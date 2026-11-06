package com.hzchum.scim.plan.core.api.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CAPP产品更新类型枚举")
public enum CappProductUpdateTypeEnum {
   NEW(1, "新增"),
   UPDATE(2, "更新"),
   UNBIND(3, "解绑");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CappProductUpdateTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
