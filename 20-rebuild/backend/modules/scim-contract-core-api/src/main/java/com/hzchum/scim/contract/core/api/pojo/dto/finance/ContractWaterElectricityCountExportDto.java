package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "运营分析-水电费统计-导出实体", description = "水电费表相关")
@ExcelTarget("ContractWaterElectricityCountDto")
public class ContractWaterElectricityCountExportDto implements Serializable {
   private static final long serialVersionUID = 1L;
   @Excel(name = "月份", orderNum = "1", width = 15.0)
   private String month;
   @Excel(name = "月产(吨)", orderNum = "2", width = 15.0)
   private BigDecimal monthOutput;
   @Excel(name = "用电度数", orderNum = "3", width = 15.0)
   private BigDecimal usedElectricityMete;
   @Excel(name = "均价(元/度)", orderNum = "4", width = 15.0)
   private BigDecimal electricityAvgPrice;
   @Excel(name = "电费(元)", orderNum = "5", width = 15.0)
   private BigDecimal electricityPrice;
   @Excel(name = "折合电费(元/吨)", orderNum = "6", width = 15.0)
   private BigDecimal convertElectricityPrice;
   @Excel(name = "用水量(吨)", orderNum = "7", width = 15.0)
   private BigDecimal usedWaterMete;
   @Excel(name = "均价(元/吨)", orderNum = "8", width = 15.0)
   private BigDecimal waterAvgPrice;
   @Excel(name = "水费(元)", orderNum = "9", width = 15.0)
   private BigDecimal waterPrice;
   @Excel(name = "折合水费(元/吨)", orderNum = "10", width = 15.0)
   private BigDecimal convertWaterPrice;

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getMonthOutput() {
      return this.monthOutput;
   }

   public BigDecimal getUsedElectricityMete() {
      return this.usedElectricityMete;
   }

   public BigDecimal getElectricityAvgPrice() {
      return this.electricityAvgPrice;
   }

   public BigDecimal getElectricityPrice() {
      return this.electricityPrice;
   }

   public BigDecimal getConvertElectricityPrice() {
      return this.convertElectricityPrice;
   }

   public BigDecimal getUsedWaterMete() {
      return this.usedWaterMete;
   }

   public BigDecimal getWaterAvgPrice() {
      return this.waterAvgPrice;
   }

   public BigDecimal getWaterPrice() {
      return this.waterPrice;
   }

   public BigDecimal getConvertWaterPrice() {
      return this.convertWaterPrice;
   }

   public void setMonth(final String month) {
      this.month = month;
   }

   public void setMonthOutput(final BigDecimal monthOutput) {
      this.monthOutput = monthOutput;
   }

   public void setUsedElectricityMete(final BigDecimal usedElectricityMete) {
      this.usedElectricityMete = usedElectricityMete;
   }

   public void setElectricityAvgPrice(final BigDecimal electricityAvgPrice) {
      this.electricityAvgPrice = electricityAvgPrice;
   }

   public void setElectricityPrice(final BigDecimal electricityPrice) {
      this.electricityPrice = electricityPrice;
   }

   public void setConvertElectricityPrice(final BigDecimal convertElectricityPrice) {
      this.convertElectricityPrice = convertElectricityPrice;
   }

   public void setUsedWaterMete(final BigDecimal usedWaterMete) {
      this.usedWaterMete = usedWaterMete;
   }

   public void setWaterAvgPrice(final BigDecimal waterAvgPrice) {
      this.waterAvgPrice = waterAvgPrice;
   }

   public void setWaterPrice(final BigDecimal waterPrice) {
      this.waterPrice = waterPrice;
   }

