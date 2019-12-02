package br.com.contmatic.modelo.pessoa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.modelo.contato.CelularTest;
import br.com.contmatic.modelo.contato.EmailTest;
import br.com.contmatic.modelo.contato.TipoContatoCelularTest;

@RunWith(Suite.class)
@SuiteClasses({ CelularTest.class, ContratoTrabalhoTest.class, EmailTest.class, PessoaTest.class, SocioTest.class,
		TipoContatoCelularTest.class, TipoContratoTrabalhoTest.class, TipoEstadoCivilTest.class,
		TipoGrauInstrucaoTest.class, TipoSexoTest.class, TipoSocioTest.class })
public class TodosPessoaTest {
}
