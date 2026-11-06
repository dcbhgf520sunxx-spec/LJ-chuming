package com.hzchum.scim.project.core.api.enums;

public enum AuditStatusEnum {
   AUDITING(1, "审核中"),
   SUCCEED(2, "已通过"),
   FAILED(4, "已驳回");

   private final Integer type;
   private final String name;

   AuditStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
