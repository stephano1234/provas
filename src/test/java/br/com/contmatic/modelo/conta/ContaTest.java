package br.com.contmatic.modelo.conta;

import static br.com.contmatic.utilidades.VerificadoresRegras.verificaErro;
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

import br.com.contmatic.modelo.conta.Agencia;
import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.conta.TipoConta;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.banco.ContaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.banco.AgenciaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class ContaTest {

    private Conta conta;
    
    private Conta outroConta;
    
    private Agencia agencia;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new ContaTemplateFixtureFactory().load();
        new AgenciaTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        conta = Fixture.from(Conta.class).gimme("valido");
        outroConta = Fixture.from(Conta.class).gimme("outroValido");
        agencia = Fixture.from(Agencia.class).gimme("valido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //numero
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        conta.setNumero(null);
        assertTrue(verificaErro(conta, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_numero() {
        conta = Fixture.from(Conta.class).gimme("naoNuloNumero");
        assertFalse(verificaErro(conta, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        conta.setNumero("");
        assertTrue(verificaErro(conta, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_vazio_no_numero() {
        conta = Fixture.from(Conta.class).gimme("naoVazioNumero");
        assertFalse(verificaErro(conta, MensagensErro.STRING_VAZIO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        conta = Fixture.from(Conta.class).gimme("maiorTamanhoNumero");
        assertTrue(verificaErro(conta, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void deve_aceitar_valor_menor_ou_igual_que_tamanho_no_numero() {
        conta = Fixture.from(Conta.class).gimme("menorIgualTamanhoNumero");
        assertFalse(verificaErro(conta, MensagensErro.STRING_MAX));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_numero() {
        conta = Fixture.from(Conta.class).gimme("comCaractereInvalidoNumero");
        assertTrue(verificaErro(conta, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        conta = Fixture.from(Conta.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(verificaErro(conta, MensagensErro.STRING_INVALIDO));
    }
    
    @Test
    public void deve_aceitar_valor_sem_caractere_invalido_no_numero() {
        conta = Fixture.from(Conta.class).gimme("semCaractereInvalidoNumero");
        assertFalse(verificaErro(conta, MensagensErro.STRING_INVALIDO));
    }

    //agencia
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_agencia() {
        conta.setAgencia(null);
        assertTrue(verificaErro(conta, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_agencia() {
        conta.setAgencia(agencia);
        assertFalse(verificaErro(conta, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_agencia_invalido() {
        conta.setAgencia(Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoNumero"));
        assertTrue(procuraAlgumErro(conta));
    }
    
    @Test
    public void deve_aceitar_agencia_valido() {
        conta.setAgencia(agencia);
        assertFalse(procuraAlgumErro(conta));
    }
    
    //tipoConta
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoConta() {
        conta.setTipoConta(null);
        assertTrue(verificaErro(conta, MensagensErro.VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoConta() {
        conta.setTipoConta(TipoConta.CONTA_CORRENTE);
        assertFalse(verificaErro(conta, MensagensErro.VALOR_NULO));
    }
    
    //getter e setter    
    
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        conta.setNumero("1234567");
        assertThat(conta.getNumero(), is(equalTo("1234567")));
    }
    
    @Test
    public void getAgencia_deve_trazer_o_valor_armazenado_em_agencia() {
        conta.setAgencia(agencia);
        assertThat(conta.getAgencia(), is(equalTo(agencia)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Conta.class).testing(Method.GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Conta.class).testing(Method.SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void deve_haver_construtor_publico_com_argumento_do_tipo_String_Agencia() {
        try {
            Conta.class.getDeclaredConstructor(String.class, Agencia.class, TipoConta.class).newInstance("1234567", agencia, TipoConta.CONTA_CORRENTE);
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            fail();
        }
    }
    
    @Test
    public void o_construtor_deve_alimentar_o_numero_da_nova_instancia() {
        try {
            assertThat(Conta.class.getDeclaredConstructor(String.class, Agencia.class, TipoConta.class).newInstance("1234567", agencia, TipoConta.CONTA_CORRENTE).getNumero(), is(equalTo("1234567")));
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            fail();
        }
    }
    
    @Test
    public void o_construtor_deve_alimentar_o_agencia_da_nova_instancia() {
        try {
            assertThat(Conta.class.getDeclaredConstructor(String.class, Agencia.class, TipoConta.class).newInstance("1234567", agencia, TipoConta.CONTA_CORRENTE).getAgencia(), is(equalTo(agencia)));
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            fail();
        }
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_numero_agencia_igual() {
        outroConta.setNumero(conta.getNumero());
        outroConta.setAgencia(conta.getAgencia());
        assertThat(conta.hashCode(), is(equalTo(outroConta.hashCode())));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_agencia_diferente() {
        outroConta.setNumero(conta.getNumero());
        assertThat(conta.hashCode(), is(not(equalTo(outroConta.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_diferente_agencia_igual() {
        outroConta.setAgencia(conta.getAgencia());
        assertThat(conta.hashCode(), is(not(equalTo(outroConta.hashCode()))));
    }
    
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_agencia_diferente() {
        assertThat(conta.hashCode(), is(not(equalTo(outroConta.hashCode()))));
    }
    
    @Test
    public void equals_deve_retornar_true_com_numero_agencia_igual() {
        outroConta.setNumero(conta.getNumero());
        outroConta.setAgencia(conta.getAgencia());
        assertTrue(conta.equals(outroConta));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_igual_agencia_diferente() {
        outroConta.setNumero(conta.getNumero());
        assertFalse(conta.equals(outroConta));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_diferente_agencia_igual() {
        outroConta.setAgencia(conta.getAgencia());
        assertFalse(conta.equals(outroConta));
    }
    
    @Test
    public void equals_deve_retornar_false_com_numero_agencia_diferente() {
        assertFalse(conta.equals(outroConta));
    }
        
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Conta.class).suppress(Warning.NONFINAL_FIELDS, Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        conta.setNumero("1234567");
        assertTrue(conta.toString().contains("1234567"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_agencia_no_texto_gerado_pelo_metodo_toString() {
        conta.setAgencia(agencia);
        assertTrue(conta.toString().contains(agencia.toString()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        StringBuilder formatoEsperado = new StringBuilder();
        assertThat(conta.toString().charAt(0), is(equalTo('{')));
        for (int i = 0; i < Conta.class.getDeclaredFields().length; i++) {      
            formatoEsperado.append("\"").append(Conta.class.getDeclaredFields()[i].getName()).append("\":");         
            assertTrue(conta.toString().contains(formatoEsperado.toString()));
            formatoEsperado.delete(0, formatoEsperado.length());          
            formatoEsperado.append(",");
        }
        assertThat(conta.toString().charAt(conta.toString().length() - 1), is(equalTo('}')));
    }
    
}
