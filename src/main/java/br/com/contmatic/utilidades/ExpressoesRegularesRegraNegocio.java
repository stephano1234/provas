package br.com.contmatic.utilidades;

public class ExpressoesRegularesRegraNegocio {
    
    public static final String SEM_CARACTERE_ESPECIAL = "([A-Z]|[a-z]|[ÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[\\.'ªº]|[-]|\\d|\\s)*";
    public static final String APENAS_NUMERAL = "\\d*";
    public static final String APENAS_LETRA_MAIUSCULA = "[A-Z]*";
    public static final String SEM_ESPACO = "\\S*";   
    
    private ExpressoesRegularesRegraNegocio() {
    }

}
