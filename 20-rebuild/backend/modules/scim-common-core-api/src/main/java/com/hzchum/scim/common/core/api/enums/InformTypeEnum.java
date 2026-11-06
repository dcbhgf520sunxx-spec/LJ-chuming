package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;

public enum InformTypeEnum {
   APPROVE_NOTICE(1, "审批通知");

   private Integer type;
   private String name;

   InformTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static InformTypeEnum selectType(Integer type) {
      for (InformTypeEnum value : values()) {
         if (value.type.equals(type)) {
            return value;
         }
      }

      Preconditions.checkArgument(false, "枚举类未查询到!!");
      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
