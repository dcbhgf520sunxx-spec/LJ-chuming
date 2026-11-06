package com.hzchum.scim.scm.core.api.enums;

public enum ApplyPurchaseStateEnum {
   NOT_STARTED(1, "未开始"),
   PARTIAL_CREATED(2, "部分创建"),
   CREATED(4, "已创建");

   private final Integer type;
   private final String name;

   ApplyPurchaseStateEnum(Integer type, String name) {
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
