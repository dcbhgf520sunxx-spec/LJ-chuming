package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("用户部门信息返回类")
public class UserDeptResponseVO {
   @ApiModelProperty(name = "deptId", value = "部门id")
   private Long deptId;
   @ApiModelProperty(name = "deptName", value = "部门名称")
   private String deptName;
   @ApiModelProperty(name = "deptName", value = "用户信息")
   private List<UserJobResponseVO> userJobResponseVOList;

   public static UserDeptResponseVO.UserDeptResponseVOBuilder builder() {
      return new UserDeptResponseVO.UserDeptResponseVOBuilder();
   }

   public UserDeptResponseVO() {
   }

   public UserDeptResponseVO(final Long deptId, final String deptName, final List<UserJobResponseVO> userJobResponseVOList) {
      this.deptId = deptId;
      this.deptName = deptName;
      this.userJobResponseVOList = userJobResponseVOList;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public List<UserJobResponseVO> getUserJobResponseVOList() {
      return this.userJobResponseVOList;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setUserJobResponseVOList(final List<UserJobResponseVO> userJobResponseVOList) {
      this.userJobResponseVOList = userJobResponseVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserDeptResponseVO)) {
         return false;
      }

      UserDeptResponseVO other = (UserDeptResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$deptId = this.getDeptId();
      Object other$deptId = other.getDeptId();
      if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
         Object this$deptName = this.getDeptName();
         Object other$deptName = other.getDeptName();
         if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
            Object this$userJobResponseVOList = this.getUserJobResponseVOList();
            Object other$userJobResponseVOList = other.getUserJobResponseVOList();
            return this$userJobResponseVOList == null ? other$userJobResponseVOList == null : this$userJobResponseVOList.equals(other$userJobResponseVOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserDeptResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $userJobResponseVOList = this.getUserJobResponseVOList();
      return result * 59 + ($userJobResponseVOList == null ? 43 : $userJobResponseVOList.hashCode());
   }

   @Override
   public String toString() {
      return "UserDeptResponseVO(deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", userJobResponseVOList="
         + this.getUserJobResponseVOList()
         + ")";
   }

   public static class UserDeptResponseVOBuilder {
      private Long deptId;
      private String deptName;
      private List<UserJobResponseVO> userJobResponseVOList;

      UserDeptResponseVOBuilder() {
      }

      public UserDeptResponseVO.UserDeptResponseVOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public UserDeptResponseVO.UserDeptResponseVOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public UserDeptResponseVO.UserDeptResponseVOBuilder userJobResponseVOList(final List<UserJobResponseVO> userJobResponseVOList) {
         this.userJobResponseVOList = userJobResponseVOList;
         return this;
      }

      public UserDeptResponseVO build() {
         return new UserDeptResponseVO(this.deptId, this.deptName, this.userJobResponseVOList);
      }

      @Override
      public String toString() {
         return "UserDeptResponseVO.UserDeptResponseVOBuilder(deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ", userJobResponseVOList="
            + this.userJobResponseVOList
            + ")";
      }
   }
}
