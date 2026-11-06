package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OutboundStatusEnum {
   UN_REVIEWED(1, "待审核"),
   REVIEWED(2, "审核通过"),
   RETURNED(4, "审核退回"),
   CANCEL(8, "撤销"),
   AUDITING(16, "审核中");

   private Integer type;
   private String name;

   OutboundStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<OutboundStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
