package com.hzchum.scim.contract.core.api.enums.finance;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WaterElectricityPropertyFeeTypeEnum {
   WATER_FEE(1, "水费"),
   ELECTRICITY_FEE(2, "电费"),
   PROPERTY_FEE(3, "物业费");

   private static final Map<Integer, WaterElectricityPropertyFeeTypeEnum> enumMap = Stream.of(values())
      .collect(Collectors.toMap(WaterElectricityPropertyFeeTypeEnum::getType, Function.identity()));
   private final int type;
   private final String name;

   public static String getNameByType(Integer type) {
      WaterElectricityPropertyFeeTypeEnum e = enumMap.get(type);
      return e == null ? null : e.getName();
   }

   public static List<Integer> getWaterElectricityType() {
      return Stream.of(values()).map(WaterElectricityPropertyFeeTypeEnum::getType).filter(type -> type != PROPERTY_FEE.getType()).collect(Collectors.toList());
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WaterElectricityPropertyFeeTypeEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
