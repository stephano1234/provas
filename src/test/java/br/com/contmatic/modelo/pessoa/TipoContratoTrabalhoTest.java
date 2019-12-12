package br.com.contmatic.modelo.pessoa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TipoContratoTrabalhoTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_TEMPO_DETERMINADO() {
        assertThat(TipoContratoTrabalho.TEMPO_DETERMINADO.getDescricao(), is(equalTo("Contrato de trabalho por tempo determinado")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TEMPO_INDETERMINADO() {
        assertThat(TipoContratoTrabalho.TEMPO_INDETERMINADO.getDescricao(), is(equalTo("Contrato de trabalho por tempo indeterminado")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TEMPORAREO() {
        assertThat(TipoContratoTrabalho.TEMPORAREO.getDescricao(), is(equalTo("Contrato de trabalho temporáreo")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_EVENTUAL() {
        assertThat(TipoContratoTrabalho.EVENTUAL.getDescricao(), is(equalTo("Contrato de trabalho eventual")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AUTONOMO() {
        assertThat(TipoContratoTrabalho.AUTONOMO.getDescricao(), is(equalTo("Contrato de trabalho autônomo")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ESTAGIO() {
        assertThat(TipoContratoTrabalho.ESTAGIO.getDescricao(), is(equalTo("Contrato de estágio")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoContratoTrabalho.class).testing(GETTER).areWellImplemented();
    }
    
}
