package br.com.contmatic.modelo.empresa;

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

public class TipoPorteEmpresaTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_ME() {
        assertThat(TipoPorteEmpresa.ME.getDescricao(), is(equalTo("Microempresa")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_EPP() {
        assertThat(TipoPorteEmpresa.EPP.getDescricao(), is(equalTo("Empresa de pequeno porte")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MEDIO() {
        assertThat(TipoPorteEmpresa.MEDIO.getDescricao(), is(equalTo("Empresa de médio porte")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_GRANDE() {
        assertThat(TipoPorteEmpresa.GRANDE.getDescricao(), is(equalTo("Empresa de grande porte")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoPorteEmpresa.class).testing(GETTER).areWellImplemented();
    }
    
}
