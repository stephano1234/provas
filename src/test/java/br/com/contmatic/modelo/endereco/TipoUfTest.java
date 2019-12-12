package br.com.contmatic.modelo.endereco;

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

public class TipoUfTest {

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
    public void verifica_valor_do_atributo_descricao_da_constante_AC() {
        assertThat(TipoUf.AC.getSigla(), is(equalTo("AC")));
    }

    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AL() {
        assertThat(TipoUf.AL.getSigla(), is(equalTo("AL")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AM() {
        assertThat(TipoUf.AM.getSigla(), is(equalTo("AM")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AP() {
        assertThat(TipoUf.AP.getSigla(), is(equalTo("AP")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_BA() {
        assertThat(TipoUf.BA.getSigla(), is(equalTo("BA")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_CE() {
        assertThat(TipoUf.CE.getSigla(), is(equalTo("CE")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DF() {
        assertThat(TipoUf.DF.getSigla(), is(equalTo("DF")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ES() {
        assertThat(TipoUf.ES.getSigla(), is(equalTo("ES")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_GO() {
        assertThat(TipoUf.GO.getSigla(), is(equalTo("GO")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MA() {
        assertThat(TipoUf.MA.getSigla(), is(equalTo("MA")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MG() {
        assertThat(TipoUf.MG.getSigla(), is(equalTo("MG")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MS() {
        assertThat(TipoUf.MS.getSigla(), is(equalTo("MS")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MT() {
        assertThat(TipoUf.MT.getSigla(), is(equalTo("MT")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PA() {
        assertThat(TipoUf.PA.getSigla(), is(equalTo("PA")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PB() {
        assertThat(TipoUf.PB.getSigla(), is(equalTo("PB")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PE() {
        assertThat(TipoUf.PE.getSigla(), is(equalTo("PE")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PI() {
        assertThat(TipoUf.PI.getSigla(), is(equalTo("PI")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PR() {
        assertThat(TipoUf.PR.getSigla(), is(equalTo("PR")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RJ() {
        assertThat(TipoUf.RJ.getSigla(), is(equalTo("RJ")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RN() {
        assertThat(TipoUf.RN.getSigla(), is(equalTo("RN")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RO() {
        assertThat(TipoUf.RO.getSigla(), is(equalTo("RO")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RR() {
        assertThat(TipoUf.RR.getSigla(), is(equalTo("RR")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RS() {
        assertThat(TipoUf.RS.getSigla(), is(equalTo("RS")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SC() {
        assertThat(TipoUf.SC.getSigla(), is(equalTo("SC")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SE() {
        assertThat(TipoUf.SE.getSigla(), is(equalTo("SE")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SP() {
        assertThat(TipoUf.SP.getSigla(), is(equalTo("SP")));
    }
    
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TO() {
        assertThat(TipoUf.TO.getSigla(), is(equalTo("TO")));
    }
    
    //getter
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoUf.class).testing(GETTER).areWellImplemented();
    }
    
}
