package com.hzchum.scim.plan.core.api.enums;

import com.google.common.base.Preconditions;

public enum BridgeDrawingProductTypeEnum {
   BOX(1, "分段(箱体)", "box"),
   ELEMENT(2, "单元件", "element"),
   MACHINE_PART(4, "零件", "machine_part");

   private final Integer type;
   private final String name;
   private final String dir;

   public static Boolean isExist(Integer type) {
      Preconditions.checkArgument(type != null, "资料类型不能为空!");

      for (BridgeDrawingProductTypeEnum productTypeEnum : values()) {
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

      for (BridgeDrawingProductTypeEnum drawingProductTypeEnum : values()) {
         if (drawingProductTypeEnum.getType().equals(type)) {
            return drawingProductTypeEnum.getDir();
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

   BridgeDrawingProductTypeEnum(final Integer type, final String name, final String dir) {
      this.type = type;
      this.name = name;
      this.dir = dir;
   }
}
