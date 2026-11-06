package com.hzchum.scim.business.core.api.pojo.dtoParam;

import javax.validation.constraints.NotNull;

public class BindDTOParam {
   @NotNull(message = "产品id不能为空")
   private Long productId;
   private Long businessId;
   private String name;

   public static BindDTOParam.BindDTOParamBuilder builder() {
      return new BindDTOParam.BindDTOParamBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public String getName() {
      return this.name;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BindDTOParam)) {
         return false;
      }

      BindDTOParam other = (BindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$businessId = this.getBusinessId();
         Object other$businessId = other.getBusinessId();
         if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "BindDTOParam(productId=" + this.getProductId() + ", businessId=" + this.getBusinessId() + ", name=" + this.getName() + ")";
   }

   public BindDTOParam() {
   }

   public BindDTOParam(final Long productId, final Long businessId, final String name) {
      this.productId = productId;
      this.businessId = businessId;
      this.name = name;
   }

   public static class BindDTOParamBuilder {
      private Long productId;
      private Long businessId;
      private String name;

      BindDTOParamBuilder() {
      }

      public BindDTOParam.BindDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public BindDTOParam.BindDTOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public BindDTOParam.BindDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BindDTOParam build() {
         return new BindDTOParam(this.productId, this.businessId, this.name);
      }

      @Override
      public String toString() {
         return "BindDTOParam.BindDTOParamBuilder(productId=" + this.productId + ", businessId=" + this.businessId + ", name=" + this.name + ")";
      }
   }
}
