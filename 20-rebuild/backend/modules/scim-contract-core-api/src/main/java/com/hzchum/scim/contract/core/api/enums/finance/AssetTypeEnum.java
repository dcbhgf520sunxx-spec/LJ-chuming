package com.hzchum.scim.contract.core.api.enums.finance;

public enum AssetTypeEnum {
   COMPANY_INJECTION(1, "公司主体"),
   MANAGER_INJECTION(2, "项目经理");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AssetTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
