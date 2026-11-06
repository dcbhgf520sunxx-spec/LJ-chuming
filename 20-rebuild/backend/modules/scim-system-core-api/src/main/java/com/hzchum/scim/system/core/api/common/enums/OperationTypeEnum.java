package com.hzchum.scim.system.core.api.common.enums;

public enum OperationTypeEnum {
   ADD(1),
   UPDATE(2),
   DELETE(3),
   OTHER(4);

   private Integer type;

   OperationTypeEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
