package com.hzchum.scim.project.core.api.enums;

public enum ProductTypeUpEnum {
   MACHINE_PART(1, "零件"),
   ARTIFACT(2, "构件"),
   ENCLOSURE(4, "围护"),
   AUXILIARY_MATERIAL(8, "配套件"),
   ASSEMBLE(16, "部件(组立)"),
   RAW_MATERIAL(32, "其他(原材料)");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (ProductTypeUpEnum value : values()) {
         if (Integer.valueOf(17).equals(type)) {
            return "直发件";
         }

         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProductTypeUpEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
