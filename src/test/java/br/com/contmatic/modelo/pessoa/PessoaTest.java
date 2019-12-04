package br.com.contmatic.modelo.pessoa;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO;
import static br.com.contmatic.utilidades.MensagensErro.STRING_CPF_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.STRING_NOME_INVALIDO;
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
import br.com.contmatic.utilidades.templates.conta.ContaTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.CelularTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.EmailTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.utilidades.templates.pessoa.PessoaTemplateFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PessoaTest {
    
    private Pessoa pessoa;
    
    private Pessoa outroPessoa;
    
    private Set<Endereco> enderecos = new HashSet<Endereco>();

    private Set<Endereco> enderecosInvalido = new HashSet<Endereco>();
    
    private Set<Celular> celulares = new HashSet<Celular>();

    private Set<Celular> celularesInvalido = new HashSet<Celular>();
    
    private Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();
    
    private Set<TelefoneFixo> telefonesFixoInvalido = new HashSet<TelefoneFixo>();

    private Set<Email> emails = new HashSet<Email>();

    private Set<Email> emailsInvalido = new HashSet<Email>();
    
    private Set<Conta> contas = new HashSet<Conta>();
    
    private Set<Conta> contasInvalido = new HashSet<Conta>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new PessoaTemplateFixtureFactory().load();
        new EnderecoTemplateFixtureFactory().load();
        new CelularTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();
        new EmailTemplateFixtureFactory().load();
        new ContaTemplateFixtureFactory().load();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        pessoa = Fixture.from(Pessoa.class).gimme("valido");
        outroPessoa = Fixture.from(Pessoa.class).gimme("outroValido");
        for (int i = 0; i < ELEMENTOS_ARRAY_GERADA; i++) {
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        	emails.add(Fixture.from(Email.class).gimme("valido"));
        	contas.add(Fixture.from(Conta.class).gimme("valido"));
        	enderecosInvalido.add(Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoCep"));
        	celularesInvalido.add(Fixture.from(Celular.class).gimme("comUmCaractereInvalidoNumero"));
        	telefonesFixoInvalido.add(Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero"));
        	emailsInvalido.add(Fixture.from(Email.class).gimme("comUmCaractereInvalidoAntesArrobaEndereco"));
        	contasInvalido.add(Fixture.from(Conta.class).gimme("comUmCaractereInvalidoNumero"));
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    //cpf
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cpf() {
        pessoa.setCpf(null);
        assertTrue(verificaErro(pessoa, VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("naoNuloCpf");
        assertFalse(verificaErro(pessoa, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("maiorTamanhoCpf");
        assertTrue(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("menorTamanhoCpf");
        assertTrue(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }
        
    @Test
    public void nao_deve_aceitar_valor_com_caractere_invalido_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("comCaractereInvalidoCpf");
        assertTrue(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("comUmCaractereInvalidoCpf");
        assertTrue(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_apenas_numeros_repetidos_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("numerosRepetidosCpf");
        assertTrue(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_cpf_com_um_digito_verificador_invalido() {
        pessoa = Fixture.from(Pessoa.class).gimme("comUmDigitoVerificadorInvalidoCpf");
        assertTrue(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }    
    
    @Test
    public void deve_aceitar_cpf_valido() {
        pessoa = Fixture.from(Pessoa.class).gimme("cpfValido");
        assertFalse(verificaErro(pessoa, STRING_CPF_INVALIDO));
    }
    
    //nome
    
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        pessoa.setNome(null);
        assertTrue(verificaErro(pessoa, VALOR_NULO));
    }
    
    @Test
    public void deve_aceitar_valor_nao_nulo_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("naoNuloNome");
        assertFalse(verificaErro(pessoa, VALOR_NULO));
    }

    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
    	pessoa.setNome("");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("maiorTamanhoNome");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_invalido_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comPrimeiroCaractereInvalido");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_dois_espacos_juntos_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comEspacoDuploNome");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }
    
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_espaco_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comEspacoInicioNome");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }

    @Test
    public void nao_deve_aceitar_valor_com_ultimo_caractere_espaco_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comEspacoFimNome");
        assertTrue(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }

    @Test
    public void deve_aceitar_nome_valido() {
        pessoa = Fixture.from(Pessoa.class).gimme("nomeValido");
        assertFalse(verificaErro(pessoa, STRING_NOME_INVALIDO));
    }
        
    //enderecos
    
    @Test
    public void nao_deve_aceitar_enderecos_nulo() {
    	pessoa.setEnderecos(null);
    	assertTrue(verificaErro(pessoa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }

    @Test
    public void nao_deve_aceitar_enderecos_vazio() {
    	pessoa.setEnderecos(new HashSet<Endereco>());
    	assertTrue(verificaErro(pessoa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_enderecos_com_elementos_nulos() {
    	pessoa.getEnderecos().add(null);
    	assertTrue(verificaErro(pessoa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void deve_aceitar_enderecos_nao_nulo_e_nao_vazio_e_sem_elementos_nulos() {
    	pessoa.setEnderecos(enderecos);
    	assertFalse(verificaErro(pessoa, VALOR_NULO_COLLECTION_VAZIA_OU_COM_ELEMENTO_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_enderecos_invalido() {
    	pessoa.setEnderecos(enderecosInvalido);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    @Test
    public void deve_aceitar_enderecos_valido() {
    	pessoa.setEnderecos(enderecos);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    //dataNascimento
    
    @Test
    public void nao_deve_aceitar_dataNascimento_nulo() {
    	pessoa.setDataNascimento(null);
    	assertTrue(verificaErro(pessoa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_dataNascimento_nao_nulo() {
    	pessoa = Fixture.from(Pessoa.class).gimme("dataNascimentoQualquer");
    	assertFalse(verificaErro(pessoa, VALOR_NULO));
    }
    
    @Test
    public void nao_deve_aceitar_dataNascimento_futura() {
    	pessoa = Fixture.from(Pessoa.class).gimme("dataNascimentoFutura");
    	assertTrue(verificaErro(pessoa, DATA_PASSADO));
    }

    @Test
    public void deve_aceitar_dataNascimento_passada() {
    	pessoa = Fixture.from(Pessoa.class).gimme("dataNascimentoPassada");
    	assertFalse(verificaErro(pessoa, DATA_PASSADO));
    }

    //celulares
    
    @Test
    public void nao_deve_aceitar_celulares_invalido() {
    	pessoa.setCelulares(celularesInvalido);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    @Test
    public void deve_aceitar_celulares_valido() {
    	pessoa.setCelulares(celulares);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    //telefonesFixo
    
    @Test
    public void nao_deve_aceitar_telefonesFixo_invalido() {
    	pessoa.setTelefonesFixo(telefonesFixoInvalido);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    @Test
    public void deve_aceitar_telefonesFixo_valido() {
    	pessoa.setTelefonesFixo(telefonesFixo);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    //emails
    
    @Test
    public void nao_deve_aceitar_emails_invalido() {
    	pessoa.setEmails(emailsInvalido);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    @Test
    public void deve_aceitar_emails_valido() {
    	pessoa.setEmails(emails);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    //tipoGrauInstrucao
    
    @Test
    public void nao_deve_aceitar_tipoGrauInstrucao_nulo() {
    	pessoa.setTipoGrauInstrucao(null);
    	assertTrue(verificaErro(pessoa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoGrauInstrucao_nao_nulo() {
    	pessoa.setTipoGrauInstrucao(TipoGrauInstrucao.ANALFABETO);
    	assertFalse(verificaErro(pessoa, VALOR_NULO));
    }

    //tipoEstadoCivil
    
    @Test
    public void nao_deve_aceitar_tipoEstadoCivil_nulo() {
    	pessoa.setTipoEstadoCivil(null);
    	assertTrue(verificaErro(pessoa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoEstadoCivil_nao_nulo() {
    	pessoa.setTipoEstadoCivil(TipoEstadoCivil.CASADO);
    	assertFalse(verificaErro(pessoa, VALOR_NULO));
    }

    //tipoSexo
    
    @Test
    public void nao_deve_aceitar_tipoSexo_nulo() {
    	pessoa.setTipoSexo(null);
    	assertTrue(verificaErro(pessoa, VALOR_NULO));
    }

    @Test
    public void deve_aceitar_tipoSexo_nao_nulo() {
    	pessoa.setTipoSexo(TipoSexo.FEMININO);
    	assertFalse(verificaErro(pessoa, VALOR_NULO));
    }

    //contas
    
    @Test
    public void nao_deve_aceitar_contas_invalido() {
    	pessoa.setContas(contasInvalido);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    @Test
    public void deve_aceitar_contas_valido() {
    	pessoa.setContas(contas);
    	assertFalse(procuraAlgumErro(pessoa));
    }
    
    //getter e setter    
    
    @Test
    public void getCpf_deve_trazer_o_valor_armazenado_em_cpf() {
        pessoa.setCpf("28361440844");
        assertThat(pessoa.getCpf(), is(equalTo("28361440844")));
    }
    
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        pessoa.setNome("Gabriel Marques");
        assertThat(pessoa.getNome(), is(equalTo("Gabriel Marques")));
    }
    
    @Test
    public void getEnderecos_deve_trazer_o_valor_armazenado_em_enderecos() {
        pessoa.setEnderecos(enderecos);
        assertThat(pessoa.getEnderecos(), is(equalTo(enderecos)));
    }
    
    @Test
    public void getDataNascimento_deve_trazer_o_valor_armazenado_em_dataNascimento() {
        pessoa.setDataNascimento(LocalDate.parse("1990-02-12"));
        assertThat(pessoa.getDataNascimento(), is(equalTo(LocalDate.parse("1990-02-12"))));
    }

    @Test
    public void getCelulares_deve_trazer_o_valor_armazenado_em_celulares() {
        pessoa.setCelulares(celulares);
        assertThat(pessoa.getCelulares(), is(equalTo(celulares)));
    }
    
    @Test
    public void getTelefonesFixo_deve_trazer_o_valor_armazenado_em_telefonesFixo() {
        pessoa.setTelefonesFixo(telefonesFixo);
        assertThat(pessoa.getTelefonesFixo(), is(equalTo(telefonesFixo)));
    }
    
    @Test
    public void getEmails_deve_trazer_o_valor_armazenado_em_emails() {
        pessoa.setEmails(emails);
        assertThat(pessoa.getEmails(), is(equalTo(emails)));
    }

    @Test
    public void getTipoGrauInstrucao_deve_trazer_o_valor_armazenado_em_tipoGrauInstrucao() {
        pessoa.setTipoGrauInstrucao(TipoGrauInstrucao.ANALFABETO);
        assertThat(pessoa.getTipoGrauInstrucao(), is(equalTo(TipoGrauInstrucao.ANALFABETO)));
    }
    
    @Test
    public void getTipoEstadoCivil_deve_trazer_o_valor_armazenado_em_tipoEstadoCivil() {
        pessoa.setTipoEstadoCivil(TipoEstadoCivil.CASADO);
        assertThat(pessoa.getTipoEstadoCivil(), is(equalTo(TipoEstadoCivil.CASADO)));
    }
    
    @Test
    public void getTipoSexo_deve_trazer_o_valor_armazenado_em_tipoSexo() {
        pessoa.setTipoSexo(TipoSexo.FEMININO);
        assertThat(pessoa.getTipoSexo(), is(equalTo(TipoSexo.FEMININO)));
    }
    
    @Test
    public void getContas_deve_trazer_o_valor_armazenado_em_contas() {
        pessoa.setContas(contas);
        assertThat(pessoa.getContas(), is(equalTo(contas)));
    }
    
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Pessoa.class).testing(GETTER).areWellImplemented();
    }
    
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Pessoa.class).testing(SETTER).areWellImplemented();
    }
    
    //construtor
    
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"28361440844", "Gabriel Marques", enderecos, LocalDate.parse("1990-02-12"), TipoGrauInstrucao.ANALFABETO, TipoEstadoCivil.CASADO, TipoSexo.FEMININO};
        assertTrue(verificaConstrutor(pessoa, valores, String.class, String.class, Set.class, LocalDate.class, TipoGrauInstrucao.class, TipoEstadoCivil.class, TipoSexo.class));
    }
    
    //equals e hashcode
    
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_cpf_igual() {
        outroPessoa.setCpf(pessoa.getCpf());
        assertThat(pessoa.hashCode(), is(equalTo(outroPessoa.hashCode())));
    }
        
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cpf_diferente() {
        assertThat(pessoa.hashCode(), is(not(equalTo(outroPessoa.hashCode()))));
    }
        
    @Test
    public void equals_deve_retornar_true_com_cpf_igual() {
        outroPessoa.setCpf(pessoa.getCpf());
        assertTrue(pessoa.equals(outroPessoa));
    }
        
    @Test
    public void equals_deve_retornar_false_com_cpf_diferente() {
        assertFalse(pessoa.equals(outroPessoa));
    }
    
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Pessoa.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    //toString
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cpf_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setCpf("28361440844");
        assertTrue(pessoa.toString().contains("28361440844"));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setNome("Gabriel Marques");
        assertTrue(pessoa.toString().contains("Gabriel Marques"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_enderecos_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setEnderecos(enderecos);
        assertTrue(pessoa.toString().contains(enderecos.toString()));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_dataNascimento_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setDataNascimento(LocalDate.parse("1990-02-12"));
        assertTrue(pessoa.toString().contains("1990-02-12"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_celulares_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setCelulares(celulares);
        assertTrue(pessoa.toString().contains(celulares.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_celulares_nulo() {
        pessoa.setCelulares(null);
        assertTrue(pessoa.toString().contains("Sem celular"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_telefonesFixo_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTelefonesFixo(telefonesFixo);
        assertTrue(pessoa.toString().contains(telefonesFixo.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_telefonesFixo_nulo() {
        pessoa.setTelefonesFixo(null);
        assertTrue(pessoa.toString().contains("Sem telefone fixo"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_emails_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setEmails(emails);
        assertTrue(pessoa.toString().contains(emails.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_emails_nulo() {
        pessoa.setEmails(null);
        assertTrue(pessoa.toString().contains("Sem e-mail"));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoGrauInstrucao_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTipoGrauInstrucao(TipoGrauInstrucao.ANALFABETO);
        assertTrue(pessoa.toString().contains(TipoGrauInstrucao.ANALFABETO.name()));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoEstadoCivil_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTipoEstadoCivil(TipoEstadoCivil.CASADO);
        assertTrue(pessoa.toString().contains(TipoEstadoCivil.CASADO.name()));
    }

    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoSexo_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTipoSexo(TipoSexo.FEMININO);
        assertTrue(pessoa.toString().contains(TipoSexo.FEMININO.name()));
    }
    
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_contas_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setContas(contas);
        assertTrue(pessoa.toString().contains(contas.toString()));
    }

    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_contas_nulo() {
        pessoa.setContas(null);
        assertTrue(pessoa.toString().contains("Sem conta banc\\u00E1ria"));
    }
    
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(pessoa));
    }
    
}
