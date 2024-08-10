package models;


public class Empresa {
    private String nome;
    private BaseDeDados baseDeDados;
    private Gerente gerente;
    private ListaDeFuncionarios listaDeFuncionarios;

    // Construtor
    public Empresa(String nome, BaseDeDados baseDeDados, Gerente gerente) {
        this.nome = nome;
        this.baseDeDados = baseDeDados;
        this.gerente = gerente;
        this.listaDeFuncionarios = new ListaDeFuncionarios();
    }

    // Método para inserir dados de um novo funcionário
    public void insereDadosFuncionario(TipoDadosFuncionario dadosFuncionario, TipoPg tPg) {
        Funcionario novoFuncionario = new Funcionario(dadosFuncionario.getNome(), dadosFuncionario, tPg);
        listaDeFuncionarios.adicionarFuncionario(novoFuncionario);
    }

    // Método para atualizar dados de um funcionário existente
    public void atualizaDadosFuncionario(TipoDadosFuncionario novosDados, String ID) {
        Funcionario f = listaDeFuncionarios.getFuncionarioPorID(ID);
        f.atualizaDados(novosDados);
    }

    // Método para marcar um funcionário para exclusão
    public void marcaFuncionarioExclusao(String ID) {
        Funcionario f = listaDeFuncionarios.getFuncionarioPorID(ID);
        f.setParaExclusao(true);
    }

    // Método para enviar cartão de ponto
    public void enviaCartao(TipoData dataAtual) {
        listaDeFuncionarios.enviaCartao(dataAtual);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BaseDeDados getBaseDeDados() {
        return baseDeDados;
    }

    public void setBaseDeDados(BaseDeDados baseDeDados) {
        this.baseDeDados = baseDeDados;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public ListaDeFuncionarios getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }
}
