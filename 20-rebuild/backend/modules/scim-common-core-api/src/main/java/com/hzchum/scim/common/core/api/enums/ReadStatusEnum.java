package com.hzchum.scim.common.core.api.enums;

public enum ReadStatusEnum {
   READ(true, "已读"),
   UNREAD(false, "未读");

   private Boolean type;
   private String name;

   ReadStatusEnum(Boolean type, String name) {
      this.type = type;
      this.name = name;
   }

   public Boolean getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
