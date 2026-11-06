package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum RejectEnum {
   NO_REJECT(1, "没有退货"),
   UN_REVIEWED(2, "退货待审核"),
   PART_REJECT(4, "部分退货"),
   All_REJECT(8, "全部退货");

   private Integer type;
   private String name;

   RejectEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<RejectEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
