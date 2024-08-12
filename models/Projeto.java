package models;

import java.io.Serializable;

public class Projeto implements Serializable {

    // Atributo da classe Projeto
    private String nome;

    // Construtor da classe Projeto
    public Projeto(String nome) {
        this.nome = nome;
    }

    // Método para obter o nome do projeto
    public String getNome() {
        return nome;
    }

    // Método para definir o nome do projeto
    public void setNome(String nome) {
        this.nome = nome;
    }
}
