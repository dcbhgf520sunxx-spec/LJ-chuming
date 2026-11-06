package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserSimpleResponseVO {
   private Long id;
   private String name;
   private String deptName;
   private String phone;
   private String email;
   private Long oaUserId;
   @ApiModelProperty("是否为深化用户")
   private Boolean isDeepen;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getEmail() {
      return this.email;
   }

   public Long getOaUserId() {
      return this.oaUserId;
   }

   public Boolean getIsDeepen() {
      return this.isDeepen;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setOaUserId(final Long oaUserId) {
      this.oaUserId = oaUserId;
   }

   public void setIsDeepen(final Boolean isDeepen) {
      this.isDeepen = isDeepen;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserSimpleResponseVO)) {
         return false;
      }

      UserSimpleResponseVO other = (UserSimpleResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$oaUserId = this.getOaUserId();
         Object other$oaUserId = other.getOaUserId();
         if (this$oaUserId == null ? other$oaUserId == null : this$oaUserId.equals(other$oaUserId)) {
            Object this$isDeepen = this.getIsDeepen();
            Object other$isDeepen = other.getIsDeepen();
            if (this$isDeepen == null ? other$isDeepen == null : this$isDeepen.equals(other$isDeepen)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$deptName = this.getDeptName();
                  Object other$deptName = other.getDeptName();
                  if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                     Object this$phone = this.getPhone();
                     Object other$phone = other.getPhone();
                     if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                        Object this$email = this.getEmail();
                        Object other$email = other.getEmail();
                        return this$email == null ? other$email == null : this$email.equals(other$email);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserSimpleResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $oaUserId = this.getOaUserId();
      result = result * 59 + ($oaUserId == null ? 43 : $oaUserId.hashCode());
      Object $isDeepen = this.getIsDeepen();
      result = result * 59 + ($isDeepen == null ? 43 : $isDeepen.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $email = this.getEmail();
      return result * 59 + ($email == null ? 43 : $email.hashCode());
   }

   @Override
   public String toString() {
      return "UserSimpleResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", deptName="
         + this.getDeptName()
         + ", phone="
         + this.getPhone()
         + ", email="
         + this.getEmail()
         + ", oaUserId="
         + this.getOaUserId()
         + ", isDeepen="
         + this.getIsDeepen()
         + ")";
   }
}
