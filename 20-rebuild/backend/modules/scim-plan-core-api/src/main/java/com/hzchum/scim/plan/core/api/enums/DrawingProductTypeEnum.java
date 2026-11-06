package com.hzchum.scim.plan.core.api.enums;

import com.google.common.base.Preconditions;

public enum DrawingProductTypeEnum {
   MACHINE_PART(1, "零件", "machine_part"),
   ARTIFACT(2, "构件", "artifact"),
   ASSEMBLE(16, "组立", "assemble"),
   ALL_PRODUCT(19, "未知类型", "all_product");

   private final Integer type;
   private final String name;
   private final String dir;

   public static Boolean isExist(Integer type) {
      Preconditions.checkArgument(type != null, "资料类型不能为空!");

      for (DrawingProductTypeEnum productTypeEnum : values()) {
         if (productTypeEnum.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public static String getDirByType(Integer type) {
      if (type == null) {
         return null;
      }

      for (DrawingProductTypeEnum drawingProductTypeEnum : values()) {
         if (drawingProductTypeEnum.getType().equals(type)) {
            return drawingProductTypeEnum.getDir();
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      if (type == null) {
         return null;
      }

      for (DrawingProductTypeEnum drawingProductTypeEnum : values()) {
         if (drawingProductTypeEnum.getType().equals(type)) {
            return drawingProductTypeEnum.getName();
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

   public String getDir() {
      return this.dir;
   }

   DrawingProductTypeEnum(final Integer type, final String name, final String dir) {
      this.type = type;
      this.name = name;
      this.dir = dir;
   }
}
