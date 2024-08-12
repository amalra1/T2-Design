package views;

import models.TipoPg;

import java.util.Scanner;

public class PagamentoView {
    private Scanner scanner;

    public PagamentoView() {
        this.scanner = new Scanner(System.in);
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
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        if (opcao > 0 && opcao <= TipoPg.values().length) {
            return TipoPg.values()[opcao - 1];
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return selecionarTipoPagamento();
        }
    }
}
