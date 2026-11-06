package com.hzchum.scim.scm.core.api.enums;

public enum PurchaseStatusEnum {
   DURING(1, "采购中"),
   FINISH(2, "采购完成");

   private final Integer type;
   private final String name;

   PurchaseStatusEnum(Integer type, String name) {
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
