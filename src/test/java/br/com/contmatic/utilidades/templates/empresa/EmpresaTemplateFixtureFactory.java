package br.com.contmatic.utilidades.templates.empresa;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.CAMPO_REGULAR;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.CNPJ;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.INCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.VALOR_UNIVERSO_CHAR_GERADOS;
import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;
import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.cnpjInvalido;
import static br.com.contmatic.utilidades.FuncoesRandomicas.cnpjValido;
import static br.com.contmatic.utilidades.FuncoesRandomicas.localDateAleatoria;
import static br.com.contmatic.utilidades.FuncoesRandomicas.naoCorresponde;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.stringAleatoria;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import java.util.HashSet;
import java.util.Set;
import org.joda.time.LocalDate;
import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.contato.Celular;
import br.com.contmatic.modelo.contato.Email;
import br.com.contmatic.modelo.contato.TelefoneFixo;
import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.pessoa.ContratoTrabalho;
import br.com.contmatic.modelo.pessoa.Pessoa;
import br.com.contmatic.modelo.empresa.Empresa;
import br.com.contmatic.modelo.empresa.TipoPorteEmpresa;
import br.com.contmatic.modelo.empresa.TipoEmpresa;
import br.com.contmatic.utilidades.templates.conta.ContaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.CelularTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.EmailTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.ContratoTrabalhoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplateFixtureFactory implements TemplateLoader {


	@Override
    public void load() {

		new PessoaTemplateFixtureFactory().load();
		
		new ContratoTrabalhoTemplateFixtureFactory().load();
		
		new EnderecoTemplateFixtureFactory().load();
        
        new TelefoneFixoTemplateFixtureFactory().load();
        
        new EmailTemplateFixtureFactory().load();
        
        new CelularTemplateFixtureFactory().load();
        
        new ContaTemplateFixtureFactory().load();
        
        Set<Pessoa> responsaveis = new HashSet<Pessoa>();
        
        Set<Pessoa> outroResponsaveis = new HashSet<Pessoa>();

        Set<ContratoTrabalho> contratosTrabalho = new HashSet<ContratoTrabalho>();
        
        Set<ContratoTrabalho> outroContratosTrabalho = new HashSet<ContratoTrabalho>();
        
        Set<Endereco> enderecos = new HashSet<Endereco>();
        
        Set<Endereco> outroEnderecos = new HashSet<Endereco>();
                
        Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();
        
        Set<TelefoneFixo> outroTelefonesFixo = new HashSet<TelefoneFixo>();
        
        Set<Email> emails = new HashSet<Email>();
        
        Set<Email> outroEmails = new HashSet<Email>();

        Set<Celular> celulares = new HashSet<Celular>();
        
        Set<Celular> outroCelulares = new HashSet<Celular>();

        Set<Conta> contas = new HashSet<Conta>();
        
        Set<Conta> outroContas = new HashSet<Conta>();
        
        for (int i = 0; i < ELEMENTOS_ARRAY_GERADA; i++) {
        	        	
        	responsaveis.add(Fixture.from(Pessoa.class).gimme("valido"));
        	
        	outroResponsaveis.add(Fixture.from(Pessoa.class).gimme("outroValido"));
        	
        	contratosTrabalho.add(Fixture.from(ContratoTrabalho.class).gimme("valido"));
        	
        	outroContratosTrabalho.add(Fixture.from(ContratoTrabalho.class).gimme("outroValido"));
        	
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        	
        	outroEnderecos.add(Fixture.from(Endereco.class).gimme("outroValido"));
        	
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        	
        	outroTelefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("outroValido"));
        	
        	emails.add(Fixture.from(Email.class).gimme("valido"));
        	
        	outroEmails.add(Fixture.from(Email.class).gimme("outroValido"));

        	celulares.add(Fixture.from(Celular.class).gimme("valido"));
        	
        	outroCelulares.add(Fixture.from(Celular.class).gimme("outroValido"));
        	
        	contas.add(Fixture.from(Conta.class).gimme("valido"));
        	
        	outroContas.add(Fixture.from(Conta.class).gimme("outroValido"));
        	        	
        }
    	
    	//geral
        
        Fixture.of(Empresa.class).addTemplate("valido", new Rule() {{
            add("cnpj", random("92385152000178", "68564301000181", "13125387000154", "94359762000122"));
            add("razaoSocial", random("Contmatic Phoenix", "José César Ltda.", "Manufaturas EPP", "Fomentos Latino-Americanos S.A."));            
            add("responsaveis", responsaveis);
            add("contratosTrabalho", contratosTrabalho);
            add("dataAbertura", localDateAleatoria(LocalDate.parse("1900-01-01"), LocalDate.now()));
            add("enderecos", enderecos);
            add("telefonesFixo", telefonesFixo);
            add("emails", emails);
            add("celulares", celulares);
            add("contas", contas);
            add("tipoEmpresa", TipoEmpresa.values()[nextInt(0, TipoEmpresa.values().length)]);
            add("tipoPorteEmpresa", TipoPorteEmpresa.values()[nextInt(0, TipoPorteEmpresa.values().length)]);
        }});

        Fixture.of(Empresa.class).addTemplate("outroValido", new Rule() {{
            add("cnpj", random("93944007000142", "28808705000159", "01053510000190", "98323917000121"));
            add("razaoSocial", random("Maria dos Santos", "Carlos Augusto ME", "Super Esporte Artigos Esportivos Ltda.", "Itaú SA"));            
            add("responsaveis", outroResponsaveis);
            add("contratosTrabalho", outroContratosTrabalho);
            add("dataAbertura", localDateAleatoria(LocalDate.parse("1900-01-01"), LocalDate.now()));
            add("enderecos", outroEnderecos);
            add("telefonesFixo", outroTelefonesFixo);
            add("emails", outroEmails);
            add("celulares", outroCelulares);
            add("contas", outroContas);
            add("tipoEmpresa", TipoEmpresa.values()[nextInt(0, TipoEmpresa.values().length)]);
            add("tipoPorteEmpresa", TipoPorteEmpresa.values()[nextInt(0, TipoPorteEmpresa.values().length)]);
        }});
        
        //cnpj
        
        Fixture.of(Empresa.class).addTemplate("naoNuloCnpj").inherits("valido", new Rule() {{
            add("cnpj", stringAleatoria(nextInt(INCLUI_STRING_VAZIO, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Empresa.class).addTemplate("maiorTamanhoCnpj").inherits("valido", new Rule() {{
            add("cnpj", stringAleatoria(nextInt(CNPJ + 1, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
                
        Fixture.of(Empresa.class).addTemplate("menorTamanhoCnpj").inherits("valido", new Rule() {{
            add("cnpj", stringAleatoria(nextInt(EXCLUI_STRING_VAZIO, CNPJ), false));
        }});
        
        Fixture.of(Empresa.class).addTemplate("comCaractereInvalidoCnpj").inherits("valido", new Rule() {{
            add("cnpj", naoCorresponde(CNPJ, APENAS_NUMERAL));
        }});
        
        Fixture.of(Empresa.class).addTemplate("comUmCaractereInvalidoCnpj").inherits("valido", new Rule() {{
            add("cnpj", apenasUmCaractere(CNPJ, "[\\D]", APENAS_NUMERAL));
        }});
        
        Fixture.of(Empresa.class).addTemplate("numerosRepetidosCnpj").inherits("valido", new Rule() {{
            add("cnpj", naoCorresponde(CNPJ, Integer.toString(nextInt(0, 10))));
        }});

        Fixture.of(Empresa.class).addTemplate("comUmDigitoVerificadorInvalidoCnpj").inherits("valido", new Rule() {{
            add("cnpj", cnpjInvalido());
        }});
        
        Fixture.of(Empresa.class).addTemplate("cnpjValido").inherits("valido", new Rule() {{
            add("cnpj", cnpjValido());
        }});
        
        //razaoSocial
        
        Fixture.of(Empresa.class).addTemplate("naoNuloRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", stringAleatoria(nextInt(INCLUI_STRING_VAZIO, VALOR_UNIVERSO_CHAR_GERADOS), false));
        }});
        
        Fixture.of(Empresa.class).addTemplate("maiorTamanhoRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(CAMPO_REGULAR, VALOR_UNIVERSO_CHAR_GERADOS), "[a-z]"));
        }});

        Fixture.of(Empresa.class).addTemplate("comPrimeiroCaractereInvalido").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[a-z]") + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});

        Fixture.of(Empresa.class).addTemplate("comUmCaractereInvalidoRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + apenasUmCaractere(nextInt(1, 10), "\\d", "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});

        Fixture.of(Empresa.class).addTemplate("comEspacoDuploRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + "  " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});

        Fixture.of(Empresa.class).addTemplate("comEspacoInicioRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", " " + somenteCaractere(10, "[A-Z]") + " LTDA");
        }});

        Fixture.of(Empresa.class).addTemplate("comEspacoFimRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(10, "[A-Z]") + " LTDA" + " ");
        }});

        Fixture.of(Empresa.class).addTemplate("razaoSocialValido").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(10, "[A-Z]") + " LTDA");
        }});

        //dataAbertura

        Fixture.of(Empresa.class).addTemplate("dataAberturaQualquer").inherits("valido", new Rule() {{
            add("dataAbertura", localDateAleatoria(LocalDate.parse("1900-01-01"), LocalDate.now().plusYears(nextInt(0, 200))));
        }});

        Fixture.of(Empresa.class).addTemplate("dataAberturaFutura").inherits("valido", new Rule() {{
            add("dataAbertura", localDateAleatoria(LocalDate.now().plusYears(1), LocalDate.now().plusYears(10)));
        }});

        Fixture.of(Empresa.class).addTemplate("dataAberturaPassada").inherits("valido", new Rule() {{
            add("dataAbertura", localDateAleatoria(LocalDate.now().minusYears(100), LocalDate.now().minusDays(1)));
        }});

    }

}
