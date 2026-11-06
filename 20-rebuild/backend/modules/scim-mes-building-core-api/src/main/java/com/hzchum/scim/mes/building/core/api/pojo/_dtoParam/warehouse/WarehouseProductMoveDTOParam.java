package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("产品移库-请求类")
public class WarehouseProductMoveDTOParam {
   @NotNull(message = "产品类型不能为空!")
   @ApiModelProperty("产品类型")
   private Integer productType;
   @NotNull(message = "产品id不能为空!")
   @ApiModelProperty("产品id")
   private Long productId;
   @NotNull(message = "仓库ID不能为空!")
   @ApiModelProperty(name = "warehouseId ", value = "仓库id", notes = "仓库id")
   private Long warehouseId;
   @NotNull(message = "数量不能为空!")
   @Min(value = 1L, message = "数量有误!")
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("码号列表")
   private List<Integer> numberList = new ArrayList<>();
   @NotNull(message = "未选择移动目的仓库!")
   @ApiModelProperty(name = "moveWarehouseId ", value = "移动目的仓库id", notes = "移动目的仓库id")
   private Long moveWarehouseId;

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Long getMoveWarehouseId() {
      return this.moveWarehouseId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   public void setMoveWarehouseId(final Long moveWarehouseId) {
      this.moveWarehouseId = moveWarehouseId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseProductMoveDTOParam)) {
         return false;
      }

      WarehouseProductMoveDTOParam other = (WarehouseProductMoveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$moveWarehouseId = this.getMoveWarehouseId();
                  Object other$moveWarehouseId = other.getMoveWarehouseId();
                  if (this$moveWarehouseId == null ? other$moveWarehouseId == null : this$moveWarehouseId.equals(other$moveWarehouseId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseProductMoveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $moveWarehouseId = this.getMoveWarehouseId();
      result = result * 59 + ($moveWarehouseId == null ? 43 : $moveWarehouseId.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseProductMoveDTOParam(productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", quantity="
         + this.getQuantity()
         + ", numberList="
         + this.getNumberList()
         + ", moveWarehouseId="
         + this.getMoveWarehouseId()
         + ")";
   }
}
