package br.com.contmatic.modelo.pessoa;

import javax.validation.constraints.*;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Celular {

    @NotNull(message = MensagensErro.VALOR_NULO)   
    @Size(max = ConstantesNumericas.DDD, message = MensagensErro.STRING_MAX)
    @Size(min = ConstantesNumericas.DDD, message = MensagensErro.STRING_MIN)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.APENAS_NUMERAL, message = MensagensErro.STRING_INVALIDO)
    private String ddd;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Size(max = ConstantesNumericas.NUMERO_CELULAR, message = MensagensErro.STRING_MAX)
    @Size(min = ConstantesNumericas.NUMERO_CELULAR, message = MensagensErro.STRING_MIN)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.APENAS_NUMERAL, message = MensagensErro.STRING_INVALIDO)
    private String numero;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("ddd", ddd)
                .append("numero", numero)
                .append("tipoContatoCelular", tipoContatoCelular)
                .toString();
    }
    
}
