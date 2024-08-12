import controllers.ControladorGerente;
import controllers.ControladorLogin;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import models.Empresa;
import models.Gerente;
import views.GerenteView;
import views.LoginView;
import views.PagamentoView;
import controllers.ControladorPagamento;
import controllers.ControladorLogin;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Empresa empresa = new Empresa("Empresa", null, new Gerente("admin", "admin", "Departamento", null));

        Map<String, Object> teste = new HashMap<>();

        teste.put("nome", "teste");
        teste.put("senha", "teste");
        teste.put("cpf", "teste");
        teste.put("endereco", "teste");
        teste.put("telefone", "teste");
        teste.put("email", "teste");
        teste.put("deducaoPadrao", 0);
        teste.put("outrasDeducoes", 0);
        teste.put("taxaHoraria", 1);
        teste.put("tipo", "horista");

        empresa.insereDadosFuncionario(teste);
        boolean running = true;

        empresa.insereDadosFuncionario(new TipoDadosFuncionario("Funcionario1","asd", "asd", "asd", "asd"), "senha123", TipoPg.DEPOSITO_DIRETO);

        // Inicialize a view e o controller
        LoginView loginView = new LoginView();
        ControladorLogin loginController = new ControladorLogin(empresa, loginView);

        boolean continuar = true;
        int acao = 0;
        boolean logado = false;
        while (continuar) {
            if (!logado)
                acao = loginController.iniciar();

            switch ((int)acao) {
                case 1: //acoes de gerente
                    logado = true;
                    GerenteView gv = new GerenteView();
                    ControladorGerente cg = new ControladorGerente(empresa, gv);
                    cg.iniciar();
                    break;
                case 2: // acoes de funcionario
                    logado = true;
                    System.out.println("Funcionário logado.");
                    PagamentoView pagamentoView = new PagamentoView();
                    ControladorPagamento controladorPagamento = new ControladorPagamento(empresa, pagamentoView);
                    controladorPagamento.alterarTipoPagamento();
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
