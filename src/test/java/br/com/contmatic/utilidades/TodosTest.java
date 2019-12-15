package br.com.contmatic.utilidades;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.model.conta.TodosContaTest;
import br.com.contmatic.model.contato.TodosContatoTest;
import br.com.contmatic.model.empresa.TodosEmpresaTest;
import br.com.contmatic.model.endereco.TodosEnderecoTest;
import br.com.contmatic.model.pessoa.TodosPessoaTest;

/**
 * The Class TodosTest.
 */
@RunWith(Suite.class)
@SuiteClasses({TodosContaTest.class, TodosContatoTest.class, TodosEnderecoTest.class, TodosPessoaTest.class, TodosEmpresaTest.class})
public class TodosTest {
}
