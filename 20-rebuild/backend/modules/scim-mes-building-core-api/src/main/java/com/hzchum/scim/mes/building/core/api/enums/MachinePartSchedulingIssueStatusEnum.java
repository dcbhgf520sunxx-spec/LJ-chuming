package com.hzchum.scim.mes.building.core.api.enums;

public enum MachinePartSchedulingIssueStatusEnum {
   NOT_NESTING(1, "未套料"),
   IN_NESTING(2, "套料中"),
   OUT_NESTING(4, "套料完成"),
   HAS_BEEN_ISSUED(8, "已下发");

   private Integer type;
   private String name;

   MachinePartSchedulingIssueStatusEnum(Integer type, String name) {
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
