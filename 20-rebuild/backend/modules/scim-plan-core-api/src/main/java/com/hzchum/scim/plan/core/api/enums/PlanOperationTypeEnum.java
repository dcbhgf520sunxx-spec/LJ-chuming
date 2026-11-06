package com.hzchum.scim.plan.core.api.enums;

public enum PlanOperationTypeEnum {
   ADD(1),
   UPDATE(2),
   DELETE(3),
   OTHER(4);

   private final Integer type;

   PlanOperationTypeEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
