package com.hzchum.scim.common.core.api.enums;

public enum OldCheckStatusEnum {
   PENDING(0),
   PASS(1),
   FAIL(2);

   private final Integer type;

   OldCheckStatusEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
