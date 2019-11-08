package br.com.contmatic.modelo.endereco;

import javax.validation.constraints.*;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.validacoes.NaoVazio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TelefoneFixo {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.DDD, message = MensagensErro.STRING_MAX)
    @Size(min = ConstantesNumericas.DDD, message = MensagensErro.STRING_MIN)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.APENAS_NUMERAL, message = MensagensErro.STRING_INVALIDO)
    private String ddd;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.NUMERO_TELEFONE, message = MensagensErro.STRING_MAX)
    @Size(min = ConstantesNumericas.NUMERO_TELEFONE, message = MensagensErro.STRING_MIN)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.APENAS_NUMERAL, message = MensagensErro.STRING_INVALIDO)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("ddd", ddd)
                .append("numero", numero)
                .toString();
    }
    
}