package com.hzchum.pangu.common.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataPermissionCheck {
   int permissionType() default 1;

   String[] interceptedTableList() default {"ALL"};
}
