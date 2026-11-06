package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

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

   public static YearCargoListMeteDO.YearCargoListMeteDOBuilder builder() {
      return new YearCargoListMeteDO.YearCargoListMeteDOBuilder();
   }

   public YearCargoListMeteDO(final Integer quantity, final BigDecimal mete) {
      this.quantity = quantity;
      this.mete = mete;
   }

   public YearCargoListMeteDO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof YearCargoListMeteDO)) {
         return false;
      } else {
         YearCargoListMeteDO other = (YearCargoListMeteDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
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
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "YearCargoListMeteDO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   public static class YearCargoListMeteDOBuilder {
      private Integer quantity;
      private BigDecimal mete;

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

      public YearCargoListMeteDO build() {
         return new YearCargoListMeteDO(this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "YearCargoListMeteDO.YearCargoListMeteDOBuilder(quantity=" + this.quantity + ", mete=" + this.mete + ")";
      }
   }
}
