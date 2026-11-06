package com.hzchum.scim.system.core.api.common.enums;

public enum ModuleEnum {
   LOGIN("登录"),
   PROJECT("合同管理"),
   PLAN("计划管理"),
   TECHNOLOGY("技术管理"),
   TECHNOLOGY_DATA("技术资料管理"),
   BUSINESS("商务管理"),
   TASK_ASSIGNMENT("任务分配"),
   WAREHOUSE_HANDLE("入库办理"),
   RETURN_WAREHOUSE_HANDLE("退还库办理"),
   RETURN_WAREHOUSE_REVIEW("出入库审核"),
   ORDER("采购订单"),
   PURCHASE_ORDER("备料定制"),
   SUPPLIER("供应商管理"),
   BIM("BIM管理"),
   CONFIG("配置管理");

   private final String name;

   ModuleEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
