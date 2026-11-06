package com.hzchum.scim.wms.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;

public enum TransferTypeEnum {
   PUBLIC_WARE(1, "移至公共库"),
   PROJECT_WARE(2, "移至项目库"),
   RETURN_PARTY_A(4, "归还甲方"),
   BORROW_RETURN(8, "借用归还"),
   DIRECT_RETURN_PUBLIC_WARE(16, "直退至公共库");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   TransferTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer type) {
      switch (type) {
         case 1:
            return PUBLIC_WARE.getName();
         case 2:
            return PROJECT_WARE.getName();
         case 4:
            return RETURN_PARTY_A.getName();
         case 8:
            return BORROW_RETURN.getName();
         case 16:
            return DIRECT_RETURN_PUBLIC_WARE.getName();
         default:
            throw new BusinessException("当前计量方式错误");
      }
   }
}
