package br.com.contmatic.utilidades;

public class MensagensErro {
    
    //objeto
    public static final String VALOR_NULO = "O campo não pode ser nulo.";
    
    //String
    public static final String STRING_VAZIO = "O campo não pode estar vazio.";
    public static final String STRING_APENAS_ESPACO = "O campo não pode possuir apenas espaços em branco.";
    public static final String STRING_APENAS_LETRA_ESPACO = "O campo pode possuir apenas letras e espaços em branco.";
    public static final String STRING_COM_ESPACO = "O campo não pode possuir espaços em branco.";
    public static final String STRING_MAX = "O campo pode possuir no máximo {max} caracteres.";
    public static final String STRING_MIN = "O campo pode possuir no mínimo {min} caracteres.";
    public static final String STRING_CARACTERE_ESPECIAL = "O campo não pode possuir caracteres especiais.";
    public static final String STRING_NAO_NUMERAL = "O campo não pode possuir caracteres que não sejam numerais.";
    public static final String STRING_NAO_FORMATO_EMAIL = "O campo deve ser um endereço de e-mail.";
    public static final String STRING_APENAS_NUMERO_REPETIDO = "O campo não pode conter todos os números iguais.";
    public static final String STRING_CPF_INVALIDO = "O campo deve conter um CPF válido.";
    public static final String STRING_NOME_INVALIDO = "O campo deve conter um nome válido.";
    
    //double, float, respectivas wrappers e BigDecimal
    public static final String DECIMAL_MAX = "O campo não pode ser maior que {value}.";
    public static final String DECIMAL_MIN = "O campo não pode ser menor que {value}.";
    
    //LocalDate
    public static final String DATA_PASSADO = "A data deve ser anterior à data atual.";
    
    private MensagensErro() {
    }

}
