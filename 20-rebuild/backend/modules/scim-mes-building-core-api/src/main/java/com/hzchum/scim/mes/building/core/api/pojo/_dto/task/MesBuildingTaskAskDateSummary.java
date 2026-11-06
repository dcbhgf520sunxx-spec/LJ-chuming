package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingTaskAskDateSummary", description = "任务要求完成时间列表详情 ")
public class MesBuildingTaskAskDateSummary {
   @ApiModelProperty(name = "totalTaskQuantity", notes = "任务总数")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "mete", notes = "汇总量（构件等kg,围护mm）")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   MesBuildingTaskAskDateSummary(final Integer totalTaskQuantity, final BigDecimal mete) {
      this.totalTaskQuantity = totalTaskQuantity;
      this.mete = mete;
   }

   public static MesBuildingTaskAskDateSummary.MesBuildingTaskAskDateSummaryBuilder builder() {
      return new MesBuildingTaskAskDateSummary.MesBuildingTaskAskDateSummaryBuilder();
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("totalTaskQuantity")
   public MesBuildingTaskAskDateSummary setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("mete")
   public MesBuildingTaskAskDateSummary setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskAskDateSummary(totalTaskQuantity=" + this.getTotalTaskQuantity() + ", mete=" + this.getMete() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingTaskAskDateSummary)) {
         return false;
      } else {
         MesBuildingTaskAskDateSummary other = (MesBuildingTaskAskDateSummary)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalTaskQuantity = this.getTotalTaskQuantity();
            Object other$totalTaskQuantity = other.getTotalTaskQuantity();
            if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
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
      return other instanceof MesBuildingTaskAskDateSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class MesBuildingTaskAskDateSummaryBuilder {
      private Integer totalTaskQuantity;
      private BigDecimal mete;

      MesBuildingTaskAskDateSummaryBuilder() {
      }

      @JsonProperty("totalTaskQuantity")
      public MesBuildingTaskAskDateSummary.MesBuildingTaskAskDateSummaryBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("mete")
      public MesBuildingTaskAskDateSummary.MesBuildingTaskAskDateSummaryBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MesBuildingTaskAskDateSummary build() {
         return new MesBuildingTaskAskDateSummary(this.totalTaskQuantity, this.mete);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskAskDateSummary.MesBuildingTaskAskDateSummaryBuilder(totalTaskQuantity=" + this.totalTaskQuantity + ", mete=" + this.mete + ")";
      }
   }
}
