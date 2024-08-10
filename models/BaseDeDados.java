package models;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {
    private List<Projeto> projetos;

    // Construtor
    public BaseDeDados() {
        this.projetos = new ArrayList<>();
    }

    // Adiciona um projeto à lista
    public void adicionarProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    // Remove um projeto da lista
    public void removerProjeto(Projeto projeto) {
        this.projetos.remove(projeto);
    }

    // Obtém a lista de projetos
    public List<Projeto> getProjetos() {
        return projetos;
    }

    // Define a lista de projetos
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
