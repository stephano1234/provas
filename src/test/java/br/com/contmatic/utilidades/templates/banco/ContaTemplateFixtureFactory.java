package br.com.contmatic.utilidades.templates.banco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.conta.Agencia;
import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.conta.TipoConta;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ContaTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        new AgenciaTemplateFixtureFactory().load();
        
        Agencia agencia = Fixture.from(Agencia.class).gimme("valido");
        
        Agencia outroAgencia = Fixture.from(Agencia.class).gimme("outroValido");
        
        //geral
        
        Fixture.of(Conta.class).addTemplate("valido", new Rule() {{
            add("numero", random("11111D", "32325678901A", "7654321p", "555557"));
            add("agencia", agencia);
            add("tipoConta", TipoConta.values()[RandomUtils.nextInt(0, TipoConta.values().length)]);
        }});
        
        Fixture.of(Conta.class).addTemplate("outroValido", new Rule() {{
            add("numero", random("55555D", "99999D", "9999999999D", "1234567"));
            add("agencia", outroAgencia);
            add("tipoConta", TipoConta.values()[RandomUtils.nextInt(0, TipoConta.values().length)]);
        }});
        
        //numero
        
        Fixture.of(Conta.class).addTemplate("naoNuloNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Conta.class).addTemplate("naoVazioNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Conta.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.MAX_NUMERO_CONTA + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Conta.class).addTemplate("menorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.MAX_NUMERO_CONTA), false));
        }});
        
        Fixture.of(Conta.class).addTemplate("comCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        Fixture.of(Conta.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
        Fixture.of(Conta.class).addTemplate("semCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_ESPACO));
        }});
        
    }

}
