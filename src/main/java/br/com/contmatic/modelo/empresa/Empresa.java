package br.com.contmatic.modelo.empresa;

import java.util.Set;

import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.contato.Celular;
import br.com.contmatic.modelo.contato.Email;
import br.com.contmatic.modelo.contato.TelefoneFixo;
import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.pessoa.ContratoTrabalho;
import br.com.contmatic.modelo.pessoa.Socio;

public class Empresa {

	private String cnpj;
	
	private String razaoSocial;
	
	private Set<Socio> socios;
	
	private Set<ContratoTrabalho> contratosTrabalho;
	
	private Set<Endereco> enderecos;
	
	private Set<TelefoneFixo> telefonesFixo;
	
	private Set<Email> emails;
	
	private Set<Celular> celulares;
	
	private Set<Conta> contas;
	
	private TipoEmpresa tipoEmpresa;
	
	private TipoPorteEmpresa tipoPorteEmpresa;
	
}
