package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目收支分析类")
public class ProjectIncomeExpenseDTO {
   @ApiModelProperty("月份")
   private Integer month;
   @ApiModelProperty("收入金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty("付款金额")
   private BigDecimal paymentAmount;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectIncomeExpenseDTO)) {
         return false;
      }

      ProjectIncomeExpenseDTO other = (ProjectIncomeExpenseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$collectionAmount = this.getCollectionAmount();
         Object other$collectionAmount = other.getCollectionAmount();
         if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
            Object this$paymentAmount = this.getPaymentAmount();
            Object other$paymentAmount = other.getPaymentAmount();
            return this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectIncomeExpenseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      return result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectIncomeExpenseDTO(month="
         + this.getMonth()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ")";
   }
}
