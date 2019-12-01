package br.com.contmatic.modelo.pessoa;

import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Socio {

    @NotNull(message = VALOR_NULO)
    @Valid
    private Pessoa pessoa;
      
    @NotNull(message = VALOR_NULO)
    private TipoSocio tipoSocio;
    
    public Socio(Pessoa pessoa, TipoSocio tipoSocio) {
        this.pessoa = pessoa;
        this.tipoSocio = tipoSocio;
    }
   
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoSocio getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(TipoSocio tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(pessoa)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Socio)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Socio outroSocio = (Socio) objeto;
        return new EqualsBuilder()
                .append(pessoa, outroSocio.pessoa)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("pessoa", pessoa)
                .append("tipoSocio", tipoSocio)
                .toString();
    }
    
}
