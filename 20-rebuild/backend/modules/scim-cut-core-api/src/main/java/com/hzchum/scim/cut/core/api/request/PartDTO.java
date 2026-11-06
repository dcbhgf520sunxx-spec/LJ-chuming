package com.hzchum.scim.cut.core.api.request;

import java.math.BigDecimal;

public class PartDTO {
   private String serialNumber;
   private Integer quantity;
   private BigDecimal totalNetWeight;
   private BigDecimal netWeight;

   public static PartDTO.PartDTOBuilder builder() {
      return new PartDTO.PartDTOBuilder();
   }

   public PartDTO() {
   }

   public PartDTO(final String serialNumber, final Integer quantity, final BigDecimal totalNetWeight, final BigDecimal netWeight) {
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.netWeight = netWeight;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartDTO)) {
         return false;
      }

      PartDTO other = (PartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof PartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   @Override
   public String toString() {
      return "PartDTO(serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   public static class PartDTOBuilder {
      private String serialNumber;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal netWeight;

      PartDTOBuilder() {
      }

      public PartDTO.PartDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public PartDTO.PartDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public PartDTO.PartDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public PartDTO.PartDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public PartDTO build() {
         return new PartDTO(this.serialNumber, this.quantity, this.totalNetWeight, this.netWeight);
      }

      @Override
      public String toString() {
         return "PartDTO.PartDTOBuilder(serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
