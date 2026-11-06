package com.hzchum.scim.mes.building.core.api.enums.task;

import java.util.Arrays;
import java.util.Optional;

public enum TaskReportTypeEnum {
   REPORT(1, "生产上报"),
   INSPECTION(2, "质检上报");

   private Integer type;
   private String name;

   TaskReportTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<TaskReportTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (TaskReportTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
