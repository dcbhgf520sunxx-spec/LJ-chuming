package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmInformationValidityPeriodConfigEnum {
   INFORMATION_VALIDITY_PERIOD(1, "信息有效期配置"),
   INDUSTRY_CONFIGURATION(2, "CA锁有效期提醒"),
   NUMBER_OF_PROJECT_QUOTA_ALLOCATION(3, "项目名额数量配置");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmInformationValidityPeriodConfigEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmInformationValidityPeriodConfigEnum(final Integer type, final String name) {
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
