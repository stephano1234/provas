package br.com.contmatic.utilidades.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Preconditions;

public class NaoVazioValidador implements ConstraintValidator<NaoVazio, String> {

    boolean semErro = true;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            value = Preconditions.checkNotNull(value);
            return !value.isEmpty();
        }
        catch (NullPointerException pass) {
            return semErro;
        }
    }
}
