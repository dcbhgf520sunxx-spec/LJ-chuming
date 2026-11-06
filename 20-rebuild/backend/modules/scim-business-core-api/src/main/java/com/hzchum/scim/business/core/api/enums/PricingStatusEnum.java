package com.hzchum.scim.business.core.api.enums;

public enum PricingStatusEnum {
   UN_PRICING(1, "未计价"),
   PART_PRICING(2, "部分计价"),
   WHOLE_PRICING(4, "全部计价");

   private final Integer type;
   private final String name;

   PricingStatusEnum(final Integer type, final String name) {
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
