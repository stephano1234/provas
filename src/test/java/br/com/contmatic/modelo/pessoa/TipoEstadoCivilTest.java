package br.com.contmatic.modelo.pessoa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.modelo.pessoa.TipoEstadoCivil;
import pl.pojo.tester.api.assertion.Method;

public class TipoEstadoCivilTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //constantes
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SOLTEIRO() {
        assertThat(TipoEstadoCivil.SOLTEIRO.getDescricao(), is(equalTo("Solteiro(a)")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_CASADO() {
        assertThat(TipoEstadoCivil.CASADO.getDescricao(), is(equalTo("Casado(a)")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DIVORCIADO() {
        assertThat(TipoEstadoCivil.DIVORCIADO.getDescricao(), is(equalTo("Divorciado(a)")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_VIUVO() {
        assertThat(TipoEstadoCivil.VIUVO.getDescricao(), is(equalTo("Viuvo(a)")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_OUTROS() {
        assertThat(TipoEstadoCivil.OUTROS.getDescricao(), is(equalTo("Outros")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoEstadoCivil.class).testing(Method.GETTER).areWellImplemented();
    }
    
}