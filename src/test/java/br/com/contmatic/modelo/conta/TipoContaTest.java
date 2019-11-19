package br.com.contmatic.modelo.conta;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.modelo.conta.TipoConta;
import pl.pojo.tester.api.assertion.Method;

public class TipoContaTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_CONTA_CORRENTE() {
        assertThat(TipoConta.CONTA_CORRENTE.getDescricao(), is(equalTo("Conta corrente")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_CONTA_POUPANCA() {
        assertThat(TipoConta.CONTA_POUPANCA.getDescricao(), is(equalTo("Conta poupança")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoConta.class).testing(Method.GETTER).areWellImplemented();
    }
    
}
