package br.com.contmatic.utilidades;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.collections4.map.LinkedMap;

import com.google.common.base.Preconditions;

/**
 * The Class Verificadores.
 */
public class Verificadores {

	/** The validator. */
	private static Validator validator;
	
	/** The factory. */
	private static ValidatorFactory factory;

	/**
	 * Verifica erro.
	 *
	 * @param objetoTestado the objeto testado
	 * @param mensagem the mensagem
	 * @return true, if successful
	 */
	public static boolean verificaErro(Object objetoTestado, String mensagem) {
		Preconditions.checkNotNull(objetoTestado, "O objeto testado não pode ser nulo.");
		Preconditions.checkNotNull(mensagem, "A mensagem do erro procurado deve ser informada.");
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		boolean possuiErro = false;
		Set<ConstraintViolation<Object>> violacoes = validator.validate(objetoTestado);
		for (ConstraintViolation<Object> violacao : violacoes) {
			if (violacao.getMessageTemplate().equals(mensagem)) {
				possuiErro = true;
			}
		}
		return possuiErro;
	}

	/**
	 * Procura algum erro.
	 *
	 * @param objetoTestado the objeto testado
	 * @return true, if successful
	 */
	public static boolean procuraAlgumErro(Object objetoTestado) {
		Preconditions.checkNotNull(objetoTestado, "O objeto testado não pode ser nulo.");
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Set<ConstraintViolation<Object>> violacoes = validator.validate(objetoTestado);
		return !violacoes.isEmpty();
	}

	/**
	 * Verifica to string JSONSTYLE.
	 *
	 * @param objetoTestado the objeto testado
	 * @return true, if successful
	 */
	public static boolean verificaToStringJSONSTYLE(Object objetoTestado) {
		Preconditions.checkNotNull(objetoTestado, "O objeto testado não pode ser nulo.");
		StringBuilder formatoEsperado = new StringBuilder("{");
		Field[] campos = objetoTestado.getClass().getDeclaredFields();
		for (Field campo : campos) {
			campo.setAccessible(true);
			formatoEsperado.append("\"").append(campo.getName()).append("\":\"");
			try {
				if (campo.get(objetoTestado).toString().charAt(0) == '{'
						|| campo.get(objetoTestado).toString().charAt(0) == '[') {
					formatoEsperado.deleteCharAt(formatoEsperado.length() - 1);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return false;
			}
			try {
				if (campo.get(objetoTestado).getClass().isEnum()) {
					formatoEsperado.append(transformaCaractereEmUnicode(campo.get(objetoTestado).getClass()
							.getSuperclass().getMethod("name").invoke(campo.get(objetoTestado)).toString()))
							.append("\",");
				} else {
					formatoEsperado.append(transformaCaractereEmUnicode(campo.get(objetoTestado).toString()))
							.append("\",");
				}
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				return false;
			}
			try {
				if (campo.get(objetoTestado).toString().charAt(0) == '{'
						|| campo.get(objetoTestado).toString().charAt(0) == '[') {
					formatoEsperado.deleteCharAt(formatoEsperado.length() - 2);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return false;
			}
		}
		formatoEsperado.deleteCharAt(formatoEsperado.length() - 1);
		formatoEsperado.append("}");
		return objetoTestado.toString().equals(formatoEsperado.toString());
	}

	/**
	 * Transforma caractere em unicode.
	 *
	 * @param string the string
	 * @return the string
	 */
	public static String transformaCaractereEmUnicode(String string) {
		String letrasAcentuadas = "ÁáÉéÍíÓóÚúÀàÂâÊêÔôÃãÕõªºç";
		Map<String, String> tabelaAcentos = new LinkedMap<String, String>();
		tabelaAcentos.put("Á", "\\u00C1");
		tabelaAcentos.put("á", "\\u00E1");
		tabelaAcentos.put("É", "\\u00C9");
		tabelaAcentos.put("é", "\\u00E9");
		tabelaAcentos.put("Í", "\\u00CD");
		tabelaAcentos.put("í", "\\u00ED");
		tabelaAcentos.put("Ó", "\\u00D3");
		tabelaAcentos.put("ó", "\\u00F3");
		tabelaAcentos.put("Ú", "\\u00DA");
		tabelaAcentos.put("ú", "\\u00FA");
		tabelaAcentos.put("Â", "\\u00C2");
		tabelaAcentos.put("â", "\\u00E2");
		tabelaAcentos.put("Ê", "\\u00CA");
		tabelaAcentos.put("ê", "\\u00EA");
		tabelaAcentos.put("Ô", "\\u00D4");
		tabelaAcentos.put("ô", "\\u00F4");
		tabelaAcentos.put("Ã", "\\u00C3");
		tabelaAcentos.put("ã", "\\u00E3");
		tabelaAcentos.put("Õ", "\\u00D5");
		tabelaAcentos.put("õ", "\\u00F5");
		tabelaAcentos.put("ª", "\\u00AA");
		tabelaAcentos.put("º", "\\u00BA");
		tabelaAcentos.put("ç", "\\u00E7");
		StringBuilder stringTransformada = new StringBuilder(string);
		String letraAcentuada;
		for (int i = 0; i < stringTransformada.length(); i++) {
			if (letrasAcentuadas.contains(stringTransformada.substring(i, i + 1))) {
				letraAcentuada = tabelaAcentos.get(stringTransformada.substring(i, i + 1));
				stringTransformada.deleteCharAt(i);
				stringTransformada.insert(i, letraAcentuada);
				i += 5;
			}
		}
		return stringTransformada.toString();
	}

	/**
	 * Verifica construtor.
	 *
	 * @param classe the classe
	 * @param valores the valores
	 * @param tiposArgumentos the tipos argumentos
	 * @return true, if successful
	 */
	public static boolean verificaConstrutor(Class<?> classe, Object[] valores, Class<?>... tiposArgumentos) {
		Preconditions.checkNotNull(classe, "A classe deve ser informada.");
		Preconditions.checkNotNull(valores, "Os valores de inicialização do construtor devem ser informados.");
		Preconditions.checkNotNull(tiposArgumentos, "Os tipos de cada argumento do construtor devem ser informados.");
		Preconditions.checkArgument(valores.length == tiposArgumentos.length,
				"Deve haver um valor para cada tipo de argumento do construtor e vice-versa.");
		Object objetoCriadoPeloConstrutor;
		try {
			objetoCriadoPeloConstrutor = classe.getDeclaredConstructor(tiposArgumentos).newInstance(valores);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return false;
		}
		Set<Method> getters = trazMetodosGetters(classe);
		List<Object> retornosGetter = new ArrayList<Object>();
		for (Method getter : getters) {
			try {
				retornosGetter.add(getter.invoke(objetoCriadoPeloConstrutor));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
		}
		for (Object valor : valores) {
			if (!retornosGetter.contains(valor)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Traz metodos getters.
	 *
	 * @param classe the classe
	 * @return the sets the
	 */
	public static Set<Method> trazMetodosGetters(Class<?> classe) {
		Set<Method> metodosGet = new HashSet<Method>();
		for (int i = 0; i < classe.getDeclaredMethods().length; i++) {
			if (classe.getDeclaredMethods()[i].getName().substring(0, 3).equals("get")) {
				metodosGet.add(classe.getDeclaredMethods()[i]);
			}
		}
		return metodosGet;
	}

}
