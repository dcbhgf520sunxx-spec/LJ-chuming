package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum NoDefinitionArtifactPrefixEnum {
   PL("PL");

   private final String name;

   NoDefinitionArtifactPrefixEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(String name) {
      Optional<NoDefinitionArtifactPrefixEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getName().equals(name)).findFirst();
      return optional.isPresent();
   }
}
