package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;

public class DetailVO {
   private Long projectSubjectId;
   private Long supplierId;
   private String supplierName;
   private String shortName;
   private Long offerDetailId;
   private Integer round;
   private BigDecimal bidAmount;
   private BigDecimal unitPrice;
   private Integer extremeValue;
   private BigDecimal contrastBidAmount;
   private BigDecimal previousRoundUnitPrice;
   private BigDecimal previousRoundBidAmount;
   private Integer isFollow;

   public static DetailVO.DetailVOBuilder builder() {
      return new DetailVO.DetailVOBuilder();
   }

   public DetailVO() {
   }

   public DetailVO(
      final Long projectSubjectId,
      final Long supplierId,
      final String supplierName,
      final String shortName,
      final Long offerDetailId,
      final Integer round,
      final BigDecimal bidAmount,
      final BigDecimal unitPrice,
      final Integer extremeValue,
      final BigDecimal contrastBidAmount,
      final BigDecimal previousRoundUnitPrice,
      final BigDecimal previousRoundBidAmount,
      final Integer isFollow
   ) {
      this.projectSubjectId = projectSubjectId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.shortName = shortName;
      this.offerDetailId = offerDetailId;
      this.round = round;
      this.bidAmount = bidAmount;
      this.unitPrice = unitPrice;
      this.extremeValue = extremeValue;
      this.contrastBidAmount = contrastBidAmount;
      this.previousRoundUnitPrice = previousRoundUnitPrice;
      this.previousRoundBidAmount = previousRoundBidAmount;
      this.isFollow = isFollow;
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Long getOfferDetailId() {
      return this.offerDetailId;
   }

   public Integer getRound() {
      return this.round;
   }

   public BigDecimal getBidAmount() {
      return this.bidAmount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getExtremeValue() {
      return this.extremeValue;
   }

   public BigDecimal getContrastBidAmount() {
      return this.contrastBidAmount;
   }

   public BigDecimal getPreviousRoundUnitPrice() {
      return this.previousRoundUnitPrice;
   }

   public BigDecimal getPreviousRoundBidAmount() {
      return this.previousRoundBidAmount;
   }

   public Integer getIsFollow() {
      return this.isFollow;
   }

   public void setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setOfferDetailId(final Long offerDetailId) {
      this.offerDetailId = offerDetailId;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   public void setBidAmount(final BigDecimal bidAmount) {
      this.bidAmount = bidAmount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setExtremeValue(final Integer extremeValue) {
      this.extremeValue = extremeValue;
   }

   public void setContrastBidAmount(final BigDecimal contrastBidAmount) {
      this.contrastBidAmount = contrastBidAmount;
   }

   public void setPreviousRoundUnitPrice(final BigDecimal previousRoundUnitPrice) {
      this.previousRoundUnitPrice = previousRoundUnitPrice;
   }

   public void setPreviousRoundBidAmount(final BigDecimal previousRoundBidAmount) {
      this.previousRoundBidAmount = previousRoundBidAmount;
   }

   public void setIsFollow(final Integer isFollow) {
      this.isFollow = isFollow;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DetailVO)) {
         return false;
      }

      DetailVO other = (DetailVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectSubjectId = this.getProjectSubjectId();
      Object other$projectSubjectId = other.getProjectSubjectId();
      if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$offerDetailId = this.getOfferDetailId();
            Object other$offerDetailId = other.getOfferDetailId();
            if (this$offerDetailId == null ? other$offerDetailId == null : this$offerDetailId.equals(other$offerDetailId)) {
               Object this$round = this.getRound();
               Object other$round = other.getRound();
               if (this$round == null ? other$round == null : this$round.equals(other$round)) {
                  Object this$extremeValue = this.getExtremeValue();
                  Object other$extremeValue = other.getExtremeValue();
                  if (this$extremeValue == null ? other$extremeValue == null : this$extremeValue.equals(other$extremeValue)) {
                     Object this$isFollow = this.getIsFollow();
                     Object other$isFollow = other.getIsFollow();
                     if (this$isFollow == null ? other$isFollow == null : this$isFollow.equals(other$isFollow)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$bidAmount = this.getBidAmount();
                              Object other$bidAmount = other.getBidAmount();
                              if (this$bidAmount == null ? other$bidAmount == null : this$bidAmount.equals(other$bidAmount)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$contrastBidAmount = this.getContrastBidAmount();
                                    Object other$contrastBidAmount = other.getContrastBidAmount();
                                    if (this$contrastBidAmount == null
                                       ? other$contrastBidAmount == null
                                       : this$contrastBidAmount.equals(other$contrastBidAmount)) {
                                       Object this$previousRoundUnitPrice = this.getPreviousRoundUnitPrice();
                                       Object other$previousRoundUnitPrice = other.getPreviousRoundUnitPrice();
                                       if (this$previousRoundUnitPrice == null
                                          ? other$previousRoundUnitPrice == null
                                          : this$previousRoundUnitPrice.equals(other$previousRoundUnitPrice)) {
                                          Object this$previousRoundBidAmount = this.getPreviousRoundBidAmount();
                                          Object other$previousRoundBidAmount = other.getPreviousRoundBidAmount();
                                          return this$previousRoundBidAmount == null
                                             ? other$previousRoundBidAmount == null
                                             : this$previousRoundBidAmount.equals(other$previousRoundBidAmount);
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof DetailVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $offerDetailId = this.getOfferDetailId();
      result = result * 59 + ($offerDetailId == null ? 43 : $offerDetailId.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $extremeValue = this.getExtremeValue();
      result = result * 59 + ($extremeValue == null ? 43 : $extremeValue.hashCode());
      Object $isFollow = this.getIsFollow();
      result = result * 59 + ($isFollow == null ? 43 : $isFollow.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $bidAmount = this.getBidAmount();
      result = result * 59 + ($bidAmount == null ? 43 : $bidAmount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $contrastBidAmount = this.getContrastBidAmount();
      result = result * 59 + ($contrastBidAmount == null ? 43 : $contrastBidAmount.hashCode());
      Object $previousRoundUnitPrice = this.getPreviousRoundUnitPrice();
      result = result * 59 + ($previousRoundUnitPrice == null ? 43 : $previousRoundUnitPrice.hashCode());
      Object $previousRoundBidAmount = this.getPreviousRoundBidAmount();
      return result * 59 + ($previousRoundBidAmount == null ? 43 : $previousRoundBidAmount.hashCode());
   }

   @Override
   public String toString() {
      return "DetailVO(projectSubjectId="
         + this.getProjectSubjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", shortName="
         + this.getShortName()
         + ", offerDetailId="
         + this.getOfferDetailId()
         + ", round="
         + this.getRound()
         + ", bidAmount="
         + this.getBidAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", extremeValue="
         + this.getExtremeValue()
         + ", contrastBidAmount="
         + this.getContrastBidAmount()
         + ", previousRoundUnitPrice="
         + this.getPreviousRoundUnitPrice()
         + ", previousRoundBidAmount="
         + this.getPreviousRoundBidAmount()
         + ", isFollow="
         + this.getIsFollow()
         + ")";
   }

   public static class DetailVOBuilder {
      private Long projectSubjectId;
      private Long supplierId;
      private String supplierName;
      private String shortName;
      private Long offerDetailId;
      private Integer round;
      private BigDecimal bidAmount;
      private BigDecimal unitPrice;
      private Integer extremeValue;
      private BigDecimal contrastBidAmount;
      private BigDecimal previousRoundUnitPrice;
      private BigDecimal previousRoundBidAmount;
      private Integer isFollow;

      DetailVOBuilder() {
      }

      public DetailVO.DetailVOBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      public DetailVO.DetailVOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public DetailVO.DetailVOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public DetailVO.DetailVOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public DetailVO.DetailVOBuilder offerDetailId(final Long offerDetailId) {
         this.offerDetailId = offerDetailId;
         return this;
      }

      public DetailVO.DetailVOBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public DetailVO.DetailVOBuilder bidAmount(final BigDecimal bidAmount) {
         this.bidAmount = bidAmount;
         return this;
      }

      public DetailVO.DetailVOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public DetailVO.DetailVOBuilder extremeValue(final Integer extremeValue) {
         this.extremeValue = extremeValue;
         return this;
      }

      public DetailVO.DetailVOBuilder contrastBidAmount(final BigDecimal contrastBidAmount) {
         this.contrastBidAmount = contrastBidAmount;
         return this;
      }

      public DetailVO.DetailVOBuilder previousRoundUnitPrice(final BigDecimal previousRoundUnitPrice) {
         this.previousRoundUnitPrice = previousRoundUnitPrice;
         return this;
      }

      public DetailVO.DetailVOBuilder previousRoundBidAmount(final BigDecimal previousRoundBidAmount) {
         this.previousRoundBidAmount = previousRoundBidAmount;
         return this;
      }

      public DetailVO.DetailVOBuilder isFollow(final Integer isFollow) {
         this.isFollow = isFollow;
         return this;
      }

      public DetailVO build() {
         return new DetailVO(
            this.projectSubjectId,
            this.supplierId,
            this.supplierName,
            this.shortName,
            this.offerDetailId,
            this.round,
            this.bidAmount,
            this.unitPrice,
            this.extremeValue,
            this.contrastBidAmount,
            this.previousRoundUnitPrice,
            this.previousRoundBidAmount,
            this.isFollow
         );
      }

      @Override
      public String toString() {
         return "DetailVO.DetailVOBuilder(projectSubjectId="
            + this.projectSubjectId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", shortName="
            + this.shortName
            + ", offerDetailId="
            + this.offerDetailId
            + ", round="
            + this.round
            + ", bidAmount="
            + this.bidAmount
            + ", unitPrice="
            + this.unitPrice
            + ", extremeValue="
            + this.extremeValue
            + ", contrastBidAmount="
            + this.contrastBidAmount
            + ", previousRoundUnitPrice="
            + this.previousRoundUnitPrice
            + ", previousRoundBidAmount="
            + this.previousRoundBidAmount
            + ", isFollow="
            + this.isFollow
            + ")";
      }
   }
}
