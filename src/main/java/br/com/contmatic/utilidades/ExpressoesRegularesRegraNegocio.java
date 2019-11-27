package br.com.contmatic.utilidades;

public class ExpressoesRegularesRegraNegocio {
    
    //não permite determinados caracteres
    public static final String SEM_ESPACO = "\\S*";
    
    //permite apenas determinados caracteres
    public static final String APENAS_NUMERAL = "\\d*";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]*";
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    
    //regex complexa
    public static final String EMAIL = "^[a-z0-9]+[a-z0-9._-]*(?<![-_\\.])@[a-z0-9]+[a-z0-9.-]*(?<![-_\\.])\\.[a-z]{2,6}$";    
    public static final String NOME_PESSOA = "^[\\w]{1}(\\w|[ ](?![ ])){1," + (ConstantesNumericas.CAMPO_REGULAR - 2) + "}[\\w]{1}$";
    
    //constante
    public static final String UM = "1";   
    public static final String ZERO = "0";   
    
    private ExpressoesRegularesRegraNegocio() {
    }

}
