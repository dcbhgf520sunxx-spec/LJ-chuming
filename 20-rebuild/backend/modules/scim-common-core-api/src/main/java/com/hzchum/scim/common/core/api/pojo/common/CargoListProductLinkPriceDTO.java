package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class CargoListProductLinkPriceDTO {
   @ApiModelProperty("发运详情id")
   private Long id;
   @ApiModelProperty("发运id")
   private Long cargoListId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("发运数量")
   private BigDecimal quantity;
   @ApiModelProperty("计价id")
   private Long businessPriceId;
   @ApiModelProperty("计价详情id")
   private Long businessPriceDetailId;
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价方式 1重量 2长度 4面积 8数量", notes = "计价方式 1重量 2长度 4面积 8数量")
   private Integer pricingMannerEnum;
   @ApiModelProperty(name = "pricingUnitTypeEnum", value = "计价单位类型 1千克 2吨 4米 8平米 ", notes = "计价单位 1千克 2吨 4米 8平米")
   private Integer pricingUnitTypeEnum;
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("核算量")
   private BigDecimal mete;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;

   public static CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder builder() {
      return new CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder();
   }

   public CargoListProductLinkPriceDTO(
      final Long id,
      final Long cargoListId,
      final Integer productType,
      final Long productId,
      final BigDecimal quantity,
      final Long businessPriceId,
      final Long businessPriceDetailId,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final BigDecimal unitPrice,
      final BigDecimal mete,
      final BigDecimal totalPrice
   ) {
      this.id = id;
      this.cargoListId = cargoListId;
      this.productType = productType;
      this.productId = productId;
      this.quantity = quantity;
      this.businessPriceId = businessPriceId;
      this.businessPriceDetailId = businessPriceDetailId;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.unitPrice = unitPrice;
      this.mete = mete;
      this.totalPrice = totalPrice;
   }

   public CargoListProductLinkPriceDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getBusinessPriceId() {
      return this.businessPriceId;
   }

   public Long getBusinessPriceDetailId() {
      return this.businessPriceDetailId;
   }

   public Integer getPricingMannerEnum() {
      return this.pricingMannerEnum;
   }

   public Integer getPricingUnitTypeEnum() {
      return this.pricingUnitTypeEnum;
   }

   public Integer getPricingWeightTypeEnum() {
      return this.pricingWeightTypeEnum;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setBusinessPriceId(final Long businessPriceId) {
      this.businessPriceId = businessPriceId;
   }

   public void setBusinessPriceDetailId(final Long businessPriceDetailId) {
      this.businessPriceDetailId = businessPriceDetailId;
   }

   public void setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
   }

   public void setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
   }

   public void setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListProductLinkPriceDTO)) {
         return false;
      }

      CargoListProductLinkPriceDTO other = (CargoListProductLinkPriceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cargoListId = this.getCargoListId();
         Object other$cargoListId = other.getCargoListId();
         if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$businessPriceId = this.getBusinessPriceId();
                  Object other$businessPriceId = other.getBusinessPriceId();
                  if (this$businessPriceId == null ? other$businessPriceId == null : this$businessPriceId.equals(other$businessPriceId)) {
                     Object this$businessPriceDetailId = this.getBusinessPriceDetailId();
                     Object other$businessPriceDetailId = other.getBusinessPriceDetailId();
                     if (this$businessPriceDetailId == null
                        ? other$businessPriceDetailId == null
                        : this$businessPriceDetailId.equals(other$businessPriceDetailId)) {
                        Object this$pricingMannerEnum = this.getPricingMannerEnum();
                        Object other$pricingMannerEnum = other.getPricingMannerEnum();
                        if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                           Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                           Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                           if (this$pricingUnitTypeEnum == null
                              ? other$pricingUnitTypeEnum == null
                              : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                              Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                              Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                              if (this$pricingWeightTypeEnum == null
                                 ? other$pricingWeightTypeEnum == null
                                 : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$unitPrice = this.getUnitPrice();
                                    Object other$unitPrice = other.getUnitPrice();
                                    if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                       Object this$mete = this.getMete();
                                       Object other$mete = other.getMete();
                                       if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListProductLinkPriceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $businessPriceId = this.getBusinessPriceId();
      result = result * 59 + ($businessPriceId == null ? 43 : $businessPriceId.hashCode());
      Object $businessPriceDetailId = this.getBusinessPriceDetailId();
      result = result * 59 + ($businessPriceDetailId == null ? 43 : $businessPriceDetailId.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListProductLinkPriceDTO(id="
         + this.getId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", businessPriceId="
         + this.getBusinessPriceId()
         + ", businessPriceDetailId="
         + this.getBusinessPriceDetailId()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", mete="
         + this.getMete()
         + ", totalPrice="
         + this.getTotalPrice()
         + ")";
   }

   public static class CargoListProductLinkPriceDTOBuilder {
      private Long id;
      private Long cargoListId;
      private Integer productType;
      private Long productId;
      private BigDecimal quantity;
      private Long businessPriceId;
      private Long businessPriceDetailId;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private BigDecimal unitPrice;
      private BigDecimal mete;
      private BigDecimal totalPrice;

      CargoListProductLinkPriceDTOBuilder() {
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder businessPriceId(final Long businessPriceId) {
         this.businessPriceId = businessPriceId;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder businessPriceDetailId(final Long businessPriceDetailId) {
         this.businessPriceDetailId = businessPriceDetailId;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public CargoListProductLinkPriceDTO build() {
         return new CargoListProductLinkPriceDTO(
            this.id,
            this.cargoListId,
            this.productType,
            this.productId,
            this.quantity,
            this.businessPriceId,
            this.businessPriceDetailId,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.unitPrice,
            this.mete,
            this.totalPrice
         );
      }

      @Override
      public String toString() {
         return "CargoListProductLinkPriceDTO.CargoListProductLinkPriceDTOBuilder(id="
            + this.id
            + ", cargoListId="
            + this.cargoListId
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", businessPriceId="
            + this.businessPriceId
            + ", businessPriceDetailId="
            + this.businessPriceDetailId
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", unitPrice="
            + this.unitPrice
            + ", mete="
            + this.mete
            + ", totalPrice="
            + this.totalPrice
            + ")";
      }
   }
}
