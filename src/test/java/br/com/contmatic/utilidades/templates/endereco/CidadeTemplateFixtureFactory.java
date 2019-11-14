package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.modelo.endereco.TipoUf;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CidadeTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        //geral
        
        Fixture.of(Cidade.class).addTemplate("valido", new Rule() {{     
            add("nome", random("São Paulo", "Campinas", "Sorocaba", "Guarulhos"));
            add("tipoUf", TipoUf.values()[RandomUtils.nextInt(0, 13)]);
        }});
        
        Fixture.of(Cidade.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Vitória", "Florianópolis", "Osasco", "São Caetano"));
            add("tipoUf", TipoUf.values()[RandomUtils.nextInt(13, TipoUf.values().length)]);
        }});
        
        //nome
        
        Fixture.of(Cidade.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("somenteEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Cidade.class).addTemplate("comNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Cidade.class).addTemplate("comUmNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Cidade.class).addTemplate("comCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Cidade.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Cidade.class).addTemplate("semCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
    }
    
}
