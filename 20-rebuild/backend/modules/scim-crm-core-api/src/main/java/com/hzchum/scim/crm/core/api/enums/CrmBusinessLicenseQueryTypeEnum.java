package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmBusinessLicenseQueryTypeEnum {
   NAME(1, "名称"),
   CREDIT_NO(2, "信用代码");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmBusinessLicenseQueryTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(CrmBusinessLicenseQueryTypeEnum::getName).orElse(null);
   }

   CrmBusinessLicenseQueryTypeEnum(final Integer type, final String name) {
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
