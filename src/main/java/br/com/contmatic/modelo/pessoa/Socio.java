package br.com.contmatic.modelo.pessoa;

import java.math.BigDecimal;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.*;

import br.com.contmatic.modelo.empresa.Empresa;

import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Socio {

    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Pessoa pessoa;
      
    @NotNull(message = MensagensErro.VALOR_NULO)
    @Valid
    private Empresa empresa;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    @DecimalMax(value = ExpressoesRegularesRegraNegocio.UM, message = MensagensErro.DECIMAL_MAX)
    @DecimalMin(value = ExpressoesRegularesRegraNegocio.ZERO, message = MensagensErro.DECIMAL_MIN)
    private BigDecimal participacao;
    
    @NotNull(message = MensagensErro.VALOR_NULO)
    private TipoSocio tipoSocio;
    
    @Valid
    private Set<Celular> celularesCorporativo;
    
    @Pattern(regexp = ExpressoesRegularesRegraNegocio.EMAIL, message = MensagensErro.STRING_INVALIDO)
    private String emailCorporativo;
    
    public Socio(Pessoa pessoa, Empresa empresa, BigDecimal participacao, TipoSocio tipoSocio) {
        this.pessoa = pessoa;
        this.empresa = empresa;
        this.participacao = participacao;
        this.tipoSocio = tipoSocio;
    }
   
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getParticipacao() {
        return participacao;
    }

    public void setParticipacao(BigDecimal participacao) {
        this.participacao = participacao;
    }

    public TipoSocio getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(TipoSocio tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public Set<Celular> getCelularesCorporativo() {
        return celularesCorporativo;
    }

    public void setCelularesCorporativo(Set<Celular> celularesCorporativo) {
        this.celularesCorporativo = celularesCorporativo;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(pessoa)
                .append(empresa)
                .toHashCode();
    }
    
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Socio)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Socio outroSocio = (Socio) objeto;
        return new EqualsBuilder()
                .append(pessoa, outroSocio.pessoa)
                .append(empresa, outroSocio.empresa)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("pessoa", pessoa)
                .append("empresa", empresa)
                .append("participacao", participacao)
                .append("tipoSocio", tipoSocio)
                .append("celularesCorporativo", (celularesCorporativo != null) ? celularesCorporativo : "Celular corporativo não informado")
                .append("emailCorporativo", (emailCorporativo != null) ? emailCorporativo : "E-mail corporativo não informado")
                .toString();
    }
    
}
