package br.com.contmatic.utilidades;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.LocalDate;

import com.google.common.base.Preconditions;

public class FuncoesRandomicas {

    public static String geraStringForaPadraoExpressaoRegular(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 0, "O tamanho da string gerada não pode ser um número inteiro negativo.");
        StringBuilder stringComCharInvalido = new StringBuilder(stringAleatoria(tamanho, false));
        while (stringComCharInvalido.toString().matches(expressaoRegular)) {
            stringComCharInvalido.delete(0, tamanho);
            stringComCharInvalido.append(stringAleatoria(tamanho, false));
        }
        return stringComCharInvalido.toString();
    }

    public static String todosCaracteresValidos(String expressaoRegular) {
        StringBuilder caracteresValidos = new StringBuilder();
        for (int i = 0; i < ExpressoesRegularesTesteRegra.UNVIVERSO_CARACTERES.length(); i++) {    
            if (ExpressoesRegularesTesteRegra.UNVIVERSO_CARACTERES.substring(i, i + 1).matches(expressaoRegular)) {
                caracteresValidos.append(ExpressoesRegularesTesteRegra.UNVIVERSO_CARACTERES.substring(i, i + 1));
            }
        }
        return caracteresValidos.toString();
    }

    public static String semCaractereNaoEspecificadoExpressaoRegular(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 0, "O tamanho da string gerada não pode ser um número inteiro negativo.");
        StringBuilder stringSemCaractereInvalido = new StringBuilder();
        String caracteresValidos = todosCaracteresValidos(expressaoRegular);
        for (int i = 0 ; i < tamanho && !caracteresValidos.isEmpty() ; i++) {
            stringSemCaractereInvalido.append(caracteresValidos.charAt(RandomUtils.nextInt(0, caracteresValidos.length())));
        }
        return stringSemCaractereInvalido.toString();
    }

    public static String comUmCaractereNaoEspecificadoExpressaoRegular(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 1, "O tamanho da string gerada deve ser maior ou igual a um.");
        int posicaoCaractereInvalido = RandomUtils.nextInt(0, tamanho - 1);
        return semCaractereNaoEspecificadoExpressaoRegular(posicaoCaractereInvalido, expressaoRegular) + geraStringForaPadraoExpressaoRegular(1, expressaoRegular) +
            semCaractereNaoEspecificadoExpressaoRegular((tamanho - 1) - posicaoCaractereInvalido, expressaoRegular);
    }

    public static String stringAleatoria(int tamanho, boolean incluiNulo) {
        Preconditions.checkArgument(tamanho >= 0, "O tamanho da string gerada não pode ser um número inteiro negativo.");                        
        if (incluiNulo && RandomUtils.nextInt(1, 100) <= ConstantesTesteNumericas.PERCENTUAL_NULO_GERADO) {            
            System.out.println("entrou onde nao devia");
            return null;       
        } 
        else {
            StringBuilder randomString = new StringBuilder("");                                    
            for (int i = 0 ; i < tamanho ; i++) {                                
                randomString.append(ExpressoesRegularesTesteRegra.UNVIVERSO_CARACTERES.charAt(RandomUtils.nextInt(0, ExpressoesRegularesTesteRegra.UNVIVERSO_CARACTERES.length())));
            }
            return randomString.toString();
        }
    }

    public static String emailAleatorio() {
    	StringBuilder emailRandom = new StringBuilder();
    	emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(1, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL));
    	emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_UNDERLINE_TRACO_PONTO));
    	if (emailRandom.substring(emailRandom.length() - 1, emailRandom.length()).matches(ExpressoesRegularesTesteRegra.UNDERLINE_TRACO_PONTO)) {
    		emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL));
    	}
    	emailRandom.append(ExpressoesRegularesTesteRegra.ARROBA);
    	emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(1, ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL));
    	emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL_TRACO_PONTO));
    	if (emailRandom.substring(emailRandom.length() - 1, emailRandom.length()).matches(ExpressoesRegularesTesteRegra.UNDERLINE_TRACO_PONTO)) {
    		emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, ConstantesTesteNumericas.CARACTERES_CADA_PARTE_EMAIL_GERADO + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO_NUMERAL));
    	}
    	emailRandom.append(ExpressoesRegularesTesteRegra.PONTO);
    	emailRandom.append(semCaractereNaoEspecificadoExpressaoRegular(RandomUtils.nextInt(ConstantesTesteNumericas.MIN_DEPOIS_PONTO_EMAIL, ConstantesTesteNumericas.MAX_DEPOIS_PONTO_EMAIL + 1), ExpressoesRegularesTesteRegra.LETRA_MINUSCULA_SEM_ACENTO));
    	return emailRandom.toString();
    }
    
    public static String cpfValido() {
    	StringBuilder cpfRandom = new StringBuilder();
    	cpfRandom.append(semCaractereNaoEspecificadoExpressaoRegular(9, ExpressoesRegularesTesteRegra.APENAS_NUMERAL));
    	if (cpfRandom.charAt(7) == cpfRandom.charAt(8)) {
    		cpfRandom.deleteCharAt(8);
    		cpfRandom.append(geraStringForaPadraoExpressaoRegular(1, cpfRandom.substring(7)));
    	}
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += Integer.parseInt(cpfRandom.substring(i, i + 1)) * (10 - i);
		}
		cpfRandom.append((((11 - (soma % 11)) % 11) % 10));
    	soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += Integer.parseInt(cpfRandom.substring(i, i + 1)) * (11 - i);
		}
		cpfRandom.append((((11 - (soma % 11)) % 11) % 10));
		return cpfRandom.toString();
    }
    
    public static String cpfInvalido() {
    	StringBuilder cpfInvalidoRandom = new StringBuilder(cpfValido());
    	int posicaoDigitoVerificador = RandomUtils.nextInt(9, 11);
    	Integer digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
    	while (Integer.parseInt(cpfInvalidoRandom.substring(posicaoDigitoVerificador, posicaoDigitoVerificador + 1)) == digitoVerificadorInvalido) {
    		digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
    	}
    	cpfInvalidoRandom.deleteCharAt(posicaoDigitoVerificador);
    	cpfInvalidoRandom.insert(posicaoDigitoVerificador, digitoVerificadorInvalido.toString());
    	return cpfInvalidoRandom.toString();
    }
    
    public static LocalDate localDateAleatoria(LocalDate dataInicio, LocalDate dataFim) {
    	StringBuilder stringData = new StringBuilder();
    	if (dataInicio.equals(dataFim)) {
    		return dataInicio;
    	}
    	if (dataInicio.getYear() == dataFim.getYear() && dataInicio.getMonthOfYear() == dataFim.getMonthOfYear()) {
    		stringData.append(RandomUtils.nextInt(dataInicio.getDayOfMonth(), dataFim.getDayOfMonth()));
    		stringData.append("-");
    		stringData.append(dataInicio.getMonthOfYear());
    		stringData.append("-");
    		stringData.append(dataInicio.getYear());
    		return LocalDate.parse(stringData.toString());
    	}
    	if (dataInicio.getYear() == dataFim.getYear()) {
    		stringData.append(RandomUtils.nextInt(dataInicio.getDayOfMonth(), dataFim.getDayOfMonth()));
    		stringData.append("-");
    		stringData.append(RandomUtils.nextInt(dataInicio.getMonthOfYear(), dataFim.getMonthOfYear() + 1));
    		stringData.append("-");
    		stringData.append(dataInicio.getYear());
    		return LocalDate.parse(stringData.toString());
    	}
		stringData.append(RandomUtils.nextInt(dataInicio.getDayOfMonth(), dataFim.getDayOfMonth()));
		stringData.append("-");
		stringData.append(RandomUtils.nextInt(dataInicio.getMonthOfYear(), dataFim.getMonthOfYear() + 1));
		stringData.append("-");
		stringData.append(RandomUtils.nextInt(dataInicio.getYear(), dataFim.getYear() + 1));
    	return LocalDate.parse(stringData.toString());
    }
    
}
