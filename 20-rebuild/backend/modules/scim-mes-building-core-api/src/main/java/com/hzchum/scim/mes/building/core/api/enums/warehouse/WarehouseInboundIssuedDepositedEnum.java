package com.hzchum.scim.mes.building.core.api.enums.warehouse;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum WarehouseInboundIssuedDepositedEnum {
   BEGINNING(1, "期初"),
   INBOUND(2, "入库"),
   OUTBOUND(3, "出库"),
   STOCK(4, "期末"),
   PACKAGE(5, "打包(未装车)");

   private final int type;
   private String name;

   WarehouseInboundIssuedDepositedEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<WarehouseInboundIssuedDepositedEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (WarehouseInboundIssuedDepositedEnum statusTypeEnum : values()) {
         if (type.equals(statusTypeEnum.getType())) {
            return statusTypeEnum.getName();
         }
      }

      throw new BusinessException("入发存类型传入错误!");
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
