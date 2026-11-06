package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum WeightedPriceEnum {
   WHOLE(1, "全库加权"),
   SINGLE(2, "单库加权");

   private final Integer type;
   private final String name;

   WeightedPriceEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(Integer type) {
      Optional<WeightedPriceEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
