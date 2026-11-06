package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.get;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectProductionLineVORequest", description = "查询项目下的车间产线请求类")
public class ProjectProductionLineVORequest {
   @ApiModelProperty(name = "projectId", notes = "项目Id", value = "项目Id")
   @NotNull(message = "项目Id不可为空!")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体Id", value = "单体Id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域Id", value = "区域Id")
   private Long areaId;

   public static ProjectProductionLineVORequest.ProjectProductionLineVORequestBuilder builder() {
      return new ProjectProductionLineVORequest.ProjectProductionLineVORequestBuilder();
   }

   public ProjectProductionLineVORequest(final Long projectId, final Long monomerId, final Long areaId) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
   }

   public ProjectProductionLineVORequest() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public ProjectProductionLineVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectProductionLineVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProjectProductionLineVORequest setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionLineVORequest(projectId=" + this.getProjectId() + ", monomerId=" + this.getMonomerId() + ", areaId=" + this.getAreaId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionLineVORequest)) {
         return false;
      }

      ProjectProductionLineVORequest other = (ProjectProductionLineVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            return this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductionLineVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      return result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
   }

   public static class ProjectProductionLineVORequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;

      ProjectProductionLineVORequestBuilder() {
      }

      public ProjectProductionLineVORequest.ProjectProductionLineVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectProductionLineVORequest.ProjectProductionLineVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectProductionLineVORequest.ProjectProductionLineVORequestBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectProductionLineVORequest build() {
         return new ProjectProductionLineVORequest(this.projectId, this.monomerId, this.areaId);
      }

      @Override
      public String toString() {
         return "ProjectProductionLineVORequest.ProjectProductionLineVORequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ")";
      }
   }
}
