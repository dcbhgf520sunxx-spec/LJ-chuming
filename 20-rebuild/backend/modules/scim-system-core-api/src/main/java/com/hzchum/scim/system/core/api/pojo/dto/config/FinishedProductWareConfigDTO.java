package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class FinishedProductWareConfigDTO {
   @ApiModelProperty("是否启用仓库功能")
   private Boolean boolEnableWarehouse;
   @ApiModelProperty("产品入仓库码号选择方式 1自动选择 2手动选择")
   private Integer warehouseNumberModeEnum;
   @ApiModelProperty("是否必选库位 true必选 false非必选")
   private Boolean boolRequiredWarehouse;

   public static FinishedProductWareConfigDTO.FinishedProductWareConfigDTOBuilder builder() {
      return new FinishedProductWareConfigDTO.FinishedProductWareConfigDTOBuilder();
   }

   public FinishedProductWareConfigDTO(final Boolean boolEnableWarehouse, final Integer warehouseNumberModeEnum, final Boolean boolRequiredWarehouse) {
      this.boolEnableWarehouse = boolEnableWarehouse;
      this.warehouseNumberModeEnum = warehouseNumberModeEnum;
      this.boolRequiredWarehouse = boolRequiredWarehouse;
   }

   public FinishedProductWareConfigDTO() {
   }

   public Boolean getBoolEnableWarehouse() {
      return this.boolEnableWarehouse;
   }

   public Integer getWarehouseNumberModeEnum() {
      return this.warehouseNumberModeEnum;
   }

   public Boolean getBoolRequiredWarehouse() {
      return this.boolRequiredWarehouse;
   }

   public void setBoolEnableWarehouse(final Boolean boolEnableWarehouse) {
      this.boolEnableWarehouse = boolEnableWarehouse;
   }

   public void setWarehouseNumberModeEnum(final Integer warehouseNumberModeEnum) {
      this.warehouseNumberModeEnum = warehouseNumberModeEnum;
   }

   public void setBoolRequiredWarehouse(final Boolean boolRequiredWarehouse) {
      this.boolRequiredWarehouse = boolRequiredWarehouse;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishedProductWareConfigDTO)) {
         return false;
      }

      FinishedProductWareConfigDTO other = (FinishedProductWareConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolEnableWarehouse = this.getBoolEnableWarehouse();
      Object other$boolEnableWarehouse = other.getBoolEnableWarehouse();
      if (this$boolEnableWarehouse == null ? other$boolEnableWarehouse == null : this$boolEnableWarehouse.equals(other$boolEnableWarehouse)) {
         Object this$warehouseNumberModeEnum = this.getWarehouseNumberModeEnum();
         Object other$warehouseNumberModeEnum = other.getWarehouseNumberModeEnum();
         if (this$warehouseNumberModeEnum == null ? other$warehouseNumberModeEnum == null : this$warehouseNumberModeEnum.equals(other$warehouseNumberModeEnum)) {
            Object this$boolRequiredWarehouse = this.getBoolRequiredWarehouse();
            Object other$boolRequiredWarehouse = other.getBoolRequiredWarehouse();
            return this$boolRequiredWarehouse == null ? other$boolRequiredWarehouse == null : this$boolRequiredWarehouse.equals(other$boolRequiredWarehouse);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FinishedProductWareConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolEnableWarehouse = this.getBoolEnableWarehouse();
      result = result * 59 + ($boolEnableWarehouse == null ? 43 : $boolEnableWarehouse.hashCode());
      Object $warehouseNumberModeEnum = this.getWarehouseNumberModeEnum();
      result = result * 59 + ($warehouseNumberModeEnum == null ? 43 : $warehouseNumberModeEnum.hashCode());
      Object $boolRequiredWarehouse = this.getBoolRequiredWarehouse();
      return result * 59 + ($boolRequiredWarehouse == null ? 43 : $boolRequiredWarehouse.hashCode());
   }

   @Override
   public String toString() {
      return "FinishedProductWareConfigDTO(boolEnableWarehouse="
         + this.getBoolEnableWarehouse()
         + ", warehouseNumberModeEnum="
         + this.getWarehouseNumberModeEnum()
         + ", boolRequiredWarehouse="
         + this.getBoolRequiredWarehouse()
         + ")";
   }

   public static class FinishedProductWareConfigDTOBuilder {
      private Boolean boolEnableWarehouse;
      private Integer warehouseNumberModeEnum;
      private Boolean boolRequiredWarehouse;

      FinishedProductWareConfigDTOBuilder() {
      }

      public FinishedProductWareConfigDTO.FinishedProductWareConfigDTOBuilder boolEnableWarehouse(final Boolean boolEnableWarehouse) {
         this.boolEnableWarehouse = boolEnableWarehouse;
         return this;
      }

      public FinishedProductWareConfigDTO.FinishedProductWareConfigDTOBuilder warehouseNumberModeEnum(final Integer warehouseNumberModeEnum) {
         this.warehouseNumberModeEnum = warehouseNumberModeEnum;
         return this;
      }

      public FinishedProductWareConfigDTO.FinishedProductWareConfigDTOBuilder boolRequiredWarehouse(final Boolean boolRequiredWarehouse) {
         this.boolRequiredWarehouse = boolRequiredWarehouse;
         return this;
      }

      public FinishedProductWareConfigDTO build() {
         return new FinishedProductWareConfigDTO(this.boolEnableWarehouse, this.warehouseNumberModeEnum, this.boolRequiredWarehouse);
      }

      @Override
      public String toString() {
         return "FinishedProductWareConfigDTO.FinishedProductWareConfigDTOBuilder(boolEnableWarehouse="
            + this.boolEnableWarehouse
            + ", warehouseNumberModeEnum="
            + this.warehouseNumberModeEnum
            + ", boolRequiredWarehouse="
            + this.boolRequiredWarehouse
            + ")";
      }
   }
}
