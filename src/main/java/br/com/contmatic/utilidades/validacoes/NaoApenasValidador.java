package br.com.contmatic.utilidades.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Optional;

public class NaoApenasValidador implements ConstraintValidator<NaoApenas, String> {

	private String[] regexs;

	private Optional<String> value;

	@Override
	public void initialize(NaoApenas naoApenas) {
		this.regexs = naoApenas.regexp();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		this.value = Optional.fromNullable(value);
		value = this.value.or("");
		int quantidadeCaracteres = value.length();
		int ultimoCaractere = quantidadeCaracteres - 1;
		for (int posicaoRegex = 0; posicaoRegex < regexs.length; posicaoRegex++) {
			for (int posicaoCaractere = 0; posicaoCaractere < quantidadeCaracteres; posicaoCaractere++) {
				if (!value.substring(posicaoCaractere, posicaoCaractere + 1).matches(regexs[posicaoRegex])) {
					posicaoCaractere = quantidadeCaracteres;
				}
				else {
					if (posicaoCaractere == ultimoCaractere) {
						return false;
					}					
				}
			}
		}
		return true;
	}
}
