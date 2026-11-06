package com.hzchum.scim.mes.building.core.api.enums.cargoList;

import java.util.Arrays;
import java.util.Optional;

public enum CargoListShipEnum {
   INVENTORY(1, "清单"),
   ASSIGNMENT(2, "任务"),
   STORAGE(3, "入库"),
   CUMULATIVE_SHIPMENT(4, "累计发运"),
   SHIPMENT_MONTH(5, "本月发运"),
   IN_STOCK(6, "库存"),
   ACCUMULATED_NUMBER(7, "累计车次"),
   PACKAGE(8, "打包量(未装车)");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CargoListShipEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(CargoListShipEnum::getName).orElse(null);
   }

   CargoListShipEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
