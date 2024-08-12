package controllers;

import models.Empresa;
import models.Funcionario;
import models.TipoPg;
import views.PagamentoView;

public class ControladorPagamento {
    private Empresa empresa;
    private PagamentoView pagamentoView;

    public ControladorPagamento(Empresa empresa, PagamentoView pagamentoView) {
        this.empresa = empresa;
        this.pagamentoView = pagamentoView;
    }

    // Método para iniciar o processo de alteração de tipo de pagamento
    public void alterarTipoPagamento() {
        // Buscar o funcionário pelo nome
        String nomeFuncionario = pagamentoView.requisitarNomeFuncionario();
        TipoPg novoTipoPagamento = pagamentoView.selecionarTipoPagamento();
        Funcionario funcionario = empresa.getListaDeFuncionarios().getFuncionarioPorNome(nomeFuncionario);
        /* comparar com o id do usuario atual pra ver se ele nao ta tentando mexer com outro user */
        // Verifica se o funcionário foi encontrado
        if (funcionario != null) {
            // Altera o tipo de pagamento do funcionário
            funcionario.setTipoPagto(novoTipoPagamento);
            System.out.println("Tipo de pagamento alterado para: " + novoTipoPagamento.getDescricao());
        } else {
            System.out.println("Funcionário com o nome " + nomeFuncionario + " não encontrado.");
        }
    }
}