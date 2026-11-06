package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@ApiModel("设置修改价格")
public class ProductBusinessPriceDtoParam {
   @ApiModelProperty(name = "商务id", value = "商务id", notes = "商务id")
   @NotNull(message = "商务标id不能为空")
   private Long id;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @NotNull(message = "标准件单价不能为空")
   @DecimalMin(value = "0", message = "价格不能为负值!")
   private BigDecimal unitPrice;

   public static ProductBusinessPriceDtoParam.ProductBusinessPriceDtoParamBuilder builder() {
      return new ProductBusinessPriceDtoParam.ProductBusinessPriceDtoParamBuilder();
   }

   public ProductBusinessPriceDtoParam() {
   }

   public ProductBusinessPriceDtoParam(final Long id, final BigDecimal unitPrice) {
      this.id = id;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductBusinessPriceDtoParam)) {
         return false;
      } else {
         ProductBusinessPriceDtoParam other = (ProductBusinessPriceDtoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$unitPrice = this.getUnitPrice();
               Object other$unitPrice = other.getUnitPrice();
               return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductBusinessPriceDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "ProductBusinessPriceDtoParam(id=" + this.getId() + ", unitPrice=" + this.getUnitPrice() + ")";
   }

   public static class ProductBusinessPriceDtoParamBuilder {
      private Long id;
      private BigDecimal unitPrice;

      ProductBusinessPriceDtoParamBuilder() {
      }

      public ProductBusinessPriceDtoParam.ProductBusinessPriceDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProductBusinessPriceDtoParam.ProductBusinessPriceDtoParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ProductBusinessPriceDtoParam build() {
         return new ProductBusinessPriceDtoParam(this.id, this.unitPrice);
      }

      @Override
      public String toString() {
         return "ProductBusinessPriceDtoParam.ProductBusinessPriceDtoParamBuilder(id=" + this.id + ", unitPrice=" + this.unitPrice + ")";
      }
   }
}
