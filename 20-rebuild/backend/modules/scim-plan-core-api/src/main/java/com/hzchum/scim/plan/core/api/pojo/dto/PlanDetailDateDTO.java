package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("")
public class PlanDetailDateDTO {
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束日期")
   private LocalDate endDate;

   public static PlanDetailDateDTO.PlanDetailDateDTOBuilder builder() {
      return new PlanDetailDateDTO.PlanDetailDateDTOBuilder();
   }

   public PlanDetailDateDTO() {
   }

   public PlanDetailDateDTO(final LocalDate startDate, final LocalDate endDate) {
      this.startDate = startDate;
      this.endDate = endDate;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
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
      } else if (!(o instanceof PlanDetailDateDTO)) {
         return false;
      } else {
         PlanDetailDateDTO other = (PlanDetailDateDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanDetailDateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDetailDateDTO(startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ")";
   }

   public static class PlanDetailDateDTOBuilder {
      private LocalDate startDate;
      private LocalDate endDate;

      PlanDetailDateDTOBuilder() {
      }

      public PlanDetailDateDTO.PlanDetailDateDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public PlanDetailDateDTO.PlanDetailDateDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public PlanDetailDateDTO build() {
         return new PlanDetailDateDTO(this.startDate, this.endDate);
      }

      @Override
      public String toString() {
         return "PlanDetailDateDTO.PlanDetailDateDTOBuilder(startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
      }
   }
}
