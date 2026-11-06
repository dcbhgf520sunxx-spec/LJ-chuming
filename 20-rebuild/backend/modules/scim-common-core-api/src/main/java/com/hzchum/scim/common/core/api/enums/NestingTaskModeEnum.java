package com.hzchum.scim.common.core.api.enums;

import java.util.Objects;
import java.util.stream.Stream;

public enum NestingTaskModeEnum {
   MODE_ONE(1, "根据铆焊班组独立生成套料任务"),
   MODE_TWO(2, "根据零件和翼腹板统一生成套料任务");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static NestingTaskModeEnum getEnumByType(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).findFirst().orElse(null);
   }

   public static String getNameByType(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).map(NestingTaskModeEnum::getName).findFirst().orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   NestingTaskModeEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
