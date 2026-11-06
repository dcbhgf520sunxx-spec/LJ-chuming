package com.hzchum.scim.wms.core.api.enums;

public enum PickingStatusEnum {
   NOT_PROCESSED(1, "未办理"),
   PROCESSING(2, "办理中"),
   HANDLED(3, "已办理");

   private final int type;
   private final String name;

   PickingStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
