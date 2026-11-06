package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class YearCargoListMeteDO {
   @ApiModelProperty(name = "quantity", value = "车次数量", notes = "车次数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "发运重量", notes = "发运重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalLength", value = "发运长度", notes = "发运长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "发运面积", notes = "发运面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;

   public static YearCargoListMeteDO.YearCargoListMeteDOBuilder builder() {
      return new YearCargoListMeteDO.YearCargoListMeteDOBuilder();
   }

   public YearCargoListMeteDO(final Integer quantity, final BigDecimal mete, final BigDecimal totalLength, final BigDecimal totalArea) {
      this.quantity = quantity;
      this.mete = mete;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
   }

   public YearCargoListMeteDO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @JsonProperty("totalArea")
   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearCargoListMeteDO)) {
         return false;
      }

      YearCargoListMeteDO other = (YearCargoListMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$totalLength = this.getTotalLength();
            Object other$totalLength = other.getTotalLength();
            if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
               Object this$totalArea = this.getTotalArea();
               Object other$totalArea = other.getTotalArea();
               return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof YearCargoListMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "YearCargoListMeteDO(quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }

   public static class YearCargoListMeteDOBuilder {
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal totalLength;
      private BigDecimal totalArea;

      YearCargoListMeteDOBuilder() {
      }

      @JsonProperty("quantity")
      public YearCargoListMeteDO.YearCargoListMeteDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public YearCargoListMeteDO.YearCargoListMeteDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("totalLength")
      public YearCargoListMeteDO.YearCargoListMeteDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public YearCargoListMeteDO.YearCargoListMeteDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public YearCargoListMeteDO build() {
         return new YearCargoListMeteDO(this.quantity, this.mete, this.totalLength, this.totalArea);
      }

      @Override
      public String toString() {
         return "YearCargoListMeteDO.YearCargoListMeteDOBuilder(quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
