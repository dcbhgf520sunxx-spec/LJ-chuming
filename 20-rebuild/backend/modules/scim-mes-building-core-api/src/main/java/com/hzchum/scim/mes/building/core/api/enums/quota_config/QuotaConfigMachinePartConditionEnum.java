package com.hzchum.scim.mes.building.core.api.enums.quota_config;

import java.util.Objects;
import java.util.stream.Stream;

public enum QuotaConfigMachinePartConditionEnum {
   PLATE_THICKNESS(1, "板厚(毫米)"),
   CUTTING_LENGTH(2, "切割长度(毫米)"),
   PROFILE_SECTION(4, "型材截面(毫米)");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static String getName(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).map(QuotaConfigMachinePartConditionEnum::getName).findFirst().orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   QuotaConfigMachinePartConditionEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
