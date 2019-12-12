package br.com.contmatic.modelo.conta;

import static br.com.contmatic.utilidades.ConstantesString.CODIGO_BANCO;
import static br.com.contmatic.utilidades.ConstantesString.NUMERO_AGENCIA;

import static br.com.contmatic.utilidades.MensagensErro.DDD_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.NUMERO_AGENCIA_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Agencia {
    
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NUMERO_AGENCIA, message = NUMERO_AGENCIA_INVALIDO)
    private String numero;
    
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = CODIGO_BANCO, message = DDD_INVALIDO)
    private String codigoBanco;

    public Agencia(String numero, String codigoBanco) {
        this.numero = numero;     
        this.codigoBanco = codigoBanco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	@Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(numero)
                .append(codigoBanco)
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
                .append(codigoBanco, outroAgencia.codigoBanco)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("numero", numero)              
                .append("codigoBanco", codigoBanco)
                .toString();
    }
    
}
