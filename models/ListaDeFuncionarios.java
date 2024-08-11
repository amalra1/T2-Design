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
        while(getFuncionarioPorID(funcionario.getID()) != null){
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
        return new ArrayList<>(funcionarios); // Retorna uma cópia da lista para evitar modificações externas
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

    public void enviaCartao(TipoData dataAtual) {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.isCartaoEnviado()) {
                funcionario.enviarCartao(dataAtual);
            }
        }
    }

    public Funcionario login(String nome, String senha){
        for (Funcionario f : funcionarios) {
            if (f.login(nome, senha)){
                return f;
            }
        }
        return null;
    }
}
