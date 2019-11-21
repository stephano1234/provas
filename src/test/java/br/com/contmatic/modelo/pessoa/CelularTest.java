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
import br.com.contmatic.utilidades.templates.pessoa.CelularTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class CelularTest {
    
    private Celular celular;
    
    private Celular outroCelular;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new CelularTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        celular = Fixture.from(Celular.class).gimme("valido");
        outroCelular = Fixture.from(Celular.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //ddd
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_ddd() {
        celular.setDdd(null);
        assertTrue(verificaErro(celular, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("naoNuloDdd");
        assertFalse(verificaErro(celular, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("maiorTamanhoDdd");
        assertTrue(verificaErro(celular, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("menorIgualTamanhoDdd");
        assertFalse(verificaErro(celular, MensagensErro.STRING_MAX));
    }

    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("menorTamanhoDdd");
        assertTrue(verificaErro(celular, MensagensErro.STRING_MIN));
    }
    
    @Test
    public void deve_aceitar_valor_maior_ou_igual_que_tamanho_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("maiorIgualTamanhoDdd");
        assertFalse(verificaErro(celular, MensagensErro.STRING_MIN));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("comCaractereInvalidoDdd");
        assertTrue(verificaErro(celular, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("comUmCaractereInvalidoDdd");
        assertTrue(verificaErro(celular, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_ddd() {
        celular = Fixture.from(Celular.class).gimme("semCaractereInvalidoDdd");
        assertFalse(verificaErro(celular, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    //numero
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        celular.setNumero(null);
        assertTrue(verificaErro(celular, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_numero() {
        celular = Fixture.from(Celular.class).gimme("naoNuloNumero");
        assertFalse(verificaErro(celular, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        celular = Fixture.from(Celular.class).gimme("maiorTamanhoNumero");
        assertTrue(verificaErro(celular, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_numero() {
        celular = Fixture.from(Celular.class).gimme("menorIgualTamanhoNumero");
        assertFalse(verificaErro(celular, MensagensErro.STRING_MAX));
    }

    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_numero() {
        celular = Fixture.from(Celular.class).gimme("menorTamanhoNumero");
        assertTrue(verificaErro(celular, MensagensErro.STRING_MIN));
    }
    
    @Test
    public void deve_aceitar_valor_maior_ou_igual_que_tamanho_no_numero() {
        celular = Fixture.from(Celular.class).gimme("maiorIgualTamanhoNumero");
        assertFalse(verificaErro(celular, MensagensErro.STRING_MIN));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_numero() {
        celular = Fixture.from(Celular.class).gimme("comCaractereInvalidoNumero");
        assertTrue(verificaErro(celular, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        celular = Fixture.from(Celular.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(verificaErro(celular, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_numero() {
        celular = Fixture.from(Celular.class).gimme("semCaractereInvalidoNumero");
        assertFalse(verificaErro(celular, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    //tipoContatoCelular
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoContatoCelular() {
        celular.setTipoContatoCelular(null);
        assertTrue(verificaErro(celular, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoContatoCelular() {
        celular.setTipoContatoCelular(TipoContatoCelular.APENAS_LIGACAO);
        assertFalse(verificaErro(celular, MensagensErro.VALOR_NULO));
    }
    
    //getter e setter    
    
    @Test
    public void getDdd_deve_trazer_o_valor_armazenado_em_ddd() {
        celular.setDdd("45");
        assertThat(celular.getDdd(), is(equalTo("45")));
    }
    
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        celular.setNumero("908004444");
        assertThat(celular.getNumero(), is(equalTo("908004444")));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Celular.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Celular.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"00", "900000000", TipoContatoCelular.APENAS_LIGACAO};
        assertTrue(verificaConstrutor(celular, valores, String.class, String.class, TipoContatoCelular.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_ddd_numero_igual() {
        outroCelular.setDdd(celular.getDdd());
        outroCelular.setNumero(celular.getNumero());
        assertThat(celular.hashCode(), is(equalTo(outroCelular.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_igual_numero_diferente() {
        outroCelular.setDdd(celular.getDdd());
        assertThat(celular.hashCode(), is(not(equalTo(outroCelular.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_diferente_numero_igual() {
        outroCelular.setNumero(celular.getNumero());
        assertThat(celular.hashCode(), is(not(equalTo(outroCelular.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_diferente_numero_diferente() {
        assertThat(celular.hashCode(), is(not(equalTo(outroCelular.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_ddd_numero_igual() {
        outroCelular.setDdd(celular.getDdd());
        outroCelular.setNumero(celular.getNumero());
        assertTrue(celular.equals(outroCelular));
    }
    
    @Test
    public void equals_deve_retornar_false_com_ddd_igual_numero_diferente() {
        outroCelular.setDdd(celular.getDdd());
        assertFalse(celular.equals(outroCelular));
    }
    
    @Test
    public void equals_deve_retornar_false_com_ddd_diferente_numero_igual() {
        outroCelular.setNumero(celular.getNumero());
        assertFalse(celular.equals(outroCelular));
    }
    
    @Test
    public void equals_deve_retornar_false_com_ddd_diferente_numero_diferente() {
        assertFalse(celular.equals(outroCelular));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Celular.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_ddd_no_texto_gerado_pelo_metodo_toString() {
        celular.setDdd("45");
        assertTrue(celular.toString().contains("45"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        celular.setNumero("908004444");
        assertTrue(celular.toString().contains("908004444"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(celular));
    }
    
}
