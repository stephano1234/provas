package br.com.contmatic.utilidades;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.contmatic.modelo.conta.TodosContaTest;
import br.com.contmatic.modelo.contato.TodosContatoTest;
import br.com.contmatic.modelo.empresa.TodosEmpresaTest;
import br.com.contmatic.modelo.endereco.TodosEnderecoTest;
import br.com.contmatic.modelo.pessoa.TodosPessoaTest;

public class ExecucaoTestes {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void executa_todos_testes_unitarios_determinadas_vezes() {
		for (int i = 0; i < 500; i++) {	
			Result resultado = JUnitCore.runClasses(TodosContaTest.class, TodosContatoTest.class, TodosEnderecoTest.class, TodosPessoaTest.class, TodosEmpresaTest.class);
			System.out.println((i + 1) + "ª rodada de testes executada.");
			List<Failure> falhas = resultado.getFailures();
			for (Failure falha : falhas) {
				System.out.println(falha.getTestHeader());
				System.out.println(falha.getException().toString());
				System.out.println(falha.getException().getCause().toString());
				falha.getException().printStackTrace();
				System.out.println(falha.getTrace());
			}
			assertTrue(resultado.wasSuccessful());
		}
	}

}
