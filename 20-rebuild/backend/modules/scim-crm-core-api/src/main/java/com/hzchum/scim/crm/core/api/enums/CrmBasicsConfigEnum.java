package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmBasicsConfigEnum {
   UNIT_PROPERTY_ALLOCATION(1, "单位性质配置"),
   UNIT_CLASS_CONFIGURATION(2, "单位类别配置"),
   INDUSTRY_CONFIGURATION(3, "所属行业配置"),
   UNIT_REPUTATION_ALLOCATION(4, "单位信誉配置");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmBasicsConfigEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmBasicsConfigEnum(final Integer type, final String name) {
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
