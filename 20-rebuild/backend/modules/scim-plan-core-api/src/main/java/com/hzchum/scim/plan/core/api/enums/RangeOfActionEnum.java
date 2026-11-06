package com.hzchum.scim.plan.core.api.enums;

public enum RangeOfActionEnum {
   SERIAL_NUMBER(1, "编号"),
   REMARK(2, "备注");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   RangeOfActionEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
