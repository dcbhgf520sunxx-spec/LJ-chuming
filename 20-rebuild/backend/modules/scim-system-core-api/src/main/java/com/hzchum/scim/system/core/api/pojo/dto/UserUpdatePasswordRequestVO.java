package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;

public class UserUpdatePasswordRequestVO {
   @NotBlank(message = "新密码不能为空")
   private String newPwd;
   @NotBlank(message = "旧密码不能为空")
   private String oldPwd;

   public String getNewPwd() {
      return this.newPwd;
   }

   public String getOldPwd() {
      return this.oldPwd;
   }

   public void setNewPwd(final String newPwd) {
      this.newPwd = newPwd;
   }

   public void setOldPwd(final String oldPwd) {
      this.oldPwd = oldPwd;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserUpdatePasswordRequestVO)) {
         return false;
      } else {
         UserUpdatePasswordRequestVO other = (UserUpdatePasswordRequestVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$newPwd = this.getNewPwd();
            Object other$newPwd = other.getNewPwd();
            if (this$newPwd == null ? other$newPwd == null : this$newPwd.equals(other$newPwd)) {
               Object this$oldPwd = this.getOldPwd();
               Object other$oldPwd = other.getOldPwd();
               return this$oldPwd == null ? other$oldPwd == null : this$oldPwd.equals(other$oldPwd);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserUpdatePasswordRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $newPwd = this.getNewPwd();
      result = result * 59 + ($newPwd == null ? 43 : $newPwd.hashCode());
      Object $oldPwd = this.getOldPwd();
      return result * 59 + ($oldPwd == null ? 43 : $oldPwd.hashCode());
   }

   @Override
   public String toString() {
      return "UserUpdatePasswordRequestVO(newPwd=" + this.getNewPwd() + ", oldPwd=" + this.getOldPwd() + ")";
   }
}
