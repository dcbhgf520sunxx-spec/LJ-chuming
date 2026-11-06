package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserResetPhonePasswordRequestVO {
   @NotBlank(message = "账户手机号不能为空")
   @Pattern(regexp = "((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", message = "手机号格式错误")
   private String phone;
   @NotBlank(message = "新密码不能为空")
   private String password;
   @NotBlank(message = "验证码不能为空")
   private String verifyCode;

   public String getPhone() {
      return this.phone;
   }

   public String getPassword() {
      return this.password;
   }

   public String getVerifyCode() {
      return this.verifyCode;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setPassword(final String password) {
      this.password = password;
   }

   public void setVerifyCode(final String verifyCode) {
      this.verifyCode = verifyCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserResetPhonePasswordRequestVO)) {
         return false;
      }

      UserResetPhonePasswordRequestVO other = (UserResetPhonePasswordRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$phone = this.getPhone();
      Object other$phone = other.getPhone();
      if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
         Object this$password = this.getPassword();
         Object other$password = other.getPassword();
         if (this$password == null ? other$password == null : this$password.equals(other$password)) {
            Object this$verifyCode = this.getVerifyCode();
            Object other$verifyCode = other.getVerifyCode();
            return this$verifyCode == null ? other$verifyCode == null : this$verifyCode.equals(other$verifyCode);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserResetPhonePasswordRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $password = this.getPassword();
      result = result * 59 + ($password == null ? 43 : $password.hashCode());
      Object $verifyCode = this.getVerifyCode();
      return result * 59 + ($verifyCode == null ? 43 : $verifyCode.hashCode());
   }

   @Override
   public String toString() {
      return "UserResetPhonePasswordRequestVO(phone=" + this.getPhone() + ", password=" + this.getPassword() + ", verifyCode=" + this.getVerifyCode() + ")";
   }
}
