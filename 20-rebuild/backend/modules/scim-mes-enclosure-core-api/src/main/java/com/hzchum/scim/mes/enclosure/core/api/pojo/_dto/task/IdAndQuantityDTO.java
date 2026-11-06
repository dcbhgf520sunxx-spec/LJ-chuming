package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdAndQuantityDTO", description = "围护排产详情")
public class IdAndQuantityDTO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "排产数", notes = "排产数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static IdAndQuantityDTO.IdAndQuantityDTOBuilder builder() {
      return new IdAndQuantityDTO.IdAndQuantityDTOBuilder();
   }

   public IdAndQuantityDTO() {
   }

   public IdAndQuantityDTO(final Long productId, final Integer quantity) {
      this.productId = productId;
      this.quantity = quantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("productId")
   public IdAndQuantityDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public IdAndQuantityDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "IdAndQuantityDTO(productId=" + this.getProductId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof IdAndQuantityDTO)) {
         return false;
      } else {
         IdAndQuantityDTO other = (IdAndQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class IdAndQuantityDTOBuilder {
      private Long productId;
      private Integer quantity;

      IdAndQuantityDTOBuilder() {
      }

      @JsonProperty("productId")
      public IdAndQuantityDTO.IdAndQuantityDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public IdAndQuantityDTO.IdAndQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public IdAndQuantityDTO build() {
         return new IdAndQuantityDTO(this.productId, this.quantity);
      }

      @Override
      public String toString() {
         return "IdAndQuantityDTO.IdAndQuantityDTOBuilder(productId=" + this.productId + ", quantity=" + this.quantity + ")";
      }
   }
}