   public void setConvertWaterPrice(final BigDecimal convertWaterPrice) {
      this.convertWaterPrice = convertWaterPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityCountExportDto)) {
         return false;
      }

      ContractWaterElectricityCountExportDto other = (ContractWaterElectricityCountExportDto)o;
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
               Object this$electricityAvgPrice = this.getElectricityAvgPrice();
               Object other$electricityAvgPrice = other.getElectricityAvgPrice();
               if (this$electricityAvgPrice == null ? other$electricityAvgPrice == null : this$electricityAvgPrice.equals(other$electricityAvgPrice)) {
                  Object this$electricityPrice = this.getElectricityPrice();
                  Object other$electricityPrice = other.getElectricityPrice();
                  if (this$electricityPrice == null ? other$electricityPrice == null : this$electricityPrice.equals(other$electricityPrice)) {
                     Object this$convertElectricityPrice = this.getConvertElectricityPrice();
                     Object other$convertElectricityPrice = other.getConvertElectricityPrice();
                     if (this$convertElectricityPrice == null
                        ? other$convertElectricityPrice == null
                        : this$convertElectricityPrice.equals(other$convertElectricityPrice)) {
                        Object this$usedWaterMete = this.getUsedWaterMete();
                        Object other$usedWaterMete = other.getUsedWaterMete();
                        if (this$usedWaterMete == null ? other$usedWaterMete == null : this$usedWaterMete.equals(other$usedWaterMete)) {
                           Object this$waterAvgPrice = this.getWaterAvgPrice();
                           Object other$waterAvgPrice = other.getWaterAvgPrice();
                           if (this$waterAvgPrice == null ? other$waterAvgPrice == null : this$waterAvgPrice.equals(other$waterAvgPrice)) {
                              Object this$waterPrice = this.getWaterPrice();
                              Object other$waterPrice = other.getWaterPrice();
                              if (this$waterPrice == null ? other$waterPrice == null : this$waterPrice.equals(other$waterPrice)) {
                                 Object this$convertWaterPrice = this.getConvertWaterPrice();
                                 Object other$convertWaterPrice = other.getConvertWaterPrice();
                                 return this$convertWaterPrice == null
                                    ? other$convertWaterPrice == null
                                    : this$convertWaterPrice.equals(other$convertWaterPrice);
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
      return other instanceof ContractWaterElectricityCountExportDto;
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
      Object $electricityAvgPrice = this.getElectricityAvgPrice();
      result = result * 59 + ($electricityAvgPrice == null ? 43 : $electricityAvgPrice.hashCode());
      Object $electricityPrice = this.getElectricityPrice();
      result = result * 59 + ($electricityPrice == null ? 43 : $electricityPrice.hashCode());
      Object $convertElectricityPrice = this.getConvertElectricityPrice();
      result = result * 59 + ($convertElectricityPrice == null ? 43 : $convertElectricityPrice.hashCode());
      Object $usedWaterMete = this.getUsedWaterMete();
      result = result * 59 + ($usedWaterMete == null ? 43 : $usedWaterMete.hashCode());
      Object $waterAvgPrice = this.getWaterAvgPrice();
      result = result * 59 + ($waterAvgPrice == null ? 43 : $waterAvgPrice.hashCode());
      Object $waterPrice = this.getWaterPrice();
      result = result * 59 + ($waterPrice == null ? 43 : $waterPrice.hashCode());
      Object $convertWaterPrice = this.getConvertWaterPrice();
      return result * 59 + ($convertWaterPrice == null ? 43 : $convertWaterPrice.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityCountExportDto(month="
         + this.getMonth()
         + ", monthOutput="
         + this.getMonthOutput()
         + ", usedElectricityMete="
         + this.getUsedElectricityMete()
         + ", electricityAvgPrice="
         + this.getElectricityAvgPrice()
         + ", electricityPrice="
         + this.getElectricityPrice()
         + ", convertElectricityPrice="
         + this.getConvertElectricityPrice()
         + ", usedWaterMete="
         + this.getUsedWaterMete()
         + ", waterAvgPrice="
         + this.getWaterAvgPrice()
         + ", waterPrice="
         + this.getWaterPrice()
         + ", convertWaterPrice="
         + this.getConvertWaterPrice()
         + ")";
   }
}
