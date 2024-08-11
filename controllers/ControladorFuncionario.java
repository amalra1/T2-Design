package controllers;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import models.Funcionario;
import models.ListaDeFuncionarios;
import models.TipoDadosFuncionario;
import models.TipoData;
import models.TipoPg;
import views.FuncionarioView;
import views.Home;

public class ControladorFuncionario {
    private ListaDeFuncionarios lFuncionarios;
    private FuncionarioView view;

    public ControladorFuncionario() {
        this.lFuncionarios = new ListaDeFuncionarios();
        this.view = new FuncionarioView();
    }

    public void iniciar() {
        Home h = new Home();
        boolean running = true;
        while (running) {
            view.exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    h.clearScreen();
                    adicionarFuncionario();
                    break;
                case 2:
                    h.clearScreen();
                    atualizarFuncionario();
                    break;
                case 3:
                    h.clearScreen();
                    listarFuncionarios();
                    break;
                case 4:
                    h.clearScreen();
                    enviarCartaoPonto();
                    break;
                case 5:
                    running = false;
                    view.exibirMensagem("Saindo do sistema. Até logo!");
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
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

    private void adicionarFuncionario() {
        // Lógica para adicionar um novo funcionário
        Map<String, Object> r = view.adicionarFuncionario();
        TipoDadosFuncionario dados = new TipoDadosFuncionario( (String) r.get("nome"), (String) r.get("cpf"), (String) r.get("endereco"), (String) r.get("telefone"), (String) r.get("email"));
        TipoPg tp;
        switch ((int) r.get("tipoPg")) {
            case 1:
                tp = TipoPg.CHEQUE;
                break;
            case 2:
                tp = TipoPg.DEPOSITO_DIRETO;
                break;
            case 3:
                tp = TipoPg.RETIRADA_ESCRITORIO;
                break;
            default:
                view.exibirMensagem("Tipo de Pagamento invalido!");
                return;
        }

        Funcionario funcionario = new Funcionario((String) r.get("nome"), (String) r.get("senha"), dados, tp);
        lFuncionarios.adicionarFuncionario(funcionario);
        view.exibirMensagem("Funcionário adicionado com sucesso!");
    }

    private void atualizarFuncionario() {
        // Lógica para atualizar dados de um funcionário
        String id = (String) view.getId("Escreva o ID do usuario que deseja alterar: ").get("id");
        Funcionario f = lFuncionarios.getFuncionarioPorID(id);
        if (f != null) {
            Map<String, Object> r = view.atualizarFuncionario(f.getDados());
            TipoDadosFuncionario novosDados = new TipoDadosFuncionario( (String) r.get("nome"), (String) r.get("cpf"), (String) r.get("endereco"), (String) r.get("telefone"), (String) r.get("email"));

            f.atribuirDados(novosDados);
            view.exibirMensagem("Funcionário atualizado com sucesso!");
        } else {
            view.exibirMensagem("Funcionário não encontrado.");
        }
    }

    private void listarFuncionarios() {
        view.exibirListaFuncionarios(lFuncionarios);
    }

    private void enviarCartaoPonto() {
        // Lógica para enviar cartão de ponto
        String id = (String) view.getId("Escreva o ID do usuario para enviar cartão ponto: ").get("id");
        TipoData dataAtual = new TipoData(LocalDate.now());
        Funcionario f = lFuncionarios.getFuncionarioPorID(id);
        if (f != null) {
            f.enviarCartao(dataAtual);
            view.exibirMensagem("Cartão de ponto enviado com sucesso!");
        } else {
            view.exibirMensagem("Funcionário não encontrado.");

        }
    }
}
