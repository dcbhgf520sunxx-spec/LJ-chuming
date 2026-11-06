package com.hzchum.scim.contract.core.api.enums;

public enum ContractNumberEnum {
   CONTRACT_PRE_REGISTRATION(1, "合同预登记", "YDJ"),
   CONTRACT_REVIEW_REGISTRATION(2, "合同评审登记", "PSDJ"),
   CONTRACT_IMMEDIATE_REGISTRATION(3, "合同直接登记", "ZJDJ");

   private Integer type;
   private String name;
   private String prefix;

   ContractNumberEnum(final Integer type, final String name, final String prefix) {
      this.type = type;
      this.name = name;
      this.prefix = prefix;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getPrefix() {
      return this.prefix;
   }
}
