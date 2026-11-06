package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BusinessPriceDetail对象", description = "商务产品计价明细表 ")
public class BusinessPriceDetailParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @NotNull(message = "未知产品id!")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @NotNull(message = "未传产品计价数量!")
   private BigDecimal quantity;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;

   public static BusinessPriceDetailParam.BusinessPriceDetailParamBuilder builder() {
      return new BusinessPriceDetailParam.BusinessPriceDetailParamBuilder();
   }

   public BusinessPriceDetailParam() {
   }

   public BusinessPriceDetailParam(final Long id, final Long productId, final BigDecimal quantity, final BigDecimal unitPrice) {
      this.id = id;
      this.productId = productId;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceDetailParam)) {
         return false;
      }

      BusinessPriceDetailParam other = (BusinessPriceDetailParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$unitPrice = this.getUnitPrice();
               Object other$unitPrice = other.getUnitPrice();
               return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof BusinessPriceDetailParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceDetailParam(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   public static class BusinessPriceDetailParamBuilder {
      private Long id;
      private Long productId;
      private BigDecimal quantity;
      private BigDecimal unitPrice;

      BusinessPriceDetailParamBuilder() {
      }

      public BusinessPriceDetailParam.BusinessPriceDetailParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceDetailParam.BusinessPriceDetailParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public BusinessPriceDetailParam.BusinessPriceDetailParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BusinessPriceDetailParam.BusinessPriceDetailParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceDetailParam build() {
         return new BusinessPriceDetailParam(this.id, this.productId, this.quantity, this.unitPrice);
      }

      @Override
      public String toString() {
         return "BusinessPriceDetailParam.BusinessPriceDetailParamBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
