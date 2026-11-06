package com.hzchum.scim.system.core.api.common.enums;

public enum BimModelRestrictedTypeEnum {
   TOTAL_QUANTITY(1, "总次数"),
   FILE_SIZE(2, "文件大小");

   private int type;
   private String name;

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   BimModelRestrictedTypeEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
