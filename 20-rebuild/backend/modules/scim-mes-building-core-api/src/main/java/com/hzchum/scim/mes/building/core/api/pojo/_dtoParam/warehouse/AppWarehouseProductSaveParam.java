package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("APP产品库位保存-请求类")
public class AppWarehouseProductSaveParam {
   @NotNull(message = "未选择库位!")
   @ApiModelProperty(name = "warehouseLocationId ", value = "库位id", notes = "库位id")
   private Long warehouseLocationId;
   @Valid
   @NotEmpty(message = "未选择存入产品!")
   @ApiModelProperty(name = "productList ", value = "产品列表", notes = "产品列表")
   private List<AppWarehouseProductDetailSaveParam> productList;

   public Long getWarehouseLocationId() {
      return this.warehouseLocationId;
   }

   public List<AppWarehouseProductDetailSaveParam> getProductList() {
      return this.productList;
   }

   public void setWarehouseLocationId(final Long warehouseLocationId) {
      this.warehouseLocationId = warehouseLocationId;
   }

   public void setProductList(final List<AppWarehouseProductDetailSaveParam> productList) {
      this.productList = productList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppWarehouseProductSaveParam)) {
         return false;
      } else {
         AppWarehouseProductSaveParam other = (AppWarehouseProductSaveParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$warehouseLocationId = this.getWarehouseLocationId();
            Object other$warehouseLocationId = other.getWarehouseLocationId();
            if (this$warehouseLocationId == null ? other$warehouseLocationId == null : this$warehouseLocationId.equals(other$warehouseLocationId)) {
               Object this$productList = this.getProductList();
               Object other$productList = other.getProductList();
               return this$productList == null ? other$productList == null : this$productList.equals(other$productList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppWarehouseProductSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $warehouseLocationId = this.getWarehouseLocationId();
      result = result * 59 + ($warehouseLocationId == null ? 43 : $warehouseLocationId.hashCode());
      Object $productList = this.getProductList();
      return result * 59 + ($productList == null ? 43 : $productList.hashCode());
   }

   @Override
   public String toString() {
      return "AppWarehouseProductSaveParam(warehouseLocationId=" + this.getWarehouseLocationId() + ", productList=" + this.getProductList() + ")";
   }
}
