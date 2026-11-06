package com.hzchum.scim.contract.core.api.enums;

public enum CollectionReasonEnum {
   PROCESS_PREPAYMENT("加工预付款"),
   ENGINEERING_PREPAYMENT("工程预付款"),
   FINISHED_PAYMENT("成品提货款"),
   PROCESS_SETTLEMENT("加工结算款"),
   EXPORTED_REBATE_TAX("出口退税");

   private final String name;

   public String getName() {
      return this.name;
   }

   CollectionReasonEnum(final String name) {
      this.name = name;
   }
}
