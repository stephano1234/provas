package br.com.contmatic.modelo.pessoa;

public enum TipoGrauInstrucao {

    ANALFABETO("Analfabeto"),
    
    ATE_5_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL("Até o 5º ano incompleto do Ensino Fundamental"),
    
    O_5_ANO_COMPLETO_ENSINO_FUNDAMENTAL("5º ano completo do Ensino Fundamental"),
    
    DO_6_AO_9_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO("Do 6º ao 9º ano do Ensino Fundamental incompleto"),
    
    ENSINO_FUNDAMENTAL_COMPLETO("Ensino Fundamental completo"),
    
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio incompleto"),
    
    ENSINO_MEDIO_COMPLETO("Ensino Médio completo"),
    
    SUPERIOR_INCOMPLETO("Superior incompleto"),
    
    SUPERIOR_COMPLETO("Superior completo"),
    
    POS_GRADUACAO_ESPECIALIZACAO("Pós-Graduação / Especialização"),
    
    MESTRADO("Mestrado"),
    
    DOUTORADO("Doutorado"),
    
    POS_DOUTORADO("Pós-Doutorado");
    
    private String descricao;
    
    private TipoGrauInstrucao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
