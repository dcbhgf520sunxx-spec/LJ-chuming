package com.hzchum.scim.mes.building.core.api.enums.quota_config;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum QuotaConfigMeasureUnitEnum {
   TON(1, "吨"),
   METER(2, "米"),
   PIECE(4, "件"),
   SQUARE_METER(8, "平方米"),
   SET(16, "套"),
   GRAIN(32, "颗"),
   PERFORATE_QUANTITY(64, "打孔数");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static boolean isExist(String name) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getName(), name));
   }

   public static List<Integer> getTonMeterPieceType() {
      EnumSet<QuotaConfigMeasureUnitEnum> enumSet = EnumSet.of(TON, METER, PIECE);
      return enumSet.stream().map(QuotaConfigMeasureUnitEnum::getType).collect(Collectors.toList());
   }

   public static List<String> getTonMeterPieceName() {
      EnumSet<QuotaConfigMeasureUnitEnum> enumSet = EnumSet.of(TON, METER, PIECE);
      return enumSet.stream().map(QuotaConfigMeasureUnitEnum::getName).collect(Collectors.toList());
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   QuotaConfigMeasureUnitEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
