package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TaskStatusTypeEnum {
   START(0, "正常"),
   ABNORMAL(1, "异常"),
   STOP(2, "停止");

   private final int type;
   private String name;

   TaskStatusTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<TaskStatusTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
