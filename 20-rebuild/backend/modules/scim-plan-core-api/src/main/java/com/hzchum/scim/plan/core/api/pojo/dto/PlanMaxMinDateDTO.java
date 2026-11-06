package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("计划时间")
public class PlanMaxMinDateDTO {
   @ApiModelProperty(name = "minDate", value = "最小完成日期")
   private LocalDate minDate;
   @ApiModelProperty(name = "maxDate", value = "最大完成日期")
   private LocalDate maxDate;

   public LocalDate getMinDate() {
      return this.minDate;
   }

   public LocalDate getMaxDate() {
      return this.maxDate;
   }

   public void setMinDate(final LocalDate minDate) {
      this.minDate = minDate;
   }

   public void setMaxDate(final LocalDate maxDate) {
      this.maxDate = maxDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlanMaxMinDateDTO)) {
         return false;
      } else {
         PlanMaxMinDateDTO other = (PlanMaxMinDateDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$minDate = this.getMinDate();
            Object other$minDate = other.getMinDate();
            if (this$minDate == null ? other$minDate == null : this$minDate.equals(other$minDate)) {
               Object this$maxDate = this.getMaxDate();
               Object other$maxDate = other.getMaxDate();
               return this$maxDate == null ? other$maxDate == null : this$maxDate.equals(other$maxDate);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanMaxMinDateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $minDate = this.getMinDate();
      result = result * 59 + ($minDate == null ? 43 : $minDate.hashCode());
      Object $maxDate = this.getMaxDate();
      return result * 59 + ($maxDate == null ? 43 : $maxDate.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMaxMinDateDTO(minDate=" + this.getMinDate() + ", maxDate=" + this.getMaxDate() + ")";
   }
}
