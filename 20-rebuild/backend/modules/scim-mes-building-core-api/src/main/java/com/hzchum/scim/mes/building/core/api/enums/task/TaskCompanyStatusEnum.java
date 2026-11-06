package com.hzchum.scim.mes.building.core.api.enums.task;

import java.util.Arrays;
import java.util.Optional;

public enum TaskCompanyStatusEnum {
   UNFINISHED(1, "未完成"),
   PARTLY_COMPLETED(2, "部分完成"),
   COMPLETED(4, "已完成");

   private Integer type;
   private String name;

   TaskCompanyStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<TaskCompanyStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (TaskCompanyStatusEnum value : values()) {
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
