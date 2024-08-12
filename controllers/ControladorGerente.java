package controllers;

import java.util.Map;
import java.util.Scanner;

import models.Empresa;
import models.Funcionario;
import views.FuncionarioView;
import views.GerenteView;

public class ControladorGerente {
    
    private Empresa empresa;
    private GerenteView gerenteView;

    public ControladorGerente(Empresa empresa, GerenteView gerenteView) {
        this.empresa = empresa;
        this.gerenteView = gerenteView;
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
            String opcao = gerenteView.exibirMenu();

            switch (opcao) {
                case "1": // Criar Relatório administrativo
                    limpaTela();
                    System.out.println("Calma lá paizao.");
                    break;

                case "2": // Manter informações dos Funcionários
                    limpaTela();
                    boolean l = true;

                    FuncionarioView fv = new FuncionarioView();
                    ControladorFuncionario cf = new ControladorFuncionario(empresa, fv);
                    while (l){
                        String o = gerenteView.exibirMenuManterFuncionario();
                        switch (o) {
                            case "1": // add funcionario
                                cf.adicionarFuncionario();
                                break;
                            case "2": // up funcionario
                                cf.atualizarFuncionario();
                                break;
                            case "3": // del funcionario
                                cf.excluirFuncionario();
                                break;
                            case "4": // list funcionario
                                cf.listarFuncionarios();
                                break;
                            case "5": // Sair
                                System.out.println("Saindo...");
                                l = false;
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }
                            
                    }
                    break;
                case "3": // Sair
                    System.out.println("Deslogando...");
                    return 4;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
