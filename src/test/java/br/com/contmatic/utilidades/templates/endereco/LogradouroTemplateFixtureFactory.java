package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Logradouro;
import br.com.contmatic.modelo.endereco.Bairro;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ConstantesTesteString;
import br.com.contmatic.utilidades.FuncoesRandomicas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class LogradouroTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        new BairroTemplateFixtureFactory().load();
        
        Bairro bairro = Fixture.from(Bairro.class).gimme("valido");
        
        Bairro outroBairro = Fixture.from(Bairro.class).gimme("outroValido");
        
        //geral
        
        Fixture.of(Logradouro.class).addTemplate("valido", new Rule() {{     
            add("nome", random("Avenida Paulista", "Rua Padre Vieira", "Alameda Santos", "Rua Monte Alegre"));
            add("bairro", bairro);
        }});
        
        Fixture.of(Logradouro.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Avenida Brasil", "Avenida 23 de Maio", "Estrada de Itapicirica da Serra", "Rua João Cachoeira"));
            add("bairro", outroBairro);
        }});
        
        //nome
        
        Fixture.of(Logradouro.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_ESPACO));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("naoApenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.naoCorresponde(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_ESPACO));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("umNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_ESPACO));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("comCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.naoCorresponde(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Logradouro.class).addTemplate("semCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.SEM_CARACTERE_ESPECIAL));
        }});
        
    }
    
}