package com.hzchum.scim.business.core.api.pojo.dtoParam.bridge;

import java.math.BigDecimal;

public class BridgeBoxEditDTOParam {
   private Long businessId;
   private Integer quantity;
   private BigDecimal totalWeight;

   BridgeBoxEditDTOParam(final Long businessId, final Integer quantity, final BigDecimal totalWeight) {
      this.businessId = businessId;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
   }

   public static BridgeBoxEditDTOParam.BridgeBoxEditDTOParamBuilder builder() {
      return new BridgeBoxEditDTOParam.BridgeBoxEditDTOParamBuilder();
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

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BridgeBoxEditDTOParam)) {
         return false;
      }

      BridgeBoxEditDTOParam other = (BridgeBoxEditDTOParam)o;
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
            return this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BridgeBoxEditDTOParam;
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
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "BridgeBoxEditDTOParam(businessId=" + this.getBusinessId() + ", quantity=" + this.getQuantity() + ", totalWeight=" + this.getTotalWeight() + ")";
   }

   public static class BridgeBoxEditDTOParamBuilder {
      private Long businessId;
      private Integer quantity;
      private BigDecimal totalWeight;

      BridgeBoxEditDTOParamBuilder() {
      }

      public BridgeBoxEditDTOParam.BridgeBoxEditDTOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public BridgeBoxEditDTOParam.BridgeBoxEditDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BridgeBoxEditDTOParam.BridgeBoxEditDTOParamBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BridgeBoxEditDTOParam build() {
         return new BridgeBoxEditDTOParam(this.businessId, this.quantity, this.totalWeight);
      }

      @Override
      public String toString() {
         return "BridgeBoxEditDTOParam.BridgeBoxEditDTOParamBuilder(businessId="
            + this.businessId
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
