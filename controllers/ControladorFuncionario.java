package controllers;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import models.Empresa;
import models.Funcionario;
import models.ListaDeFuncionarios;
import models.TipoData;
import models.TipoHoras;
import models.TipoPg;
import views.FuncionarioView;
import views.Home;

public class ControladorFuncionario {
    private Empresa empresa;
    private ListaDeFuncionarios lFuncionarios;
    private FuncionarioView view;

    public ControladorFuncionario(Empresa empresa, FuncionarioView funcionarioView) {
        this.empresa = empresa;
        this.lFuncionarios = empresa.getListaDeFuncionarios();
        this.view = funcionarioView;
    }

    public int iniciar() {
        Home h = new Home();
        boolean running = true;
        while (running) {
            view.exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    enviarCartaoPonto();
                    break;
                case 2:
                    alterarTipoPagamento();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
        return 4;
    }

    private int lerOpcao() {
        Scanner scanner = new Scanner(System.in);

        int option = -1;
        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
        } else {
            System.out.println("Entrada inválida, por favor digite um número.");
            scanner.nextLine(); // Consome a entrada inválida
        }
        return option;
    }

    public void adicionarFuncionario() {
        // Lógica para adicionar um novo funcionário
        Map<String, Object> r = view.adicionarFuncionario();
        String id = empresa.insereDadosFuncionario(r);

        lFuncionarios = empresa.getListaDeFuncionarios();
        view.exibirMensagem("Funcionário adicionado com sucesso! ID: " + id);
    }

    public void atualizarFuncionario() {
        // Lógica para atualizar dados de um funcionário
        String id = view.getId("Digite o ID do funcinario: ");
        Funcionario f = lFuncionarios.getFuncionarioPorID(id);
        Map<String, Object> r = view.atualizarFuncionario(f);
        empresa.atualizaDadosFuncionario(id, r);

        lFuncionarios = empresa.getListaDeFuncionarios();
        view.exibirMensagem("Funcionário utualizado com sucesso!");
    }

    public void excluirFuncionario() {
        String id = view.getId("Escreva o ID do usuario que deseja excluir: ");
        Funcionario f = lFuncionarios.getFuncionarioPorID(id);
        if (f != null) {
            lFuncionarios.removerFuncionario(f);
            view.exibirMensagem("Funcionário exlcuido com sucesso!");
        } else {
            view.exibirMensagem("Funcionário não encontrado.");
        }
    }

    public void listarFuncionarios() {
        view.exibirListaFuncionarios(lFuncionarios);
    }

    private void enviarCartaoPonto() {
        // Lógica para enviar cartão de ponto
        String nomeFuncionario = view.requisitarNomeFuncionario();
        Funcionario funcionario = empresa.getListaDeFuncionarios().getFuncionarioPorNome(nomeFuncionario);
        
        TipoData dataAtual = new TipoData(LocalDate.now());

        if (funcionario != null) {
            if (!funcionario.isCartaoEnviado()) {
                String horasTrabalhadas = view.solicitarHorasTrabalhadas(dataAtual);
                if (verificarFormatoHorario(horasTrabalhadas)) {
                    int horas = Integer.parseInt(horasTrabalhadas.substring(0, 2));
                    int minutos = Integer.parseInt(horasTrabalhadas.substring(3, 5));
                    TipoHoras horaMinutoTrabalhado = new TipoHoras(horas, minutos);
    
                    funcionario.enviarCartao(dataAtual, horaMinutoTrabalhado);
                    view.exibirMensagem("Cartão de ponto enviado com sucesso!");
                } else {
                    view.exibirMensagem("Formato de hora incorreto!");
                }
            } else {
                view.exibirMensagem("Cartão Ponto já enviado!");
            }
        } else {
            view.exibirMensagem("Funcionário não encontrado.");
        }
    }

    public static boolean verificarFormatoHorario(String horario) {
        // Verifica o padrão de formato HH:MM usando regex
        if (!horario.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        // Extrai horas e minutos
        int horas = Integer.parseInt(horario.substring(0, 2));
        int minutos = Integer.parseInt(horario.substring(3, 5));

        // Verifica se horas estão entre 00 e 23 e minutos entre 00 e 59
        if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59) {
            return false;
        }

        return true;
    }

    public void alterarTipoPagamento() {
        // Buscar o funcionário pelo nome
        String nomeFuncionario = view.requisitarNomeFuncionario();
        Funcionario funcionario = empresa.getListaDeFuncionarios().getFuncionarioPorNome(nomeFuncionario);

        // Verifica se o funcionário foi encontrado
        if (funcionario != null) {
            // Exibe o método de recebimento atual
            System.out.println("Seu método de recebimento atual é: " + funcionario.getTipoPagto());
            TipoPg novoTipoPagamento = view.selecionarTipoPagamento();

            if (novoTipoPagamento == TipoPg.CHEQUE) {
                // Pede confirmação do endereço ou atualização
                int retorno = view.informaEndereco(funcionario);
                if (retorno == 1) { // Endereço ainda é o mesmo
                    System.out.println("Cheque será enviado para o endereço já cadastrado.");
                } else if (retorno == 2) { // Novo endereço
                    System.out.print("Digite o endereço para envio do cheque: ");
                    String endereco = view.getScanner().nextLine();
                    funcionario.setEndereco(endereco);
                    System.out.println("Cheque será enviado para o novo endereço.");
                }
                funcionario.setTipoPagto(novoTipoPagamento);

            } else if (novoTipoPagamento == TipoPg.DEPOSITO_DIRETO) {
                // Solicita os dados bancários do funcionário
                String contaBancaria = view.solicitaConta();
                String agencia = view.solicitaAgencia();
                funcionario.setTipoPagto(novoTipoPagamento);
                funcionario.setContaBancaria(contaBancaria);
                funcionario.setAgenciaBancaria(agencia);
                System.out.println("Tipo de pagamento alterado para: " + novoTipoPagamento.getDescricao());

            } else if (novoTipoPagamento == TipoPg.RETIRADA_ESCRITORIO) {
                System.out.println("Favor passar no RH para retirar o cheque.");
                funcionario.setTipoPagto(novoTipoPagamento);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                alterarTipoPagamento();
            }
        } else {
            System.out.println("Funcionário com o nome " + nomeFuncionario + " não encontrado.");
        }
    }
}
