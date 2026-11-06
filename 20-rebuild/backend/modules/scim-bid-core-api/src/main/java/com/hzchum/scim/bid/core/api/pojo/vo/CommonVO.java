package com.hzchum.scim.bid.core.api.pojo.vo;

public class CommonVO {
   private Long supplierId;
   private Long offerDetailId;

   public static CommonVO.CommonVOBuilder builder() {
      return new CommonVO.CommonVOBuilder();
   }

   public CommonVO() {
   }

   public CommonVO(final Long supplierId, final Long offerDetailId) {
      this.supplierId = supplierId;
      this.offerDetailId = offerDetailId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getOfferDetailId() {
      return this.offerDetailId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setOfferDetailId(final Long offerDetailId) {
      this.offerDetailId = offerDetailId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CommonVO)) {
         return false;
      } else {
         CommonVO other = (CommonVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$offerDetailId = this.getOfferDetailId();
               Object other$offerDetailId = other.getOfferDetailId();
               return this$offerDetailId == null ? other$offerDetailId == null : this$offerDetailId.equals(other$offerDetailId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CommonVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $offerDetailId = this.getOfferDetailId();
      return result * 59 + ($offerDetailId == null ? 43 : $offerDetailId.hashCode());
   }

   @Override
   public String toString() {
      return "CommonVO(supplierId=" + this.getSupplierId() + ", offerDetailId=" + this.getOfferDetailId() + ")";
   }

   public static class CommonVOBuilder {
      private Long supplierId;
      private Long offerDetailId;

      CommonVOBuilder() {
      }

      public CommonVO.CommonVOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public CommonVO.CommonVOBuilder offerDetailId(final Long offerDetailId) {
         this.offerDetailId = offerDetailId;
         return this;
      }

      public CommonVO build() {
         return new CommonVO(this.supplierId, this.offerDetailId);
      }

      @Override
      public String toString() {
         return "CommonVO.CommonVOBuilder(supplierId=" + this.supplierId + ", offerDetailId=" + this.offerDetailId + ")";
      }
   }
}
