package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.validation.constraints.NotNull;

@ApiModel("角色中的用户更新请求")
public class RoleAndUserUpdateDTO {
   @NotNull(message = "角色id不能为空")
   @ApiModelProperty("角色id")
   private Long roleId;
   @ApiModelProperty("用户id集合")
   private Set<Long> userIds;

   public Long getRoleId() {
      return this.roleId;
   }

   public Set<Long> getUserIds() {
      return this.userIds;
   }

   public void setRoleId(final Long roleId) {
      this.roleId = roleId;
   }

   public void setUserIds(final Set<Long> userIds) {
      this.userIds = userIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RoleAndUserUpdateDTO)) {
         return false;
      } else {
         RoleAndUserUpdateDTO other = (RoleAndUserUpdateDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$roleId = this.getRoleId();
            Object other$roleId = other.getRoleId();
            if (this$roleId == null ? other$roleId == null : this$roleId.equals(other$roleId)) {
               Object this$userIds = this.getUserIds();
               Object other$userIds = other.getUserIds();
               return this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RoleAndUserUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $roleId = this.getRoleId();
      result = result * 59 + ($roleId == null ? 43 : $roleId.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   @Override
   public String toString() {
      return "RoleAndUserUpdateDTO(roleId=" + this.getRoleId() + ", userIds=" + this.getUserIds() + ")";
   }
}
