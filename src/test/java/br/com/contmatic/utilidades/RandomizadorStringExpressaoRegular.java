package br.com.contmatic.utilidades;

import org.apache.commons.lang3.RandomUtils;

import com.google.common.base.Preconditions;

public class RandomizadorStringExpressaoRegular {

    public static String comCaractereInvalido(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 1, "O tamanho da string gerada deve ser maior ou igual a um.");
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

    public static String semCaractereInvalido(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 0, "O tamanho da string gerada não pode ser um número inteiro negativo.");
        StringBuilder stringSemCaractereInvalido = new StringBuilder();
        String caracteresValidos = todosCaracteresValidos(expressaoRegular);
        for (int i = 0 ; i < tamanho && !caracteresValidos.isEmpty() ; i++) {
            stringSemCaractereInvalido.append(caracteresValidos.charAt(RandomUtils.nextInt(0, caracteresValidos.length())));
        }
        return stringSemCaractereInvalido.toString();
    }

    public static String comUmCaractereInvalido(int tamanho, String expressaoRegular) {
        Preconditions.checkArgument(tamanho >= 1, "O tamanho da string gerada deve ser maior ou igual a um.");
        int posicaoCaractereInvalido = RandomUtils.nextInt(0, tamanho - 1);
        return semCaractereInvalido(posicaoCaractereInvalido, expressaoRegular) + comCaractereInvalido(1, expressaoRegular) +
            semCaractereInvalido((tamanho - 1) - posicaoCaractereInvalido, expressaoRegular);
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

}
