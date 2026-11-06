package com.hzchum.scim.mes.building.core.api.enums.wage_quota_management;

import java.util.Objects;
import java.util.stream.Stream;

public enum AssembleCalculationWayEnum {
   WEIGHT(1, "按重量"),
   LENGTH(2, "按长度");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static String getUnitByType(Integer type) {
      if (Objects.equals(WEIGHT.getType(), type)) {
         return "吨";
      } else {
         return Objects.equals(LENGTH.getType(), type) ? "米" : null;
      }
   }

   public static AssembleCalculationWayEnum getEnumByType(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).findFirst().orElse(null);
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AssembleCalculationWayEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
