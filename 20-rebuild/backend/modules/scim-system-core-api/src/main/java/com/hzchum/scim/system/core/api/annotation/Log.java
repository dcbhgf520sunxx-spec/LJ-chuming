package com.hzchum.scim.system.core.api.annotation;

import com.hzchum.scim.system.core.api.common.enums.BusinessTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ModuleEnum;
import com.hzchum.scim.system.core.api.common.enums.OperationTypeEnum;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
   ModuleEnum module();

   BusinessTypeEnum name();

   OperationTypeEnum type() default OperationTypeEnum.OTHER;

   String table() default "";

   String column() default "name";

   String field() default "";

   Class dataType() default Object.class;
}
