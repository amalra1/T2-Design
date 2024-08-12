package models;
import java.io.Serializable;


public abstract class Funcionario implements Serializable {

    // Atributos da classe Funcionario
    private String nome;
    private String senha;
    private TipoDadosFuncionario dados;
    private TipoPg tipoPagto;
    private TipoID id;    
    private CartaoDePonto cartaoPonto; // Supondo que um funcionário tenha um cartão de ponto associado

    
    // Construtor da classe Funcionario
    public Funcionario(String nome, String senha, TipoDadosFuncionario dados, TipoPg tipoPagto) {
        this.nome = nome;
        this.senha = senha;
        this.dados = dados;
        this.tipoPagto = tipoPagto;
        this.gerarID();
    }

    // Métodos comuns a todos os funcionários
    public abstract double calcularPagamento();

    // Método para gerar um ID para o funcionário
    public void gerarID() {
        id = TipoID.gerarNovoID();
    }

    // Método para obter um funcionário pelo ID
    public Funcionario getFuncionario(String ID) {
        // Implementação para buscar e retornar um funcionário pelo ID
        return null;
    }

    // Método para atribuir dados ao funcionário
    public void atribuirDados(TipoDadosFuncionario dadosFuncionario) {
        this.dados = dadosFuncionario;
    }

    // Método para criar um cartão de ponto
    public CartaoDePonto criaCartaoPonto() {
        return new CartaoDePonto();
    }

    // Método para definir informações adicionais sobre o pagamento
    public void setTipoPagtoInformacoesAdicionais(TipoPg tPg) {
        this.tipoPagto = tPg;
    }

    public TipoPg getTipoPagtoInformacoesAdicionais() {
        return this.tipoPagto;
    }

    // Método para registrar um ponto
    public void registrarPonto() {
        // Implementação para registrar o ponto
    }

    // Outros métodos e atributos podem ser adicionados conforme necessário

    // Getters e Setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDadosFuncionario getDados() {
        return dados;
    }

    public void setDados(TipoDadosFuncionario dados) {
        this.dados = dados;
    }

    public TipoPg getTipoPagto() {
        return tipoPagto;
    }

    public void setTipoPagto(TipoPg tipoPagto) {
        this.tipoPagto = tipoPagto;
    }

    // Método para obter o ID do funcionário
    public String getID() {
        return id.getID();
    }

    // Método para atualizar os dados do funcionário
    public void atualizaDados(TipoDadosFuncionario novosDados) {
        if (novosDados != null) {
            this.dados = novosDados;
        }
    }

    public boolean isCartaoEnviado() {
        return cartaoPonto != null && "enviado".equals(cartaoPonto.getStatus());
    }

    public void enviarCartao(TipoData dataAtual) {
        if (cartaoPonto != null) {
            cartaoPonto.atribuiData(dataAtual); // Define a data de envio
            cartaoPonto.confirmaEnvio();        // Marca o cartão de ponto como enviado
            cartaoPonto.salvaCartao();          // Salva o cartão de ponto no sistema
        }
    }

    public boolean login(String n, String s){
        if (n.equals(this.nome) && s.equals(this.senha)){
            return true;
        }
        return false;
    }

    public String getEndereco() {
        return dados.getEndereco();
    }
    
    public void setEndereco(String endereco) {
        dados.setEndereco(endereco);
    }
    
    public String getContaBancaria() {
        return dados.getNumContaBancaria();
    }

    public void setContaBancaria(String contaBancaria) {
        dados.setNumContaBancaria(contaBancaria);
    }

    public String getAgenciaBancaria(){
        return dados.getAgenciaBancaria();
    }

    public void setAgenciaBancaria(String agenciaBancaria){
        dados.setAgenciaBancaria(agenciaBancaria);
    }
}

