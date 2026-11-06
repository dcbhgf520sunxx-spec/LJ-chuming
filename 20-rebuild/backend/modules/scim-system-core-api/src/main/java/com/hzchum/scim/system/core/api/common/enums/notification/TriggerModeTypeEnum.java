package com.hzchum.scim.system.core.api.common.enums.notification;

public enum TriggerModeTypeEnum {
   BUSINESS_ARRIVAL(1, "业务到达"),
   BUSINESS_COMPLETION(2, "业务完成"),
   BUSINESS_OVERDUE(3, "业务超期"),
   BUSINESS_EXPIRED(4, "业务过期");

   private int type;
   private String name;

   TriggerModeTypeEnum(int type, String name) {
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
