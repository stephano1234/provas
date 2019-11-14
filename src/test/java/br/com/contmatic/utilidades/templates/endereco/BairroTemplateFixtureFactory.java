package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;


public class BairroTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        new CidadeTemplateFixtureFactory().load();
        
        Cidade cidade = Fixture.from(Cidade.class).gimme("valido");
        
        Cidade outroCidade = Fixture.from(Cidade.class).gimme("outroValido");
        
        //geral
        
        Fixture.of(Bairro.class).addTemplate("valido", new Rule() {{     
            add("nome", random("Tatuapé", "Capão Redondo", "Paraisópolis", "Vila Olímpia"));
            add("cidade", cidade);
        }});
        
        Fixture.of(Bairro.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Vila Madalena", "Barra Funda", "Piqueri", "Mandaqui"));
            add("cidade", outroCidade);
        }});
        
        //nome
        
        Fixture.of(Bairro.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Bairro.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Bairro.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Bairro.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Bairro.class).addTemplate("somenteEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Bairro.class).addTemplate("comNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Bairro.class).addTemplate("comUmNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Bairro.class).addTemplate("comCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Bairro.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Bairro.class).addTemplate("semCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
    }
    
}