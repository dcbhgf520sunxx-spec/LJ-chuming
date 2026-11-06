package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class MachinePartAddDtoParam {
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   private Long areaBatchId;
   private String name;
   private String material;
   private String specification;
   private Integer quantity;
   private BigDecimal totalWeight;
   private BigDecimal totalLength;
   private Integer productType;

   public static MachinePartAddDtoParam.MachinePartAddDtoParamBuilder builder() {
      return new MachinePartAddDtoParam.MachinePartAddDtoParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
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

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
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

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartAddDtoParam)) {
         return false;
      }

      MachinePartAddDtoParam other = (MachinePartAddDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartAddDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartAddDtoParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
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
         + ", totalLength="
         + this.getTotalLength()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   public MachinePartAddDtoParam(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final String name,
      final String material,
      final String specification,
      final Integer quantity,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final Integer productType
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.name = name;
      this.material = material;
      this.specification = specification;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.productType = productType;
   }

   public MachinePartAddDtoParam() {
   }

   public static class MachinePartAddDtoParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private String name;
      private String material;
      private String specification;
      private Integer quantity;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private Integer productType;

      MachinePartAddDtoParamBuilder() {
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public MachinePartAddDtoParam.MachinePartAddDtoParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MachinePartAddDtoParam build() {
         return new MachinePartAddDtoParam(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.name,
            this.material,
            this.specification,
            this.quantity,
            this.totalWeight,
            this.totalLength,
            this.productType
         );
      }

      @Override
      public String toString() {
         return "MachinePartAddDtoParam.MachinePartAddDtoParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
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
            + ", totalLength="
            + this.totalLength
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
