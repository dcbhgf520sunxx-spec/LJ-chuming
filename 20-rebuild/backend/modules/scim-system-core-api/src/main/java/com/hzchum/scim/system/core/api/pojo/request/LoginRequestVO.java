package com.hzchum.scim.system.core.api.pojo.request;

import javax.validation.constraints.NotBlank;

public class LoginRequestVO {
   @NotBlank(message = "用户名不能为空")
   private String username;
   @NotBlank(message = "登录密码不能为空")
   private String password;

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setPassword(final String password) {
      this.password = password;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof LoginRequestVO)) {
         return false;
      } else {
         LoginRequestVO other = (LoginRequestVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$username = this.getUsername();
            Object other$username = other.getUsername();
            if (this$username == null ? other$username == null : this$username.equals(other$username)) {
               Object this$password = this.getPassword();
               Object other$password = other.getPassword();
               return this$password == null ? other$password == null : this$password.equals(other$password);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LoginRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $password = this.getPassword();
      return result * 59 + ($password == null ? 43 : $password.hashCode());
   }

   @Override
   public String toString() {
      return "LoginRequestVO(username=" + this.getUsername() + ", password=" + this.getPassword() + ")";
   }
}
