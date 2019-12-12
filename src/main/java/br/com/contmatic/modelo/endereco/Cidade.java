package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.ConstantesString.NOME;

import static br.com.contmatic.utilidades.MensagensErro.NOME_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Cidade {

    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NOME, message = NOME_INVALIDO)
    private String nome;
    
    @NotNull(message = VALOR_NULO)
    private TipoUf tipoUf;
    
    public Cidade(String nome, TipoUf tipoUf) {
        this.nome = nome;
        this.tipoUf = tipoUf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUf getTipoUf() {
        return tipoUf;
    }

    public void setTipoUf(TipoUf tipoUf) {
        this.tipoUf = tipoUf;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(tipoUf)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Cidade)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Cidade outroCidade = (Cidade) objeto;
        return new EqualsBuilder()
                .append(nome, outroCidade.nome)
                .append(tipoUf, outroCidade.tipoUf)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("nome", nome)
                .append("tipoUf", tipoUf)
                .toString();
    }
    
}
