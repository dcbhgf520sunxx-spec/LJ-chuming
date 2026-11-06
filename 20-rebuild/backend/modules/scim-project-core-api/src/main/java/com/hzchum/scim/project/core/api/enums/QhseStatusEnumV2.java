package com.hzchum.scim.project.core.api.enums;

public enum QhseStatusEnumV2 {
   NOT_NEED_REPLY(1, "无需回复"),
   NO_REPLY(2, "未回复"),
   REPLIED(4, "已回复"),
   CLOSED(8, "已关闭");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (QhseStatusEnumV2 value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   QhseStatusEnumV2(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
