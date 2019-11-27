package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaErro;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;
import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;

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

import br.com.contmatic.modelo.endereco.Logradouro;
import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.endereco.LogradouroTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.BairroTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class LogradouroTest {
    
    private Logradouro logradouro;
    
    private Logradouro outroLogradouro;
    
    private Bairro bairro;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new LogradouroTemplateFixtureFactory().load();
        new BairroTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        logradouro = Fixture.from(Logradouro.class).gimme("valido");
        outroLogradouro = Fixture.from(Logradouro.class).gimme("outroValido");
        bairro = Fixture.from(Bairro.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //nome
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        logradouro.setNome(null);
        assertTrue(verificaErro(logradouro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("naoNuloNome");
        assertFalse(verificaErro(logradouro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
        logradouro.setNome("");
        assertTrue(verificaErro(logradouro, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("naoVazioNome");
        assertFalse(verificaErro(logradouro, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("maiorTamanhoNome");
        assertTrue(verificaErro(logradouro, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("menorIgualTamanhoNome");
        assertFalse(verificaErro(logradouro, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("apenasEspacoNome");
        assertTrue(verificaErro(logradouro, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_caractere_nao_espaco_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("naoApenasEspacoNome");
        assertFalse(verificaErro(logradouro, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_um_caractere_nao_espaco_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("umNaoEspacoNome");
        assertFalse(verificaErro(logradouro, MensagensErro.STRING_APENAS_ESPACO));
    }

    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("comCaractereInvalidoNome");
        assertTrue(verificaErro(logradouro, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(verificaErro(logradouro, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_nome() {
        logradouro = Fixture.from(Logradouro.class).gimme("semCaractereInvalidoNome");
        assertFalse(verificaErro(logradouro, MensagensErro.STRING_CARACTERE_ESPECIAL));
    }
    
    //bairro
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_bairro() {
        logradouro.setBairro(null);
        assertTrue(verificaErro(logradouro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_bairro() {
        logradouro.setBairro(bairro);
        assertFalse(verificaErro(logradouro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_bairro_invalido() {
        logradouro.setBairro(Fixture.from(Bairro.class).gimme("comUmCaractereInvalidoNome"));
        assertTrue(procuraAlgumErro(logradouro));
    }
    
    @Test
    public void deve_aceitar_bairro_valido() {
        logradouro.setBairro(bairro);
        assertFalse(procuraAlgumErro(logradouro));
    }
    
    //getter e setter    
    
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        logradouro.setNome("Rua Maria José Cruz");
        assertThat(logradouro.getNome(), is(equalTo("Rua Maria José Cruz")));
    }
    
    @Test
    public void getBairro_deve_trazer_o_valor_armazenado_em_bairro() {
        logradouro.setBairro(bairro);
        assertThat(logradouro.getBairro(), is(equalTo(bairro)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Logradouro.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Logradouro.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"Rua Calimã", bairro};
        assertTrue(verificaConstrutor(logradouro, valores, String.class, Bairro.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_nome_bairro_igual() {
        outroLogradouro.setNome(logradouro.getNome());
        outroLogradouro.setBairro(logradouro.getBairro());
        assertThat(logradouro.hashCode(), is(equalTo(outroLogradouro.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_igual_bairro_diferente() {
        outroLogradouro.setNome(logradouro.getNome());
        assertThat(logradouro.hashCode(), is(not(equalTo(outroLogradouro.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_bairro_igual() {
        outroLogradouro.setBairro(logradouro.getBairro());
        assertThat(logradouro.hashCode(), is(not(equalTo(outroLogradouro.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_bairro_diferente() {
        assertThat(logradouro.hashCode(), is(not(equalTo(outroLogradouro.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_nome_bairro_igual() {
        outroLogradouro.setNome(logradouro.getNome());
        outroLogradouro.setBairro(logradouro.getBairro());
        assertTrue(logradouro.equals(outroLogradouro));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_igual_bairro_diferente() {
        outroLogradouro.setNome(logradouro.getNome());
        assertFalse(logradouro.equals(outroLogradouro));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_bairro_igual() {
        outroLogradouro.setBairro(logradouro.getBairro());
        assertFalse(logradouro.equals(outroLogradouro));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_bairro_diferente() {
        assertFalse(logradouro.equals(outroLogradouro));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Logradouro.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        logradouro.setNome("Avenida 9 de Julho");
        assertTrue(logradouro.toString().contains("Avenida 9 de Julho"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_bairro_no_texto_gerado_pelo_metodo_toString() {
        logradouro.setBairro(bairro);
        assertTrue(logradouro.toString().contains(bairro.toString()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(logradouro));
    }
    
}