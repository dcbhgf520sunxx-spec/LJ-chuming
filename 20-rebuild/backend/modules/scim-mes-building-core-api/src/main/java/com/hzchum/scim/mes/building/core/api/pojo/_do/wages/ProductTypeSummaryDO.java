package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductTypeSummaryDTO", description = "")
public class ProductTypeSummaryDO {
   @ApiModelProperty(name = "productClass", notes = "产品类型", value = "产品类型")
   @JsonProperty("productClass")
   @JSONField(name = "productClass")
   private IdAndNameDO productClass;
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "grossWeight", notes = "总毛重量", value = "总毛重量")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "netWeight", notes = "总净重量", value = "总净重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;

   public static ProductTypeSummaryDO.ProductTypeSummaryDOBuilder builder() {
      return new ProductTypeSummaryDO.ProductTypeSummaryDOBuilder();
   }

   public ProductTypeSummaryDO(final IdAndNameDO productClass, final Integer quantity, final BigDecimal grossWeight, final BigDecimal netWeight) {
      this.productClass = productClass;
      this.quantity = quantity;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
   }

   public ProductTypeSummaryDO() {
   }

   public IdAndNameDO getProductClass() {
      return this.productClass;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("productClass")
   public ProductTypeSummaryDO setProductClass(final IdAndNameDO productClass) {
      this.productClass = productClass;
      return this;
   }

   @JsonProperty("quantity")
   public ProductTypeSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("grossWeight")
   public ProductTypeSummaryDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductTypeSummaryDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProductTypeSummaryDO(productClass="
         + this.getProductClass()
         + ", quantity="
         + this.getQuantity()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductTypeSummaryDO)) {
         return false;
      }

      ProductTypeSummaryDO other = (ProductTypeSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$productClass = this.getProductClass();
         Object other$productClass = other.getProductClass();
         if (this$productClass == null ? other$productClass == null : this$productClass.equals(other$productClass)) {
            Object this$grossWeight = this.getGrossWeight();
            Object other$grossWeight = other.getGrossWeight();
            if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof ProductTypeSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productClass = this.getProductClass();
      result = result * 59 + ($productClass == null ? 43 : $productClass.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class ProductTypeSummaryDOBuilder {
      private IdAndNameDO productClass;
      private Integer quantity;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;

      ProductTypeSummaryDOBuilder() {
      }

      @JsonProperty("productClass")
      public ProductTypeSummaryDO.ProductTypeSummaryDOBuilder productClass(final IdAndNameDO productClass) {
         this.productClass = productClass;
         return this;
      }

      @JsonProperty("quantity")
      public ProductTypeSummaryDO.ProductTypeSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("grossWeight")
      public ProductTypeSummaryDO.ProductTypeSummaryDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductTypeSummaryDO.ProductTypeSummaryDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProductTypeSummaryDO build() {
         return new ProductTypeSummaryDO(this.productClass, this.quantity, this.grossWeight, this.netWeight);
      }

      @Override
      public String toString() {
         return "ProductTypeSummaryDO.ProductTypeSummaryDOBuilder(productClass="
            + this.productClass
            + ", quantity="
            + this.quantity
            + ", grossWeight="
            + this.grossWeight
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
