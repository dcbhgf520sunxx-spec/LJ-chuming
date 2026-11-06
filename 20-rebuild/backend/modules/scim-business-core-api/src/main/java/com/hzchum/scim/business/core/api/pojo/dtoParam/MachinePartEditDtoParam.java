package com.hzchum.scim.business.core.api.pojo.dtoParam;

import java.math.BigDecimal;

public class MachinePartEditDtoParam {
   private Long businessId;
   private Integer quantity;
   private BigDecimal totalWeight;
   private BigDecimal totalLength;

   MachinePartEditDtoParam(final Long businessId, final Integer quantity, final BigDecimal totalWeight, final BigDecimal totalLength) {
      this.businessId = businessId;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
   }

   public static MachinePartEditDtoParam.MachinePartEditDtoParamBuilder builder() {
      return new MachinePartEditDtoParam.MachinePartEditDtoParamBuilder();
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartEditDtoParam)) {
         return false;
      }

      MachinePartEditDtoParam other = (MachinePartEditDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessId = this.getBusinessId();
      Object other$businessId = other.getBusinessId();
      if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$totalWeight = this.getTotalWeight();
            Object other$totalWeight = other.getTotalWeight();
            if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
               Object this$totalLength = this.getTotalLength();
               Object other$totalLength = other.getTotalLength();
               return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
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
      return other instanceof MachinePartEditDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartEditDtoParam(businessId="
         + this.getBusinessId()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ")";
   }

   public static class MachinePartEditDtoParamBuilder {
      private Long businessId;
      private Integer quantity;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;

      MachinePartEditDtoParamBuilder() {
      }

      public MachinePartEditDtoParam.MachinePartEditDtoParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public MachinePartEditDtoParam.MachinePartEditDtoParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartEditDtoParam.MachinePartEditDtoParamBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MachinePartEditDtoParam.MachinePartEditDtoParamBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public MachinePartEditDtoParam build() {
         return new MachinePartEditDtoParam(this.businessId, this.quantity, this.totalWeight, this.totalLength);
      }

      @Override
      public String toString() {
         return "MachinePartEditDtoParam.MachinePartEditDtoParamBuilder(businessId="
            + this.businessId
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ")";
      }
   }
}
