package com.hzchum.scim.plan.core.api.enums;

public enum PlanFileOverlayEnum {
   DRAWING_NUMERICAL_CONTROL_XML(1, "图纸，数控，XML覆盖导入"),
   ALTER_CONSTRUCTION_BLUEPRINT(2, "变更，施工蓝图文件替换接口");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      PlanFileOverlayEnum[] values = values();

      for (PlanFileOverlayEnum value : values) {
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

   PlanFileOverlayEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
