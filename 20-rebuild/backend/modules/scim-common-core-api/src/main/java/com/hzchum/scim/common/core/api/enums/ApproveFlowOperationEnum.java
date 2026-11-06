package com.hzchum.scim.common.core.api.enums;

public enum ApproveFlowOperationEnum {
   OPERATION_MONEY(1, "金额修改或填写"),
   FREIGHT_MSG(2, "运费信息修改或填写");

   private Integer type;
   private String name;

   ApproveFlowOperationEnum(int type, String name) {
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
