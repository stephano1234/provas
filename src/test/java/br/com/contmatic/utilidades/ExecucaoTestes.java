package br.com.contmatic.utilidades;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * The Class ExecucaoTestes.
 */
public class ExecucaoTestes {

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Executa todos testes unitarios determinado numero de vezes.
	 */
	@Test
	public void executa_todos_testes_unitarios_determinado_numero_de_vezes() {
		for (int i = 0; i < 1000; i++) {	
			Result resultado = JUnitCore.runClasses(TodosTest.class);
			System.out.println((i + 1) + "ª rodada de testes executada.");
			resultado.getFailures().forEach(falha -> falha.getException().printStackTrace());
			assertTrue(resultado.wasSuccessful());
		}
	}

}
