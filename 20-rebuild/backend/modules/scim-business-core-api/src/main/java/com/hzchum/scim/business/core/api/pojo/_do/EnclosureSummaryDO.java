package com.hzchum.scim.business.core.api.pojo._do;

import java.math.BigDecimal;

public class EnclosureSummaryDO {
   private Integer totalQuantity;
   private BigDecimal totalLength;
   private BigDecimal totalArea;
   private BigDecimal totalLengthPrice;
   private BigDecimal totalAreaPrice;
   private BigDecimal unitPrice;
   private Integer category;

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalLengthPrice() {
      return this.totalLengthPrice;
   }

   public BigDecimal getTotalAreaPrice() {
      return this.totalAreaPrice;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getCategory() {
      return this.category;
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

   public void setTotalLengthPrice(final BigDecimal totalLengthPrice) {
      this.totalLengthPrice = totalLengthPrice;
   }

   public void setTotalAreaPrice(final BigDecimal totalAreaPrice) {
      this.totalAreaPrice = totalAreaPrice;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSummaryDO)) {
         return false;
      }

      EnclosureSummaryDO other = (EnclosureSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$totalLength = this.getTotalLength();
            Object other$totalLength = other.getTotalLength();
            if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
               Object this$totalArea = this.getTotalArea();
               Object other$totalArea = other.getTotalArea();
               if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                  Object this$totalLengthPrice = this.getTotalLengthPrice();
                  Object other$totalLengthPrice = other.getTotalLengthPrice();
                  if (this$totalLengthPrice == null ? other$totalLengthPrice == null : this$totalLengthPrice.equals(other$totalLengthPrice)) {
                     Object this$totalAreaPrice = this.getTotalAreaPrice();
                     Object other$totalAreaPrice = other.getTotalAreaPrice();
                     if (this$totalAreaPrice == null ? other$totalAreaPrice == null : this$totalAreaPrice.equals(other$totalAreaPrice)) {
                        Object this$unitPrice = this.getUnitPrice();
                        Object other$unitPrice = other.getUnitPrice();
                        return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof EnclosureSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalLengthPrice = this.getTotalLengthPrice();
      result = result * 59 + ($totalLengthPrice == null ? 43 : $totalLengthPrice.hashCode());
      Object $totalAreaPrice = this.getTotalAreaPrice();
      result = result * 59 + ($totalAreaPrice == null ? 43 : $totalAreaPrice.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureSummaryDO(totalQuantity="
         + this.getTotalQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalLengthPrice="
         + this.getTotalLengthPrice()
         + ", totalAreaPrice="
         + this.getTotalAreaPrice()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", category="
         + this.getCategory()
         + ")";
   }
}
