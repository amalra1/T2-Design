import controllers.ControladorGerente;
import controllers.ControladorLogin;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import models.Empresa;
import models.Gerente;
import views.FuncionarioView;
import views.GerenteView;
import views.LoginView;
import controllers.ControladorFuncionario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = null;

        // Tentar desserializar a empresa
        try (FileInputStream fileIn = new FileInputStream(".empresa.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            empresa = (Empresa) in.readObject();
            System.out.println("Dados da empresa foram desserializados de empresa.ser");
        } catch (Exception e) {
            // Se a desserialização falhar, inicialize a empresa normalmente
            empresa = new Empresa("Empresa", null, new Gerente("admin", "admin", "Departamento", null));
            System.out.println("Nova empresa foi criada.");
        }

        // Exemplo de inserção de dados fictícios (pode ser removido se não for necessário)
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
        teste.put("agenciaBancaria", "teste");
        teste.put("numContaBancaria", "teste");

        empresa.insereDadosFuncionario(teste);

        boolean continuar = true;
        int acao = 0;
        boolean logado = false;

        // Inicialize a view e o controller
        LoginView loginView = new LoginView();
        ControladorLogin loginController = new ControladorLogin(empresa, loginView);

        while (continuar) {
            if (!logado)
                acao = loginController.iniciar();

            switch (acao) {
                case 1: // Ações de gerente
                    logado = true;
                    GerenteView gv = new GerenteView();
                    ControladorGerente cg = new ControladorGerente(empresa, gv);
                    if (cg.iniciar() == 4)
                        logado = false;
                    break;
                case 2: // Ações de funcionário
                    logado = true;
                    FuncionarioView fv = new FuncionarioView();
                    ControladorFuncionario cf = new ControladorFuncionario(empresa, fv);
                    if (cf.iniciar() == 4)
                        logado = false;
                    break;
                case 3: // Encerra
                    continuar = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }

        // Serializar a empresa ao encerrar o programa
        try (FileOutputStream fileOut = new FileOutputStream(".empresa.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(empresa);
            System.out.println("Dados da empresa foram serializados para empresa.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
