package br.com.contmatic.utilidades;

public class ConstantesString {
    
    //não permite determinados caracteres
    public static final String SEM_ESPACO = "\\S*";
    
    //permite apenas determinados caracteres
    public static final String APENAS_NUMERAL = "\\d*";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]*";
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    
    //regex complexa
    public static final String EMAIL = "^[a-z0-9]+[a-z0-9._-]*(?<![-_\\.])@[a-z0-9]+[a-z0-9.-]*(?<![-_\\.])\\.[a-z]{2,6}$";    
    public static final String NOME_PESSOA = "^([A-Z]|[ÁÉÍÓÚÃÕÀÂÊÔ]){1}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|['ç]|([ ](?![ ]))){1," + (ConstantesNumericas.CAMPO_REGULAR - 2) + "}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]){1}$";
    public static final String CELULAR = "[0-9]{" + ConstantesNumericas.NUMERO_CELULAR + "}";
    public static final String TELEFONE = "[0-9]{" + ConstantesNumericas.NUMERO_TELEFONE + "}";
    public static final String DDD = "[0-9]{" + ConstantesNumericas.DDD + "}";
    public static final String CODIGO_BANCO = "[A-Za-z0-9]{1," + ConstantesNumericas.MAX_CODIGO_BANCO + "}";
    public static final String RAZAO_SOCIAL = "^([A-Z]|[ÁÉÍÓÚÃÕÀÂÊÔ]){1}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[&'ç\\-\\.]|([ ](?![ ]))){1," + (ConstantesNumericas.CAMPO_REGULAR - 2) + "}([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|\\.){1}$";
    
    private ConstantesString() {
    }

}
