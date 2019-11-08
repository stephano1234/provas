package br.com.contmatic.modelo.endereco;

import javax.validation.Valid;
import javax.validation.constraints.*;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.validacoes.NaoApenasEspaco;
import br.com.contmatic.utilidades.validacoes.NaoVazio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Endereco {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.CEP, message = MensagensErro.STRING_MAX)
    @Size(min = ConstantesNumericas.CEP, message = MensagensErro.STRING_MIN)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.APENAS_NUMERAL, message = MensagensErro.STRING_INVALIDO)
    private String cep;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.MAX_NUMERO_ENDERECO, message = MensagensErro.STRING_MAX)
    
    private String numero;
    
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.CAMPO_REGULAR, message = MensagensErro.STRING_MAX)
    @NaoApenasEspaco(message = MensagensErro.STRING_APENAS_ESPACO)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL, message = MensagensErro.STRING_INVALIDO)
    private String complemento;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Logradouro logradouro;
    
    @Valid
    private TelefoneFixo telefoneFixo;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    private TipoEndereco tipoEndereco;
    
    public Endereco(String cep, String numero, Logradouro logradouro, TipoEndereco tipoEndereco) {
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.tipoEndereco = tipoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public TelefoneFixo getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(TelefoneFixo telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(cep)
                .append(numero)
                .append(logradouro)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Endereco)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Endereco outroEndereco = (Endereco) objeto;
        return new EqualsBuilder()
                .append(cep, outroEndereco.cep)
                .append(numero, outroEndereco.numero)
                .append(logradouro, outroEndereco.logradouro)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cep", cep)
                .append("numero", numero)
                .append("complemento", complemento)
                .append("logradouro", logradouro)
                .append("telefoneFixo", telefoneFixo)
                .append("tipoEndereco", tipoEndereco)
                .toString();
    }
    
}
