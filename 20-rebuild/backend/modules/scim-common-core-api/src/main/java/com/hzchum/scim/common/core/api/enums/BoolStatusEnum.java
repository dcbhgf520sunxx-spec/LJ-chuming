package com.hzchum.scim.common.core.api.enums;

public enum BoolStatusEnum {
   NORMAL(Boolean.TRUE, "进行中"),
   PAUSED(Boolean.FALSE, "已暂停");

   private final Boolean type;
   private final String desc;

   public Boolean getType() {
      return this.type;
   }

   public String getDesc() {
      return this.desc;
   }

   BoolStatusEnum(final Boolean type, final String desc) {
      this.type = type;
      this.desc = desc;
   }
}
