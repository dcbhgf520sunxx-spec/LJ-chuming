package com.hzchum.scim.mes.building.core.api.enums;

import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import java.util.Arrays;
import java.util.Optional;

public enum DockingMethodEnum {
   CARGO_WEIGHT(1, "查询近三天的过磅记录"),
   PLATE(2, "查询最近一次的过磅记录"),
   WEIGHT(4, "查询当前磅重（仅重量）");

   private Integer type;
   private String name;

   DockingMethodEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<TaskTypeEnum> optional = Arrays.stream(TaskTypeEnum.values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (DockingMethodEnum value : values()) {
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
