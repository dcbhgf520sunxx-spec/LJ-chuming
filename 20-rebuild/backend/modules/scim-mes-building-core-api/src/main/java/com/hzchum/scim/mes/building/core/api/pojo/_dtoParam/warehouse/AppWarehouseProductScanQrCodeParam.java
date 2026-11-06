package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("APP产品保存库位-扫码请求类")
public class AppWarehouseProductScanQrCodeParam {
   @ApiModelProperty(name = "workshopId", value = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "taskId", value = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "warehouseId", value = "入库汇总id")
   private Long warehouseId;
   @NotNull(message = "产品类型不能为空!")
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @NotNull(message = "产品id不能为空!")
   @ApiModelProperty(name = "productId", value = "产品id")
   private Long productId;
   @ApiModelProperty(name = "number", value = "一物一码号")
   private Integer number;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppWarehouseProductScanQrCodeParam)) {
         return false;
      }

      AppWarehouseProductScanQrCodeParam other = (AppWarehouseProductScanQrCodeParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof AppWarehouseProductScanQrCodeParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   @Override
   public String toString() {
      return "AppWarehouseProductScanQrCodeParam(workshopId="
         + this.getWorkshopId()
         + ", taskId="
         + this.getTaskId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ")";
   }
}
