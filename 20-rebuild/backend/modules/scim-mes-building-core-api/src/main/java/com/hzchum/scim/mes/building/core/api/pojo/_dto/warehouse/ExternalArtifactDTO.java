package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "外协入库对象", description = "外协入库对象")
public class ExternalArtifactDTO {
   @ApiModelProperty(name = "productId", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "warehousingType", notes = "入库类型 0:入库 1:及入及出")
   private Integer warehousingType;
   @ApiModelProperty(name = "workShopId", notes = "车间id")
   private Long workShopId;

   public static ExternalArtifactDTO.ExternalArtifactDTOBuilder builder() {
      return new ExternalArtifactDTO.ExternalArtifactDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getWarehousingType() {
      return this.warehousingType;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setWarehousingType(final Integer warehousingType) {
      this.warehousingType = warehousingType;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExternalArtifactDTO)) {
         return false;
      }

      ExternalArtifactDTO other = (ExternalArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$warehousingType = this.getWarehousingType();
            Object other$warehousingType = other.getWarehousingType();
            if (this$warehousingType == null ? other$warehousingType == null : this$warehousingType.equals(other$warehousingType)) {
               Object this$workShopId = this.getWorkShopId();
               Object other$workShopId = other.getWorkShopId();
               return this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId);
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
      return other instanceof ExternalArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $warehousingType = this.getWarehousingType();
      result = result * 59 + ($warehousingType == null ? 43 : $warehousingType.hashCode());
      Object $workShopId = this.getWorkShopId();
      return result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
   }

   @Override
   public String toString() {
      return "ExternalArtifactDTO(productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", warehousingType="
         + this.getWarehousingType()
         + ", workShopId="
         + this.getWorkShopId()
         + ")";
   }

   public ExternalArtifactDTO(final Long productId, final Integer quantity, final Integer warehousingType, final Long workShopId) {
      this.productId = productId;
      this.quantity = quantity;
      this.warehousingType = warehousingType;
      this.workShopId = workShopId;
   }

   public ExternalArtifactDTO() {
   }

   public static class ExternalArtifactDTOBuilder {
      private Long productId;
      private Integer quantity;
      private Integer warehousingType;
      private Long workShopId;

      ExternalArtifactDTOBuilder() {
      }

      public ExternalArtifactDTO.ExternalArtifactDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ExternalArtifactDTO.ExternalArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ExternalArtifactDTO.ExternalArtifactDTOBuilder warehousingType(final Integer warehousingType) {
         this.warehousingType = warehousingType;
         return this;
      }

      public ExternalArtifactDTO.ExternalArtifactDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public ExternalArtifactDTO build() {
         return new ExternalArtifactDTO(this.productId, this.quantity, this.warehousingType, this.workShopId);
      }

      @Override
      public String toString() {
         return "ExternalArtifactDTO.ExternalArtifactDTOBuilder(productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", warehousingType="
            + this.warehousingType
            + ", workShopId="
            + this.workShopId
            + ")";
      }
   }
}
