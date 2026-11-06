package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("月份-金额")
public class MonthAmountInfo {
   @ApiModelProperty("月份")
   private Integer month;
   @ApiModelProperty("金额")
   private BigDecimal amount;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonthAmountInfo)) {
         return false;
      } else {
         MonthAmountInfo other = (MonthAmountInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthAmountInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "MonthAmountInfo(month=" + this.getMonth() + ", amount=" + this.getAmount() + ")";
   }
}
