package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "SchedulingDetailDTO", description = "")
public class SchedulingDetailDTO {
   private Integer totalSchedulingQuantity;
   private Integer totalTaskQuantity;
   private Integer inProductionQuantity;
   private Integer completeQuantity;

   public static SchedulingDetailDTO.SchedulingDetailDTOBuilder builder() {
      return new SchedulingDetailDTO.SchedulingDetailDTOBuilder();
   }

   public SchedulingDetailDTO() {
   }

   public SchedulingDetailDTO(
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

   public SchedulingDetailDTO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   public SchedulingDetailDTO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   public SchedulingDetailDTO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   public SchedulingDetailDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingDetailDTO(totalSchedulingQuantity="
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

      if (!(o instanceof SchedulingDetailDTO)) {
         return false;
      }

      SchedulingDetailDTO other = (SchedulingDetailDTO)o;
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
      return other instanceof SchedulingDetailDTO;
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

   public static class SchedulingDetailDTOBuilder {
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private Integer inProductionQuantity;
      private Integer completeQuantity;

      SchedulingDetailDTOBuilder() {
      }

      public SchedulingDetailDTO.SchedulingDetailDTOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      public SchedulingDetailDTO.SchedulingDetailDTOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      public SchedulingDetailDTO.SchedulingDetailDTOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      public SchedulingDetailDTO.SchedulingDetailDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public SchedulingDetailDTO build() {
         return new SchedulingDetailDTO(this.totalSchedulingQuantity, this.totalTaskQuantity, this.inProductionQuantity, this.completeQuantity);
      }

      @Override
      public String toString() {
         return "SchedulingDetailDTO.SchedulingDetailDTOBuilder(totalSchedulingQuantity="
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
