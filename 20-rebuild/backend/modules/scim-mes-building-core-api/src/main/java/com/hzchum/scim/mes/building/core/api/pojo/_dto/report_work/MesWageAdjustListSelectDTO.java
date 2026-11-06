package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;

public class MesWageAdjustListSelectDTO {
   private ProductInfo product;

   public ProductInfo getProduct() {
      return this.product;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustListSelectDTO)) {
         return false;
      }

      MesWageAdjustListSelectDTO other = (MesWageAdjustListSelectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$product = this.getProduct();
      Object other$product = other.getProduct();
      return this$product == null ? other$product == null : this$product.equals(other$product);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageAdjustListSelectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $product = this.getProduct();
      return result * 59 + ($product == null ? 43 : $product.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustListSelectDTO(product=" + this.getProduct() + ")";
   }
}
