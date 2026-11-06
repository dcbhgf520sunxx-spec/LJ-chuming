package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("制造成本-生产人工DTO")
public class ManufactureCostProductionLaborDTO {
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("计量方式")
   private String unit;
   @ApiModelProperty("当月产量")
   private BigDecimal monthlyYield;
   @ApiModelProperty("总额")
   private BigDecimal totalAmount;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getMonthlyYield() {
      return this.monthlyYield;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setMonthlyYield(final BigDecimal monthlyYield) {
      this.monthlyYield = monthlyYield;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManufactureCostProductionLaborDTO)) {
         return false;
      }

      ManufactureCostProductionLaborDTO other = (ManufactureCostProductionLaborDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$yearMonth = this.getYearMonth();
         Object other$yearMonth = other.getYearMonth();
         if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$unit = this.getUnit();
               Object other$unit = other.getUnit();
               if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                  Object this$monthlyYield = this.getMonthlyYield();
                  Object other$monthlyYield = other.getMonthlyYield();
                  if (this$monthlyYield == null ? other$monthlyYield == null : this$monthlyYield.equals(other$monthlyYield)) {
                     Object this$totalAmount = this.getTotalAmount();
                     Object other$totalAmount = other.getTotalAmount();
                     return this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount);
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
      return other instanceof ManufactureCostProductionLaborDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $monthlyYield = this.getMonthlyYield();
      result = result * 59 + ($monthlyYield == null ? 43 : $monthlyYield.hashCode());
      Object $totalAmount = this.getTotalAmount();
      return result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ManufactureCostProductionLaborDTO(yearMonth="
         + this.getYearMonth()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", unit="
         + this.getUnit()
         + ", monthlyYield="
         + this.getMonthlyYield()
         + ", totalAmount="
         + this.getTotalAmount()
         + ")";
   }
}
