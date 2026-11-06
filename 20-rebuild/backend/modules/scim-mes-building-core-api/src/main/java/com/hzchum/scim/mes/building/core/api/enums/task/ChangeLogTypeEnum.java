package com.hzchum.scim.mes.building.core.api.enums.task;

import java.util.Arrays;
import java.util.Optional;

public enum ChangeLogTypeEnum {
   WAREHOUSE_SUMMARY(1, "入库汇总"),
   WAREHOUSE_RECORD(2, "入库记录"),
   COMPLETE(4, "完成记录");

   private Integer type;
   private String name;

   ChangeLogTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<ChangeLogTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (ChangeLogTypeEnum value : values()) {
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
