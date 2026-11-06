package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class WorkshopAchievementRateDTO {
   @ApiModelProperty("月份")
   private String month;
   @ApiModelProperty("排产任务")
   private BigDecimal schedulingWeight;
   @ApiModelProperty("实际完成")
   private BigDecimal completedWeight;
   @ApiModelProperty("达成率")
   private BigDecimal rate;

   public static WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder builder() {
      return new WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder();
   }

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getSchedulingWeight() {
      return this.schedulingWeight;
   }

   public BigDecimal getCompletedWeight() {
      return this.completedWeight;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public void setMonth(final String month) {
      this.month = month;
   }

   public void setSchedulingWeight(final BigDecimal schedulingWeight) {
      this.schedulingWeight = schedulingWeight;
   }

   public void setCompletedWeight(final BigDecimal completedWeight) {
      this.completedWeight = completedWeight;
   }

   public void setRate(final BigDecimal rate) {
      this.rate = rate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopAchievementRateDTO)) {
         return false;
      }

      WorkshopAchievementRateDTO other = (WorkshopAchievementRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$schedulingWeight = this.getSchedulingWeight();
         Object other$schedulingWeight = other.getSchedulingWeight();
         if (this$schedulingWeight == null ? other$schedulingWeight == null : this$schedulingWeight.equals(other$schedulingWeight)) {
            Object this$completedWeight = this.getCompletedWeight();
            Object other$completedWeight = other.getCompletedWeight();
            if (this$completedWeight == null ? other$completedWeight == null : this$completedWeight.equals(other$completedWeight)) {
               Object this$rate = this.getRate();
               Object other$rate = other.getRate();
               return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof WorkshopAchievementRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $schedulingWeight = this.getSchedulingWeight();
      result = result * 59 + ($schedulingWeight == null ? 43 : $schedulingWeight.hashCode());
      Object $completedWeight = this.getCompletedWeight();
      result = result * 59 + ($completedWeight == null ? 43 : $completedWeight.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopAchievementRateDTO(month="
         + this.getMonth()
         + ", schedulingWeight="
         + this.getSchedulingWeight()
         + ", completedWeight="
         + this.getCompletedWeight()
         + ", rate="
         + this.getRate()
         + ")";
   }

   public WorkshopAchievementRateDTO(final String month, final BigDecimal schedulingWeight, final BigDecimal completedWeight, final BigDecimal rate) {
      this.month = month;
      this.schedulingWeight = schedulingWeight;
      this.completedWeight = completedWeight;
      this.rate = rate;
   }

   public WorkshopAchievementRateDTO() {
   }

   public static class WorkshopAchievementRateDTOBuilder {
      private String month;
      private BigDecimal schedulingWeight;
      private BigDecimal completedWeight;
      private BigDecimal rate;

      WorkshopAchievementRateDTOBuilder() {
      }

      public WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder schedulingWeight(final BigDecimal schedulingWeight) {
         this.schedulingWeight = schedulingWeight;
         return this;
      }

      public WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder completedWeight(final BigDecimal completedWeight) {
         this.completedWeight = completedWeight;
         return this;
      }

      public WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      public WorkshopAchievementRateDTO build() {
         return new WorkshopAchievementRateDTO(this.month, this.schedulingWeight, this.completedWeight, this.rate);
      }

      @Override
      public String toString() {
         return "WorkshopAchievementRateDTO.WorkshopAchievementRateDTOBuilder(month="
            + this.month
            + ", schedulingWeight="
            + this.schedulingWeight
            + ", completedWeight="
            + this.completedWeight
            + ", rate="
            + this.rate
            + ")";
      }
   }
}
