package br.com.contmatic.utilidades;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.collections4.map.LinkedMap;

public class VerificadoresRegras {

    private static Validator validator;
    private static ValidatorFactory factory;  
    
    public static boolean verificaErro(Object objetoTestado, String mensagem) {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        boolean possuiErro = false;
        Set<ConstraintViolation<Object>> violacoes = validator.validate(objetoTestado);
        for (ConstraintViolation<Object> violacao : violacoes) {
            if (violacao.getMessageTemplate().equals(mensagem)) {
                possuiErro = true;
            }
        }
        return possuiErro;
    }
    
    public static boolean procuraAlgumErro(Object objetoTestado) {  
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violacoes = validator.validate(objetoTestado);
        return !violacoes.isEmpty();
    }
    
    public static boolean verificaToStringJSONSTYLE(Object objetoTestado) {
        StringBuilder formatoEsperado = new StringBuilder("{");
        Field[] campos = objetoTestado.getClass().getDeclaredFields();
        for(Field campo : campos) {
            campo.setAccessible(true);
            formatoEsperado.append("\"").append(campo.getName()).append("\":\"");
            try {
                if (campo.get(objetoTestado).toString().charAt(0) == '{') {
                    formatoEsperado.deleteCharAt(formatoEsperado.length() - 1);
                }
            }
            catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
            try {
                if (campo.get(objetoTestado).getClass().isEnum()) {
                    formatoEsperado.append(transformaCaractereAcentoEmCodUnicode(campo.get(objetoTestado).getClass().getSuperclass().getMethod("name").invoke(campo.get(objetoTestado)).toString())).append("\",");
                }
                else {
                    formatoEsperado.append(transformaCaractereAcentoEmCodUnicode(campo.get(objetoTestado).toString())).append("\",");
                }
            }
            catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
                return false;
            }
            try {
                if (campo.get(objetoTestado).toString().charAt(0) == '{') {
                    formatoEsperado.deleteCharAt(formatoEsperado.length() - 2);
                }
            }
            catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        formatoEsperado.deleteCharAt(formatoEsperado.length() - 1);
        formatoEsperado.append("}");
        return objetoTestado.toString().equals(formatoEsperado.toString());
    }
    
    public static String transformaCaractereAcentoEmCodUnicode(String string) {
        String letrasAcentuadas = "ÁáÉéÍíÓóÚúÀàÂâÊêÔôÃãÕõªºç";
        Map<String, String> tabelaAcentos = new LinkedMap<String, String>();
        tabelaAcentos.put("Á", "\\u00C1");
        tabelaAcentos.put("á", "\\u00E1");
        tabelaAcentos.put("É", "\\u00C9");
        tabelaAcentos.put("é", "\\u00E9");
        tabelaAcentos.put("Í", "\\u00CD");
        tabelaAcentos.put("í", "\\u00ED");
        tabelaAcentos.put("Ó", "\\u00D3");
        tabelaAcentos.put("ó", "\\u00F3");
        tabelaAcentos.put("Ú", "\\u00DA");
        tabelaAcentos.put("ú", "\\u00FA");
        tabelaAcentos.put("Â", "\\u00C2");
        tabelaAcentos.put("â", "\\u00E2");
        tabelaAcentos.put("Ê", "\\u00CA");
        tabelaAcentos.put("ê", "\\u00EA");
        tabelaAcentos.put("Ô", "\\u00D4");
        tabelaAcentos.put("ô", "\\u00F4");
        tabelaAcentos.put("Ã", "\\u00C3");
        tabelaAcentos.put("ã", "\\u00E3");
        tabelaAcentos.put("Õ", "\\u00D5");
        tabelaAcentos.put("õ", "\\u00F5");
        tabelaAcentos.put("ª", "\\u00AA");
        tabelaAcentos.put("º", "\\u00BA");
        tabelaAcentos.put("ç", "\\u00E7");
        StringBuilder stringTransformada = new StringBuilder(string);   
        String letraAcentuada;
        for (int i = 0; i < stringTransformada.length(); i++) {
            if (letrasAcentuadas.contains(stringTransformada.substring(i, i + 1))) {         
                letraAcentuada = tabelaAcentos.get(stringTransformada.substring(i, i + 1));
                stringTransformada.deleteCharAt(i);
                stringTransformada.insert(i, letraAcentuada);
                i += 5;
            }
        }
        return stringTransformada.toString();
    }
    
}
