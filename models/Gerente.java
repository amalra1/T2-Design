package models;

public class Gerente {
    private String nome;
    private String departamento;
    private FolhaDePagamento folhaDePagamento;
    private String senha;

    // Construtor
    public Gerente(String nome, String senha, String departamento, FolhaDePagamento folhaDePagamento) {
        this.nome = nome;
        this.departamento = departamento;
        this.folhaDePagamento = folhaDePagamento;
        this.senha = senha;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public boolean login(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
    
}
