package com.hzchum.scim.mes.building.core.api.enums.task;

import java.util.Arrays;
import java.util.Optional;

public enum TaskTypeEnum {
   MACHINE_PART(1, "零件"),
   ARTIFACT(2, "构件"),
   ENCLOSURE(4, "围护"),
   AUXILIARY_MATERIAL(8, "配套件"),
   ASSEMBLE(16, "组立"),
   MACHINE_PART_NESTING(64, "零件切割指令");

   private Integer type;
   private String name;

   TaskTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<TaskTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (TaskTypeEnum value : values()) {
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
