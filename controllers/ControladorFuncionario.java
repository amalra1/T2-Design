package controllers;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import models.Empresa;
import models.Funcionario;
import models.ListaDeFuncionarios;
import models.TipoData;
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

    public void adicionarFuncionario() {
        // Lógica para adicionar um novo funcionário
        Map<String, Object> r = view.adicionarFuncionario();
        empresa.insereDadosFuncionario(r);

        lFuncionarios = empresa.getListaDeFuncionarios();
        view.exibirMensagem("Funcionário adicionado com sucesso!");
    }

    public void atualizarFuncionario() {
        // Lógica para atualizar dados de um funcionário

    }

    public void excluirFuncionario() {
        String id = (String) view.getId("Escreva o ID do usuario que deseja excluir: ").get("id");
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
