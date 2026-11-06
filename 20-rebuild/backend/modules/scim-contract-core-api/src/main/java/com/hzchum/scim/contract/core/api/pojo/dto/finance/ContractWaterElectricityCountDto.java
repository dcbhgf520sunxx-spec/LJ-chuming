package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "水电费统计响应信息", description = "水电费表相关")
public class ContractWaterElectricityCountDto implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   private Integer month;
   @ApiModelProperty(name = "elementSn", value = "月产(吨)", notes = "月产(吨)")
   private BigDecimal monthOutput;
   @ApiModelProperty(name = "usedElectricityMete", value = "用电度数", notes = "用电度数")
   private BigDecimal usedElectricityMete;
   @ApiModelProperty(name = "electricityPrice", value = "电费(元)", notes = "电费(元)")
   private BigDecimal electricityPrice;
   @ApiModelProperty(name = "usedWaterMete", value = "用电度数", notes = "用电度数")
   private BigDecimal usedWaterMete;
   @ApiModelProperty(name = "waterPrice", value = "水费(元)", notes = "水费(元)")
   private BigDecimal waterPrice;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getMonthOutput() {
      return this.monthOutput;
   }

   public BigDecimal getUsedElectricityMete() {
      return this.usedElectricityMete;
   }

   public BigDecimal getElectricityPrice() {
      return this.electricityPrice;
   }

   public BigDecimal getUsedWaterMete() {
      return this.usedWaterMete;
   }

   public BigDecimal getWaterPrice() {
      return this.waterPrice;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setMonthOutput(final BigDecimal monthOutput) {
      this.monthOutput = monthOutput;
   }

   public void setUsedElectricityMete(final BigDecimal usedElectricityMete) {
      this.usedElectricityMete = usedElectricityMete;
   }

   public void setElectricityPrice(final BigDecimal electricityPrice) {
      this.electricityPrice = electricityPrice;
   }

   public void setUsedWaterMete(final BigDecimal usedWaterMete) {
      this.usedWaterMete = usedWaterMete;
   }

   public void setWaterPrice(final BigDecimal waterPrice) {
      this.waterPrice = waterPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityCountDto)) {
         return false;
      }

      ContractWaterElectricityCountDto other = (ContractWaterElectricityCountDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$monthOutput = this.getMonthOutput();
         Object other$monthOutput = other.getMonthOutput();
         if (this$monthOutput == null ? other$monthOutput == null : this$monthOutput.equals(other$monthOutput)) {
            Object this$usedElectricityMete = this.getUsedElectricityMete();
            Object other$usedElectricityMete = other.getUsedElectricityMete();
            if (this$usedElectricityMete == null ? other$usedElectricityMete == null : this$usedElectricityMete.equals(other$usedElectricityMete)) {
               Object this$electricityPrice = this.getElectricityPrice();
               Object other$electricityPrice = other.getElectricityPrice();
               if (this$electricityPrice == null ? other$electricityPrice == null : this$electricityPrice.equals(other$electricityPrice)) {
                  Object this$usedWaterMete = this.getUsedWaterMete();
                  Object other$usedWaterMete = other.getUsedWaterMete();
                  if (this$usedWaterMete == null ? other$usedWaterMete == null : this$usedWaterMete.equals(other$usedWaterMete)) {
                     Object this$waterPrice = this.getWaterPrice();
                     Object other$waterPrice = other.getWaterPrice();
                     return this$waterPrice == null ? other$waterPrice == null : this$waterPrice.equals(other$waterPrice);
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
      return other instanceof ContractWaterElectricityCountDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $monthOutput = this.getMonthOutput();
      result = result * 59 + ($monthOutput == null ? 43 : $monthOutput.hashCode());
      Object $usedElectricityMete = this.getUsedElectricityMete();
      result = result * 59 + ($usedElectricityMete == null ? 43 : $usedElectricityMete.hashCode());
      Object $electricityPrice = this.getElectricityPrice();
      result = result * 59 + ($electricityPrice == null ? 43 : $electricityPrice.hashCode());
      Object $usedWaterMete = this.getUsedWaterMete();
      result = result * 59 + ($usedWaterMete == null ? 43 : $usedWaterMete.hashCode());
      Object $waterPrice = this.getWaterPrice();
      return result * 59 + ($waterPrice == null ? 43 : $waterPrice.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityCountDto(month="
         + this.getMonth()
         + ", monthOutput="
         + this.getMonthOutput()
         + ", usedElectricityMete="
         + this.getUsedElectricityMete()
         + ", electricityPrice="
         + this.getElectricityPrice()
         + ", usedWaterMete="
         + this.getUsedWaterMete()
         + ", waterPrice="
         + this.getWaterPrice()
         + ")";
   }
}
