package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;

public enum BranchCompanyLevelEnum {
   PRIMARY_UNIT(1, "一级单位", "工厂使用"),
   SECONDARY_UNIT(2, "二级单位", "工地使用");

   private final Integer type;
   private final String name;
   private final String level;

   public static String getNameByType(Integer type) {
      for (BranchCompanyLevelEnum levelEnum : values()) {
         if (levelEnum.getType().equals(type)) {
            return levelEnum.getName();
         }
      }

      return "";
   }

   public static String getLevelByType(Integer type) {
      for (BranchCompanyLevelEnum levelEnum : values()) {
         if (levelEnum.getType().equals(type)) {
            return levelEnum.getLevel();
         }
      }

      return "";
   }

   public static Boolean check(Integer type) {
      return Arrays.stream(values()).anyMatch(em -> em.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getLevel() {
      return this.level;
   }

   BranchCompanyLevelEnum(final Integer type, final String name, final String level) {
      this.type = type;
      this.name = name;
      this.level = level;
   }
}
