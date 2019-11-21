package br.com.contmatic.utilidades.templates.pessoa;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.pessoa.Email;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmailTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {

        //geral
        
        Fixture.of(Email.class).addTemplate("valido", new Rule() {{
            add("endereco", random("oioioi@gomail.com", "stephano.regina@contmatic.com.br", "fausto@uol.com.br"));            
        }});
        
        Fixture.of(Email.class).addTemplate("outroValido", new Rule() {{
            add("endereco", random("paulo4321@hotmail.com", "soares13@hotmail.com", "tetete@gmail.com"));
        }});
        
        //endereco
        
        Fixture.of(Email.class).addTemplate("naoNuloEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Email.class).addTemplate("naoVazioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        
        

        
    }

}