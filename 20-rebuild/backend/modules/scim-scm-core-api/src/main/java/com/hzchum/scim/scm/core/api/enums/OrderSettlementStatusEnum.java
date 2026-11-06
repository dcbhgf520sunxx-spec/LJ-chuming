package com.hzchum.scim.scm.core.api.enums;

public enum OrderSettlementStatusEnum {
   UN_SETTLED(false, "未结算"),
   SETTLED(true, "已结算");

   private final boolean type;
   private final String name;

   public boolean isType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   OrderSettlementStatusEnum(final boolean type, final String name) {
      this.type = type;
      this.name = name;
   }
}
