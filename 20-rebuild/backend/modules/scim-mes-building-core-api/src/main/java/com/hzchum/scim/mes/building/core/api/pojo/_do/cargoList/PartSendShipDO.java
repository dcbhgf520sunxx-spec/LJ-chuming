package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "檩条(直发件)商务")
public class PartSendShipDO {
   @ApiModelProperty("构件id")
   private Long artifactId;
   @ApiModelProperty("零件商务id")
   private Long businessId;
   @ApiModelProperty("零件规格")
   private String specification;
   @ApiModelProperty("零件材质")
   private String material;
   @ApiModelProperty("发运总数量")
   private Integer quantity;
   @ApiModelProperty("零件清单总重")
   private BigDecimal totalWeight;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("零件总长度（mm）")
   private BigDecimal totalLength;
   @ApiModelProperty("每根构件上零件的总重量")
   private BigDecimal Weight;
   @ApiModelProperty("每根构件上零件的总长度（mm）")
   private BigDecimal Length;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "warehouseType", value = "出入库类型", notes = "出入库类型")
   private Integer warehouseType;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getWeight() {
      return this.Weight;
   }

   public BigDecimal getLength() {
      return this.Length;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setWeight(final BigDecimal Weight) {
      this.Weight = Weight;
   }

   public void setLength(final BigDecimal Length) {
      this.Length = Length;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartSendShipDO)) {
         return false;
      }

      PartSendShipDO other = (PartSendShipDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$businessId = this.getBusinessId();
         Object other$businessId = other.getBusinessId();
         if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$pricingManner = this.getPricingManner();
               Object other$pricingManner = other.getPricingManner();
               if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                  Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                  Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                  if (this$boolAllPartSendDirectly == null
                     ? other$boolAllPartSendDirectly == null
                     : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                     Object this$warehouseType = this.getWarehouseType();
                     Object other$warehouseType = other.getWarehouseType();
                     if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$totalWeight = this.getTotalWeight();
                              Object other$totalWeight = other.getTotalWeight();
                              if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$totalLength = this.getTotalLength();
                                    Object other$totalLength = other.getTotalLength();
                                    if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                       Object this$Weight = this.getWeight();
                                       Object other$Weight = other.getWeight();
                                       if (this$Weight == null ? other$Weight == null : this$Weight.equals(other$Weight)) {
                                          Object this$Length = this.getLength();
                                          Object other$Length = other.getLength();
                                          if (this$Length == null ? other$Length == null : this$Length.equals(other$Length)) {
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
      return other instanceof PartSendShipDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $Weight = this.getWeight();
      result = result * 59 + ($Weight == null ? 43 : $Weight.hashCode());
      Object $Length = this.getLength();
      result = result * 59 + ($Length == null ? 43 : $Length.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "PartSendShipDO(artifactId="
         + this.getArtifactId()
         + ", businessId="
         + this.getBusinessId()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalLength="
         + this.getTotalLength()
         + ", Weight="
         + this.getWeight()
         + ", Length="
         + this.getLength()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", warehouseType="
         + this.getWarehouseType()
         + ")";
   }
}
