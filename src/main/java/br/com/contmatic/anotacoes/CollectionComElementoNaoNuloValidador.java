package br.com.contmatic.anotacoes;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CollectionComElementoNaoNuloValidador implements ConstraintValidator<CollectionComElementoNaoNulo, Collection<?>> {
	
	@Override
	public boolean isValid(Collection<?> value, ConstraintValidatorContext constraintValidatorContext) {
		if (value == null) {
			return true;
		}		
		if (value.toArray().length == 0) {
			return false;
		}
		for (int i = 0; i < value.toArray().length; i++) {
			if (value.toArray()[i] == null) {
				return false;
			}
		}
		return true;
	}

}
