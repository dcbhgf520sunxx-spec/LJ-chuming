package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SaveProduceTeamReportSummaryTypeEnum {
   PRODUCE_REPORT(0, "生产上报需质检"),
   UN_INSPECTION_REPORT(1, "生产上报不质检"),
   INSPECTION_REPORT(2, "质检通过"),
   PROBLEM_REPORT(3, "问题上报"),
   ADOPT_PROBLEM_REPORT(4, "问题通过");

   private int type;
   private String name;

   SaveProduceTeamReportSummaryTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<SaveProduceTeamReportSummaryTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
