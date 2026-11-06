package com.hzchum.scim.system.core.api.common.enums;

public enum InstallReportClientTypeEnum {
   APP(1, "APP端"),
   PC(0, "PC端");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   InstallReportClientTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
