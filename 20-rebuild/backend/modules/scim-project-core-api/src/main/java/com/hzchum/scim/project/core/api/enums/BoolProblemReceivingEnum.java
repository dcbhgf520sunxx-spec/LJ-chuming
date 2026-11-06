package com.hzchum.scim.project.core.api.enums;

public enum BoolProblemReceivingEnum {
   PROBLEM_RECEIVING(true, "问题收货"),
   NORMAL_RECEIVING(false, "非问题收货(正常收货)");

   private boolean type;
   private String desc;

   public boolean isType() {
      return this.type;
   }

   public String getDesc() {
      return this.desc;
   }

   BoolProblemReceivingEnum(final boolean type, final String desc) {
      this.type = type;
      this.desc = desc;
   }
}
