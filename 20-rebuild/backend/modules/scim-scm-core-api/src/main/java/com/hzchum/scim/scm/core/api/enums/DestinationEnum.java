package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DestinationEnum {
   DIRECT_TO_SITE(1, "直发工地"),
   DIRECT_TO_FACTORY(2, "直发工厂"),
   SITE_AND_FACTORY(4, "直发工地和工厂");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   DestinationEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<LogisticsPayerEnum> optional = Arrays.stream(LogisticsPayerEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
