import controllers.ControladorFuncionario;
import java.util.Map;
import java.util.Scanner;
import models.Funcionario;
import models.ListaDeFuncionarios;
import models.TipoDadosFuncionario;
import models.TipoPg;
import views.Home;

public class Main {
    public static void main(String[] args) {
        TipoDadosFuncionario df = new TipoDadosFuncionario("teste", "asd", "asd", "asd", "asd");
        Funcionario f = new Funcionario("teste", "teste", df, TipoPg.CHEQUE);
        ListaDeFuncionarios lf = new ListaDeFuncionarios();

        lf.adicionarFuncionario(f);
        Scanner scanner = new Scanner(System.in);
        

        boolean running = true;
        System.out.println("Bem-vindo ao Sistema");
        Home h = new Home();
        ControladorFuncionario cFuncionario = new ControladorFuncionario();

        Map<String, Object> retorno = h.login();
        Funcionario nf = lf.login((String) retorno.get("nome"), (String) retorno.get("senha"));

        while (nf == null) { 
            h.exibirMensagem("Login Incorreto!");
            System.out.println("nome: " + (String) retorno.get("nome") + " senha: " + (String) retorno.get("senha"));

            retorno = h.login();
            nf = lf.login((String) retorno.get("nome"), (String) retorno.get("senha"));
        }

        while (running) {
            retorno = h.home();
            int opcao = (int) retorno.get("numero");

            switch (opcao) {
                case 1: //funcionarios
                    cFuncionario.iniciar();
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
