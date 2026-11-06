package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MesEnclosureProjectNestingStatusEnum {
   NO_NESTING(1, "未套料"),
   PORTION_NESTING(2, "部分套料"),
   ENTIRELY(4, "已套料");

   private final Integer type;
   private final String name;

   MesEnclosureProjectNestingStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<MesEnclosureProjectNestingStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
