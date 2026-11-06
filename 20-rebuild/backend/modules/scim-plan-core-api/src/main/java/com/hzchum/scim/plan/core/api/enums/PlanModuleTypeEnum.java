package com.hzchum.scim.plan.core.api.enums;

public enum PlanModuleTypeEnum {
   DRAWING(1, "图纸文件管理"),
   NUMERICAL_CONTROL(2, "数控文件管理"),
   ALTER(4, "变更文件"),
   CONSTRUCTION_BLUEPRINT(8, "施工蓝图"),
   XML(16, "XML文件管理"),
   TECHNOLOGY(32, "工艺文件"),
   MODEL(64, "模型文件管理");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      PlanModuleTypeEnum[] values = values();

      for (PlanModuleTypeEnum value : values) {
         if (value.getType().equals(type)) {
            return value.getName();
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

   PlanModuleTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
