package br.com.contmatic.modelo.pessoa;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;
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

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.utilidades.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.ColaboradorTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ColaboradorTest {
    
    private Colaborador colaborador;
    
    private Colaborador outroColaborador;
    
    private Pessoa pessoa;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new ColaboradorTemplateFixtureFactory().load();
        new PessoaTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        colaborador = Fixture.from(Colaborador.class).gimme("valido");
        outroColaborador = Fixture.from(Colaborador.class).gimme("outroValido");
        pessoa = Fixture.from(Pessoa.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }
    
    //colaborador
    
    @Test
    public void nao_deve_aceitar_pessoa_nulo() {
    	colaborador.setPessoa(null);
    	assertTrue(verificaErro(colaborador, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_pessoa_nao_nulo() {
    	colaborador.setPessoa(pessoa);
    	assertFalse(verificaErro(colaborador, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_pessoa_invalido() {
    	colaborador.setPessoa(Fixture.from(Pessoa.class).gimme("comUmDigitoVerificadorInvalidoCpf"));
    	assertTrue(procuraAlgumErro(colaborador));
    }

    @Test
    public void deve_aceitar_pessoa_valido() {
    	colaborador.setPessoa(Fixture.from(Pessoa.class).gimme("valido"));
    	assertFalse(procuraAlgumErro(colaborador));
    }
    
    //tipoContratoTrabalho
    
    @Test
    public void nao_deve_aceitar_tipoContratoTrabalho_nulo() {
    	colaborador.setTipoContratoTrabalho(null);
    	assertTrue(verificaErro(colaborador, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoContratoTrabalho_nao_nulo() {
    	colaborador.setTipoContratoTrabalho(TipoContratoTrabalho.AUTONOMO);
    	assertFalse(verificaErro(colaborador, VALOR_NULO));
    }
    
    //dataInicioContrato
    
    @Test
    public void nao_deve_aceitar_dataInicioContrato_nulo() {
    	colaborador.setDataInicioContrato(null);
    	assertTrue(verificaErro(colaborador, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_dataInicioContrato_nao_nulo() {
    	colaborador = Fixture.from(Colaborador.class).gimme("dataInicioContratoQualquer");
    	assertFalse(verificaErro(colaborador, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_dataInicioContrato_futura() {
    	colaborador = Fixture.from(Colaborador.class).gimme("dataInicioContratoFutura");
    	assertTrue(verificaErro(colaborador, DATA_PASSADO));
    }

    @Test
    public void deve_aceitar_dataInicioContrato_passada() {
    	colaborador = Fixture.from(Colaborador.class).gimme("dataInicioContratoPassada");
    	assertFalse(verificaErro(colaborador, DATA_PASSADO));
    }
    
    //getter e setter    
    
    @Test
    public void getPessoa_deve_trazer_o_valor_armazenado_em_pessoa() {
        colaborador.setPessoa(pessoa);
        assertThat(colaborador.getPessoa(), is(equalTo(pessoa)));
    }

    @Test
    public void getTipoContratoTrabalho_deve_trazer_o_valor_armazenado_em_tipoContratoTrabalho() {
        colaborador.setTipoContratoTrabalho(TipoContratoTrabalho.AUTONOMO);
        assertThat(colaborador.getTipoContratoTrabalho(), is(equalTo(TipoContratoTrabalho.AUTONOMO)));
    }
    
    @Test
    public void getDataInicioContrato_deve_trazer_o_valor_armazenado_em_dataInicioContrato() {
        colaborador.setDataInicioContrato(LocalDate.parse("1996-08-13"));
        assertThat(colaborador.getDataInicioContrato(), is(equalTo(LocalDate.parse("1996-08-13"))));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Colaborador.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Colaborador.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {pessoa, TipoContratoTrabalho.AUTONOMO, LocalDate.parse("1996-08-13")};
        assertTrue(verificaConstrutor(colaborador, valores, Pessoa.class, TipoContratoTrabalho.class, LocalDate.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_pessoa_igual() {
        outroColaborador.setPessoa(colaborador.getPessoa());
        assertThat(colaborador.hashCode(), is(equalTo(outroColaborador.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_pessoa_diferente() {
        assertThat(colaborador.hashCode(), is(not(equalTo(outroColaborador.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_pessoa_igual() {
        outroColaborador.setPessoa(colaborador.getPessoa());
        assertTrue(colaborador.equals(outroColaborador));
    }
    
    @Test
    public void equals_deve_retornar_false_com_pessoa_diferente() {
        assertFalse(colaborador.equals(outroColaborador));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Colaborador.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_pessoa_no_texto_gerado_pelo_metodo_toString() {
        colaborador.setPessoa(pessoa);
        assertTrue(colaborador.toString().contains(pessoa.toString()));
    }
    
	@Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoContratoTrabalho_no_texto_gerado_pelo_metodo_toString() {
        colaborador.setTipoContratoTrabalho(TipoContratoTrabalho.AUTONOMO);
        assertTrue(colaborador.toString().contains(TipoContratoTrabalho.AUTONOMO.name()));
    }
	
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_dataInicioContrato_no_texto_gerado_pelo_metodo_toString() {
    	colaborador.setDataInicioContrato(LocalDate.parse("1996-08-13"));
        assertTrue(colaborador.toString().contains("1996-08-13"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(colaborador));
    }
    
}