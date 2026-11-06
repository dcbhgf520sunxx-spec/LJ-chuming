package com.hzchum.scim.mes.building.core.api.enums.wage_quota;

import java.util.stream.Stream;

public enum TempWorkQuotaConfigTypeEnum {
   HOURLY_WAGE(1, "计时工价"),
   APPROVAL_INPUT(2, "审批录入");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> e.getType().equals(type));
   }

   TempWorkQuotaConfigTypeEnum(final Integer type, final String name) {
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
