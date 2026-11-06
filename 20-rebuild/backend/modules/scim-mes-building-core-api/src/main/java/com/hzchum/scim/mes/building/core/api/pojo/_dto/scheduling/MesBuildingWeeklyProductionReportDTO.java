package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingWeeklyProductionReportDTO", description = "生产周报")
public class MesBuildingWeeklyProductionReportDTO {
   @ApiModelProperty(name = "workshopName", value = "车间名称")
   private String workShopName;
   @ApiModelProperty(name = "weeksNetWeight", value = "周总量")
   private double weeksNetWeight;
   @ApiModelProperty(name = "monthNetWeight", value = "月总量")
   private double monthNetWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总重量")
   private double totalNetWeight;

   public String getWorkShopName() {
      return this.workShopName;
   }

   public double getWeeksNetWeight() {
      return this.weeksNetWeight;
   }

   public double getMonthNetWeight() {
      return this.monthNetWeight;
   }

   public double getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public MesBuildingWeeklyProductionReportDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   public MesBuildingWeeklyProductionReportDTO setWeeksNetWeight(final double weeksNetWeight) {
      this.weeksNetWeight = weeksNetWeight;
      return this;
   }

   public MesBuildingWeeklyProductionReportDTO setMonthNetWeight(final double monthNetWeight) {
      this.monthNetWeight = monthNetWeight;
      return this;
   }

   public MesBuildingWeeklyProductionReportDTO setTotalNetWeight(final double totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWeeklyProductionReportDTO(workShopName="
         + this.getWorkShopName()
         + ", weeksNetWeight="
         + this.getWeeksNetWeight()
         + ", monthNetWeight="
         + this.getMonthNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWeeklyProductionReportDTO)) {
         return false;
      }

      MesBuildingWeeklyProductionReportDTO other = (MesBuildingWeeklyProductionReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getWeeksNetWeight(), other.getWeeksNetWeight()) != 0) {
         return false;
      }

      if (Double.compare(this.getMonthNetWeight(), other.getMonthNetWeight()) != 0) {
         return false;
      }

      if (Double.compare(this.getTotalNetWeight(), other.getTotalNetWeight()) != 0) {
         return false;
      }

      Object this$workShopName = this.getWorkShopName();
      Object other$workShopName = other.getWorkShopName();
      return this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWeeklyProductionReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $weeksNetWeight = Double.doubleToLongBits(this.getWeeksNetWeight());
      result = result * 59 + (int)($weeksNetWeight >>> 32 ^ $weeksNetWeight);
      long $monthNetWeight = Double.doubleToLongBits(this.getMonthNetWeight());
      result = result * 59 + (int)($monthNetWeight >>> 32 ^ $monthNetWeight);
      long $totalNetWeight = Double.doubleToLongBits(this.getTotalNetWeight());
      result = result * 59 + (int)($totalNetWeight >>> 32 ^ $totalNetWeight);
      Object $workShopName = this.getWorkShopName();
      return result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
   }
}
