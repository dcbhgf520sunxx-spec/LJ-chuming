package com.hzchum.scim.system.core.api.common;

import com.alibaba.fastjson.JSON;
import com.hzchum.scim.system.core.api.common.enums.ResultCodeEnum;

public class Result<T> {
   private int code;
   private String message;
   private T data;

   public Result<T> setCode(ResultCodeEnum resultCodeEnum) {
      this.code = resultCodeEnum.getCode();
      return this;
   }

   public int getCode() {
      return this.code;
   }

   public Result<T> setCode(int code) {
      this.code = code;
      return this;
   }

   public String getMessage() {
      return this.message;
   }

   public Result<T> setMessage(String message) {
      this.message = message;
      return this;
   }

   public T getData() {
      return this.data;
   }

   public Result<T> setData(T data) {
      this.data = data;
      return this;
   }

   @Override
   public String toString() {
      return JSON.toJSONString(this);
   }
}
