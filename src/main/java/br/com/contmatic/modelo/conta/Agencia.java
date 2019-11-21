package br.com.contmatic.modelo.conta;

import javax.validation.Valid;
import javax.validation.constraints.*;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.validacoes.NaoVazio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Agencia {
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.MAX_NUMERO_AGENCIA, message = MensagensErro.STRING_MAX)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_ESPACO, message = MensagensErro.STRING_CARACTERE_ESPECIAL)
    private String numero;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Banco banco;

    public Agencia(String numero, Banco banco) {
        this.numero = numero;     
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(numero)
                .append(banco)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Agencia)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Agencia outroAgencia = (Agencia) objeto;
        return new EqualsBuilder()
                .append(numero, outroAgencia.numero)
                .append(banco, outroAgencia.banco)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("numero", numero)              
                .append("banco", banco)
                .toString();
    }
    
}
