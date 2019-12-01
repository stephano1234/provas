package br.com.contmatic.utilidades;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.LocalDate;

import com.google.common.base.Preconditions;

public class FuncoesRandomicas {

    public static String naoCorresponde(int tamanho, String expressaoRegular) {
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
        for (int i = 0; i < ConstantesTesteString.UNVIVERSO_CARACTERES.length(); i++) {    
            if (ConstantesTesteString.UNVIVERSO_CARACTERES.substring(i, i + 1).matches(expressaoRegular)) {
                caracteresValidos.append(ConstantesTesteString.UNVIVERSO_CARACTERES.substring(i, i + 1));
            }
        }
        return caracteresValidos.toString();
    }

    public static String somenteCaractere(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 0, "O tamanho da string gerada não pode ser um número inteiro negativo.");
        StringBuilder stringSemCaractereInvalido = new StringBuilder();
        String caracteresValidos = todosCaracteresValidos(expressaoRegular);
        for (int i = 0 ; i < tamanho && !caracteresValidos.isEmpty() ; i++) {
            stringSemCaractereInvalido.append(caracteresValidos.charAt(RandomUtils.nextInt(0, caracteresValidos.length())));
        }
        return stringSemCaractereInvalido.toString();
    }

    public static String ANTIGAcomUmCaractereNaoEspecificadoExpressaoRegular(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 1, "O tamanho da string gerada deve ser maior ou igual a um.");
        int posicaoCaractereInvalido = RandomUtils.nextInt(0, tamanho - 1);
        return somenteCaractere(posicaoCaractereInvalido, expressaoRegular) + naoCorresponde(1, expressaoRegular) +
            somenteCaractere((tamanho - 1) - posicaoCaractereInvalido, expressaoRegular);
    }

    public static String apenasUmCaractere(int tamanho, String regexCaractere, String regexConjunto) {
        Preconditions.checkArgument(tamanho >= 1, "O tamanho da string gerada por apenasUmCaractere deve ser maior ou igual a um.");
        int posicaoCaractere = RandomUtils.nextInt(0, tamanho - 1);
        return somenteCaractere(posicaoCaractere, regexConjunto) + somenteCaractere(1, regexCaractere) + somenteCaractere((tamanho - 1) - posicaoCaractere, regexConjunto);
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
                randomString.append(ConstantesTesteString.UNVIVERSO_CARACTERES.charAt(RandomUtils.nextInt(0, ConstantesTesteString.UNVIVERSO_CARACTERES.length())));
            }
            return randomString.toString();
        }
    }

    public static String emailAleatorio() {
    	StringBuilder emailRandom = new StringBuilder();
    	emailRandom.append(somenteCaractere(1, "[a-z0-9]"));
    	emailRandom.append(somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, 10 + 1), "([a-z]|[0-9]|[\\.]|[_]|[-])"));
    	if (emailRandom.substring(emailRandom.length() - 1, emailRandom.length()).matches("[-_\\.]")) {
    		emailRandom.append(somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, 10 + 1), "[a-z0-9]"));
    	}
    	emailRandom.append("@");
    	emailRandom.append(somenteCaractere(1, "[a-z0-9]"));
    	emailRandom.append(somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, 10 + 1), "([a-z]|[0-9]|[\\.]|[-])"));
    	if (emailRandom.substring(emailRandom.length() - 1, emailRandom.length()).matches("[-_\\.]")) {
    		emailRandom.append(somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.EXCLUI_STRING_VAZIO, 10 + 1), "[a-z0-9]"));
    	}
    	emailRandom.append(".");
    	emailRandom.append(somenteCaractere(RandomUtils.nextInt(2, 6 + 1), "[a-z]"));
    	return emailRandom.toString();
    }
    
    public static String cpfValido() {
    	StringBuilder cpfRandom = new StringBuilder();
    	cpfRandom.append(somenteCaractere(9, ConstantesTesteString.APENAS_NUMERAL));
    	while (cpfRandom.charAt(7) == cpfRandom.charAt(8)) {
    		cpfRandom.deleteCharAt(8);
    		cpfRandom.append(somenteCaractere(1, ConstantesTesteString.APENAS_NUMERAL));
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
    	Integer digitoVerificadorValido = Integer.parseInt(cpfInvalidoRandom.substring(posicaoDigitoVerificador, posicaoDigitoVerificador + 1));
    	Integer digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
    	while (digitoVerificadorValido == digitoVerificadorInvalido) {
    		digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
    	}
    	cpfInvalidoRandom.deleteCharAt(posicaoDigitoVerificador);
    	cpfInvalidoRandom.insert(posicaoDigitoVerificador, digitoVerificadorInvalido.toString());
    	return cpfInvalidoRandom.toString();
    }
    
    public static LocalDate localDateAleatoria(LocalDate dataInicio, LocalDate dataFim) {
    	Preconditions.checkArgument(dataInicio.isBefore(dataFim), "A data inicial deve ser anterior à data de final.");
    	StringBuilder stringData = new StringBuilder();
    	if (dataInicio.equals(dataFim)) {
    		return dataInicio;
    	}
    	if (dataInicio.getYear() == dataFim.getYear() && dataInicio.getMonthOfYear() == dataFim.getMonthOfYear()) {
    		stringData.append(dataInicio.getYear());
    		stringData.append("-");
    		stringData.append(dataInicio.getMonthOfYear());
    		stringData.append("-");
    		stringData.append(RandomUtils.nextInt(dataInicio.getDayOfMonth() <= 28 ? dataInicio.getDayOfMonth() : 28, dataFim.getDayOfMonth() <= 28 ? dataFim.getDayOfMonth() : 28));    		
    		return LocalDate.parse(stringData.toString());
    	}
    	if (dataInicio.getYear() == dataFim.getYear()) {
    		stringData.append(dataInicio.getYear());
    		stringData.append("-");
    		stringData.append(RandomUtils.nextInt(dataInicio.getMonthOfYear(), dataFim.getMonthOfYear() + 1));
    		stringData.append("-");
    		stringData.append("01");
    		return LocalDate.parse(stringData.toString());
    	}
		stringData.append(RandomUtils.nextInt(dataInicio.getYear(), dataFim.getYear() + 1));
		stringData.append("-");
		stringData.append("01");
		stringData.append("-");
		stringData.append("01");
		return LocalDate.parse(stringData.toString());
    }
        
}
