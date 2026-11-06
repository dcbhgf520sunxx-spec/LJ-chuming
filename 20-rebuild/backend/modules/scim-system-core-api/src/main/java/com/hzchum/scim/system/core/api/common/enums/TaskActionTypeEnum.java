package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TaskActionTypeEnum {
   AND(1, "AND"),
   OR(2, "OR"),
   NONE(3, "NONE");

   private int type;
   private String name;

   TaskActionTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(int type) {
      Optional<TaskActionTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.map(TaskActionTypeEnum::getName).orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
