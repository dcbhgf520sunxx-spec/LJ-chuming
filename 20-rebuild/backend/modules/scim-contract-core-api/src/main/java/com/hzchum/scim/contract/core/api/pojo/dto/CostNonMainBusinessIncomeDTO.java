package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("非主营业务收入")
public class CostNonMainBusinessIncomeDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("总产量（吨）")
   private BigDecimal totalOutput;
   @ApiModelProperty("项目产量（吨）")
   private BigDecimal projectOutput;
   @ApiModelProperty("项目产量占比")
   private BigDecimal projectOutputRatio;
   @ApiModelProperty("废料出售（元）")
   private BigDecimal wasteSale;
   @ApiModelProperty("摊销金额（元/吨）")
   private BigDecimal amortizationAmount;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getTotalOutput() {
      return this.totalOutput;
   }

   public BigDecimal getProjectOutput() {
      return this.projectOutput;
   }

   public BigDecimal getProjectOutputRatio() {
      return this.projectOutputRatio;
   }

   public BigDecimal getWasteSale() {
      return this.wasteSale;
   }

   public BigDecimal getAmortizationAmount() {
      return this.amortizationAmount;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setTotalOutput(final BigDecimal totalOutput) {
      this.totalOutput = totalOutput;
   }

   public void setProjectOutput(final BigDecimal projectOutput) {
      this.projectOutput = projectOutput;
   }

   public void setProjectOutputRatio(final BigDecimal projectOutputRatio) {
      this.projectOutputRatio = projectOutputRatio;
   }

   public void setWasteSale(final BigDecimal wasteSale) {
      this.wasteSale = wasteSale;
   }

   public void setAmortizationAmount(final BigDecimal amortizationAmount) {
      this.amortizationAmount = amortizationAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostNonMainBusinessIncomeDTO)) {
         return false;
      }

      CostNonMainBusinessIncomeDTO other = (CostNonMainBusinessIncomeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$totalOutput = this.getTotalOutput();
         Object other$totalOutput = other.getTotalOutput();
         if (this$totalOutput == null ? other$totalOutput == null : this$totalOutput.equals(other$totalOutput)) {
            Object this$projectOutput = this.getProjectOutput();
            Object other$projectOutput = other.getProjectOutput();
            if (this$projectOutput == null ? other$projectOutput == null : this$projectOutput.equals(other$projectOutput)) {
               Object this$projectOutputRatio = this.getProjectOutputRatio();
               Object other$projectOutputRatio = other.getProjectOutputRatio();
               if (this$projectOutputRatio == null ? other$projectOutputRatio == null : this$projectOutputRatio.equals(other$projectOutputRatio)) {
                  Object this$wasteSale = this.getWasteSale();
                  Object other$wasteSale = other.getWasteSale();
                  if (this$wasteSale == null ? other$wasteSale == null : this$wasteSale.equals(other$wasteSale)) {
                     Object this$amortizationAmount = this.getAmortizationAmount();
                     Object other$amortizationAmount = other.getAmortizationAmount();
                     return this$amortizationAmount == null ? other$amortizationAmount == null : this$amortizationAmount.equals(other$amortizationAmount);
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
      return other instanceof CostNonMainBusinessIncomeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $totalOutput = this.getTotalOutput();
      result = result * 59 + ($totalOutput == null ? 43 : $totalOutput.hashCode());
      Object $projectOutput = this.getProjectOutput();
      result = result * 59 + ($projectOutput == null ? 43 : $projectOutput.hashCode());
      Object $projectOutputRatio = this.getProjectOutputRatio();
      result = result * 59 + ($projectOutputRatio == null ? 43 : $projectOutputRatio.hashCode());
      Object $wasteSale = this.getWasteSale();
      result = result * 59 + ($wasteSale == null ? 43 : $wasteSale.hashCode());
      Object $amortizationAmount = this.getAmortizationAmount();
      return result * 59 + ($amortizationAmount == null ? 43 : $amortizationAmount.hashCode());
   }

   @Override
   public String toString() {
      return "CostNonMainBusinessIncomeDTO(yearMonth="
         + this.getYearMonth()
         + ", totalOutput="
         + this.getTotalOutput()
         + ", projectOutput="
         + this.getProjectOutput()
         + ", projectOutputRatio="
         + this.getProjectOutputRatio()
         + ", wasteSale="
         + this.getWasteSale()
         + ", amortizationAmount="
         + this.getAmortizationAmount()
         + ")";
   }

   public CostNonMainBusinessIncomeDTO() {
   }

   public CostNonMainBusinessIncomeDTO(
      final String yearMonth,
      final BigDecimal totalOutput,
      final BigDecimal projectOutput,
      final BigDecimal projectOutputRatio,
      final BigDecimal wasteSale,
      final BigDecimal amortizationAmount
   ) {
      this.yearMonth = yearMonth;
      this.totalOutput = totalOutput;
      this.projectOutput = projectOutput;
      this.projectOutputRatio = projectOutputRatio;
      this.wasteSale = wasteSale;
      this.amortizationAmount = amortizationAmount;
   }
}
