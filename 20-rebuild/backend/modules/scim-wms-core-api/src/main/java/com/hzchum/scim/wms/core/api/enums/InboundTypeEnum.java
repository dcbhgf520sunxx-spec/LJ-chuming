package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum InboundTypeEnum {
   DAILY_PREPARATION(1, "公共"),
   PROJECT_SPECIFIC(2, "项目"),
   SUPPLY_MATERIAL(4, "甲供");

   private Integer type;
   private String name;

   InboundTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<InboundTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getNameByType(Integer type) {
      switch (type) {
         case 1:
            return DAILY_PREPARATION.getName();
         case 2:
            return PROJECT_SPECIFIC.getName();
         case 3:
         default:
            return "";
         case 4:
            return SUPPLY_MATERIAL.getName();
      }
   }
}
