package com.hzchum.scim.system.core.api.pojo.dto;

public class UserResetPasswordRequestVO {
   private Long userId;

   public Long getUserId() {
      return this.userId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserResetPasswordRequestVO)) {
         return false;
      }

      UserResetPasswordRequestVO other = (UserResetPasswordRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserResetPasswordRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   @Override
   public String toString() {
      return "UserResetPasswordRequestVO(userId=" + this.getUserId() + ")";
   }
}
