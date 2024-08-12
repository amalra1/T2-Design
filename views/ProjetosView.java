package views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProjetosView {
    public Map<String, Object> adicionarProjeto() {
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Adicionar Projeto");

        System.out.print("Nome: ");
        retorno.put("nome", scanner.nextLine());

        return retorno;
    }

    public Map<String, Object> removerProjeto() {
        Map<String, Object> retorno = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Adicionar Projeto");

        System.out.print("Nome: ");
        retorno.put("nome", scanner.nextLine());

        return retorno;
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
