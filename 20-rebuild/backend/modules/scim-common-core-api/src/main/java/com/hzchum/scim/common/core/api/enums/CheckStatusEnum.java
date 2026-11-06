package com.hzchum.scim.common.core.api.enums;

public enum CheckStatusEnum {
   PENDING(1, "待审核"),
   PASS(2, "通过"),
   FAIL(4, "不通过"),
   CANCEL(8, "撤销"),
   REVOCATION(8, "驳回");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (CheckStatusEnum value : values()) {
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

   CheckStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
