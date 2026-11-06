package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 焊接产品列表 响应参数")
public class CappCraftCardProductVO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productName", value = "产品名称")
   private String productSerialNumber;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;

   CappCraftCardProductVO(final Long productId, final String productSerialNumber, final Integer productType) {
      this.productId = productId;
      this.productSerialNumber = productSerialNumber;
      this.productType = productType;
   }

   public static CappCraftCardProductVO.CappCraftCardProductVOBuilder builder() {
      return new CappCraftCardProductVO.CappCraftCardProductVOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductVO)) {
         return false;
      }

      CappCraftCardProductVO other = (CappCraftCardProductVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productSerialNumber = this.getProductSerialNumber();
            Object other$productSerialNumber = other.getProductSerialNumber();
            return this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductVO(productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   public static class CappCraftCardProductVOBuilder {
      private Long productId;
      private String productSerialNumber;
      private Integer productType;

      CappCraftCardProductVOBuilder() {
      }

      public CappCraftCardProductVO.CappCraftCardProductVOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CappCraftCardProductVO.CappCraftCardProductVOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public CappCraftCardProductVO.CappCraftCardProductVOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public CappCraftCardProductVO build() {
         return new CappCraftCardProductVO(this.productId, this.productSerialNumber, this.productType);
      }

      @Override
      public String toString() {
         return "CappCraftCardProductVO.CappCraftCardProductVOBuilder(productId="
            + this.productId
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
