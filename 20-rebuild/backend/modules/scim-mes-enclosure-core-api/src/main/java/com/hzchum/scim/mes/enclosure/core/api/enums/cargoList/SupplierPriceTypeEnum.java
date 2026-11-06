package com.hzchum.scim.mes.enclosure.core.api.enums.cargoList;

import java.util.Arrays;
import java.util.Optional;

public enum SupplierPriceTypeEnum {
   WEIGHT(1, "重量"),
   TRAIN_NUMBER(2, "车次");

   private int type;
   private String name;

   SupplierPriceTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<SupplierPriceTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
