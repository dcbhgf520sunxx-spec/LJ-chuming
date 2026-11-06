package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmProjectInformationConfigEnum {
   CONFIGURATION_OF_ARCHITECTURAL_FORM(1, "建筑形式配置"),
   STRUCTURE_TYPE_CONFIGURATION(2, "结构类型配置"),
   KEY_PROJECT(3, "重点项目"),
   ITEM_CATEGORY(4, "项目类别"),
   TYPE_OF_CONTRACTOR(5, "承建类别"),
   DIFFICULTY_FACTOR(6, "难度系数"),
   FOLLOW_UP_METHODS(8, "跟进方式"),
   PROJECT_LEVEL_CONFIG(9, "项目级别"),
   PROJECT_MANAGER_COOPERATION(10, "项目经理配合");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmProjectInformationConfigEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmProjectInformationConfigEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
