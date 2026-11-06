package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ProjectModeEnum {
   ARTIFACT_MODE(1, "简约模式"),
   STANDARD_MODE(2, "标准模式");

   private final Integer type;
   private final String name;

   public static List<Integer> listAll() {
      return Arrays.stream(values()).map(ProjectModeEnum::getType).collect(Collectors.toList());
   }

   ProjectModeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
