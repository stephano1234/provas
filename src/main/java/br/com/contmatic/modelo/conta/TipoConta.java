package br.com.contmatic.modelo.conta;

public enum TipoConta {

    CONTA_CORRENTE("Conta corrente"),
    
    CONTA_POUPANCA("Conta poupança");
    
    private String descricao;
    
    private TipoConta(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
