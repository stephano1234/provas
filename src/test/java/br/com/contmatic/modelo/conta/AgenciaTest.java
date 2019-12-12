package br.com.contmatic.modelo.conta;

import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;
import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;

import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.modelo.conta.Agencia;

import br.com.contmatic.utilidades.templates.conta.AgenciaTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class AgenciaTest {
    
    private Agencia agencia;
    
    private Agencia outroAgencia;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new AgenciaTemplateFixtureFactory().load();     
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        agencia = Fixture.from(Agencia.class).gimme("valido");
        outroAgencia = Fixture.from(Agencia.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //numero
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        agencia.setNumero(null);
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        agencia.setNumero("");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("maiorTamanhoNumero");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void deve_aceitar_numero_valido() {
        agencia = Fixture.from(Agencia.class).gimme("validoNumero");
        assertFalse(procuraAlgumErro(agencia));
    }

    //codigoCodigoBanco
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_codigoBanco() {
        agencia.setCodigoBanco(null);
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_codigoBanco() {
        agencia.setCodigoBanco("");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_codigoBanco() {
        agencia = Fixture.from(Agencia.class).gimme("maiorTamanhoCodigoBanco");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_codigoBanco() {
        agencia = Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoCodigoBanco");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void deve_aceitar_codigoBanco_valido() {
        agencia = Fixture.from(Agencia.class).gimme("validoCodigoBanco");
        assertFalse(procuraAlgumErro(agencia));
    }
    
    //getter e setter    
    
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        agencia.setNumero("2244");
        assertThat(agencia.getNumero(), is(equalTo("2244")));
    }
    
    @Test
    public void getCodigoBanco_deve_trazer_o_valor_armazenado_em_codigoBanco() {
        agencia.setCodigoBanco("77B");
        assertThat(agencia.getCodigoBanco(), is(equalTo("77B")));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Agencia.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Agencia.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"1223", "77B"};
        assertTrue(verificaConstrutor(Agencia.class, valores, String.class, String.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_numero_codigoBanco_igual() {
        outroAgencia.setNumero(agencia.getNumero());
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertThat(agencia.hashCode(), is(equalTo(outroAgencia.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_codigoBanco_diferente() {
        outroAgencia.setNumero(agencia.getNumero());
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_diferente_codigoBanco_igual() {
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_codigoBanco_diferente() {
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    @Test
    public void equals_deve_retornar_true_com_numero_codigoBanco_igual() {
        outroAgencia.setNumero(agencia.getNumero());
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertTrue(agencia.equals(outroAgencia));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_igual_codigoBanco_diferente() {
        outroAgencia.setNumero(agencia.getNumero());
        assertFalse(agencia.equals(outroAgencia));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_diferente_codigoBanco_igual() {
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertFalse(agencia.equals(outroAgencia));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_codigoBanco_diferente() {
        assertFalse(agencia.equals(outroAgencia));
    }
        
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Agencia.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        agencia.setNumero("2244");
        assertTrue(agencia.toString().contains("2244"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_codigoBanco_no_texto_gerado_pelo_metodo_toString() {
        agencia.setCodigoBanco("77B");
        assertTrue(agencia.toString().contains("77B"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(agencia));
    }
    
}
