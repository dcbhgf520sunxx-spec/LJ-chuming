package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum EmployeeCategoryEnum {
   OWN_EMPLOYEE(1, "自有员工"),
   EXPATRIATE_EMPLOYEES(2, "外派员工");

   private final int type;
   private final String name;

   public static boolean isExist(int type) {
      Optional<EmployeeCategoryEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   EmployeeCategoryEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
