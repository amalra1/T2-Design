package models;

public class Venda {

    // Atributo da classe Venda
    private TipoValor valor;

    // Construtor da classe Venda
    public Venda(TipoValor valor) {
        this.valor = valor;
    }

    // Método para obter o valor da venda
    public TipoValor getValor() {
        return valor;
    }

    // Método para definir o valor da venda
    public void setValor(TipoValor valor) {
        this.valor = valor;
    }
}
