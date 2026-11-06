package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmUserSimpleInfoDTO {
   @ApiModelProperty(value = "用户ID", required = true)
   private Long userId;
   @ApiModelProperty(value = "用户名", required = true)
   private String userName;

   public CrmUserSimpleInfoDTO(final Long userId, final String userName) {
      this.userId = userId;
      this.userName = userName;
   }

   public CrmUserSimpleInfoDTO() {
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmUserSimpleInfoDTO)) {
         return false;
      } else {
         CrmUserSimpleInfoDTO other = (CrmUserSimpleInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmUserSimpleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmUserSimpleInfoDTO(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ")";
   }
}
