package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;

public enum EnclosureMeasureModeEnum {
   LENGTH_MODE(1, "长度计量"),
   AREA_MODE(2, "面积计量");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   public static String getNameByType(Integer type) {
      if (type == null) {
         return null;
      }

      EnclosureMeasureModeEnum[] values = values();

      for (EnclosureMeasureModeEnum value : values) {
         if (type.equals(value.getType())) {
            return value.getName();
         }
      }

      return null;
   }

   EnclosureMeasureModeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
