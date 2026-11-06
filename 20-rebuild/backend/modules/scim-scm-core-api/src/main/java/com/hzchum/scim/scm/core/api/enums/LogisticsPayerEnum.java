package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum LogisticsPayerEnum {
   DEMAND(1, "需方承担"),
   SUPPLIER(2, "供方承担");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   LogisticsPayerEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<LogisticsPayerEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      LogisticsPayerEnum logisticsPayerEnum = Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
      return logisticsPayerEnum != null ? logisticsPayerEnum.getName() : null;
   }
}
