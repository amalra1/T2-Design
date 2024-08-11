package views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Funcionario;
import models.ListaDeFuncionarios;
import models.TipoDadosFuncionario;

public class FuncionarioView {
    public void exibirMenu() {
        System.out.println("");
        System.out.println("Menu de Funcionários");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Atualizar Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Enviar Cartão de Ponto");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
    }

    public Map<String, Object> adicionarFuncionario(){
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Adicionar Funcionario");

        System.out.print("Nome: ");
        retorno.put("nome", scanner.nextLine());
        System.out.print("CPF: ");
        retorno.put("cpf", scanner.nextLine());
        System.out.print("Endereço: ");
        retorno.put("endereco", scanner.nextLine());
        System.out.print("Telefone: ");
        retorno.put("telefone", scanner.nextLine());
        System.out.print("Email: ");
        retorno.put("email", scanner.nextLine());


        boolean running = true;
        int n = -1;
        while (running) {
            System.out.print("Tipo de pagamento (Cheque: 1, Dpesito Direto: 2, Retirada Escritorio: 3): ");

            n = -1;
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
                if (n > 3 || n < 1){
                    System.out.println("Entrada inválida, por favor digite um número valido (1, 2 ou 3).");
                } else {
                    running = false;
                }
            } else {
                System.out.println("Entrada inválida, por favor digite um número.");
                scanner.nextLine(); // Consome a entrada inválida
            }
        }

        retorno.put("tipoPg", n);

        return retorno;
    }

    public Map<String, Object> getId(String mensagem){
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print(mensagem);
        retorno.put("id", scanner.nextLine());

        return retorno;
    }

    public Map<String, Object> atualizarFuncionario(TipoDadosFuncionario f){
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        String r;

        System.out.println("Atulizar Funcionario (campos em branco não serão alterados)");
        
        System.out.println("Nome atual: " + f.getNome());
        System.out.print("Nome: ");
        r = scanner.nextLine();
        if (r.equals("")){
            retorno.put("nome", f.getNome());
        } else {
            retorno.put("nome", r);
        }

        System.out.println("CPF atual: " + f.getCpf());
        System.out.print("CPF: ");
        r = scanner.nextLine();
        if (r.equals("")){
            retorno.put("cpf", f.getCpf());
        } else {
            retorno.put("cpf", r);
        }
        
        System.out.println("Endereco atual: " + f.getEndereco());
        System.out.print("Endereço: ");
        r = scanner.nextLine();
        if (r.equals("")){
            retorno.put("endereco", f.getEndereco());
        } else {
            retorno.put("endereco", r);
        }

        System.out.println("Telefone atual: " + f.getTelefone());
        System.out.print("Telefone: ");
        r = scanner.nextLine();
        if (r.equals("")){
            retorno.put("telefone", f.getTelefone());
        } else {
            retorno.put("telefone", r);
        }

        System.out.println("Email atual: " + f.getEmail());
        System.out.print("Email: ");
        r = scanner.nextLine();
        if (r.equals("")){
            retorno.put("email", f.getEmail());
        } else {
            retorno.put("email", r);
        }

        return retorno;
    }


    public void exibirListaFuncionarios(ListaDeFuncionarios funcionarios) {
        System.out.println("Lista de Funcionários:");
        List<Funcionario> fs = funcionarios.getListaDeFuncionarios();
        for (Funcionario f : fs) {
            System.out.println("ID: " + f.getID() + ", Nome: " + f.getNome());
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}