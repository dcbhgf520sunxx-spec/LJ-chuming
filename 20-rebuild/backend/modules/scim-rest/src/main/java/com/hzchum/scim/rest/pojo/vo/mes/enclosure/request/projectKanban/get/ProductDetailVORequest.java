package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.projectKanban.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectSummaryDTOParam", description = "项目状态查询")
public class ProductDetailVORequest {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "prodcutType", notes = "产品类型")
   @JsonProperty("prodcutType")
   @JSONField(name = "prodcutType")
   private Long prodcutType;

   public static ProductDetailVORequest.ProductDetailVORequestBuilder builder() {
      return new ProductDetailVORequest.ProductDetailVORequestBuilder();
   }

   public ProductDetailVORequest() {
   }

   public ProductDetailVORequest(final Long productId, final Long factoryId, final Long prodcutType) {
      this.productId = productId;
      this.factoryId = factoryId;
      this.prodcutType = prodcutType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProdcutType() {
      return this.prodcutType;
   }

   @JsonProperty("productId")
   public ProductDetailVORequest setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("factoryId")
   public ProductDetailVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("prodcutType")
   public ProductDetailVORequest setProdcutType(final Long prodcutType) {
      this.prodcutType = prodcutType;
      return this;
   }

   @Override
   public String toString() {
      return "ProductDetailVORequest(productId=" + this.getProductId() + ", factoryId=" + this.getFactoryId() + ", prodcutType=" + this.getProdcutType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductDetailVORequest)) {
         return false;
      }

      ProductDetailVORequest other = (ProductDetailVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$prodcutType = this.getProdcutType();
            Object other$prodcutType = other.getProdcutType();
            return this$prodcutType == null ? other$prodcutType == null : this$prodcutType.equals(other$prodcutType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductDetailVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $prodcutType = this.getProdcutType();
      return result * 59 + ($prodcutType == null ? 43 : $prodcutType.hashCode());
   }

   public static class ProductDetailVORequestBuilder {
      private Long productId;
      private Long factoryId;
      private Long prodcutType;

      ProductDetailVORequestBuilder() {
      }

      @JsonProperty("productId")
      public ProductDetailVORequest.ProductDetailVORequestBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("factoryId")
      public ProductDetailVORequest.ProductDetailVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("prodcutType")
      public ProductDetailVORequest.ProductDetailVORequestBuilder prodcutType(final Long prodcutType) {
         this.prodcutType = prodcutType;
         return this;
      }

      public ProductDetailVORequest build() {
         return new ProductDetailVORequest(this.productId, this.factoryId, this.prodcutType);
      }

      @Override
      public String toString() {
         return "ProductDetailVORequest.ProductDetailVORequestBuilder(productId="
            + this.productId
            + ", factoryId="
            + this.factoryId
            + ", prodcutType="
            + this.prodcutType
            + ")";
      }
   }
}
