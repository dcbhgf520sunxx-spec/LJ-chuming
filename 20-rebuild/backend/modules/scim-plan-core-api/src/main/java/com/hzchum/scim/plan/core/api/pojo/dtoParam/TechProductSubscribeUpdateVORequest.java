package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TechArtifactSubscribeSaveVORequest", description = "产品申购请求类")
public class TechProductSubscribeUpdateVORequest {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "申购数量", notes = "申购数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "申购数量不能为空")
   @Min(value = 1L, message = "申购数量不能小于1")
   private Integer quantity;

   public static TechProductSubscribeUpdateVORequest.TechProductSubscribeUpdateVORequestBuilder builder() {
      return new TechProductSubscribeUpdateVORequest.TechProductSubscribeUpdateVORequestBuilder();
   }

   public TechProductSubscribeUpdateVORequest(final Long productId, final Integer quantity) {
      this.productId = productId;
      this.quantity = quantity;
   }

   public TechProductSubscribeUpdateVORequest() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("productId")
   public TechProductSubscribeUpdateVORequest setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public TechProductSubscribeUpdateVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TechProductSubscribeUpdateVORequest)) {
         return false;
      } else {
         TechProductSubscribeUpdateVORequest other = (TechProductSubscribeUpdateVORequest)o;
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
      return other instanceof TechProductSubscribeUpdateVORequest;
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

   @Override
   public String toString() {
      return "TechProductSubscribeUpdateVORequest(productId=" + this.getProductId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class TechProductSubscribeUpdateVORequestBuilder {
      private Long productId;
      private Integer quantity;

      TechProductSubscribeUpdateVORequestBuilder() {
      }

      @JsonProperty("productId")
      public TechProductSubscribeUpdateVORequest.TechProductSubscribeUpdateVORequestBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public TechProductSubscribeUpdateVORequest.TechProductSubscribeUpdateVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechProductSubscribeUpdateVORequest build() {
         return new TechProductSubscribeUpdateVORequest(this.productId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechProductSubscribeUpdateVORequest.TechProductSubscribeUpdateVORequestBuilder(productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
