package br.com.contmatic.modelo.empresa;

public enum TipoEmpresa {
	
	INDIVIDUAL("Empresário Individual"),
	
	MEI("Microempreendedor Individual"),
	
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	
	SOCIEDADE("Sociedade Emppresária"),
	
	SOCIEDADE_SIMPLES("Sociedade Simples");
	
	private String descricao;
	
	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
