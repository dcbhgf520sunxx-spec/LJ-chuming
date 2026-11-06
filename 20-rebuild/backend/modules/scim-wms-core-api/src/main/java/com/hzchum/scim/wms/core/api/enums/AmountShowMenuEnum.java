package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AmountShowMenuEnum {
   INBOUND_DETAILS(1, "入库明细"),
   OUTBOUND_DETAILS(2, "出库明细"),
   TRANSFER_DETAILS(3, "调拨明细"),
   RETURN_DETAILS(4, "退库明细"),
   REJECTED_DETAILS(5, "退货明细"),
   MOVE_WAREHOUSE_DETAILS(6, "移库明细"),
   RECEIVING_DISPATCHING_STORING(7, "收发存");

   private Integer type;
   private String name;

   AmountShowMenuEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<RejectEnum> optional = Arrays.stream(RejectEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getName(Integer type) {
      String v = "";

      for (AmountShowMenuEnum value : values()) {
         if (value.getType().equals(type)) {
            v = value.getName();
         }
      }

      return v;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
