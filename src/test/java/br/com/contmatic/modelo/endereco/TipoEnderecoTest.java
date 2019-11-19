package br.com.contmatic.modelo.endereco;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.pojo.tester.api.assertion.Method;

public class TipoEnderecoTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_RESIDENCIAL() {
        assertThat(TipoEndereco.RESIDENCIAL.getDescricao(), is(equalTo("Endereço residencial")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_COMERCIAL() {
        assertThat(TipoEndereco.COMERCIAL.getDescricao(), is(equalTo("Endereço comercial")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoEndereco.class).testing(Method.GETTER).areWellImplemented();
    }
    
}
