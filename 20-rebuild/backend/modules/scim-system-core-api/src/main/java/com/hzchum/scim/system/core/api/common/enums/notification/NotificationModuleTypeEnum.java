package com.hzchum.scim.system.core.api.common.enums.notification;

public enum NotificationModuleTypeEnum {
   CREATE_CONTRACT(1, "创建合同", 1, "合同管理"),
   LOGISTICS_SETTING(2, "物流费设置", 1, "合同管理"),
   CREATE_DETAILED(4, "导入清单", 3, "计划管理"),
   DELETE_DETAILED(5, "删除清单", 3, "计划管理"),
   UPDATE_CONTRACT(6, "合同变更", 1, "合同管理"),
   DELIVERY_COMPLETED(8, "完工提示", 4, "MES"),
   PLAN_ENCOUNTER(9, "计划滞后-生产计划", 4, "MES"),
   STEEL_NVENTORY(13, "钢材库存", 4, "MES"),
   PROCESS_SLUGGISHNESS(14, "工序呆滞", 4, "MES"),
   SUBSCRIBE(15, "申购提醒", 8, "供应链"),
   PURCHASE(16, "采购提醒", 8, "供应链"),
   ABARBEITUNG(17, "整改提示", 4, "MES"),
   CREATE_MONOMER_AREA(19, "创建单体区域", 3, "计划管理"),
   QUALITY_INSPECTION(20, "质量检验", 4, "MES"),
   PROCESS_LAG(21, "工序滞后", 4, "MES"),
   CRM_SETTLEMENT_METHOD(50, "商务标分配负责人", 12, "CRM"),
   CRM_TYPE_OF_PERFORMANCE_BOND(51, "技术标分配负责人", 12, "CRM"),
   CRM_STRUCTURAL_DESIGN_TARGET(52, "结构设计标分配负责人", 12, "CRM"),
   CRM_DEEPENING_THE_DESIGN_STANDARD(53, "深化设计标分配负责人", 12, "CRM"),
   WMS_MATERIAL_OUTBOUND(54, "物料出库", 8, "供应链"),
   WMS_MATERIAL_PARTY_A_INBOUND(55, "物料甲供入库", 8, "供应链"),
   WMS_MATERIAL_SELF_PURCHASE_INBOUND(56, "物料自购入库", 8, "供应链"),
   SHR_UPDATE_PUSH(57, "SHR人员变更推送", 12, "人员管理");

   private Integer notificationType;
   private String notificationTypeName;
   private Integer operationalModuleType;
   private String operationalModuleTypeName;

   NotificationModuleTypeEnum(int notificationType, String notificationTypeName, int operationalModuleType, String operationalModuleTypeName) {
      this.operationalModuleType = operationalModuleType;
      this.operationalModuleTypeName = operationalModuleTypeName;
      this.notificationType = notificationType;
      this.notificationTypeName = notificationTypeName;
   }

   public static NotificationModuleTypeEnum getEnumByNotificationTypeAndOperationalModuleType(Integer notificationType, Integer operationalModuleType) {
      for (NotificationModuleTypeEnum notificationModuleTypeEnum : values()) {
         if (notificationModuleTypeEnum.getNotificationType().equals(notificationType)
            && notificationModuleTypeEnum.getOperationalModuleType().equals(operationalModuleType)) {
            return notificationModuleTypeEnum;
         }
      }

      return null;
   }

   public static NotificationModuleTypeEnum getOperationalModuleType(Integer operationalModuleType) {
      for (NotificationModuleTypeEnum notificationModuleTypeEnum : values()) {
         if (notificationModuleTypeEnum.getOperationalModuleType().equals(operationalModuleType)) {
            return notificationModuleTypeEnum;
         }
      }

      return null;
   }

   public static NotificationModuleTypeEnum getNotificationType(Integer notificationType) {
      for (NotificationModuleTypeEnum notificationModuleTypeEnum : values()) {
         if (notificationModuleTypeEnum.getNotificationType().equals(notificationType)) {
            return notificationModuleTypeEnum;
         }
      }

      return null;
   }

   public Integer getNotificationType() {
      return this.notificationType;
   }

   public String getNotificationTypeName() {
      return this.notificationTypeName;
   }

   public Integer getOperationalModuleType() {
      return this.operationalModuleType;
   }

   public String getOperationalModuleTypeName() {
      return this.operationalModuleTypeName;
   }
}
