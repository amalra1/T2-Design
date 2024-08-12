package views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Funcionario;
import models.ListaDeFuncionarios;
import models.TipoDadosFuncionario;
import models.TipoPg;

public class FuncionarioView {
    private Scanner scanner;

    public FuncionarioView() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void exibirMenu() {
        System.out.println("");
        System.out.println("Menu de Funcionários");
        // System.out.println("1. Adicionar Funcionário");
        // System.out.println("2. Atualizar Funcionário");
        // System.out.println("3. Listar Funcionários");
        System.out.println("1. Enviar Cartão de Ponto");
        System.out.println("2. Alterar método de pagamento");
        System.out.println("3. Sair");
        System.out.print("Opção: ");
    }

    public Map<String, Object> adicionarFuncionario() {
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adicionar Funcionario");

        System.out.print("Nome: ");
        retorno.put("nome", scanner.nextLine());
        System.out.print("Senha: ");
        retorno.put("senha", scanner.nextLine());
        System.out.print("CPF: ");
        retorno.put("cpf", scanner.nextLine());
        System.out.print("Endereço: ");
        retorno.put("endereco", scanner.nextLine());
        System.out.print("Telefone: ");
        retorno.put("telefone", scanner.nextLine());
        System.out.print("Email: ");
        retorno.put("email", scanner.nextLine());
        System.out.print("Deducao Padrao: ");
        retorno.put("deducaoPadrao", scanner.nextDouble());
        System.out.print("Outras Deducoes: ");
        retorno.put("outrasDeducoes", scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Tipo de Funcionario (1: Horista, 2: Assalariado, 3: Comissionado): ");
        int tipoFuncionario = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após o número

        // Coletar informacoes adicionais com base no tipo de funcionario
        switch (tipoFuncionario) {
            case 1: // Horista
                System.out.print("Taxa Horaria: ");
                retorno.put("taxaHoraria", scanner.nextDouble());
                scanner.nextLine(); // Consumir a nova linha após o número
                retorno.put("tipo", "horista");
                break;
            case 2: // Assalariado
                System.out.print("Salario: ");
                retorno.put("salario", scanner.nextDouble());
                scanner.nextLine(); // Consumir a nova linha após o número
                retorno.put("tipo", "assalariado");
                break;
            case 3: // Comissionado
                System.out.print("Salario: ");
                retorno.put("salario", scanner.nextDouble());
                scanner.nextLine(); // Consumir a nova linha após o número
                System.out.print("Taxa de Comissao: ");
                retorno.put("taxaComissao", scanner.nextDouble());
                scanner.nextLine(); // Consumir a nova linha após o número
                retorno.put("tipo", "comissionado");
                break;
            default:
                System.out.println("Tipo de funcionario invalido.");
                break;
        }

        return retorno;
    }

    public String getId(String mensagem){
        String retorno;
        Scanner scanner = new Scanner(System.in);

        System.out.print(mensagem);
        retorno = scanner.nextLine();

        return retorno;
    }

    public Map<String, Object> atualizarFuncionario(Funcionario f){
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Adicionar Funcionario");

        System.out.println("Nome atual: " + f.getNome());
        System.out.print("Nome: ");
        retorno.put("nome", scanner.nextLine());
        System.out.println("Senha atual: " + f.getSenha());
        System.out.print("Senha: ");
        retorno.put("senha", scanner.nextLine());
        System.out.println("CPF atual: " + f.getDados().getCpf());
        System.out.print("CPF: ");
        retorno.put("cpf", scanner.nextLine());
        System.out.println("Endereço atual: " + f.getDados().getEndereco());
        System.out.print("Endereço: ");
        retorno.put("endereco", scanner.nextLine());
        System.out.println("Telefone atual: " + f.getDados().getTelefone());
        System.out.print("Telefone: ");
        retorno.put("telefone", scanner.nextLine());
        System.out.println("Email atual: " + f.getDados().getEmail());
        System.out.print("Email: ");
        retorno.put("email", scanner.nextLine());
        System.out.println("Deducao Padrao atual: " + f.getDados().getDeducaoPadrao());
        System.out.print("Deducao Padrao: ");
        retorno.put("deducaoPadrao", scanner.nextDouble());
        System.out.println("Outras Deducoes atual: " + f.getDados().getOutrasDeducoes());
        System.out.print("Outras Deducoes: ");
        retorno.put("outrasDeducoes", scanner.nextDouble());
        scanner.nextLine(); 

        return retorno;
    }

    public void exibirListaFuncionarios(ListaDeFuncionarios funcionarios) {
        System.out.println("Lista de Funcionários:");
        List<Funcionario> fs = funcionarios.getListaDeFuncionarios();
        for (Funcionario f : fs) {
            System.out.println("ID: " + f.getID() + ", Nome: " + f.getNome() + ", Pagamento: " + f.getTipoPagto());
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Requisita o nome do funcionário
    public String requisitarNomeFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        return scanner.nextLine();
    }

    // Exibe as opções de tipo de pagamento e requisita uma seleção do usuário
    public TipoPg selecionarTipoPagamento() {
        System.out.println("Selecione o novo tipo de pagamento:");
        for (int i = 0; i < TipoPg.values().length; i++) {
            System.out.println((i + 1) + ". " + TipoPg.values()[i].getDescricao());
        }
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        if (opcao > 0 && opcao <= TipoPg.values().length) {
            return TipoPg.values()[opcao - 1];
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return selecionarTipoPagamento();
        }
    }

    public int informaEndereco(Funcionario f) {
        System.out.println("Seu endereco atual é " + f.getEndereco() + "?");
        System.out.println("1. Sim");
        System.out.println("2. Não");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (opcao == 1) {
            return 1;
        } else if (opcao == 2) {
            return 2;
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return informaEndereco(f);
        }
    }

    // Método para solicitar os dados bancários do funcionário
    public String solicitaConta() {
        System.out.print("Digite o numero da conta para depósito: ");
        return scanner.nextLine();
    }

    public String solicitaAgencia() {
        System.out.print("Digite o numero da agencia para depósito: ");
        return scanner.nextLine();
    }
}