package com.hzchum.scim.scm.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum SupplyTypeEnum {
   SELF(1, "自采"),
   PARTY_A(2, "甲供");

   private final Integer type;
   private final String name;

   SupplyTypeEnum(Integer type, String name) {
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
            return SELF.getName();
         case 2:
            return PARTY_A.getName();
         default:
            throw new BusinessException("当前货源类型不存在");
      }
   }

   public static boolean isExist(Integer type) {
      Optional<PurchaseEnum> optional = Arrays.stream(PurchaseEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
