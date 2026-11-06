package com.hzchum.scim.common.core.api.enums;

public enum ApproveRecordStatusEnum {
   NO_START(0, "未开始"),
   UNDERWAY(1, "进行中"),
   END(2, "结束");

   private Integer type;
   private String name;

   ApproveRecordStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
