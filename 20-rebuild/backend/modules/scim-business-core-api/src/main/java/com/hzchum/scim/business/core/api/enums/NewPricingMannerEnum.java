package com.hzchum.scim.business.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum NewPricingMannerEnum {
   WEIGHT(1, "重量"),
   LENGTH(2, "长度"),
   AREA(4, "面积"),
   QUANTITY(8, "数量");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      NewPricingMannerEnum pricingMannerEnum = Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst().orElse(null);
      return pricingMannerEnum != null ? pricingMannerEnum.getName() : null;
   }

   public static boolean isExist(Integer type) {
      Optional<NewPricingMannerEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   NewPricingMannerEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
