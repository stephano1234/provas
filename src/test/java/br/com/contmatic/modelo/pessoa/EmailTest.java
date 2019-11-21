package br.com.contmatic.modelo.pessoa;

import static br.com.contmatic.utilidades.VerificadoresRegras.verificaConstrutor;
import static br.com.contmatic.utilidades.VerificadoresRegras.verificaErro;
import static br.com.contmatic.utilidades.VerificadoresRegras.verificaToStringJSONSTYLE;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.pessoa.EmailTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class EmailTest {
    
    private Email email;
    
    private Email outroEmail;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new EmailTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        email = Fixture.from(Email.class).gimme("valido");
        outroEmail = Fixture.from(Email.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //endereco
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_endereco() {
        email.setEndereco(null);
        assertTrue(verificaErro(email, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_endereco() {
        email = Fixture.from(Email.class).gimme("naoNuloEndereco");
        assertFalse(verificaErro(email, MensagensErro.VALOR_NULO));
    }
	
    @Test
    public void nao_deve_aceitar_valor_vazio_no_endereco() {
        email.setEndereco("");
        assertTrue(verificaErro(email, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_endereco() {
        email = Fixture.from(Email.class).gimme("naoVazioEndereco");
        assertFalse(verificaErro(email, MensagensErro.STRING_VAZIO));
    }
    
	
    

    
    //getter e setter    
    
    @Test
    public void getEndereco_deve_trazer_o_valor_armazenado_em_endereco() {
        email.setEndereco("teste@teste.teste");
        assertThat(email.getEndereco(), is(equalTo("teste@teste.teste")));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Email.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Email.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"teste@teste.teste"};
        assertTrue(verificaConstrutor(email, valores, String.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_endereco_igual() {
        outroEmail.setEndereco(email.getEndereco());
        assertThat(email.hashCode(), is(equalTo(outroEmail.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_endereco_diferente() {
        assertThat(email.hashCode(), is(not(equalTo(outroEmail.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_endereco_igual() {
        outroEmail.setEndereco(email.getEndereco());
        assertTrue(email.equals(outroEmail));
    }
    
    @Test
    public void equals_deve_retornar_false_com_endereco_diferente() {
        assertFalse(email.equals(outroEmail));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Email.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_endereco_no_texto_gerado_pelo_metodo_toString() {
        email.setEndereco("teste@teste.teste");
        assertTrue(email.toString().contains("teste@teste.teste"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(email));
    }
    
}