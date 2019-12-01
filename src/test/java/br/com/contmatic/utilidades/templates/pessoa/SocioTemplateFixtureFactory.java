package br.com.contmatic.utilidades.templates.pessoa;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import br.com.contmatic.modelo.pessoa.Pessoa;
import br.com.contmatic.modelo.pessoa.Socio;
import br.com.contmatic.modelo.pessoa.TipoSocio;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class SocioTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {

    	new PessoaTemplateFixtureFactory().load();
    	
    	Pessoa pessoa = Fixture.from(Pessoa.class).gimme("valido");
    	
    	Pessoa outroPessoa = Fixture.from(Pessoa.class).gimme("outroValido");
    	
        //geral
        
        Fixture.of(Socio.class).addTemplate("valido", new Rule() {{
            add("pessoa", pessoa);
            add("tipoSocio", TipoSocio.values()[nextInt(0, TipoSocio.values().length)]);
        }});
        
        Fixture.of(Socio.class).addTemplate("outroValido", new Rule() {{
        	add("pessoa", outroPessoa);
            add("tipoSocio", TipoSocio.values()[nextInt(0, TipoSocio.values().length)]);
        }});
        
    }

}
