import java.time.LocalDate;

public class TipoData {
    private LocalDate data;

    public TipoData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Método para criar uma instância de TipoData com a data atual
    public static TipoData obterDataAtual() {
        return new TipoData(LocalDate.now());
    }

    @Override
    public String toString() {
        return data.toString(); // ISO format yyyy-MM-dd
    }
}
