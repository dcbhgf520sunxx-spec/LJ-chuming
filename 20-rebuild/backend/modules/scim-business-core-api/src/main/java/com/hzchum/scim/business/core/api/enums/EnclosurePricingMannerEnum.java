package com.hzchum.scim.business.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum EnclosurePricingMannerEnum {
   LENGTH(1, "长度"),
   AREA(2, "面积");

   private Integer type;
   private String name;

   public static boolean isExist(Integer type) {
      Optional<EnclosurePricingMannerEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   EnclosurePricingMannerEnum(final Integer type, final String name) {
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
