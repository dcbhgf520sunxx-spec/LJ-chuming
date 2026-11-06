package com.hzchum.scim.system.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AvoidTimeEnum {
   AVOID_SATURDAY(1, "避开周六"),
   AVOID_SUNDAY(2, "避开周日");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (AvoidTimeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<AvoidTimeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AvoidTimeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
