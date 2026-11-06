package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class MaterialConfig {
   private Integer inventoryGainType;

   public static MaterialConfig.MaterialConfigBuilder builder() {
      return new MaterialConfig.MaterialConfigBuilder();
   }

   public Integer getInventoryGainType() {
      return this.inventoryGainType;
   }

   public void setInventoryGainType(final Integer inventoryGainType) {
      this.inventoryGainType = inventoryGainType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialConfig)) {
         return false;
      }

      MaterialConfig other = (MaterialConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inventoryGainType = this.getInventoryGainType();
      Object other$inventoryGainType = other.getInventoryGainType();
      return this$inventoryGainType == null ? other$inventoryGainType == null : this$inventoryGainType.equals(other$inventoryGainType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaterialConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inventoryGainType = this.getInventoryGainType();
      return result * 59 + ($inventoryGainType == null ? 43 : $inventoryGainType.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialConfig(inventoryGainType=" + this.getInventoryGainType() + ")";
   }

   public MaterialConfig(final Integer inventoryGainType) {
      this.inventoryGainType = inventoryGainType;
   }

   public MaterialConfig() {
   }

   public static class MaterialConfigBuilder {
      private Integer inventoryGainType;

      MaterialConfigBuilder() {
      }

      public MaterialConfig.MaterialConfigBuilder inventoryGainType(final Integer inventoryGainType) {
         this.inventoryGainType = inventoryGainType;
         return this;
      }

      public MaterialConfig build() {
         return new MaterialConfig(this.inventoryGainType);
      }

      @Override
      public String toString() {
         return "MaterialConfig.MaterialConfigBuilder(inventoryGainType=" + this.inventoryGainType + ")";
      }
   }
}
