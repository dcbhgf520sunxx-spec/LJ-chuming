package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "YearQuantityAndMeteDTO", description = "排产量统计按月分组 ")
public class YearQuantityAndMeteDTO {
   @ApiModelProperty(name = "date", value = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "totalNetWeight", value = "净重排产量（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "毛重排产量（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "completeGrossWeight", value = "完成产总毛重（kg）")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", value = "完成总净重（kg）")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;

   public static YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder builder() {
      return new YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder();
   }

   public YearQuantityAndMeteDTO() {
   }

   public YearQuantityAndMeteDTO(
      final String date,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal completeGrossWeight,
      final BigDecimal completeNetWeight
   ) {
      this.date = date;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.completeNetWeight = completeNetWeight;
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

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   @JsonProperty("date")
   public YearQuantityAndMeteDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public YearQuantityAndMeteDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public YearQuantityAndMeteDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public YearQuantityAndMeteDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public YearQuantityAndMeteDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "YearQuantityAndMeteDTO(date="
         + this.getDate()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearQuantityAndMeteDTO)) {
         return false;
      }

      YearQuantityAndMeteDTO other = (YearQuantityAndMeteDTO)o;
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
            if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
               Object this$completeGrossWeight = this.getCompleteGrossWeight();
               Object other$completeGrossWeight = other.getCompleteGrossWeight();
               if (this$completeGrossWeight == null ? other$completeGrossWeight == null : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                  Object this$completeNetWeight = this.getCompleteNetWeight();
                  Object other$completeNetWeight = other.getCompleteNetWeight();
                  return this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight);
               } else {
                  return false;
               }
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
      return other instanceof YearQuantityAndMeteDTO;
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
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      return result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
   }

   public static class YearQuantityAndMeteDTOBuilder {
      private String date;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal completeGrossWeight;
      private BigDecimal completeNetWeight;

      YearQuantityAndMeteDTOBuilder() {
      }

      @JsonProperty("date")
      public YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      public YearQuantityAndMeteDTO build() {
         return new YearQuantityAndMeteDTO(this.date, this.totalNetWeight, this.totalGrossWeight, this.completeGrossWeight, this.completeNetWeight);
      }

      @Override
      public String toString() {
         return "YearQuantityAndMeteDTO.YearQuantityAndMeteDTOBuilder(date="
            + this.date
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", completeNetWeight="
            + this.completeNetWeight
            + ")";
      }
   }
}
