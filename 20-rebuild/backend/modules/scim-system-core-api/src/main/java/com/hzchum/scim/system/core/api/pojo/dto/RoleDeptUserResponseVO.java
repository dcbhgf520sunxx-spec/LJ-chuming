package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("用户部门角色信息返回类")
public class RoleDeptUserResponseVO {
   @ApiModelProperty(name = "deptId", value = "角色id")
   private Long roleId;
   @ApiModelProperty(name = "deptName", value = "角色名称")
   private String roleName;
   @ApiModelProperty(name = "userDeptResponseVOList", value = "用户部门信息返回类")
   private List<UserDeptResponseVO> userDeptResponseVOList;

   public static RoleDeptUserResponseVO.RoleDeptUserResponseVOBuilder builder() {
      return new RoleDeptUserResponseVO.RoleDeptUserResponseVOBuilder();
   }

   public RoleDeptUserResponseVO() {
   }

   public RoleDeptUserResponseVO(final Long roleId, final String roleName, final List<UserDeptResponseVO> userDeptResponseVOList) {
      this.roleId = roleId;
      this.roleName = roleName;
      this.userDeptResponseVOList = userDeptResponseVOList;
   }

   public Long getRoleId() {
      return this.roleId;
   }

   public String getRoleName() {
      return this.roleName;
   }

   public List<UserDeptResponseVO> getUserDeptResponseVOList() {
      return this.userDeptResponseVOList;
   }

   public void setRoleId(final Long roleId) {
      this.roleId = roleId;
   }

   public void setRoleName(final String roleName) {
      this.roleName = roleName;
   }

   public void setUserDeptResponseVOList(final List<UserDeptResponseVO> userDeptResponseVOList) {
      this.userDeptResponseVOList = userDeptResponseVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RoleDeptUserResponseVO)) {
         return false;
      }

      RoleDeptUserResponseVO other = (RoleDeptUserResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$roleId = this.getRoleId();
      Object other$roleId = other.getRoleId();
      if (this$roleId == null ? other$roleId == null : this$roleId.equals(other$roleId)) {
         Object this$roleName = this.getRoleName();
         Object other$roleName = other.getRoleName();
         if (this$roleName == null ? other$roleName == null : this$roleName.equals(other$roleName)) {
            Object this$userDeptResponseVOList = this.getUserDeptResponseVOList();
            Object other$userDeptResponseVOList = other.getUserDeptResponseVOList();
            return this$userDeptResponseVOList == null
               ? other$userDeptResponseVOList == null
               : this$userDeptResponseVOList.equals(other$userDeptResponseVOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RoleDeptUserResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $roleId = this.getRoleId();
      result = result * 59 + ($roleId == null ? 43 : $roleId.hashCode());
      Object $roleName = this.getRoleName();
      result = result * 59 + ($roleName == null ? 43 : $roleName.hashCode());
      Object $userDeptResponseVOList = this.getUserDeptResponseVOList();
      return result * 59 + ($userDeptResponseVOList == null ? 43 : $userDeptResponseVOList.hashCode());
   }

   @Override
   public String toString() {
      return "RoleDeptUserResponseVO(roleId="
         + this.getRoleId()
         + ", roleName="
         + this.getRoleName()
         + ", userDeptResponseVOList="
         + this.getUserDeptResponseVOList()
         + ")";
   }

   public static class RoleDeptUserResponseVOBuilder {
      private Long roleId;
      private String roleName;
      private List<UserDeptResponseVO> userDeptResponseVOList;

      RoleDeptUserResponseVOBuilder() {
      }

      public RoleDeptUserResponseVO.RoleDeptUserResponseVOBuilder roleId(final Long roleId) {
         this.roleId = roleId;
         return this;
      }

      public RoleDeptUserResponseVO.RoleDeptUserResponseVOBuilder roleName(final String roleName) {
         this.roleName = roleName;
         return this;
      }

      public RoleDeptUserResponseVO.RoleDeptUserResponseVOBuilder userDeptResponseVOList(final List<UserDeptResponseVO> userDeptResponseVOList) {
         this.userDeptResponseVOList = userDeptResponseVOList;
         return this;
      }

      public RoleDeptUserResponseVO build() {
         return new RoleDeptUserResponseVO(this.roleId, this.roleName, this.userDeptResponseVOList);
      }

      @Override
      public String toString() {
         return "RoleDeptUserResponseVO.RoleDeptUserResponseVOBuilder(roleId="
            + this.roleId
            + ", roleName="
            + this.roleName
            + ", userDeptResponseVOList="
            + this.userDeptResponseVOList
            + ")";
      }
   }
}
