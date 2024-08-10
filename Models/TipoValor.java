import java.math.BigDecimal;
import java.math.RoundingMode;

public class TipoValor {
    private BigDecimal valor;

    // Construtor
    public TipoValor(double valor) {
        this.valor = BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP);
    }

    // Construtor
    public TipoValor(BigDecimal valor) {
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
    }

    // Getter
    public BigDecimal getValor() {
        return valor;
    }

    // Setter
    public void setValor(BigDecimal valor) {
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
    }

    // Adiciona um valor ao valor atual
    public void adicionar(TipoValor valorAdicional) {
        this.valor = this.valor.add(valorAdicional.getValor());
    }

    // Subtrai um valor do valor atual
    public void subtrair(TipoValor valorSubtraido) {
        this.valor = this.valor.subtract(valorSubtraido.getValor());
    }

    // Multiplica o valor atual por um fator
    public void multiplicar(double fator) {
        this.valor = this.valor.multiply(BigDecimal.valueOf(fator));
    }

    // Divide o valor atual por um divisor
    public void dividir(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor não pode ser zero.");
        }
        this.valor = this.valor.divide(BigDecimal.valueOf(divisor), RoundingMode.HALF_UP);
    }

    // Formata o valor para exibição
    public String formatar() {
        return String.format("$%.2f", valor);
    }

    @Override
    public String toString() {
        return formatar();
    }
}
