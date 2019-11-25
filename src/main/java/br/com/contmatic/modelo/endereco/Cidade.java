package br.com.contmatic.modelo.endereco;

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

public class Cidade {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio
    @Size(max = ConstantesNumericas.CAMPO_REGULAR, message = MensagensErro.STRING_MAX)
    @NaoApenas
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL, message = MensagensErro.STRING_CARACTERE_ESPECIAL)
    private String nome;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("tipoUf", tipoUf)
                .toString();
    }
    
}
