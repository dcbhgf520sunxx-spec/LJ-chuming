package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "WorkshopMonthAndMeteDTO", description = "车间报表")
public class WorkshopMonthAndMeteDTO {
   @ApiModelProperty(name = "date", value = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重(kg)")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重(kg)")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;

   WorkshopMonthAndMeteDTO(final String date, final BigDecimal totalNetWeight, final BigDecimal totalGrossWeight) {
      this.date = date;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public static WorkshopMonthAndMeteDTO.WorkshopMonthAndMeteDTOBuilder builder() {
      return new WorkshopMonthAndMeteDTO.WorkshopMonthAndMeteDTOBuilder();
   }

   public String getDate() {
      return this.date;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   @JsonProperty("date")
   public WorkshopMonthAndMeteDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public WorkshopMonthAndMeteDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public WorkshopMonthAndMeteDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopMonthAndMeteDTO(date="
         + this.getDate()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopMonthAndMeteDTO)) {
         return false;
      }

      WorkshopMonthAndMeteDTO other = (WorkshopMonthAndMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$totalNetWeight = this.getTotalNetWeight();
         Object other$totalNetWeight = other.getTotalNetWeight();
         if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
            Object this$totalGrossWeight = this.getTotalGrossWeight();
            Object other$totalGrossWeight = other.getTotalGrossWeight();
            return this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopMonthAndMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   public static class WorkshopMonthAndMeteDTOBuilder {
      private String date;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      WorkshopMonthAndMeteDTOBuilder() {
      }

      @JsonProperty("date")
      public WorkshopMonthAndMeteDTO.WorkshopMonthAndMeteDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public WorkshopMonthAndMeteDTO.WorkshopMonthAndMeteDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public WorkshopMonthAndMeteDTO.WorkshopMonthAndMeteDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public WorkshopMonthAndMeteDTO build() {
         return new WorkshopMonthAndMeteDTO(this.date, this.totalNetWeight, this.totalGrossWeight);
      }

      @Override
      public String toString() {
         return "WorkshopMonthAndMeteDTO.WorkshopMonthAndMeteDTOBuilder(date="
            + this.date
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
