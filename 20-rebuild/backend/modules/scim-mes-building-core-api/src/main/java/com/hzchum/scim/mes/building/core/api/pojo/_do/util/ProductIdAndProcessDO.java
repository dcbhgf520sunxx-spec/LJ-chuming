package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ProductIdAndProcessDO {
   @ApiModelProperty(name = "productId", notes = "productId")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "boolenProcess", value = "是否有工序")
   @JsonProperty("boolenProcess")
   @JSONField(name = "boolenProcess")
   private Boolean boolenProcess;

   public static ProductIdAndProcessDO.ProductIdAndProcessDOBuilder builder() {
      return new ProductIdAndProcessDO.ProductIdAndProcessDOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Boolean getBoolenProcess() {
      return this.boolenProcess;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("boolenProcess")
   public void setBoolenProcess(final Boolean boolenProcess) {
      this.boolenProcess = boolenProcess;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductIdAndProcessDO)) {
         return false;
      } else {
         ProductIdAndProcessDO other = (ProductIdAndProcessDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$boolenProcess = this.getBoolenProcess();
               Object other$boolenProcess = other.getBoolenProcess();
               return this$boolenProcess == null ? other$boolenProcess == null : this$boolenProcess.equals(other$boolenProcess);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductIdAndProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $boolenProcess = this.getBoolenProcess();
      return result * 59 + ($boolenProcess == null ? 43 : $boolenProcess.hashCode());
   }

   @Override
   public String toString() {
      return "ProductIdAndProcessDO(productId=" + this.getProductId() + ", boolenProcess=" + this.getBoolenProcess() + ")";
   }

   public ProductIdAndProcessDO(final Long productId, final Boolean boolenProcess) {
      this.productId = productId;
      this.boolenProcess = boolenProcess;
   }

   public ProductIdAndProcessDO() {
   }

   public static class ProductIdAndProcessDOBuilder {
      private Long productId;
      private Boolean boolenProcess;

      ProductIdAndProcessDOBuilder() {
      }

      @JsonProperty("productId")
      public ProductIdAndProcessDO.ProductIdAndProcessDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("boolenProcess")
      public ProductIdAndProcessDO.ProductIdAndProcessDOBuilder boolenProcess(final Boolean boolenProcess) {
         this.boolenProcess = boolenProcess;
         return this;
      }

      public ProductIdAndProcessDO build() {
         return new ProductIdAndProcessDO(this.productId, this.boolenProcess);
      }

      @Override
      public String toString() {
         return "ProductIdAndProcessDO.ProductIdAndProcessDOBuilder(productId=" + this.productId + ", boolenProcess=" + this.boolenProcess + ")";
      }
   }
}
