package com.hzchum.pangu.common.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Constraint(validatedBy = EnumValidatorClass.class)
public @interface EnumValidator {
   Class<?> value();

   String message() default "入参不在正确的类型中";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
