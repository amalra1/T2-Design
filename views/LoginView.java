package views;

import java.util.Scanner;

public class LoginView {

    private Scanner scanner;

    public LoginView() {
        this.scanner = new Scanner(System.in);
    }

    public String requisitarNome() {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    public String requisitarSenha() {
        System.out.print("Senha: ");
        return scanner.nextLine();
    }

    public String exibirMenu() {
        System.out.println("Selecione a opção de login:");
        System.out.println("1. Login como Gerente");
        System.out.println("2. Login como Funcionário");
        System.out.println("3. Sair");
        return scanner.nextLine();
    }
}
