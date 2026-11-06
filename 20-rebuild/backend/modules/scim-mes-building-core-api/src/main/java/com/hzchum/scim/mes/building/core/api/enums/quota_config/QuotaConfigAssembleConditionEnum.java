package com.hzchum.scim.mes.building.core.api.enums.quota_config;

import java.util.Objects;
import java.util.stream.Stream;

public enum QuotaConfigAssembleConditionEnum {
   WEIGHT(1, "重量(吨)"),
   SECTION(2, "截面(毫米)"),
   WEB_THICKNESS(4, "腹板厚度(毫米)"),
   LENGTH(8, "长度(毫米)"),
   HOLE_QUANTITY(16, "孔数");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static String getName(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).map(QuotaConfigAssembleConditionEnum::getName).findFirst().orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   QuotaConfigAssembleConditionEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
