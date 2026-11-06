package com.hzchum.scim.plan.core.api.pojo._do;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanSummaryDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PlanSummaryDO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体信息")
   private NameInfo monomer;
   @ApiModelProperty("开始时间")
   @JsonIgnore
   private LocalDate startDate;
   @ApiModelProperty("计划完成日期")
   @JsonIgnore
   private LocalDate endDate;
   @ApiModelProperty("计划量")
   @JsonIgnore
   private BigDecimal mete;
   @ApiModelProperty("计划")
   private List<PlanSummaryDTO> summaries;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public List<PlanSummaryDTO> getSummaries() {
      return this.summaries;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   @JsonIgnore
   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   @JsonIgnore
   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @JsonIgnore
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setSummaries(final List<PlanSummaryDTO> summaries) {
      this.summaries = summaries;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanSummaryDO)) {
         return false;
      }

      PlanSummaryDO other = (PlanSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomer = this.getMonomer();
         Object other$monomer = other.getMonomer();
         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$summaries = this.getSummaries();
                     Object other$summaries = other.getSummaries();
                     return this$summaries == null ? other$summaries == null : this$summaries.equals(other$summaries);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $summaries = this.getSummaries();
      return result * 59 + ($summaries == null ? 43 : $summaries.hashCode());
   }

   @Override
   public String toString() {
      return "PlanSummaryDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", mete="
         + this.getMete()
         + ", summaries="
         + this.getSummaries()
         + ")";
   }
}
