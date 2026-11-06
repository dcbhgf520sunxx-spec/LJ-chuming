package com.hzchum.scim.scm.core.api.enums;

public enum SubOrderStatusEnum {
   PROCESSING(1, "进行中"),
   PAUSE(2, "已暂停"),
   COMPLETED(4, "已完成"),
   SETTLEMENTSTATUS(8, "已结算");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SubOrderStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
