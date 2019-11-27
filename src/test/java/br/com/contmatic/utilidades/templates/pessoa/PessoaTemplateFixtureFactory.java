package br.com.contmatic.utilidades.templates.pessoa;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.LocalDate;

import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.pessoa.Celular;
import br.com.contmatic.modelo.pessoa.Email;
import br.com.contmatic.modelo.pessoa.Pessoa;
import br.com.contmatic.modelo.pessoa.TipoEstadoCivil;
import br.com.contmatic.modelo.pessoa.TipoGrauInstrucao;
import br.com.contmatic.modelo.pessoa.TipoSexo;
import br.com.contmatic.utilidades.ConstantesTesteNumericas;
import br.com.contmatic.utilidades.ExpressoesRegularesTesteRegra;
import br.com.contmatic.utilidades.FuncoesRandomicas;
import br.com.contmatic.utilidades.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PessoaTemplateFixtureFactory implements TemplateLoader {

    @Override
    public void load() {

        new EnderecoTemplateFixtureFactory().load();
        
        new CelularTemplateFixtureFactory().load();
        
        new EmailTemplateFixtureFactory().load();
        
        Set<Endereco> enderecos = new HashSet<Endereco>();
        
        Set<Endereco> outroEnderecos = new HashSet<Endereco>();
        
        Set<Celular> celulares = new HashSet<Celular>();
        
        Set<Celular> outroCelulares = new HashSet<Celular>();
        
        Set<Email> emails = new HashSet<Email>();
        
        Set<Email> outroEmails = new HashSet<Email>();
        
        for (int i = 0; i < ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA; i++) {
        	
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        	
        	outroEnderecos.add(Fixture.from(Endereco.class).gimme("Outrovalido"));
        	
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));
        	
        	outroCelulares.add(Fixture.from(Celular.class).gimme("Outrovalido"));
        	
        	emails.add(Fixture.from(Email.class).gimme("valido"));
        	
        	outroEmails.add(Fixture.from(Email.class).gimme("Outrovalido"));
        	        	
        }
    	
    	//geral
        
        Fixture.of(Pessoa.class).addTemplate("valido", new Rule() {{
            add("cpf", random("39270773809", "90563441887", "38325120398", "04759868496"));
            add("nome", random("Carlos Alberto", "José César", "Maria Paula", "Ana Duarte"));            
            add("enderecos", enderecos);
            add("dataNascimento", FuncoesRandomicas.localDateAleatoria(LocalDate.parse("01-01-1900"), LocalDate.now()));
            add("celulares", celulares);
            add("emails", emails);
            add("tipoGrauInstrucao", TipoGrauInstrucao.values()[RandomUtils.nextInt(0, TipoGrauInstrucao.values().length)]);
            add("tipoEstadoCivil", TipoEstadoCivil.values()[RandomUtils.nextInt(0, TipoEstadoCivil.values().length)]);
            add("tipoSexo", TipoSexo.values()[RandomUtils.nextInt(0, TipoSexo.values().length)]);
        }});

        Fixture.of(Pessoa.class).addTemplate("outroValido", new Rule() {{
            add("cpf", random("60421184124", "65490465727", "01351417029", "87841587511"));
            add("nome", random("Carlos Alberto", "José César", "Maria Paula", "Ana Duarte"));            
            add("enderecos", enderecos);
            add("dataNascimento", FuncoesRandomicas.localDateAleatoria(LocalDate.parse("01-01-1900"), LocalDate.now()));
            add("celulares", celulares);
            add("emails", emails);
            add("tipoGrauInstrucao", TipoGrauInstrucao.values()[RandomUtils.nextInt(0, TipoGrauInstrucao.values().length)]);
            add("tipoEstadoCivil", TipoEstadoCivil.values()[RandomUtils.nextInt(0, TipoEstadoCivil.values().length)]);
            add("tipoSexo", TipoSexo.values()[RandomUtils.nextInt(0, TipoSexo.values().length)]);
        }});
        
        //cpf
        
        Fixture.of(Pessoa.class).addTemplate("naoNuloCpf").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("maiorTamanhoCpf").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.CPF + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
                
        Fixture.of(Pessoa.class).addTemplate("menorTamanhoCpf").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.CPF), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("comCaractereInvalidoCpf").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.geraStringForaPadraoExpressaoRegular(ConstantesTesteNumericas.CPF, ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("comUmCaractereInvalidoCpf").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.comUmCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.CPF, ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("numerosRepetidosCpf").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.semCaractereNaoEspecificadoExpressaoRegular(ConstantesTesteNumericas.CPF, Integer.toString(RandomUtils.nextInt(0, 10))));
        }});

        Fixture.of(Pessoa.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.cpfInvalido());
        }});
        
        Fixture.of(Pessoa.class).addTemplate("cpfValido").inherits("valido", new Rule() {{
            add("cpf", FuncoesRandomicas.cpfValido());
        }});
        
        //nome
        
        Fixture.of(Pessoa.class).addTemplate("naoNuloNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.NUMERO_CELULAR + 1, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("menorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.NUMERO_CELULAR + 1), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("menorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.NUMERO_CELULAR), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("maiorIgualTamanhoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.stringAleatoria(RandomUtils.nextInt(ConstantesTesteNumericas.NUMERO_CELULAR, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("comCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.geraStringForaPadraoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.comUmCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
        Fixture.of(Pessoa.class).addTemplate("semCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", FuncoesRandomicas.semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS), ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
        }});
        
    }

}