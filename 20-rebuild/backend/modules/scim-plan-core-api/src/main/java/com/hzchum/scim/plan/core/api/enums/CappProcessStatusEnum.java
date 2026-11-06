package com.hzchum.scim.plan.core.api.enums;

public enum CappProcessStatusEnum {
   NORMAL(1, "正常状态"),
   DRAFT(2, "草稿状态");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CappProcessStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
