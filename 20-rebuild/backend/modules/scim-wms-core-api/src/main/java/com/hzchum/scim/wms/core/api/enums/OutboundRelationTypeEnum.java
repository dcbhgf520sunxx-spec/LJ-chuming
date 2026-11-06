package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OutboundRelationTypeEnum {
   ROUTINE(1, "常规"),
   TRANSFER(2, "调拨"),
   CUT(4, "切割"),
   CUT_TRANSFER(8, "切割调拨");

   private final Integer type;
   private final String name;

   OutboundRelationTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(int type) {
      Optional<OutboundRelationTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
