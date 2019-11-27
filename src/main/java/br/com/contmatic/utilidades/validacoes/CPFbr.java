package br.com.contmatic.utilidades.validacoes;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.contmatic.utilidades.MensagensErro;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CPFbrValidador.class)
public @interface CPFbr {
    
    String message() default MensagensErro.STRING_CPF_INVALIDO;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
