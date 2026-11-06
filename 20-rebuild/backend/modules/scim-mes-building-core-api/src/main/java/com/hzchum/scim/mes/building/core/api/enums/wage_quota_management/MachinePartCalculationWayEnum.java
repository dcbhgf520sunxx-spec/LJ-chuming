package com.hzchum.scim.mes.building.core.api.enums.wage_quota_management;

import java.util.Objects;
import java.util.stream.Stream;

public enum MachinePartCalculationWayEnum {
   MACHINE_PART_QUANTITY(1, "按零件数量"),
   MACHINE_PART_WEIGHT(2, "按零件重量"),
   MACHINE_PART_LENGTH(8, "按零件长度");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return type == null ? false : Stream.of(values()).anyMatch(e -> e.getType() == type);
   }

   public static MachinePartCalculationWayEnum getEnumByType(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).findFirst().orElse(null);
   }

   public static String getUnitByType(Integer type) {
      MachinePartCalculationWayEnum ae = getEnumByType(type);
      if (ae != null) {
         switch (ae) {
            case MACHINE_PART_QUANTITY:
               return "件";
            case MACHINE_PART_WEIGHT:
               return "吨";
            case MACHINE_PART_LENGTH:
               return "米";
            default:
               return null;
         }
      } else {
         return null;
      }
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MachinePartCalculationWayEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
