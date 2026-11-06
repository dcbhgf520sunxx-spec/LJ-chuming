package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运信息汇总")
public class CargoListMeteGroupMonthDTO {
   @ApiModelProperty(name = "date", value = "日期", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "cargoNetWeight", value = "发运量(净重)", notes = "发运量(净重)")
   @JsonProperty("cargoNetWeight")
   @JSONField(name = "cargoNetWeight")
   private BigDecimal cargoNetWeight;
   @ApiModelProperty(name = "cargoGrossWeight", value = "发运量(毛重)", notes = "发运量(毛重)")
   @JsonProperty("cargoGrossWeight")
   @JSONField(name = "cargoGrossWeight")
   private BigDecimal cargoGrossWeight;

   public static CargoListMeteGroupMonthDTO.CargoListMeteGroupMonthDTOBuilder builder() {
      return new CargoListMeteGroupMonthDTO.CargoListMeteGroupMonthDTOBuilder();
   }

   public CargoListMeteGroupMonthDTO(final String date, final BigDecimal cargoNetWeight, final BigDecimal cargoGrossWeight) {
      this.date = date;
      this.cargoNetWeight = cargoNetWeight;
      this.cargoGrossWeight = cargoGrossWeight;
   }

   public CargoListMeteGroupMonthDTO() {
   }

   public String getDate() {
      return this.date;
   }

   public BigDecimal getCargoNetWeight() {
      return this.cargoNetWeight;
   }

   public BigDecimal getCargoGrossWeight() {
      return this.cargoGrossWeight;
   }

   @JsonProperty("date")
   public void setDate(final String date) {
      this.date = date;
   }

   @JsonProperty("cargoNetWeight")
   public void setCargoNetWeight(final BigDecimal cargoNetWeight) {
      this.cargoNetWeight = cargoNetWeight;
   }

   @JsonProperty("cargoGrossWeight")
   public void setCargoGrossWeight(final BigDecimal cargoGrossWeight) {
      this.cargoGrossWeight = cargoGrossWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListMeteGroupMonthDTO)) {
         return false;
      }

      CargoListMeteGroupMonthDTO other = (CargoListMeteGroupMonthDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$cargoNetWeight = this.getCargoNetWeight();
         Object other$cargoNetWeight = other.getCargoNetWeight();
         if (this$cargoNetWeight == null ? other$cargoNetWeight == null : this$cargoNetWeight.equals(other$cargoNetWeight)) {
            Object this$cargoGrossWeight = this.getCargoGrossWeight();
            Object other$cargoGrossWeight = other.getCargoGrossWeight();
            return this$cargoGrossWeight == null ? other$cargoGrossWeight == null : this$cargoGrossWeight.equals(other$cargoGrossWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListMeteGroupMonthDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $cargoNetWeight = this.getCargoNetWeight();
      result = result * 59 + ($cargoNetWeight == null ? 43 : $cargoNetWeight.hashCode());
      Object $cargoGrossWeight = this.getCargoGrossWeight();
      return result * 59 + ($cargoGrossWeight == null ? 43 : $cargoGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListMeteGroupMonthDTO(date="
         + this.getDate()
         + ", cargoNetWeight="
         + this.getCargoNetWeight()
         + ", cargoGrossWeight="
         + this.getCargoGrossWeight()
         + ")";
   }

   public static class CargoListMeteGroupMonthDTOBuilder {
      private String date;
      private BigDecimal cargoNetWeight;
      private BigDecimal cargoGrossWeight;

      CargoListMeteGroupMonthDTOBuilder() {
      }

      @JsonProperty("date")
      public CargoListMeteGroupMonthDTO.CargoListMeteGroupMonthDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("cargoNetWeight")
      public CargoListMeteGroupMonthDTO.CargoListMeteGroupMonthDTOBuilder cargoNetWeight(final BigDecimal cargoNetWeight) {
         this.cargoNetWeight = cargoNetWeight;
         return this;
      }

      @JsonProperty("cargoGrossWeight")
      public CargoListMeteGroupMonthDTO.CargoListMeteGroupMonthDTOBuilder cargoGrossWeight(final BigDecimal cargoGrossWeight) {
         this.cargoGrossWeight = cargoGrossWeight;
         return this;
      }

      public CargoListMeteGroupMonthDTO build() {
         return new CargoListMeteGroupMonthDTO(this.date, this.cargoNetWeight, this.cargoGrossWeight);
      }

      @Override
      public String toString() {
         return "CargoListMeteGroupMonthDTO.CargoListMeteGroupMonthDTOBuilder(date="
            + this.date
            + ", cargoNetWeight="
            + this.cargoNetWeight
            + ", cargoGrossWeight="
            + this.cargoGrossWeight
            + ")";
      }
   }
}
