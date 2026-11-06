package com.hzchum.scim.project.core.api.enums;

public enum QhseStatusEnum {
   WAIT_RECTIFIED(1),
   RECTIFIED(2),
   CLOSED(3);

   private final Integer type;

   QhseStatusEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
