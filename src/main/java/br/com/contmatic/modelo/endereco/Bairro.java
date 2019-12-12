package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.ConstantesString.NOME;

import static br.com.contmatic.utilidades.MensagensErro.NOME_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Bairro {

    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NOME, message = NOME_INVALIDO)
    private String nome;
    
    @NotNull(message = VALOR_NULO)
    @Valid
    private Cidade cidade;
    
    public Bairro(String nome, Cidade cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(cidade)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Bairro)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Bairro outroBairro = (Bairro) objeto;
        return new EqualsBuilder()
                .append(nome, outroBairro.nome)
                .append(cidade, outroBairro.cidade)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("nome", nome)
                .append("cidade", cidade)
                .toString();
    }
    
}
