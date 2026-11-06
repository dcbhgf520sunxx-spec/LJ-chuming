package com.hzchum.scim.plan.core.api.enums;

public enum LumpSumSystemEnum {
   OTHER(1, "其他"),
   NO_FACTORY_PROCESSING_NEED_CONTROL(2, "无需工厂加工，需管控"),
   NO_FACTORY_PROCESSING_NO_CONTROL(4, "无需工厂加工，无需管控 "),
   NEED_FACTORY_PROCESSING_NEED_CONTROL(8, "需工厂加工，需管控"),
   NEED_FACTORY_PROCESSING_NO_CONTROL(16, "需工厂加工，无需管控");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (LumpSumSystemEnum item : values()) {
         if (item.getType().equals(type)) {
            return item.getName();
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

   LumpSumSystemEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
