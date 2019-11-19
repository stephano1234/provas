package br.com.contmatic.modelo.pessoa;

import br.com.contmatic.modelo.endereco.Endereco;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.MensagensErro;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.joda.time.LocalDate;

public class Pessoa {

    private String cpf;
    
    private String nome;
    
    private Set<Endereco> enderecos;
    
    private LocalDate dataNascimento;
    
    private Set<Celular> celularesPessoal;
    
    private String emailPessoal;
    
    
    
}
