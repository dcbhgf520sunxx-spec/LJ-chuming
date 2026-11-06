package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MesBuildingTypesettingAssembleTypeEnum {
   WELDING(1, "焊接型材"),
   FINISHED(2, "成品型材");

   private Integer type;
   private String name;

   MesBuildingTypesettingAssembleTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<MesBuildingTypesettingAssembleTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      Optional<MesBuildingTypesettingAssembleTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.map(MesBuildingTypesettingAssembleTypeEnum::getName).orElse(null);
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
