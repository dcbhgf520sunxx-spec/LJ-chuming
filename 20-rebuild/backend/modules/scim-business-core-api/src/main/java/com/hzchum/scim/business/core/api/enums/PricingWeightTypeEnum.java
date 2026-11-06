package com.hzchum.scim.business.core.api.enums;

import java.util.Arrays;

public enum PricingWeightTypeEnum {
   NET_WEIGHT(1, "净重"),
   GROSS_WEIGHT(2, "毛重"),
   DRAW_WEIGHT(4, "图纸重");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      PricingWeightTypeEnum weightTypeEnum = Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst().orElse(null);
      return weightTypeEnum != null ? weightTypeEnum.getName() : null;
   }

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   PricingWeightTypeEnum(final Integer type, final String name) {
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
