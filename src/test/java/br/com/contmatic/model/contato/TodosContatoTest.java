package br.com.contmatic.model.contato;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class TodosContatoTest.
 */
@RunWith(Suite.class)
@SuiteClasses({ CelularTest.class, EmailTest.class, TelefoneFixoTest.class, TipoContatoCelularTest.class })
public class TodosContatoTest {
}
