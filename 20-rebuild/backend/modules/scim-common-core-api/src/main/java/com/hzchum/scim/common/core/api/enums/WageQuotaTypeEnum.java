package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WageQuotaTypeEnum {
   WEIGHT_PRICE(1, "按重量计价"),
   LENGTH_PRICE(2, "按长度计价"),
   AREA_PRICE(4, "按面积计价"),
   QUANTITY_PRICE(8, "按数量计价");

   private final int type;
   private final String name;

   public static WageQuotaTypeEnum getEnumByType(Integer type) {
      return Stream.of(values()).collect(Collectors.toMap(WageQuotaTypeEnum::getType, Function.identity(), (value1, value2) -> {
         throw new IllegalStateException("Duplicate key found: " + value1.getType());
      })).get(type);
   }

   public static boolean isExist(int type) {
      Optional<WageQuotaTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static boolean existEliminateArea(int type) {
      return Stream.of(values()).filter(typeEnum -> typeEnum.getType() != AREA_PRICE.getType()).anyMatch(typeEnum -> typeEnum.getType() == type);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WageQuotaTypeEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
