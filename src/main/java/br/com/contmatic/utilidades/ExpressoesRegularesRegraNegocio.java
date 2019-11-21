package br.com.contmatic.utilidades;

public class ExpressoesRegularesRegraNegocio {
    
    //não permite determinados caracteres
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    public static final String SEM_ESPACO = "\\S*";
    
    //permite apenas determinados caracteres
    public static final String APENAS_NUMERAL = "\\d*";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]*";
    
    //regex complexa
    public static final String EMAIL = "^[a-zA-Z0-9_-][a-zA-Z0-9._-]+@[a-zA-Z0_9][a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";    
    
    //constante
    public static final String UM = "1";   
    public static final String ZERO = "0";   
    
    private ExpressoesRegularesRegraNegocio() {
    }

}
