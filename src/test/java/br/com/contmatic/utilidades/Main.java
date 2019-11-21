package br.com.contmatic.utilidades;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.contmatic.modelo.conta.TodosBancoTest;
import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.modelo.endereco.TipoUf;
import br.com.contmatic.modelo.endereco.TodosEnderecoTest;
import br.com.contmatic.modelo.pessoa.Celular;
import br.com.contmatic.modelo.pessoa.Email;
import br.com.contmatic.modelo.pessoa.TipoContatoCelular;
import br.com.contmatic.utilidades.VerificadoresRegras;

//import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;

public class Main {

    public static void main(String[] args) {
        Set<Email> s = new HashSet<Email>();
        Set<Celular> c = new HashSet<Celular>();
        c.add(new Celular("21", "111111111", TipoContatoCelular.APENAS_LIGACAO));
        c.add(new Celular("21", "111141111", TipoContatoCelular.APENAS_LIGACAO));
        s.add(new Email("lalala@gmail.com"));
        s.add(new Email("oioioi@gmail.com"));
       
        try {
            s.add(new Email("oioioigmail.com"));
            c.add(new Celular("1111111", "222222222", TipoContatoCelular.APENAS_LIGACAO));
            
            //assertTrue(!VerificadoresRegras.procuraAlgumErro());
            
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("nao armazenou");            
        }
//        for (int i = 0; i < 1; i++) {          
//            System.out.println(RandomizadorStringExpressaoRegular.comUmCaractereInvalido(50, ExpressoesRegularesTesteRegra.APENAS_ESPACO));
//        }
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
