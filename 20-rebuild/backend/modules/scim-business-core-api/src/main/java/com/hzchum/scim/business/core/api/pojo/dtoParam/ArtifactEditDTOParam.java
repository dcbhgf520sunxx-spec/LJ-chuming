package com.hzchum.scim.business.core.api.pojo.dtoParam;

import java.math.BigDecimal;

public class ArtifactEditDTOParam {
   private Long businessId;
   private Integer quantity;
   private BigDecimal totalWeight;
   private String specification;
   private BigDecimal totalLength;

   ArtifactEditDTOParam(final Long businessId, final Integer quantity, final BigDecimal totalWeight, final String specification, final BigDecimal totalLength) {
      this.businessId = businessId;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
      this.specification = specification;
      this.totalLength = totalLength;
   }

   public static ArtifactEditDTOParam.ArtifactEditDTOParamBuilder builder() {
      return new ArtifactEditDTOParam.ArtifactEditDTOParamBuilder();
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

   public String getSpecification() {
      return this.specification;
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

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactEditDTOParam)) {
         return false;
      }

      ArtifactEditDTOParam other = (ArtifactEditDTOParam)o;
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
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactEditDTOParam;
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
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactEditDTOParam(businessId="
         + this.getBusinessId()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", specification="
         + this.getSpecification()
         + ", totalLength="
         + this.getTotalLength()
         + ")";
   }

   public static class ArtifactEditDTOParamBuilder {
      private Long businessId;
      private Integer quantity;
      private BigDecimal totalWeight;
      private String specification;
      private BigDecimal totalLength;

      ArtifactEditDTOParamBuilder() {
      }

      public ArtifactEditDTOParam.ArtifactEditDTOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public ArtifactEditDTOParam.ArtifactEditDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ArtifactEditDTOParam.ArtifactEditDTOParamBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public ArtifactEditDTOParam.ArtifactEditDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ArtifactEditDTOParam.ArtifactEditDTOParamBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ArtifactEditDTOParam build() {
         return new ArtifactEditDTOParam(this.businessId, this.quantity, this.totalWeight, this.specification, this.totalLength);
      }

      @Override
      public String toString() {
         return "ArtifactEditDTOParam.ArtifactEditDTOParamBuilder(businessId="
            + this.businessId
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ", specification="
            + this.specification
            + ", totalLength="
            + this.totalLength
            + ")";
      }
   }
}
