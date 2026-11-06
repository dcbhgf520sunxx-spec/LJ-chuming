package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;

public enum EnclosureChangeLogTypeEnum {
   TECH_ENCLOSURE(2, "清单表"),
   ENCLOSURE_TASK(4, "任务表"),
   ENCLOSURE_ORDER(8, "工单表"),
   TEAM_REPORT(16, "上报表"),
   ENCLOSURE_COMPLETE(32, "完成表"),
   ENCLOSURE_WAREHOUSE(64, "入库表"),
   ENCLOSURE_WAREHOUSE_SUMMARY(128, "入库汇总表");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.type.equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   EnclosureChangeLogTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
