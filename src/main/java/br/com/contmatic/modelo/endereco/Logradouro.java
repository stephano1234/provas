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

public class Logradouro {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio(message = MensagensErro.STRING_VAZIO)
    @Size(max = ConstantesNumericas.CAMPO_REGULAR, message = MensagensErro.STRING_MAX)
    @NaoApenas
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL, message = MensagensErro.STRING_INVALIDO)
    private String nome;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("bairro", bairro)
                .toString();
    }
    
}