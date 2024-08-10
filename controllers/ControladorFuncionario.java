package controllers;

import models.Funcionario;
import models.TipoDadosFuncionario;
import models.TipoData;
import views.FuncionarioView;

import java.util.ArrayList;
import java.util.List;

public class ControladorFuncionario {
    private List<Funcionario> listaDeFuncionarios;
    private FuncionarioView view;

    public ControladorFuncionario() {
        this.listaDeFuncionarios = new ArrayList<>();
        this.view = new FuncionarioView();
    }

    public void iniciar() {
        boolean running = true;
        while (running) {
            view.exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    atualizarFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    enviarCartaoPonto();
                    break;
                case 5:
                    running = false;
                    view.exibirMensagem("Saindo do sistema. Até logo!");
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    private int lerOpcao() {
        // Lógica para ler opção do usuário (pode usar Scanner)
        return 0;
    }

    private void adicionarFuncionario() {
        // Lógica para adicionar um novo funcionário
        String nome = "Novo Funcionario"; // Exemplo, use Scanner para ler do usuário
        TipoDadosFuncionario dados = new TipoDadosFuncionario(nome);
        Funcionario funcionario = new Funcionario(nome, dados);
        listaDeFuncionarios.add(funcionario);
        view.exibirMensagem("Funcionário adicionado com sucesso!");
    }

    private void atualizarFuncionario() {
        // Lógica para atualizar dados de um funcionário
        String id = "ID"; // Exemplo, use Scanner para ler do usuário
        for (Funcionario funcionario : listaDeFuncionarios) {
            if (funcionario.getId().equals(id)) {
                // Atualizar dados
                TipoDadosFuncionario novosDados = new TipoDadosFuncionario("Nome Atualizado");
                funcionario.atribuirDados(novosDados);
                view.exibirMensagem("Funcionário atualizado com sucesso!");
                return;
            }
        }
        view.exibirMensagem("Funcionário não encontrado.");
    }

    private void listarFuncionarios() {
        view.exibirListaFuncionarios(listaDeFuncionarios);
    }

    private void enviarCartaoPonto() {
        // Lógica para enviar cartão de ponto
        String id = "ID"; // Exemplo, use Scanner para ler do usuário
        TipoData dataAtual = new TipoData();
        for (Funcionario funcionario : listaDeFuncionarios) {
            if (funcionario.getId().equals(id)) {
                funcionario.enviarCartao(dataAtual);
                view.exibirMensagem("Cartão de ponto enviado com sucesso!");
                return;
            }
        }
        view.exibirMensagem("Funcionário não encontrado.");
    }
}
