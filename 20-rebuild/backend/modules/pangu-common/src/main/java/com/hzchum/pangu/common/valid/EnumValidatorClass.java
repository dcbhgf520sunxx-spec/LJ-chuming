package com.hzchum.pangu.common.valid;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumValidatorClass implements ConstraintValidator<EnumValidator, Object> {
   private static final Logger logger = LoggerFactory.getLogger(EnumValidatorClass.class);
   private final List<Object> values = new ArrayList<>();

   public void initialize(EnumValidator enumValidator) {
      Class<?> clz = enumValidator.value();
      Object[] objects = clz.getEnumConstants();

      try {
         Method method = clz.getMethod("getType");
         if (Objects.isNull(method)) {
            method = clz.getMethod("getName");
         }

         if (Objects.isNull(method)) {
            throw new Exception("枚举对象:" + clz.getName() + "缺少get方法");
         }

         for (Object obj : objects) {
            Object value = method.invoke(obj);
            this.values.add(value);
         }
      } catch (Exception e) {
         e.printStackTrace();
         logger.error("处理枚举校验异常", e);
      }
   }

   @Override
   public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
      logger.info("校验的枚举值为:{}", value);
      return value == null ? Boolean.TRUE : this.values.contains(value);
   }
}
