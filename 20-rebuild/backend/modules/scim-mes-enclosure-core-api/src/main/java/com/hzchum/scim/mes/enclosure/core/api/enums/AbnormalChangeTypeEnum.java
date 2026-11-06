package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AbnormalChangeTypeEnum {
   ARTIFACT_REDUCE(1, "构件减少"),
   ARTIFACT_DELETE(2, "构件删除"),
   ASSEMBLE_REDUCE(4, "组立减少"),
   ASSEMBLE_DELETE(8, "组立删除"),
   MACHINE_PART_REDUCE(16, "零件减少"),
   MACHINE_PART_DELETE(32, "零件删除");

   private final int type;
   private String name;

   AbnormalChangeTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<AbnormalChangeTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
