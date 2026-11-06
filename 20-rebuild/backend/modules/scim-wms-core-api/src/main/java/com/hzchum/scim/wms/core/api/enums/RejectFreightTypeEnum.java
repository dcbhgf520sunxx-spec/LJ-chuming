package com.hzchum.scim.wms.core.api.enums;

public enum RejectFreightTypeEnum {
   RETAIN_FREIGHT(1, "保留运费"),
   REJECT_FREIGHT(2, "退运费");

   private final Integer type;
   private final String name;

   RejectFreightTypeEnum(Integer type, String name) {
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
