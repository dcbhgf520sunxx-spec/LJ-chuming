package com.hzchum.scim.contract.core.api.enums;

public enum ReportMethodEnum {
   APP(1, "app端"),
   PC(0, "PC端");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ReportMethodEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
