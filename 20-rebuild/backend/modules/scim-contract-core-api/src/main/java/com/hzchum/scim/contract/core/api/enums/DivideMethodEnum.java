package com.hzchum.scim.contract.core.api.enums;

public enum DivideMethodEnum {
   LIST(2, "清单"),
   AREA(1, "区域");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   DivideMethodEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
