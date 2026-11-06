package com.hzchum.scim.crm.core.api.enums;

public enum CrmCountryTypeEnum {
   DOMESTIC(1, "国内"),
   FOREIGN(2, "国外");

   private final Integer type;
   private final String name;

   CrmCountryTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
