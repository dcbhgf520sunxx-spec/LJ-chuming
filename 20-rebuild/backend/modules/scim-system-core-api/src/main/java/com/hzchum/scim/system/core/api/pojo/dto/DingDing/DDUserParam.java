package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import java.util.List;

public class DDUserParam {
   private List<Long> deptIdList;
   private String email;
   private String mobile;
   private String name;
   private String userid;

   public List<Long> getDeptIdList() {
      return this.deptIdList;
   }

   public String getEmail() {
      return this.email;
   }

   public String getMobile() {
      return this.mobile;
   }

   public String getName() {
      return this.name;
   }

   public String getUserid() {
      return this.userid;
   }

   public void setDeptIdList(final List<Long> deptIdList) {
      this.deptIdList = deptIdList;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setMobile(final String mobile) {
      this.mobile = mobile;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUserid(final String userid) {
      this.userid = userid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DDUserParam)) {
         return false;
      }

      DDUserParam other = (DDUserParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$deptIdList = this.getDeptIdList();
      Object other$deptIdList = other.getDeptIdList();
      if (this$deptIdList == null ? other$deptIdList == null : this$deptIdList.equals(other$deptIdList)) {
         Object this$email = this.getEmail();
         Object other$email = other.getEmail();
         if (this$email == null ? other$email == null : this$email.equals(other$email)) {
            Object this$mobile = this.getMobile();
            Object other$mobile = other.getMobile();
            if (this$mobile == null ? other$mobile == null : this$mobile.equals(other$mobile)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$userid = this.getUserid();
                  Object other$userid = other.getUserid();
                  return this$userid == null ? other$userid == null : this$userid.equals(other$userid);
               } else {
                  return false;
               }
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
      return other instanceof DDUserParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deptIdList = this.getDeptIdList();
      result = result * 59 + ($deptIdList == null ? 43 : $deptIdList.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $mobile = this.getMobile();
      result = result * 59 + ($mobile == null ? 43 : $mobile.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $userid = this.getUserid();
      return result * 59 + ($userid == null ? 43 : $userid.hashCode());
   }

   @Override
   public String toString() {
      return "DDUserParam(deptIdList="
         + this.getDeptIdList()
         + ", email="
         + this.getEmail()
         + ", mobile="
         + this.getMobile()
         + ", name="
         + this.getName()
         + ", userid="
         + this.getUserid()
         + ")";
   }
}
