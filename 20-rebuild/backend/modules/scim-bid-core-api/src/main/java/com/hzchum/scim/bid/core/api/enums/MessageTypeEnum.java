package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MessageTypeEnum {
   VERIFICATION_CODE(0, "验证码"),
   SHORT_NOTE(1, "短信通知"),
   PROMOTION_SMS(2, "推广短信"),
   OTHER_MESSAGES(3, "国际/港澳台消息");

   private Integer type;
   private String name;

   MessageTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<MessageTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
