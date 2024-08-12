package models;

public class FuncionarioHorista extends Funcionario {
    private double taxaHoraria;
    private int horasTrabalhadas;

    public FuncionarioHorista(String nome, String senha, TipoDadosFuncionario dados, TipoPg tipoPagto, double taxaHoraria, int horasTrabalhadas) {
        super(nome, senha, dados, tipoPagto);
        this.taxaHoraria = taxaHoraria;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularPagamento() {
        return taxaHoraria * horasTrabalhadas;
    }

    // Getters e Setters
    public double getTaxaHoraria() {
        return taxaHoraria;
    }

    public void setTaxaHoraria(double taxaHoraria) {
        this.taxaHoraria = taxaHoraria;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
