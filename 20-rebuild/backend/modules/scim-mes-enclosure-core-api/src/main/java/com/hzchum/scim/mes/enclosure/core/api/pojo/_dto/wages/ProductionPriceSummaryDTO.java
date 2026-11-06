package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionPriceSummaryDTO", description = "")
public class ProductionPriceSummaryDTO {
   @ApiModelProperty(name = "mete", notes = "产量", value = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static ProductionPriceSummaryDTO.ProductionPriceSummaryDTOBuilder builder() {
      return new ProductionPriceSummaryDTO.ProductionPriceSummaryDTOBuilder();
   }

   public ProductionPriceSummaryDTO(final BigDecimal mete, final BigDecimal price) {
      this.mete = mete;
      this.price = price;
   }

   public ProductionPriceSummaryDTO() {
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("mete")
   public ProductionPriceSummaryDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("price")
   public ProductionPriceSummaryDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionPriceSummaryDTO(mete=" + this.getMete() + ", price=" + this.getPrice() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionPriceSummaryDTO)) {
         return false;
      } else {
         ProductionPriceSummaryDTO other = (ProductionPriceSummaryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionPriceSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProductionPriceSummaryDTOBuilder {
      private BigDecimal mete;
      private BigDecimal price;

      ProductionPriceSummaryDTOBuilder() {
      }

      @JsonProperty("mete")
      public ProductionPriceSummaryDTO.ProductionPriceSummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("price")
      public ProductionPriceSummaryDTO.ProductionPriceSummaryDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProductionPriceSummaryDTO build() {
         return new ProductionPriceSummaryDTO(this.mete, this.price);
      }

      @Override
      public String toString() {
         return "ProductionPriceSummaryDTO.ProductionPriceSummaryDTOBuilder(mete=" + this.mete + ", price=" + this.price + ")";
      }
   }
}
