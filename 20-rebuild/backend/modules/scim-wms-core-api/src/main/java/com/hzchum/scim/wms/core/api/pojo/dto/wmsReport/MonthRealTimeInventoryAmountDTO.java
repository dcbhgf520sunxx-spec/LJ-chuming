package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class MonthRealTimeInventoryAmountDTO {
   private String basicClass;
   private BigDecimal amount;
   private BigDecimal compareLastMonth;

   public static MonthRealTimeInventoryAmountDTO.MonthRealTimeInventoryAmountDTOBuilder builder() {
      return new MonthRealTimeInventoryAmountDTO.MonthRealTimeInventoryAmountDTOBuilder();
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getCompareLastMonth() {
      return this.compareLastMonth;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setCompareLastMonth(final BigDecimal compareLastMonth) {
      this.compareLastMonth = compareLastMonth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthRealTimeInventoryAmountDTO)) {
         return false;
      }

      MonthRealTimeInventoryAmountDTO other = (MonthRealTimeInventoryAmountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$amount = this.getAmount();
         Object other$amount = other.getAmount();
         if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
            Object this$compareLastMonth = this.getCompareLastMonth();
            Object other$compareLastMonth = other.getCompareLastMonth();
            return this$compareLastMonth == null ? other$compareLastMonth == null : this$compareLastMonth.equals(other$compareLastMonth);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthRealTimeInventoryAmountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $compareLastMonth = this.getCompareLastMonth();
      return result * 59 + ($compareLastMonth == null ? 43 : $compareLastMonth.hashCode());
   }

   @Override
   public String toString() {
      return "MonthRealTimeInventoryAmountDTO(basicClass="
         + this.getBasicClass()
         + ", amount="
         + this.getAmount()
         + ", compareLastMonth="
         + this.getCompareLastMonth()
         + ")";
   }

   public MonthRealTimeInventoryAmountDTO(final String basicClass, final BigDecimal amount, final BigDecimal compareLastMonth) {
      this.basicClass = basicClass;
      this.amount = amount;
      this.compareLastMonth = compareLastMonth;
   }

   public MonthRealTimeInventoryAmountDTO() {
   }

   public static class MonthRealTimeInventoryAmountDTOBuilder {
      private String basicClass;
      private BigDecimal amount;
      private BigDecimal compareLastMonth;

      MonthRealTimeInventoryAmountDTOBuilder() {
      }

      public MonthRealTimeInventoryAmountDTO.MonthRealTimeInventoryAmountDTOBuilder basicClass(final String basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MonthRealTimeInventoryAmountDTO.MonthRealTimeInventoryAmountDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MonthRealTimeInventoryAmountDTO.MonthRealTimeInventoryAmountDTOBuilder compareLastMonth(final BigDecimal compareLastMonth) {
         this.compareLastMonth = compareLastMonth;
         return this;
      }

      public MonthRealTimeInventoryAmountDTO build() {
         return new MonthRealTimeInventoryAmountDTO(this.basicClass, this.amount, this.compareLastMonth);
      }

      @Override
      public String toString() {
         return "MonthRealTimeInventoryAmountDTO.MonthRealTimeInventoryAmountDTOBuilder(basicClass="
            + this.basicClass
            + ", amount="
            + this.amount
            + ", compareLastMonth="
            + this.compareLastMonth
            + ")";
      }
   }
}
