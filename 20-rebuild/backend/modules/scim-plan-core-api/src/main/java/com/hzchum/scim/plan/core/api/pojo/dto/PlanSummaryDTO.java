package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class PlanSummaryDTO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体信息")
   private NameInfo monomer;
   @ApiModelProperty("计划")
   private List<PlanSummaryDetailDTO> details;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public List<PlanSummaryDetailDTO> getDetails() {
      return this.details;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setDetails(final List<PlanSummaryDetailDTO> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanSummaryDTO)) {
         return false;
      }

      PlanSummaryDTO other = (PlanSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomer = this.getMonomer();
         Object other$monomer = other.getMonomer();
         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
            Object this$details = this.getDetails();
            Object other$details = other.getDetails();
            return this$details == null ? other$details == null : this$details.equals(other$details);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "PlanSummaryDTO(project=" + this.getProject() + ", monomer=" + this.getMonomer() + ", details=" + this.getDetails() + ")";
   }
}
