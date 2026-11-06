package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PreparationRangeEnum {
   PROJECT(1, "项目", "P"),
   MONOMER(2, "单体", "M"),
   AREA(3, "区域", "A");

   private Integer type;
   private String name;
   private String code;

   PreparationRangeEnum(int type, String name, String code) {
      this.type = type;
      this.name = name;
      this.code = code;
   }

   public static boolean isExist(int type) {
      Optional<PreparationRangeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(int type) {
      Optional<PreparationRangeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public static String getCodeByType(int type) {
      Optional<PreparationRangeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getCode() : null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
   }
}
