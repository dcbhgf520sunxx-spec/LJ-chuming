package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TransportTypeEnum {
   PUBLIC_TRANSFER(2, "客户自提"),
   PRIVATE_TRANSFER(1, "运送到场");

   private Integer type;
   private String name;

   TransportTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer type) {
      Optional<TransportTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public static TransportTypeEnum getByType(Integer type) {
      Optional<TransportTypeEnum> optional = Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst();
      return optional.orElse(null);
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
