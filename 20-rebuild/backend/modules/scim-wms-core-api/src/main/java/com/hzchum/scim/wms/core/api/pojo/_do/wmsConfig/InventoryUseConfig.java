package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class InventoryUseConfig {
   private Boolean boolEndMonth;
   private Boolean brand;
   private Boolean projectId;
   private Boolean workshopId;
   private Boolean warehouseId;
   private Boolean color;
   private Boolean heatNoAndBatchNo;

   public static InventoryUseConfig.InventoryUseConfigBuilder builder() {
      return new InventoryUseConfig.InventoryUseConfigBuilder();
   }

   public Boolean getBoolEndMonth() {
      return this.boolEndMonth;
   }

   public Boolean getBrand() {
      return this.brand;
   }

   public Boolean getProjectId() {
      return this.projectId;
   }

   public Boolean getWorkshopId() {
      return this.workshopId;
   }

   public Boolean getWarehouseId() {
      return this.warehouseId;
   }

   public Boolean getColor() {
      return this.color;
   }

   public Boolean getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public void setBoolEndMonth(final Boolean boolEndMonth) {
      this.boolEndMonth = boolEndMonth;
   }

   public void setBrand(final Boolean brand) {
      this.brand = brand;
   }

   public void setProjectId(final Boolean projectId) {
      this.projectId = projectId;
   }

   public void setWorkshopId(final Boolean workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Boolean warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setColor(final Boolean color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final Boolean heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryUseConfig)) {
         return false;
      }

      InventoryUseConfig other = (InventoryUseConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolEndMonth = this.getBoolEndMonth();
      Object other$boolEndMonth = other.getBoolEndMonth();
      if (this$boolEndMonth == null ? other$boolEndMonth == null : this$boolEndMonth.equals(other$boolEndMonth)) {
         Object this$brand = this.getBrand();
         Object other$brand = other.getBrand();
         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$color = this.getColor();
                     Object other$color = other.getColor();
                     if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                        Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                        Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                        return this$heatNoAndBatchNo == null ? other$heatNoAndBatchNo == null : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventoryUseConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolEndMonth = this.getBoolEndMonth();
      result = result * 59 + ($boolEndMonth == null ? 43 : $boolEndMonth.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      return result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryUseConfig(boolEndMonth="
         + this.getBoolEndMonth()
         + ", brand="
         + this.getBrand()
         + ", projectId="
         + this.getProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ")";
   }

   public InventoryUseConfig(
      final Boolean boolEndMonth,
      final Boolean brand,
      final Boolean projectId,
      final Boolean workshopId,
      final Boolean warehouseId,
      final Boolean color,
      final Boolean heatNoAndBatchNo
   ) {
      this.boolEndMonth = boolEndMonth;
      this.brand = brand;
      this.projectId = projectId;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public InventoryUseConfig() {
   }

   public static class InventoryUseConfigBuilder {
      private Boolean boolEndMonth;
      private Boolean brand;
      private Boolean projectId;
      private Boolean workshopId;
      private Boolean warehouseId;
      private Boolean color;
      private Boolean heatNoAndBatchNo;

      InventoryUseConfigBuilder() {
      }

      public InventoryUseConfig.InventoryUseConfigBuilder boolEndMonth(final Boolean boolEndMonth) {
         this.boolEndMonth = boolEndMonth;
         return this;
      }

      public InventoryUseConfig.InventoryUseConfigBuilder brand(final Boolean brand) {
         this.brand = brand;
         return this;
      }

      public InventoryUseConfig.InventoryUseConfigBuilder projectId(final Boolean projectId) {
         this.projectId = projectId;
         return this;
      }

      public InventoryUseConfig.InventoryUseConfigBuilder workshopId(final Boolean workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InventoryUseConfig.InventoryUseConfigBuilder warehouseId(final Boolean warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public InventoryUseConfig.InventoryUseConfigBuilder color(final Boolean color) {
         this.color = color;
         return this;
      }

      public InventoryUseConfig.InventoryUseConfigBuilder heatNoAndBatchNo(final Boolean heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InventoryUseConfig build() {
         return new InventoryUseConfig(this.boolEndMonth, this.brand, this.projectId, this.workshopId, this.warehouseId, this.color, this.heatNoAndBatchNo);
      }

      @Override
      public String toString() {
         return "InventoryUseConfig.InventoryUseConfigBuilder(boolEndMonth="
            + this.boolEndMonth
            + ", brand="
            + this.brand
            + ", projectId="
            + this.projectId
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ")";
      }
   }
}
