package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OrderTransportTypeEnum {
   SELF_MENTION(1, "自提"),
   TO_FACTORY(2, "到厂");

   private Integer type;
   private String name;

   OrderTransportTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer type) {
      Optional<OrderTransportTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
