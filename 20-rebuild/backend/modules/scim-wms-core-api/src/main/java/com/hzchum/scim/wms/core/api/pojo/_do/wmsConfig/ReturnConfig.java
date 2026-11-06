package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class ReturnConfig {
   private Integer returnType;
   private Integer returnDestination;

   public static ReturnConfig.ReturnConfigBuilder builder() {
      return new ReturnConfig.ReturnConfigBuilder();
   }

   public Integer getReturnType() {
      return this.returnType;
   }

   public Integer getReturnDestination() {
      return this.returnDestination;
   }

   public void setReturnType(final Integer returnType) {
      this.returnType = returnType;
   }

   public void setReturnDestination(final Integer returnDestination) {
      this.returnDestination = returnDestination;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReturnConfig)) {
         return false;
      } else {
         ReturnConfig other = (ReturnConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$returnType = this.getReturnType();
            Object other$returnType = other.getReturnType();
            if (this$returnType == null ? other$returnType == null : this$returnType.equals(other$returnType)) {
               Object this$returnDestination = this.getReturnDestination();
               Object other$returnDestination = other.getReturnDestination();
               return this$returnDestination == null ? other$returnDestination == null : this$returnDestination.equals(other$returnDestination);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReturnConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $returnType = this.getReturnType();
      result = result * 59 + ($returnType == null ? 43 : $returnType.hashCode());
      Object $returnDestination = this.getReturnDestination();
      return result * 59 + ($returnDestination == null ? 43 : $returnDestination.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnConfig(returnType=" + this.getReturnType() + ", returnDestination=" + this.getReturnDestination() + ")";
   }

   public ReturnConfig(final Integer returnType, final Integer returnDestination) {
      this.returnType = returnType;
      this.returnDestination = returnDestination;
   }

   public ReturnConfig() {
   }

   public static class ReturnConfigBuilder {
      private Integer returnType;
      private Integer returnDestination;

      ReturnConfigBuilder() {
      }

      public ReturnConfig.ReturnConfigBuilder returnType(final Integer returnType) {
         this.returnType = returnType;
         return this;
      }

      public ReturnConfig.ReturnConfigBuilder returnDestination(final Integer returnDestination) {
         this.returnDestination = returnDestination;
         return this;
      }

      public ReturnConfig build() {
         return new ReturnConfig(this.returnType, this.returnDestination);
      }

      @Override
      public String toString() {
         return "ReturnConfig.ReturnConfigBuilder(returnType=" + this.returnType + ", returnDestination=" + this.returnDestination + ")";
      }
   }
}
