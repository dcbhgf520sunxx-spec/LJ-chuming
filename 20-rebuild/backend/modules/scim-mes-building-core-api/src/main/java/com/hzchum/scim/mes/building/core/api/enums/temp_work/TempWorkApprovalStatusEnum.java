package com.hzchum.scim.mes.building.core.api.enums.temp_work;

import java.util.stream.Stream;

public enum TempWorkApprovalStatusEnum {
   WAIT_APPROVAL(1, "待审批"),
   APPROVAL_ING(2, "审批中"),
   APPROVAL_PASS(3, "审批通过"),
   APPROVAL_NOT_PASS(4, "审批未通过");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> e.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   TempWorkApprovalStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
