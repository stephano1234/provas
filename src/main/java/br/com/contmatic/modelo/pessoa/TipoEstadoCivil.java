package br.com.contmatic.modelo.pessoa;

public enum TipoEstadoCivil {

    SOLTEIRO("Solteiro(a)"),
    
    CASADO("Casado(a)"),
    
    DIVORCIADO("Divorciado(a)"),
    
    VIUVO("Viuvo(a)"),
    
    OUTROS("Outros");
    
    private String descricao;
    
    private TipoEstadoCivil(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
