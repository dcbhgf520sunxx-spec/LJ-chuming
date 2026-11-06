package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class InboundPriceSummaryDTO {
   @ApiModelProperty(name = "dateTime", value = "入库时间")
   private String dateTime;
   @ApiModelProperty(name = "avgPrice", value = "")
   private BigDecimal mete;
   @ApiModelProperty(name = "avgPrice", value = "")
   private BigDecimal price;
   @ApiModelProperty(name = "avgPrice", value = "入库价格（元/吨）")
   private BigDecimal avgPrice;

   public static InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder builder() {
      return new InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAvgPrice() {
      return this.avgPrice;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAvgPrice(final BigDecimal avgPrice) {
      this.avgPrice = avgPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundPriceSummaryDTO)) {
         return false;
      }

      InboundPriceSummaryDTO other = (InboundPriceSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTime = this.getDateTime();
      Object other$dateTime = other.getDateTime();
      if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
               Object this$avgPrice = this.getAvgPrice();
               Object other$avgPrice = other.getAvgPrice();
               return this$avgPrice == null ? other$avgPrice == null : this$avgPrice.equals(other$avgPrice);
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
      return other instanceof InboundPriceSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $avgPrice = this.getAvgPrice();
      return result * 59 + ($avgPrice == null ? 43 : $avgPrice.hashCode());
   }

   @Override
   public String toString() {
      return "InboundPriceSummaryDTO(dateTime="
         + this.getDateTime()
         + ", mete="
         + this.getMete()
         + ", price="
         + this.getPrice()
         + ", avgPrice="
         + this.getAvgPrice()
         + ")";
   }

   public InboundPriceSummaryDTO(final String dateTime, final BigDecimal mete, final BigDecimal price, final BigDecimal avgPrice) {
      this.dateTime = dateTime;
      this.mete = mete;
      this.price = price;
      this.avgPrice = avgPrice;
   }

   public InboundPriceSummaryDTO() {
   }

   public static class InboundPriceSummaryDTOBuilder {
      private String dateTime;
      private BigDecimal mete;
      private BigDecimal price;
      private BigDecimal avgPrice;

      InboundPriceSummaryDTOBuilder() {
      }

      public InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder avgPrice(final BigDecimal avgPrice) {
         this.avgPrice = avgPrice;
         return this;
      }

      public InboundPriceSummaryDTO build() {
         return new InboundPriceSummaryDTO(this.dateTime, this.mete, this.price, this.avgPrice);
      }

      @Override
      public String toString() {
         return "InboundPriceSummaryDTO.InboundPriceSummaryDTOBuilder(dateTime="
            + this.dateTime
            + ", mete="
            + this.mete
            + ", price="
            + this.price
            + ", avgPrice="
            + this.avgPrice
            + ")";
      }
   }
}
