package views;

import java.util.Scanner;

public class GerenteView {

    private Scanner scanner;

    public GerenteView() {
        this.scanner = new Scanner(System.in);
    }

    public String exibirMenu() {
        System.out.println("Selecione a opção de gerente:");
        System.out.println("1. Criar Relatório administrativo");
        System.out.println("2. Manter informações dos Funcionários");
        System.out.println("3. Sair");
        return scanner.nextLine();
    }

    public String exibirMenuManterFuncionario() {
        System.out.println("Selecione a opção de manter Funcionário:");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Atualizar Funcionário");
        System.out.println("3. Excluir Funcionário");
        System.out.println("4. Listar Funcionários");
        System.out.println("5. Sair");
        return scanner.nextLine();
    }
}
