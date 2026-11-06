package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;

public enum ManufacturesGroupingEnum {
   MONOMER(1, "单体"),
   AREA(2, "区域"),
   SN(4, "构件编号"),
   NAME(8, "构件名称"),
   MATERIAL(16, "材质"),
   SPEC(32, "规格");

   private final Integer type;
   private final String name;

   ManufacturesGroupingEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getName(Integer type) {
      String v = "";

      for (ManufacturesGroupingEnum value : values()) {
         if (value.getType().equals(type)) {
            v = value.getName();
         }
      }

      return v;
   }

   public static void main(String[] args) {
      ManufacturesGroupingEnum[] values = values();
      System.out.println(Arrays.asList(values));
   }
}
