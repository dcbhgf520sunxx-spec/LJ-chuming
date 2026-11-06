package com.hzchum.scim.contract.core.api.enums;

public enum ContractInfoSourceEnum {
   SALESMAN_WITH_PUBLIC(0, "销售员信息-项目经理配合-公私合营"),
   SALESMAN_WITH_MANAGER(1, "销售员信息-项目经理配合"),
   MANAGER_WITH_SALESMAN(2, "项目经理信息-销售员配合"),
   SALESMAN(3, "销售员信息-公司自营"),
   NEW_RECRUITED_PROJECT_MANAGER(4, "新引进项目经理"),
   COMPANY_LEADERSHIP_INFORMATION(5, "公司领导信息"),
   PROJECT_DEPARTMENT_INFORMATION(6, "项目部信息"),
   SALES_DEPARTMENT_EMPLOYEE_INFORMATION(7, "员工提供信息-销售部"),
   HISTORICAL_PROJECT_IMPORT(8, "历史项目导入用");

   private Integer type;
   private String name;

   ContractInfoSourceEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer infoSource) {
      for (ContractInfoSourceEnum ci : values()) {
         if (ci.getType().equals(infoSource)) {
            return ci.name;
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
