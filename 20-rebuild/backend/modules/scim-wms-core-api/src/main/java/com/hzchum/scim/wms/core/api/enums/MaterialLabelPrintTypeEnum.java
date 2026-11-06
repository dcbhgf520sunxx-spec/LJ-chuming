package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MaterialLabelPrintTypeEnum {
   INBOUND(1, "入库"),
   OUTBOUND(2, "半出"),
   TRANSFER(4, "调拨"),
   RETURN(8, "退库"),
   CONVERT(16, "转换"),
   BORROW(32, "借用"),
   MOVE_WAREHOUSE(50, "移库单"),
   SURPLUS(64, "盘盈");

   private Integer type;
   private String name;

   MaterialLabelPrintTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<RejectEnum> optional = Arrays.stream(RejectEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
