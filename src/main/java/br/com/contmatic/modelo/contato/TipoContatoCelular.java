package br.com.contmatic.modelo.contato;

public enum TipoContatoCelular {

    APENAS_LIGACAO("Recebe apenas ligações"),
    
    APENAS_MENSAGEM_TEXTO("Recebe apenas mensagens de texto"),
    
    APENAS_MENSAGEM_INTERNET("Recebe apenas mensagens de internet"),
    
    LIGACAO_MENSAGEM_TEXTO("Recebe apenas ligações e mensagens de texto"),
    
    LIGACAO_MENSAGEM_INTERNET("Recebe apenas ligações e mensagens de internet"),
    
    MENSAGEM_TEXTO_INTERNET("Recebe apenas mensagens de texto e de internet"),
    
    LIGACAO_MENSAGEM_TEXTO_INTERNET("Recebe ligações, mensagens de texto e de internet");
    
    private String descricao;
    
    private TipoContatoCelular(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
