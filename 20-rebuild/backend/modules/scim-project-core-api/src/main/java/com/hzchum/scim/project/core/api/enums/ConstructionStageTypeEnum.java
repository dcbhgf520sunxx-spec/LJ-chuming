package com.hzchum.scim.project.core.api.enums;

public enum ConstructionStageTypeEnum {
   BEFORE_CONSTRUCTION(1),
   UNDER_CONSTRUCTION(2),
   AFTER_COMPLETION(4);

   private final Integer type;

   ConstructionStageTypeEnum(Integer type) {
      this.type = type;
   }
}
