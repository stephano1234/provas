package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Logradouro;
import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;


public class LogradouroTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        new BairroTemplateFixtureFactory().load();
        
        Bairro bairro = Fixture.from(Bairro.class).gimme("valido");
        
        Bairro outroBairro = Fixture.from(Bairro.class).gimme("outroValido");
        
        //geral
        
        Fixture.of(Logradouro.class).addTemplate("valido", new Rule() {{     
            add("nome", random("Avenida Paulista", "Rua Padre Vieira", "Alameda Santos", "Rua Monte Alegre"));
            add("bairro", bairro);
        }});
        
        Fixture.of(Logradouro.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Avenida Brasil", "Avenida 23 de Maio", "Estrada de Itapicirica da Serra", "Rua João Cachoeira"));
            add("bairro", outroBairro);
        }});
        
        //nome
        
        Fixture.of(Logradouro.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("somenteEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("comNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("comUmNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("comCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("semCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
    }
    
}