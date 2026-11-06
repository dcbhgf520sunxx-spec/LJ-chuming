package com.hzchum.scim.crm.core.api.enums;

public enum CrmSettlementBusinessTypeEnum {
   DIRECT_SALE(1, "直营"),
   NON_DIRECT_SALE(2, "非直营");

   private final Integer type;
   private final String name;

   CrmSettlementBusinessTypeEnum(final Integer type, final String name) {
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
