package br.com.contmatic.anotacoes;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.contmatic.utilidades.MensagensErro;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CNPJbrValidador.class)
public @interface CNPJbr {
    
    String message() default MensagensErro.CNPJ_INVALIDO;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
