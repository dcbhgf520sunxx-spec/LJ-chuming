package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessPriceDateDetailsDTO", description = "")
public class ProcessPriceDateDetailsDTO {
   @ApiModelProperty(name = "dayTime", notes = "日期", value = "日期")
   @JsonProperty("dayTime")
   @JSONField(name = "dayTime")
   private String dayTime;
   @ApiModelProperty(name = "mete", notes = "产量", value = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static ProcessPriceDateDetailsDTO.ProcessPriceDateDetailsDTOBuilder builder() {
      return new ProcessPriceDateDetailsDTO.ProcessPriceDateDetailsDTOBuilder();
   }

   public ProcessPriceDateDetailsDTO(final String dayTime, final BigDecimal mete, final BigDecimal price) {
      this.dayTime = dayTime;
      this.mete = mete;
      this.price = price;
   }

   public ProcessPriceDateDetailsDTO() {
   }

   public String getDayTime() {
      return this.dayTime;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("dayTime")
   public ProcessPriceDateDetailsDTO setDayTime(final String dayTime) {
      this.dayTime = dayTime;
      return this;
   }

   @JsonProperty("mete")
   public ProcessPriceDateDetailsDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("price")
   public ProcessPriceDateDetailsDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessPriceDateDetailsDTO(dayTime=" + this.getDayTime() + ", mete=" + this.getMete() + ", price=" + this.getPrice() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessPriceDateDetailsDTO)) {
         return false;
      }

      ProcessPriceDateDetailsDTO other = (ProcessPriceDateDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dayTime = this.getDayTime();
      Object other$dayTime = other.getDayTime();
      if (this$dayTime == null ? other$dayTime == null : this$dayTime.equals(other$dayTime)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            return this$price == null ? other$price == null : this$price.equals(other$price);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessPriceDateDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dayTime = this.getDayTime();
      result = result * 59 + ($dayTime == null ? 43 : $dayTime.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProcessPriceDateDetailsDTOBuilder {
      private String dayTime;
      private BigDecimal mete;
      private BigDecimal price;

      ProcessPriceDateDetailsDTOBuilder() {
      }

      @JsonProperty("dayTime")
      public ProcessPriceDateDetailsDTO.ProcessPriceDateDetailsDTOBuilder dayTime(final String dayTime) {
         this.dayTime = dayTime;
         return this;
      }

      @JsonProperty("mete")
      public ProcessPriceDateDetailsDTO.ProcessPriceDateDetailsDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("price")
      public ProcessPriceDateDetailsDTO.ProcessPriceDateDetailsDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProcessPriceDateDetailsDTO build() {
         return new ProcessPriceDateDetailsDTO(this.dayTime, this.mete, this.price);
      }

      @Override
      public String toString() {
         return "ProcessPriceDateDetailsDTO.ProcessPriceDateDetailsDTOBuilder(dayTime=" + this.dayTime + ", mete=" + this.mete + ", price=" + this.price + ")";
      }
   }
}
