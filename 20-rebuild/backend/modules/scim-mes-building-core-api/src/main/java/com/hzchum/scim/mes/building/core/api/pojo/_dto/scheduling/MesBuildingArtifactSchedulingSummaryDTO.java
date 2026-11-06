package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingArtifactSchedulingSummaryDTO", description = "构件汇总信息")
public class MesBuildingArtifactSchedulingSummaryDTO {
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "completionTime", value = "完成时间")
   @JsonProperty("completionTime")
   @JSONField(name = "completionTime")
   private LocalDate completionTime;
   @ApiModelProperty(name = "maxAskCompleteTime", value = "最大要求完成日期）")
   @JsonProperty("maxAskCompleteTime")
   @JSONField(name = "maxAskCompleteTime")
   private LocalDateTime maxAskCompleteTime;
   @ApiModelProperty(name = "minAskCompleteTime", value = "最小要求完成日期）")
   @JsonProperty("minAskCompleteTime")
   @JSONField(name = "minAskCompleteTime")
   private LocalDateTime minAskCompleteTime;

   public static MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder builder() {
      return new MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder();
   }

   public MesBuildingArtifactSchedulingSummaryDTO(
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final LocalDate completionTime,
      final LocalDateTime maxAskCompleteTime,
      final LocalDateTime minAskCompleteTime
   ) {
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.completionTime = completionTime;
      this.maxAskCompleteTime = maxAskCompleteTime;
      this.minAskCompleteTime = minAskCompleteTime;
   }

   public MesBuildingArtifactSchedulingSummaryDTO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public LocalDate getCompletionTime() {
      return this.completionTime;
   }

   public LocalDateTime getMaxAskCompleteTime() {
      return this.maxAskCompleteTime;
   }

   public LocalDateTime getMinAskCompleteTime() {
      return this.minAskCompleteTime;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingArtifactSchedulingSummaryDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("completionTime")
   public MesBuildingArtifactSchedulingSummaryDTO setCompletionTime(final LocalDate completionTime) {
      this.completionTime = completionTime;
      return this;
   }

   @JsonProperty("maxAskCompleteTime")
   public MesBuildingArtifactSchedulingSummaryDTO setMaxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
      this.maxAskCompleteTime = maxAskCompleteTime;
      return this;
   }

   @JsonProperty("minAskCompleteTime")
   public MesBuildingArtifactSchedulingSummaryDTO setMinAskCompleteTime(final LocalDateTime minAskCompleteTime) {
      this.minAskCompleteTime = minAskCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingSummaryDTO(quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", completionTime="
         + this.getCompletionTime()
         + ", maxAskCompleteTime="
         + this.getMaxAskCompleteTime()
         + ", minAskCompleteTime="
         + this.getMinAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingSummaryDTO)) {
         return false;
      }

      MesBuildingArtifactSchedulingSummaryDTO other = (MesBuildingArtifactSchedulingSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$totalNetWeight = this.getTotalNetWeight();
         Object other$totalNetWeight = other.getTotalNetWeight();
         if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
            Object this$completionTime = this.getCompletionTime();
            Object other$completionTime = other.getCompletionTime();
            if (this$completionTime == null ? other$completionTime == null : this$completionTime.equals(other$completionTime)) {
               Object this$maxAskCompleteTime = this.getMaxAskCompleteTime();
               Object other$maxAskCompleteTime = other.getMaxAskCompleteTime();
               if (this$maxAskCompleteTime == null ? other$maxAskCompleteTime == null : this$maxAskCompleteTime.equals(other$maxAskCompleteTime)) {
                  Object this$minAskCompleteTime = this.getMinAskCompleteTime();
                  Object other$minAskCompleteTime = other.getMinAskCompleteTime();
                  return this$minAskCompleteTime == null ? other$minAskCompleteTime == null : this$minAskCompleteTime.equals(other$minAskCompleteTime);
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
      return other instanceof MesBuildingArtifactSchedulingSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $completionTime = this.getCompletionTime();
      result = result * 59 + ($completionTime == null ? 43 : $completionTime.hashCode());
      Object $maxAskCompleteTime = this.getMaxAskCompleteTime();
      result = result * 59 + ($maxAskCompleteTime == null ? 43 : $maxAskCompleteTime.hashCode());
      Object $minAskCompleteTime = this.getMinAskCompleteTime();
      return result * 59 + ($minAskCompleteTime == null ? 43 : $minAskCompleteTime.hashCode());
   }

   public static class MesBuildingArtifactSchedulingSummaryDTOBuilder {
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private LocalDate completionTime;
      private LocalDateTime maxAskCompleteTime;
      private LocalDateTime minAskCompleteTime;

      MesBuildingArtifactSchedulingSummaryDTOBuilder() {
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("completionTime")
      public MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder completionTime(final LocalDate completionTime) {
         this.completionTime = completionTime;
         return this;
      }

      @JsonProperty("maxAskCompleteTime")
      public MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder maxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
         this.maxAskCompleteTime = maxAskCompleteTime;
         return this;
      }

      @JsonProperty("minAskCompleteTime")
      public MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder minAskCompleteTime(final LocalDateTime minAskCompleteTime) {
         this.minAskCompleteTime = minAskCompleteTime;
         return this;
      }

      public MesBuildingArtifactSchedulingSummaryDTO build() {
         return new MesBuildingArtifactSchedulingSummaryDTO(
            this.quantity, this.totalNetWeight, this.completionTime, this.maxAskCompleteTime, this.minAskCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingSummaryDTO.MesBuildingArtifactSchedulingSummaryDTOBuilder(quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", completionTime="
            + this.completionTime
            + ", maxAskCompleteTime="
            + this.maxAskCompleteTime
            + ", minAskCompleteTime="
            + this.minAskCompleteTime
            + ")";
      }
   }
}
