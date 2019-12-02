package br.com.contmatic.utilidades.templates.conta;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.modelo.conta.Banco;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ConstantesTesteString;
import br.com.contmatic.utilidades.FuncoesRandomicas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class BancoTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {
        
        //geral
        
        Fixture.of(Banco.class).addTemplate("valido", new Rule() {{
            add("codigo", random("079", "341", "085x", "0817"));
            add("nome", random("Cooperativa Central de Crédito Urbano-CECRED", "Cooperativa Unicred Central Santa Catarina", "Itaú Unibanco S.A.", "Banco Real S.A."));
        }});
        
        Fixture.of(Banco.class).addTemplate("outroValido", new Rule() {{
            add("codigo", random("M24", "735", "655", "633"));
            add("nome", random("Banco PSA Finance Brasil S.A.", "Banco Pottencial S.A.", "Banco Prosper S.A.", "Banco Votorantim S.A."));
        }});
        
        //codigo
        
        Fixture.of(Banco.class).addTemplate("naoNuloCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("naoVazioCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("maiorTamanhoCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.MAX_CODIGO_BANCO + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("menorIgualTamanhoCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.MAX_CODIGO_BANCO + 1), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("comCaractereInvalidoCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.naoCorresponde(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.SEM_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("comUmCaractereInvalidoCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.SEM_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("semCaractereInvalidoCodigo").inherits("valido", new Rule() {{
            add("codigo", FuncoesRandomicas.somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.SEM_ESPACO));
        }});
        
        //nome
        
        Fixture.of(Banco.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("naoVazioNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CAMPO_REGULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CAMPO_REGULAR + 1), false));
        }});
        
        Fixture.of(Banco.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("naoApenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.naoCorresponde(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_ESPACO));
        }});
        
        Fixture.of(Banco.class).addTemplate("umNaoEspacoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ConstantesTesteString.APENAS_ESPACO));
        }});
        
    }

}