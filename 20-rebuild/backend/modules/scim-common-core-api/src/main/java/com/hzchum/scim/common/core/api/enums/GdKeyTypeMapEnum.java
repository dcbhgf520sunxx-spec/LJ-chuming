package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Optional;

public enum GdKeyTypeMapEnum {
   WEB(1, "WEB"),
   JS(2, "js"),
   ANDROID(4, "ANDROID"),
   IOS(8, "IOS"),
   WE_CHAT(16, "we_chat");

   private final Integer type;
   private final String name;

   GdKeyTypeMapEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer type) {
      Optional<GdKeyTypeMapEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(GdKeyTypeMapEnum::getName).orElse(null);
   }

   public static Boolean isExist(Integer type) {
      Preconditions.checkArgument(type != null, "type不能为空!");

      for (GdKeyTypeMapEnum value : values()) {
         if (value.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
