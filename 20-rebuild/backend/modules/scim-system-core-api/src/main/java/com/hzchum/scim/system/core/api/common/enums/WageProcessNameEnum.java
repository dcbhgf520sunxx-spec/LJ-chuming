package com.hzchum.scim.system.core.api.common.enums;

public enum WageProcessNameEnum {
   LAYING_OFF(1, "下料"),
   DRILL_HOLE(2, "钻孔"),
   GROUP_WELDING(3, "组焊"),
   ASSEMBLING_WELDING(4, "装焊"),
   COATING(5, "涂装"),
   BOLT_SLEEVE(6, "栓钉套筒"),
   OTHER_APPORTIONMENT(7, "其他分摊");

   private final Integer type;
   private final String name;

   public static WageProcessNameEnum getEnumByType(Integer type) {
      for (WageProcessNameEnum e : values()) {
         if (e.getType().equals(type)) {
            return e;
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      for (WageProcessNameEnum e : values()) {
         if (e.getType().equals(type)) {
            return e.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (WageProcessNameEnum e : values()) {
         if (e.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WageProcessNameEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
