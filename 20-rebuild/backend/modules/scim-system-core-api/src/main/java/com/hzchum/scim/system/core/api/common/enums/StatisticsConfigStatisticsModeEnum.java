package com.hzchum.scim.system.core.api.common.enums;

public enum StatisticsConfigStatisticsModeEnum {
   REAL_TIME_COMPUTING_MODE(1, "实时计算模式"),
   STORAGE_RETRODICT_MODE(2, "入库倒推模式");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (StatisticsConfigStatisticsModeEnum e : values()) {
         if (e.getType().equals(type)) {
            return e.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (StatisticsConfigStatisticsModeEnum e : values()) {
         if (e.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   StatisticsConfigStatisticsModeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
