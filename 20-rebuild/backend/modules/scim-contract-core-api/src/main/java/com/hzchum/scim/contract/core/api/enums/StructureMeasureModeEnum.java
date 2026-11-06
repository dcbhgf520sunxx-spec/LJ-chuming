package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StructureMeasureModeEnum {
   THEORY(1, "理计"),
   POUND(2, "磅计");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   public static String getNameByType(Integer type) {
      Optional<StructureMeasureModeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(StructureMeasureModeEnum::getName).orElse(null);
   }

   StructureMeasureModeEnum(final Integer type, final String name) {
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
