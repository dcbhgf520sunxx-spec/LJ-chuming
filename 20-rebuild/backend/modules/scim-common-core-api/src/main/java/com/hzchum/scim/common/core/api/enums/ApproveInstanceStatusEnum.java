package com.hzchum.scim.common.core.api.enums;

public enum ApproveInstanceStatusEnum {
   NEW("NEW"),
   RUNNING("RUNNING"),
   TERMINATED("TERMINATED"),
   COMPLETED("COMPLETED"),
   CANCELED("CANCELED");

   private String name;

   ApproveInstanceStatusEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
