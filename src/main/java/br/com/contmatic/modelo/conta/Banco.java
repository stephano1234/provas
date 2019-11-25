package br.com.contmatic.modelo.conta;

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

public class Banco {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio
    @Size(max = ConstantesNumericas.MAX_CODIGO_BANCO, message = MensagensErro.STRING_MAX)
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.SEM_ESPACO, message = MensagensErro.STRING_COM_ESPACO)
    private String codigo;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @NaoVazio
    @Size(max = ConstantesNumericas.CAMPO_REGULAR, message = MensagensErro.STRING_MAX)
    @NaoApenas
    private String nome;
    
    public Banco(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(codigo)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Banco)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Banco outroBanco = (Banco) objeto;
        return new EqualsBuilder()
                .append(codigo, outroBanco.codigo)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("codigo", codigo)
                .append("nome", nome)
                .toString();
    }
    
}
