package br.com.contmatic.modelo.empresa;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO;
import static br.com.contmatic.utilidades.MensagensErro.STRING_CNPJ_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.STRING_RAZAO_SOCIAL_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;
import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaErro;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;

import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.modelo.conta.Conta;
import br.com.contmatic.modelo.contato.Celular;
import br.com.contmatic.modelo.contato.Email;
import br.com.contmatic.modelo.contato.TelefoneFixo;
import br.com.contmatic.modelo.endereco.Endereco;
import br.com.contmatic.modelo.pessoa.ContratoTrabalho;
import br.com.contmatic.modelo.pessoa.Pessoa;

import br.com.contmatic.utilidades.templates.conta.ContaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.CelularTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.EmailTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.ContratoTrabalhoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.empresa.EmpresaTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class EmpresaTest {
    
    private Empresa empresa;
    
    private Empresa outroEmpresa;
    
    Set<Pessoa> responsaveis = new HashSet<Pessoa>();
    
    Set<Pessoa> responsaveisInvalido = new HashSet<Pessoa>();

    Set<ContratoTrabalho> contratosTrabalho = new HashSet<ContratoTrabalho>();
    
    Set<ContratoTrabalho> contratosTrabalhoInvalido = new HashSet<ContratoTrabalho>();
    
    private Set<Endereco> enderecos = new HashSet<Endereco>();

    private Set<Endereco> enderecosInvalido = new HashSet<Endereco>();
        
    private Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();
    
    private Set<TelefoneFixo> telefonesFixoInvalido = new HashSet<TelefoneFixo>();

    private Set<Email> emails = new HashSet<Email>();

    private Set<Email> emailsInvalido = new HashSet<Email>();
    
    private Set<Celular> celulares = new HashSet<Celular>();

    private Set<Celular> celularesInvalido = new HashSet<Celular>();

    private Set<Conta> contas = new HashSet<Conta>();
    
    private Set<Conta> contasInvalido = new HashSet<Conta>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new EmpresaTemplateFixtureFactory().load();
        new PessoaTemplateFixtureFactory().load();
        new ContratoTrabalhoTemplateFixtureFactory().load();
        new EnderecoTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();
        new EmailTemplateFixtureFactory().load();
        new CelularTemplateFixtureFactory().load();
        new ContaTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        empresa = Fixture.from(Empresa.class).gimme("valido");
        outroEmpresa = Fixture.from(Empresa.class).gimme("outroValido");
        for (int i = 0; i < ELEMENTOS_ARRAY_GERADA; i++) {
        	responsaveis.add(Fixture.from(Pessoa.class).gimme("valido"));
        	contratosTrabalho.add(Fixture.from(ContratoTrabalho.class).gimme("valido"));
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));        	
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        	emails.add(Fixture.from(Email.class).gimme("valido"));
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));
        	contas.add(Fixture.from(Conta.class).gimme("valido"));
        	responsaveisInvalido.add(Fixture.from(Pessoa.class).gimme("comUmDigitoVerificadorInvalidoCpf"));
        	contratosTrabalhoInvalido.add(Fixture.from(ContratoTrabalho.class).gimme("dataInicioContratoFutura"));
        	enderecosInvalido.add(Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoCep"));        	
        	telefonesFixoInvalido.add(Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero"));
        	emailsInvalido.add(Fixture.from(Email.class).gimme("comUmCaractereInvalidoAntesArrobaEndereco"));
        	celularesInvalido.add(Fixture.from(Celular.class).gimme("comUmCaractereInvalidoNumero"));
        	contasInvalido.add(Fixture.from(Conta.class).gimme("comUmCaractereInvalidoNumero"));
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    //cnpj
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cnpj() {
        empresa.setCnpj(null);
        assertTrue(verificaErro(empresa, VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("naoNuloCnpj");
        assertFalse(verificaErro(empresa, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("maiorTamanhoCnpj");
        assertTrue(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("menorTamanhoCnpj");
        assertTrue(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }
        
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("comCaractereInvalidoCnpj");
        assertTrue(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("comUmCaractereInvalidoCnpj");
        assertTrue(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_numeros_repetidos_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("numerosRepetidosCnpj");
        assertTrue(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_cnpj_com_um_digito_verificador_invalido() {
        empresa = Fixture.from(Empresa.class).gimme("comUmDigitoVerificadorInvalidoCnpj");
        assertTrue(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }    
    
    @Test
    public void deve_aceitar_cnpj_valido() {
        empresa = Fixture.from(Empresa.class).gimme("cnpjValido");
        assertFalse(verificaErro(empresa, STRING_CNPJ_INVALIDO));
    }
    
    //razaoSocial
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_razaoSocial() {
        empresa.setRazaoSocial(null);
        assertTrue(verificaErro(empresa, VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("naoNuloRazaoSocial");
        assertFalse(verificaErro(empresa, VALOR_NULO));
    }

    @Test
    public void nao_deve_aceitar_valor_vazio_no_razaoSocial() {
    	empresa.setRazaoSocial("");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("maiorTamanhoRazaoSocial");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_invalido_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comPrimeiroCaractereInvalido");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comUmCaractereInvalidoRazaoSocial");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_dois_espacos_juntos_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comEspacoDuploRazaoSocial");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_espaco_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comEspacoInicioRazaoSocial");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }

    @Test
    public void nao_deve_aceitar_valor_com_ultimo_caractere_espaco_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comEspacoFimRazaoSocial");
        assertTrue(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }

    @Test
    public void deve_aceitar_razaoSocial_valido() {
        empresa = Fixture.from(Empresa.class).gimme("razaoSocialValido");
        assertFalse(verificaErro(empresa, STRING_RAZAO_SOCIAL_INVALIDO));
    }

    //dataAbertura
    
    @Test
    public void nao_deve_aceitar_dataAbertura_nulo() {
    	empresa.setDataAbertura(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_dataAbertura_nao_nulo() {
    	empresa = Fixture.from(Empresa.class).gimme("dataAberturaQualquer");
    	assertFalse(verificaErro(empresa, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_dataAbertura_futura() {
    	empresa = Fixture.from(Empresa.class).gimme("dataAberturaFutura");
    	assertTrue(verificaErro(empresa, DATA_PASSADO));
    }

    @Test
    public void deve_aceitar_dataAbertura_passada() {
    	empresa = Fixture.from(Empresa.class).gimme("dataAberturaPassada");
    	assertFalse(verificaErro(empresa, DATA_PASSADO));
    }
    
    //responsaveis
    
    @Test
    public void nao_deve_aceitar_responsaveis_nulo() {
    	empresa.setResponsaveis(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_responsaveis_vazio() {
    	empresa.setResponsaveis(new HashSet<Pessoa>());
    	assertTrue(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_responsaveis_com_pelo_menos_um_elemento_nulo() {
    	empresa.getResponsaveis().add(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }

    @Test
    public void deve_aceitar_responsaveis_nao_nulo_e_nao_vazio_e_sem_elementos_nulos() {
    	empresa.setResponsaveis(responsaveis);
    	assertFalse(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_responsaveis_invalido() {
    	empresa.setResponsaveis(responsaveisInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_responsaveis_valido() {
    	empresa.setResponsaveis(responsaveis);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    //contratosTrabalho
    
    @Test
    public void nao_deve_aceitar_contratosTrabalho_invalido() {
    	empresa.setContratosTrabalho(contratosTrabalhoInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_contratosTrabalho_valido() {
    	empresa.setContratosTrabalho(contratosTrabalho);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    //enderecos
    
    @Test
    public void nao_deve_aceitar_enderecos_nulo() {
    	empresa.setEnderecos(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }

    @Test
    public void nao_deve_aceitar_enderecos_vazio() {
    	empresa.setEnderecos(new HashSet<Endereco>());
    	assertTrue(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_enderecos_com_pelo_menos_um_elemento_nulo() {
    	empresa.getEnderecos().add(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void deve_aceitar_enderecos_nao_nulo_e_nao_vazio_e_sem_elementos_nulos() {
    	empresa.setEnderecos(enderecos);
    	assertFalse(verificaErro(empresa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_enderecos_invalido() {
    	empresa.setEnderecos(enderecosInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_enderecos_valido() {
    	empresa.setEnderecos(enderecos);
    	assertFalse(procuraAlgumErro(empresa));
    }

    //telefonesFixo
    
    @Test
    public void nao_deve_aceitar_telefonesFixo_invalido() {
    	empresa.setTelefonesFixo(telefonesFixoInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_telefonesFixo_valido() {
    	empresa.setTelefonesFixo(telefonesFixo);
    	assertFalse(procuraAlgumErro(empresa));
    }

    //emails
    
    @Test
    public void nao_deve_aceitar_emails_invalido() {
    	empresa.setEmails(emailsInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_emails_valido() {
    	empresa.setEmails(emails);
    	assertFalse(procuraAlgumErro(empresa));
    }

    //celulares
    
    @Test
    public void nao_deve_aceitar_celulares_invalido() {
    	empresa.setCelulares(celularesInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_celulares_valido() {
    	empresa.setCelulares(celulares);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    //contas
    
    @Test
    public void nao_deve_aceitar_contas_invalido() {
    	empresa.setContas(contasInvalido);
    	assertTrue(procuraAlgumErro(empresa));
    }

    @Test
    public void deve_aceitar_contas_valido() {
    	empresa.setContas(contas);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    //tipoEmpresa
    
    @Test
    public void nao_deve_aceitar_tipoEmpresa_nulo() {
    	empresa.setTipoEmpresa(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoEmpresa_nao_nulo() {
    	empresa.setTipoEmpresa(TipoEmpresa.SOCIEDADE);
    	assertFalse(verificaErro(empresa, VALOR_NULO));
    }

    //tipoPorteEmpresa
    
    @Test
    public void nao_deve_aceitar_tipoPorteEmpresa_nulo() {
    	empresa.setTipoPorteEmpresa(null);
    	assertTrue(verificaErro(empresa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoPorteEmpresa_nao_nulo() {
    	empresa.setTipoPorteEmpresa(TipoPorteEmpresa.EPP);
    	assertFalse(verificaErro(empresa, VALOR_NULO));
    }
    
    //getter e setter    
    
    @Test
    public void getCnpj_deve_trazer_o_valor_armazenado_em_cnpj() {
        empresa.setCnpj("13282774000102");
        assertThat(empresa.getCnpj(), is(equalTo("13282774000102")));
    }
    
    @Test
    public void getRazaoSocial_deve_trazer_o_valor_armazenado_em_razaoSocial() {
        empresa.setRazaoSocial("Empresa SA");
        assertThat(empresa.getRazaoSocial(), is(equalTo("Empresa SA")));
    }

    @Test
    public void getDataAbertura_deve_trazer_o_valor_armazenado_em_dataAbertura() {
        empresa.setDataAbertura(LocalDate.parse("1990-02-12"));
        assertThat(empresa.getDataAbertura(), is(equalTo(LocalDate.parse("1990-02-12"))));
    }    
    
    @Test
    public void getResponsaveis_deve_trazer_o_valor_armazenado_em_responsaveis() {
        empresa.setResponsaveis(responsaveis);
        assertThat(empresa.getResponsaveis(), is(equalTo(responsaveis)));
    }
    
    @Test
    public void getContratosTrabalho_deve_trazer_o_valor_armazenado_em_contratosTrabalho() {
        empresa.setContratosTrabalho(contratosTrabalho);
        assertThat(empresa.getContratosTrabalho(), is(equalTo(contratosTrabalho)));
    }
    
    @Test
    public void getEnderecos_deve_trazer_o_valor_armazenado_em_enderecos() {
        empresa.setEnderecos(enderecos);
        assertThat(empresa.getEnderecos(), is(equalTo(enderecos)));
    }
    
    @Test
    public void getTelefonesFixo_deve_trazer_o_valor_armazenado_em_telefonesFixo() {
        empresa.setTelefonesFixo(telefonesFixo);
        assertThat(empresa.getTelefonesFixo(), is(equalTo(telefonesFixo)));
    }
    
    @Test
    public void getEmails_deve_trazer_o_valor_armazenado_em_emails() {
        empresa.setEmails(emails);
        assertThat(empresa.getEmails(), is(equalTo(emails)));
    }

    @Test
    public void getCelulares_deve_trazer_o_valor_armazenado_em_celulares() {
        empresa.setCelulares(celulares);
        assertThat(empresa.getCelulares(), is(equalTo(celulares)));
    }
    
    @Test
    public void getContas_deve_trazer_o_valor_armazenado_em_contas() {
        empresa.setContas(contas);
        assertThat(empresa.getContas(), is(equalTo(contas)));
    }
    
    @Test
    public void getTipoEmpresa_deve_trazer_o_valor_armazenado_em_tipoEmpresa() {
        empresa.setTipoEmpresa(TipoEmpresa.SOCIEDADE);
        assertThat(empresa.getTipoEmpresa(), is(equalTo(TipoEmpresa.SOCIEDADE)));
    }
    
    @Test
    public void getTipoPorteEmpresa_deve_trazer_o_valor_armazenado_em_tipoPorteEmpresa() {
        empresa.setTipoPorteEmpresa(TipoPorteEmpresa.EPP);
        assertThat(empresa.getTipoPorteEmpresa(), is(equalTo(TipoPorteEmpresa.EPP)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Empresa.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Empresa.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"13282774000102", "Empresa SA", LocalDate.parse("1990-02-12"), responsaveis, enderecos, TipoEmpresa.SOCIEDADE, TipoPorteEmpresa.EPP};
        assertTrue(verificaConstrutor(empresa, valores, String.class, String.class, LocalDate.class, Set.class, Set.class, TipoEmpresa.class, TipoPorteEmpresa.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_cnpj_igual() {
        outroEmpresa.setCnpj(empresa.getCnpj());
        assertThat(empresa.hashCode(), is(equalTo(outroEmpresa.hashCode())));
    }
        
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cnpj_diferente() {
        assertThat(empresa.hashCode(), is(not(equalTo(outroEmpresa.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_cnpj_igual() {
        outroEmpresa.setCnpj(empresa.getCnpj());
        assertTrue(empresa.equals(outroEmpresa));
    }
        
    @Test
    public void equals_deve_retornar_false_com_cnpj_diferente() {
        assertFalse(empresa.equals(outroEmpresa));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Empresa.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cnpj_no_texto_gerado_pelo_metodo_toString() {
        empresa.setCnpj("13282774000102");
        assertTrue(empresa.toString().contains("13282774000102"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_razaoSocial_no_texto_gerado_pelo_metodo_toString() {
        empresa.setRazaoSocial("Empresa SA");
        assertTrue(empresa.toString().contains("Empresa SA"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_dataAbertura_no_texto_gerado_pelo_metodo_toString() {
        empresa.setDataAbertura(LocalDate.parse("1990-02-12"));
        assertTrue(empresa.toString().contains("1990-02-12"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_responsaveis_no_texto_gerado_pelo_metodo_toString() {
        empresa.setResponsaveis(responsaveis);
        assertTrue(empresa.toString().contains(responsaveis.toString()));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_contratosTrabalho_no_texto_gerado_pelo_metodo_toString() {
        empresa.setContratosTrabalho(contratosTrabalho);
        assertTrue(empresa.toString().contains(contratosTrabalho.toString()));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_enderecos_no_texto_gerado_pelo_metodo_toString() {
        empresa.setEnderecos(enderecos);
        assertTrue(empresa.toString().contains(enderecos.toString()));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_telefonesFixo_no_texto_gerado_pelo_metodo_toString() {
        empresa.setTelefonesFixo(telefonesFixo);
        assertTrue(empresa.toString().contains(telefonesFixo.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_telefonesFixo_nulo() {
        empresa.setTelefonesFixo(null);
        assertTrue(empresa.toString().contains("Sem telefone fixo"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_emails_no_texto_gerado_pelo_metodo_toString() {
        empresa.setEmails(emails);
        assertTrue(empresa.toString().contains(emails.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_emails_nulo() {
        empresa.setEmails(null);
        assertTrue(empresa.toString().contains("Sem e-mail"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_celulares_no_texto_gerado_pelo_metodo_toString() {
        empresa.setCelulares(celulares);
        assertTrue(empresa.toString().contains(celulares.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_celulares_nulo() {
        empresa.setCelulares(null);
        assertTrue(empresa.toString().contains("Sem celular"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_contas_no_texto_gerado_pelo_metodo_toString() {
        empresa.setContas(contas);
        assertTrue(empresa.toString().contains(contas.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_contas_nulo() {
        empresa.setContas(null);
        assertTrue(empresa.toString().contains("Sem conta banc\\u00E1ria"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoEmpresa_no_texto_gerado_pelo_metodo_toString() {
        empresa.setTipoEmpresa(TipoEmpresa.SOCIEDADE);
        assertTrue(empresa.toString().contains(TipoEmpresa.SOCIEDADE.name()));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoPorteEmpresa_no_texto_gerado_pelo_metodo_toString() {
        empresa.setTipoPorteEmpresa(TipoPorteEmpresa.EPP);
        assertTrue(empresa.toString().contains(TipoPorteEmpresa.EPP.name()));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(empresa));
    }
    
}
