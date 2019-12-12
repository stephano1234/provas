package br.com.contmatic.modelo.pessoa;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.joda.time.LocalDate;

public class ContratoTrabalho {

    @NotNull(message = VALOR_NULO)
    @Valid
    private Pessoa pessoa;
      
    @NotNull(message = VALOR_NULO)
    private TipoContratoTrabalho tipoContratoTrabalho;

    @NotNull(message = VALOR_NULO)
    @Past(message = DATA_PASSADO)
    private LocalDate dataInicioContrato;
    
    public ContratoTrabalho(Pessoa pessoa, TipoContratoTrabalho tipoContratoTrabalho, LocalDate dataInicioContrato) {
        this.pessoa = pessoa;
        this.tipoContratoTrabalho = tipoContratoTrabalho;
        this.dataInicioContrato = dataInicioContrato;
    }
   
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoContratoTrabalho getTipoContratoTrabalho() {
		return tipoContratoTrabalho;
	}

	public void setTipoContratoTrabalho(TipoContratoTrabalho tipoContratoTrabalho) {
		this.tipoContratoTrabalho = tipoContratoTrabalho;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	@Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(pessoa)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof ContratoTrabalho)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final ContratoTrabalho outroContratoTrabalho = (ContratoTrabalho) objeto;
        return new EqualsBuilder()
                .append(pessoa, outroContratoTrabalho.pessoa)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("pessoa", pessoa)
                .append("tipoContratoTrabalho", tipoContratoTrabalho)
                .append("dataInicioContrato", dataInicioContrato)
                .toString();
    }
    
}
