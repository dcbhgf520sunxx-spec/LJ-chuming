package com.hzchum.scim.system.core.api.common.enums;

public enum ApproveStatusEnum {
   WAIT(1),
   PASS(2),
   FAIL(4),
   CANCEL(8);

   private int type;

   ApproveStatusEnum(int type) {
      this.type = type;
   }

   public int getType() {
      return this.type;
   }
}
