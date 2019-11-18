package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.endereco.Logradouro;
import br.com.contmatic.modelo.endereco.TelefoneFixo;
import br.com.contmatic.modelo.endereco.TipoEndereco;
import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesRegraNegocio;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        new LogradouroTemplateFixtureFactory().load();
        
        new TelefoneFixoTemplateFixtureFactory().load();
        
        Logradouro logradouro = Fixture.from(Logradouro.class).gimme("valido");
        
        Logradouro outroLogradouro = Fixture.from(Logradouro.class).gimme("outroValido");
        
        TelefoneFixo telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("valido");
        
        TelefoneFixo outroTelefoneFixo = Fixture.from(TelefoneFixo.class).gimme("outroValido");
        
        //geral
        
        Fixture.of(Endereco.class).addTemplate("valido", new Rule() {{
            add("cep", random("04546080", "12320010", "12345678"));
            add("numero", random("12", "467", "1920"));
            add("complemento", random("2ª casa da rua", "Bl B", "1º andar"));
            add("logradouro", logradouro);
            add("telefoneFixo", telefoneFixo);
            add("tipoEndereco", TipoEndereco.values()[RandomUtils.nextInt(0, TipoEndereco.values().length)]);
        }});
                
        Fixture.of(Endereco.class).addTemplate("outroValido", new Rule() {{
            add("cep", random("87654321", "11111111", "90023078"));
            add("numero", random("11", "2300", "2"));
            add("complemento", random("b", "apto 82", "4"));
            add("logradouro", outroLogradouro);
            add("telefoneFixo", outroTelefoneFixo);
            add("tipoEndereco", TipoEndereco.values()[RandomUtils.nextInt(0, TipoEndereco.values().length)]);
        }});
        
        //cep
        
        Fixture.of(Endereco.class).addTemplate("naoNuloCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CEP + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorIgualTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CEP + 1), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CEP), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorIgualTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CEP, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("semCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        //numero
        
        Fixture.of(Endereco.class).addTemplate("naoVazioNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.MAX_NUMERO_ENDERECO + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.MAX_NUMERO_ENDERECO + 1), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("semCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.APENAS_NUMERAL));
        }});

        //complemento
        
        Fixture.of(Endereco.class).addTemplate("naoVazioComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorIgualTamanhoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(0, ConstantesNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("somenteEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comNaoEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmNaoEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comCaractereInvalidoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("semCaractereInvalidoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(0, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesRegraNegocio.SEM_CARACTERE_ESPECIAL));
        }});
        
    }

}
