package com.hzchum.scim.system.core.api.common.enums;

public enum ResultCodeEnum {
   SUCCESS(20000),
   FAIL(40000),
   UNAUTHORIZED(40001),
   FORBIDDEN(40003),
   NOT_FOUND(40004),
   INTERNAL_SERVER_ERROR(50000);

   private int code;

   ResultCodeEnum(int code) {
      this.code = code;
   }

   public int getCode() {
      return this.code;
   }
}
