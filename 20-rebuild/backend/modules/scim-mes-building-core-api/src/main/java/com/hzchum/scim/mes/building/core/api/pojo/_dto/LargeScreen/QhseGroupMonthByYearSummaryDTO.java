package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "月度质量问题统计对象")
public class QhseGroupMonthByYearSummaryDTO {
   private String date;
   private Integer quantity;

   public static QhseGroupMonthByYearSummaryDTO.QhseGroupMonthByYearSummaryDTOBuilder builder() {
      return new QhseGroupMonthByYearSummaryDTO.QhseGroupMonthByYearSummaryDTOBuilder();
   }

   public String getDate() {
      return this.date;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QhseGroupMonthByYearSummaryDTO)) {
         return false;
      } else {
         QhseGroupMonthByYearSummaryDTO other = (QhseGroupMonthByYearSummaryDTO)o;
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
      return other instanceof QhseGroupMonthByYearSummaryDTO;
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

   @Override
   public String toString() {
      return "QhseGroupMonthByYearSummaryDTO(super=" + super.toString() + ", date=" + this.getDate() + ", quantity=" + this.getQuantity() + ")";
   }

   public QhseGroupMonthByYearSummaryDTO(final String date, final Integer quantity) {
      this.date = date;
      this.quantity = quantity;
   }

   public QhseGroupMonthByYearSummaryDTO() {
   }

   public static class QhseGroupMonthByYearSummaryDTOBuilder {
      private String date;
      private Integer quantity;

      QhseGroupMonthByYearSummaryDTOBuilder() {
      }

      public QhseGroupMonthByYearSummaryDTO.QhseGroupMonthByYearSummaryDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public QhseGroupMonthByYearSummaryDTO.QhseGroupMonthByYearSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public QhseGroupMonthByYearSummaryDTO build() {
         return new QhseGroupMonthByYearSummaryDTO(this.date, this.quantity);
      }

      @Override
      public String toString() {
         return "QhseGroupMonthByYearSummaryDTO.QhseGroupMonthByYearSummaryDTOBuilder(date=" + this.date + ", quantity=" + this.quantity + ")";
      }
   }
}
