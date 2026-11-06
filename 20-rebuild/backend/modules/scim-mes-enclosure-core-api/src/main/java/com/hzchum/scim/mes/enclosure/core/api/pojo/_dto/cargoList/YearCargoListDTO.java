package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运信息汇总")
public class YearCargoListDTO {
   @ApiModelProperty(name = "cargoQuantity", value = "车次数量", notes = "车次数量")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "cargoMete", value = "发运重量", notes = "发运重量")
   @JsonProperty("cargoMete")
   @JSONField(name = "cargoMete")
   private BigDecimal cargoMete;
   @ApiModelProperty(name = "totalNetWeight", value = "清单量", notes = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "stockMete", value = "制成品库存量", notes = "制成品库存量")
   @JsonProperty("stockMete")
   @JSONField(name = "stockMete")
   private BigDecimal stockMete;

   public static YearCargoListDTO.YearCargoListDTOBuilder builder() {
      return new YearCargoListDTO.YearCargoListDTOBuilder();
   }

   public YearCargoListDTO(final Integer cargoQuantity, final BigDecimal cargoMete, final BigDecimal totalNetWeight, final BigDecimal stockMete) {
      this.cargoQuantity = cargoQuantity;
      this.cargoMete = cargoMete;
      this.totalNetWeight = totalNetWeight;
      this.stockMete = stockMete;
   }

   public YearCargoListDTO() {
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public BigDecimal getCargoMete() {
      return this.cargoMete;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   @JsonProperty("cargoQuantity")
   public void setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
   }

   @JsonProperty("cargoMete")
   public void setCargoMete(final BigDecimal cargoMete) {
      this.cargoMete = cargoMete;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("stockMete")
   public void setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearCargoListDTO)) {
         return false;
      }

      YearCargoListDTO other = (YearCargoListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cargoQuantity = this.getCargoQuantity();
      Object other$cargoQuantity = other.getCargoQuantity();
      if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
         Object this$cargoMete = this.getCargoMete();
         Object other$cargoMete = other.getCargoMete();
         if (this$cargoMete == null ? other$cargoMete == null : this$cargoMete.equals(other$cargoMete)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$stockMete = this.getStockMete();
               Object other$stockMete = other.getStockMete();
               return this$stockMete == null ? other$stockMete == null : this$stockMete.equals(other$stockMete);
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
      return other instanceof YearCargoListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $cargoMete = this.getCargoMete();
      result = result * 59 + ($cargoMete == null ? 43 : $cargoMete.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $stockMete = this.getStockMete();
      return result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
   }

   @Override
   public String toString() {
      return "YearCargoListDTO(cargoQuantity="
         + this.getCargoQuantity()
         + ", cargoMete="
         + this.getCargoMete()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", stockMete="
         + this.getStockMete()
         + ")";
   }

   public static class YearCargoListDTOBuilder {
      private Integer cargoQuantity;
      private BigDecimal cargoMete;
      private BigDecimal totalNetWeight;
      private BigDecimal stockMete;

      YearCargoListDTOBuilder() {
      }

      @JsonProperty("cargoQuantity")
      public YearCargoListDTO.YearCargoListDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("cargoMete")
      public YearCargoListDTO.YearCargoListDTOBuilder cargoMete(final BigDecimal cargoMete) {
         this.cargoMete = cargoMete;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public YearCargoListDTO.YearCargoListDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("stockMete")
      public YearCargoListDTO.YearCargoListDTOBuilder stockMete(final BigDecimal stockMete) {
         this.stockMete = stockMete;
         return this;
      }

      public YearCargoListDTO build() {
         return new YearCargoListDTO(this.cargoQuantity, this.cargoMete, this.totalNetWeight, this.stockMete);
      }

      @Override
      public String toString() {
         return "YearCargoListDTO.YearCargoListDTOBuilder(cargoQuantity="
            + this.cargoQuantity
            + ", cargoMete="
            + this.cargoMete
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", stockMete="
            + this.stockMete
            + ")";
      }
   }
}
