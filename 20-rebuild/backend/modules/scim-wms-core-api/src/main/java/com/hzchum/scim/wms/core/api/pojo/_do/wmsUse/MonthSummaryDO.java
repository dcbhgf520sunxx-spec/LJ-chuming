package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import java.math.BigDecimal;

public class MonthSummaryDO {
   private Integer date;
   private BigDecimal mete;
   private BigDecimal amount;

   public static MonthSummaryDO.MonthSummaryDOBuilder builder() {
      return new MonthSummaryDO.MonthSummaryDOBuilder();
   }

   public Integer getDate() {
      return this.date;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setDate(final Integer date) {
      this.date = date;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthSummaryDO)) {
         return false;
      }

      MonthSummaryDO other = (MonthSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "MonthSummaryDO(date=" + this.getDate() + ", mete=" + this.getMete() + ", amount=" + this.getAmount() + ")";
   }

   public MonthSummaryDO(final Integer date, final BigDecimal mete, final BigDecimal amount) {
      this.date = date;
      this.mete = mete;
      this.amount = amount;
   }

   public MonthSummaryDO() {
   }

   public static class MonthSummaryDOBuilder {
      private Integer date;
      private BigDecimal mete;
      private BigDecimal amount;

      MonthSummaryDOBuilder() {
      }

      public MonthSummaryDO.MonthSummaryDOBuilder date(final Integer date) {
         this.date = date;
         return this;
      }

      public MonthSummaryDO.MonthSummaryDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MonthSummaryDO.MonthSummaryDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MonthSummaryDO build() {
         return new MonthSummaryDO(this.date, this.mete, this.amount);
      }

      @Override
      public String toString() {
         return "MonthSummaryDO.MonthSummaryDOBuilder(date=" + this.date + ", mete=" + this.mete + ", amount=" + this.amount + ")";
      }
   }
}
