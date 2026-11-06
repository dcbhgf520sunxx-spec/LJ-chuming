package com.hzchum.scim.common.core.api.pojo.common;

import java.util.List;

public class ApproveInfo {
   private Integer type;
   private List<ApproveUserInfo> users;

   public Integer getType() {
      return this.type;
   }

   public List<ApproveUserInfo> getUsers() {
      return this.users;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setUsers(final List<ApproveUserInfo> users) {
      this.users = users;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ApproveInfo)) {
         return false;
      } else {
         ApproveInfo other = (ApproveInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$users = this.getUsers();
               Object other$users = other.getUsers();
               return this$users == null ? other$users == null : this$users.equals(other$users);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApproveInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $users = this.getUsers();
      return result * 59 + ($users == null ? 43 : $users.hashCode());
   }

   @Override
   public String toString() {
      return "ApproveInfo(type=" + this.getType() + ", users=" + this.getUsers() + ")";
   }
}
