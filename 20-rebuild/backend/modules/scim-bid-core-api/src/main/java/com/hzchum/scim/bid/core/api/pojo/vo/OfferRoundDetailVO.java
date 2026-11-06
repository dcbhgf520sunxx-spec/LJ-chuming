package com.hzchum.scim.bid.core.api.pojo.vo;

import java.util.List;

public class OfferRoundDetailVO {
   private Long projectSubjectId;
   private String subjectNames;
   private String subjectName;
   private String specification;
   private String modelNumber;
   private Double mete;
   private String unitName;
   private Integer offerRound;
   private Integer isFollow;
   private Long supplierId;
   private Long offerDetailId;
   private List<CommonVO> weedOuts;
   private List<CommonVO> nextRounds;
   private List<DetailVO> detailVOList;

   public static OfferRoundDetailVO.OfferRoundDetailVOBuilder builder() {
      return new OfferRoundDetailVO.OfferRoundDetailVOBuilder();
   }

   public OfferRoundDetailVO() {
   }

   public OfferRoundDetailVO(
      final Long projectSubjectId,
      final String subjectNames,
      final String subjectName,
      final String specification,
      final String modelNumber,
      final Double mete,
      final String unitName,
      final Integer offerRound,
      final Integer isFollow,
      final Long supplierId,
      final Long offerDetailId,
      final List<CommonVO> weedOuts,
      final List<CommonVO> nextRounds,
      final List<DetailVO> detailVOList
   ) {
      this.projectSubjectId = projectSubjectId;
      this.subjectNames = subjectNames;
      this.subjectName = subjectName;
      this.specification = specification;
      this.modelNumber = modelNumber;
      this.mete = mete;
      this.unitName = unitName;
      this.offerRound = offerRound;
      this.isFollow = isFollow;
      this.supplierId = supplierId;
      this.offerDetailId = offerDetailId;
      this.weedOuts = weedOuts;
      this.nextRounds = nextRounds;
      this.detailVOList = detailVOList;
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public String getSubjectNames() {
      return this.subjectNames;
   }

   public String getSubjectName() {
      return this.subjectName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModelNumber() {
      return this.modelNumber;
   }

   public Double getMete() {
      return this.mete;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public Integer getOfferRound() {
      return this.offerRound;
   }

   public Integer getIsFollow() {
      return this.isFollow;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getOfferDetailId() {
      return this.offerDetailId;
   }

   public List<CommonVO> getWeedOuts() {
      return this.weedOuts;
   }

   public List<CommonVO> getNextRounds() {
      return this.nextRounds;
   }

   public List<DetailVO> getDetailVOList() {
      return this.detailVOList;
   }

   public void setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
   }

   public void setSubjectNames(final String subjectNames) {
      this.subjectNames = subjectNames;
   }

   public void setSubjectName(final String subjectName) {
      this.subjectName = subjectName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModelNumber(final String modelNumber) {
      this.modelNumber = modelNumber;
   }

   public void setMete(final Double mete) {
      this.mete = mete;
   }

   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   public void setOfferRound(final Integer offerRound) {
      this.offerRound = offerRound;
   }

   public void setIsFollow(final Integer isFollow) {
      this.isFollow = isFollow;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setOfferDetailId(final Long offerDetailId) {
      this.offerDetailId = offerDetailId;
   }

   public void setWeedOuts(final List<CommonVO> weedOuts) {
      this.weedOuts = weedOuts;
   }

   public void setNextRounds(final List<CommonVO> nextRounds) {
      this.nextRounds = nextRounds;
   }

   public void setDetailVOList(final List<DetailVO> detailVOList) {
      this.detailVOList = detailVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OfferRoundDetailVO)) {
         return false;
      }

      OfferRoundDetailVO other = (OfferRoundDetailVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectSubjectId = this.getProjectSubjectId();
      Object other$projectSubjectId = other.getProjectSubjectId();
      if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$offerRound = this.getOfferRound();
            Object other$offerRound = other.getOfferRound();
            if (this$offerRound == null ? other$offerRound == null : this$offerRound.equals(other$offerRound)) {
               Object this$isFollow = this.getIsFollow();
               Object other$isFollow = other.getIsFollow();
               if (this$isFollow == null ? other$isFollow == null : this$isFollow.equals(other$isFollow)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$offerDetailId = this.getOfferDetailId();
                     Object other$offerDetailId = other.getOfferDetailId();
                     if (this$offerDetailId == null ? other$offerDetailId == null : this$offerDetailId.equals(other$offerDetailId)) {
                        Object this$subjectNames = this.getSubjectNames();
                        Object other$subjectNames = other.getSubjectNames();
                        if (this$subjectNames == null ? other$subjectNames == null : this$subjectNames.equals(other$subjectNames)) {
                           Object this$subjectName = this.getSubjectName();
                           Object other$subjectName = other.getSubjectName();
                           if (this$subjectName == null ? other$subjectName == null : this$subjectName.equals(other$subjectName)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$modelNumber = this.getModelNumber();
                                 Object other$modelNumber = other.getModelNumber();
                                 if (this$modelNumber == null ? other$modelNumber == null : this$modelNumber.equals(other$modelNumber)) {
                                    Object this$unitName = this.getUnitName();
                                    Object other$unitName = other.getUnitName();
                                    if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                                       Object this$weedOuts = this.getWeedOuts();
                                       Object other$weedOuts = other.getWeedOuts();
                                       if (this$weedOuts == null ? other$weedOuts == null : this$weedOuts.equals(other$weedOuts)) {
                                          Object this$nextRounds = this.getNextRounds();
                                          Object other$nextRounds = other.getNextRounds();
                                          if (this$nextRounds == null ? other$nextRounds == null : this$nextRounds.equals(other$nextRounds)) {
                                             Object this$detailVOList = this.getDetailVOList();
                                             Object other$detailVOList = other.getDetailVOList();
                                             return this$detailVOList == null ? other$detailVOList == null : this$detailVOList.equals(other$detailVOList);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OfferRoundDetailVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $offerRound = this.getOfferRound();
      result = result * 59 + ($offerRound == null ? 43 : $offerRound.hashCode());
      Object $isFollow = this.getIsFollow();
      result = result * 59 + ($isFollow == null ? 43 : $isFollow.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $offerDetailId = this.getOfferDetailId();
      result = result * 59 + ($offerDetailId == null ? 43 : $offerDetailId.hashCode());
      Object $subjectNames = this.getSubjectNames();
      result = result * 59 + ($subjectNames == null ? 43 : $subjectNames.hashCode());
      Object $subjectName = this.getSubjectName();
      result = result * 59 + ($subjectName == null ? 43 : $subjectName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $modelNumber = this.getModelNumber();
      result = result * 59 + ($modelNumber == null ? 43 : $modelNumber.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $weedOuts = this.getWeedOuts();
      result = result * 59 + ($weedOuts == null ? 43 : $weedOuts.hashCode());
      Object $nextRounds = this.getNextRounds();
      result = result * 59 + ($nextRounds == null ? 43 : $nextRounds.hashCode());
      Object $detailVOList = this.getDetailVOList();
      return result * 59 + ($detailVOList == null ? 43 : $detailVOList.hashCode());
   }

   @Override
   public String toString() {
      return "OfferRoundDetailVO(projectSubjectId="
         + this.getProjectSubjectId()
         + ", subjectNames="
         + this.getSubjectNames()
         + ", subjectName="
         + this.getSubjectName()
         + ", specification="
         + this.getSpecification()
         + ", modelNumber="
         + this.getModelNumber()
         + ", mete="
         + this.getMete()
         + ", unitName="
         + this.getUnitName()
         + ", offerRound="
         + this.getOfferRound()
         + ", isFollow="
         + this.getIsFollow()
         + ", supplierId="
         + this.getSupplierId()
         + ", offerDetailId="
         + this.getOfferDetailId()
         + ", weedOuts="
         + this.getWeedOuts()
         + ", nextRounds="
         + this.getNextRounds()
         + ", detailVOList="
         + this.getDetailVOList()
         + ")";
   }

   public static class OfferRoundDetailVOBuilder {
      private Long projectSubjectId;
      private String subjectNames;
      private String subjectName;
      private String specification;
      private String modelNumber;
      private Double mete;
      private String unitName;
      private Integer offerRound;
      private Integer isFollow;
      private Long supplierId;
      private Long offerDetailId;
      private List<CommonVO> weedOuts;
      private List<CommonVO> nextRounds;
      private List<DetailVO> detailVOList;

      OfferRoundDetailVOBuilder() {
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder subjectNames(final String subjectNames) {
         this.subjectNames = subjectNames;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder subjectName(final String subjectName) {
         this.subjectName = subjectName;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder modelNumber(final String modelNumber) {
         this.modelNumber = modelNumber;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder mete(final Double mete) {
         this.mete = mete;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder unitName(final String unitName) {
         this.unitName = unitName;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder offerRound(final Integer offerRound) {
         this.offerRound = offerRound;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder isFollow(final Integer isFollow) {
         this.isFollow = isFollow;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder offerDetailId(final Long offerDetailId) {
         this.offerDetailId = offerDetailId;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder weedOuts(final List<CommonVO> weedOuts) {
         this.weedOuts = weedOuts;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder nextRounds(final List<CommonVO> nextRounds) {
         this.nextRounds = nextRounds;
         return this;
      }

      public OfferRoundDetailVO.OfferRoundDetailVOBuilder detailVOList(final List<DetailVO> detailVOList) {
         this.detailVOList = detailVOList;
         return this;
      }

      public OfferRoundDetailVO build() {
         return new OfferRoundDetailVO(
            this.projectSubjectId,
            this.subjectNames,
            this.subjectName,
            this.specification,
            this.modelNumber,
            this.mete,
            this.unitName,
            this.offerRound,
            this.isFollow,
            this.supplierId,
            this.offerDetailId,
            this.weedOuts,
            this.nextRounds,
            this.detailVOList
         );
      }

      @Override
      public String toString() {
         return "OfferRoundDetailVO.OfferRoundDetailVOBuilder(projectSubjectId="
            + this.projectSubjectId
            + ", subjectNames="
            + this.subjectNames
            + ", subjectName="
            + this.subjectName
            + ", specification="
            + this.specification
            + ", modelNumber="
            + this.modelNumber
            + ", mete="
            + this.mete
            + ", unitName="
            + this.unitName
            + ", offerRound="
            + this.offerRound
            + ", isFollow="
            + this.isFollow
            + ", supplierId="
            + this.supplierId
            + ", offerDetailId="
            + this.offerDetailId
            + ", weedOuts="
            + this.weedOuts
            + ", nextRounds="
            + this.nextRounds
            + ", detailVOList="
            + this.detailVOList
            + ")";
      }
   }
}
