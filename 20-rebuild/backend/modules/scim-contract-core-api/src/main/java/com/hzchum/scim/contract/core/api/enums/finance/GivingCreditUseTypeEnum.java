package com.hzchum.scim.contract.core.api.enums.finance;

public enum GivingCreditUseTypeEnum {
   LEND_MONEY(1, "借款"),
   RETURN_MONEY(2, "还款");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   GivingCreditUseTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
