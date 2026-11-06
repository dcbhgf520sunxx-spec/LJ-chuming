package com.hzchum.scim.mes.building.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdAndQuantityRequest", description = "上报详细信息")
public class IdAndRecelveQuantityDTO {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "receivedQuantity", notes = "接收数")
   @JsonProperty("receivedQuantity")
   @JSONField(name = "receivedQuantity")
   private Integer receivedQuantity;

   public IdAndRecelveQuantityDTO(final Long productId, final Integer receivedQuantity) {
      this.productId = productId;
      this.receivedQuantity = receivedQuantity;
   }

   public IdAndRecelveQuantityDTO() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getReceivedQuantity() {
      return this.receivedQuantity;
   }

   @JsonProperty("productId")
   public IdAndRecelveQuantityDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("receivedQuantity")
   public IdAndRecelveQuantityDTO setReceivedQuantity(final Integer receivedQuantity) {
      this.receivedQuantity = receivedQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "IdAndRecelveQuantityDTO(productId=" + this.getProductId() + ", receivedQuantity=" + this.getReceivedQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof IdAndRecelveQuantityDTO)) {
         return false;
      } else {
         IdAndRecelveQuantityDTO other = (IdAndRecelveQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$receivedQuantity = this.getReceivedQuantity();
               Object other$receivedQuantity = other.getReceivedQuantity();
               return this$receivedQuantity == null ? other$receivedQuantity == null : this$receivedQuantity.equals(other$receivedQuantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdAndRecelveQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $receivedQuantity = this.getReceivedQuantity();
      return result * 59 + ($receivedQuantity == null ? 43 : $receivedQuantity.hashCode());
   }
}
