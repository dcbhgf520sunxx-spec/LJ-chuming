package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum WeightedPriceTypeEnum {
   MONTH(1, "月末"),
   USER(2, "自己关账");

   private final Integer type;
   private final String name;

   WeightedPriceTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<WeightedPriceEnum> optional = Arrays.stream(WeightedPriceEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
