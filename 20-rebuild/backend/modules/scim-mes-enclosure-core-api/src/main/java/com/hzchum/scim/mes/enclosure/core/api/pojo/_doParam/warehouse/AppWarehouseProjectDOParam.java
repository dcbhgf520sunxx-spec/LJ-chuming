package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("APP项目汇总条件")
public class AppWarehouseProjectDOParam {
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;

   public Integer getProductType() {
      return this.productType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppWarehouseProjectDOParam)) {
         return false;
      }

      AppWarehouseProjectDOParam other = (AppWarehouseProjectDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppWarehouseProjectDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   @Override
   public String toString() {
      return "AppWarehouseProjectDOParam(productType=" + this.getProductType() + ")";
   }
}
