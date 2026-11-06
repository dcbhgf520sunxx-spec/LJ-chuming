package com.hzchum.scim.scm.core.api.enums;

public enum SubOrderApproveStatusEnum {
   NORMAL(1, "正常状态"),
   UPDATE_APPROVE(2, "修改-审批中"),
   DEL_APPROVE(4, "删除-审批中");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SubOrderApproveStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
