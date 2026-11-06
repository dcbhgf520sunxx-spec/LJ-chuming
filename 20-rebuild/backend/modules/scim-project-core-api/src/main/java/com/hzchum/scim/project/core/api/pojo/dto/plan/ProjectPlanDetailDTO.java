package com.hzchum.scim.project.core.api.pojo.dto.plan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("计划详情类")
public class ProjectPlanDetailDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "startDate", value = "计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "计划结束日期")
   private LocalDate endDate;

   public Long getId() {
      return this.id;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPlanDetailDTO)) {
         return false;
      }

      ProjectPlanDetailDTO other = (ProjectPlanDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$startDate = this.getStartDate();
         Object other$startDate = other.getStartDate();
         if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
            Object this$endDate = this.getEndDate();
            Object other$endDate = other.getEndDate();
            return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPlanDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPlanDetailDTO(id=" + this.getId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ")";
   }
}
