package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "项目计划详情DTO")
public class ProjectPlanDetailDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("单体列表")
   private List<ProjectPlanMonomerDTO> monomerList;

   ProjectPlanDetailDTO(final Long projectId, final List<ProjectPlanMonomerDTO> monomerList) {
      this.projectId = projectId;
      this.monomerList = monomerList;
   }

   public static ProjectPlanDetailDTO.ProjectPlanDetailDTOBuilder builder() {
      return new ProjectPlanDetailDTO.ProjectPlanDetailDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<ProjectPlanMonomerDTO> getMonomerList() {
      return this.monomerList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerList(final List<ProjectPlanMonomerDTO> monomerList) {
      this.monomerList = monomerList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectPlanDetailDTO)) {
         return false;
      } else {
         ProjectPlanDetailDTO other = (ProjectPlanDetailDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerList = this.getMonomerList();
               Object other$monomerList = other.getMonomerList();
               return this$monomerList == null ? other$monomerList == null : this$monomerList.equals(other$monomerList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPlanDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerList = this.getMonomerList();
      return result * 59 + ($monomerList == null ? 43 : $monomerList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPlanDetailDTO(projectId=" + this.getProjectId() + ", monomerList=" + this.getMonomerList() + ")";
   }

   public static class ProjectPlanDetailDTOBuilder {
      private Long projectId;
      private List<ProjectPlanMonomerDTO> monomerList;

      ProjectPlanDetailDTOBuilder() {
      }

      public ProjectPlanDetailDTO.ProjectPlanDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectPlanDetailDTO.ProjectPlanDetailDTOBuilder monomerList(final List<ProjectPlanMonomerDTO> monomerList) {
         this.monomerList = monomerList;
         return this;
      }

      public ProjectPlanDetailDTO build() {
         return new ProjectPlanDetailDTO(this.projectId, this.monomerList);
      }

      @Override
      public String toString() {
         return "ProjectPlanDetailDTO.ProjectPlanDetailDTOBuilder(projectId=" + this.projectId + ", monomerList=" + this.monomerList + ")";
      }
   }
}
