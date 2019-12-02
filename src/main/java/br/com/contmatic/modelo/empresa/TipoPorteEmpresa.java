package br.com.contmatic.modelo.empresa;

public enum TipoPorteEmpresa {
	
	ME("Microempresa"),
	
	EPP("Empresa de pequeno porte"),
	
	MEDIO("Empresa de médio porte"),
	
	GRANDE("Empresa de grande porte");
	
	private String descricao;
	
	private TipoPorteEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
