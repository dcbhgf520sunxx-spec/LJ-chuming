package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("班组工资DTO")
public class MesTeamSalaryDTO {
   @ApiModelProperty("车间")
   private ShowInfo workshop;
   @ApiModelProperty("班组")
   private ShowInfo team;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("产量")
   private BigDecimal productionVolume;
   @ApiModelProperty("工资总额(元)")
   private BigDecimal totalSalary;
   @ApiModelProperty("平均工价(元)")
   private BigDecimal averageLaborCost;

   public BigDecimal getAverageLaborCost() {
      return this.averageLaborCost == null && this.getTotalSalary() != null && this.getProductionVolume() != null
         ? this.getTotalSalary().divide(this.getProductionVolume(), 8, 4)
         : this.averageLaborCost;
   }

   public ShowInfo getWorkshop() {
      return this.workshop;
   }

   public ShowInfo getTeam() {
      return this.team;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getProductionVolume() {
      return this.productionVolume;
   }

   public BigDecimal getTotalSalary() {
      return this.totalSalary;
   }

   public void setWorkshop(final ShowInfo workshop) {
      this.workshop = workshop;
   }

   public void setTeam(final ShowInfo team) {
      this.team = team;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setProductionVolume(final BigDecimal productionVolume) {
      this.productionVolume = productionVolume;
   }

   public void setTotalSalary(final BigDecimal totalSalary) {
      this.totalSalary = totalSalary;
   }

   public void setAverageLaborCost(final BigDecimal averageLaborCost) {
      this.averageLaborCost = averageLaborCost;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTeamSalaryDTO)) {
         return false;
      }

      MesTeamSalaryDTO other = (MesTeamSalaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshop = this.getWorkshop();
      Object other$workshop = other.getWorkshop();
      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
         Object this$team = this.getTeam();
         Object other$team = other.getTeam();
         if (this$team == null ? other$team == null : this$team.equals(other$team)) {
            Object this$unit = this.getUnit();
            Object other$unit = other.getUnit();
            if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
               Object this$productionVolume = this.getProductionVolume();
               Object other$productionVolume = other.getProductionVolume();
               if (this$productionVolume == null ? other$productionVolume == null : this$productionVolume.equals(other$productionVolume)) {
                  Object this$totalSalary = this.getTotalSalary();
                  Object other$totalSalary = other.getTotalSalary();
                  if (this$totalSalary == null ? other$totalSalary == null : this$totalSalary.equals(other$totalSalary)) {
                     Object this$averageLaborCost = this.getAverageLaborCost();
                     Object other$averageLaborCost = other.getAverageLaborCost();
                     return this$averageLaborCost == null ? other$averageLaborCost == null : this$averageLaborCost.equals(other$averageLaborCost);
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
      return other instanceof MesTeamSalaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $productionVolume = this.getProductionVolume();
      result = result * 59 + ($productionVolume == null ? 43 : $productionVolume.hashCode());
      Object $totalSalary = this.getTotalSalary();
      result = result * 59 + ($totalSalary == null ? 43 : $totalSalary.hashCode());
      Object $averageLaborCost = this.getAverageLaborCost();
      return result * 59 + ($averageLaborCost == null ? 43 : $averageLaborCost.hashCode());
   }

   @Override
   public String toString() {
      return "MesTeamSalaryDTO(workshop="
         + this.getWorkshop()
         + ", team="
         + this.getTeam()
         + ", unit="
         + this.getUnit()
         + ", productionVolume="
         + this.getProductionVolume()
         + ", totalSalary="
         + this.getTotalSalary()
         + ", averageLaborCost="
         + this.getAverageLaborCost()
         + ")";
   }
}
