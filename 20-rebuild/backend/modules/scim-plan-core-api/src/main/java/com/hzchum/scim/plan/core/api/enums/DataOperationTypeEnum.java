package com.hzchum.scim.plan.core.api.enums;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;

public enum DataOperationTypeEnum {
   DATA_IMPORT(1, "导入"),
   DATA_DELETE(2, "删除"),
   DATA_REPLACE(4, "替换"),
   DATA_DOWNLOAD(8, "下载");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Preconditions.checkArgument(type != null, "操作类型为空!");

      for (DataOperationTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      throw new BusinessException("操作类型错误!");
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   DataOperationTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
