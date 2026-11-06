package com.hzchum.scim.contract.core.api.enums.finance;

import java.util.Arrays;

public enum WaterElectricityEnum {
   WATER(1, "水费"),
   ELECTRICITY(2, "电费");

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

   WaterElectricityEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
