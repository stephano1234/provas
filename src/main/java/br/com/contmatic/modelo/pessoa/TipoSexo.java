package br.com.contmatic.modelo.pessoa;

public enum TipoSexo {

    MASCULINO("Masculino"),
    
    FEMININO("Feminino");
    
    private String descricao;
    
    private TipoSexo(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
