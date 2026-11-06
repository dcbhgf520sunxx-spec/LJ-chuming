package com.hzchum.scim.system.core.api.pojo.request.foreign;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ForeignRoleMenuUpdateRequestVO {
   @ApiModelProperty("token")
   @NotBlank(message = "token不能为空!")
   private String token;
   @NotEmpty(message = "权限列表不可为空!")
   private List<String> permissions;
   @NotEmpty(message = "角色列表列表不可为空!")
   private List<Long> roleIds;

   public String getToken() {
      return this.token;
   }

   public List<String> getPermissions() {
      return this.permissions;
   }

   public List<Long> getRoleIds() {
      return this.roleIds;
   }

   public void setToken(final String token) {
      this.token = token;
   }

   public void setPermissions(final List<String> permissions) {
      this.permissions = permissions;
   }

   public void setRoleIds(final List<Long> roleIds) {
      this.roleIds = roleIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ForeignRoleMenuUpdateRequestVO)) {
         return false;
      }

      ForeignRoleMenuUpdateRequestVO other = (ForeignRoleMenuUpdateRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$token = this.getToken();
      Object other$token = other.getToken();
      if (this$token == null ? other$token == null : this$token.equals(other$token)) {
         Object this$permissions = this.getPermissions();
         Object other$permissions = other.getPermissions();
         if (this$permissions == null ? other$permissions == null : this$permissions.equals(other$permissions)) {
            Object this$roleIds = this.getRoleIds();
            Object other$roleIds = other.getRoleIds();
            return this$roleIds == null ? other$roleIds == null : this$roleIds.equals(other$roleIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ForeignRoleMenuUpdateRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $token = this.getToken();
      result = result * 59 + ($token == null ? 43 : $token.hashCode());
      Object $permissions = this.getPermissions();
      result = result * 59 + ($permissions == null ? 43 : $permissions.hashCode());
      Object $roleIds = this.getRoleIds();
      return result * 59 + ($roleIds == null ? 43 : $roleIds.hashCode());
   }

   @Override
   public String toString() {
      return "ForeignRoleMenuUpdateRequestVO(token=" + this.getToken() + ", permissions=" + this.getPermissions() + ", roleIds=" + this.getRoleIds() + ")";
   }
}
