package com.hzchum.scim.plan.core.api.enums;

public enum CappCraftTypeEnum {
   WELDING(1, "焊接工艺"),
   CUTTING(2, "切割工艺"),
   COATING(3, "涂装工艺");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CappCraftTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
