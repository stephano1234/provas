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

public class TipoContatoCelularTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_APENAS_LIGACAO() {
        assertThat(TipoContatoCelular.APENAS_LIGACAO.getDescricao(), is(equalTo("Recebe apenas ligações")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_APENAS_MENSAGEM_TEXTO() {
        assertThat(TipoContatoCelular.APENAS_MENSAGEM_TEXTO.getDescricao(), is(equalTo("Recebe apenas mensagens de texto")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_APENAS_MENSAGEM_INTERNET() {
        assertThat(TipoContatoCelular.APENAS_MENSAGEM_INTERNET.getDescricao(), is(equalTo("Recebe apenas mensagens de internet")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_LIGACAO_MENSAGEM_TEXTO() {
        assertThat(TipoContatoCelular.LIGACAO_MENSAGEM_TEXTO.getDescricao(), is(equalTo("Recebe apenas ligações e mensagens de texto")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_LIGACAO_MENSAGEM_INTERNET() {
        assertThat(TipoContatoCelular.LIGACAO_MENSAGEM_INTERNET.getDescricao(), is(equalTo("Recebe apenas ligações e mensagens de internet")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MENSAGEM_TEXTO_INTERNET() {
        assertThat(TipoContatoCelular.MENSAGEM_TEXTO_INTERNET.getDescricao(), is(equalTo("Recebe apenas mensagens de texto e de internet")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_LIGACAO_MENSAGEM_TEXTO_INTERNET() {
        assertThat(TipoContatoCelular.LIGACAO_MENSAGEM_TEXTO_INTERNET.getDescricao(), is(equalTo("Recebe ligações, mensagens de texto e de internet")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoContatoCelular.class).testing(GETTER).areWellImplemented();
    }
    
}
