package com.hzchum.scim.common.core.api.enums;

public enum CreateTypeEnum {
   CREATED(1, "已创建"),
   NOTCREATED(2, "未创建");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CreateTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
