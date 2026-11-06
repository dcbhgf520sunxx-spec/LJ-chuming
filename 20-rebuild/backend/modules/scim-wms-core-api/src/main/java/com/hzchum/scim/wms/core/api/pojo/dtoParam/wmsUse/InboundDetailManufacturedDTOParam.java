package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InboundDetailManufacturedDTOParam {
   @ApiModelProperty("入库明细ID")
   private Long id;
   @ApiModelProperty("采购单详情ID")
   private Long purchaseOrderDetailId;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("仓库ID")
   @NotNull(message = "仓库必选")
   @Min(value = 1L, message = "仓库参数有误！！！")
   private Long workshopId;
   @ApiModelProperty("仓库位置ID")
   @NotNull(message = "仓库位置必选")
   @Min(value = 1L, message = "仓库位置参数有误！！！")
   private Long warehouseId;
   @ApiModelProperty("备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetailManufacturedDTOParam)) {
         return false;
      }

      InboundDetailManufacturedDTOParam other = (InboundDetailManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
         Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
         if (this$purchaseOrderDetailId == null ? other$purchaseOrderDetailId == null : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$warehouseId = this.getWarehouseId();
               Object other$warehouseId = other.getWarehouseId();
               if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof InboundDetailManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDetailManufacturedDTOParam(id="
         + this.getId()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", quantity="
         + this.getQuantity()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public InboundDetailManufacturedDTOParam(
      final Long id, final Long purchaseOrderDetailId, final BigDecimal quantity, final Long workshopId, final Long warehouseId, final String remark
   ) {
      this.id = id;
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      this.quantity = quantity;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.remark = remark;
   }

   public InboundDetailManufacturedDTOParam() {
   }
}
