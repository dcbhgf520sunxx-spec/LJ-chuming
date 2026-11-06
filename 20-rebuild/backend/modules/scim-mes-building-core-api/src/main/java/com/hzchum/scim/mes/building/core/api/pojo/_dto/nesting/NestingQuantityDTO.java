package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "套料数量DTO", description = "套料数量DTO")
public class NestingQuantityDTO {
   private Integer partQuantity;
   private Integer nestingQuantity;
   private Integer cutQuantity;

   public static NestingQuantityDTO.NestingQuantityDTOBuilder builder() {
      return new NestingQuantityDTO.NestingQuantityDTOBuilder();
   }

   public NestingQuantityDTO(final Integer partQuantity, final Integer nestingQuantity, final Integer cutQuantity) {
      this.partQuantity = partQuantity;
      this.nestingQuantity = nestingQuantity;
      this.cutQuantity = cutQuantity;
   }

   public NestingQuantityDTO() {
   }

   public Integer getPartQuantity() {
      return this.partQuantity;
   }

   public Integer getNestingQuantity() {
      return this.nestingQuantity;
   }

   public Integer getCutQuantity() {
      return this.cutQuantity;
   }

   public NestingQuantityDTO setPartQuantity(final Integer partQuantity) {
      this.partQuantity = partQuantity;
      return this;
   }

   public NestingQuantityDTO setNestingQuantity(final Integer nestingQuantity) {
      this.nestingQuantity = nestingQuantity;
      return this;
   }

   public NestingQuantityDTO setCutQuantity(final Integer cutQuantity) {
      this.cutQuantity = cutQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "NestingQuantityDTO(partQuantity="
         + this.getPartQuantity()
         + ", nestingQuantity="
         + this.getNestingQuantity()
         + ", cutQuantity="
         + this.getCutQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestingQuantityDTO)) {
         return false;
      }

      NestingQuantityDTO other = (NestingQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$partQuantity = this.getPartQuantity();
      Object other$partQuantity = other.getPartQuantity();
      if (this$partQuantity == null ? other$partQuantity == null : this$partQuantity.equals(other$partQuantity)) {
         Object this$nestingQuantity = this.getNestingQuantity();
         Object other$nestingQuantity = other.getNestingQuantity();
         if (this$nestingQuantity == null ? other$nestingQuantity == null : this$nestingQuantity.equals(other$nestingQuantity)) {
            Object this$cutQuantity = this.getCutQuantity();
            Object other$cutQuantity = other.getCutQuantity();
            return this$cutQuantity == null ? other$cutQuantity == null : this$cutQuantity.equals(other$cutQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NestingQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $partQuantity = this.getPartQuantity();
      result = result * 59 + ($partQuantity == null ? 43 : $partQuantity.hashCode());
      Object $nestingQuantity = this.getNestingQuantity();
      result = result * 59 + ($nestingQuantity == null ? 43 : $nestingQuantity.hashCode());
      Object $cutQuantity = this.getCutQuantity();
      return result * 59 + ($cutQuantity == null ? 43 : $cutQuantity.hashCode());
   }

   public static class NestingQuantityDTOBuilder {
      private Integer partQuantity;
      private Integer nestingQuantity;
      private Integer cutQuantity;

      NestingQuantityDTOBuilder() {
      }

      public NestingQuantityDTO.NestingQuantityDTOBuilder partQuantity(final Integer partQuantity) {
         this.partQuantity = partQuantity;
         return this;
      }

      public NestingQuantityDTO.NestingQuantityDTOBuilder nestingQuantity(final Integer nestingQuantity) {
         this.nestingQuantity = nestingQuantity;
         return this;
      }

      public NestingQuantityDTO.NestingQuantityDTOBuilder cutQuantity(final Integer cutQuantity) {
         this.cutQuantity = cutQuantity;
         return this;
      }

      public NestingQuantityDTO build() {
         return new NestingQuantityDTO(this.partQuantity, this.nestingQuantity, this.cutQuantity);
      }

      @Override
      public String toString() {
         return "NestingQuantityDTO.NestingQuantityDTOBuilder(partQuantity="
            + this.partQuantity
            + ", nestingQuantity="
            + this.nestingQuantity
            + ", cutQuantity="
            + this.cutQuantity
            + ")";
      }
   }
}
