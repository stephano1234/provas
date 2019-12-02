package br.com.contmatic.utilidades.templates.contato;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.DDD;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.INCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.NUMERO_TELEFONE;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS;
import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;
import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.stringAleatoria;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import br.com.contmatic.modelo.contato.TelefoneFixo;
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
            add("ddd", stringAleatoria(nextInt(INCLUI_STRING_VAZIO, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("maiorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", stringAleatoria(nextInt(DDD + 1, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("menorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", stringAleatoria(nextInt(EXCLUI_STRING_VAZIO, DDD), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("comUmCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", apenasUmCaractere(DDD, "[^0-9]", APENAS_NUMERAL));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("validoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD, APENAS_NUMERAL));
        }});
        
        //numero
        
        Fixture.of(TelefoneFixo.class).addTemplate("naoNuloNumero").inherits("valido", new Rule() {{
            add("numero", stringAleatoria(nextInt(INCLUI_STRING_VAZIO, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", stringAleatoria(nextInt(NUMERO_TELEFONE + 1, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("menorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", stringAleatoria(nextInt(EXCLUI_STRING_VAZIO, NUMERO_TELEFONE), false));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", apenasUmCaractere(NUMERO_TELEFONE, "[^0-9]", APENAS_NUMERAL));
        }});
        
        Fixture.of(TelefoneFixo.class).addTemplate("validoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_TELEFONE, APENAS_NUMERAL));
        }});
        
    }

}
