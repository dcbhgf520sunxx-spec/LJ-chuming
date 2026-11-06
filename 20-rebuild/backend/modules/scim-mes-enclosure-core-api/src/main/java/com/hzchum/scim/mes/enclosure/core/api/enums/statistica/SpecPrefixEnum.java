package com.hzchum.scim.mes.enclosure.core.api.enums.statistica;

import java.util.Arrays;
import java.util.Optional;

public enum SpecPrefixEnum {
   PL("PL");

   private String name;

   public static boolean isExist(String name) {
      Optional<SpecPrefixEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getName().equals(name)).findFirst();
      return optional.isPresent();
   }

   SpecPrefixEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
