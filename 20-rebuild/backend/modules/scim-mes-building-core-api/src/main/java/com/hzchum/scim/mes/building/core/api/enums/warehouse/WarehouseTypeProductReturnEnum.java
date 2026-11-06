package com.hzchum.scim.mes.building.core.api.enums.warehouse;

public enum WarehouseTypeProductReturnEnum {
   NORMAL(0, "普通出入库"),
   REPAIR(1, "回厂返修出入库"),
   SUBSCRIBE(2, "申购出入库");

   int type;
   String name;

   WarehouseTypeProductReturnEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      for (WarehouseTypeProductReturnEnum value : values()) {
         if (value.getType() == type) {
            return true;
         }
      }

      return false;
   }

   public int getType() {
      return this.type;
   }
}
