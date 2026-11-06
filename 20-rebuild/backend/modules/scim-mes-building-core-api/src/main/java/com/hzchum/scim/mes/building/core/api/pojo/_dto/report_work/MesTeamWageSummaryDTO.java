package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("班组工资汇总DTO")
public class MesTeamWageSummaryDTO {
   @ApiModelProperty("车间信息")
   private NameInfo workshop;
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("工序信息")
   private NameInfo process;
   @ApiModelProperty("班组信息")
   private NameInfo team;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("产量")
   private BigDecimal productionQuantity;
   @ApiModelProperty("工价(元)")
   private BigDecimal wage;
   @ApiModelProperty("平均工价(元/吨)")
   private BigDecimal averageWage;
   @ApiModelProperty("开始时间")
   private LocalDateTime startTime;
   @ApiModelProperty("结束时间")
   private LocalDateTime endTime;

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public NameInfo getTeam() {
      return this.team;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getProductionQuantity() {
      return this.productionQuantity;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getAverageWage() {
      return this.averageWage;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProcess(final NameInfo process) {
      this.process = process;
   }

   public void setTeam(final NameInfo team) {
      this.team = team;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setProductionQuantity(final BigDecimal productionQuantity) {
      this.productionQuantity = productionQuantity;
   }

   public void setWage(final BigDecimal wage) {
      this.wage = wage;
   }

   public void setAverageWage(final BigDecimal averageWage) {
      this.averageWage = averageWage;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTeamWageSummaryDTO)) {
         return false;
      }

      MesTeamWageSummaryDTO other = (MesTeamWageSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$workshop = this.getWorkshop();
         Object other$workshop = other.getWorkshop();
         if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$team = this.getTeam();
               Object other$team = other.getTeam();
               if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$productionQuantity = this.getProductionQuantity();
                     Object other$productionQuantity = other.getProductionQuantity();
                     if (this$productionQuantity == null ? other$productionQuantity == null : this$productionQuantity.equals(other$productionQuantity)) {
                        Object this$wage = this.getWage();
                        Object other$wage = other.getWage();
                        if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                           Object this$averageWage = this.getAverageWage();
                           Object other$averageWage = other.getAverageWage();
                           if (this$averageWage == null ? other$averageWage == null : this$averageWage.equals(other$averageWage)) {
                              Object this$startTime = this.getStartTime();
                              Object other$startTime = other.getStartTime();
                              if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                                 Object this$endTime = this.getEndTime();
                                 Object other$endTime = other.getEndTime();
                                 return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof MesTeamWageSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $productionQuantity = this.getProductionQuantity();
      result = result * 59 + ($productionQuantity == null ? 43 : $productionQuantity.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $averageWage = this.getAverageWage();
      result = result * 59 + ($averageWage == null ? 43 : $averageWage.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesTeamWageSummaryDTO(workshop="
         + this.getWorkshop()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", process="
         + this.getProcess()
         + ", team="
         + this.getTeam()
         + ", unit="
         + this.getUnit()
         + ", productionQuantity="
         + this.getProductionQuantity()
         + ", wage="
         + this.getWage()
         + ", averageWage="
         + this.getAverageWage()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ")";
   }
}
