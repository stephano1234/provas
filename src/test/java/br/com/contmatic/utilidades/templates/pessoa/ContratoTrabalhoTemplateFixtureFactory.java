package br.com.contmatic.utilidades.templates.pessoa;

import static br.com.contmatic.utilidades.FuncoesRandomicas.localDateAleatoria;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import org.joda.time.LocalDate;
import br.com.contmatic.modelo.pessoa.Pessoa;
import br.com.contmatic.modelo.pessoa.ContratoTrabalho;
import br.com.contmatic.modelo.pessoa.TipoContratoTrabalho;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ContratoTrabalhoTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {

    	new PessoaTemplateFixtureFactory().load();
    	
    	Pessoa pessoa = Fixture.from(Pessoa.class).gimme("valido");
    	
    	Pessoa outroPessoa = Fixture.from(Pessoa.class).gimme("outroValido");
    	
        //geral
        
        Fixture.of(ContratoTrabalho.class).addTemplate("valido", new Rule() {{
            add("pessoa", pessoa);
            add("tipoContratoTrabalho", TipoContratoTrabalho.values()[nextInt(0, TipoContratoTrabalho.values().length)]);
            add("dataInicioContrato", localDateAleatoria(LocalDate.parse("1900-01-01"), LocalDate.now()));
        }});
        
        Fixture.of(ContratoTrabalho.class).addTemplate("outroValido", new Rule() {{
        	add("pessoa", outroPessoa);
            add("tipoContratoTrabalho", TipoContratoTrabalho.values()[nextInt(0, TipoContratoTrabalho.values().length)]);
            add("dataInicioContrato", localDateAleatoria(LocalDate.parse("1900-01-01"), LocalDate.now()));
        }});
        
        //dataInicioContrato

        Fixture.of(ContratoTrabalho.class).addTemplate("dataInicioContratoQualquer").inherits("valido", new Rule() {{
            add("dataInicioContrato", localDateAleatoria(LocalDate.parse("1900-01-01"), LocalDate.now().plusYears(nextInt(0, 200))));
        }});

        Fixture.of(ContratoTrabalho.class).addTemplate("dataInicioContratoFutura").inherits("valido", new Rule() {{
            add("dataInicioContrato", localDateAleatoria(LocalDate.now().plusYears(1), LocalDate.now().plusYears(10)));
        }});

        Fixture.of(ContratoTrabalho.class).addTemplate("dataInicioContratoPassada").inherits("valido", new Rule() {{
            add("dataInicioContrato", localDateAleatoria(LocalDate.now().minusYears(100), LocalDate.now().minusDays(1)));
        }});
        
    }

}
