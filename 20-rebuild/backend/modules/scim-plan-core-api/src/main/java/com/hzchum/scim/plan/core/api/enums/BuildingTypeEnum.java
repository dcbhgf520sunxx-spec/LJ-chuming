package com.hzchum.scim.plan.core.api.enums;

public enum BuildingTypeEnum {
   UNKNOWN(0, "未确定", 0),
   BUILDING(1, "建钢构件", 1),
   BRIDGE(2, "桥梁构件", 2),
   GRID(8, "网架构件", 1);

   private final Integer type;
   private final String name;
   private final Integer mesProductType;

   public static Integer getMesProductTypeByType(Integer type) {
      BuildingTypeEnum[] enums = values();

      for (BuildingTypeEnum anEnum : enums) {
         if (!anEnum.getType().equals(UNKNOWN.getType()) && anEnum.getType().equals(type)) {
            return anEnum.getMesProductType();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMesProductType() {
      return this.mesProductType;
   }

   BuildingTypeEnum(final Integer type, final String name, final Integer mesProductType) {
      this.type = type;
      this.name = name;
      this.mesProductType = mesProductType;
   }
}
