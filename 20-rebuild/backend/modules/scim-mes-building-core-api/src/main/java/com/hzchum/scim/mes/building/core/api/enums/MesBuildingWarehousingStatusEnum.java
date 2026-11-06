package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MesBuildingWarehousingStatusEnum {
   NO_WAREHOUSING(1, "未入库"),
   SOME_WAREHOUSING(2, "部分入库"),
   WAREHOUSING(4, "已入库");

   private Integer type;
   private String name;

   MesBuildingWarehousingStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<MesBuildingWarehousingStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
