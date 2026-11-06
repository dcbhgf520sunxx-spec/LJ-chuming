package com.hzchum.scim.common.core.api.pojo.vo;

import com.hzchum.scim.common.core.api.pojo.common.ApproveUserInfo;
import java.util.List;

public class ApproveInfoVO {
   private Integer type;
   private List<ApproveUserInfo> users;
   private Integer sort;
   private String userName;

   public Integer getType() {
      return this.type;
   }

   public List<ApproveUserInfo> getUsers() {
      return this.users;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setUsers(final List<ApproveUserInfo> users) {
      this.users = users;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApproveInfoVO)) {
         return false;
      }

      ApproveInfoVO other = (ApproveInfoVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$users = this.getUsers();
            Object other$users = other.getUsers();
            if (this$users == null ? other$users == null : this$users.equals(other$users)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApproveInfoVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $users = this.getUsers();
      result = result * 59 + ($users == null ? 43 : $users.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ApproveInfoVO(type=" + this.getType() + ", users=" + this.getUsers() + ", sort=" + this.getSort() + ", userName=" + this.getUserName() + ")";
   }
}
