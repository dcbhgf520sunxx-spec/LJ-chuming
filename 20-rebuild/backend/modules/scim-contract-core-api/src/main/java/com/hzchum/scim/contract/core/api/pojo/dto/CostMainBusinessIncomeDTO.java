package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("主营业务收入")
public class CostMainBusinessIncomeDTO {
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("结构发运量(吨)")
   private BigDecimal totalOutputArtifact;
   @ApiModelProperty("围护发运量(m)")
   private BigDecimal totalOutputEnclosure;
   @ApiModelProperty("配套制品发运量")
   private BigDecimal totalOutputStandard;
   @ApiModelProperty("发运额（元）")
   private BigDecimal totalAmount;
   @ApiModelProperty("当月收入（元）")
   private BigDecimal income;
   @ApiModelProperty("签证费（元）")
   private BigDecimal visaFee;
   @ApiModelProperty("预收额（元）")
   private BigDecimal advancePayment;
   @ApiModelProperty("合计")
   private BigDecimal total;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getTotalOutputArtifact() {
      return this.totalOutputArtifact;
   }

   public BigDecimal getTotalOutputEnclosure() {
      return this.totalOutputEnclosure;
   }

   public BigDecimal getTotalOutputStandard() {
      return this.totalOutputStandard;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public BigDecimal getVisaFee() {
      return this.visaFee;
   }

   public BigDecimal getAdvancePayment() {
      return this.advancePayment;
   }

   public BigDecimal getTotal() {
      return this.total;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setTotalOutputArtifact(final BigDecimal totalOutputArtifact) {
      this.totalOutputArtifact = totalOutputArtifact;
   }

   public void setTotalOutputEnclosure(final BigDecimal totalOutputEnclosure) {
      this.totalOutputEnclosure = totalOutputEnclosure;
   }

   public void setTotalOutputStandard(final BigDecimal totalOutputStandard) {
      this.totalOutputStandard = totalOutputStandard;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setIncome(final BigDecimal income) {
      this.income = income;
   }

   public void setVisaFee(final BigDecimal visaFee) {
      this.visaFee = visaFee;
   }

   public void setAdvancePayment(final BigDecimal advancePayment) {
      this.advancePayment = advancePayment;
   }

   public void setTotal(final BigDecimal total) {
      this.total = total;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostMainBusinessIncomeDTO)) {
         return false;
      }

      CostMainBusinessIncomeDTO other = (CostMainBusinessIncomeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$totalOutputArtifact = this.getTotalOutputArtifact();
         Object other$totalOutputArtifact = other.getTotalOutputArtifact();
         if (this$totalOutputArtifact == null ? other$totalOutputArtifact == null : this$totalOutputArtifact.equals(other$totalOutputArtifact)) {
            Object this$totalOutputEnclosure = this.getTotalOutputEnclosure();
            Object other$totalOutputEnclosure = other.getTotalOutputEnclosure();
            if (this$totalOutputEnclosure == null ? other$totalOutputEnclosure == null : this$totalOutputEnclosure.equals(other$totalOutputEnclosure)) {
               Object this$totalOutputStandard = this.getTotalOutputStandard();
               Object other$totalOutputStandard = other.getTotalOutputStandard();
               if (this$totalOutputStandard == null ? other$totalOutputStandard == null : this$totalOutputStandard.equals(other$totalOutputStandard)) {
                  Object this$totalAmount = this.getTotalAmount();
                  Object other$totalAmount = other.getTotalAmount();
                  if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                     Object this$income = this.getIncome();
                     Object other$income = other.getIncome();
                     if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                        Object this$visaFee = this.getVisaFee();
                        Object other$visaFee = other.getVisaFee();
                        if (this$visaFee == null ? other$visaFee == null : this$visaFee.equals(other$visaFee)) {
                           Object this$advancePayment = this.getAdvancePayment();
                           Object other$advancePayment = other.getAdvancePayment();
                           if (this$advancePayment == null ? other$advancePayment == null : this$advancePayment.equals(other$advancePayment)) {
                              Object this$total = this.getTotal();
                              Object other$total = other.getTotal();
                              return this$total == null ? other$total == null : this$total.equals(other$total);
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
      return other instanceof CostMainBusinessIncomeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $totalOutputArtifact = this.getTotalOutputArtifact();
      result = result * 59 + ($totalOutputArtifact == null ? 43 : $totalOutputArtifact.hashCode());
      Object $totalOutputEnclosure = this.getTotalOutputEnclosure();
      result = result * 59 + ($totalOutputEnclosure == null ? 43 : $totalOutputEnclosure.hashCode());
      Object $totalOutputStandard = this.getTotalOutputStandard();
      result = result * 59 + ($totalOutputStandard == null ? 43 : $totalOutputStandard.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $visaFee = this.getVisaFee();
      result = result * 59 + ($visaFee == null ? 43 : $visaFee.hashCode());
      Object $advancePayment = this.getAdvancePayment();
      result = result * 59 + ($advancePayment == null ? 43 : $advancePayment.hashCode());
      Object $total = this.getTotal();
      return result * 59 + ($total == null ? 43 : $total.hashCode());
   }

   @Override
   public String toString() {
      return "CostMainBusinessIncomeDTO(yearMonth="
         + this.getYearMonth()
         + ", totalOutputArtifact="
         + this.getTotalOutputArtifact()
         + ", totalOutputEnclosure="
         + this.getTotalOutputEnclosure()
         + ", totalOutputStandard="
         + this.getTotalOutputStandard()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", income="
         + this.getIncome()
         + ", visaFee="
         + this.getVisaFee()
         + ", advancePayment="
         + this.getAdvancePayment()
         + ", total="
         + this.getTotal()
         + ")";
   }

   public CostMainBusinessIncomeDTO() {
   }

   public CostMainBusinessIncomeDTO(
      final String yearMonth,
      final BigDecimal totalOutputArtifact,
      final BigDecimal totalOutputEnclosure,
      final BigDecimal totalOutputStandard,
      final BigDecimal totalAmount,
      final BigDecimal income,
      final BigDecimal visaFee,
      final BigDecimal advancePayment,
      final BigDecimal total
   ) {
      this.yearMonth = yearMonth;
      this.totalOutputArtifact = totalOutputArtifact;
      this.totalOutputEnclosure = totalOutputEnclosure;
      this.totalOutputStandard = totalOutputStandard;
      this.totalAmount = totalAmount;
      this.income = income;
      this.visaFee = visaFee;
      this.advancePayment = advancePayment;
      this.total = total;
   }
}
