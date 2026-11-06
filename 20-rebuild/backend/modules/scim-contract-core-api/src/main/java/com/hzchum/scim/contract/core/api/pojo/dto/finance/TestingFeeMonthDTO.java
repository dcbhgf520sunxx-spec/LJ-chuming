package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ContractTestingFee对象", description = "检测费汇总dto ")
public class TestingFeeMonthDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   private Integer month;
   @ApiModelProperty(name = "feeAmount", value = "费用(元)", notes = "费用(元)")
   private BigDecimal feeAmount;

   public static TestingFeeMonthDTO.TestingFeeMonthDTOBuilder builder() {
      return new TestingFeeMonthDTO.TestingFeeMonthDTOBuilder();
   }

   public TestingFeeMonthDTO() {
   }

   public TestingFeeMonthDTO(final Integer month, final BigDecimal feeAmount) {
      this.month = month;
      this.feeAmount = feeAmount;
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getFeeAmount() {
      return this.feeAmount;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TestingFeeMonthDTO)) {
         return false;
      } else {
         TestingFeeMonthDTO other = (TestingFeeMonthDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$feeAmount = this.getFeeAmount();
               Object other$feeAmount = other.getFeeAmount();
               return this$feeAmount == null ? other$feeAmount == null : this$feeAmount.equals(other$feeAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TestingFeeMonthDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $feeAmount = this.getFeeAmount();
      return result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
   }

   @Override
   public String toString() {
      return "TestingFeeMonthDTO(month=" + this.getMonth() + ", feeAmount=" + this.getFeeAmount() + ")";
   }

   public static class TestingFeeMonthDTOBuilder {
      private Integer month;
      private BigDecimal feeAmount;

      TestingFeeMonthDTOBuilder() {
      }

      public TestingFeeMonthDTO.TestingFeeMonthDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public TestingFeeMonthDTO.TestingFeeMonthDTOBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public TestingFeeMonthDTO build() {
         return new TestingFeeMonthDTO(this.month, this.feeAmount);
      }

      @Override
      public String toString() {
         return "TestingFeeMonthDTO.TestingFeeMonthDTOBuilder(month=" + this.month + ", feeAmount=" + this.feeAmount + ")";
      }
   }
}
