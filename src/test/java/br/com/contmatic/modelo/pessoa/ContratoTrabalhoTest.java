package br.com.contmatic.modelo.pessoa;

import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;
import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
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

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.utilidades.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.ContratoTrabalhoTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ContratoTrabalhoTest {
    
    private ContratoTrabalho contratoTrabalho;
    
    private ContratoTrabalho outroContratoTrabalho;
    
    private Pessoa pessoa;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new ContratoTrabalhoTemplateFixtureFactory().load();
        new PessoaTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        contratoTrabalho = Fixture.from(ContratoTrabalho.class).gimme("valido");
        outroContratoTrabalho = Fixture.from(ContratoTrabalho.class).gimme("outroValido");
        pessoa = Fixture.from(Pessoa.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }
    
    //contratoTrabalho
    
    @Test
    public void nao_deve_aceitar_pessoa_nulo() {
    	contratoTrabalho.setPessoa(null);
    	assertTrue(procuraAlgumErro(contratoTrabalho));
    }

    @Test
    public void deve_aceitar_pessoa_nao_nulo() {
    	contratoTrabalho.setPessoa(pessoa);
    	assertFalse(procuraAlgumErro(contratoTrabalho));
    }
    
    @Test
    public void nao_deve_aceitar_pessoa_invalido() {
    	contratoTrabalho.setPessoa(Fixture.from(Pessoa.class).gimme("comUmDigitoVerificadorInvalidoCpf"));
    	assertTrue(procuraAlgumErro(contratoTrabalho));
    }

    @Test
    public void deve_aceitar_pessoa_valido() {
    	contratoTrabalho.setPessoa(Fixture.from(Pessoa.class).gimme("valido"));
    	assertFalse(procuraAlgumErro(contratoTrabalho));
    }
    
    //tipoContratoTrabalho
    
    @Test
    public void nao_deve_aceitar_tipoContratoTrabalho_nulo() {
    	contratoTrabalho.setTipoContratoTrabalho(null);
    	assertTrue(procuraAlgumErro(contratoTrabalho));
    }

    @Test
    public void deve_aceitar_tipoContratoTrabalho_nao_nulo() {
    	contratoTrabalho.setTipoContratoTrabalho(TipoContratoTrabalho.AUTONOMO);
    	assertFalse(procuraAlgumErro(contratoTrabalho));
    }
    
    //dataInicioContrato
    
    @Test
    public void nao_deve_aceitar_dataInicioContrato_nulo() {
    	contratoTrabalho.setDataInicioContrato(null);
    	assertTrue(procuraAlgumErro(contratoTrabalho));
    }
    
    @Test
    public void nao_deve_aceitar_dataInicioContrato_futura() {
    	contratoTrabalho = Fixture.from(ContratoTrabalho.class).gimme("dataInicioContratoFutura");
    	assertTrue(procuraAlgumErro(contratoTrabalho));
    }

    @Test
    public void deve_aceitar_dataInicioContrato_passada() {
    	contratoTrabalho = Fixture.from(ContratoTrabalho.class).gimme("dataInicioContratoPassada");
    	assertFalse(procuraAlgumErro(contratoTrabalho));
    }
    
    //getter e setter    
    
    @Test
    public void getPessoa_deve_trazer_o_valor_armazenado_em_pessoa() {
        contratoTrabalho.setPessoa(pessoa);
        assertThat(contratoTrabalho.getPessoa(), is(equalTo(pessoa)));
    }

    @Test
    public void getTipoContratoTrabalho_deve_trazer_o_valor_armazenado_em_tipoContratoTrabalho() {
        contratoTrabalho.setTipoContratoTrabalho(TipoContratoTrabalho.AUTONOMO);
        assertThat(contratoTrabalho.getTipoContratoTrabalho(), is(equalTo(TipoContratoTrabalho.AUTONOMO)));
    }
    
    @Test
    public void getDataInicioContrato_deve_trazer_o_valor_armazenado_em_dataInicioContrato() {
        contratoTrabalho.setDataInicioContrato(LocalDate.parse("1996-08-13"));
        assertThat(contratoTrabalho.getDataInicioContrato(), is(equalTo(LocalDate.parse("1996-08-13"))));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(ContratoTrabalho.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(ContratoTrabalho.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {pessoa, TipoContratoTrabalho.AUTONOMO, LocalDate.parse("1996-08-13")};
        assertTrue(verificaConstrutor(ContratoTrabalho.class, valores, Pessoa.class, TipoContratoTrabalho.class, LocalDate.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_pessoa_igual() {
        outroContratoTrabalho.setPessoa(contratoTrabalho.getPessoa());
        assertThat(contratoTrabalho.hashCode(), is(equalTo(outroContratoTrabalho.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_pessoa_diferente() {
        assertThat(contratoTrabalho.hashCode(), is(not(equalTo(outroContratoTrabalho.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_pessoa_igual() {
        outroContratoTrabalho.setPessoa(contratoTrabalho.getPessoa());
        assertTrue(contratoTrabalho.equals(outroContratoTrabalho));
    }
    
    @Test
    public void equals_deve_retornar_false_com_pessoa_diferente() {
        assertFalse(contratoTrabalho.equals(outroContratoTrabalho));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(ContratoTrabalho.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_pessoa_no_texto_gerado_pelo_metodo_toString() {
        contratoTrabalho.setPessoa(pessoa);
        assertTrue(contratoTrabalho.toString().contains(pessoa.toString()));
    }
    
	@Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoContratoTrabalho_no_texto_gerado_pelo_metodo_toString() {
        contratoTrabalho.setTipoContratoTrabalho(TipoContratoTrabalho.AUTONOMO);
        assertTrue(contratoTrabalho.toString().contains(TipoContratoTrabalho.AUTONOMO.name()));
    }
	
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_dataInicioContrato_no_texto_gerado_pelo_metodo_toString() {
    	contratoTrabalho.setDataInicioContrato(LocalDate.parse("1996-08-13"));
        assertTrue(contratoTrabalho.toString().contains("1996-08-13"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(contratoTrabalho));
    }
    
}