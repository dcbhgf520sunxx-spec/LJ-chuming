package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class CargoListMeteDTO {
   @ApiModelProperty("发运量")
   private BigDecimal weight;
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;

   CargoListMeteDTO(final BigDecimal weight, final BigDecimal actualWeight) {
      this.weight = weight;
      this.actualWeight = actualWeight;
   }

   public static CargoListMeteDTO.CargoListMeteDTOBuilder builder() {
      return new CargoListMeteDTO.CargoListMeteDTOBuilder();
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CargoListMeteDTO)) {
         return false;
      } else {
         CargoListMeteDTO other = (CargoListMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$weight = this.getWeight();
            Object other$weight = other.getWeight();
            if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
               Object this$actualWeight = this.getActualWeight();
               Object other$actualWeight = other.getActualWeight();
               return this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $actualWeight = this.getActualWeight();
      return result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListMeteDTO(weight=" + this.getWeight() + ", actualWeight=" + this.getActualWeight() + ")";
   }

   public static class CargoListMeteDTOBuilder {
      private BigDecimal weight;
      private BigDecimal actualWeight;

      CargoListMeteDTOBuilder() {
      }

      public CargoListMeteDTO.CargoListMeteDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CargoListMeteDTO.CargoListMeteDTOBuilder actualWeight(final BigDecimal actualWeight) {
         this.actualWeight = actualWeight;
         return this;
      }

      public CargoListMeteDTO build() {
         return new CargoListMeteDTO(this.weight, this.actualWeight);
      }

      @Override
      public String toString() {
         return "CargoListMeteDTO.CargoListMeteDTOBuilder(weight=" + this.weight + ", actualWeight=" + this.actualWeight + ")";
      }
   }
}
