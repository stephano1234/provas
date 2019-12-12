package br.com.contmatic.modelo.conta;

import static br.com.contmatic.utilidades.ConstantesString.NUMERO_CONTA;

import static br.com.contmatic.utilidades.MensagensErro.NUMERO_CONTA_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Conta {

    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NUMERO_CONTA, message = NUMERO_CONTA_INVALIDO)
    private String numero;
    
    @NotNull(message = VALOR_NULO)
    @Valid
    private Agencia agencia;
    
    @NotNull(message = VALOR_NULO)
    private TipoConta tipoConta;

    public Conta(String numero, Agencia agencia, TipoConta tipoConta) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(numero)
                .append(agencia)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Conta)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Conta outroConta = (Conta) objeto;
        return new EqualsBuilder()
                .append(numero, outroConta.numero)
                .append(agencia, outroConta.agencia)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("numero", numero)
                .append("agencia", agencia)
                .append("tipoConta", tipoConta)
                .toString();
    }
    
}
