package br.com.contmatic.utilidades;

public class ConstantesTesteString {
    
    //teste
    public static final String UNVIVERSO_CARACTERES = "AZQSWXCDERÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô FVBGTYHNMJUIKLOPÇ><:?}{`´^~ºª=+§-_)(*&¨%#@!¹²³£¢¬1234567890qazxswedcvfrtgbnhyujmkilopç,.;/\\]['\"";
    
    //não permite determinados caracteres    
    public static final String SEM_ESPACO = "\\S*";
    
    //permite apenas determinados caracteres
    public static final String APENAS_NUMERAL = "\\d";
    public static final String APENAS_LETRA = "\\w";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]";
    public static final String APENAS_ESPACO = "\\s";
    public static final String APENAS_LETRA_ESPACO = "(\\w|[ ])*";
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    public static final String LETRAS_ESPACO_VALIDOS_NOME = "([A-Z]|[a-z]|[ ]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô])+";
	public static final String APENAS_LETRAS_VALIDAS_NOME = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô])+";
	public static final String INVALIDOS_ANTES_PONTO = "[A-Zªº;:/@\\$´`\\^~\\}\\{?!\\]\\[\\)\\+\\*\\\"\\(\\#°§¬¢£³²¹¨,'&%ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]";
	public static final String INVALIDOS_DEPOIS_PONTO = "[\\dA-Zªº;:/@\\$´`\\^~\\}\\{?!\\]\\[\\)\\+\\*\\\"\\(\\#°§¬¢£³²¹¨,'&%ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]";
    
    //regex complexa
    public static final String EMAIL = "^[a-z0-9]+[a-z0-9._-]*(?<![-_\\.])@[a-z0-9]+[a-z0-9.-]*(?<![-_\\.])\\.[a-z]{2,6}$";    
    public static final String NOME_PESSOA = "^([A-Z]|[ÁÉÍÓÚÃÕÀÂÊÔ]){1}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|['ç]|([ ](?![ ]))){1," + (ConstantesTesteNumericas.CAMPO_REGULAR - 2) + "}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]){1}$";
    public static final String APENAS_UM_ESPACO_ENTRE_LETRAS = "^([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô])+[ ]{1}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô])+$";
    public static final String CELULAR = "[0-9]{" + ConstantesTesteNumericas.NUMERO_CELULAR + "}";
    public static final String TELEFONE = "[0-9]{" + ConstantesTesteNumericas.NUMERO_TELEFONE + "}";
    public static final String DDD = "[0-9]{" + ConstantesTesteNumericas.DDD + "}";

    //constante
    public static final String ESPACO = " ";
    
    public ConstantesTesteString() {
    }

}
