import Views.Home;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean running = true;

        System.out.println("Bem-vindo ao Sistema");
        Home h = new Home();
        while (running) {
            Map<String, Object> retorno = h.view();
            int opcao = (int) retorno.get("numero");

            switch (opcao) {
                case 1: //funcionarios
                    h.clearScreen();
                    break;
                case 2: //Projetos
                    h.clearScreen();
                    break;
                case 3: //cartao ponto
                    h.clearScreen();
                    break;
                case 4: //Folha de Pagamento
                    h.clearScreen();
                    break;
                case 5: //Relatorios
                    h.clearScreen();
                    break;
                case 6:
                    running = false;
                    h.exibirMensagem("Saindo do sistema. Até logo!");
                    break;
                default:
                    h.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
