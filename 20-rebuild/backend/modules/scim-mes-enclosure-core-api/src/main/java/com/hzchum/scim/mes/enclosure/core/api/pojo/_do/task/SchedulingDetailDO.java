package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "SchedulingDetailDO", description = "")
public class SchedulingDetailDO {
   private Integer totalSchedulingQuantity;
   private Integer totalTaskQuantity;
   private Integer inProductionQuantity;
   private Integer completeQuantity;

   public static SchedulingDetailDO.SchedulingDetailDOBuilder builder() {
      return new SchedulingDetailDO.SchedulingDetailDOBuilder();
   }

   public SchedulingDetailDO() {
   }

   public SchedulingDetailDO(
      final Integer totalSchedulingQuantity, final Integer totalTaskQuantity, final Integer inProductionQuantity, final Integer completeQuantity
   ) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.completeQuantity = completeQuantity;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public SchedulingDetailDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   public SchedulingDetailDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   public SchedulingDetailDO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   public SchedulingDetailDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingDetailDO(totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingDetailDO)) {
         return false;
      }

      SchedulingDetailDO other = (SchedulingDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
      if (this$totalSchedulingQuantity == null ? other$totalSchedulingQuantity == null : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
         Object this$totalTaskQuantity = this.getTotalTaskQuantity();
         Object other$totalTaskQuantity = other.getTotalTaskQuantity();
         if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
            Object this$inProductionQuantity = this.getInProductionQuantity();
            Object other$inProductionQuantity = other.getInProductionQuantity();
            if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               return this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity);
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
      return other instanceof SchedulingDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      return result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
   }

   public static class SchedulingDetailDOBuilder {
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private Integer inProductionQuantity;
      private Integer completeQuantity;

      SchedulingDetailDOBuilder() {
      }

      public SchedulingDetailDO.SchedulingDetailDOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      public SchedulingDetailDO.SchedulingDetailDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      public SchedulingDetailDO.SchedulingDetailDOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      public SchedulingDetailDO.SchedulingDetailDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public SchedulingDetailDO build() {
         return new SchedulingDetailDO(this.totalSchedulingQuantity, this.totalTaskQuantity, this.inProductionQuantity, this.completeQuantity);
      }

      @Override
      public String toString() {
         return "SchedulingDetailDO.SchedulingDetailDOBuilder(totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ")";
      }
   }
}
