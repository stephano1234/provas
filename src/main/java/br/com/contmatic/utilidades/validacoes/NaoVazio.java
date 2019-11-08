package br.com.contmatic.utilidades.validacoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NaoVazioValidador.class)
public @interface NaoVazio {
 
    String message() default "Valor inválido";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
}