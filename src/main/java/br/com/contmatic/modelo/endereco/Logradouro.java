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

public class Logradouro {

    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NOME, message = NOME_INVALIDO)
    private String nome;
    
    @NotNull(message = VALOR_NULO)
    @Valid
    private Bairro bairro;
    
    public Logradouro(String nome, Bairro bairro) {
        this.nome = nome;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(bairro)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Logradouro)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Logradouro outroLogradouro = (Logradouro) objeto;
        return new EqualsBuilder()
                .append(nome, outroLogradouro.nome)
                .append(bairro, outroLogradouro.bairro)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("nome", nome)
                .append("bairro", bairro)
                .toString();
    }
    
}