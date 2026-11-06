package com.hzchum.scim.business.core.api.pojo.dtoParam.bridge;

import java.math.BigDecimal;

public class BridgeBoxAddDTOParam {
   private Long projectId;
   private Long monomerId;
   private String name;
   private String material;
   private String specification;
   private Integer quantity;
   private BigDecimal totalWeight;

   BridgeBoxAddDTOParam(
      final Long projectId,
      final Long monomerId,
      final String name,
      final String material,
      final String specification,
      final Integer quantity,
      final BigDecimal totalWeight
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.name = name;
      this.material = material;
      this.specification = specification;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
   }

   public static BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder builder() {
      return new BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
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

      if (!(o instanceof BridgeBoxAddDTOParam)) {
         return false;
      }

      BridgeBoxAddDTOParam other = (BridgeBoxAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$totalWeight = this.getTotalWeight();
                        Object other$totalWeight = other.getTotalWeight();
                        return this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight);
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
      return other instanceof BridgeBoxAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "BridgeBoxAddDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ")";
   }

   public static class BridgeBoxAddDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private String name;
      private String material;
      private String specification;
      private Integer quantity;
      private BigDecimal totalWeight;

      BridgeBoxAddDTOParamBuilder() {
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BridgeBoxAddDTOParam build() {
         return new BridgeBoxAddDTOParam(this.projectId, this.monomerId, this.name, this.material, this.specification, this.quantity, this.totalWeight);
      }

      @Override
      public String toString() {
         return "BridgeBoxAddDTOParam.BridgeBoxAddDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
