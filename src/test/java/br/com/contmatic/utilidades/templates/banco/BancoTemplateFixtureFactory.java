package br.com.contmatic.utilidades.templates.banco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.conta.Banco;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class BancoTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        //geral
        
        Fixture.of(Banco.class).addTemplate("valido", new Rule() {{
            add("codigo", random("079", "341", "085x", "0817"));
            add("nome", random("Cooperativa Central de Crédito Urbano-CECRED", "Cooperativa Unicred Central Santa Catarina", "Itaú Unibanco S.A.", "Banco Real S.A."));
        }});
        
        Fixture.of(Banco.class).addTemplate("outroValido", new Rule() {{
            add("codigo", random("M24", "735", "655", "633"));
            add("nome", random("Banco PSA Finance Brasil S.A.", "Banco Pottencial S.A.", "Banco Prosper S.A.", "Banco Votorantim S.A."));
        }});
        
        //codigo
        
        Fixture.of(Banco.class).addTemplate("naoNuloCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("naoVazioCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("maiorTamanhoCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.MAX_CODIGO_BANCO + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("menorIgualTamanhoCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.MAX_CODIGO_BANCO + 1), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("comCaractereInvalidoCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("comUmCaractereInvalidoCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("semCaractereInvalidoCodigo").inherits("valido", new Rule() {{
            add("codigo", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        //nome
        
        Fixture.of(Banco.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("somenteEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("comNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("comUmNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
    }

}
