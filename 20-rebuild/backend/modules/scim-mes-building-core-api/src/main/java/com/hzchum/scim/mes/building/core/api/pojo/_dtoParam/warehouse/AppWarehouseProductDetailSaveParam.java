package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("app库位保存产品类")
public class AppWarehouseProductDetailSaveParam {
   @NotNull(message = "车间id不能为空!")
   @ApiModelProperty("车间id")
   private Long workshopId;
   @NotNull(message = "产品类型不能为空!")
   @ApiModelProperty("产品类型")
   private Integer productType;
   @NotNull(message = "产品id不能为空!")
   @ApiModelProperty("产品id")
   private Long productId;
   @NotNull(message = "数量不能为空!")
   @Min(value = 1L, message = "数量有误!")
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("码号列表")
   private List<Integer> numberList;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppWarehouseProductDetailSaveParam)) {
         return false;
      }

      AppWarehouseProductDetailSaveParam other = (AppWarehouseProductDetailSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$numberList = this.getNumberList();
                  Object other$numberList = other.getNumberList();
                  return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppWarehouseProductDetailSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "AppWarehouseProductDetailSaveParam(workshopId="
         + this.getWorkshopId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }
}
