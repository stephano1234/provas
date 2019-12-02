package br.com.contmatic.modelo.endereco;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.modelo.contato.TelefoneFixoTest;

@RunWith(Suite.class)
@SuiteClasses({ BairroTest.class, CidadeTest.class, EnderecoTest.class, LogradouroTest.class, TelefoneFixoTest.class, TipoEnderecoTest.class, TipoUfTest.class })
public class TodosEnderecoTest {
}
