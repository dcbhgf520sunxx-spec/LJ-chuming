package com.hzchum.scim.system.core.api.pojo.request;

import javax.validation.constraints.NotBlank;

public class WeChatBindingRequestVO {
   @NotBlank(message = "key不能为空！")
   private String key;
   @NotBlank(message = "电话不能为空！")
   private String phone;
   @NotBlank(message = "验证码不能为空！")
   private String code;

   public String getKey() {
      return this.key;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getCode() {
      return this.code;
   }

   public void setKey(final String key) {
      this.key = key;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeChatBindingRequestVO)) {
         return false;
      }

      WeChatBindingRequestVO other = (WeChatBindingRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$key = this.getKey();
      Object other$key = other.getKey();
      if (this$key == null ? other$key == null : this$key.equals(other$key)) {
         Object this$phone = this.getPhone();
         Object other$phone = other.getPhone();
         if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
            Object this$code = this.getCode();
            Object other$code = other.getCode();
            return this$code == null ? other$code == null : this$code.equals(other$code);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WeChatBindingRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $key = this.getKey();
      result = result * 59 + ($key == null ? 43 : $key.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "WeChatBindingRequestVO(key=" + this.getKey() + ", phone=" + this.getPhone() + ", code=" + this.getCode() + ")";
   }
}
