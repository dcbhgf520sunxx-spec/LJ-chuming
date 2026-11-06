package com.hzchum.scim.system.core.api.common.enums;

public enum ApproveProcessTypeEnum {
   APPLY_PURCHASE(1, "申购");

   private Integer type;
   private String name;

   ApproveProcessTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static Boolean exist(String name) {
      for (ApproveProcessTypeEnum approveProcessTypeEnum : values()) {
         if (approveProcessTypeEnum.name.equals(name)) {
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
}
