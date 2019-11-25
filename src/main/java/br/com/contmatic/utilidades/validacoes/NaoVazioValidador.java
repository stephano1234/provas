package br.com.contmatic.utilidades.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Optional;

public class NaoVazioValidador implements ConstraintValidator<NaoVazio, String> {
    
    private Optional<String> value;
	
	@Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    	this.value = Optional.fromNullable(value);
    	return !this.value.or("NULO").isEmpty();
    }
}
