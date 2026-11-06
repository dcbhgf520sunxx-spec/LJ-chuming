package com.hzchum.scim.contract.core.api.enums.finance;

public enum AmountOperationTypeEnum {
   DEDUCT(1, "扣除"),
   RETURN(2, "退还");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AmountOperationTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
