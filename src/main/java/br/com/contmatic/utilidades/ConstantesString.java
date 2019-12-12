package br.com.contmatic.utilidades;

public class ConstantesString {
        
    //regex simples
    public static final String NUMERAL = "[0-9]";
    public static final String APENAS_LETRA_NUMERAL = "[A-Za-z0-9]";
    
    //regex complexa
    public static final String EMAIL = "^[a-z0-9]+[a-z0-9._-]*(?<![-_\\.])@[a-z0-9]+[a-z0-9.-]*(?<![-_\\.])\\.[a-z]{2,6}$";    
    public static final String NOME = "^[A-ZÁÉÍÓÚÃÕÀÂÊÔ]([A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[-'ç]|([ ](?![ ]))){0," + (ConstantesNumericas.TAMANHO_REGULAR - 2) + "}[A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]$";
    public static final String NOT_BLANK = ".*\\S.*";
    public static final String CELULAR = NUMERAL + "{" + ConstantesNumericas.NUMERO_CELULAR + "}";
    public static final String TELEFONE = NUMERAL + "{" + ConstantesNumericas.NUMERO_TELEFONE + "}";
    public static final String DDD = NUMERAL + "{" + ConstantesNumericas.DDD + "}";
    public static final String CEP = NUMERAL + "{" + ConstantesNumericas.CEP + "}";
    public static final String NUMERO_ENDERECO = NUMERAL + "{1," + ConstantesNumericas.MAX_NUMERO_ENDERECO + "}";
    public static final String CODIGO_BANCO = APENAS_LETRA_NUMERAL + "{1," + ConstantesNumericas.MAX_CODIGO_BANCO + "}";
    public static final String NUMERO_AGENCIA = APENAS_LETRA_NUMERAL + "{1," + ConstantesNumericas.MAX_NUMERO_AGENCIA + "}";
    public static final String NUMERO_CONTA = APENAS_LETRA_NUMERAL + "{1," + ConstantesNumericas.MAX_NUMERO_CONTA + "}";
    public static final String RAZAO_SOCIAL = "^[A-ZÁÉÍÓÚÃÕÀÂÊÔ]([A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[&'ç\\-\\.]|([ ](?![ ]))){0," + (ConstantesNumericas.TAMANHO_REGULAR - 2) + "}([A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|\\.)$";
    
    private ConstantesString() {
    }

}
