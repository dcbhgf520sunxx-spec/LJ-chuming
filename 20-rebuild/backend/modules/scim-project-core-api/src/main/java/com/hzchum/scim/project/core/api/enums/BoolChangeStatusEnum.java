package com.hzchum.scim.project.core.api.enums;

public enum BoolChangeStatusEnum {
   NOT_CHANGE(false, "未整改"),
   CHANGED(true, "已整改");

   private final boolean type;
   private final String name;

   public boolean isType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   BoolChangeStatusEnum(final boolean type, final String name) {
      this.type = type;
      this.name = name;
   }
}
