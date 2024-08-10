package views;

import models.Funcionario;
import java.util.List;

public class FuncionarioView {
    public void exibirMenu() {
        System.out.println("Menu de Funcionários");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Atualizar Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Enviar Cartão de Ponto");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
    }

    public void exibirListaFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
