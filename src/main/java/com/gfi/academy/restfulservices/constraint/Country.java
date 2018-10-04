package com.gfi.academy.restfulservices.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryValidator.class)
public @interface Country {

    String message() default "some default message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
