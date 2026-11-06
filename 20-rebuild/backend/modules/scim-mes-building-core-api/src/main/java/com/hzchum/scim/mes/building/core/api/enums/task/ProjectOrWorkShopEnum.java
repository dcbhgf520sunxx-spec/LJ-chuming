package com.hzchum.scim.mes.building.core.api.enums.task;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectOrWorkShopEnum {
   PROJECT(1, "项目"),
   WORKSHOP(2, "车间");

   private Integer type;
   private String name;

   ProjectOrWorkShopEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<ProjectOrWorkShopEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
