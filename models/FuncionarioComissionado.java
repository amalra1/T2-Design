package models;

public class FuncionarioComissionado extends Funcionario {
    private double salarioBase;
    private double taxaComissao;
    private double vendas;

    public FuncionarioComissionado(String nome, String senha, TipoDadosFuncionario dados, TipoPg tipoPagto, double salarioBase, double taxaComissao, double vendas) {
        super(nome, senha, dados, tipoPagto);
        this.salarioBase = salarioBase;
        this.taxaComissao = taxaComissao;
        this.vendas = vendas;
    }

    @Override
    public double calcularPagamento() {
        return salarioBase + (vendas * taxaComissao);
    }

    // Método específico para comissionados
    public void registrarVenda(double valorVenda) {
        vendas += valorVenda;
    }

    // Getters e Setters
    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
}
