package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class MaterialWarehouseConfig {
   private Integer materialWarehouseType;

   public static MaterialWarehouseConfig.MaterialWarehouseConfigBuilder builder() {
      return new MaterialWarehouseConfig.MaterialWarehouseConfigBuilder();
   }

   public Integer getMaterialWarehouseType() {
      return this.materialWarehouseType;
   }

   public void setMaterialWarehouseType(final Integer materialWarehouseType) {
      this.materialWarehouseType = materialWarehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialWarehouseConfig)) {
         return false;
      }

      MaterialWarehouseConfig other = (MaterialWarehouseConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialWarehouseType = this.getMaterialWarehouseType();
      Object other$materialWarehouseType = other.getMaterialWarehouseType();
      return this$materialWarehouseType == null ? other$materialWarehouseType == null : this$materialWarehouseType.equals(other$materialWarehouseType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaterialWarehouseConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialWarehouseType = this.getMaterialWarehouseType();
      return result * 59 + ($materialWarehouseType == null ? 43 : $materialWarehouseType.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialWarehouseConfig(materialWarehouseType=" + this.getMaterialWarehouseType() + ")";
   }

   public MaterialWarehouseConfig(final Integer materialWarehouseType) {
      this.materialWarehouseType = materialWarehouseType;
   }

   public MaterialWarehouseConfig() {
   }

   public static class MaterialWarehouseConfigBuilder {
      private Integer materialWarehouseType;

      MaterialWarehouseConfigBuilder() {
      }

      public MaterialWarehouseConfig.MaterialWarehouseConfigBuilder materialWarehouseType(final Integer materialWarehouseType) {
         this.materialWarehouseType = materialWarehouseType;
         return this;
      }

      public MaterialWarehouseConfig build() {
         return new MaterialWarehouseConfig(this.materialWarehouseType);
      }

      @Override
      public String toString() {
         return "MaterialWarehouseConfig.MaterialWarehouseConfigBuilder(materialWarehouseType=" + this.materialWarehouseType + ")";
      }
   }
}
