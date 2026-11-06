package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmProjectScheduleTypeEnum {
   FILING_STATUS(1, "备案状态"),
   FOLLOW_UP_STATUS(2, "跟进通过状态"),
   PREQUALIFICATION_STATUS(3, "预审资格通过状态"),
   BID_APPLICATION_STATUS(5, "投标申请通过状态"),
   LAPSE_STATUS(7, "失效状态"),
   WINNING_BIDDER(8, "中标状态"),
   UNWINNING_BID(10, "未中标"),
   PROJECT_TERMINATION(11, "项目终止");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmProjectScheduleTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmProjectScheduleTypeEnum(final Integer type, final String name) {
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
