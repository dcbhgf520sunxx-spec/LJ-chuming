package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;

public enum SubSupplyTypeEnum {
   LABOR_SUPPLY(1L, "劳务分包"),
   CONSTRUCTION_MEASURES(2L, "施工措施"),
   MATERIAL_SUPPLY(3L, "专业分包"),
   QUALITYI_NSPECTION(4L, "质量检测"),
   RENTAL_SERVICE(5L, "租赁服务");

   private final Long type;
   private final String name;

   public static SubSupplyTypeEnum getByType(Long type) {
      return Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst().orElse(null);
   }

   public static String getNameByType(Long type) {
      SubSupplyTypeEnum supplyTypeEnum = Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst().orElse(null);
      return supplyTypeEnum != null ? supplyTypeEnum.getName() : null;
   }

   public Long getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SubSupplyTypeEnum(final Long type, final String name) {
      this.type = type;
      this.name = name;
   }
}
