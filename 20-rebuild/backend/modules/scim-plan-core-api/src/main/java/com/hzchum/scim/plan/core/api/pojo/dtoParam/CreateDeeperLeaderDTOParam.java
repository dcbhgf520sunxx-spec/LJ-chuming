package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CreateDeeperLeaderDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "userIdList", notes = "深化负责人id集合")
   private List<Long> userIdList;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getUserIdList() {
      return this.userIdList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setUserIdList(final List<Long> userIdList) {
      this.userIdList = userIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CreateDeeperLeaderDTOParam)) {
         return false;
      }

      CreateDeeperLeaderDTOParam other = (CreateDeeperLeaderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$userIdList = this.getUserIdList();
            Object other$userIdList = other.getUserIdList();
            return this$userIdList == null ? other$userIdList == null : this$userIdList.equals(other$userIdList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CreateDeeperLeaderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $userIdList = this.getUserIdList();
      return result * 59 + ($userIdList == null ? 43 : $userIdList.hashCode());
   }

   @Override
   public String toString() {
      return "CreateDeeperLeaderDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", userIdList="
         + this.getUserIdList()
         + ")";
   }
}
