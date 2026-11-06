package com.hzchum.scim.project.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ClockInTypeEnum {
   MORNING_WORKING(1, "上午上班"),
   MORNING_CLOSING(2, "上午下班"),
   AFTERNOON_WORKING(4, "下午上班"),
   AFTERNOON_CLOSING(8, "下午下班"),
   OVERTIME_WORKING(16, "加班上班"),
   OVERTIME_CLOSING(32, "加班下班");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<ClockInTypeEnum> optional = Arrays.stream(values()).filter(item -> item.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : "";
   }

   public static boolean isExist(int type) {
      return Arrays.stream(values()).anyMatch(item -> item.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ClockInTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
