package br.com.contmatic.anotacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.contmatic.utilidades.ConstantesNumericas;
import br.com.contmatic.utilidades.ConstantesString;

public class CPFbrValidador implements ConstraintValidator<CPFbr, String> {
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (value == null) {
			return true;
		}
		int quantidadeCaracteres = value.length();
		if (quantidadeCaracteres != ConstantesNumericas.CPF) {
			return false;
		}
		if (!value.matches(ConstantesString.APENAS_NUMERAL)) {
			return false;
		}
		for (Integer numeroRepetido = 0; numeroRepetido < 10; numeroRepetido++) {
			for (int i = 0; i < quantidadeCaracteres; i++) {
				if (!value.substring(i, i + 1).equals(numeroRepetido.toString())) {
					i = quantidadeCaracteres;
				}
				else {
					if (i == quantidadeCaracteres - 1) {
						return false;
					}					
				}
			}
		}		
		int dig1 = Integer.parseInt(value.substring(9, 9 + 1));
		int dig2 = Integer.parseInt(value.substring(10, 10 + 1));
		int soma = 0;
		for (int i = 0; i < quantidadeCaracteres - 2; i++) {
			soma += Integer.parseInt(value.substring(i, i + 1)) * (10 - i);
		}
		if ((((11 - (soma % 11)) % 11) % 10) != dig1) {
			return false;
		}
		soma = 0;
		for (int i = 0; i < quantidadeCaracteres - 1; i++) {
			soma += Integer.parseInt(value.substring(i, i + 1)) * (11 - i);
		}
		if ((((11 - (soma % 11)) % 11) % 10) != dig2) {
			return false;
		}
		return true;
	}

}
