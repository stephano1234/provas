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

public class Conta {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.MAX_NUMERO_CONTA, message = MensagensErro.STRING_MAX)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_ESPACO, message = MensagensErro.STRING_COM_ESPACO)
    private String numero;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Agencia agencia;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("numero", numero)
                .append("agencia", agencia)
                .append("tipoConta", tipoConta)
                .toString();
    }
    
}
