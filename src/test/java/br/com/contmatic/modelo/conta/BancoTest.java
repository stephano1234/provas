package br.com.contmatic.modelo.conta;

import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaErro;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;

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

import br.com.contmatic.modelo.conta.Banco;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.banco.BancoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class BancoTest {
    
    private Banco banco;
    
    private Banco outroBanco;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new BancoTemplateFixtureFactory().load();      
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        banco = Fixture.from(Banco.class).gimme("valido");
        outroBanco = Fixture.from(Banco.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //codigo
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_codigo() {
        banco.setCodigo(null);
        assertTrue(verificaErro(banco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("naoNuloCodigo");
        assertFalse(verificaErro(banco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_codigo() {
        banco.setCodigo("");
        assertTrue(verificaErro(banco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("naoVazioCodigo");
        assertFalse(verificaErro(banco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("maiorTamanhoCodigo");
        assertTrue(verificaErro(banco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("menorIgualTamanhoCodigo");
        assertFalse(verificaErro(banco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("comCaractereInvalidoCodigo");
        assertTrue(verificaErro(banco, MensagensErro.STRING_COM_ESPACO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("comUmCaractereInvalidoCodigo");
        assertTrue(verificaErro(banco, MensagensErro.STRING_COM_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_codigo() {
        banco = Fixture.from(Banco.class).gimme("semCaractereInvalidoCodigo");
        assertFalse(verificaErro(banco, MensagensErro.STRING_COM_ESPACO));
    }
    
    //nome
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        banco.setNome(null);
        assertTrue(verificaErro(banco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_nome() {
        banco = Fixture.from(Banco.class).gimme("naoNuloNome");
        assertFalse(verificaErro(banco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
        banco.setNome("");
        assertTrue(verificaErro(banco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_nome() {
        banco = Fixture.from(Banco.class).gimme("naoVazioNome");
        assertFalse(verificaErro(banco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        banco = Fixture.from(Banco.class).gimme("maiorTamanhoNome");
        assertTrue(verificaErro(banco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_nome() {
        banco = Fixture.from(Banco.class).gimme("menorIgualTamanhoNome");
        assertFalse(verificaErro(banco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        banco = Fixture.from(Banco.class).gimme("apenasEspacoNome");
        System.out.println(banco);
        assertTrue(verificaErro(banco, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_caractere_nao_espaco_no_nome() {
        banco = Fixture.from(Banco.class).gimme("naoApenasEspacoNome");
        assertFalse(verificaErro(banco, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_um_caractere_nao_espaco_no_nome() {
        banco = Fixture.from(Banco.class).gimme("umNaoEspacoNome");
        assertFalse(verificaErro(banco, MensagensErro.STRING_APENAS_ESPACO));
    }

    //getter e setter    
    
    @Test
    public void getCodigo_deve_trazer_o_valor_armazenado_em_nome() {
        banco.setCodigo("655");
        assertThat(banco.getCodigo(), is(equalTo("655")));
    }
    
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        banco.setNome("Banco Votorantim S.A.");
        assertThat(banco.getNome(), is(equalTo("Banco Votorantim S.A.")));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Banco.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Banco.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"340", "Banco Salvador S.A."};
        assertTrue(verificaConstrutor(banco, valores, String.class, String.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_codigo_igual() {
        outroBanco.setCodigo(banco.getCodigo());
        assertThat(banco.hashCode(), is(equalTo(outroBanco.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_codigo_diferente() {
        assertThat(banco.hashCode(), is(not(equalTo(outroBanco.hashCode()))));
    }
    
    @Test
    public void equals_deve_retornar_true_com_codigo_igual() {
        outroBanco.setCodigo(banco.getCodigo());
        assertTrue(banco.equals(outroBanco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_codigo_diferente() {
        assertFalse(banco.equals(outroBanco));
    }
        
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Banco.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_codigo_no_texto_gerado_pelo_metodo_toString() {
        banco.setCodigo("655");
        assertTrue(banco.toString().contains("655"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        banco.setNome("Banco Votorantim S.A.");
        assertTrue(banco.toString().contains("Banco Votorantim S.A."));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(banco));
    }
    
}
