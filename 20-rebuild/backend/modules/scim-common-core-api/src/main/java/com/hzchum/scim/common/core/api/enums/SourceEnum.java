package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SourceEnum {
   USER_ADDITION(1, "用户新增"),
   CURRENT_SYSTEM(2, "系统自定义");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (SourceEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<SourceEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SourceEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
