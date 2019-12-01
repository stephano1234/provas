package br.com.contmatic.modelo.pessoa;

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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.utilidades.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.SocioTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class SocioTest {
    
    private Socio socio;
    
    private Socio outroSocio;
    
    private Pessoa pessoa;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new SocioTemplateFixtureFactory().load();
        new PessoaTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        socio = Fixture.from(Socio.class).gimme("valido");
        outroSocio = Fixture.from(Socio.class).gimme("outroValido");
        pessoa = Fixture.from(Pessoa.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }
    
    //socio
    
    @Test
    public void nao_deve_aceitar_pessoa_nulo() {
    	socio.setPessoa(null);
    	assertTrue(verificaErro(socio, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_pessoa_nao_nulo() {
    	socio.setPessoa(pessoa);
    	assertFalse(verificaErro(socio, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_pessoa_invalido() {
    	socio.setPessoa(Fixture.from(Pessoa.class).gimme("comUmDigitoVerificadorInvalidoCpf"));
    	assertTrue(procuraAlgumErro(socio));
    }

    @Test
    public void deve_aceitar_pessoa_valido() {
    	socio.setPessoa(Fixture.from(Pessoa.class).gimme("valido"));
    	assertFalse(procuraAlgumErro(socio));
    }
    
    //tipoSocio
    
    @Test
    public void nao_deve_aceitar_tipoSocio_nulo() {
    	socio.setTipoSocio(null);
    	assertTrue(verificaErro(socio, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoSocio_nao_nulo() {
    	socio.setTipoSocio(TipoSocio.ADMINISTRADOR);
    	assertFalse(verificaErro(socio, VALOR_NULO));
    }
    
    //getter e setter    
    
    @Test
    public void getPessoa_deve_trazer_o_valor_armazenado_em_pessoa() {
        socio.setPessoa(pessoa);
        assertThat(socio.getPessoa(), is(equalTo(pessoa)));
    }
    
    @Test
    public void getTipoSocio_deve_trazer_o_valor_armazenado_em_tipoSocio() {
        socio.setTipoSocio(TipoSocio.ADMINISTRADOR);
        assertThat(socio.getTipoSocio(), is(equalTo(TipoSocio.ADMINISTRADOR)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Socio.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Socio.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {pessoa, TipoSocio.ADMINISTRADOR};
        assertTrue(verificaConstrutor(socio, valores, Pessoa.class, TipoSocio.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_pessoa_igual() {
        outroSocio.setPessoa(socio.getPessoa());
        assertThat(socio.hashCode(), is(equalTo(outroSocio.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_pessoa_diferente() {
        assertThat(socio.hashCode(), is(not(equalTo(outroSocio.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_pessoa_igual() {
        outroSocio.setPessoa(socio.getPessoa());
        assertTrue(socio.equals(outroSocio));
    }
    
    @Test
    public void equals_deve_retornar_false_com_pessoa_diferente() {
        assertFalse(socio.equals(outroSocio));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Socio.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_pessoa_no_texto_gerado_pelo_metodo_toString() {
        socio.setPessoa(pessoa);
        assertTrue(socio.toString().contains(pessoa.toString()));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoSocio_no_texto_gerado_pelo_metodo_toString() {
        socio.setTipoSocio(TipoSocio.ADMINISTRADOR);
        assertTrue(socio.toString().contains(TipoSocio.ADMINISTRADOR.name()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(socio));
    }
    
}