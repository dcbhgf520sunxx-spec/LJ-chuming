package com.hzchum.scim.system.core.api.common.enums;

public enum MenuRootEnum {
   CONFIG_MANAGEMENT(1L, "配置管理"),
   MES(2L, "建钢MES"),
   CONTRACT(3L, "合同管理"),
   USER_SETTING(4L, "人员管理"),
   WORKBENCH(137L, "工作台"),
   PRODUCTION_REPORT(177L, "生产报表"),
   THREE_D(398L, "3D模型"),
   THREE_D_APP_WORKBENCH(174L, "APP工作台-3D模型"),
   WMS(475L, "WMS"),
   WMS_CONFIG(471L, "WMS-配置管理"),
   WMS_APP_WORKBENCH(1054L, "APP工作台-物料"),
   BRIDGE(684L, "桥梁MES"),
   BRIDGE_CONFIG(764L, "桥梁-生产配置"),
   BRIDGE_APP_WORKBENCH(974L, "APP工作台-桥梁"),
   BRIDGE_APP_REPORT(976L, "APP生产报表-桥梁"),
   THICKNESS_COMPARISON_TABLE(1338L, "厚度对照表"),
   COMPARISON_COMPONENT_USAGE(1344L, "构件用量对比");

   private Long id;
   private String name;

   MenuRootEnum(Long value, String name) {
      this.id = value;
      this.name = name;
   }

   public Long getValue() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }
}
