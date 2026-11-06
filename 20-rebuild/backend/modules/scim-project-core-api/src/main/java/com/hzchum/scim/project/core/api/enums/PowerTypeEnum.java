package com.hzchum.scim.project.core.api.enums;

public enum PowerTypeEnum {
   VIEW(1, "查看"),
   REPLY(2, "整改"),
   EXAMINE(4, "审核");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (PowerTypeEnum value : values()) {
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

   PowerTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
