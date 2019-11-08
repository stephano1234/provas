package br.com.contmatic.utilidades.templates.banco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.conta.Agencia;
import br.com.contmatic.modelo.conta.Banco;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AgenciaTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        new BancoTemplateFixtureFactory().load();
        
        Banco banco = Fixture.from(Banco.class).gimme("valido");
        
        Banco outroBanco = Fixture.from(Banco.class).gimme("outroValido");
        
        //geral
        
        Fixture.of(Agencia.class).addTemplate("valido", new Rule() {{
            add("numero", random("11111", "3232", "4457o", "1234"));
            add("banco", banco);
        }});
        
        Fixture.of(Agencia.class).addTemplate("outroValido", new Rule() {{
            add("numero", random("4321", "3422G", "7667", "47590"));
            add("banco", outroBanco);
        }});
        
        //numero
        
        Fixture.of(Agencia.class).addTemplate("naoNuloNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Agencia.class).addTemplate("naoVazioNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Agencia.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.MAX_NUMERO_AGENCIA + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Agencia.class).addTemplate("menorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.MAX_NUMERO_AGENCIA), false));
        }});
        
        Fixture.of(Agencia.class).addTemplate("comCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        Fixture.of(Agencia.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        Fixture.of(Agencia.class).addTemplate("semCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
    }

}