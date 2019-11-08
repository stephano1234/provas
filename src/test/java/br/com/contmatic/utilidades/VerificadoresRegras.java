package br.com.contmatic.utilidades;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
    
}
