package controllers;

import java.util.Map;
import java.util.Scanner;

import models.BaseDeDados;
import models.Projeto;
import views.BaseDeDadosView;
import views.ProjetosView;

public class ControladorProjetos {
    private BaseDeDadosView baseDeDadosView;
    private ProjetosView view;
    private BaseDeDados baseDeDadosModel;

    public ControladorProjetos() {
        this.baseDeDadosView = new BaseDeDadosView();
        this.baseDeDadosModel = new BaseDeDados();
        this.view = new ProjetosView();
    }

    public void iniciar() {
        boolean running = true;
        while (running) {
            // TODO exibir todos os projetos?
            baseDeDadosView.exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarProjeto();
                    break;
                case 2:
                    removerProjeto();
                    break;
                case 3:
                    running = false;
                    baseDeDadosView.exibirMensagem("Saindo do sistema. Até logo!");
                    break;
                default:
                    baseDeDadosView.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarProjeto() {
        Map<String, Object> p = view.adicionarProjeto();

        
        Projeto projeto = new Projeto((String) p.get("nome"));

        baseDeDadosModel.adicionarProjeto(projeto);
        view.exibirMensagem("Projeto adicionado com sucesso!");
    }

    private void removerProjeto() {
        view.exibirMensagem("Criar lógica pra remover projeto!");
        view.removerProjeto();
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
}
