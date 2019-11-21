package br.com.contmatic.modelo.pessoa;

import javax.validation.constraints.*;

import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.validacoes.NaoVazio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Email {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.EMAIL, message = MensagensErro.STRING_CARACTERE_ESPECIAL)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("endereco", endereco)
                .toString();
    }
    
}
