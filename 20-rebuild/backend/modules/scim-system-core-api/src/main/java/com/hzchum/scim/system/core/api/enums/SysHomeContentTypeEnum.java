package com.hzchum.scim.system.core.api.enums;

public enum SysHomeContentTypeEnum {
   CONTENT_TYPE(1, "内容输入"),
   ATTACH_TYPE(2, "附件导入");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SysHomeContentTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
