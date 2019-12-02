package br.com.contmatic.utilidades.templates.contato;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.INCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS;
import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_ESPACO;
import static br.com.contmatic.utilidades.ConstantesTesteString.INVALIDOS_ANTES_PONTO;
import static br.com.contmatic.utilidades.ConstantesTesteString.INVALIDOS_DEPOIS_PONTO;
import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.emailAleatorio;
import static br.com.contmatic.utilidades.FuncoesRandomicas.naoCorresponde;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.stringAleatoria;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.modelo.contato.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmailTemplateFixtureFactory implements TemplateLoader {

	@Override
    public void load() {

        //geral
        
        Fixture.of(Email.class).addTemplate("valido", new Rule() {{
            add("endereco", random("oioioi@gmail.com", "stephano.regina@contmatic.com.br", "fausto@uol.com.br"));            
        }});
        
        Fixture.of(Email.class).addTemplate("outroValido", new Rule() {{
            add("endereco", random("paulo4321@hotmail.com", "soares13@hotmail.com", "tetete@gmail.com"));
        }});
        
        //endereco
        
        Fixture.of(Email.class).addTemplate("naoNuloEndereco").inherits("valido", new Rule() {{
            add("endereco", stringAleatoria(nextInt(INCLUI_STRING_VAZIO, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
                       
        Fixture.of(Email.class).addTemplate("apenasEspacoEndereco").inherits("valido", new Rule() {{
            add("endereco", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, VALOR_UNIVERSO_CHAR_GERADOS), APENAS_ESPACO));
        }});
        
        Fixture.of(Email.class).addTemplate("semArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@", ""));
        }});

        Fixture.of(Email.class).addTemplate("comArrobaEntreCaracteresInvalidosEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@", somenteCaractere(1, "[-_\\.]") + "@"));
        }});
        
        Fixture.of(Email.class).addTemplate("comMaisDeUmArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio() + "@");
        }});
        
        Fixture.of(Email.class).addTemplate("semPontoEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.", ""));
        }});
        
        Fixture.of(Email.class).addTemplate("validoEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio());
        }});
            
        Fixture.of(Email.class).addTemplate("vazioAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll(".*@", "@"));
        }});
        
        Fixture.of(Email.class).addTemplate("primeiroCaractereInvalidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", naoCorresponde(1, "[a-z0-9]") + emailAleatorio());
        }});
        
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll(".*@", apenasUmCaractere(nextInt(1, 10 + 1), INVALIDOS_ANTES_PONTO, "[a-z]+") + "@"));
        }});       
        
        Fixture.of(Email.class).addTemplate("randomValidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.+", "") + "@hotmail.com");
        }});
             
        Fixture.of(Email.class).addTemplate("vazioDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@{1}.*\\.(?!\\.)", "@" + "."));
        }});
        
        Fixture.of(Email.class).addTemplate("primeiroCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("((?<=@).){1}", naoCorresponde(1, "[a-z0-9\\\\]")));
        }});
               
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@{1}.*\\.(?!\\.)", "@" + apenasUmCaractere(10, INVALIDOS_ANTES_PONTO, "[a-z0-9]") + "."));
        }});
        
        Fixture.of(Email.class).addTemplate("semPontoObrigatorioDepoisArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@{1}.*\\.(?!\\.)", "@" + somenteCaractere(10, "[a-z0-9]")));
        }});        
        
        Fixture.of(Email.class).addTemplate("comPontoEntreCaractereInvalidoDepoisArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@{1}.*\\.(?!\\.)", "@" + somenteCaractere(10, "[a-z0-9]") + "." + "."));
        }});   
        
        Fixture.of(Email.class).addTemplate("randomValidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", "lalala@" + emailAleatorio().replaceAll(".*@", "").replaceAll("\\.(?!.*\\.).*", "") + ".com");
        }});
        
        Fixture.of(Email.class).addTemplate("maiorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.(?!.*\\.).*", "." + somenteCaractere(6 + 1, "[a-z]")));
        }});
        
        Fixture.of(Email.class).addTemplate("menorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.(?!.*\\.).*", "." + somenteCaractere(2 - 1, "[a-z]")));
        }});
        
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.(?!.*\\.).*", "." + apenasUmCaractere(nextInt(2, 6 + 1), INVALIDOS_DEPOIS_PONTO, "[a-z]")));
        }});
        
        Fixture.of(Email.class).addTemplate("randomValidoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", "lalala@contmatic." + emailAleatorio().replaceAll(".*\\.(?!\\.)", ""));
        }});
        
    }

}