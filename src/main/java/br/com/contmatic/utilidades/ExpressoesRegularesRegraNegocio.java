package br.com.contmatic.utilidades;

public class ExpressoesRegularesRegraNegocio {
    
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    public static final String APENAS_NUMERAL = "\\d*";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]*";
    public static final String SEM_ESPACO = "\\S*";
    public static final String EMAIL = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";    
    public static final String UM = "1";   
    public static final String ZERO = "0";   
    
    private ExpressoesRegularesRegraNegocio() {
    }

}
