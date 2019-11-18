package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.VerificadoresRegras.verificaErro;
import static br.com.contmatic.utilidades.VerificadoresRegras.verificaToStringJSONSTYLE;
import static br.com.contmatic.utilidades.VerificadoresRegras.procuraAlgumErro;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.endereco.BairroTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.CidadeTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class BairroTest {
    
    private Bairro bairro;
    
    private Bairro outroBairro;
    
    private Cidade cidade;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new BairroTemplateFixtureFactory().load();
        new CidadeTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        bairro = Fixture.from(Bairro.class).gimme("valido");
        outroBairro = Fixture.from(Bairro.class).gimme("outroValido");
        cidade = Fixture.from(Cidade.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //nome
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        bairro.setNome(null);
        assertTrue(verificaErro(bairro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("naoNuloNome");
        assertFalse(verificaErro(bairro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
        bairro.setNome("");
        assertTrue(verificaErro(bairro, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("naoVazioNome");
        assertFalse(verificaErro(bairro, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("maiorTamanhoNome");
        assertTrue(verificaErro(bairro, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("menorIgualTamanhoNome");
        assertFalse(verificaErro(bairro, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("somenteEspacoNome");
        assertTrue(verificaErro(bairro, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_caractere_nao_espaco_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comNaoEspacoNome");
        assertFalse(verificaErro(bairro, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_um_caractere_nao_espaco_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comUmNaoEspacoNome");
        assertFalse(verificaErro(bairro, MensagensErro.STRING_APENAS_ESPACO));
    }

    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comCaractereInvalidoNome");
        assertTrue(verificaErro(bairro, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(verificaErro(bairro, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("semCaractereInvalidoNome");
        assertFalse(verificaErro(bairro, MensagensErro.STRING_INVALIDO));
    }
    
    //cidade
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cidade() {
        bairro.setCidade(null);
        assertTrue(verificaErro(bairro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_cidade() {
        bairro.setCidade(cidade);
        assertFalse(verificaErro(bairro, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_cidade_invalido() {
        bairro.setCidade(Fixture.from(Cidade.class).gimme("comUmCaractereInvalidoNome"));
        assertTrue(procuraAlgumErro(bairro));
    }
    
    @Test
    public void deve_aceitar_cidade_valido() {
        bairro.setCidade(cidade);
        assertFalse(procuraAlgumErro(bairro));
    }
    
    //getter e setter    
    
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        bairro.setNome("Pompéia");
        assertThat(bairro.getNome(), is(equalTo("Pompéia")));
    }
    
    @Test
    public void getCidade_deve_trazer_o_valor_armazenado_em_cidade() {
        bairro.setCidade(cidade);
        assertThat(bairro.getCidade(), is(equalTo(cidade)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Bairro.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Bairro.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void deve_haver_construtor_publico_com_argumento_do_tipo_String_Cidade() {
        try {
            Bairro.class.getDeclaredConstructor(String.class, Cidade.class).newInstance("Pompéia", cidade);
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            fail();
        }
    }
    
    @Test
    public void o_construtor_deve_alimentar_o_nome_da_nova_instancia() {
        try {
            assertThat(Bairro.class.getDeclaredConstructor(String.class, Cidade.class).newInstance("Pompéia", cidade).getNome(), is(equalTo("Pompéia")));
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            fail();
        }
    }
    
    @Test
    public void o_construtor_deve_alimentar_o_cidade_da_nova_instancia() {
        try {
            assertThat(Bairro.class.getDeclaredConstructor(String.class, Cidade.class).newInstance("São João", cidade).getCidade(), is(equalTo(cidade)));
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            fail();
        }
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_nome_cidade_igual() {
        outroBairro.setNome(bairro.getNome());
        outroBairro.setCidade(bairro.getCidade());
        assertThat(bairro.hashCode(), is(equalTo(outroBairro.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_igual_cidade_diferente() {
        outroBairro.setNome(bairro.getNome());
        assertThat(bairro.hashCode(), is(not(equalTo(outroBairro.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_cidade_igual() {
        outroBairro.setCidade(bairro.getCidade());
        assertThat(bairro.hashCode(), is(not(equalTo(outroBairro.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_cidade_diferente() {
        assertThat(bairro.hashCode(), is(not(equalTo(outroBairro.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_nome_cidade_igual() {
        outroBairro.setNome(bairro.getNome());
        outroBairro.setCidade(bairro.getCidade());
        assertTrue(bairro.equals(outroBairro));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_igual_cidade_diferente() {
        outroBairro.setNome(bairro.getNome());
        assertFalse(bairro.equals(outroBairro));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_cidade_igual() {
        outroBairro.setCidade(bairro.getCidade());
        assertFalse(bairro.equals(outroBairro));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_cidade_diferente() {
        assertFalse(bairro.equals(outroBairro));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Bairro.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        bairro.setNome("Lapa");
        assertTrue(bairro.toString().contains("Lapa"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cidade_no_texto_gerado_pelo_metodo_toString() {
        bairro.setCidade(cidade);
        assertTrue(bairro.toString().contains(cidade.toString()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(bairro));
    }
    
}