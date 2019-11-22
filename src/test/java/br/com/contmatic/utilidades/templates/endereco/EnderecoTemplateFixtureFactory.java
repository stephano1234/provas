package br.com.contmatic.utilidades.templates.endereco;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.endereco.Logradouro;
import br.com.contmatic.modelo.endereco.TelefoneFixo;
import br.com.contmatic.modelo.endereco.TipoEndereco;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
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
        
        Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();
        
        Set<TelefoneFixo> outroTelefonesFixo = new HashSet<TelefoneFixo>();
        
        for (int i = 0; i < ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA; i++) {
        
            telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        
            outroTelefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("outroValido"));
        
        }
            
        //geral
        
        Fixture.of(Endereco.class).addTemplate("valido", new Rule() {{
            add("cep", random("04546080", "12320010", "12345678"));
            add("numero", random("12", "467", "1920"));
            add("complemento", random("2ª casa da rua", "Bl B", "1º andar"));
            add("logradouro", logradouro);
            add("telefonesFixo", telefonesFixo);
            add("tipoEndereco", TipoEndereco.values()[RandomUtils.nextInt(0, TipoEndereco.values().length)]);
        }});
                
        Fixture.of(Endereco.class).addTemplate("outroValido", new Rule() {{
            add("cep", random("87654321", "11111111", "90023078"));
            add("numero", random("11", "2300", "2"));
            add("complemento", random("b", "apto 82", "4"));
            add("logradouro", outroLogradouro);
            add("telefonesFixo", outroTelefonesFixo);
            add("tipoEndereco", TipoEndereco.values()[RandomUtils.nextInt(0, TipoEndereco.values().length)]);
        }});
        
        //cep
        
        Fixture.of(Endereco.class).addTemplate("naoNuloCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CEP + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorIgualTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CEP + 1), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CEP), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorIgualTamanhoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CEP, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("semCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        //numero
        
        Fixture.of(Endereco.class).addTemplate("naoVazioNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.MAX_NUMERO_ENDERECO + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.MAX_NUMERO_ENDERECO + 1), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("semCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});

        //complemento
        
        Fixture.of(Endereco.class).addTemplate("naoVazioComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("menorIgualTamanhoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Endereco.class).addTemplate("apenasEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Endereco.class).addTemplate("naoApenasEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Endereco.class).addTemplate("umNaoEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comCaractereInvalidoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.comUmCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.NAO_INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Endereco.class).addTemplate("semCaractereInvalidoComplemento").inherits("valido", new Rule() {{
            add("complemento", RandomizadorStringExpressaoRegular.semCaractereInvalido(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.SEM_CARACTERE_ESPECIAL));
        }});
        
    }

}
