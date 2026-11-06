package com.hzchum.scim.crm.core.api.enums;

public enum CrmTenderApprovalFlowsTypeEnum {
   BIDDING_METHOD(1, "商务标"),
   SETTLEMENT_METHOD(2, "技术标"),
   TYPE_OF_PERFORMANCE_BOND(4, "设计标");

   private final Integer type;
   private final String name;

   CrmTenderApprovalFlowsTypeEnum(final Integer type, final String name) {
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
