package com.hzchum.scim.system.core.api.common.enums.config;

public enum ProjectNameShowModeEnum {
   SN_NAME(0),
   NAME_SN(1);

   private final Integer type;

   ProjectNameShowModeEnum(final Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
