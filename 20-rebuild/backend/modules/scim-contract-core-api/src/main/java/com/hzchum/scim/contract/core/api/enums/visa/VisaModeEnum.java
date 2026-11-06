package com.hzchum.scim.contract.core.api.enums.visa;

public enum VisaModeEnum {
   INTERNALLY(1),
   FOREIGN(2);

   private final Integer type;

   VisaModeEnum(final Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
