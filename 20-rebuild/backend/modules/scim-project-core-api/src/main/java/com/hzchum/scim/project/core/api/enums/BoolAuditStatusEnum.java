package com.hzchum.scim.project.core.api.enums;

public enum BoolAuditStatusEnum {
   AUDITED(true, "已审核"),
   UN_AUDITED(false, "未审核");

   private final boolean type;
   private final String name;

   public boolean isType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   BoolAuditStatusEnum(final boolean type, final String name) {
      this.type = type;
      this.name = name;
   }
}
