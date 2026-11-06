package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QhseTypeEnum {
   QUALITY(1, "质量问题", "quality"),
   SECURITY(2, "安全问题", "security"),
   ENVIRONMENT(4, "环境问题", "environment"),
   SPECIAL_QUALITY(8, "特殊质量问题", "specialQuality");

   private int type;
   private String name;
   private String value;

   QhseTypeEnum(int type, String name, String value) {
      this.type = type;
      this.name = name;
      this.value = value;
   }

   public static boolean isExist(int type) {
      Optional<QhseTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }
}
