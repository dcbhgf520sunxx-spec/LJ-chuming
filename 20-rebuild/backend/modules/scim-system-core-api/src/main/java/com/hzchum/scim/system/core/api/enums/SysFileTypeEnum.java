package com.hzchum.scim.system.core.api.enums;

public enum SysFileTypeEnum {
   STANDARD_TYPE(1, "标准类"),
   ORDER_TYPE(2, "制度类");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SysFileTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
