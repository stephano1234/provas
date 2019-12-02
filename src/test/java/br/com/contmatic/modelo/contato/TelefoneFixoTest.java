package br.com.contmatic.modelo.contato;

import static br.com.contmatic.utilidades.MensagensErro.STRING_DDD_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.STRING_TELEFONE_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaErro;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;

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

import br.com.contmatic.utilidades.templates.contato.TelefoneFixoTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TelefoneFixoTest {
    
    private TelefoneFixo telefoneFixo;
    
    private TelefoneFixo outroTelefoneFixo;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new TelefoneFixoTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("valido");
        outroTelefoneFixo = Fixture.from(TelefoneFixo.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //ddd
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_ddd() {
        telefoneFixo.setDdd(null);
        assertTrue(verificaErro(telefoneFixo, VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("naoNuloDdd");
        assertFalse(verificaErro(telefoneFixo, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("maiorTamanhoDdd");
        assertTrue(verificaErro(telefoneFixo, STRING_DDD_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("menorTamanhoDdd");
        assertTrue(verificaErro(telefoneFixo, STRING_DDD_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoDdd");
        assertTrue(verificaErro(telefoneFixo, STRING_DDD_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_ddd_valido() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("validoDdd");
        assertFalse(verificaErro(telefoneFixo, STRING_DDD_INVALIDO));
    }
    
    //numero
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        telefoneFixo.setNumero(null);
        assertTrue(verificaErro(telefoneFixo, VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("naoNuloNumero");
        assertFalse(verificaErro(telefoneFixo, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("maiorTamanhoNumero");
        assertTrue(verificaErro(telefoneFixo, STRING_TELEFONE_INVALIDO));
    }

    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("menorTamanhoNumero");
        assertTrue(verificaErro(telefoneFixo, STRING_TELEFONE_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(verificaErro(telefoneFixo, STRING_TELEFONE_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_numero_valido() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("validoNumero");
        assertFalse(verificaErro(telefoneFixo, STRING_TELEFONE_INVALIDO));
    }
    
    //getter e setter    
    
    @Test
    public void getDdd_deve_trazer_o_valor_armazenado_em_ddd() {
        telefoneFixo.setDdd("45");
        assertThat(telefoneFixo.getDdd(), is(equalTo("45")));
    }
    
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        telefoneFixo.setNumero("08004444");
        assertThat(telefoneFixo.getNumero(), is(equalTo("08004444")));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TelefoneFixo.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(TelefoneFixo.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"00", "00000000"};
        assertTrue(verificaConstrutor(telefoneFixo, valores, String.class, String.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_ddd_numero_igual() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertThat(telefoneFixo.hashCode(), is(equalTo(outroTelefoneFixo.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_igual_numero_diferente() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        assertThat(telefoneFixo.hashCode(), is(not(equalTo(outroTelefoneFixo.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_diferente_numero_igual() {
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertThat(telefoneFixo.hashCode(), is(not(equalTo(outroTelefoneFixo.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_diferente_numero_diferente() {
        assertThat(telefoneFixo.hashCode(), is(not(equalTo(outroTelefoneFixo.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_ddd_numero_igual() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertTrue(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    @Test
    public void equals_deve_retornar_false_com_ddd_igual_numero_diferente() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        assertFalse(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    @Test
    public void equals_deve_retornar_false_com_ddd_diferente_numero_igual() {
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertFalse(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    @Test
    public void equals_deve_retornar_false_com_ddd_diferente_numero_diferente() {
        assertFalse(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(TelefoneFixo.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_ddd_no_texto_gerado_pelo_metodo_toString() {
        telefoneFixo.setDdd("45");
        assertTrue(telefoneFixo.toString().contains("45"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        telefoneFixo.setNumero("08004444");
        assertTrue(telefoneFixo.toString().contains("08004444"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(telefoneFixo));
    }
    
}