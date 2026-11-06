package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CAPP 产品焊缝数量 查询参数")
public class CappCraftCardProductWeldCountDTO {
   private Long productId;
   private Long areaId;
   private Long monomerId;

   CappCraftCardProductWeldCountDTO(final Long productId, final Long areaId, final Long monomerId) {
      this.productId = productId;
      this.areaId = areaId;
      this.monomerId = monomerId;
   }

   public static CappCraftCardProductWeldCountDTO.CappCraftCardProductWeldCountDTOBuilder builder() {
      return new CappCraftCardProductWeldCountDTO.CappCraftCardProductWeldCountDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductWeldCountDTO)) {
         return false;
      }

      CappCraftCardProductWeldCountDTO other = (CappCraftCardProductWeldCountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            return this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductWeldCountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      return result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductWeldCountDTO(productId=" + this.getProductId() + ", areaId=" + this.getAreaId() + ", monomerId=" + this.getMonomerId() + ")";
   }

   public static class CappCraftCardProductWeldCountDTOBuilder {
      private Long productId;
      private Long areaId;
      private Long monomerId;

      CappCraftCardProductWeldCountDTOBuilder() {
      }

      public CappCraftCardProductWeldCountDTO.CappCraftCardProductWeldCountDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CappCraftCardProductWeldCountDTO.CappCraftCardProductWeldCountDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public CappCraftCardProductWeldCountDTO.CappCraftCardProductWeldCountDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public CappCraftCardProductWeldCountDTO build() {
         return new CappCraftCardProductWeldCountDTO(this.productId, this.areaId, this.monomerId);
      }

      @Override
      public String toString() {
         return "CappCraftCardProductWeldCountDTO.CappCraftCardProductWeldCountDTOBuilder(productId="
            + this.productId
            + ", areaId="
            + this.areaId
            + ", monomerId="
            + this.monomerId
            + ")";
      }
   }
}
