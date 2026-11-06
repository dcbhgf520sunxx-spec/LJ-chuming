package com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectSummaryDTOParam", description = "项目状态查询")
public class ProjectSummaryDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;

   public static ProjectSummaryDOParam.ProjectSummaryDOParamBuilder builder() {
      return new ProjectSummaryDOParam.ProjectSummaryDOParamBuilder();
   }

   public ProjectSummaryDOParam() {
   }

   public ProjectSummaryDOParam(final Long projectId, final Long monomerId) {
      this.projectId = projectId;
      this.monomerId = monomerId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   @JsonProperty("projectId")
   public ProjectSummaryDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectSummaryDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSummaryDOParam(projectId=" + this.getProjectId() + ", monomerId=" + this.getMonomerId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectSummaryDOParam)) {
         return false;
      } else {
         ProjectSummaryDOParam other = (ProjectSummaryDOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               return this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSummaryDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      return result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
   }

   public static class ProjectSummaryDOParamBuilder {
      private Long projectId;
      private Long monomerId;

      ProjectSummaryDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public ProjectSummaryDOParam.ProjectSummaryDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectSummaryDOParam.ProjectSummaryDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectSummaryDOParam build() {
         return new ProjectSummaryDOParam(this.projectId, this.monomerId);
      }

      @Override
      public String toString() {
         return "ProjectSummaryDOParam.ProjectSummaryDOParamBuilder(projectId=" + this.projectId + ", monomerId=" + this.monomerId + ")";
      }
   }
}
