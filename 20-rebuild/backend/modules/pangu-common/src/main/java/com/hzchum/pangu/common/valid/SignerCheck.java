package com.hzchum.pangu.common.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SignerCheck {
   boolean boolRedisson() default false;

   boolean boolMethodAndClassName() default false;

   String[] lockKey() default {};

   String constantKey() default "";

   long timeout() default 15L;

   long waitTime() default 5L;

   long leaseTime() default 15L;

   TimeUnit timeUnit() default TimeUnit.SECONDS;

   String message() default "操作失败，请勿重复提交";
}
