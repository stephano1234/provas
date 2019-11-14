package br.com.contmatic.modelo.endereco;

import javax.validation.Valid;
import javax.validation.constraints.*;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.validacoes.NaoApenas;
import br.com.contmatic.utilidades.validacoes.NaoVazio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Bairro {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.CAMPO_REGULAR, message = MensagensErro.STRING_MAX)
    @NaoApenas
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL, message = MensagensErro.STRING_INVALIDO)
    private String nome;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("cidade", cidade)
                .toString();
    }
    
}