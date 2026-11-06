package com.hzchum.scim.common.core.api.pojo.common;

public class ApproveUserInfo {
   private Long userId;
   private String ddUserId;

   public Long getUserId() {
      return this.userId;
   }

   public String getDdUserId() {
      return this.ddUserId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setDdUserId(final String ddUserId) {
      this.ddUserId = ddUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ApproveUserInfo)) {
         return false;
      } else {
         ApproveUserInfo other = (ApproveUserInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$ddUserId = this.getDdUserId();
               Object other$ddUserId = other.getDdUserId();
               return this$ddUserId == null ? other$ddUserId == null : this$ddUserId.equals(other$ddUserId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApproveUserInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $ddUserId = this.getDdUserId();
      return result * 59 + ($ddUserId == null ? 43 : $ddUserId.hashCode());
   }

   @Override
   public String toString() {
      return "ApproveUserInfo(userId=" + this.getUserId() + ", ddUserId=" + this.getDdUserId() + ")";
   }
}
