public class Pagamento {

    // Atributos da classe Pagamento
    private String nome;
    private TipoPg tipoPagto;

    // Construtor da classe Pagamento
    public Pagamento(String nome, TipoPg tipoPagto) {
        this.nome = nome;
        this.tipoPagto = tipoPagto;
    }

    // Método para obter o nome do pagamento
    public String getNome() {
        return nome;
    }

    // Método para definir o nome do pagamento
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter o tipo de pagamento
    public TipoPg getTipoPagto() {
        return tipoPagto;
    }

    // Método para definir o tipo de pagamento
    public void setTipoPagto(TipoPg tipoPagto) {
        this.tipoPagto = tipoPagto;
    }

    // Método para processar o pagamento (implementação pode variar)
    public void processar() {
        // Implementação do processo de pagamento
        System.out.println("Processando pagamento de " + nome + " do tipo " + tipoPagto);
    }

}
