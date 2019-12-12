package br.com.contmatic.modelo.empresa;

import static br.com.contmatic.utilidades.ConstantesString.RAZAO_SOCIAL;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.RAZAO_SOCIAL_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.joda.time.LocalDate;

import br.com.contmatic.anotacoes.CNPJbr;
import br.com.contmatic.anotacoes.CollectionComElementoNaoNulo;

import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.contato.Celular;
import br.com.contmatic.modelo.contato.Email;
import br.com.contmatic.modelo.contato.TelefoneFixo;
import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.pessoa.ContratoTrabalho;
import br.com.contmatic.modelo.pessoa.Pessoa;

public class Empresa {

	@NotNull(message = VALOR_NULO)
	@CNPJbr
	private String cnpj;

	@NotNull(message = VALOR_NULO)
	@Pattern(regexp = RAZAO_SOCIAL, message = RAZAO_SOCIAL_INVALIDO)
	private String razaoSocial;

	@NotNull(message = VALOR_NULO)
	@Past(message = DATA_PASSADO)
	private LocalDate dataAbertura;

	@NotNull(message = VALOR_NULO)
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Pessoa> responsaveis;

	@CollectionComElementoNaoNulo
	@Valid
	private Set<ContratoTrabalho> contratosTrabalho;

	@NotNull(message = VALOR_NULO)
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Endereco> enderecos;

	@CollectionComElementoNaoNulo
	@Valid
	private Set<TelefoneFixo> telefonesFixo;

	@CollectionComElementoNaoNulo
	@Valid
	private Set<Email> emails;

	@CollectionComElementoNaoNulo
	@Valid
	private Set<Celular> celulares;

	@CollectionComElementoNaoNulo
	@Valid
	private Set<Conta> contas;

	@NotNull(message = VALOR_NULO)
	private TipoEmpresa tipoEmpresa;

	@NotNull(message = VALOR_NULO)
	private TipoPorteEmpresa tipoPorteEmpresa;

	public Empresa(String cnpj, String razaoSocial, LocalDate dataAbertura, Set<Pessoa> responsaveis,
			Set<Endereco> enderecos, TipoEmpresa tipoEmpresa, TipoPorteEmpresa tipoPorteEmpresa) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.dataAbertura = dataAbertura;
		this.responsaveis = responsaveis;
		this.enderecos = enderecos;
		this.tipoEmpresa = tipoEmpresa;
		this.tipoPorteEmpresa = tipoPorteEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Set<Pessoa> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(Set<Pessoa> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public Set<ContratoTrabalho> getContratosTrabalho() {
		return contratosTrabalho;
	}

	public void setContratosTrabalho(Set<ContratoTrabalho> contratosTrabalho) {
		this.contratosTrabalho = contratosTrabalho;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<TelefoneFixo> getTelefonesFixo() {
		return telefonesFixo;
	}

	public void setTelefonesFixo(Set<TelefoneFixo> telefonesFixo) {
		this.telefonesFixo = telefonesFixo;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Set<Celular> getCelulares() {
		return celulares;
	}

	public void setCelulares(Set<Celular> celulares) {
		this.celulares = celulares;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public TipoPorteEmpresa getTipoPorteEmpresa() {
		return tipoPorteEmpresa;
	}

	public void setTipoPorteEmpresa(TipoPorteEmpresa tipoPorteEmpresa) {
		this.tipoPorteEmpresa = tipoPorteEmpresa;
	}

	@Override
	public final int hashCode() {
		return new HashCodeBuilder()
				.append(cnpj)
				.toHashCode();
	}

	@Override
	public final boolean equals(Object objeto) {
		if (!(objeto instanceof Empresa)) {
			return false;
		}
		if (this == objeto) {
			return true;
		}
		final Empresa outroEmpresa = (Empresa) objeto;
		return new EqualsBuilder()
				.append(cnpj, outroEmpresa.cnpj)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, JSON_STYLE)
				.append("cnpj", cnpj)
				.append("razaoSocial", razaoSocial)
				.append("dataAbertura", dataAbertura)
				.append("responsaveis", responsaveis)
				.append("contratosTrabalho", contratosTrabalho)	
				.append("enderecos", enderecos)		
				.append("telefonesFixo", (telefonesFixo != null) ? telefonesFixo : "Sem telefone fixo")
				.append("emails", (emails != null) ? emails : "Sem e-mail")
				.append("celulares", (celulares != null) ? celulares : "Sem celular")
				.append("contas", (contas != null) ? contas : "Sem conta bancária")
				.append("tipoEmpresa", tipoEmpresa)
				.append("tipoPorteEmpresa", tipoPorteEmpresa)
				.toString();
	}
	
}
