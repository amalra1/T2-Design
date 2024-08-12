package models;

public class FuncionarioAssalariado extends Funcionario {
    private double salario;

    public FuncionarioAssalariado(String nome, String senha, TipoDadosFuncionario dados, TipoPg tipoPagto, double salario) {
        super(nome, senha, dados, tipoPagto);
        this.salario = salario;
    }

    @Override
    public double calcularPagamento() {
        return salario;
    }

    // Getters e Setters
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
