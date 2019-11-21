package br.com.contmatic.utilidades;

public class MensagensErro {
    
    //objeto
    public static final String VALOR_NULO = "O campo não pode ser nulo.";
    
    //String
    public static final String STRING_VAZIO = "O campo não pode estar vazio.";
    public static final String STRING_APENAS_ESPACO = "O campo não pode possuir apenas espaços em branco.";
    public static final String STRING_MAX = "O campo pode possuir no máximo {max} caracteres.";
    public static final String STRING_MIN = "O campo pode possuir no mínimo {min} caracteres.";
    public static final String STRING_CARACTERE_ESPECIAL = "O campo não pode possuir caracteres especiais.";
    public static final String STRING_NAO_NUMERAL = "O campo não pode possuir caracteres que não sejam numerais.";
    
    //double, float, respectivas wrappers e BigDecimal
    public static final String DECIMAL_MAX = "O campo não pode ser maior que {value}.";
    public static final String DECIMAL_MIN = "O campo não pode ser menor que {value}.";
    
    private MensagensErro() {
    }

}
