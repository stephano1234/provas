package br.com.contmatic.utilidades.templates.endereco;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.endereco.Cidade;
import br.com.contmatic.modelo.endereco.TipoUf;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.FuncoesRandomicas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CidadeTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        //geral
        
        Fixture.of(Cidade.class).addTemplate("valido", new Rule() {{     
            add("nome", random("São Paulo", "Campinas", "Sorocaba", "Guarulhos"));
            add("tipoUf", TipoUf.values()[RandomUtils.nextInt(0, 13)]);
        }});
        
        Fixture.of(Cidade.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Vitória", "Florianópolis", "Osasco", "São Caetano"));
            add("tipoUf", TipoUf.values()[RandomUtils.nextInt(13, TipoUf.values().length)]);
        }});
        
        //nome
        
        Fixture.of(Cidade.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Cidade.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Cidade.class).addTemplate("naoApenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.geraStringForaPadraoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Cidade.class).addTemplate("umNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.comUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_ESPACO));
        }});
        
        Fixture.of(Cidade.class).addTemplate("comCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.geraStringForaPadraoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Cidade.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.comUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.SEM_CARACTERE_ESPECIAL));
        }});
        
        Fixture.of(Cidade.class).addTemplate("semCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.SEM_CARACTERE_ESPECIAL));
        }});
        
    }
    
}
