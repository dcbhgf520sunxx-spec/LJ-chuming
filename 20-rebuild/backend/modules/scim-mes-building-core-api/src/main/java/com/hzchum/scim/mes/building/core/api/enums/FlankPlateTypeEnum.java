package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;

public enum FlankPlateTypeEnum {
   FLANK_PLATE_TYPE_1("1", "翼缘板"),
   FLANK_PLATE_TYPE_2("2", "腹板");

   private final int flankPlateType;
   private final String flankPlateTypeName;

   public int getFlankPlateType() {
      return this.flankPlateType;
   }

   public String getFlankPlateTypeName() {
      return this.flankPlateTypeName;
   }

   FlankPlateTypeEnum(String flankPlateType, String flankPlateTypeName) {
      this.flankPlateType = Integer.parseInt(flankPlateType);
      this.flankPlateTypeName = flankPlateTypeName;
   }

   public static boolean isExist(int flankPlateType) {
      return Arrays.stream(values()).anyMatch(e -> e.getFlankPlateType() == flankPlateType);
   }
}
