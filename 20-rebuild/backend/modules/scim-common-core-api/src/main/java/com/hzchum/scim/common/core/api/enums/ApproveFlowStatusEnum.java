package com.hzchum.scim.common.core.api.enums;

public enum ApproveFlowStatusEnum {
   NO_START(0, "未开始"),
   UNDERWAY(1, "进行中"),
   PASS(2, "通过"),
   FAIL(4, "不通过"),
   CANCEL(8, "撤销");

   private Integer type;
   private String name;

   ApproveFlowStatusEnum(int type, String name) {
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
