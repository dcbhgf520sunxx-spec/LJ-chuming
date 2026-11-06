package com.hzchum.scim.scm.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum PurchaseOrderModeEnum {
   FUTURE(1, "期货订单"),
   SPOT(2, "现货订单"),
   ARRIVAL(4, "到货订单");

   private final Integer type;
   private final String name;

   PurchaseOrderModeEnum(Integer type, String name) {
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
            return FUTURE.getName();
         case 2:
            return SPOT.getName();
         case 3:
         default:
            throw new BusinessException("当前付款方式不存在");
         case 4:
            return ARRIVAL.getName();
      }
   }

   public static boolean isExist(Integer type) {
      Optional<PurchaseOrderModeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
