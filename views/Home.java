package views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Home {
    
    public Map<String, Object> home() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Principal");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Gerenciar Funcionários");
        System.out.println("2. Gerenciar Projetos");
        System.out.println("3. Cartão Ponto");
        System.out.println("4. Folha de Pagamento");
        System.out.println("5. Relatórios");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        
        int option = -1;
        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
        } else {
            System.out.println("Entrada inválida, por favor digite um número.");
            scanner.nextLine(); // Consome a entrada inválida
        }

        Map<String, Object> retorno = new HashMap<>();
        retorno.put("numero", option);
        retorno.put("texto", "asd");

        return retorno;
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Map<String, Object> login() {
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String nome, senha;

        System.out.print("Nome: ");
        nome = scanner.nextLine();
        retorno.put("nome", nome);
        
        System.out.print("Senha: ");
        senha = scanner.nextLine();
        retorno.put("senha", senha);

        return retorno;
    }
}
