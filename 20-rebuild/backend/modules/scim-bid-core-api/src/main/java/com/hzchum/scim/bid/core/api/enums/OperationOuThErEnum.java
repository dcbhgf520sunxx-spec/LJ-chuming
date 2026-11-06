package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OperationOuThErEnum {
   PAUSED(0, "废标"),
   IS_START(1, "暂停"),
   GO(2, "继续招标");

   private Integer type;
   private String name;

   OperationOuThErEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<OperationOuThErEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
