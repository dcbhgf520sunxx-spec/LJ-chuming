package com.hzchum.scim.bid.core.api.enums;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;

public enum FilesEnum {
   PRIVATE(100, "supplier", true),
   PUBLIC(200, "supplier", false),
   PUBLIC_OFFER(201, "offer", false);

   private final Integer type;
   private final String module;
   private final Boolean isPrivate;

   FilesEnum(int type, String module, Boolean isPrivate) {
      this.type = type;
      this.module = module;
      this.isPrivate = isPrivate;
   }

   public static FilesEnum getByType(Integer type) {
      for (FilesEnum value : values()) {
         if (value.getType().equals(type)) {
            return value;
         }
      }

      throw new BusinessException(ResultCodeEnum.FILE_TYPE_ERROR);
   }

   public static boolean getIsPrivateByType(Integer type) {
      return getByType(type).getIsPrivate();
   }

   public Integer getType() {
      return this.type;
   }

   public String getModule() {
      return this.module;
   }

   public Boolean getIsPrivate() {
      return this.isPrivate;
   }
}
