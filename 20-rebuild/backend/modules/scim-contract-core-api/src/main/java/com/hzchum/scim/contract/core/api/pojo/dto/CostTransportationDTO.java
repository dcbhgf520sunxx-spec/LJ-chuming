package com.hzchum.scim.contract.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ExcelTarget("transportationCost")
@ApiModel("运输费")
public class CostTransportationDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("运输量（吨）")
   private BigDecimal transportAmount;
   @ApiModelProperty("运输费总额（元）")
   @Excel(name = "运输费总额（元）", orderNum = "1")
   private BigDecimal costMonthTotal;
   @ApiModelProperty("运输费单价（元/吨）")
   private BigDecimal transportCostPerTon;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getTransportAmount() {
      return this.transportAmount;
   }

   public BigDecimal getCostMonthTotal() {
      return this.costMonthTotal;
   }

   public BigDecimal getTransportCostPerTon() {
      return this.transportCostPerTon;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setTransportAmount(final BigDecimal transportAmount) {
      this.transportAmount = transportAmount;
   }

   public void setCostMonthTotal(final BigDecimal costMonthTotal) {
      this.costMonthTotal = costMonthTotal;
   }

   public void setTransportCostPerTon(final BigDecimal transportCostPerTon) {
      this.transportCostPerTon = transportCostPerTon;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostTransportationDTO)) {
         return false;
      }

      CostTransportationDTO other = (CostTransportationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$transportAmount = this.getTransportAmount();
         Object other$transportAmount = other.getTransportAmount();
         if (this$transportAmount == null ? other$transportAmount == null : this$transportAmount.equals(other$transportAmount)) {
            Object this$costMonthTotal = this.getCostMonthTotal();
            Object other$costMonthTotal = other.getCostMonthTotal();
            if (this$costMonthTotal == null ? other$costMonthTotal == null : this$costMonthTotal.equals(other$costMonthTotal)) {
               Object this$transportCostPerTon = this.getTransportCostPerTon();
               Object other$transportCostPerTon = other.getTransportCostPerTon();
               return this$transportCostPerTon == null ? other$transportCostPerTon == null : this$transportCostPerTon.equals(other$transportCostPerTon);
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
      return other instanceof CostTransportationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $transportAmount = this.getTransportAmount();
      result = result * 59 + ($transportAmount == null ? 43 : $transportAmount.hashCode());
      Object $costMonthTotal = this.getCostMonthTotal();
      result = result * 59 + ($costMonthTotal == null ? 43 : $costMonthTotal.hashCode());
      Object $transportCostPerTon = this.getTransportCostPerTon();
      return result * 59 + ($transportCostPerTon == null ? 43 : $transportCostPerTon.hashCode());
   }

   @Override
   public String toString() {
      return "CostTransportationDTO(yearMonth="
         + this.getYearMonth()
         + ", transportAmount="
         + this.getTransportAmount()
         + ", costMonthTotal="
         + this.getCostMonthTotal()
         + ", transportCostPerTon="
         + this.getTransportCostPerTon()
         + ")";
   }

   public CostTransportationDTO() {
   }

   public CostTransportationDTO(final String yearMonth, final BigDecimal transportAmount, final BigDecimal costMonthTotal, final BigDecimal transportCostPerTon) {
      this.yearMonth = yearMonth;
      this.transportAmount = transportAmount;
      this.costMonthTotal = costMonthTotal;
      this.transportCostPerTon = transportCostPerTon;
   }
}
