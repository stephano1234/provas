package br.com.contmatic.modelo.pessoa;

public enum TipoSocio {

    ADMINISTRADOR("Sócio administrador"),
    
    QUOTISTA("Sócio quotista");
    
    private String descricao;
    
    private TipoSocio(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
