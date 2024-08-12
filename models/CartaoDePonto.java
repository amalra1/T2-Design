package models;
import java.io.Serializable;

public class CartaoDePonto implements Serializable {

    // Atributos da classe CartaoDePonto
    private TipoHoras horas;
    private String status;
    private TipoData dataEnvio;

    // Método para atribuir horas ao cartão de ponto
    public void atribuirHoras(TipoHoras horas) {
        this.horas = horas;
    }

    // Método para atribuir data de envio
    public void atribuiData(TipoData dataAtual) {
        this.dataEnvio = dataAtual;
    }

    // Método para confirmar envio do cartão de ponto
    public void confirmaEnvio() {
        this.status = "enviado";
        this.dataEnvio = TipoData.obterDataAtual(); // Exemplo de obtenção da data atual
    }

    // Método para salvar o cartão de ponto
    public void salvaCartao() {
        // Implementação do processo de salvar o cartão
        System.out.println("Cartão de ponto salvo com sucesso.");
    }

    // Método para obter o cartão de ponto atual
    public CartaoDePonto getCartaoPonto() {
        return this;
    }

    // Getters e Setters (se necessário)

    public TipoHoras getHoras() {
        return horas;
    }

    public void setHoras(TipoHoras horas) {
        this.horas = horas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoData getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(TipoData dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}

// As classes TipoHoras e TipoData são placeholders para seus tipos específicos, certifique-se de defini-las conforme a sua necessidade.
