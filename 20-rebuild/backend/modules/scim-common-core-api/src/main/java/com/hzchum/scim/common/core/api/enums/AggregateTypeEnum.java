package com.hzchum.scim.common.core.api.enums;

public enum AggregateTypeEnum {
   FOR_SALE_CV(1, "对外出售-累计差异");

   private Integer type;
   private String name;

   AggregateTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
