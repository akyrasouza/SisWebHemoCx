package com.akira.apihemomar.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DataValidacao.class)
public @interface DateCustom {
    public String message() default "Data com formato inválido formato aceito dd-MM-yyyy !";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
