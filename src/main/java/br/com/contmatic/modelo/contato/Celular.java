package br.com.contmatic.modelo.contato;

import static br.com.contmatic.utilidades.ConstantesString.CELULAR;
import static br.com.contmatic.utilidades.ConstantesString.DDD;

import static br.com.contmatic.utilidades.MensagensErro.STRING_CELULAR_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.STRING_DDD_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Celular {

    @NotNull(message = VALOR_NULO)   
    @Pattern(regexp = DDD, message = STRING_DDD_INVALIDO)
    private String ddd;
    
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = CELULAR, message = STRING_CELULAR_INVALIDO)
    private String numero;
    
    @NotNull(message = VALOR_NULO)
    private TipoContatoCelular tipoContatoCelular;
    
    public Celular(String ddd, String numero, TipoContatoCelular tipoContatoCelular) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipoContatoCelular = tipoContatoCelular;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoContatoCelular getTipoContatoCelular() {
        return tipoContatoCelular;
    }

    public void setTipoContatoCelular(TipoContatoCelular tipoContatoCelular) {
        this.tipoContatoCelular = tipoContatoCelular;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(ddd)
                .append(numero)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Celular)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Celular outroCelular = (Celular) objeto;
        return new EqualsBuilder()
                .append(ddd, outroCelular.ddd)
                .append(numero, outroCelular.numero)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("ddd", ddd)
                .append("numero", numero)
                .append("tipoContatoCelular", tipoContatoCelular)
                .toString();
    }
    
}
