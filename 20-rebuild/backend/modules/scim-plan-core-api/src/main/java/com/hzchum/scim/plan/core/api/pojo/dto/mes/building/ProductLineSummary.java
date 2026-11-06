package com.hzchum.scim.plan.core.api.pojo.dto.mes.building;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ProductLineSummary对象", description = "产线汇总数据详细信息 ")
public class ProductLineSummary {
   @ApiModelProperty(name = "factoryId", value = "分配量", notes = "分配量")
   private Long allocationWeight;
   @ApiModelProperty(name = "factoryId", value = "完成量", notes = "完成量")
   private Long completionWeight;
   @ApiModelProperty(name = "factoryId", value = "未完成量", notes = "未完成量")
   private Long unCompletionWeight;
   @ApiModelProperty(name = "date", value = "完成时间", notes = "完成时间")
   private LocalDateTime date;

   public static ProductLineSummary.ProductLineSummaryBuilder builder() {
      return new ProductLineSummary.ProductLineSummaryBuilder();
   }

   public ProductLineSummary() {
   }

   public ProductLineSummary(final Long allocationWeight, final Long completionWeight, final Long unCompletionWeight, final LocalDateTime date) {
      this.allocationWeight = allocationWeight;
      this.completionWeight = completionWeight;
      this.unCompletionWeight = unCompletionWeight;
      this.date = date;
   }

   public Long getAllocationWeight() {
      return this.allocationWeight;
   }

   public Long getCompletionWeight() {
      return this.completionWeight;
   }

   public Long getUnCompletionWeight() {
      return this.unCompletionWeight;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public ProductLineSummary setAllocationWeight(final Long allocationWeight) {
      this.allocationWeight = allocationWeight;
      return this;
   }

   public ProductLineSummary setCompletionWeight(final Long completionWeight) {
      this.completionWeight = completionWeight;
      return this;
   }

   public ProductLineSummary setUnCompletionWeight(final Long unCompletionWeight) {
      this.unCompletionWeight = unCompletionWeight;
      return this;
   }

   public ProductLineSummary setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @Override
   public String toString() {
      return "ProductLineSummary(allocationWeight="
         + this.getAllocationWeight()
         + ", completionWeight="
         + this.getCompletionWeight()
         + ", unCompletionWeight="
         + this.getUnCompletionWeight()
         + ", date="
         + this.getDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductLineSummary)) {
         return false;
      }

      ProductLineSummary other = (ProductLineSummary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$allocationWeight = this.getAllocationWeight();
      Object other$allocationWeight = other.getAllocationWeight();
      if (this$allocationWeight == null ? other$allocationWeight == null : this$allocationWeight.equals(other$allocationWeight)) {
         Object this$completionWeight = this.getCompletionWeight();
         Object other$completionWeight = other.getCompletionWeight();
         if (this$completionWeight == null ? other$completionWeight == null : this$completionWeight.equals(other$completionWeight)) {
            Object this$unCompletionWeight = this.getUnCompletionWeight();
            Object other$unCompletionWeight = other.getUnCompletionWeight();
            if (this$unCompletionWeight == null ? other$unCompletionWeight == null : this$unCompletionWeight.equals(other$unCompletionWeight)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               return this$date == null ? other$date == null : this$date.equals(other$date);
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
      return other instanceof ProductLineSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $allocationWeight = this.getAllocationWeight();
      result = result * 59 + ($allocationWeight == null ? 43 : $allocationWeight.hashCode());
      Object $completionWeight = this.getCompletionWeight();
      result = result * 59 + ($completionWeight == null ? 43 : $completionWeight.hashCode());
      Object $unCompletionWeight = this.getUnCompletionWeight();
      result = result * 59 + ($unCompletionWeight == null ? 43 : $unCompletionWeight.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public static class ProductLineSummaryBuilder {
      private Long allocationWeight;
      private Long completionWeight;
      private Long unCompletionWeight;
      private LocalDateTime date;

      ProductLineSummaryBuilder() {
      }

      public ProductLineSummary.ProductLineSummaryBuilder allocationWeight(final Long allocationWeight) {
         this.allocationWeight = allocationWeight;
         return this;
      }

      public ProductLineSummary.ProductLineSummaryBuilder completionWeight(final Long completionWeight) {
         this.completionWeight = completionWeight;
         return this;
      }

      public ProductLineSummary.ProductLineSummaryBuilder unCompletionWeight(final Long unCompletionWeight) {
         this.unCompletionWeight = unCompletionWeight;
         return this;
      }

      public ProductLineSummary.ProductLineSummaryBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public ProductLineSummary build() {
         return new ProductLineSummary(this.allocationWeight, this.completionWeight, this.unCompletionWeight, this.date);
      }

      @Override
      public String toString() {
         return "ProductLineSummary.ProductLineSummaryBuilder(allocationWeight="
            + this.allocationWeight
            + ", completionWeight="
            + this.completionWeight
            + ", unCompletionWeight="
            + this.unCompletionWeight
            + ", date="
            + this.date
            + ")";
      }
   }
}
