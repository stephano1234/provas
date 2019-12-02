package br.com.contmatic.modelo.conta;

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

import br.com.contmatic.modelo.conta.Agencia;
import br.com.contmatic.modelo.conta.Banco;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.conta.AgenciaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.conta.BancoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class AgenciaTest {
    
    private Agencia agencia;
    
    private Agencia outroAgencia;
    
    private Banco banco;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new AgenciaTemplateFixtureFactory().load();
        new BancoTemplateFixtureFactory().load();     
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        agencia = Fixture.from(Agencia.class).gimme("valido");
        outroAgencia = Fixture.from(Agencia.class).gimme("outroValido");
        banco = Fixture.from(Banco.class).gimme("valido");
        
    }

    @After
    public void tearDown() throws Exception {
    }

    //numero
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        agencia.setNumero(null);
        assertTrue(verificaErro(agencia, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("naoNuloNumero");
        assertFalse(verificaErro(agencia, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        agencia.setNumero("");
        assertTrue(verificaErro(agencia, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("naoVazioNumero");
        assertFalse(verificaErro(agencia, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("maiorTamanhoNumero");
        assertTrue(verificaErro(agencia, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("menorIgualTamanhoNumero");
        assertFalse(verificaErro(agencia, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("comCaractereInvalidoNumero");
        assertTrue(verificaErro(agencia, MensagensErro.STRING_COM_ESPACO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(verificaErro(agencia, MensagensErro.STRING_COM_ESPACO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("semCaractereInvalidoNumero");
        assertFalse(verificaErro(agencia, MensagensErro.STRING_COM_ESPACO));
    }

    //banco
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_banco() {
        agencia.setBanco(null);
        assertTrue(verificaErro(agencia, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_banco() {
        agencia.setBanco(banco);
        assertFalse(verificaErro(agencia, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_banco_invalido() {
        agencia.setBanco(Fixture.from(Banco.class).gimme("comUmCaractereInvalidoCodigo"));
        assertTrue(procuraAlgumErro(agencia));
    }
    
    @Test
    public void deve_aceitar_banco_valido() {
        agencia.setBanco(banco);
        assertFalse(procuraAlgumErro(agencia));
    }
    
    //getter e setter    
    
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        agencia.setNumero("2244");
        assertThat(agencia.getNumero(), is(equalTo("2244")));
    }
    
    @Test
    public void getBanco_deve_trazer_o_valor_armazenado_em_banco() {
        agencia.setBanco(banco);
        assertThat(agencia.getBanco(), is(equalTo(banco)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Agencia.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Agencia.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"1223", banco};
        assertTrue(verificaConstrutor(agencia, valores, String.class, Banco.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_numero_banco_igual() {
        outroAgencia.setNumero(agencia.getNumero());
        outroAgencia.setBanco(agencia.getBanco());
        assertThat(agencia.hashCode(), is(equalTo(outroAgencia.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_banco_diferente() {
        outroAgencia.setNumero(agencia.getNumero());
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_diferente_banco_igual() {
        outroAgencia.setBanco(agencia.getBanco());
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_banco_diferente() {
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    @Test
    public void equals_deve_retornar_true_com_numero_banco_igual() {
        outroAgencia.setNumero(agencia.getNumero());
        outroAgencia.setBanco(agencia.getBanco());
        assertTrue(agencia.equals(outroAgencia));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_igual_banco_diferente() {
        outroAgencia.setNumero(agencia.getNumero());
        assertFalse(agencia.equals(outroAgencia));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_diferente_banco_igual() {
        outroAgencia.setBanco(agencia.getBanco());
        assertFalse(agencia.equals(outroAgencia));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_banco_diferente() {
        assertFalse(agencia.equals(outroAgencia));
    }
        
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Agencia.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        agencia.setNumero("2244");
        assertTrue(agencia.toString().contains("2244"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_banco_no_texto_gerado_pelo_metodo_toString() {
        agencia.setBanco(banco);
        assertTrue(agencia.toString().contains(banco.toString()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(agencia));
    }
    
}
