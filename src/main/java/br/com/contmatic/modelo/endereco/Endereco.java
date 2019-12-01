package br.com.contmatic.modelo.endereco;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.*;

import br.com.contmatic.anotacoes.NaoApenas;
import br.com.contmatic.anotacoes.NaoVazio;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesString;
import br.com.contmatic.utilidades.MensagensErro;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Endereco {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @Size(max = ConstantesNumericas.CEP, message = MensagensErro.STRING_MAX)
    @Size(min = ConstantesNumericas.CEP, message = MensagensErro.STRING_MIN)
    @Pattern(regexp = ConstantesString.APENAS_NUMERAL, message = MensagensErro.STRING_NAO_NUMERAL)
    private String cep;
    
    @NaoVazio
    @Size(max = ConstantesNumericas.MAX_NUMERO_ENDERECO, message = MensagensErro.STRING_MAX)
    @Pattern(regexp = ConstantesString.APENAS_NUMERAL, message = MensagensErro.STRING_NAO_NUMERAL)
    private String numero;
    
    @NaoVazio
    @Size(max = ConstantesNumericas.CAMPO_REGULAR, message = MensagensErro.STRING_MAX)
    @NaoApenas
    @Pattern(regexp = ConstantesString.SEM_CARACTERE_ESPECIAL, message = MensagensErro.STRING_CARACTERE_ESPECIAL)
    private String complemento;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Logradouro logradouro;
    
    @Valid
    private Set<TelefoneFixo> telefonesFixo;
    
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

    public Set<TelefoneFixo> getTelefonesFixo() {
        return telefonesFixo;
    }

    public void setTelefonesFixo(Set<TelefoneFixo> telefonesFixo) {
        this.telefonesFixo = telefonesFixo;
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
                .append("numero", (numero != null) ? numero : "Sem número")
                .append("complemento", (complemento != null) ? complemento : "Sem informações adicionais do endereço")
                .append("logradouro", logradouro)
                .append("telefonesFixo", (telefonesFixo != null) ? telefonesFixo : "Sem telefone fixo atrelado a este endereço")
                .append("tipoEndereco", tipoEndereco)
                .toString();
    }
    
}
