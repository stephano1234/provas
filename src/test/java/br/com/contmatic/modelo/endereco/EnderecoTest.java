package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.VerificadoresRegras.verificaConstrutor;
import static br.com.contmatic.utilidades.VerificadoresRegras.verificaErro;
import static br.com.contmatic.utilidades.VerificadoresRegras.verificaToStringJSONSTYLE;
import static br.com.contmatic.utilidades.VerificadoresRegras.procuraAlgumErro;

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
import br.com.contmatic.modelo.endereco.TelefoneFixo;
import br.com.contmatic.modelo.endereco.TipoEndereco;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.LogradouroTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.TelefoneFixoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class EnderecoTest {

    private Endereco endereco;
    
    private Endereco outroEndereco;
    
    private Logradouro logradouro;
    
    private TelefoneFixo telefoneFixo;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new EnderecoTemplateFixtureFactory().load();
        new LogradouroTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        endereco = Fixture.from(Endereco.class).gimme("valido");
        outroEndereco = Fixture.from(Endereco.class).gimme("outroValido");
        logradouro = Fixture.from(Logradouro.class).gimme("valido");
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //cep
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cep() {
        endereco.setCep(null);
        assertTrue(verificaErro(endereco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("naoNuloCep");
        assertFalse(verificaErro(endereco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("maiorTamanhoCep");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("menorIgualTamanhoCep");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_MAX));
    }

    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("menorTamanhoCep");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_MIN));
    }
    
    @Test
    public void deve_aceitar_valor_maior_ou_igual_que_tamanho_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("maiorIgualTamanhoCep");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_MIN));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("comCaractereInvalidoCep");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoCep");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("semCaractereInvalidoCep");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }

    //numero
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        endereco.setNumero("");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("naoVazioNumero");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("maiorTamanhoNumero");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("menorIgualTamanhoNumero");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("comCaractereInvalidoNumero");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("semCaractereInvalidoNumero");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    //complemento
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_complemento() {
        endereco.setComplemento("");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("naoVazioComplemento");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("maiorTamanhoComplemento");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("menorIgualTamanhoComplemento");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("somenteEspacoComplemento");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_caractere_nao_espaco_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("comNaoEspacoComplemento");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_com_um_caractere_nao_espaco_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("comUmNaoEspacoComplemento");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_APENAS_ESPACO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("comCaractereInvalidoComplemento");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoComplemento");
        assertTrue(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("semCaractereInvalidoComplemento");
        assertFalse(verificaErro(endereco, MensagensErro.STRING_INVALIDO));
    }
    
    //logradouro
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_logradouro() {
        endereco.setLogradouro(null);
        assertTrue(verificaErro(endereco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_logradouro() {
        endereco.setLogradouro(logradouro);
        assertFalse(verificaErro(endereco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_logradouro_invalido() {
        endereco.setLogradouro(Fixture.from(Logradouro.class).gimme("comUmCaractereInvalidoNome"));
        assertTrue(procuraAlgumErro(endereco));
    }
    
    @Test
    public void deve_aceitar_logradouro_valido() {
        endereco.setLogradouro(logradouro);
        assertFalse(procuraAlgumErro(endereco));
    }
    
    //telefoneFixo
    
    @Test
    public void nao_deve_aceitar_telefoneFixo_invalido() {
        endereco.setTelefoneFixo(Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero"));
        assertTrue(procuraAlgumErro(endereco));
    }
    
    @Test
    public void deve_aceitar_telefoneFixo_valido() {
        endereco.setTelefoneFixo(telefoneFixo);
        assertFalse(procuraAlgumErro(endereco));
    }
    
    //tipoEndereco
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoEndereco() {
        endereco.setTipoEndereco(null);
        assertTrue(verificaErro(endereco, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoEndereco() {
        endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
        assertFalse(verificaErro(endereco, MensagensErro.VALOR_NULO));
    }
    
    //getter e setter    
    
    @Test
    public void getCep_deve_trazer_o_valor_armazenado_em_cep() {
        endereco.setCep("22223333");
        assertThat(endereco.getCep(), is(equalTo("22223333")));
    }
    
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        endereco.setNumero("701");
        assertThat(endereco.getNumero(), is(equalTo("701")));
    }
    
    @Test
    public void getComplemento_deve_trazer_o_valor_armazenado_em_complemento() {
        endereco.setComplemento("LADO B");
        assertThat(endereco.getComplemento(), is(equalTo("LADO B")));
    }
    
    @Test
    public void getLogradouro_deve_trazer_o_valor_armazenado_em_logradouro() {
        endereco.setLogradouro(logradouro);
        assertThat(endereco.getLogradouro(), is(equalTo(logradouro)));
    }
    
    @Test
    public void getTelefoneFixo_deve_trazer_o_valor_armazenado_em_telefoneFixo() {
        endereco.setTelefoneFixo(telefoneFixo);
        assertThat(endereco.getTelefoneFixo(), is(equalTo(telefoneFixo)));
    }
    
    @Test
    public void getTipoEndereco_deve_trazer_o_valor_armazenado_em_tipoEndereco() {
        endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
        assertThat(endereco.getTipoEndereco(), is(equalTo(TipoEndereco.COMERCIAL)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Endereco.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Endereco.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"21210090", "340", logradouro, TipoEndereco.COMERCIAL};
        assertTrue(verificaConstrutor(endereco, valores, String.class, String.class, Logradouro.class, TipoEndereco.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_cep_numero_logradouro_igual() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(equalTo(outroEndereco.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_numero_igual_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_logradouro_igual_numero_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_igual_numero_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_cep_logradouro_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_logradouro_igual_cep_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_logradouro_igual_cep_numero_diferente() {
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_numero_logradouro_diferente() {
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_cep_numero_logradouro_igual() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertTrue(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_cep_numero_igual_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_cep_logradouro_igual_numero_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_cep_igual_numero_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_igual_cep_logradouro_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_logradouro_igual_cep_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_logradouro_igual_cep_numero_diferente() {
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void equals_deve_retornar_false_com_cep_numero_logradouro_diferente() {
        assertFalse(endereco.equals(outroEndereco));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Endereco.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cep_no_texto_gerado_pelo_metodo_toString() {
        endereco.setCep("22223333");
        assertTrue(endereco.toString().contains("22223333"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        endereco.setNumero("701");
        assertTrue(endereco.toString().contains("701"));
    }
    
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_numero_nulo() {
        endereco.setNumero(null);
        assertTrue(endereco.toString().contains("Sem n\\u00FAmero"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_complemento_no_texto_gerado_pelo_metodo_toString() {
        endereco.setComplemento("CASA");
        assertTrue(endereco.toString().contains("CASA"));
    }
    
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_complemento_nulo() {
        endereco.setComplemento(null);
        assertTrue(endereco.toString().contains("Sem informa\\u00E7\\u00F5es adicionais do endere\\u00E7o"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_logradouro_no_texto_gerado_pelo_metodo_toString() {
        endereco.setLogradouro(logradouro);
        assertTrue(endereco.toString().contains(logradouro.toString()));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_telefoneFixo_no_texto_gerado_pelo_metodo_toString() {
        endereco.setTelefoneFixo(telefoneFixo);
        assertTrue(endereco.toString().contains(telefoneFixo.toString()));
    }
    
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_telefoneFixo_nulo() {
        endereco.setTelefoneFixo(null);
        assertTrue(endereco.toString().contains("Sem telefone fixo atrelado a este endere\\u00E7o"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoEndereco_no_texto_gerado_pelo_metodo_toString() {
        endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
        assertTrue(endereco.toString().contains(TipoEndereco.COMERCIAL.name()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(endereco));
    }
    
}
