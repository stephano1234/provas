package br.com.contmatic.modelo.pessoa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContratoTrabalhoTest.class, PessoaTest.class, TipoContratoTrabalhoTest.class, TipoEstadoCivilTest.class,
		TipoGrauInstrucaoTest.class, TipoSexoTest.class })
public class TodosPessoaTest {
}
