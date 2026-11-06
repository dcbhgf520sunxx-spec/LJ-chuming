package com.hzchum.scim.mes.building.core.api.pojo._dto.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenTeamAchievementRateProductionLineDTO", description = "班组达成率以产线为单位")
public class ScreenTeamAchievementRateProductionLineDTO {
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数")
   private Double schedulingQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数")
   private Double completeQuantity;
   @ApiModelProperty(name = "productionName", notes = "产线名称")
   private String productionName;
   @ApiModelProperty(name = "month", notes = "月份")
   private String month;

   public static ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder builder() {
      return new ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder();
   }

   public ScreenTeamAchievementRateProductionLineDTO() {
   }

   public ScreenTeamAchievementRateProductionLineDTO(
      final Double schedulingQuantity, final Double completeQuantity, final String productionName, final String month
   ) {
      this.schedulingQuantity = schedulingQuantity;
      this.completeQuantity = completeQuantity;
      this.productionName = productionName;
      this.month = month;
   }

   public Double getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Double getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getProductionName() {
      return this.productionName;
   }

   public String getMonth() {
      return this.month;
   }

   public ScreenTeamAchievementRateProductionLineDTO setSchedulingQuantity(final Double schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   public ScreenTeamAchievementRateProductionLineDTO setCompleteQuantity(final Double completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public ScreenTeamAchievementRateProductionLineDTO setProductionName(final String productionName) {
      this.productionName = productionName;
      return this;
   }

   public ScreenTeamAchievementRateProductionLineDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenTeamAchievementRateProductionLineDTO(schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", productionName="
         + this.getProductionName()
         + ", month="
         + this.getMonth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenTeamAchievementRateProductionLineDTO)) {
         return false;
      }

      ScreenTeamAchievementRateProductionLineDTO other = (ScreenTeamAchievementRateProductionLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingQuantity = this.getSchedulingQuantity();
      Object other$schedulingQuantity = other.getSchedulingQuantity();
      if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$productionName = this.getProductionName();
            Object other$productionName = other.getProductionName();
            if (this$productionName == null ? other$productionName == null : this$productionName.equals(other$productionName)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               return this$month == null ? other$month == null : this$month.equals(other$month);
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
      return other instanceof ScreenTeamAchievementRateProductionLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $productionName = this.getProductionName();
      result = result * 59 + ($productionName == null ? 43 : $productionName.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   public static class ScreenTeamAchievementRateProductionLineDTOBuilder {
      private Double schedulingQuantity;
      private Double completeQuantity;
      private String productionName;
      private String month;

      ScreenTeamAchievementRateProductionLineDTOBuilder() {
      }

      public ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder schedulingQuantity(final Double schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder completeQuantity(final Double completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder productionName(final String productionName) {
         this.productionName = productionName;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineDTO build() {
         return new ScreenTeamAchievementRateProductionLineDTO(this.schedulingQuantity, this.completeQuantity, this.productionName, this.month);
      }

      @Override
      public String toString() {
         return "ScreenTeamAchievementRateProductionLineDTO.ScreenTeamAchievementRateProductionLineDTOBuilder(schedulingQuantity="
            + this.schedulingQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", productionName="
            + this.productionName
            + ", month="
            + this.month
            + ")";
      }
   }
}
