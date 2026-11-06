package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CAPP  app产品码号 查询参数")
public class CappCraftCardProductAppPassCodeScanDTO {
   private Long productId;
   private Integer number;
   private Integer productType;

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppPassCodeScanDTO)) {
         return false;
      }

      CappCraftCardProductAppPassCodeScanDTO other = (CappCraftCardProductAppPassCodeScanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductAppPassCodeScanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppPassCodeScanDTO(productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", productType="
         + this.getProductType()
         + ")";
   }
}
