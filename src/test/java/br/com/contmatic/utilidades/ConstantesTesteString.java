package br.com.contmatic.utilidades;

public class ConstantesTesteString {
    
    //gerador random
    public static final String UNVIVERSO_CARACTERES = "AZQSWXCDERÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô FVBGTYHNMJUIKLOPÇ><:?}{`´^~ºª=+§-_)(*&¨%#@!¹²³£¢¬1234567890qazxswedcvfrtgbnhyujmkilopç,.;/\\]['\"";
    
    //regex    
    public static final String SEM_ESPACO = "\\S*";
    public static final String APENAS_NUMERAL = "[0-9]";
    public static final String APENAS_LETRA = "\\w";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]";
    public static final String APENAS_ESPACO = "\\s";
    public static final String APENAS_LETRA_ESPACO = "(\\w|[ ])*";
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    public static final String LETRAS_ESPACO_VALIDOS_NOME = "([A-Z]|[a-z]|[ ]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô])+";
	public static final String APENAS_LETRAS_VALIDAS_NOME = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô])+";
	public static final String INVALIDOS_ANTES_PONTO = "[A-Zªº;:/@\\$´`\\^~\\}\\{?!\\]\\[\\)\\+\\*\\\"\\(\\#°§¬¢£³²¹¨,'&%ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]";
	public static final String INVALIDOS_DEPOIS_PONTO = "[\\dA-Zªº;:/@\\$´`\\^~\\}\\{?!\\]\\[\\)\\+\\*\\\"\\(\\#°§¬¢£³²¹¨,'&%ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]";
    
    public ConstantesTesteString() {
    }

}
