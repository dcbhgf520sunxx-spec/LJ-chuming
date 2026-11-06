package com.hzchum.scim.business.core.api.pojo.dto;

import java.math.BigDecimal;

public class EnclosureSummaryDTO {
   private Integer totalQuantity;
   private BigDecimal totalLength;
   private BigDecimal totalArea;
   private BigDecimal totalPrice;

   EnclosureSummaryDTO(final Integer totalQuantity, final BigDecimal totalLength, final BigDecimal totalArea, final BigDecimal totalPrice) {
      this.totalQuantity = totalQuantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.totalPrice = totalPrice;
   }

   public static EnclosureSummaryDTO.EnclosureSummaryDTOBuilder builder() {
      return new EnclosureSummaryDTO.EnclosureSummaryDTOBuilder();
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSummaryDTO)) {
         return false;
      }

      EnclosureSummaryDTO other = (EnclosureSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$totalLength = this.getTotalLength();
         Object other$totalLength = other.getTotalLength();
         if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
            Object this$totalArea = this.getTotalArea();
            Object other$totalArea = other.getTotalArea();
            if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
               Object this$totalPrice = this.getTotalPrice();
               Object other$totalPrice = other.getTotalPrice();
               return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof EnclosureSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureSummaryDTO(totalQuantity="
         + this.getTotalQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalPrice="
         + this.getTotalPrice()
         + ")";
   }

   public static class EnclosureSummaryDTOBuilder {
      private Integer totalQuantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private BigDecimal totalPrice;

      EnclosureSummaryDTOBuilder() {
      }

      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public EnclosureSummaryDTO build() {
         return new EnclosureSummaryDTO(this.totalQuantity, this.totalLength, this.totalArea, this.totalPrice);
      }

      @Override
      public String toString() {
         return "EnclosureSummaryDTO.EnclosureSummaryDTOBuilder(totalQuantity="
            + this.totalQuantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", totalPrice="
            + this.totalPrice
            + ")";
      }
   }
}
