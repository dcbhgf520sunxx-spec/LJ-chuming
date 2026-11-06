package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import io.swagger.annotations.ApiModelProperty;

public class InspectRealtimeInfoSummary {
   @ApiModelProperty(name = "toBeInspectedCount", notes = "待质检数量", value = "待质检数量")
   private Integer toBeInspectedCount;
   @ApiModelProperty(name = "toBeRectifiedCount", notes = "待整改数量", value = "待整改数量")
   private Integer toBeRectifiedCount;
   @ApiModelProperty(name = "passedCount", notes = "通过数量", value = "通过数量")
   private Integer passedCount;
   @ApiModelProperty(name = "concessionReceivingCount", notes = "让步接收数量", value = "让步接收数量")
   private Integer concessionReceivingCount;

   InspectRealtimeInfoSummary(
      final Integer toBeInspectedCount, final Integer toBeRectifiedCount, final Integer passedCount, final Integer concessionReceivingCount
   ) {
      this.toBeInspectedCount = toBeInspectedCount;
      this.toBeRectifiedCount = toBeRectifiedCount;
      this.passedCount = passedCount;
      this.concessionReceivingCount = concessionReceivingCount;
   }

   public static InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder builder() {
      return new InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder();
   }

   public Integer getToBeInspectedCount() {
      return this.toBeInspectedCount;
   }

   public Integer getToBeRectifiedCount() {
      return this.toBeRectifiedCount;
   }

   public Integer getPassedCount() {
      return this.passedCount;
   }

   public Integer getConcessionReceivingCount() {
      return this.concessionReceivingCount;
   }

   public InspectRealtimeInfoSummary setToBeInspectedCount(final Integer toBeInspectedCount) {
      this.toBeInspectedCount = toBeInspectedCount;
      return this;
   }

   public InspectRealtimeInfoSummary setToBeRectifiedCount(final Integer toBeRectifiedCount) {
      this.toBeRectifiedCount = toBeRectifiedCount;
      return this;
   }

   public InspectRealtimeInfoSummary setPassedCount(final Integer passedCount) {
      this.passedCount = passedCount;
      return this;
   }

   public InspectRealtimeInfoSummary setConcessionReceivingCount(final Integer concessionReceivingCount) {
      this.concessionReceivingCount = concessionReceivingCount;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectRealtimeInfoSummary)) {
         return false;
      }

      InspectRealtimeInfoSummary other = (InspectRealtimeInfoSummary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$toBeInspectedCount = this.getToBeInspectedCount();
      Object other$toBeInspectedCount = other.getToBeInspectedCount();
      if (this$toBeInspectedCount == null ? other$toBeInspectedCount == null : this$toBeInspectedCount.equals(other$toBeInspectedCount)) {
         Object this$toBeRectifiedCount = this.getToBeRectifiedCount();
         Object other$toBeRectifiedCount = other.getToBeRectifiedCount();
         if (this$toBeRectifiedCount == null ? other$toBeRectifiedCount == null : this$toBeRectifiedCount.equals(other$toBeRectifiedCount)) {
            Object this$passedCount = this.getPassedCount();
            Object other$passedCount = other.getPassedCount();
            if (this$passedCount == null ? other$passedCount == null : this$passedCount.equals(other$passedCount)) {
               Object this$concessionReceivingCount = this.getConcessionReceivingCount();
               Object other$concessionReceivingCount = other.getConcessionReceivingCount();
               return this$concessionReceivingCount == null
                  ? other$concessionReceivingCount == null
                  : this$concessionReceivingCount.equals(other$concessionReceivingCount);
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
      return other instanceof InspectRealtimeInfoSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $toBeInspectedCount = this.getToBeInspectedCount();
      result = result * 59 + ($toBeInspectedCount == null ? 43 : $toBeInspectedCount.hashCode());
      Object $toBeRectifiedCount = this.getToBeRectifiedCount();
      result = result * 59 + ($toBeRectifiedCount == null ? 43 : $toBeRectifiedCount.hashCode());
      Object $passedCount = this.getPassedCount();
      result = result * 59 + ($passedCount == null ? 43 : $passedCount.hashCode());
      Object $concessionReceivingCount = this.getConcessionReceivingCount();
      return result * 59 + ($concessionReceivingCount == null ? 43 : $concessionReceivingCount.hashCode());
   }

   @Override
   public String toString() {
      return "InspectRealtimeInfoSummary(toBeInspectedCount="
         + this.getToBeInspectedCount()
         + ", toBeRectifiedCount="
         + this.getToBeRectifiedCount()
         + ", passedCount="
         + this.getPassedCount()
         + ", concessionReceivingCount="
         + this.getConcessionReceivingCount()
         + ")";
   }

   public static class InspectRealtimeInfoSummaryBuilder {
      private Integer toBeInspectedCount;
      private Integer toBeRectifiedCount;
      private Integer passedCount;
      private Integer concessionReceivingCount;

      InspectRealtimeInfoSummaryBuilder() {
      }

      public InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder toBeInspectedCount(final Integer toBeInspectedCount) {
         this.toBeInspectedCount = toBeInspectedCount;
         return this;
      }

      public InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder toBeRectifiedCount(final Integer toBeRectifiedCount) {
         this.toBeRectifiedCount = toBeRectifiedCount;
         return this;
      }

      public InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder passedCount(final Integer passedCount) {
         this.passedCount = passedCount;
         return this;
      }

      public InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder concessionReceivingCount(final Integer concessionReceivingCount) {
         this.concessionReceivingCount = concessionReceivingCount;
         return this;
      }

      public InspectRealtimeInfoSummary build() {
         return new InspectRealtimeInfoSummary(this.toBeInspectedCount, this.toBeRectifiedCount, this.passedCount, this.concessionReceivingCount);
      }

      @Override
      public String toString() {
         return "InspectRealtimeInfoSummary.InspectRealtimeInfoSummaryBuilder(toBeInspectedCount="
            + this.toBeInspectedCount
            + ", toBeRectifiedCount="
            + this.toBeRectifiedCount
            + ", passedCount="
            + this.passedCount
            + ", concessionReceivingCount="
            + this.concessionReceivingCount
            + ")";
      }
   }
}
