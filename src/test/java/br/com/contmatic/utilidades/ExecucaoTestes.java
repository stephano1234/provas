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
		for (int i = 0; i < 250; i++) {	
			Result resultado = JUnitCore.runClasses(TodosTest.class);
			System.out.println((i + 1) + "ª rodada de testes executada.");
			List<Failure> falhas = resultado.getFailures();
			for (Failure falha : falhas) {
				falha.getException().printStackTrace();
			}
			assertTrue(resultado.wasSuccessful());
		}
	}

}
