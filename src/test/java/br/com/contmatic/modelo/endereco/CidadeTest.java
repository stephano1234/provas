package br.com.contmatic.modelo.endereco;

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

import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.endereco.CidadeTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class CidadeTest {
    
    private Cidade cidade;
    
    private Cidade outroCidade;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new CidadeTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        cidade = Fixture.from(Cidade.class).gimme("valido");
        outroCidade = Fixture.from(Cidade.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //nome
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        cidade.setNome(null);
        assertTrue(verificaErro(cidade, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("naoNuloNome");
        assertFalse(verificaErro(cidade, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
        cidade.setNome("");
        assertTrue(verificaErro(cidade, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("naoVazioNome");
        assertFalse(verificaErro(cidade, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("maiorTamanhoNome");
        assertTrue(verificaErro(cidade, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("menorIgualTamanhoNome");
        assertFalse(verificaErro(cidade, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("somenteEspacoNome");
        assertTrue(verificaErro(cidade, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_caractere_nao_espaco_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comNaoEspacoNome");
        assertFalse(verificaErro(cidade, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_um_caractere_nao_espaco_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comUmNaoEspacoNome");
        assertFalse(verificaErro(cidade, MensagensErro.STRING_APENAS_ESPACO));
    }

    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comCaractereInvalidoNome");
        assertTrue(verificaErro(cidade, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(verificaErro(cidade, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("semCaractereInvalidoNome");
        assertFalse(verificaErro(cidade, MensagensErro.STRING_INVALIDO));
    }
    
    //tipoUf
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoUf() {
        cidade.setTipoUf(null);
        assertTrue(verificaErro(cidade, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoUf() {
        cidade.setTipoUf(TipoUf.AC);
        assertFalse(verificaErro(cidade, MensagensErro.VALOR_NULO));
    }
    
    //getter e setter    
    
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        cidade.setNome("São João");
        assertThat(cidade.getNome(), is(equalTo("São João")));
    }
    
    @Test
    public void getTipoUf_deve_trazer_o_valor_armazenado_em_tipoUf() {
        cidade.setTipoUf(TipoUf.AC);
        assertThat(cidade.getTipoUf(), is(equalTo(TipoUf.AC)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Cidade.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Cidade.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"Goiania", TipoUf.AC};
        assertTrue(verificaConstrutor(cidade, valores, String.class, TipoUf.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_nome_tipoUf_igual() {
        outroCidade.setNome(cidade.getNome());
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertThat(cidade.hashCode(), is(equalTo(outroCidade.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_igual_tipoUf_diferente() {
        outroCidade.setNome(cidade.getNome());
        assertThat(cidade.hashCode(), is(not(equalTo(outroCidade.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_tipoUf_igual() {
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertThat(cidade.hashCode(), is(not(equalTo(outroCidade.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_tipoUf_diferente() {
        assertThat(cidade.hashCode(), is(not(equalTo(outroCidade.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_nome_tipoUf_igual() {
        outroCidade.setNome(cidade.getNome());
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertTrue(cidade.equals(outroCidade));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_igual_tipoUf_diferente() {
        outroCidade.setNome(cidade.getNome());
        assertFalse(cidade.equals(outroCidade));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_tipoUf_igual() {
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertFalse(cidade.equals(outroCidade));
    }
    
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_tipoUf_diferente() {
        assertFalse(cidade.equals(outroCidade));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Cidade.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        cidade.setNome("Rio Claro");
        assertTrue(cidade.toString().contains("Rio Claro"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoUf_no_texto_gerado_pelo_metodo_toString() {
        cidade.setTipoUf(TipoUf.AC);
        assertTrue(cidade.toString().contains("AC"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(cidade));
    }
    
}
