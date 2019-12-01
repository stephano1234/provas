package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.TelefoneFixo;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ConstantesTesteString;
import br.com.contmatic.utilidades.FuncoesRandomicas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneFixoTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {

        //geral
        
        Fixture.of(TelefoneFixo.class).addTemplate("valido", new Rule() {{
            add("ddd", random("12", "11", "68", "82"));
            add("numero", random("33445566", "50385476", "20381188", "40991818"));            
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("outroValido", new Rule() {{
            add("ddd", random("13", "21", "69", "79"));
            add("numero", random("66554433", "88888888", "31240079", "08003232"));            
        }});
        
        //ddd
        
        Fixture.of(TelefoneFixo.class).addTemplate("naoNuloDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("maiorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.DDD + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("menorIgualTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.DDD + 1), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("menorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.DDD), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("maiorIgualTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.DDD, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("comCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.naoCorresponde(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_NUMERAL));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("comUmCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_NUMERAL));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("semCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", FuncoesRandomicas.somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_NUMERAL));
        }});
        
        //numero
        
        Fixture.of(TelefoneFixo.class).addTemplate("naoNuloNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.NUMERO_TELEFONE + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("menorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.NUMERO_TELEFONE + 1), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("menorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.NUMERO_TELEFONE), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("maiorIgualTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.NUMERO_TELEFONE, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("comCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.naoCorresponde(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_NUMERAL));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_NUMERAL));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("semCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", FuncoesRandomicas.somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_NUMERAL));
        }});
        
    }

}
