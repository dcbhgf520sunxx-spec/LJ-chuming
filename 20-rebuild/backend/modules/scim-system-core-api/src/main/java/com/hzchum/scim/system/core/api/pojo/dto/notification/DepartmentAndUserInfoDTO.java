package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;

public class DepartmentAndUserInfoDTO {
   @ApiModelProperty(name = "userName", notes = "用户名称")
   private String userName;
   @ApiModelProperty(name = "departmentName", notes = "部门名称")
   private String departmentName;

   public static DepartmentAndUserInfoDTO.DepartmentAndUserInfoDTOBuilder builder() {
      return new DepartmentAndUserInfoDTO.DepartmentAndUserInfoDTOBuilder();
   }

   public DepartmentAndUserInfoDTO(final String userName, final String departmentName) {
      this.userName = userName;
      this.departmentName = departmentName;
   }

   public DepartmentAndUserInfoDTO() {
   }

   public String getUserName() {
      return this.userName;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DepartmentAndUserInfoDTO)) {
         return false;
      } else {
         DepartmentAndUserInfoDTO other = (DepartmentAndUserInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
               Object this$departmentName = this.getDepartmentName();
               Object other$departmentName = other.getDepartmentName();
               return this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DepartmentAndUserInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $departmentName = this.getDepartmentName();
      return result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
   }

   @Override
   public String toString() {
      return "DepartmentAndUserInfoDTO(userName=" + this.getUserName() + ", departmentName=" + this.getDepartmentName() + ")";
   }

   public static class DepartmentAndUserInfoDTOBuilder {
      private String userName;
      private String departmentName;

      DepartmentAndUserInfoDTOBuilder() {
      }

      public DepartmentAndUserInfoDTO.DepartmentAndUserInfoDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public DepartmentAndUserInfoDTO.DepartmentAndUserInfoDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public DepartmentAndUserInfoDTO build() {
         return new DepartmentAndUserInfoDTO(this.userName, this.departmentName);
      }

      @Override
      public String toString() {
         return "DepartmentAndUserInfoDTO.DepartmentAndUserInfoDTOBuilder(userName=" + this.userName + ", departmentName=" + this.departmentName + ")";
      }
   }
}
