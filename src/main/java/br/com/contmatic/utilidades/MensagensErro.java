package br.com.contmatic.utilidades;

public class MensagensErro {
    
    //objeto
    public static final String VALOR_NULO = "O campo não pode ser nulo.";
    
    //conjunto
    public static final String VAZIO_OU_COM_ELEMENTO_NULO = "O campo deve conter um conjunto de dados não vazio e sem elementos nulos.";
    
    //texto
    public static final String EMAIL_INVALIDO = "O campo deve ser um endereço de e-mail.";
    public static final String CPF_INVALIDO = "O campo deve conter um CPF válido.";
    public static final String CEP_INVALIDO = "O campo deve conter um CEP válido.";
    public static final String NUMERO_ENDERECO_INVALIDO = "O campo deve conter um número de endereço válido.";
    public static final String CNPJ_INVALIDO = "O campo deve conter um CNPJ válido.";
    public static final String NOME_INVALIDO = "O campo deve conter um nome válido.";
    public static final String NOT_BLANK_INVALIDO = "O campo deve conter ao menos um caractere que não seja um espaço em branco.";
    public static final String TAMANHO_INVALIDO = "O campo não pode ter menos de {min} ou mais de {max} caracteres.";
    public static final String CELULAR_INVALIDO = "O campo deve conter um celular válido.";
    public static final String TELEFONE_INVALIDO = "O campo deve conter um telefone válido.";
    public static final String DDD_INVALIDO = "O campo deve conter um DDD válido.";
    public static final String CODIGO_BANCO_INVALIDO = "O campo deve conter um código de banco válido.";
    public static final String RAZAO_SOCIAL_INVALIDO = "O campo deve conter uma Razão Social válida.";
    public static final String NUMERO_AGENCIA_INVALIDO = "O campo deve conter um número de agência válido.";
    public static final String NUMERO_CONTA_INVALIDO = "O campo deve conter um número de conta bancária válido.";
    
    //número racional
    public static final String DECIMAL_MAX = "O campo não pode ser maior que {value}.";
    public static final String DECIMAL_MIN = "O campo não pode ser menor que {value}.";
    
    //data
    public static final String DATA_PASSADO = "A data deve ser anterior à data atual.";
    
    private MensagensErro() {
    }

}
