package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmPageManagementConfigEnum {
   ENTERPRISE_RECORD_PAGE_MANAGEMENT(1, "企业备案页面管理"),
   GOVERNMENT_RECORD_PAGE_MANAGEMENT(2, "政府备案页面管理"),
   SUPPLIER_WAREHOUSING_RECORD_PAGE_MANAGEMENT(3, "供应商入库备案页面管理"),
   PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT(4, "平台注册备案页面管理"),
   PROJECT_INFORMATION_REGISTRATION_PAGE_MANAGEMENT(5, "项目信息登记页面管理"),
   PROJECT_TRACKING_PAGE_MANAGEMENT(6, "项目跟踪页面管理"),
   PREQUALIFICATION_PAGE_MANAGEMENT(7, "资格预审页面管理"),
   BID_APPLICATION_PAGE_MANAGEMENT(8, "投标申请页面管理"),
   ABANDON_PROJECT_TRACKING_PAGE_MANAGEMENT(9, "放弃跟踪页面管理");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmPageManagementConfigEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmPageManagementConfigEnum(final Integer type, final String name) {
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
