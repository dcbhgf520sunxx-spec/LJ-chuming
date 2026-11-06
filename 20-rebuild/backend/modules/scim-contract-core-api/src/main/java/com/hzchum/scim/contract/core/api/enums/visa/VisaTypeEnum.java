package com.hzchum.scim.contract.core.api.enums.visa;

public enum VisaTypeEnum {
   VISA(1),
   SETTLEMENT(2);

   private final Integer type;

   VisaTypeEnum(final Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
