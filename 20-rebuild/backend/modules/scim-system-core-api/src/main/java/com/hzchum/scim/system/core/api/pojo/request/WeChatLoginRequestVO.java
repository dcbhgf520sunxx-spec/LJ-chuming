package com.hzchum.scim.system.core.api.pojo.request;

import javax.validation.constraints.NotBlank;

public class WeChatLoginRequestVO {
   @NotBlank(message = "数据有误")
   private String code;

   public String getCode() {
      return this.code;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeChatLoginRequestVO)) {
         return false;
      }

      WeChatLoginRequestVO other = (WeChatLoginRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$code = this.getCode();
      Object other$code = other.getCode();
      return this$code == null ? other$code == null : this$code.equals(other$code);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WeChatLoginRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "WeChatLoginRequestVO(code=" + this.getCode() + ")";
   }
}
