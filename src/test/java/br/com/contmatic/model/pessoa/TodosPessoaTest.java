package br.com.contmatic.model.pessoa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class TodosPessoaTest.
 */
@RunWith(Suite.class)
@SuiteClasses({ ContratoTrabalhoTest.class, PessoaTest.class, TipoContratoTrabalhoTest.class, TipoEstadoCivilTest.class,
		TipoGrauInstrucaoTest.class, TipoSexoTest.class })
public class TodosPessoaTest {
}
