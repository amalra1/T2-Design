// Importação de classes necessárias
import java.util.List;

public class FolhaDePagamento {

    // Atributo que armazena a lista de pagamentos
    private List<Pagamento> pagamentos;

    // Construtor da classe FolhaDePagamento
    public FolhaDePagamento(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    // Método para adicionar um pagamento à folha de pagamento
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    // Método para remover um pagamento da folha de pagamento
    public void removerPagamento(Pagamento pagamento) {
        pagamentos.remove(pagamento);
    }

    // Método para obter todos os pagamentos
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    // Método para calcular e processar todos os pagamentos
    public void processarPagamentos() {
        for (Pagamento pagamento : pagamentos) {
            pagamento.processar();
        }
    }

    // Outros métodos relevantes para a folha de pagamento podem ser adicionados aqui
}
