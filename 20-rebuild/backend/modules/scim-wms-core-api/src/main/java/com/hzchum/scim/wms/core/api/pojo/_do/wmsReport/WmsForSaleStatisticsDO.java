package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import java.math.BigDecimal;

public class WmsForSaleStatisticsDO {
   private BigDecimal accumulativeDifference;
   private BigDecimal nowYearDifference;
   private BigDecimal nowMonthDifference;
   private BigDecimal lastMonthDifference;
   private BigDecimal differenceMeteSum;
   private BigDecimal profitAmountSum;
   private BigDecimal sellAmountSum;

   public BigDecimal getAccumulativeDifference() {
      return this.accumulativeDifference;
   }

   public BigDecimal getNowYearDifference() {
      return this.nowYearDifference;
   }

   public BigDecimal getNowMonthDifference() {
      return this.nowMonthDifference;
   }

   public BigDecimal getLastMonthDifference() {
      return this.lastMonthDifference;
   }

   public BigDecimal getDifferenceMeteSum() {
      return this.differenceMeteSum;
   }

   public BigDecimal getProfitAmountSum() {
      return this.profitAmountSum;
   }

   public BigDecimal getSellAmountSum() {
      return this.sellAmountSum;
   }

   public void setAccumulativeDifference(final BigDecimal accumulativeDifference) {
      this.accumulativeDifference = accumulativeDifference;
   }

   public void setNowYearDifference(final BigDecimal nowYearDifference) {
      this.nowYearDifference = nowYearDifference;
   }

   public void setNowMonthDifference(final BigDecimal nowMonthDifference) {
      this.nowMonthDifference = nowMonthDifference;
   }

   public void setLastMonthDifference(final BigDecimal lastMonthDifference) {
      this.lastMonthDifference = lastMonthDifference;
   }

   public void setDifferenceMeteSum(final BigDecimal differenceMeteSum) {
      this.differenceMeteSum = differenceMeteSum;
   }

   public void setProfitAmountSum(final BigDecimal profitAmountSum) {
      this.profitAmountSum = profitAmountSum;
   }

   public void setSellAmountSum(final BigDecimal sellAmountSum) {
      this.sellAmountSum = sellAmountSum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsForSaleStatisticsDO)) {
         return false;
      }

      WmsForSaleStatisticsDO other = (WmsForSaleStatisticsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$accumulativeDifference = this.getAccumulativeDifference();
      Object other$accumulativeDifference = other.getAccumulativeDifference();
      if (this$accumulativeDifference == null ? other$accumulativeDifference == null : this$accumulativeDifference.equals(other$accumulativeDifference)) {
         Object this$nowYearDifference = this.getNowYearDifference();
         Object other$nowYearDifference = other.getNowYearDifference();
         if (this$nowYearDifference == null ? other$nowYearDifference == null : this$nowYearDifference.equals(other$nowYearDifference)) {
            Object this$nowMonthDifference = this.getNowMonthDifference();
            Object other$nowMonthDifference = other.getNowMonthDifference();
            if (this$nowMonthDifference == null ? other$nowMonthDifference == null : this$nowMonthDifference.equals(other$nowMonthDifference)) {
               Object this$lastMonthDifference = this.getLastMonthDifference();
               Object other$lastMonthDifference = other.getLastMonthDifference();
               if (this$lastMonthDifference == null ? other$lastMonthDifference == null : this$lastMonthDifference.equals(other$lastMonthDifference)) {
                  Object this$differenceMeteSum = this.getDifferenceMeteSum();
                  Object other$differenceMeteSum = other.getDifferenceMeteSum();
                  if (this$differenceMeteSum == null ? other$differenceMeteSum == null : this$differenceMeteSum.equals(other$differenceMeteSum)) {
                     Object this$profitAmountSum = this.getProfitAmountSum();
                     Object other$profitAmountSum = other.getProfitAmountSum();
                     if (this$profitAmountSum == null ? other$profitAmountSum == null : this$profitAmountSum.equals(other$profitAmountSum)) {
                        Object this$sellAmountSum = this.getSellAmountSum();
                        Object other$sellAmountSum = other.getSellAmountSum();
                        return this$sellAmountSum == null ? other$sellAmountSum == null : this$sellAmountSum.equals(other$sellAmountSum);
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
      return other instanceof WmsForSaleStatisticsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $accumulativeDifference = this.getAccumulativeDifference();
      result = result * 59 + ($accumulativeDifference == null ? 43 : $accumulativeDifference.hashCode());
      Object $nowYearDifference = this.getNowYearDifference();
      result = result * 59 + ($nowYearDifference == null ? 43 : $nowYearDifference.hashCode());
      Object $nowMonthDifference = this.getNowMonthDifference();
      result = result * 59 + ($nowMonthDifference == null ? 43 : $nowMonthDifference.hashCode());
      Object $lastMonthDifference = this.getLastMonthDifference();
      result = result * 59 + ($lastMonthDifference == null ? 43 : $lastMonthDifference.hashCode());
      Object $differenceMeteSum = this.getDifferenceMeteSum();
      result = result * 59 + ($differenceMeteSum == null ? 43 : $differenceMeteSum.hashCode());
      Object $profitAmountSum = this.getProfitAmountSum();
      result = result * 59 + ($profitAmountSum == null ? 43 : $profitAmountSum.hashCode());
      Object $sellAmountSum = this.getSellAmountSum();
      return result * 59 + ($sellAmountSum == null ? 43 : $sellAmountSum.hashCode());
   }

   @Override
   public String toString() {
      return "WmsForSaleStatisticsDO(accumulativeDifference="
         + this.getAccumulativeDifference()
         + ", nowYearDifference="
         + this.getNowYearDifference()
         + ", nowMonthDifference="
         + this.getNowMonthDifference()
         + ", lastMonthDifference="
         + this.getLastMonthDifference()
         + ", differenceMeteSum="
         + this.getDifferenceMeteSum()
         + ", profitAmountSum="
         + this.getProfitAmountSum()
         + ", sellAmountSum="
         + this.getSellAmountSum()
         + ")";
   }
}
