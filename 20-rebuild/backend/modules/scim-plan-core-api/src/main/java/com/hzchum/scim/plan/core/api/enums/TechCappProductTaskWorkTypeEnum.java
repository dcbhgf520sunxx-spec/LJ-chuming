package com.hzchum.scim.plan.core.api.enums;

public enum TechCappProductTaskWorkTypeEnum {
   UNSTART(1, "未开始"),
   PROCESSING(2, "进行中"),
   COMPLETED(4, "已完成");

   private final Integer type;
   private final String name;

   TechCappProductTaskWorkTypeEnum(final Integer type, final String name) {
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
