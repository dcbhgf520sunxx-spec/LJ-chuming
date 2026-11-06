package com.hzchum.scim.scm.core.api.enums;

public enum SupplierConfigTypeEnum {
   EVALUATION_CATEGORY(1, "评价分类配置"),
   SCORE_RATING(2, "分数评级配置"),
   QUALIFICATION(3, "资质配置"),
   REVIEW_TEMPLATE(4, "评审模板配置");

   private final Integer type;
   private final String name;

   SupplierConfigTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static SupplierConfigTypeEnum getByType(Integer type) {
      if (type == null) {
         return null;
      }

      for (SupplierConfigTypeEnum e : values()) {
         if (e.getType().equals(type)) {
            return e;
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      SupplierConfigTypeEnum e = getByType(type);
      return e == null ? null : e.getName();
   }
}
