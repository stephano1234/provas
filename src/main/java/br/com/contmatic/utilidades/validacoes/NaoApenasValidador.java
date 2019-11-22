package br.com.contmatic.utilidades.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Preconditions;

public class NaoApenasValidador implements ConstraintValidator<NaoApenas, String> {
  
    private String regexp;
    
    @Override
    public void initialize(NaoApenas naoApenas) {
        this.regexp = naoApenas.regexp();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            value = Preconditions.checkNotNull(value);
            Preconditions.checkArgument(!value.isEmpty());            
            for (int i = 0; i < value.length(); i++) {
                if (!value.substring(i, i + 1).matches(regexp)) {
                    return true;
                }
            }
            return false;
        }
        catch (NullPointerException | IllegalArgumentException pass) {
            return true;
        }
    }
}
