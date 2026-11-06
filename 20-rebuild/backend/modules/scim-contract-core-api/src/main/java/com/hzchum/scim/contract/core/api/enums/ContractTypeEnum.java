package com.hzchum.scim.contract.core.api.enums;

public enum ContractTypeEnum {
   MASTER_CONTRACT(1, "主合同"),
   QUANTITY_ADDITION_CONTRACT(2, "工程量增补合同"),
   REPLENISHMENT_CONTRACT(3, "补充合同"),
   PERSONAL_SERVICE_CONTRACT(4, "劳务合同");

   private final Integer type;
   private final String name;

   ContractTypeEnum(final Integer type, final String name) {
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
