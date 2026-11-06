package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum WageQuotaTypeEnum {
   WEIGHT_PRICE(1, "按重量计价"),
   LENGTH_PRICE(2, "按长度计价"),
   AREA_PICE(4, "按面积计价"),
   QUANTITY_PICE(8, "按数量计价");

   private int type;
   private String name;

   WageQuotaTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<WageQuotaTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
