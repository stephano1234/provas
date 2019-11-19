package br.com.contmatic.utilidades.templates.pessoa;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.pessoa.Celular;
import br.com.contmatic.modelo.pessoa.TipoContatoCelular;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CelularTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {

        //geral
        
        Fixture.of(Celular.class).addTemplate("valido", new Rule() {{
            add("ddd", random("12", "11", "68", "82"));
            add("numero", random("933445566", "950385476", "920381188", "940991818"));            
            add("tipoContatoCelular", TipoContatoCelular.values()[RandomUtils.nextInt(0, 3)]);            
        }});
        
        Fixture.of(Celular.class).addTemplate("outroValido", new Rule() {{
            add("ddd", random("13", "21", "69", "79"));
            add("numero", random("966554433", "988888888", "931240079", "908003232"));
            add("tipoContatoCelular", TipoContatoCelular.values()[RandomUtils.nextInt(3, TipoContatoCelular.values().length)]);
        }});
        
        //ddd
        
        Fixture.of(Celular.class).addTemplate("naoNuloDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("maiorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.DDD + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("menorIgualTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.DDD + 1), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("menorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.DDD), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("maiorIgualTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.DDD, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("comCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Celular.class).addTemplate("comUmCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Celular.class).addTemplate("semCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        //numero
        
        Fixture.of(Celular.class).addTemplate("naoNuloNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.NUMERO_CELULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("menorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.NUMERO_CELULAR + 1), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("menorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.NUMERO_CELULAR), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("maiorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.NUMERO_CELULAR, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Celular.class).addTemplate("comCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Celular.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Celular.class).addTemplate("semCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
    }

}