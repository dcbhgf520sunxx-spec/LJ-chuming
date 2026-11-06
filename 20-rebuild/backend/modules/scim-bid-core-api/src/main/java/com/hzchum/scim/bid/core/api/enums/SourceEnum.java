package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SourceEnum {
   SYSTEM(0, "系统"),
   CUSTOM(1, "自定义");

   private Integer type;
   private String name;

   SourceEnum(int type, String name) {
      this.type = type;
      this.name = name;
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
}
