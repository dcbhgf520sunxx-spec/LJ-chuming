package com.hzchum.scim.project.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QhseTypeEnum {
   QUALITY(1, "质量问题", "quality"),
   SECURITY(2, "安全问题", "security"),
   ENVIRONMENT(4, "环境问题", "environment");

   private Integer type;
   private String name;
   private String value;

   public static boolean isExist(int type) {
      Optional<QhseTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (QhseTypeEnum value : values()) {
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

   public String getValue() {
      return this.value;
   }

   QhseTypeEnum(final Integer type, final String name, final String value) {
      this.type = type;
      this.name = name;
      this.value = value;
   }
}
