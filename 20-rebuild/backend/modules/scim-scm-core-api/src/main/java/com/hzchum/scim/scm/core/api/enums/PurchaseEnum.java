package com.hzchum.scim.scm.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum PurchaseEnum {
   MATERIAL(1, "原材料采购"),
   FINISHED_GOODS(2, "制成品采购");

   private final Integer type;
   private final String name;

   PurchaseEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getNameByType(Integer type) {
      switch (type) {
         case 1:
            return MATERIAL.getName();
         case 2:
            return FINISHED_GOODS.getName();
         default:
            throw new BusinessException("当前采购类型不存在");
      }
   }

   public static boolean isExist(Integer type) {
      Optional<PurchaseEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
