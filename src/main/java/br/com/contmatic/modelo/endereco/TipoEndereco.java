package br.com.contmatic.modelo.endereco;

public enum TipoEndereco {
    
    RESIDENCIAL("Endereço residencial"),
    
    COMERCIAL("Endereço comercial");
    
    private String descricao;
    
    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
