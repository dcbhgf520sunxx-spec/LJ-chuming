package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class YearCargoListMeteDTO {
   @ApiModelProperty(name = "quantity", value = "车次数量", notes = "车次数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "发运重量", notes = "发运重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   public static YearCargoListMeteDTO.YearCargoListMeteDTOBuilder builder() {
      return new YearCargoListMeteDTO.YearCargoListMeteDTOBuilder();
   }

   public YearCargoListMeteDTO(final Integer quantity, final BigDecimal mete) {
      this.quantity = quantity;
      this.mete = mete;
   }

   public YearCargoListMeteDTO() {
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
      } else if (!(o instanceof YearCargoListMeteDTO)) {
         return false;
      } else {
         YearCargoListMeteDTO other = (YearCargoListMeteDTO)o;
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
      return other instanceof YearCargoListMeteDTO;
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
      return "YearCargoListMeteDTO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   public static class YearCargoListMeteDTOBuilder {
      private Integer quantity;
      private BigDecimal mete;

      YearCargoListMeteDTOBuilder() {
      }

      @JsonProperty("quantity")
      public YearCargoListMeteDTO.YearCargoListMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public YearCargoListMeteDTO.YearCargoListMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public YearCargoListMeteDTO build() {
         return new YearCargoListMeteDTO(this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "YearCargoListMeteDTO.YearCargoListMeteDTOBuilder(quantity=" + this.quantity + ", mete=" + this.mete + ")";
      }
   }
}
