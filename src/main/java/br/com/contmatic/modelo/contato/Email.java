package br.com.contmatic.modelo.contato;

import static br.com.contmatic.utilidades.ConstantesString.EMAIL;

import static br.com.contmatic.utilidades.MensagensErro.EMAIL_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Email {

    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = EMAIL, message = EMAIL_INVALIDO)
    private String endereco;
    
    public Email(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(endereco)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Email)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Email outroEmail = (Email) objeto;
        return new EqualsBuilder()
                .append(endereco, outroEmail.endereco)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("endereco", endereco)
                .toString();
    }
    
}
