package br.com.contmatic.modelo.pessoa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CelularTest.class, ColaboradorTest.class, EmailTest.class, PessoaTest.class, SocioTest.class,
		TipoContatoCelularTest.class, TipoContratoTrabalhoTest.class, TipoEstadoCivilTest.class,
		TipoGrauInstrucaoTest.class, TipoSexoTest.class, TipoSocioTest.class })
public class TodosPessoaTest {
}
