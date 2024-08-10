package models;

public class Gerente {
    private String nome;
    private String departamento;
    private FolhaDePagamento folhaDePagamento;

    // Construtor
    public Gerente(String nome, String departamento, FolhaDePagamento folhaDePagamento) {
        this.nome = nome;
        this.departamento = departamento;
        this.folhaDePagamento = folhaDePagamento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public FolhaDePagamento getFolhaDePagamento() {
        return folhaDePagamento;
    }

    public void setFolhaDePagamento(FolhaDePagamento folhaDePagamento) {
        this.folhaDePagamento = folhaDePagamento;
    }

    // Método para rodar a folha de pagamento
    public void rodarFolhaDePagamento() {
        if (folhaDePagamento != null) {
            folhaDePagamento.processarPagamentos();
        }
    }

    public Gerente getGerente() {
        return this;
    }
}
