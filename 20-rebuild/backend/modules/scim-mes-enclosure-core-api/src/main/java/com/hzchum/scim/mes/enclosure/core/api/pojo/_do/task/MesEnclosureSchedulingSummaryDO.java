package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureSchedulingDO对象", description = "")
public class MesEnclosureSchedulingSummaryDO extends BaseEntity<Long> {
   private Long id;
   private Integer totalSchedulingQuantity;
   private Integer totalTaskQuantity;
   private Integer totalCompleteQuantity;

   public static MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder builder() {
      return new MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder();
   }

   public MesEnclosureSchedulingSummaryDO() {
   }

   public MesEnclosureSchedulingSummaryDO(
      final Long id, final Integer totalSchedulingQuantity, final Integer totalTaskQuantity, final Integer totalCompleteQuantity
   ) {
      this.id = id;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalCompleteQuantity = totalCompleteQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public MesEnclosureSchedulingSummaryDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureSchedulingSummaryDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   public MesEnclosureSchedulingSummaryDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   public MesEnclosureSchedulingSummaryDO setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureSchedulingSummaryDO(id="
         + this.getId()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureSchedulingSummaryDO)) {
         return false;
      }

      MesEnclosureSchedulingSummaryDO other = (MesEnclosureSchedulingSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
         Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
         if (this$totalSchedulingQuantity == null ? other$totalSchedulingQuantity == null : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
            Object this$totalTaskQuantity = this.getTotalTaskQuantity();
            Object other$totalTaskQuantity = other.getTotalTaskQuantity();
            if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
               Object this$totalCompleteQuantity = this.getTotalCompleteQuantity();
               Object other$totalCompleteQuantity = other.getTotalCompleteQuantity();
               return this$totalCompleteQuantity == null ? other$totalCompleteQuantity == null : this$totalCompleteQuantity.equals(other$totalCompleteQuantity);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureSchedulingSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $totalCompleteQuantity = this.getTotalCompleteQuantity();
      return result * 59 + ($totalCompleteQuantity == null ? 43 : $totalCompleteQuantity.hashCode());
   }

   public static class MesEnclosureSchedulingSummaryDOBuilder {
      private Long id;
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private Integer totalCompleteQuantity;

      MesEnclosureSchedulingSummaryDOBuilder() {
      }

      public MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      public MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      public MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder totalCompleteQuantity(final Integer totalCompleteQuantity) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      public MesEnclosureSchedulingSummaryDO build() {
         return new MesEnclosureSchedulingSummaryDO(this.id, this.totalSchedulingQuantity, this.totalTaskQuantity, this.totalCompleteQuantity);
      }

      @Override
      public String toString() {
         return "MesEnclosureSchedulingSummaryDO.MesEnclosureSchedulingSummaryDOBuilder(id="
            + this.id
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ")";
      }
   }
}
