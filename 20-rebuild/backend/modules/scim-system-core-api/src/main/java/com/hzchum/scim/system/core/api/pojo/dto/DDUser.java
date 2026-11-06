package com.hzchum.scim.system.core.api.pojo.dto;

public class DDUser {
   private String userId;
   private String name;
   private String mobile;

   public String getUserId() {
      return this.userId;
   }

   public String getName() {
      return this.name;
   }

   public String getMobile() {
      return this.mobile;
   }

   public void setUserId(final String userId) {
      this.userId = userId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMobile(final String mobile) {
      this.mobile = mobile;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DDUser)) {
         return false;
      }

      DDUser other = (DDUser)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$mobile = this.getMobile();
            Object other$mobile = other.getMobile();
            return this$mobile == null ? other$mobile == null : this$mobile.equals(other$mobile);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DDUser;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mobile = this.getMobile();
      return result * 59 + ($mobile == null ? 43 : $mobile.hashCode());
   }

   @Override
   public String toString() {
      return "DDUser(userId=" + this.getUserId() + ", name=" + this.getName() + ", mobile=" + this.getMobile() + ")";
   }
}
