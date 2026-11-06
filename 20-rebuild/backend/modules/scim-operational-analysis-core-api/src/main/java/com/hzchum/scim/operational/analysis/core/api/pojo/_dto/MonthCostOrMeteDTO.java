package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel("费用信息")
public class MonthCostOrMeteDTO {
   private String month;
   private BigDecimal costOrMete = BigDecimal.ZERO;

   public static MonthCostOrMeteDTO.MonthCostOrMeteDTOBuilder builder() {
      return new MonthCostOrMeteDTO.MonthCostOrMeteDTOBuilder();
   }

   public MonthCostOrMeteDTO() {
   }

   public MonthCostOrMeteDTO(final String month, final BigDecimal costOrMete) {
      this.month = month;
      this.costOrMete = costOrMete;
   }

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getCostOrMete() {
      return this.costOrMete;
   }

   public void setMonth(final String month) {
      this.month = month;
   }

   public void setCostOrMete(final BigDecimal costOrMete) {
      this.costOrMete = costOrMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonthCostOrMeteDTO)) {
         return false;
      } else {
         MonthCostOrMeteDTO other = (MonthCostOrMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$costOrMete = this.getCostOrMete();
               Object other$costOrMete = other.getCostOrMete();
               return this$costOrMete == null ? other$costOrMete == null : this$costOrMete.equals(other$costOrMete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthCostOrMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $costOrMete = this.getCostOrMete();
      return result * 59 + ($costOrMete == null ? 43 : $costOrMete.hashCode());
   }

   @Override
   public String toString() {
      return "MonthCostOrMeteDTO(month=" + this.getMonth() + ", costOrMete=" + this.getCostOrMete() + ")";
   }

   public static class MonthCostOrMeteDTOBuilder {
      private String month;
      private BigDecimal costOrMete;

      MonthCostOrMeteDTOBuilder() {
      }

      public MonthCostOrMeteDTO.MonthCostOrMeteDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public MonthCostOrMeteDTO.MonthCostOrMeteDTOBuilder costOrMete(final BigDecimal costOrMete) {
         this.costOrMete = costOrMete;
         return this;
      }

      public MonthCostOrMeteDTO build() {
         return new MonthCostOrMeteDTO(this.month, this.costOrMete);
      }

      @Override
      public String toString() {
         return "MonthCostOrMeteDTO.MonthCostOrMeteDTOBuilder(month=" + this.month + ", costOrMete=" + this.costOrMete + ")";
      }
   }
}
