package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingArtifactSchedulingSummaryDO", description = "构件汇总信息")
public class MesBuildingArtifactSchedulingSummaryDO {
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "maxAskCompleteTime", value = "最大要求完成日期）")
   @JsonProperty("maxAskCompleteTime")
   @JSONField(name = "maxAskCompleteTime")
   private LocalDateTime maxAskCompleteTime;
   @ApiModelProperty(name = "minAskCompleteTime", value = "最小要求完成日期）")
   @JsonProperty("minAskCompleteTime")
   @JSONField(name = "minAskCompleteTime")
   private LocalDateTime minAskCompleteTime;

   public static MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder builder() {
      return new MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder();
   }

   public MesBuildingArtifactSchedulingSummaryDO(
      final Integer quantity, final BigDecimal totalNetWeight, final LocalDateTime maxAskCompleteTime, final LocalDateTime minAskCompleteTime
   ) {
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.maxAskCompleteTime = maxAskCompleteTime;
      this.minAskCompleteTime = minAskCompleteTime;
   }

   public MesBuildingArtifactSchedulingSummaryDO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public LocalDateTime getMaxAskCompleteTime() {
      return this.maxAskCompleteTime;
   }

   public LocalDateTime getMinAskCompleteTime() {
      return this.minAskCompleteTime;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingArtifactSchedulingSummaryDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("maxAskCompleteTime")
   public MesBuildingArtifactSchedulingSummaryDO setMaxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
      this.maxAskCompleteTime = maxAskCompleteTime;
      return this;
   }

   @JsonProperty("minAskCompleteTime")
   public MesBuildingArtifactSchedulingSummaryDO setMinAskCompleteTime(final LocalDateTime minAskCompleteTime) {
      this.minAskCompleteTime = minAskCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingSummaryDO(quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
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

      if (!(o instanceof MesBuildingArtifactSchedulingSummaryDO)) {
         return false;
      }

      MesBuildingArtifactSchedulingSummaryDO other = (MesBuildingArtifactSchedulingSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$totalNetWeight = this.getTotalNetWeight();
         Object other$totalNetWeight = other.getTotalNetWeight();
         if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $maxAskCompleteTime = this.getMaxAskCompleteTime();
      result = result * 59 + ($maxAskCompleteTime == null ? 43 : $maxAskCompleteTime.hashCode());
      Object $minAskCompleteTime = this.getMinAskCompleteTime();
      return result * 59 + ($minAskCompleteTime == null ? 43 : $minAskCompleteTime.hashCode());
   }

   public static class MesBuildingArtifactSchedulingSummaryDOBuilder {
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private LocalDateTime maxAskCompleteTime;
      private LocalDateTime minAskCompleteTime;

      MesBuildingArtifactSchedulingSummaryDOBuilder() {
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("maxAskCompleteTime")
      public MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder maxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
         this.maxAskCompleteTime = maxAskCompleteTime;
         return this;
      }

      @JsonProperty("minAskCompleteTime")
      public MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder minAskCompleteTime(final LocalDateTime minAskCompleteTime) {
         this.minAskCompleteTime = minAskCompleteTime;
         return this;
      }

      public MesBuildingArtifactSchedulingSummaryDO build() {
         return new MesBuildingArtifactSchedulingSummaryDO(this.quantity, this.totalNetWeight, this.maxAskCompleteTime, this.minAskCompleteTime);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingSummaryDO.MesBuildingArtifactSchedulingSummaryDOBuilder(quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", maxAskCompleteTime="
            + this.maxAskCompleteTime
            + ", minAskCompleteTime="
            + this.minAskCompleteTime
            + ")";
      }
   }
}
