package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotEmpty;

public class TechChangeQueryDtoParam {
   @NotEmpty(message = "构件ID列表不能为空!")
   @ApiModelProperty("构件ID列表")
   private Set<Long> artifactIds;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("生产班组ids")
   private List<Long> groupIds;

   public Set<Long> getArtifactIds() {
      return this.artifactIds;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public List<Long> getGroupIds() {
      return this.groupIds;
   }

   public void setArtifactIds(final Set<Long> artifactIds) {
      this.artifactIds = artifactIds;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setGroupIds(final List<Long> groupIds) {
      this.groupIds = groupIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeQueryDtoParam)) {
         return false;
      }

      TechChangeQueryDtoParam other = (TechChangeQueryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$artifactIds = this.getArtifactIds();
         Object other$artifactIds = other.getArtifactIds();
         if (this$artifactIds == null ? other$artifactIds == null : this$artifactIds.equals(other$artifactIds)) {
            Object this$groupIds = this.getGroupIds();
            Object other$groupIds = other.getGroupIds();
            return this$groupIds == null ? other$groupIds == null : this$groupIds.equals(other$groupIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeQueryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $artifactIds = this.getArtifactIds();
      result = result * 59 + ($artifactIds == null ? 43 : $artifactIds.hashCode());
      Object $groupIds = this.getGroupIds();
      return result * 59 + ($groupIds == null ? 43 : $groupIds.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeQueryDtoParam(artifactIds=" + this.getArtifactIds() + ", areaId=" + this.getAreaId() + ", groupIds=" + this.getGroupIds() + ")";
   }
}
