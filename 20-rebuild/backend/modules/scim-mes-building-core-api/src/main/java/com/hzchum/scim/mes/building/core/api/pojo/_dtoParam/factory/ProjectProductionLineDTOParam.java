package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ProjectProductionLineDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目Id", value = "项目Id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体Id", value = "单体Id")
   private Long monomerId;
   @ApiModelProperty(name = "areaIds", notes = "区域Ids", value = "区域Ids")
   private List<Long> areaIds;

   public static ProjectProductionLineDTOParam.ProjectProductionLineDTOParamBuilder builder() {
      return new ProjectProductionLineDTOParam.ProjectProductionLineDTOParamBuilder();
   }

   public ProjectProductionLineDTOParam() {
   }

   public ProjectProductionLineDTOParam(final Long projectId, final Long monomerId, final List<Long> areaIds) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaIds = areaIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAreaIds() {
      return this.areaIds;
   }

   public ProjectProductionLineDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectProductionLineDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProjectProductionLineDTOParam setAreaIds(final List<Long> areaIds) {
      this.areaIds = areaIds;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionLineDTOParam(projectId=" + this.getProjectId() + ", monomerId=" + this.getMonomerId() + ", areaIds=" + this.getAreaIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionLineDTOParam)) {
         return false;
      }

      ProjectProductionLineDTOParam other = (ProjectProductionLineDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaIds = this.getAreaIds();
            Object other$areaIds = other.getAreaIds();
            return this$areaIds == null ? other$areaIds == null : this$areaIds.equals(other$areaIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductionLineDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaIds = this.getAreaIds();
      return result * 59 + ($areaIds == null ? 43 : $areaIds.hashCode());
   }

   public static class ProjectProductionLineDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private List<Long> areaIds;

      ProjectProductionLineDTOParamBuilder() {
      }

      public ProjectProductionLineDTOParam.ProjectProductionLineDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectProductionLineDTOParam.ProjectProductionLineDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectProductionLineDTOParam.ProjectProductionLineDTOParamBuilder areaIds(final List<Long> areaIds) {
         this.areaIds = areaIds;
         return this;
      }

      public ProjectProductionLineDTOParam build() {
         return new ProjectProductionLineDTOParam(this.projectId, this.monomerId, this.areaIds);
      }

      @Override
      public String toString() {
         return "ProjectProductionLineDTOParam.ProjectProductionLineDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaIds="
            + this.areaIds
            + ")";
      }
   }
}
