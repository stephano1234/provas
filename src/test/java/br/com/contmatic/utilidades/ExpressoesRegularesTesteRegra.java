package br.com.contmatic.utilidades;

public class ExpressoesRegularesTesteRegra {
    
    //teste
    public static final String UNVIVERSO_CARACTERES = "AZQSWXCDERÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô FVBGTYHNMJUIKLOPÇ><:?}{`´^~ºª=+§-_)(*&¨%#@!¹²³£¢¬1234567890qazxswedcvfrtgbnhyujmkilopç,.;/\\]['\"";
    
    //não permite determinados caracteres    
    public static final String SEM_ESPACO = "\\S*";
    
    //permite apenas determinados caracteres
    public static final String APENAS_NUMERAL = "\\d*";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]*";
    public static final String APENAS_ESPACO = "\\s*";
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    public static final String LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_UNDERLINE_TRACO = "([a-z]|[0-9]|[_]|[-])*";
    public static final String LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_UNDERLINE_TRACO_PONTO = "([a-z]|[0-9]|[\\.]|[_]|[-])*";
    public static final String LETRA_MINUSCULA_SEM_ACENTO_NUMERAL = "([a-z]|[0-9])*";
    public static final String LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_TRACO_PONTO = "([a-z]|[0-9]|[\\.]|[-])*";
    public static final String LETRA_MINUSCULA_SEM_ACENTO = "[a-z]*";
    public static final String UNDERLINE_TRACO_PONTO = "[-_\\.]*";
    public static final String PONTO_REGEX = "\\.";
    
    //regex complexa
    public static final String EMAIL = "^[a-z0-9]+[a-z0-9._-]*(?<![-_\\.])@[a-z0-9]+[a-z0-9.-]*(?<![-_\\.])\\.[a-z]{2,6}$";    
    
    //regex busca
    public static final String ANTES_ARROBA = ".*@";
    public static final String DEPOIS_ARROBA_ANTES_PONTO = "@{1}.*\\.(?!.*\\.)";
    public static final String DEPOIS_PONTO = "\\.(?!.*\\.).*";
    public static final String ANTES_PONTO = ".*\\.(?!.*\\.)";
    public static final String DEPOIS_ARROBA = "@.+";
    public static final String PRIMEIRO_DEPOIS_ARROBA = "(?<=[@]).{1}";
    
    //constante
    public static final String UM = "1";   
    public static final String ZERO = "0";
    public static final String ARROBA = "@";
    public static final String PONTO = ".";
    public static final String APENAS_EXCLUI_CARACTERE = "";
    
    public ExpressoesRegularesTesteRegra() {
    }

}
