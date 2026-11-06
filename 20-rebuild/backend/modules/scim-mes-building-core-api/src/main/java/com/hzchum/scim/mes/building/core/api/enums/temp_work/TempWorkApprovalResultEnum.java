package com.hzchum.scim.mes.building.core.api.enums.temp_work;

import java.util.stream.Stream;

public enum TempWorkApprovalResultEnum {
   APPROVAL_PASS(1, "通过"),
   APPROVAL_REJECT(2, "驳回");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> e.getType().equals(type));
   }

   TempWorkApprovalResultEnum(final Integer type, final String name) {
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
