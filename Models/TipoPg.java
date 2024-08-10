public enum TipoPg {
    CHEQUE,           // Pagamento por cheque enviado ao endereço do funcionário
    DEPOSITO_DIRETO,  // Pagamento por depósito direto na conta bancária do funcionário
    RETIRADA_ESCRITORIO; // Pagamento retirado pessoalmente no escritório

    // Você pode adicionar métodos adicionais se necessário
    public String getDescricao() {
        switch (this) {
            case CHEQUE:
                return "Cheque enviado ao endereço do funcionário";
            case DEPOSITO_DIRETO:
                return "Depósito direto na conta bancária do funcionário";
            case RETIRADA_ESCRITORIO:
                return "Retirada do pagamento no escritório";
            default:
                return "Tipo de pagamento desconhecido";
        }
    }
}
