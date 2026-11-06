package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BusinessPriceTemp对象", description = "商务价格临时表 ")
public class BusinessPriceTempUpdateDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @NotNull(message = "单价不能为空!")
   @DecimalMin(value = "0", message = "单价不能为负数!")
   private BigDecimal unitPrice;
   @NotNull(message = "计价方式不能为空!")
   @ApiModelProperty(name = "pricingManner", value = "计价方式 构件:0重量1长度 围护:1长度2面积", notes = "计价方式 构件:0重量1长度 围护:1长度2面积")
   private Integer pricingManner;

   public static BusinessPriceTempUpdateDtoParam.BusinessPriceTempUpdateDtoParamBuilder builder() {
      return new BusinessPriceTempUpdateDtoParam.BusinessPriceTempUpdateDtoParamBuilder();
   }

   public BusinessPriceTempUpdateDtoParam() {
   }

   public BusinessPriceTempUpdateDtoParam(final Long id, final BigDecimal unitPrice, final Integer pricingManner) {
      this.id = id;
      this.unitPrice = unitPrice;
      this.pricingManner = pricingManner;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceTempUpdateDtoParam)) {
         return false;
      }

      BusinessPriceTempUpdateDtoParam other = (BusinessPriceTempUpdateDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pricingManner = this.getPricingManner();
         Object other$pricingManner = other.getPricingManner();
         if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
            Object this$unitPrice = this.getUnitPrice();
            Object other$unitPrice = other.getUnitPrice();
            return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceTempUpdateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceTempUpdateDtoParam(id=" + this.getId() + ", unitPrice=" + this.getUnitPrice() + ", pricingManner=" + this.getPricingManner() + ")";
   }

   public static class BusinessPriceTempUpdateDtoParamBuilder {
      private Long id;
      private BigDecimal unitPrice;
      private Integer pricingManner;

      BusinessPriceTempUpdateDtoParamBuilder() {
      }

      public BusinessPriceTempUpdateDtoParam.BusinessPriceTempUpdateDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceTempUpdateDtoParam.BusinessPriceTempUpdateDtoParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceTempUpdateDtoParam.BusinessPriceTempUpdateDtoParamBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessPriceTempUpdateDtoParam build() {
         return new BusinessPriceTempUpdateDtoParam(this.id, this.unitPrice, this.pricingManner);
      }

      @Override
      public String toString() {
         return "BusinessPriceTempUpdateDtoParam.BusinessPriceTempUpdateDtoParamBuilder(id="
            + this.id
            + ", unitPrice="
            + this.unitPrice
            + ", pricingManner="
            + this.pricingManner
            + ")";
      }
   }
}
