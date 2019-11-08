package br.com.contmatic.utilidades.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Preconditions;

public class NaoApenasEspacoValidador implements ConstraintValidator<NaoApenasEspaco, String> {
    
    boolean semErro = true;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            value = Preconditions.checkNotNull(value);
            Preconditions.checkArgument(!value.isEmpty());            
            return !value.trim().isEmpty();
        }
        catch (NullPointerException | IllegalArgumentException pass) {
            return semErro;
        }
    }
}
