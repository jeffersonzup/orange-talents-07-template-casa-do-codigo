package br.com.zupacademy.jefferson.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = ExistsEstadoValidator.class)
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsEstado {

    String message() default "Selecione um estado para um país cadastrado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
