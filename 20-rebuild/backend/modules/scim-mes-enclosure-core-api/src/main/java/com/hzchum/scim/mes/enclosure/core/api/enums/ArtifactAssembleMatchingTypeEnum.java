package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ArtifactAssembleMatchingTypeEnum {
   NOTHING(1, "不具备"),
   PART(2, "部分具备"),
   WHOLE(4, "全具备");

   private final int type;
   private String name;

   ArtifactAssembleMatchingTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<ArtifactAssembleMatchingTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
