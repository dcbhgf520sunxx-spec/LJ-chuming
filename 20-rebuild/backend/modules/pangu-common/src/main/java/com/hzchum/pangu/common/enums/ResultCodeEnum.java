package com.hzchum.pangu.common.enums;

import com.hzchum.pangu.common.base.IResultCode;
import java.io.Serializable;

public enum ResultCodeEnum implements IResultCode, Serializable {
   SUCCESS(20000L, "成功"),
   ERROR(40000L, "失败"),
   AUTHENTICATION_FAIL(40001L, "未传入token信息"),
   TOKEN_EXPIRED(40002L, "token过期，请重新登录"),
   TOKEN_PARSE_FAILED(40003L, "token解析失败"),
   TOKEN_FORMAT_ERROR(40004L, "token格式不正确"),
   TOKEN_DIRTY(40005L, "token已失效，请重新登录"),
   PASSWORD_ERROR(40101L, "密码解析错误"),
   ACCOUNT_ERROR(40102L, "账号密码错误"),
   ACCOUNT_DISABLED_ERROR(40103L, "该账号已被禁用"),
   NO_PERMISSION_ACCESS(40103L, "该账号没有权限访问"),
   PARAMETER_MISSING(40205L, "参数缺失"),
   PARAMETER_EXPIRE(40206L, "参数过期"),
   VERIFY_CODE_EXPIRE(40301L, "验证码已过期"),
   VERIFY_CODE_ERROR(40302L, "验证码不正确"),
   SMS_REQUEST_FAIL(40401L, "短信调用失败"),
   SMS_ERROR(40403L, "短信错误"),
   FILE_TYPE_ERROR(40501L, "文件类型错误"),
   INTERNAL_SERVER_ERROR(50000L, "服务器内部错误"),
   INTERFACE_ERROR(500002L, "接口调用异常"),
   ABNORMAL_DATA_DUPLICATION(500003L, "数据重复提交,请刷新"),
   SERVER_EXPIRE_ERROR(500004L, "服务已暂停"),
   OUTBOUND_ERROR(500005L, "出库提交错误");

   private Long code;
   private String message;

   @Override
   public Long getCode() {
      return this.code;
   }

   @Override
   public String getMessage() {
      return this.message;
   }

   public static ResultCodeEnum getByCode(Long code) {
      for (ResultCodeEnum codeEnum : values()) {
         if (codeEnum.getCode().equals(code)) {
            return codeEnum;
         }
      }

      return null;
   }

   ResultCodeEnum(final Long code, final String message) {
      this.code = code;
      this.message = message;
   }
}
