package com.hzchum.scim.iot.core.api.enums.equipment;

import java.util.Arrays;
import java.util.Optional;

public enum EquimentTypeEnum {
   OFF_LINE(1, "关机"),
   RUNNING(2, "运行"),
   SAKEDOWN_TEST(3, "调试"),
   IDLE(4, "空闲"),
   WARNING(5, "报警");

   private Integer type;
   private String name;

   EquimentTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<EquimentTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (EquimentTypeEnum value : values()) {
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
