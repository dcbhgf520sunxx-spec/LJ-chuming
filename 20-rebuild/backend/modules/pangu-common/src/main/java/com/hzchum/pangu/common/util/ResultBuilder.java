package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.base.IResultCode;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ResultVO;

public class ResultBuilder {
   public static <T> ResultVO<T> success(T data) {
      return buildResult(data, ResultCodeEnum.SUCCESS.getMessage(), ResultCodeEnum.SUCCESS.getCode());
   }

   public static <T> ResultVO<T> success(T data, String message) {
      return buildResult(data, message, ResultCodeEnum.SUCCESS.getCode());
   }

   public static <T> ResultVO<T> success(T data, IResultCode resultCode) {
      return buildResult(data, resultCode.getMessage(), resultCode.getCode());
   }

   public static <T> ResultVO<T> success(T data, String message, IResultCode resultCode) {
      return buildResult(data, message, resultCode.getCode());
   }

   public static <T> ResultVO<T> failed() {
      return buildResult(null, ResultCodeEnum.ERROR.getMessage(), ResultCodeEnum.ERROR.getCode());
   }

   public static <T> ResultVO<T> failed(String message) {
      return buildResult(null, message, ResultCodeEnum.ERROR.getCode());
   }

   public static <T> ResultVO<T> failed(IResultCode resultCode) {
      return buildResult(null, resultCode.getMessage(), resultCode.getCode());
   }

   public static <T> ResultVO<T> failed(String message, IResultCode resultCode) {
      return buildResult(null, message, resultCode.getCode());
   }

   public static <T> ResultVO<T> failed(T data, String message, IResultCode resultCode) {
      return buildResult(data, message, resultCode.getCode());
   }

   public static <T> ResultVO<T> buildResult(T data, String message, Long code) {
      return ResultVO.<T>builder().code(code).message(message).data(data).build();
   }
}
