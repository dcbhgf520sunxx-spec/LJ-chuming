package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;

public enum WeightTypeEnum {
   NET_WEIGHT(1, "净重"),
   GROSS_WEIGHT(2, "毛重");

   private final Integer type;
   private final String name;

   public static WeightTypeEnum getByType(Integer type) {
      return Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
   }

   public static String getNameByType(Integer type) {
      WeightTypeEnum wasteHandleMethodEnum = Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
      return wasteHandleMethodEnum != null ? wasteHandleMethodEnum.getName() : null;
   }

   WeightTypeEnum(final Integer type, final String name) {
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
