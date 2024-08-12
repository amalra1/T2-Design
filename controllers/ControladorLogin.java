package controllers;

import models.Empresa;
import models.Funcionario;
import views.LoginView;

public class ControladorLogin {

    private Empresa empresa;
    private LoginView loginView;

    public ControladorLogin(Empresa empresa, LoginView loginView) {
        this.empresa = empresa;
        this.loginView = loginView;
    }

    public void limpaTela() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/* ver como esta o fluxo do resto do programa pra saber se basta retornar um inteiro aqui e prosseguir com o resto */
    public int iniciar() {
        while (true) {
            String opcao = loginView.exibirMenu();

            switch (opcao) {
                case "1": // Login como Gerente
                    String nomeGerente = loginView.requisitarNome();
                    String senhaGerente = loginView.requisitarSenha();
                    limpaTela();
                    if (empresa.loginGerente(nomeGerente, senhaGerente)) {
                        System.out.println("Login de Gerente bem-sucedido!");
                        return 1;
                        // Ações específicas para o gerente
                    } else {
                        System.out.println("Nome ou senha incorretos.");
                    }
                    break;

                case "2": // Login como Funcionário
                    String nomeFuncionario = loginView.requisitarNome();
                    String senhaFuncionario = loginView.requisitarSenha();
                    limpaTela();
                    Funcionario funcionario = empresa.loginFuncionario(nomeFuncionario, senhaFuncionario);
                    if (funcionario != null) {
                        System.out.println("Login de Funcionário bem-sucedido!");
                        // Ações específicas para o funcionário
                        return 2;
                    } else {
                        System.out.println("Nome ou senha incorretos.");
                    }
                    break;

                case "3": // Sair
                    System.out.println("Saindo...");
                    return 3;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
