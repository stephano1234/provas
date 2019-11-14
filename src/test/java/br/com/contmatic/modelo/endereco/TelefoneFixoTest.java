package br.com.contmatic.modelo.endereco;

import static br.com.contmatic.utilidades.VerificadoresRegras.verificaErro;
import static br.com.contmatic.utilidades.VerificadoresRegras.procuraAlgumErro;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.modelo.endereco.Logradouro;
import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.utilidades.MensagensErro;
import br.com.contmatic.utilidades.templates.endereco.TelefoneFixoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import pl.pojo.tester.api.assertion.Method;

public class TelefoneFixoTest {
    
    private TelefoneFixo telefoneFixo;
    
    private TelefoneFixo outroTelefoneFixo;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new TelefoneFixoTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("valido");
        outroTelefoneFixo = Fixture.from(TelefoneFixo.class).gimme("outroValido");
    }

    @After
    public void tearDown() throws Exception {
    }

    //ddd
    
    
    
}
