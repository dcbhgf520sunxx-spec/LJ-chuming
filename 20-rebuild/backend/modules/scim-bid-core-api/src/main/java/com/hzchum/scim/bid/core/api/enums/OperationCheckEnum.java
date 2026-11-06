package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OperationCheckEnum {
   NOT_PASS(1, "审核不通过"),
   RELEASED(2, "审核通过");

   private Integer type;
   private String name;

   OperationCheckEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<OperationCheckEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
