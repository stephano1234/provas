package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.ConstantesNumericas.TAMANHO_REGULAR;

import static br.com.contmatic.utilidades.ConstantesString.CEP;
import static br.com.contmatic.utilidades.ConstantesString.NOT_BLANK;
import static br.com.contmatic.utilidades.ConstantesString.NUMERO_ENDERECO;

import static br.com.contmatic.utilidades.MensagensErro.CEP_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.NOT_BLANK_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.NUMERO_ENDERECO_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.TAMANHO_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.contmatic.anotacoes.CollectionComElementoNaoNulo;

import br.com.contmatic.modelo.contato.TelefoneFixo;

public class Endereco {

    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = CEP, message = CEP_INVALIDO)
    private String cep;
    
    @Pattern(regexp = NUMERO_ENDERECO, message = NUMERO_ENDERECO_INVALIDO)
    private String numero;
    
    @Size(min = 1, max = TAMANHO_REGULAR, message = TAMANHO_INVALIDO)
    @Pattern(regexp = NOT_BLANK, message = NOT_BLANK_INVALIDO)
    private String complemento;
    
    @NotNull(message = VALOR_NULO)
    @Valid
    private Logradouro logradouro;
    
	@CollectionComElementoNaoNulo
    @Valid
    private Set<TelefoneFixo> telefonesFixo;
    
    @NotNull(message = VALOR_NULO)
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
        return new ToStringBuilder(this, JSON_STYLE)
                .append("cep", cep)
                .append("numero", (numero != null) ? numero : "Sem número")
                .append("complemento", (complemento != null) ? complemento : "Sem informações adicionais do endereço")
                .append("logradouro", logradouro)
                .append("telefonesFixo", (telefonesFixo != null) ? telefonesFixo : "Sem telefone fixo atrelado a este endereço")
                .append("tipoEndereco", tipoEndereco)
                .toString();
    }
    
}
