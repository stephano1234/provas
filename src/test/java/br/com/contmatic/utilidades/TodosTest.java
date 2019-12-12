package br.com.contmatic.utilidades;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.modelo.conta.TodosContaTest;
import br.com.contmatic.modelo.contato.TodosContatoTest;
import br.com.contmatic.modelo.empresa.TodosEmpresaTest;
import br.com.contmatic.modelo.endereco.TodosEnderecoTest;
import br.com.contmatic.modelo.pessoa.TodosPessoaTest;

@RunWith(Suite.class)
@SuiteClasses({TodosContaTest.class, TodosContatoTest.class, TodosEnderecoTest.class, TodosPessoaTest.class, TodosEmpresaTest.class})
public class TodosTest {
}
