package br.com.contmatic.utilidades.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Optional;

public class NaoApenasValidador implements ConstraintValidator<NaoApenas, String> {

	private String[] regexp;

	private Optional<String> value;

	@Override
	public void initialize(NaoApenas naoApenas) {
		this.regexp = naoApenas.regexp();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		this.value = Optional.fromNullable(value);
		value = this.value.or("");
		for (int j = 0; j < regexp.length; j++) {
			for (int i = 0; i < value.length(); i++) {
				if (!value.substring(i, i + 1).matches(regexp[j])) {
					i = value.length();
				}
				else {
					if (i == value.length() - 1) {
						return false;
					}					
				}
			}
		}
		return true;
	}
}
