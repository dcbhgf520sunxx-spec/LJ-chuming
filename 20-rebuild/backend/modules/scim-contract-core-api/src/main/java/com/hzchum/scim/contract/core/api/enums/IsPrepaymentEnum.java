package com.hzchum.scim.contract.core.api.enums;

public enum IsPrepaymentEnum {
   IS_PREPAYMENT(1, "是(预付款)"),
   NO_PREPAYMENT(0, "不是(预付款)");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   IsPrepaymentEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
