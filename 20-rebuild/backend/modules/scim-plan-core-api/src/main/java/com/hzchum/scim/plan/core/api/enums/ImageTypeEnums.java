package com.hzchum.scim.plan.core.api.enums;

public enum ImageTypeEnums {
   SVG(1, "svg"),
   JPG(2, "jpg"),
   PNG(4, "png"),
   PDF(8, "pdf"),
   TIFF(16, "tiff");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      if (type == null) {
         return null;
      }

      ImageTypeEnums[] values = values();

      for (ImageTypeEnums boardTypeEnum : values) {
         if (type.equals(boardTypeEnum.getType())) {
            return boardTypeEnum.getName();
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

   ImageTypeEnums(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
