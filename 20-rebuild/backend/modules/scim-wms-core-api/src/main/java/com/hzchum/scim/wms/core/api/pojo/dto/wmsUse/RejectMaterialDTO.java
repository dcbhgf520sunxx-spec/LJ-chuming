package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.time.LocalDateTime;

public class RejectMaterialDTO {
   private Integer reviewStatus;
   private LocalDateTime createTime;
   private MaterialInventoryDTO material;

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public MaterialInventoryDTO getMaterial() {
      return this.material;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setMaterial(final MaterialInventoryDTO material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectMaterialDTO)) {
         return false;
      }

      RejectMaterialDTO other = (RejectMaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            return this$material == null ? other$material == null : this$material.equals(other$material);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RejectMaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "RejectMaterialDTO(reviewStatus=" + this.getReviewStatus() + ", createTime=" + this.getCreateTime() + ", material=" + this.getMaterial() + ")";
   }

   public RejectMaterialDTO(final Integer reviewStatus, final LocalDateTime createTime, final MaterialInventoryDTO material) {
      this.reviewStatus = reviewStatus;
      this.createTime = createTime;
      this.material = material;
   }

   public RejectMaterialDTO() {
   }
}
