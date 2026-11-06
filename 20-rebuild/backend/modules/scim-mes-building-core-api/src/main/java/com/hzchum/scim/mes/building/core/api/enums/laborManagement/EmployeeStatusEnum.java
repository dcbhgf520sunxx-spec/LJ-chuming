package com.hzchum.scim.mes.building.core.api.enums.laborManagement;

import java.util.Arrays;
import java.util.Optional;

public enum EmployeeStatusEnum {
   ON_JOB(1, "在岗"),
   DIMISSION(2, "离职");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      Optional<EmployeeStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   EmployeeStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
