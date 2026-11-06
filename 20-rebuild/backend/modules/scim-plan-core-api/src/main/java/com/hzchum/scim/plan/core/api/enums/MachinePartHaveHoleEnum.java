package com.hzchum.scim.plan.core.api.enums;

public enum MachinePartHaveHoleEnum {
   HAVE_HOLE(true, "有孔"),
   NOT_HOLE(false, "无孔");

   private Boolean type;
   private String name;

   public Boolean getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MachinePartHaveHoleEnum(final Boolean type, final String name) {
      this.type = type;
      this.name = name;
   }
}
