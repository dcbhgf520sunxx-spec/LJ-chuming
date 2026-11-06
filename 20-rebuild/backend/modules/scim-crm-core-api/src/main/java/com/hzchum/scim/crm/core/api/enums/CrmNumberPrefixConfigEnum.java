package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmNumberPrefixConfigEnum {
   ENTERPRISE_FILING(1, "企业备案"),
   SUPPLIER_FILING(2, "供应商备案"),
   BIDDING_PLATFORM_FILING(3, "招标平台备案"),
   GOVERNMENT_FILING(4, "政府备案"),
   PROJECT_INFORMATION_REGISTRATION(5, "项目信息登记");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmNumberPrefixConfigEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmNumberPrefixConfigEnum(final Integer type, final String name) {
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
