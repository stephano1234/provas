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

public class TipoEmpresaTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_INDIVIDUAL() {
        assertThat(TipoEmpresa.INDIVIDUAL.getDescricao(), is(equalTo("Empresário Individual")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MEI() {
        assertThat(TipoEmpresa.MEI.getDescricao(), is(equalTo("Microempreendedor Individual")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_EIRELI() {
        assertThat(TipoEmpresa.EIRELI.getDescricao(), is(equalTo("Empresa Individual de Responsabilidade Limitada")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SOCIEDADE() {
        assertThat(TipoEmpresa.SOCIEDADE.getDescricao(), is(equalTo("Sociedade Emppresária")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SOCIEDADE_SIMPLES() {
        assertThat(TipoEmpresa.SOCIEDADE_SIMPLES.getDescricao(), is(equalTo("Sociedade Simples")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoEmpresa.class).testing(GETTER).areWellImplemented();
    }
    
}
