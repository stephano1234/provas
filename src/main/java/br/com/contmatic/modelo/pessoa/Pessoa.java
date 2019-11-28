package br.com.contmatic.modelo.pessoa;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.LocalDate;

import br.com.contmatic.anotacoes.CPFbr;
import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;

public class Pessoa {

	@NotNull(message = MensagensErro.VALOR_NULO)
	@CPFbr
	private String cpf;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.NOME_PESSOA, message = MensagensErro.STRING_APENAS_LETRA_ESPACO)
    private String nome;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Set<Endereco> enderecos;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Past(message = MensagensErro.DATA_PASSADO)
    private LocalDate dataNascimento;
    
    @Valid
    private Set<Celular> celulares;
    
    @Valid
    private Set<Email> emails;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    private TipoGrauInstrucao tipoGrauInstrucao;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    private TipoEstadoCivil tipoEstadoCivil;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    private TipoSexo tipoSexo;
    
    public Pessoa(String cpf, String nome, Set<Endereco> enderecos, LocalDate dataNascimento, TipoGrauInstrucao tipoGrauInstrucao, TipoEstadoCivil tipoEstadoCivil, TipoSexo tipoSexo) {
    	this.cpf = cpf;
    	this.nome = nome;
    	this.enderecos = enderecos;
    	this.dataNascimento = dataNascimento;
    	this.tipoGrauInstrucao = tipoGrauInstrucao;
    	this.tipoEstadoCivil = tipoEstadoCivil;
    	this.tipoSexo = tipoSexo;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Celular> getCelulares() {
		return celulares;
	}

	public void setCelulares(Set<Celular> celulares) {
		this.celulares = celulares;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public TipoGrauInstrucao getTipoGrauInstrucao() {
		return tipoGrauInstrucao;
	}

	public void setTipoGrauInstrucao(TipoGrauInstrucao tipoGrauInstrucao) {
		this.tipoGrauInstrucao = tipoGrauInstrucao;
	}

	public TipoEstadoCivil getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}

	public void setTipoEstadoCivil(TipoEstadoCivil tipoEstadoCivil) {
		this.tipoEstadoCivil = tipoEstadoCivil;
	}

	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(cpf)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Pessoa)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Pessoa outroPessoa = (Pessoa) objeto;
        return new EqualsBuilder()
                .append(cpf, outroPessoa.cpf)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cpf", cpf)
                .append("nome", nome)
                .append("enderecos", enderecos)
                .append("dataNascimento", dataNascimento)
                .append("celulares", (celulares != null) ? celulares : "Sem celular")
                .append("emails", (emails != null) ? emails : "Sem e-mail")
                .append("tipoGrauInstrucao", tipoGrauInstrucao)
                .append("tipoEstadoCivil", tipoEstadoCivil)
                .append("tipoSexo", tipoSexo)
                .toString();
    }
    
}
