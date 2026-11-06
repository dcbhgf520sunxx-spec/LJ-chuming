package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "制造成本统计-期间直接成本费用/期间摊销成本费用")
public class ReimbursementCostDTO {
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("总产量(吨)")
   private BigDecimal totalYield;
   @ApiModelProperty("项目产量(吨)")
   private BigDecimal projectYield;
   @ApiModelProperty("占比")
   private BigDecimal proportion;
   @ApiModelProperty("水电/物业费总金额(元)")
   private BigDecimal totalFee;
   @ApiModelProperty("摊销金额(元)")
   private BigDecimal amortizationAmount;
   @ApiModelProperty("吨单价(元/吨)")
   private BigDecimal tonUnitPrice;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getTotalYield() {
      return this.totalYield;
   }

   public BigDecimal getProjectYield() {
      return this.projectYield;
   }

   public BigDecimal getProportion() {
      return this.proportion;
   }

   public BigDecimal getTotalFee() {
      return this.totalFee;
   }

   public BigDecimal getAmortizationAmount() {
      return this.amortizationAmount;
   }

   public BigDecimal getTonUnitPrice() {
      return this.tonUnitPrice;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setTotalYield(final BigDecimal totalYield) {
      this.totalYield = totalYield;
   }

   public void setProjectYield(final BigDecimal projectYield) {
      this.projectYield = projectYield;
   }

   public void setProportion(final BigDecimal proportion) {
      this.proportion = proportion;
   }

   public void setTotalFee(final BigDecimal totalFee) {
      this.totalFee = totalFee;
   }

   public void setAmortizationAmount(final BigDecimal amortizationAmount) {
      this.amortizationAmount = amortizationAmount;
   }

   public void setTonUnitPrice(final BigDecimal tonUnitPrice) {
      this.tonUnitPrice = tonUnitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementCostDTO)) {
         return false;
      }

      ReimbursementCostDTO other = (ReimbursementCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$totalYield = this.getTotalYield();
         Object other$totalYield = other.getTotalYield();
         if (this$totalYield == null ? other$totalYield == null : this$totalYield.equals(other$totalYield)) {
            Object this$projectYield = this.getProjectYield();
            Object other$projectYield = other.getProjectYield();
            if (this$projectYield == null ? other$projectYield == null : this$projectYield.equals(other$projectYield)) {
               Object this$proportion = this.getProportion();
               Object other$proportion = other.getProportion();
               if (this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion)) {
                  Object this$totalFee = this.getTotalFee();
                  Object other$totalFee = other.getTotalFee();
                  if (this$totalFee == null ? other$totalFee == null : this$totalFee.equals(other$totalFee)) {
                     Object this$amortizationAmount = this.getAmortizationAmount();
                     Object other$amortizationAmount = other.getAmortizationAmount();
                     if (this$amortizationAmount == null ? other$amortizationAmount == null : this$amortizationAmount.equals(other$amortizationAmount)) {
                        Object this$tonUnitPrice = this.getTonUnitPrice();
                        Object other$tonUnitPrice = other.getTonUnitPrice();
                        return this$tonUnitPrice == null ? other$tonUnitPrice == null : this$tonUnitPrice.equals(other$tonUnitPrice);
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
      return other instanceof ReimbursementCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $totalYield = this.getTotalYield();
      result = result * 59 + ($totalYield == null ? 43 : $totalYield.hashCode());
      Object $projectYield = this.getProjectYield();
      result = result * 59 + ($projectYield == null ? 43 : $projectYield.hashCode());
      Object $proportion = this.getProportion();
      result = result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
      Object $totalFee = this.getTotalFee();
      result = result * 59 + ($totalFee == null ? 43 : $totalFee.hashCode());
      Object $amortizationAmount = this.getAmortizationAmount();
      result = result * 59 + ($amortizationAmount == null ? 43 : $amortizationAmount.hashCode());
      Object $tonUnitPrice = this.getTonUnitPrice();
      return result * 59 + ($tonUnitPrice == null ? 43 : $tonUnitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementCostDTO(yearMonth="
         + this.getYearMonth()
         + ", totalYield="
         + this.getTotalYield()
         + ", projectYield="
         + this.getProjectYield()
         + ", proportion="
         + this.getProportion()
         + ", totalFee="
         + this.getTotalFee()
         + ", amortizationAmount="
         + this.getAmortizationAmount()
         + ", tonUnitPrice="
         + this.getTonUnitPrice()
         + ")";
   }
}
