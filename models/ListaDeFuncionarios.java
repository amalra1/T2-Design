package models;

import java.util.ArrayList;
import java.util.List;

public class ListaDeFuncionarios {

    // Atributo para armazenar a lista de funcionários
    private List<Funcionario> funcionarios;

    // Construtor da classe ListaDeFuncionarios
    public ListaDeFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    // Método para adicionar um funcionário à lista
    public void adicionarFuncionario(Funcionario funcionario) {
        // Gera um novo ID se o ID já estiver em uso
        while (getFuncionarioPorID(funcionario.getID()) != null) {
            funcionario.gerarID();
        }
        funcionarios.add(funcionario);
    }

    // Método para remover um funcionário da lista
    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    // Método para obter a lista de funcionários
    public List<Funcionario> getListaDeFuncionarios() {
        // Retorna uma cópia da lista para evitar modificações externas
        return new ArrayList<>(funcionarios);
    }

    // Método para obter um funcionário pelo ID
    public Funcionario getFuncionarioPorID(String id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getID().equals(id)) {
                return funcionario;
            }
        }
        return null; // Retorna null se o funcionário com o ID especificado não for encontrado
    }

    // Método para obter um funcionário pelo nome
    public Funcionario getFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null; // Retorna null se o funcionário com o nome especificado não for encontrado
    }

    // Método para enviar o cartão de ponto
    public void enviaCartao(TipoData dataAtual) {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.isCartaoEnviado()) {
                funcionario.enviarCartao(dataAtual);
            }
        }
    }

    // Método para autenticar o login de um funcionário
    public Funcionario login(String nome, String senha) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.login(nome, senha)) {
                return funcionario;
            }
        }
        return null; // Retorna null se o login falhar
    }
}
