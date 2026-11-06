package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("成本汇总值")
public class CostSummaryValueDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("是否为当月")
   private Boolean boolNowMonth;
   @ApiModelProperty("月成本汇总金额")
   private BigDecimal costMonthTotal;
   @ApiModelProperty("月成本产品产量")
   private BigDecimal productMonthOutput;
   @ApiModelProperty("成本汇总年月份")
   private String yearMonth;
   @ApiModelProperty("是否加权")
   private Boolean boolWeighting;

   public static CostSummaryValueDTO.CostSummaryValueDTOBuilder builder() {
      return new CostSummaryValueDTO.CostSummaryValueDTOBuilder();
   }

   public Boolean getBoolNowMonth() {
      return this.boolNowMonth;
   }

   public BigDecimal getCostMonthTotal() {
      return this.costMonthTotal;
   }

   public BigDecimal getProductMonthOutput() {
      return this.productMonthOutput;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public Boolean getBoolWeighting() {
      return this.boolWeighting;
   }

   public void setBoolNowMonth(final Boolean boolNowMonth) {
      this.boolNowMonth = boolNowMonth;
   }

   public void setCostMonthTotal(final BigDecimal costMonthTotal) {
      this.costMonthTotal = costMonthTotal;
   }

   public void setProductMonthOutput(final BigDecimal productMonthOutput) {
      this.productMonthOutput = productMonthOutput;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setBoolWeighting(final Boolean boolWeighting) {
      this.boolWeighting = boolWeighting;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostSummaryValueDTO)) {
         return false;
      }

      CostSummaryValueDTO other = (CostSummaryValueDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolNowMonth = this.getBoolNowMonth();
      Object other$boolNowMonth = other.getBoolNowMonth();
      if (this$boolNowMonth == null ? other$boolNowMonth == null : this$boolNowMonth.equals(other$boolNowMonth)) {
         Object this$boolWeighting = this.getBoolWeighting();
         Object other$boolWeighting = other.getBoolWeighting();
         if (this$boolWeighting == null ? other$boolWeighting == null : this$boolWeighting.equals(other$boolWeighting)) {
            Object this$costMonthTotal = this.getCostMonthTotal();
            Object other$costMonthTotal = other.getCostMonthTotal();
            if (this$costMonthTotal == null ? other$costMonthTotal == null : this$costMonthTotal.equals(other$costMonthTotal)) {
               Object this$productMonthOutput = this.getProductMonthOutput();
               Object other$productMonthOutput = other.getProductMonthOutput();
               if (this$productMonthOutput == null ? other$productMonthOutput == null : this$productMonthOutput.equals(other$productMonthOutput)) {
                  Object this$yearMonth = this.getYearMonth();
                  Object other$yearMonth = other.getYearMonth();
                  return this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth);
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
      return other instanceof CostSummaryValueDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolNowMonth = this.getBoolNowMonth();
      result = result * 59 + ($boolNowMonth == null ? 43 : $boolNowMonth.hashCode());
      Object $boolWeighting = this.getBoolWeighting();
      result = result * 59 + ($boolWeighting == null ? 43 : $boolWeighting.hashCode());
      Object $costMonthTotal = this.getCostMonthTotal();
      result = result * 59 + ($costMonthTotal == null ? 43 : $costMonthTotal.hashCode());
      Object $productMonthOutput = this.getProductMonthOutput();
      result = result * 59 + ($productMonthOutput == null ? 43 : $productMonthOutput.hashCode());
      Object $yearMonth = this.getYearMonth();
      return result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
   }

   @Override
   public String toString() {
      return "CostSummaryValueDTO(boolNowMonth="
         + this.getBoolNowMonth()
         + ", costMonthTotal="
         + this.getCostMonthTotal()
         + ", productMonthOutput="
         + this.getProductMonthOutput()
         + ", yearMonth="
         + this.getYearMonth()
         + ", boolWeighting="
         + this.getBoolWeighting()
         + ")";
   }

   public CostSummaryValueDTO() {
   }

   public CostSummaryValueDTO(
      final Boolean boolNowMonth, final BigDecimal costMonthTotal, final BigDecimal productMonthOutput, final String yearMonth, final Boolean boolWeighting
   ) {
      this.boolNowMonth = boolNowMonth;
      this.costMonthTotal = costMonthTotal;
      this.productMonthOutput = productMonthOutput;
      this.yearMonth = yearMonth;
      this.boolWeighting = boolWeighting;
   }

   public static class CostSummaryValueDTOBuilder {
      private Boolean boolNowMonth;
      private BigDecimal costMonthTotal;
      private BigDecimal productMonthOutput;
      private String yearMonth;
      private Boolean boolWeighting;

      CostSummaryValueDTOBuilder() {
      }

      public CostSummaryValueDTO.CostSummaryValueDTOBuilder boolNowMonth(final Boolean boolNowMonth) {
         this.boolNowMonth = boolNowMonth;
         return this;
      }

      public CostSummaryValueDTO.CostSummaryValueDTOBuilder costMonthTotal(final BigDecimal costMonthTotal) {
         this.costMonthTotal = costMonthTotal;
         return this;
      }

      public CostSummaryValueDTO.CostSummaryValueDTOBuilder productMonthOutput(final BigDecimal productMonthOutput) {
         this.productMonthOutput = productMonthOutput;
         return this;
      }

      public CostSummaryValueDTO.CostSummaryValueDTOBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      public CostSummaryValueDTO.CostSummaryValueDTOBuilder boolWeighting(final Boolean boolWeighting) {
         this.boolWeighting = boolWeighting;
         return this;
      }

      public CostSummaryValueDTO build() {
         return new CostSummaryValueDTO(this.boolNowMonth, this.costMonthTotal, this.productMonthOutput, this.yearMonth, this.boolWeighting);
      }

      @Override
      public String toString() {
         return "CostSummaryValueDTO.CostSummaryValueDTOBuilder(boolNowMonth="
            + this.boolNowMonth
            + ", costMonthTotal="
            + this.costMonthTotal
            + ", productMonthOutput="
            + this.productMonthOutput
            + ", yearMonth="
            + this.yearMonth
            + ", boolWeighting="
            + this.boolWeighting
            + ")";
      }
   }
}
