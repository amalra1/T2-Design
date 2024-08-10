package models;

public class Ponto {

    // Atributos da classe Ponto
    private TipoData inicio;
    private TipoData fim;

    // Construtor da classe Ponto
    public Ponto(TipoData inicio, TipoData fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    // Método para obter a data de início
    public TipoData getInicio() {
        return inicio;
    }

    // Método para definir a data de início
    public void setInicio(TipoData inicio) {
        this.inicio = inicio;
    }

    // Método para obter a data de fim
    public TipoData getFim() {
        return fim;
    }

    // Método para definir a data de fim
    public void setFim(TipoData fim) {
        this.fim = fim;
    }
}
