package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MonomerDetailTypeEnum {
   STRUCTURE(1, "结构件"),
   BODY_PARTS(128, "箱体件");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      List<Integer> list = Arrays.stream(values()).map(MonomerDetailTypeEnum::getType).collect(Collectors.toList());
      return list.contains(type);
   }

   public static String getNameByType(Integer type) {
      for (MonomerDetailTypeEnum detailTypeEnum : values()) {
         if (detailTypeEnum.getType().equals(type)) {
            return detailTypeEnum.getName();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MonomerDetailTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
