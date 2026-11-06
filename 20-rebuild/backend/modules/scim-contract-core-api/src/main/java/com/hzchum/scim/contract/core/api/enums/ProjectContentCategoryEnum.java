package com.hzchum.scim.contract.core.api.enums;

public enum ProjectContentCategoryEnum {
   STRUCTURE(2, "结构"),
   ENCLOSURE(4, "围护"),
   AUXILIARY(8, "配套件"),
   BODY_PARTS(16, "箱体件");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (ProjectContentCategoryEnum contentCategoryEnum : values()) {
         if (contentCategoryEnum.getType().equals(type)) {
            return contentCategoryEnum.getName();
         }
      }

      return null;
   }

   public static Integer getTypeByItemizedType(Integer type) {
      switch (type) {
         case 1:
            return STRUCTURE.getType();
         case 8:
            return ENCLOSURE.getType();
         case 64:
            return AUXILIARY.getType();
         default:
            return null;
      }
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectContentCategoryEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
