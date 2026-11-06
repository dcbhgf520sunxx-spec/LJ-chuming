package com.hzchum.scim.mes.building.core.api.enums.wage_quota_management;

import java.util.Objects;
import java.util.stream.Stream;

public enum ArtifactCalculationWayEnum {
   ARTIFACT_WEIGHT(1, "构件重量计算"),
   MACHINE_PART_QUANTITY(2, "零件数量计算");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static ArtifactCalculationWayEnum getEnumByType(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).findFirst().orElse(null);
   }

   public static String getUnitByType(Integer type) {
      if (Objects.equals(ARTIFACT_WEIGHT.getType(), type)) {
         return "吨";
      } else {
         return Objects.equals(MACHINE_PART_QUANTITY.getType(), type) ? "件" : null;
      }
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ArtifactCalculationWayEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
