package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MessageTemplateStatusEnum {
   IN_REVIEW(0, "审核中"),
   APPROVE(1, "审核通过"),
   AUDIT_FAILURE(2, "审核失败"),
   UNAUDITED(3, "未审核");

   private Integer type;
   private String name;

   MessageTemplateStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<MessageTemplateStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
