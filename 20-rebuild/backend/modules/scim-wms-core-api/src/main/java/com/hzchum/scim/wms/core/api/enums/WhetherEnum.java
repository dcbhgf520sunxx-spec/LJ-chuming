package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum WhetherEnum {
   YES(1, true),
   NO(0, false);

   private Integer type;
   private Boolean value;

   WhetherEnum(Integer type, Boolean value) {
      this.type = type;
      this.value = value;
   }

   public static boolean isExist(Integer type) {
      Optional<WhetherEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static Boolean getValueByType(Integer type) {
      Optional<WhetherEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(WhetherEnum::getValue).orElse(null);
   }

   public Integer getType() {
      return this.type;
   }

   public Boolean getValue() {
      return this.value;
   }
}
