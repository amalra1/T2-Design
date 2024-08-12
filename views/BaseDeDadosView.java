package views;

public class BaseDeDadosView {
    public void exibirMenu() {
        System.out.println("Menu de Base De Dados");
        System.out.println("1. Adicionar um Projeto");
        System.out.println("2. Remover um Projeto");
        System.out.println("3. Sair");
        System.out.print("Opção: ");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
