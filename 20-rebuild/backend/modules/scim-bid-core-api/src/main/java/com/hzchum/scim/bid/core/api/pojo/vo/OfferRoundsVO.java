package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OfferRoundsVO {
   private Long id;
   private String supplierName;
   private String shortName;
   private String phone;
   private Long projectTenderingId;
   private Integer round;
   private BigDecimal bidGrossAmount;
   private String remark;
   private Date offerTime;
   private Integer source;
   private BigDecimal contrastBidAmount;
   private Date bidDeadline;
   private Date bidOpeningTime;
   private Integer isHold;
   private String iPAddress;
   private String DepositUrl;
   private String DepositName;
   private List<SubjectProjectVO> subjectProjectVOList;

   public static OfferRoundsVO.OfferRoundsVOBuilder builder() {
      return new OfferRoundsVO.OfferRoundsVOBuilder();
   }

   public OfferRoundsVO() {
   }

   public OfferRoundsVO(
      final Long id,
      final String supplierName,
      final String shortName,
      final String phone,
      final Long projectTenderingId,
      final Integer round,
      final BigDecimal bidGrossAmount,
      final String remark,
      final Date offerTime,
      final Integer source,
      final BigDecimal contrastBidAmount,
      final Date bidDeadline,
      final Date bidOpeningTime,
      final Integer isHold,
      final String iPAddress,
      final String DepositUrl,
      final String DepositName,
      final List<SubjectProjectVO> subjectProjectVOList
   ) {
      this.id = id;
      this.supplierName = supplierName;
      this.shortName = shortName;
      this.phone = phone;
      this.projectTenderingId = projectTenderingId;
      this.round = round;
      this.bidGrossAmount = bidGrossAmount;
      this.remark = remark;
      this.offerTime = offerTime;
      this.source = source;
      this.contrastBidAmount = contrastBidAmount;
      this.bidDeadline = bidDeadline;
      this.bidOpeningTime = bidOpeningTime;
      this.isHold = isHold;
      this.iPAddress = iPAddress;
      this.DepositUrl = DepositUrl;
      this.DepositName = DepositName;
      this.subjectProjectVOList = subjectProjectVOList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getPhone() {
      return this.phone;
   }

   public Long getProjectTenderingId() {
      return this.projectTenderingId;
   }

   public Integer getRound() {
      return this.round;
   }

   public BigDecimal getBidGrossAmount() {
      return this.bidGrossAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Date getOfferTime() {
      return this.offerTime;
   }

   public Integer getSource() {
      return this.source;
   }

   public BigDecimal getContrastBidAmount() {
      return this.contrastBidAmount;
   }

   public Date getBidDeadline() {
      return this.bidDeadline;
   }

   public Date getBidOpeningTime() {
      return this.bidOpeningTime;
   }

   public Integer getIsHold() {
      return this.isHold;
   }

   public String getIPAddress() {
      return this.iPAddress;
   }

   public String getDepositUrl() {
      return this.DepositUrl;
   }

   public String getDepositName() {
      return this.DepositName;
   }

   public List<SubjectProjectVO> getSubjectProjectVOList() {
      return this.subjectProjectVOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setProjectTenderingId(final Long projectTenderingId) {
      this.projectTenderingId = projectTenderingId;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   public void setBidGrossAmount(final BigDecimal bidGrossAmount) {
      this.bidGrossAmount = bidGrossAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setOfferTime(final Date offerTime) {
      this.offerTime = offerTime;
   }

   public void setSource(final Integer source) {
      this.source = source;
   }

   public void setContrastBidAmount(final BigDecimal contrastBidAmount) {
      this.contrastBidAmount = contrastBidAmount;
   }

   public void setBidDeadline(final Date bidDeadline) {
      this.bidDeadline = bidDeadline;
   }

   public void setBidOpeningTime(final Date bidOpeningTime) {
      this.bidOpeningTime = bidOpeningTime;
   }

   public void setIsHold(final Integer isHold) {
      this.isHold = isHold;
   }

   public void setIPAddress(final String iPAddress) {
      this.iPAddress = iPAddress;
   }

   public void setDepositUrl(final String DepositUrl) {
      this.DepositUrl = DepositUrl;
   }

   public void setDepositName(final String DepositName) {
      this.DepositName = DepositName;
   }

   public void setSubjectProjectVOList(final List<SubjectProjectVO> subjectProjectVOList) {
      this.subjectProjectVOList = subjectProjectVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OfferRoundsVO)) {
         return false;
      }

      OfferRoundsVO other = (OfferRoundsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectTenderingId = this.getProjectTenderingId();
         Object other$projectTenderingId = other.getProjectTenderingId();
         if (this$projectTenderingId == null ? other$projectTenderingId == null : this$projectTenderingId.equals(other$projectTenderingId)) {
            Object this$round = this.getRound();
            Object other$round = other.getRound();
            if (this$round == null ? other$round == null : this$round.equals(other$round)) {
               Object this$source = this.getSource();
               Object other$source = other.getSource();
               if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                  Object this$isHold = this.getIsHold();
                  Object other$isHold = other.getIsHold();
                  if (this$isHold == null ? other$isHold == null : this$isHold.equals(other$isHold)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$shortName = this.getShortName();
                        Object other$shortName = other.getShortName();
                        if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                           Object this$phone = this.getPhone();
                           Object other$phone = other.getPhone();
                           if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                              Object this$bidGrossAmount = this.getBidGrossAmount();
                              Object other$bidGrossAmount = other.getBidGrossAmount();
                              if (this$bidGrossAmount == null ? other$bidGrossAmount == null : this$bidGrossAmount.equals(other$bidGrossAmount)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$offerTime = this.getOfferTime();
                                    Object other$offerTime = other.getOfferTime();
                                    if (this$offerTime == null ? other$offerTime == null : this$offerTime.equals(other$offerTime)) {
                                       Object this$contrastBidAmount = this.getContrastBidAmount();
                                       Object other$contrastBidAmount = other.getContrastBidAmount();
                                       if (this$contrastBidAmount == null
                                          ? other$contrastBidAmount == null
                                          : this$contrastBidAmount.equals(other$contrastBidAmount)) {
                                          Object this$bidDeadline = this.getBidDeadline();
                                          Object other$bidDeadline = other.getBidDeadline();
                                          if (this$bidDeadline == null ? other$bidDeadline == null : this$bidDeadline.equals(other$bidDeadline)) {
                                             Object this$bidOpeningTime = this.getBidOpeningTime();
                                             Object other$bidOpeningTime = other.getBidOpeningTime();
                                             if (this$bidOpeningTime == null ? other$bidOpeningTime == null : this$bidOpeningTime.equals(other$bidOpeningTime)) {
                                                Object this$iPAddress = this.getIPAddress();
                                                Object other$iPAddress = other.getIPAddress();
                                                if (this$iPAddress == null ? other$iPAddress == null : this$iPAddress.equals(other$iPAddress)) {
                                                   Object this$DepositUrl = this.getDepositUrl();
                                                   Object other$DepositUrl = other.getDepositUrl();
                                                   if (this$DepositUrl == null ? other$DepositUrl == null : this$DepositUrl.equals(other$DepositUrl)) {
                                                      Object this$DepositName = this.getDepositName();
                                                      Object other$DepositName = other.getDepositName();
                                                      if (this$DepositName == null ? other$DepositName == null : this$DepositName.equals(other$DepositName)) {
                                                         Object this$subjectProjectVOList = this.getSubjectProjectVOList();
                                                         Object other$subjectProjectVOList = other.getSubjectProjectVOList();
                                                         return this$subjectProjectVOList == null
                                                            ? other$subjectProjectVOList == null
                                                            : this$subjectProjectVOList.equals(other$subjectProjectVOList);
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
      return other instanceof OfferRoundsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectTenderingId = this.getProjectTenderingId();
      result = result * 59 + ($projectTenderingId == null ? 43 : $projectTenderingId.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $isHold = this.getIsHold();
      result = result * 59 + ($isHold == null ? 43 : $isHold.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $bidGrossAmount = this.getBidGrossAmount();
      result = result * 59 + ($bidGrossAmount == null ? 43 : $bidGrossAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $offerTime = this.getOfferTime();
      result = result * 59 + ($offerTime == null ? 43 : $offerTime.hashCode());
      Object $contrastBidAmount = this.getContrastBidAmount();
      result = result * 59 + ($contrastBidAmount == null ? 43 : $contrastBidAmount.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      result = result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
      Object $iPAddress = this.getIPAddress();
      result = result * 59 + ($iPAddress == null ? 43 : $iPAddress.hashCode());
      Object $DepositUrl = this.getDepositUrl();
      result = result * 59 + ($DepositUrl == null ? 43 : $DepositUrl.hashCode());
      Object $DepositName = this.getDepositName();
      result = result * 59 + ($DepositName == null ? 43 : $DepositName.hashCode());
      Object $subjectProjectVOList = this.getSubjectProjectVOList();
      return result * 59 + ($subjectProjectVOList == null ? 43 : $subjectProjectVOList.hashCode());
   }

   @Override
   public String toString() {
      return "OfferRoundsVO(id="
         + this.getId()
         + ", supplierName="
         + this.getSupplierName()
         + ", shortName="
         + this.getShortName()
         + ", phone="
         + this.getPhone()
         + ", projectTenderingId="
         + this.getProjectTenderingId()
         + ", round="
         + this.getRound()
         + ", bidGrossAmount="
         + this.getBidGrossAmount()
         + ", remark="
         + this.getRemark()
         + ", offerTime="
         + this.getOfferTime()
         + ", source="
         + this.getSource()
         + ", contrastBidAmount="
         + this.getContrastBidAmount()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ", isHold="
         + this.getIsHold()
         + ", iPAddress="
         + this.getIPAddress()
         + ", DepositUrl="
         + this.getDepositUrl()
         + ", DepositName="
         + this.getDepositName()
         + ", subjectProjectVOList="
         + this.getSubjectProjectVOList()
         + ")";
   }

   public static class OfferRoundsVOBuilder {
      private Long id;
      private String supplierName;
      private String shortName;
      private String phone;
      private Long projectTenderingId;
      private Integer round;
      private BigDecimal bidGrossAmount;
      private String remark;
      private Date offerTime;
      private Integer source;
      private BigDecimal contrastBidAmount;
      private Date bidDeadline;
      private Date bidOpeningTime;
      private Integer isHold;
      private String iPAddress;
      private String DepositUrl;
      private String DepositName;
      private List<SubjectProjectVO> subjectProjectVOList;

      OfferRoundsVOBuilder() {
      }

      public OfferRoundsVO.OfferRoundsVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder projectTenderingId(final Long projectTenderingId) {
         this.projectTenderingId = projectTenderingId;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder bidGrossAmount(final BigDecimal bidGrossAmount) {
         this.bidGrossAmount = bidGrossAmount;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder offerTime(final Date offerTime) {
         this.offerTime = offerTime;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder contrastBidAmount(final BigDecimal contrastBidAmount) {
         this.contrastBidAmount = contrastBidAmount;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder bidDeadline(final Date bidDeadline) {
         this.bidDeadline = bidDeadline;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder bidOpeningTime(final Date bidOpeningTime) {
         this.bidOpeningTime = bidOpeningTime;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder isHold(final Integer isHold) {
         this.isHold = isHold;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder iPAddress(final String iPAddress) {
         this.iPAddress = iPAddress;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder DepositUrl(final String DepositUrl) {
         this.DepositUrl = DepositUrl;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder DepositName(final String DepositName) {
         this.DepositName = DepositName;
         return this;
      }

      public OfferRoundsVO.OfferRoundsVOBuilder subjectProjectVOList(final List<SubjectProjectVO> subjectProjectVOList) {
         this.subjectProjectVOList = subjectProjectVOList;
         return this;
      }

      public OfferRoundsVO build() {
         return new OfferRoundsVO(
            this.id,
            this.supplierName,
            this.shortName,
            this.phone,
            this.projectTenderingId,
            this.round,
            this.bidGrossAmount,
            this.remark,
            this.offerTime,
            this.source,
            this.contrastBidAmount,
            this.bidDeadline,
            this.bidOpeningTime,
            this.isHold,
            this.iPAddress,
            this.DepositUrl,
            this.DepositName,
            this.subjectProjectVOList
         );
      }

      @Override
      public String toString() {
         return "OfferRoundsVO.OfferRoundsVOBuilder(id="
            + this.id
            + ", supplierName="
            + this.supplierName
            + ", shortName="
            + this.shortName
            + ", phone="
            + this.phone
            + ", projectTenderingId="
            + this.projectTenderingId
            + ", round="
            + this.round
            + ", bidGrossAmount="
            + this.bidGrossAmount
            + ", remark="
            + this.remark
            + ", offerTime="
            + this.offerTime
            + ", source="
            + this.source
            + ", contrastBidAmount="
            + this.contrastBidAmount
            + ", bidDeadline="
            + this.bidDeadline
            + ", bidOpeningTime="
            + this.bidOpeningTime
            + ", isHold="
            + this.isHold
            + ", iPAddress="
            + this.iPAddress
            + ", DepositUrl="
            + this.DepositUrl
            + ", DepositName="
            + this.DepositName
            + ", subjectProjectVOList="
            + this.subjectProjectVOList
            + ")";
      }
   }
}
