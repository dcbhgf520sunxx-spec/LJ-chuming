package com.hzchum.scim.mes.building.core.api.enums.quota_config;

import java.util.Objects;
import java.util.stream.Stream;

public enum QuotaConfigArtifactConditionEnum {
   WEIGHT(1, "重量(吨)"),
   MACHINE_PART_QUANTITY(2, "零件数量"),
   CORBEL_QUANTITY(4, "牛腿数量"),
   CLASS_1_WELD(8, "一级焊缝(米)"),
   CLASS_2_WELD(16, "二级焊缝(米)"),
   CLASS_3_WELD(32, "三级焊缝(米)");

   private final int type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static String getName(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).map(QuotaConfigArtifactConditionEnum::getName).findFirst().orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   QuotaConfigArtifactConditionEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
