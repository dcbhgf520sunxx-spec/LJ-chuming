package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AssistEnum {
   CAN_OPERATED(1, "可协同"),
   OPERATED(2, "已协同");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<ProjectTypeEnum> optional = Arrays.stream(ProjectTypeEnum.values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(ProjectTypeEnum::getName).orElse(null);
   }

   AssistEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
