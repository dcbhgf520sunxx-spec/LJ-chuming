package com.hzchum.scim.plan.core.api.enums;

public enum PermissionCheckEnum {
   UNCHECKED_PERMISSION(0, "uncheckedPermission"),
   CHECK_PERMISSION(1, "checkPermission");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   PermissionCheckEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
