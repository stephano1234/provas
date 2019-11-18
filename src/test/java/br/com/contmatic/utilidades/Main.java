package br.com.contmatic.utilidades;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.contmatic.modelo.conta.Agencia;
import br.com.contmatic.modelo.conta.Banco;
import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.conta.TipoConta;
import br.com.contmatic.modelo.conta.TodosBancoTest;
import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.modelo.endereco.TipoUf;
import br.com.contmatic.modelo.endereco.TodosEnderecoTest;
import br.com.contmatic.utilidades.VerificadoresRegras;

//import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Conta("12345", new Agencia("1234", new Banco("123", "BVAAA")), TipoConta.CONTA_CORRENTE));
        try {
            Banco banco = new Banco("123", "       ");
            assertTrue(!VerificadoresRegras.procuraAlgumErro(banco));
            System.out.println(banco);
        } catch (AssertionError e) {
            System.out.println("nao armazenou");
        }
        for (int i = 0; i < 1; i++) {
          
            System.out.println(RandomizadorStringExpressaoRegular.comUmCaractereInvalido(50, ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }
    }
    
    @Test
    public void verifica_erro_na_repeticao_dos_testes() {
        for (int i = 0; i < ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS; i++) {
            Result resultado = JUnitCore.runClasses(TodosBancoTest.class, TodosEnderecoTest.class);
            for (Failure falha : resultado.getFailures()) {
                System.out.println(falha.toString());
            }
            assertTrue(resultado.wasSuccessful());
        }
    }

    @Test
    public void testestostring() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Bairro b = new Bairro("Õ", new Cidade("õ", TipoUf.AC));
        System.out.println(b);
        //Cidade ci = new Cidade("a", TipoUf.AC);
        //System.out.println(ci);
        assertTrue(VerificadoresRegras.verificaToStringJSONSTYLE(b));
    }
}
