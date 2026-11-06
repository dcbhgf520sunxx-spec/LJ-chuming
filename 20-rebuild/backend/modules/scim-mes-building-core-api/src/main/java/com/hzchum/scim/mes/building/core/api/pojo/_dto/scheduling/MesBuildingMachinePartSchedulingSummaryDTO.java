package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartSchedulingSummaryDTO", description = "零件排产信息和汇总信息")
public class MesBuildingMachinePartSchedulingSummaryDTO {
   @ApiModelProperty(name = "collect", value = "主键ID")
   @JsonProperty("collect")
   @JSONField(name = "collect")
   private List<MesBuildingMachinePartSchedulingDTO> collect;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "maxDate", value = "最大时间")
   @JsonProperty("maxDate")
   @JSONField(name = "maxDate")
   private LocalDateTime maxDate;
   @ApiModelProperty(name = "minDate", value = "最小时间")
   @JsonProperty("minDate")
   @JSONField(name = "minDate")
   private LocalDateTime minDate;

   public static MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder builder() {
      return new MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder();
   }

   public MesBuildingMachinePartSchedulingSummaryDTO(
      final List<MesBuildingMachinePartSchedulingDTO> collect,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final LocalDateTime maxDate,
      final LocalDateTime minDate
   ) {
      this.collect = collect;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.maxDate = maxDate;
      this.minDate = minDate;
   }

   public MesBuildingMachinePartSchedulingSummaryDTO() {
   }

   public List<MesBuildingMachinePartSchedulingDTO> getCollect() {
      return this.collect;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public LocalDateTime getMaxDate() {
      return this.maxDate;
   }

   public LocalDateTime getMinDate() {
      return this.minDate;
   }

   @JsonProperty("collect")
   public MesBuildingMachinePartSchedulingSummaryDTO setCollect(final List<MesBuildingMachinePartSchedulingDTO> collect) {
      this.collect = collect;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachinePartSchedulingSummaryDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("maxDate")
   public MesBuildingMachinePartSchedulingSummaryDTO setMaxDate(final LocalDateTime maxDate) {
      this.maxDate = maxDate;
      return this;
   }

   @JsonProperty("minDate")
   public MesBuildingMachinePartSchedulingSummaryDTO setMinDate(final LocalDateTime minDate) {
      this.minDate = minDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingSummaryDTO(collect="
         + this.getCollect()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", maxDate="
         + this.getMaxDate()
         + ", minDate="
         + this.getMinDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingSummaryDTO)) {
         return false;
      }

      MesBuildingMachinePartSchedulingSummaryDTO other = (MesBuildingMachinePartSchedulingSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$collect = this.getCollect();
         Object other$collect = other.getCollect();
         if (this$collect == null ? other$collect == null : this$collect.equals(other$collect)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$maxDate = this.getMaxDate();
               Object other$maxDate = other.getMaxDate();
               if (this$maxDate == null ? other$maxDate == null : this$maxDate.equals(other$maxDate)) {
                  Object this$minDate = this.getMinDate();
                  Object other$minDate = other.getMinDate();
                  return this$minDate == null ? other$minDate == null : this$minDate.equals(other$minDate);
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
      return other instanceof MesBuildingMachinePartSchedulingSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $collect = this.getCollect();
      result = result * 59 + ($collect == null ? 43 : $collect.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $maxDate = this.getMaxDate();
      result = result * 59 + ($maxDate == null ? 43 : $maxDate.hashCode());
      Object $minDate = this.getMinDate();
      return result * 59 + ($minDate == null ? 43 : $minDate.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingSummaryDTOBuilder {
      private List<MesBuildingMachinePartSchedulingDTO> collect;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private LocalDateTime maxDate;
      private LocalDateTime minDate;

      MesBuildingMachinePartSchedulingSummaryDTOBuilder() {
      }

      @JsonProperty("collect")
      public MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder collect(
         final List<MesBuildingMachinePartSchedulingDTO> collect
      ) {
         this.collect = collect;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("maxDate")
      public MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder maxDate(final LocalDateTime maxDate) {
         this.maxDate = maxDate;
         return this;
      }

      @JsonProperty("minDate")
      public MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder minDate(final LocalDateTime minDate) {
         this.minDate = minDate;
         return this;
      }

      public MesBuildingMachinePartSchedulingSummaryDTO build() {
         return new MesBuildingMachinePartSchedulingSummaryDTO(this.collect, this.quantity, this.totalNetWeight, this.maxDate, this.minDate);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingSummaryDTO.MesBuildingMachinePartSchedulingSummaryDTOBuilder(collect="
            + this.collect
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", maxDate="
            + this.maxDate
            + ", minDate="
            + this.minDate
            + ")";
      }
   }
}
