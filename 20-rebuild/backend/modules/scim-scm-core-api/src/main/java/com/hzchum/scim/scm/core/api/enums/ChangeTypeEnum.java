package com.hzchum.scim.scm.core.api.enums;

public enum ChangeTypeEnum {
   PRICE_SET(1, "价格变更"),
   GROUP_ADJUST(2, "分组调整"),
   GROUP_RESET(4, "分组重置");

   private final Integer type;
   private final String name;

   ChangeTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getName(Integer type) {
      String v = "";

      for (ChangeTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            v = value.getName();
         }
      }

      return v;
   }
}
