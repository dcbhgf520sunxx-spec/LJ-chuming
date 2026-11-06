package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.productionCapacity;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductionCapacityVO {
   @ApiModelProperty(name = "yearTargetProduction", value = "年目标产量")
   private BigDecimal yearTargetProduction;
   @ApiModelProperty(name = "monthProduction", value = "本月产量")
   private BigDecimal monthProduction;
   @ApiModelProperty(name = "prevMonthProduction", value = "上月产量")
   private BigDecimal prevMonthProduction;
   @ApiModelProperty(name = "avgDayProduction", value = "日均产量")
   private BigDecimal avgDayProduction;
   @ApiModelProperty(name = "yearDespatchProduction", value = "本月产量")
   private BigDecimal yearDespatchProduction;
   @ApiModelProperty(name = "productionThanLastRate", value = "本月产量")
   private BigDecimal productionThanLastRate;

   public BigDecimal getYearTargetProduction() {
      return this.yearTargetProduction;
   }

   public BigDecimal getMonthProduction() {
      return this.monthProduction;
   }

   public BigDecimal getPrevMonthProduction() {
      return this.prevMonthProduction;
   }

   public BigDecimal getAvgDayProduction() {
      return this.avgDayProduction;
   }

   public BigDecimal getYearDespatchProduction() {
      return this.yearDespatchProduction;
   }

   public BigDecimal getProductionThanLastRate() {
      return this.productionThanLastRate;
   }

   public void setYearTargetProduction(final BigDecimal yearTargetProduction) {
      this.yearTargetProduction = yearTargetProduction;
   }

   public void setMonthProduction(final BigDecimal monthProduction) {
      this.monthProduction = monthProduction;
   }

   public void setPrevMonthProduction(final BigDecimal prevMonthProduction) {
      this.prevMonthProduction = prevMonthProduction;
   }

   public void setAvgDayProduction(final BigDecimal avgDayProduction) {
      this.avgDayProduction = avgDayProduction;
   }

   public void setYearDespatchProduction(final BigDecimal yearDespatchProduction) {
      this.yearDespatchProduction = yearDespatchProduction;
   }

   public void setProductionThanLastRate(final BigDecimal productionThanLastRate) {
      this.productionThanLastRate = productionThanLastRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionCapacityVO)) {
         return false;
      }

      ProductionCapacityVO other = (ProductionCapacityVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearTargetProduction = this.getYearTargetProduction();
      Object other$yearTargetProduction = other.getYearTargetProduction();
      if (this$yearTargetProduction == null ? other$yearTargetProduction == null : this$yearTargetProduction.equals(other$yearTargetProduction)) {
         Object this$monthProduction = this.getMonthProduction();
         Object other$monthProduction = other.getMonthProduction();
         if (this$monthProduction == null ? other$monthProduction == null : this$monthProduction.equals(other$monthProduction)) {
            Object this$prevMonthProduction = this.getPrevMonthProduction();
            Object other$prevMonthProduction = other.getPrevMonthProduction();
            if (this$prevMonthProduction == null ? other$prevMonthProduction == null : this$prevMonthProduction.equals(other$prevMonthProduction)) {
               Object this$avgDayProduction = this.getAvgDayProduction();
               Object other$avgDayProduction = other.getAvgDayProduction();
               if (this$avgDayProduction == null ? other$avgDayProduction == null : this$avgDayProduction.equals(other$avgDayProduction)) {
                  Object this$yearDespatchProduction = this.getYearDespatchProduction();
                  Object other$yearDespatchProduction = other.getYearDespatchProduction();
                  if (this$yearDespatchProduction == null
                     ? other$yearDespatchProduction == null
                     : this$yearDespatchProduction.equals(other$yearDespatchProduction)) {
                     Object this$productionThanLastRate = this.getProductionThanLastRate();
                     Object other$productionThanLastRate = other.getProductionThanLastRate();
                     return this$productionThanLastRate == null
                        ? other$productionThanLastRate == null
                        : this$productionThanLastRate.equals(other$productionThanLastRate);
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
      return other instanceof ProductionCapacityVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearTargetProduction = this.getYearTargetProduction();
      result = result * 59 + ($yearTargetProduction == null ? 43 : $yearTargetProduction.hashCode());
      Object $monthProduction = this.getMonthProduction();
      result = result * 59 + ($monthProduction == null ? 43 : $monthProduction.hashCode());
      Object $prevMonthProduction = this.getPrevMonthProduction();
      result = result * 59 + ($prevMonthProduction == null ? 43 : $prevMonthProduction.hashCode());
      Object $avgDayProduction = this.getAvgDayProduction();
      result = result * 59 + ($avgDayProduction == null ? 43 : $avgDayProduction.hashCode());
      Object $yearDespatchProduction = this.getYearDespatchProduction();
      result = result * 59 + ($yearDespatchProduction == null ? 43 : $yearDespatchProduction.hashCode());
      Object $productionThanLastRate = this.getProductionThanLastRate();
      return result * 59 + ($productionThanLastRate == null ? 43 : $productionThanLastRate.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionCapacityVO(yearTargetProduction="
         + this.getYearTargetProduction()
         + ", monthProduction="
         + this.getMonthProduction()
         + ", prevMonthProduction="
         + this.getPrevMonthProduction()
         + ", avgDayProduction="
         + this.getAvgDayProduction()
         + ", yearDespatchProduction="
         + this.getYearDespatchProduction()
         + ", productionThanLastRate="
         + this.getProductionThanLastRate()
         + ")";
   }
}
