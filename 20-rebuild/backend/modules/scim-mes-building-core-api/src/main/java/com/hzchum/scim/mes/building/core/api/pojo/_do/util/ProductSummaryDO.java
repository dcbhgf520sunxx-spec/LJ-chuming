package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductSummaryDO", description = "产品汇总信息")
public class ProductSummaryDO {
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "重量", value = "重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "surfaceArea", notes = "面积", value = "面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;

   public static ProductSummaryDO.ProductSummaryDOBuilder builder() {
      return new ProductSummaryDO.ProductSummaryDOBuilder();
   }

   public ProductSummaryDO() {
   }

   public ProductSummaryDO(final Integer quantity, final BigDecimal netWeight, final BigDecimal surfaceArea) {
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.surfaceArea = surfaceArea;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   @JsonProperty("quantity")
   public ProductSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductSummaryDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ProductSummaryDO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @Override
   public String toString() {
      return "ProductSummaryDO(quantity=" + this.getQuantity() + ", netWeight=" + this.getNetWeight() + ", surfaceArea=" + this.getSurfaceArea() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductSummaryDO)) {
         return false;
      }

      ProductSummaryDO other = (ProductSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$netWeight = this.getNetWeight();
         Object other$netWeight = other.getNetWeight();
         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
            Object this$surfaceArea = this.getSurfaceArea();
            Object other$surfaceArea = other.getSurfaceArea();
            return this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      return result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
   }

   public static class ProductSummaryDOBuilder {
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal surfaceArea;

      ProductSummaryDOBuilder() {
      }

      @JsonProperty("quantity")
      public ProductSummaryDO.ProductSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductSummaryDO.ProductSummaryDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ProductSummaryDO.ProductSummaryDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ProductSummaryDO build() {
         return new ProductSummaryDO(this.quantity, this.netWeight, this.surfaceArea);
      }

      @Override
      public String toString() {
         return "ProductSummaryDO.ProductSummaryDOBuilder(quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ")";
      }
   }
}
