package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP  app产品码号列表查询 请求参数")
public class CappCraftCardProductAppCodeNumberListDTO {
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品类型")
   private Integer productType;

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappCraftCardProductAppCodeNumberListDTO)) {
         return false;
      } else {
         CappCraftCardProductAppCodeNumberListDTO other = (CappCraftCardProductAppCodeNumberListDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductAppCodeNumberListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppCodeNumberListDTO(productId=" + this.getProductId() + ", productType=" + this.getProductType() + ")";
   }
}
