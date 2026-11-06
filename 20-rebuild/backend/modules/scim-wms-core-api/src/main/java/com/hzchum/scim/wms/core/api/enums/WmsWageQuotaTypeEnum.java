package com.hzchum.scim.wms.core.api.enums;

public enum WmsWageQuotaTypeEnum {
   WMS_WEIGHT_PRICE(1, "按重量计价"),
   WMS_LENGTH_PRICE(2, "按长度计价"),
   WMS_AREA_PRICE(4, "按面积计价"),
   WMS_QUANTITY_PRICE(8, "按数量计价");

   private final int type;
   private final String name;

   WmsWageQuotaTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
