package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PartProdModeEnum {
   CNCUTTING(1, "数控切割"),
   SEMI_AUTO_CUTTING(2, "半自动切割");

   private int type;
   private String name;

   PartProdModeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<QhseTypeEnum> optional = Arrays.stream(QhseTypeEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
