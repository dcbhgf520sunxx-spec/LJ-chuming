package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class TransferConfig {
   private Integer transferType;

   public static TransferConfig.TransferConfigBuilder builder() {
      return new TransferConfig.TransferConfigBuilder();
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferConfig)) {
         return false;
      }

      TransferConfig other = (TransferConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$transferType = this.getTransferType();
      Object other$transferType = other.getTransferType();
      return this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TransferConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $transferType = this.getTransferType();
      return result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
   }

   @Override
   public String toString() {
      return "TransferConfig(transferType=" + this.getTransferType() + ")";
   }

   public TransferConfig(final Integer transferType) {
      this.transferType = transferType;
   }

   public TransferConfig() {
   }

   public static class TransferConfigBuilder {
      private Integer transferType;

      TransferConfigBuilder() {
      }

      public TransferConfig.TransferConfigBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public TransferConfig build() {
         return new TransferConfig(this.transferType);
      }

      @Override
      public String toString() {
         return "TransferConfig.TransferConfigBuilder(transferType=" + this.transferType + ")";
      }
   }
}
