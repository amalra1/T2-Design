package models;

import java.util.Map;

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

    public String insereDadosFuncionario(Map<String, Object> dadosFuncionario) {
        String nome = (String) dadosFuncionario.get("nome");
        String senha = (String) dadosFuncionario.get("senha");
        String cpf = (String) dadosFuncionario.get("cpf");
        String endereco = (String) dadosFuncionario.get("endereco");
        String telefone = (String) dadosFuncionario.get("telefone");
        String email = (String) dadosFuncionario.get("email");
        double deducaoPadrao = ((Number) dadosFuncionario.get("deducaoPadrao")).doubleValue();
        double outrasDeducoes = ((Number) dadosFuncionario.get("outrasDeducoes")).doubleValue();
        String tipo = (String) dadosFuncionario.get("tipo");
        String agenciaBancaria = (String) dadosFuncionario.get("agenciaBancaria");
        String numContaBancaria = (String) dadosFuncionario.get("numContaBancaria");
        TipoPg tPg = TipoPg.CHEQUE;

        // Criar TipoDadosFuncionario com os dados fornecidos
        TipoDadosFuncionario tipoDadosFuncionario = new TipoDadosFuncionario(nome, cpf, endereco, telefone, email, deducaoPadrao, outrasDeducoes, numContaBancaria, agenciaBancaria);

        // Criar Funcionario baseado no tipo
        Funcionario novoFuncionario = null;

        switch (tipo) {
            case "horista":
                double taxaHoraria = ((Number) dadosFuncionario.get("taxaHoraria")).doubleValue();
                novoFuncionario = new FuncionarioHorista(nome, senha, tipoDadosFuncionario, tPg, taxaHoraria, 0);
                break;
            case "assalariado":
                double salario = ((Number) dadosFuncionario.get("salario")).doubleValue();
                novoFuncionario = new FuncionarioAssalariado(nome, senha, tipoDadosFuncionario, tPg, salario);
                break;
            case "comissionado":
                salario = ((Number) dadosFuncionario.get("salario")).doubleValue();
                double taxaComissao = ((Number) dadosFuncionario.get("taxaComissao")).doubleValue();
                novoFuncionario = new FuncionarioComissionado(nome, senha, tipoDadosFuncionario, tPg, salario, taxaComissao, 0);
                break;
            default:
                System.out.println("Tipo de funcionario invalido.");
                return null; // Sai do método caso o tipo seja inválido
        }

        listaDeFuncionarios.adicionarFuncionario(novoFuncionario);
        return novoFuncionario.getID();
    }


    // Método para atualizar dados de um funcionário existente
    public void atualizaDadosFuncionario(TipoDadosFuncionario novosDados, String ID) {
        Funcionario f = listaDeFuncionarios.getFuncionarioPorID(ID);
        f.atualizaDados(novosDados);
    }

    public String atualizaDadosFuncionario(String funcionarioID, Map<String, Object> dadosFuncionario) {
        // Procurar o funcionário pelo ID
        Funcionario funcionarioExistente = listaDeFuncionarios.getFuncionarioPorID(funcionarioID);
    
        if (funcionarioExistente == null) {
            System.out.println("Funcionario nao encontrado.");
            return null; // Retorna se o funcionário não for encontrado
        }
    
        // Atualizar dados básicos apenas se estiverem presentes no mapa
        if (dadosFuncionario.containsKey("nome") && !((String) dadosFuncionario.get("nome")).isEmpty()) {
            funcionarioExistente.setNome((String) dadosFuncionario.get("nome"));
        }
    
        if (dadosFuncionario.containsKey("senha") && !((String) dadosFuncionario.get("senha")).isEmpty()) {
            funcionarioExistente.setSenha((String) dadosFuncionario.get("senha"));
        }
    
        if (dadosFuncionario.containsKey("cpf") && !((String) dadosFuncionario.get("cpf")).isEmpty()) {
            funcionarioExistente.getDados().setCpf((String) dadosFuncionario.get("cpf"));
        }
    
        if (dadosFuncionario.containsKey("endereco") && !((String) dadosFuncionario.get("endereco")).isEmpty()) {
            funcionarioExistente.getDados().setEndereco((String) dadosFuncionario.get("endereco"));
        }
    
        if (dadosFuncionario.containsKey("telefone") && !((String) dadosFuncionario.get("telefone")).isEmpty()) {
            funcionarioExistente.getDados().setTelefone((String) dadosFuncionario.get("telefone"));
        }
    
        if (dadosFuncionario.containsKey("email") && !((String) dadosFuncionario.get("email")).isEmpty()) {
            funcionarioExistente.getDados().setEmail((String) dadosFuncionario.get("email"));
        }
    
        if (dadosFuncionario.containsKey("deducaoPadrao")) {
            funcionarioExistente.getDados().setDeducaoPadrao(
                ((Number) dadosFuncionario.get("deducaoPadrao")).doubleValue()
            );
        }
    
        if (dadosFuncionario.containsKey("outrasDeducoes")) {
            funcionarioExistente.getDados().setOutrasDeducoes(
                ((Number) dadosFuncionario.get("outrasDeducoes")).doubleValue()
            );
        }
    
        return funcionarioExistente.getID();
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

    public boolean loginGerente(String nome, String senha) {
        return gerente.login(nome, senha);
    }

    public Funcionario loginFuncionario(String nome, String senha) {
        return listaDeFuncionarios.login(nome, senha);
    }
    
}
