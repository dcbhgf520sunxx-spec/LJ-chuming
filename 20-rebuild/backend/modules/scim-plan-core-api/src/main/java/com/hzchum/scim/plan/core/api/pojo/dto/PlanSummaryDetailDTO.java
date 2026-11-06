package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class PlanSummaryDetailDTO {
   @ApiModelProperty("月份")
   private Integer month;
   @ApiModelProperty("计划量")
   private BigDecimal mete;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlanSummaryDetailDTO)) {
         return false;
      } else {
         PlanSummaryDetailDTO other = (PlanSummaryDetailDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanSummaryDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "PlanSummaryDetailDTO(month=" + this.getMonth() + ", mete=" + this.getMete() + ")";
   }
}
