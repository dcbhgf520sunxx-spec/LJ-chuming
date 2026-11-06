package com.hzchum.scim.system.core.api.common.enums;

public enum SmartArtifactCategoryEnum {
   STEEL_BEAM("钢梁"),
   SHORT_BEAM("短梁"),
   LONG_BEAM("长短梁"),
   STEEL_COLUMN("钢柱");

   private String name;

   public static boolean checkName(String name) {
      for (SmartArtifactCategoryEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public String getName() {
      return this.name;
   }

   SmartArtifactCategoryEnum(final String name) {
      this.name = name;
   }
}
