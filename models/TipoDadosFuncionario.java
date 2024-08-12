package models;

import java.io.Serializable;

public class TipoDadosFuncionario implements Serializable {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private double deducaoPadrao;
    private double outrasDeducoes;
    private String numContaBancaria;
    private String agenciaBancaria;

    // Construtor
    public TipoDadosFuncionario(String nome, String cpf, String endereco, String telefone, String email, double deducaoPadrao, double outrasDeducoes, String numContaBancaria, String agenciaBancaria) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.deducaoPadrao = deducaoPadrao;
        this.outrasDeducoes = outrasDeducoes;
        this.agenciaBancaria = agenciaBancaria;
        this.numContaBancaria = numContaBancaria;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDeducaoPadrao() {
        return deducaoPadrao;
    }

    public void setDeducaoPadrao(double deducaoPadrao) {
        this.deducaoPadrao = deducaoPadrao;
    }

    public double getOutrasDeducoes() {
        return outrasDeducoes;
    }

    public void setOutrasDeducoes(double outrasDeducoes) {
        this.outrasDeducoes = outrasDeducoes;
    }

    public String getNumContaBancaria() {
        return numContaBancaria;
    }

    public void setNumContaBancaria(String numContaBancaria) {
        this.numContaBancaria = numContaBancaria;
    }

    public String getAgenciaBancaria() {
        return agenciaBancaria;
    }

    public void setAgenciaBancaria(String agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Telefone: " + telefone + ", Email: "
                + email;
    }
}
