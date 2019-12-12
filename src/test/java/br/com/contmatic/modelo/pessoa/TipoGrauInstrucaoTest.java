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

public class TipoGrauInstrucaoTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_ANALFABETO() {
        assertThat(TipoGrauInstrucao.ANALFABETO.getDescricao(), is(equalTo("Analfabeto")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ATE_5_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL() {
        assertThat(TipoGrauInstrucao.ATE_5_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL.getDescricao(), is(equalTo("Até o 5º ano incompleto do Ensino Fundamental")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_O_5_ANO_COMPLETO_ENSINO_FUNDAMENTAL() {
        assertThat(TipoGrauInstrucao.O_5_ANO_COMPLETO_ENSINO_FUNDAMENTAL.getDescricao(), is(equalTo("5º ano completo do Ensino Fundamental")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DO_6_AO_9_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO() {
        assertThat(TipoGrauInstrucao.DO_6_AO_9_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO.getDescricao(), is(equalTo("Do 6º ao 9º ano do Ensino Fundamental incompleto")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ENSINO_FUNDAMENTAL_COMPLETO() {
        assertThat(TipoGrauInstrucao.ENSINO_FUNDAMENTAL_COMPLETO.getDescricao(), is(equalTo("Ensino Fundamental completo")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ENSINO_MEDIO_INCOMPLETO() {
        assertThat(TipoGrauInstrucao.ENSINO_MEDIO_INCOMPLETO.getDescricao(), is(equalTo("Ensino Médio incompleto")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ENSINO_MEDIO_COMPLETO() {
        assertThat(TipoGrauInstrucao.ENSINO_MEDIO_COMPLETO.getDescricao(), is(equalTo("Ensino Médio completo")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SUPERIOR_INCOMPLETO() {
        assertThat(TipoGrauInstrucao.SUPERIOR_INCOMPLETO.getDescricao(), is(equalTo("Superior incompleto")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SUPERIOR_COMPLETO() {
        assertThat(TipoGrauInstrucao.SUPERIOR_COMPLETO.getDescricao(), is(equalTo("Superior completo")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_POS_GRADUACAO_ESPECIALIZACAO() {
        assertThat(TipoGrauInstrucao.POS_GRADUACAO_ESPECIALIZACAO.getDescricao(), is(equalTo("Pós-Graduação / Especialização")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MESTRADO() {
        assertThat(TipoGrauInstrucao.MESTRADO.getDescricao(), is(equalTo("Mestrado")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DOUTORADO() {
        assertThat(TipoGrauInstrucao.DOUTORADO.getDescricao(), is(equalTo("Doutorado")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_POS_DOUTORADO() {
        assertThat(TipoGrauInstrucao.POS_DOUTORADO.getDescricao(), is(equalTo("Pós-Doutorado")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoGrauInstrucao.class).testing(GETTER).areWellImplemented();
    }
    
}