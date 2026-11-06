package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserResetEmailPasswordRequestVO {
   @NotBlank(message = "账户邮箱不能为空")
   @Email(message = "用户的邮箱地址格式错误")
   private String email;
   @NotBlank(message = "新密码不能为空")
   private String password;
   @NotBlank(message = "验证码不能为空")
   private String verifyCode;

   public String getEmail() {
      return this.email;
   }

   public String getPassword() {
      return this.password;
   }

   public String getVerifyCode() {
      return this.verifyCode;
   }

   public void setEmail(final String email) {
      this.email = email;
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

      if (!(o instanceof UserResetEmailPasswordRequestVO)) {
         return false;
      }

      UserResetEmailPasswordRequestVO other = (UserResetEmailPasswordRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$email = this.getEmail();
      Object other$email = other.getEmail();
      if (this$email == null ? other$email == null : this$email.equals(other$email)) {
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
      return other instanceof UserResetEmailPasswordRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $password = this.getPassword();
      result = result * 59 + ($password == null ? 43 : $password.hashCode());
      Object $verifyCode = this.getVerifyCode();
      return result * 59 + ($verifyCode == null ? 43 : $verifyCode.hashCode());
   }

   @Override
   public String toString() {
      return "UserResetEmailPasswordRequestVO(email=" + this.getEmail() + ", password=" + this.getPassword() + ", verifyCode=" + this.getVerifyCode() + ")";
   }
}
