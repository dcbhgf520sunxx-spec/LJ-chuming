package com.hzchum.scim.contract.core.api.enums.finance;

import java.util.Arrays;

public enum ElectricityTypeEnum {
   INDUSTRY(1, "工业用电"),
   DOMESTIC(2, "民用用电");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ElectricityTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
