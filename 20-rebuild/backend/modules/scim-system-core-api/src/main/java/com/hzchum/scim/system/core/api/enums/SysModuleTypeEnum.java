package com.hzchum.scim.system.core.api.enums;

public enum SysModuleTypeEnum {
   WMS(1, "WMS"),
   SUPPLY_CHAIN(2, "供应链"),
   CONTRACT(3, "合同管理"),
   SHIP_MODULE(4, "发运管理"),
   PLAN_MODULE(5, "计划管理"),
   MES(6, "建钢MES"),
   BRIDGE_MES(7, "桥梁MES"),
   PROJECT(8, "项目管理"),
   BIM(9, "bim"),
   OPERATION(10, "运营分析"),
   ENCLOSURE_MES(11, "围护MES"),
   CRM(12, "CRM");

   private Integer type;
   private String name;

   public static boolean isExist(Integer type) {
      for (SysModuleTypeEnum sysModuleTypeEnum : values()) {
         if (sysModuleTypeEnum.getType().equals(type)) {
            return true;
         }
      }

      return false;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SysModuleTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
