package com.hzchum.scim.contract.core.api.enums;

public enum SettlementStatusEnum {
   UN_SETTLED(0, "未结算"),
   SETTLED(1, "已结算");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SettlementStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
