package com.hzchum.scim.project.core.api.enums;

public enum OutReceiveState {
   NOT_RECEIVED(1, "未收货"),
   SOME_RECEIVED(2, "部分收货"),
   FINISH_RECEIVED(4, "收货完成");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   OutReceiveState(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
