package com.hzchum.scim.system.core.api.enums;

public enum AuditStateEnum {
   INIT(0, "已初始化"),
   AUDITING(1, "已创建"),
   SUCCEED(2, "已通过"),
   FAILED(4, "已驳回");

   private final Integer type;
   private final String name;

   AuditStateEnum(final Integer type, final String name) {
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
