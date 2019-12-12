package br.com.contmatic.modelo.contato;

import static br.com.contmatic.utilidades.ConstantesString.DDD;
import static br.com.contmatic.utilidades.ConstantesString.TELEFONE;

import static br.com.contmatic.utilidades.MensagensErro.DDD_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.TELEFONE_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TelefoneFixo {

    @NotNull(message = VALOR_NULO)   
    @Pattern(regexp = DDD, message = DDD_INVALIDO)
    private String ddd;
    
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = TELEFONE, message = TELEFONE_INVALIDO)
    private String numero;
    
    public TelefoneFixo(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
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
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(ddd)
                .append(numero)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof TelefoneFixo)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final TelefoneFixo outroTelefoneFixo = (TelefoneFixo) objeto;
        return new EqualsBuilder()
                .append(ddd, outroTelefoneFixo.ddd)
                .append(numero, outroTelefoneFixo.numero)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("ddd", ddd)
                .append("numero", numero)
                .toString();
    }
    
}
