package com.hzchum.scim.contract.core.api.enums.finance;

import java.util.Arrays;

public enum WageTypeEnum {
   MANAGER_WAGE(1, "管理人员工资"),
   PRODUCTION_PERSONNEL(2, "生产人员工资");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.getType().equals(type));
   }

   public static String getNameByType(Integer type) {
      for (WageTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WageTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
