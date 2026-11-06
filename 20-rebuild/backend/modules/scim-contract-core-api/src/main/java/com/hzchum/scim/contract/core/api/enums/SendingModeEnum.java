package com.hzchum.scim.contract.core.api.enums;

public enum SendingModeEnum {
   PROPRIETOR_CONTRACT_OUT(1, "业主直接发包"),
   SPECIALIZED_SUBCONTRACT(2, "专业分包"),
   GENERAL_CONTRACT(3, "总承包");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (SendingModeEnum item : values()) {
         if (item.getType().equals(type)) {
            return item.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(String name) {
      for (SendingModeEnum item : values()) {
         if (item.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SendingModeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
