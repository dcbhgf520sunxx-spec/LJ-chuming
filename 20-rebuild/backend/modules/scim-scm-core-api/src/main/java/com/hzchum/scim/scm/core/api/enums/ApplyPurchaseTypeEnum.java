package com.hzchum.scim.scm.core.api.enums;

public enum ApplyPurchaseTypeEnum {
   PROJECT(1, "项目备料"),
   PARTY_A(2, "甲供备料"),
   PUBLIC(4, "公共备料"),
   MANUFACTURES(8, "制成品备料");

   private final Integer type;
   private final String name;

   ApplyPurchaseTypeEnum(Integer type, String name) {
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
