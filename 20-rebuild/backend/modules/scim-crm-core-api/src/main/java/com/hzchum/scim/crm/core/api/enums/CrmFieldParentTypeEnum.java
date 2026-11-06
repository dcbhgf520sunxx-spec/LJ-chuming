package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmFieldParentTypeEnum {
   BASIC_INFORMATION(1, "一、基本信息", 1),
   TENDER_ITEM(2, "二、招标事项", 2),
   FOLLOW_UP_INFORMATION(3, "二、跟进信息", 2),
   BUSINESS_INFORMATION(4, "二、商务信息", 2),
   OTHER_INFORMATION(5, "二、其他信息", 2),
   TRACE_LINE(6, "三、跟踪线", 3),
   OTHER(7, "四、其他", 4);

   private final Integer type;
   private final String name;
   private final Integer sort;

   public static String getNameByType(Integer type) {
      Optional<CrmFieldParentTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public static Integer getSortByType(Integer type) {
      Optional<CrmFieldParentTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getSort() : null;
   }

   CrmFieldParentTypeEnum(final Integer type, final String name, final Integer sort) {
      this.type = type;
      this.name = name;
      this.sort = sort;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }
}
