package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RawMaterialLossEnum {
   FORMULA_ONE(1, "原料投料累计 - 零件制成品累计"),
   FORMULA_TWO(2, "原料实际领料累计 - 零件制成品累计");

   private final int type;
   private final String name;

   public static RawMaterialLossEnum getEnumByType(Integer type) {
      return Stream.of(values()).collect(Collectors.toMap(RawMaterialLossEnum::getType, Function.identity(), (value1, value2) -> {
         throw new IllegalStateException("Duplicate key found: " + value1.getType());
      })).get(type);
   }

   public static boolean isExist(int type) {
      Optional<RawMaterialLossEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   RawMaterialLossEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
