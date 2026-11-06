package com.hzchum.scim.mes.building.core.api.pojo._dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(description = "日期和数量")
public class DateAndCount {
   @ApiModelProperty(name = "date", value = "日期")
   private LocalDateTime date;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;

   public static DateAndCount.DateAndCountBuilder builder() {
      return new DateAndCount.DateAndCountBuilder();
   }

   public DateAndCount(final LocalDateTime date, final Integer quantity) {
      this.date = date;
      this.quantity = quantity;
   }

   public DateAndCount() {
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public DateAndCount setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   public DateAndCount setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "DateAndCount(date=" + this.getDate() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DateAndCount)) {
         return false;
      } else {
         DateAndCount other = (DateAndCount)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               return this$date == null ? other$date == null : this$date.equals(other$date);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DateAndCount;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public static class DateAndCountBuilder {
      private LocalDateTime date;
      private Integer quantity;

      DateAndCountBuilder() {
      }

      public DateAndCount.DateAndCountBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public DateAndCount.DateAndCountBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public DateAndCount build() {
         return new DateAndCount(this.date, this.quantity);
      }

      @Override
      public String toString() {
         return "DateAndCount.DateAndCountBuilder(date=" + this.date + ", quantity=" + this.quantity + ")";
      }
   }
}
