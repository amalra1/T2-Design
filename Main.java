import controllers.ControladorFuncionario;
import java.util.Map;
import java.util.Scanner;
import models.Funcionario;
import models.Empresa;
import models.Gerente;
import models.ListaDeFuncionarios;
import models.TipoDadosFuncionario;
import models.TipoPg;
import views.Home;
import views.LoginView;
import controllers.ControladorLogin;

public class Main {
    public static void main(String[] args) {
        TipoDadosFuncionario df = new TipoDadosFuncionario("teste", "asd", "asd", "asd", "asd");

        Scanner scanner = new Scanner(System.in);

        Empresa empresa = new Empresa("Empresa", null,
                new Gerente("admin", "admin", "Departamento", null));

        empresa.insereDadosFuncionario(df, "teste", TipoPg.CHEQUE);
        boolean running = true;

        // Inicialize a view e o controller
        LoginView loginView = new LoginView();
        ControladorLogin loginController = new ControladorLogin(empresa, loginView);

        boolean continuar = true;
        int acao = 0;
        while (continuar) {
            acao = loginController.iniciar();

            switch ((int)acao) {
                case 1: //acoes de gerente
                    break;
                case 2: // acoes de funcionario
                    break;
                case 3: // encerra
                    continuar = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
