package br.com.contmatic.utilidades.templates.pessoa;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.pessoa.Email;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.RandomizadorStringExpressaoRegular;

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
        
        //endereco (geral)
        
        Fixture.of(Email.class).addTemplate("naoNuloEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Email.class).addTemplate("naoVazioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
               
        Fixture.of(Email.class).addTemplate("apenasEspacoEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Email.class).addTemplate("naoApenasEspacoEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.geraStringForaPadraoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Email.class).addTemplate("umNaoEspacoEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.comUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Email.class).addTemplate("semArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.ARROBA, ExpressoesRegularesTesteRegra.APENAS_EXCLUI_CARACTERE));
        }});

        Fixture.of(Email.class).addTemplate("comArrobaEntreCaracteresInvalidosEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.ARROBA, RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(1, ExpressoesRegularesTesteRegra.UNDERLINE_TRACO_PONTO) + ExpressoesRegularesTesteRegra.ARROBA));
        }});
        
        Fixture.of(Email.class).addTemplate("comMaisDeUmArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio() + ExpressoesRegularesTesteRegra.ARROBA);
        }});
        
        Fixture.of(Email.class).addTemplate("semPontoEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.PONTO_REGEX, ExpressoesRegularesTesteRegra.APENAS_EXCLUI_CARACTERE));
        }});
        
        Fixture.of(Email.class).addTemplate("randomValidoEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio());
        }});
        
        //endereco (antes do Arroba)
            
        Fixture.of(Email.class).addTemplate("naoVazioAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.ANTES_ARROBA, ExpressoesRegularesTesteRegra.ARROBA));
        }});
        
        Fixture.of(Email.class).addTemplate("primeiroCaractereInvalidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.geraStringForaPadraoExpressaoRegular(1, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL) + RandomizadorStringExpressaoRegular.emailAleatorio());
        }});
        
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.ANTES_ARROBA, RandomizadorStringExpressaoRegular.comUmCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_UNDERLINE_TRACO_PONTO) + ExpressoesRegularesTesteRegra.ARROBA));
        }});       
        
        Fixture.of(Email.class).addTemplate("randomValidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_ARROBA, ExpressoesRegularesTesteRegra.APENAS_EXCLUI_CARACTERE) + "@hotmail.com");
        }});
        
        //endereco (depois do Arroba até o ponto obrigatório)
             
        Fixture.of(Email.class).addTemplate("naoVazioDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_ARROBA_ANTES_PONTO, ExpressoesRegularesTesteRegra.ARROBA + ExpressoesRegularesTesteRegra.PONTO));
        }});
        
        Fixture.of(Email.class).addTemplate("primeiroCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.PRIMEIRO_DEPOIS_ARROBA, RandomizadorStringExpressaoRegular.geraStringForaPadraoExpressaoRegular(1, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL)));
        }});
               
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_ARROBA_ANTES_PONTO, ExpressoesRegularesTesteRegra.ARROBA + RandomizadorStringExpressaoRegular.comUmCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_UNDERLINE_TRACO_PONTO) + ExpressoesRegularesTesteRegra.PONTO));
        }});
        
        Fixture.of(Email.class).addTemplate("semPontoObrigatorioDepoisArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_ARROBA_ANTES_PONTO, ExpressoesRegularesTesteRegra.ARROBA + RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL)));
        }});        
        
        Fixture.of(Email.class).addTemplate("comPontoEntreCaractereInvalidoDepoisArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_ARROBA_ANTES_PONTO, ExpressoesRegularesTesteRegra.ARROBA + RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL) + ExpressoesRegularesTesteRegra.PONTO + ExpressoesRegularesTesteRegra.PONTO));
        }});   
        
        Fixture.of(Email.class).addTemplate("randomValidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", "lalala@" + RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.ANTES_ARROBA, ExpressoesRegularesTesteRegra.APENAS_EXCLUI_CARACTERE).replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_PONTO, ExpressoesRegularesTesteRegra.APENAS_EXCLUI_CARACTERE) + ".com");
        }});
        
        //endereco (depois do ponto obrigatório)
        
        Fixture.of(Email.class).addTemplate("maiorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_PONTO, ExpressoesRegularesTesteRegra.PONTO + RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.MAX_DEPOIS_PONTO_EMAIL + 1, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO)));
        }});
        
        Fixture.of(Email.class).addTemplate("menorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_PONTO, ExpressoesRegularesTesteRegra.PONTO + RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.MIN_DEPOIS_PONTO_EMAIL - 1, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO)));
        }});
        
        Fixture.of(Email.class).addTemplate("entreMaiorMenorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_PONTO, ExpressoesRegularesTesteRegra.PONTO + RandomizadorStringExpressaoRegular.semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.MIN_DEPOIS_PONTO_EMAIL, ConstantesTesteNumericas.MAX_DEPOIS_PONTO_EMAIL + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO)));
        }});
               
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.DEPOIS_PONTO, ExpressoesRegularesTesteRegra.PONTO + RandomizadorStringExpressaoRegular.comUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.MIN_DEPOIS_PONTO_EMAIL, ConstantesTesteNumericas.MAX_DEPOIS_PONTO_EMAIL + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO)));
        }});
        
        Fixture.of(Email.class).addTemplate("randomValidoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", "lalala@contmatic." + RandomizadorStringExpressaoRegular.emailAleatorio().replaceAll(ExpressoesRegularesTesteRegra.ANTES_PONTO, ExpressoesRegularesTesteRegra.APENAS_EXCLUI_CARACTERE));
        }});
        
    }

}