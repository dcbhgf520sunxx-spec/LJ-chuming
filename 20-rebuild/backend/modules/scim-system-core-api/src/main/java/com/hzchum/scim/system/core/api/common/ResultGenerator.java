package com.hzchum.scim.system.core.api.common;

import com.hzchum.scim.system.core.api.common.enums.ResultCodeEnum;

public class ResultGenerator {
   public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

   public static <T> Result<T> genSuccessResult() {
      return new Result<T>().setCode(ResultCodeEnum.SUCCESS).setMessage("操作成功");
   }

   public static <T> Result<T> genSuccessResult(T data) {
      return new Result<T>().setCode(ResultCodeEnum.SUCCESS).setMessage("操作成功").setData(data);
   }

   public static <T> Result<T> genFailResult(String message) {
      return new Result<T>().setCode(ResultCodeEnum.FAIL).setMessage(message);
   }

   public static <T> Result<T> genFailResult(ResultCodeEnum resultCodeEnum, String message) {
      return new Result<T>().setCode(resultCodeEnum.getCode()).setMessage(message);
   }

   private ResultGenerator() {
   }
}
