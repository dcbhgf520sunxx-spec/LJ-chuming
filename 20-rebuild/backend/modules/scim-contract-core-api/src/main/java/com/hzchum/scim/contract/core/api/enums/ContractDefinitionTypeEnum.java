package com.hzchum.scim.contract.core.api.enums;

public enum ContractDefinitionTypeEnum {
   CONTRACT(1, "承包合同"),
   REPLENISHMENT_CONTRACT(2, "补充合同"),
   PURCHASE_CONTRACT(3, "采购合同"),
   SUB_CONTRACT(4, "分包合同"),
   PERSONAL_SERVICE_CONTRACT(4, "劳务合同");

   private final int type;
   private final String name;

   ContractDefinitionTypeEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
