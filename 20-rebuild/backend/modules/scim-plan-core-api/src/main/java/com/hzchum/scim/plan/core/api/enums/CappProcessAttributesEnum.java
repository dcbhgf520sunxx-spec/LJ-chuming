package com.hzchum.scim.plan.core.api.enums;

public enum CappProcessAttributesEnum {
   GENERAL(1, "通用"),
   PROJECT_SPECIFIC(2, "项目专属");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CappProcessAttributesEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
