package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class DeficitConfig {
   private Integer inventoryType;

   public static DeficitConfig.DeficitConfigBuilder builder() {
      return new DeficitConfig.DeficitConfigBuilder();
   }

   public Integer getInventoryType() {
      return this.inventoryType;
   }

   public void setInventoryType(final Integer inventoryType) {
      this.inventoryType = inventoryType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeficitConfig)) {
         return false;
      }

      DeficitConfig other = (DeficitConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inventoryType = this.getInventoryType();
      Object other$inventoryType = other.getInventoryType();
      return this$inventoryType == null ? other$inventoryType == null : this$inventoryType.equals(other$inventoryType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeficitConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inventoryType = this.getInventoryType();
      return result * 59 + ($inventoryType == null ? 43 : $inventoryType.hashCode());
   }

   @Override
   public String toString() {
      return "DeficitConfig(inventoryType=" + this.getInventoryType() + ")";
   }

   public DeficitConfig(final Integer inventoryType) {
      this.inventoryType = inventoryType;
   }

   public DeficitConfig() {
   }

   public static class DeficitConfigBuilder {
      private Integer inventoryType;

      DeficitConfigBuilder() {
      }

      public DeficitConfig.DeficitConfigBuilder inventoryType(final Integer inventoryType) {
         this.inventoryType = inventoryType;
         return this;
      }

      public DeficitConfig build() {
         return new DeficitConfig(this.inventoryType);
      }

      @Override
      public String toString() {
         return "DeficitConfig.DeficitConfigBuilder(inventoryType=" + this.inventoryType + ")";
      }
   }
}
