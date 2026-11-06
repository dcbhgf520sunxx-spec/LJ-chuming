package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;
import java.util.List;

public class SupplierAmountVO {
   private Long supplierId;
   private BigDecimal totalAmount;
   private List<SubjectProjectVO> winBidVOS;

   public static SupplierAmountVO.SupplierAmountVOBuilder builder() {
      return new SupplierAmountVO.SupplierAmountVOBuilder();
   }

   public SupplierAmountVO() {
   }

   public SupplierAmountVO(final Long supplierId, final BigDecimal totalAmount, final List<SubjectProjectVO> winBidVOS) {
      this.supplierId = supplierId;
      this.totalAmount = totalAmount;
      this.winBidVOS = winBidVOS;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public List<SubjectProjectVO> getWinBidVOS() {
      return this.winBidVOS;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setWinBidVOS(final List<SubjectProjectVO> winBidVOS) {
      this.winBidVOS = winBidVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierAmountVO)) {
         return false;
      }

      SupplierAmountVO other = (SupplierAmountVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$totalAmount = this.getTotalAmount();
         Object other$totalAmount = other.getTotalAmount();
         if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
            Object this$winBidVOS = this.getWinBidVOS();
            Object other$winBidVOS = other.getWinBidVOS();
            return this$winBidVOS == null ? other$winBidVOS == null : this$winBidVOS.equals(other$winBidVOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierAmountVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $winBidVOS = this.getWinBidVOS();
      return result * 59 + ($winBidVOS == null ? 43 : $winBidVOS.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierAmountVO(supplierId=" + this.getSupplierId() + ", totalAmount=" + this.getTotalAmount() + ", winBidVOS=" + this.getWinBidVOS() + ")";
   }

   public static class SupplierAmountVOBuilder {
      private Long supplierId;
      private BigDecimal totalAmount;
      private List<SubjectProjectVO> winBidVOS;

      SupplierAmountVOBuilder() {
      }

      public SupplierAmountVO.SupplierAmountVOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierAmountVO.SupplierAmountVOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public SupplierAmountVO.SupplierAmountVOBuilder winBidVOS(final List<SubjectProjectVO> winBidVOS) {
         this.winBidVOS = winBidVOS;
         return this;
      }

      public SupplierAmountVO build() {
         return new SupplierAmountVO(this.supplierId, this.totalAmount, this.winBidVOS);
      }

      @Override
      public String toString() {
         return "SupplierAmountVO.SupplierAmountVOBuilder(supplierId="
            + this.supplierId
            + ", totalAmount="
            + this.totalAmount
            + ", winBidVOS="
            + this.winBidVOS
            + ")";
      }
   }
}
