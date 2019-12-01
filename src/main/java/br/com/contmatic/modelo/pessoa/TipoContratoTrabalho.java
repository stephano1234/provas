package br.com.contmatic.modelo.pessoa;

public enum TipoContratoTrabalho {
	
	TEMPO_DETERMINADO("Contrato de trabalho por tempo determinado"),
	
	TEMPO_INDETERMINADO("Contrato de trabalho por tempo indeterminado"),
	
	TEMPORAREO("Contrato de trabalho temporáreo"),
	
	EVENTUAL("Contrato de trabalho eventual"),
	
	AUTONOMO("Contrato de trabalho autônomo"),
	
	ESTAGIO("Contrato de estágio");
	
	private String descricao;
	
	private TipoContratoTrabalho(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
