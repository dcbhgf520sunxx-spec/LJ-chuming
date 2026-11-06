package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class CargoListMeteDTO {
   @ApiModelProperty("发运量")
   private BigDecimal weight;

   CargoListMeteDTO(final BigDecimal weight) {
      this.weight = weight;
   }

   public static CargoListMeteDTO.CargoListMeteDTOBuilder builder() {
      return new CargoListMeteDTO.CargoListMeteDTOBuilder();
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListMeteDTO)) {
         return false;
      }

      CargoListMeteDTO other = (CargoListMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$weight = this.getWeight();
      Object other$weight = other.getWeight();
      return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListMeteDTO(weight=" + this.getWeight() + ")";
   }

   public static class CargoListMeteDTOBuilder {
      private BigDecimal weight;

      CargoListMeteDTOBuilder() {
      }

      public CargoListMeteDTO.CargoListMeteDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CargoListMeteDTO build() {
         return new CargoListMeteDTO(this.weight);
      }

      @Override
      public String toString() {
         return "CargoListMeteDTO.CargoListMeteDTOBuilder(weight=" + this.weight + ")";
      }
   }
}
