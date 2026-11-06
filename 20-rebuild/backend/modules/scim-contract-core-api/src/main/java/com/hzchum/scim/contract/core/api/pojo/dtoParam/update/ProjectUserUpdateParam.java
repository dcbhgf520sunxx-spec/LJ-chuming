package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目用户更新参数")
public class ProjectUserUpdateParam {
   @ApiModelProperty("待删除项目id列表")
   private List<Long> projectDelIds;
   @ApiModelProperty("待添加项目id列表")
   private List<Long> projectAddIds;
   @ApiModelProperty("用户id")
   private Long userId;

   public List<Long> getProjectDelIds() {
      return this.projectDelIds;
   }

   public List<Long> getProjectAddIds() {
      return this.projectAddIds;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setProjectDelIds(final List<Long> projectDelIds) {
      this.projectDelIds = projectDelIds;
   }

   public void setProjectAddIds(final List<Long> projectAddIds) {
      this.projectAddIds = projectAddIds;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectUserUpdateParam)) {
         return false;
      }

      ProjectUserUpdateParam other = (ProjectUserUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$projectDelIds = this.getProjectDelIds();
         Object other$projectDelIds = other.getProjectDelIds();
         if (this$projectDelIds == null ? other$projectDelIds == null : this$projectDelIds.equals(other$projectDelIds)) {
            Object this$projectAddIds = this.getProjectAddIds();
            Object other$projectAddIds = other.getProjectAddIds();
            return this$projectAddIds == null ? other$projectAddIds == null : this$projectAddIds.equals(other$projectAddIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectUserUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectDelIds = this.getProjectDelIds();
      result = result * 59 + ($projectDelIds == null ? 43 : $projectDelIds.hashCode());
      Object $projectAddIds = this.getProjectAddIds();
      return result * 59 + ($projectAddIds == null ? 43 : $projectAddIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectUserUpdateParam(projectDelIds="
         + this.getProjectDelIds()
         + ", projectAddIds="
         + this.getProjectAddIds()
         + ", userId="
         + this.getUserId()
         + ")";
   }
}
