package com.hzchum.scim.plan.core.api.enums;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;

public enum TechDataTypeEnum {
   DEEPEN(1, "深化图纸", "deepen_drawing"),
   NC_DRAWING(2, "数控图纸", "machine_part_drawing"),
   CHANGE_FILE(4, "变更文件", "change_file"),
   BLUEPRINT(8, "施工蓝图", "blueprint"),
   XML_FILE(16, "XML文件", "xml_file"),
   Technical_Instructions(32, "工艺文件", "technical_instructions");

   private final Integer type;
   private final String name;
   private final String dir;

   public static Boolean isExist(Integer type) {
      Preconditions.checkArgument(type != null, "资料类型不能为空!");

      for (TechDataTypeEnum dataTypeEnum : values()) {
         if (dataTypeEnum.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public static String getNameByType(Integer type) {
      for (TechDataTypeEnum drawingTypeEnum : values()) {
         if (drawingTypeEnum.getType().equals(type)) {
            return drawingTypeEnum.getName();
         }
      }

      throw new BusinessException("资料类型传入错误!");
   }

   public static String getDirByType(Integer type) {
      for (TechDataTypeEnum drawingTypeEnum : values()) {
         if (drawingTypeEnum.getType().equals(type)) {
            return drawingTypeEnum.getDir();
         }
      }

      throw new BusinessException("资料类型有误!");
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

   TechDataTypeEnum(final Integer type, final String name, final String dir) {
      this.type = type;
      this.name = name;
      this.dir = dir;
   }
}
