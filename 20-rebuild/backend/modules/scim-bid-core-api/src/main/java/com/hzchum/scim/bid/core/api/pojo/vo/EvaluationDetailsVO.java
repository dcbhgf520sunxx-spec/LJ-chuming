package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;

public class EvaluationDetailsVO {
   private Long id;
   private Long projectTenderingId;
   private String supplierName;
   private String iPAddress;
   private Integer round;
   private BigDecimal bidAmount;
   private String remark;
   private Date OfferTime;
   private String contactPerson;
   private String phone;
   private Integer extremeValue;
   private BigDecimal contrastBidAmount;
   private Integer source;
   private String depositUrl;
   private String depositName;

   public static EvaluationDetailsVO.EvaluationDetailsVOBuilder builder() {
      return new EvaluationDetailsVO.EvaluationDetailsVOBuilder();
   }

   public EvaluationDetailsVO() {
   }

   public EvaluationDetailsVO(
      final Long id,
      final Long projectTenderingId,
      final String supplierName,
      final String iPAddress,
      final Integer round,
      final BigDecimal bidAmount,
      final String remark,
      final Date OfferTime,
      final String contactPerson,
      final String phone,
      final Integer extremeValue,
      final BigDecimal contrastBidAmount,
      final Integer source,
      final String depositUrl,
      final String depositName
   ) {
      this.id = id;
      this.projectTenderingId = projectTenderingId;
      this.supplierName = supplierName;
      this.iPAddress = iPAddress;
      this.round = round;
      this.bidAmount = bidAmount;
      this.remark = remark;
      this.OfferTime = OfferTime;
      this.contactPerson = contactPerson;
      this.phone = phone;
      this.extremeValue = extremeValue;
      this.contrastBidAmount = contrastBidAmount;
      this.source = source;
      this.depositUrl = depositUrl;
      this.depositName = depositName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectTenderingId() {
      return this.projectTenderingId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getIPAddress() {
      return this.iPAddress;
   }

   public Integer getRound() {
      return this.round;
   }

   public BigDecimal getBidAmount() {
      return this.bidAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Date getOfferTime() {
      return this.OfferTime;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getExtremeValue() {
      return this.extremeValue;
   }

   public BigDecimal getContrastBidAmount() {
      return this.contrastBidAmount;
   }

   public Integer getSource() {
      return this.source;
   }

   public String getDepositUrl() {
      return this.depositUrl;
   }

   public String getDepositName() {
      return this.depositName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectTenderingId(final Long projectTenderingId) {
      this.projectTenderingId = projectTenderingId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setIPAddress(final String iPAddress) {
      this.iPAddress = iPAddress;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   public void setBidAmount(final BigDecimal bidAmount) {
      this.bidAmount = bidAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setOfferTime(final Date OfferTime) {
      this.OfferTime = OfferTime;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setExtremeValue(final Integer extremeValue) {
      this.extremeValue = extremeValue;
   }

   public void setContrastBidAmount(final BigDecimal contrastBidAmount) {
      this.contrastBidAmount = contrastBidAmount;
   }

   public void setSource(final Integer source) {
      this.source = source;
   }

   public void setDepositUrl(final String depositUrl) {
      this.depositUrl = depositUrl;
   }

   public void setDepositName(final String depositName) {
      this.depositName = depositName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EvaluationDetailsVO)) {
         return false;
      }

      EvaluationDetailsVO other = (EvaluationDetailsVO)o;
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
               Object this$extremeValue = this.getExtremeValue();
               Object other$extremeValue = other.getExtremeValue();
               if (this$extremeValue == null ? other$extremeValue == null : this$extremeValue.equals(other$extremeValue)) {
                  Object this$source = this.getSource();
                  Object other$source = other.getSource();
                  if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$iPAddress = this.getIPAddress();
                        Object other$iPAddress = other.getIPAddress();
                        if (this$iPAddress == null ? other$iPAddress == null : this$iPAddress.equals(other$iPAddress)) {
                           Object this$bidAmount = this.getBidAmount();
                           Object other$bidAmount = other.getBidAmount();
                           if (this$bidAmount == null ? other$bidAmount == null : this$bidAmount.equals(other$bidAmount)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$OfferTime = this.getOfferTime();
                                 Object other$OfferTime = other.getOfferTime();
                                 if (this$OfferTime == null ? other$OfferTime == null : this$OfferTime.equals(other$OfferTime)) {
                                    Object this$contactPerson = this.getContactPerson();
                                    Object other$contactPerson = other.getContactPerson();
                                    if (this$contactPerson == null ? other$contactPerson == null : this$contactPerson.equals(other$contactPerson)) {
                                       Object this$phone = this.getPhone();
                                       Object other$phone = other.getPhone();
                                       if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                          Object this$contrastBidAmount = this.getContrastBidAmount();
                                          Object other$contrastBidAmount = other.getContrastBidAmount();
                                          if (this$contrastBidAmount == null
                                             ? other$contrastBidAmount == null
                                             : this$contrastBidAmount.equals(other$contrastBidAmount)) {
                                             Object this$depositUrl = this.getDepositUrl();
                                             Object other$depositUrl = other.getDepositUrl();
                                             if (this$depositUrl == null ? other$depositUrl == null : this$depositUrl.equals(other$depositUrl)) {
                                                Object this$depositName = this.getDepositName();
                                                Object other$depositName = other.getDepositName();
                                                return this$depositName == null ? other$depositName == null : this$depositName.equals(other$depositName);
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
      return other instanceof EvaluationDetailsVO;
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
      Object $extremeValue = this.getExtremeValue();
      result = result * 59 + ($extremeValue == null ? 43 : $extremeValue.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $iPAddress = this.getIPAddress();
      result = result * 59 + ($iPAddress == null ? 43 : $iPAddress.hashCode());
      Object $bidAmount = this.getBidAmount();
      result = result * 59 + ($bidAmount == null ? 43 : $bidAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $OfferTime = this.getOfferTime();
      result = result * 59 + ($OfferTime == null ? 43 : $OfferTime.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $contrastBidAmount = this.getContrastBidAmount();
      result = result * 59 + ($contrastBidAmount == null ? 43 : $contrastBidAmount.hashCode());
      Object $depositUrl = this.getDepositUrl();
      result = result * 59 + ($depositUrl == null ? 43 : $depositUrl.hashCode());
      Object $depositName = this.getDepositName();
      return result * 59 + ($depositName == null ? 43 : $depositName.hashCode());
   }

   @Override
   public String toString() {
      return "EvaluationDetailsVO(id="
         + this.getId()
         + ", projectTenderingId="
         + this.getProjectTenderingId()
         + ", supplierName="
         + this.getSupplierName()
         + ", iPAddress="
         + this.getIPAddress()
         + ", round="
         + this.getRound()
         + ", bidAmount="
         + this.getBidAmount()
         + ", remark="
         + this.getRemark()
         + ", OfferTime="
         + this.getOfferTime()
         + ", contactPerson="
         + this.getContactPerson()
         + ", phone="
         + this.getPhone()
         + ", extremeValue="
         + this.getExtremeValue()
         + ", contrastBidAmount="
         + this.getContrastBidAmount()
         + ", source="
         + this.getSource()
         + ", depositUrl="
         + this.getDepositUrl()
         + ", depositName="
         + this.getDepositName()
         + ")";
   }

   public static class EvaluationDetailsVOBuilder {
      private Long id;
      private Long projectTenderingId;
      private String supplierName;
      private String iPAddress;
      private Integer round;
      private BigDecimal bidAmount;
      private String remark;
      private Date OfferTime;
      private String contactPerson;
      private String phone;
      private Integer extremeValue;
      private BigDecimal contrastBidAmount;
      private Integer source;
      private String depositUrl;
      private String depositName;

      EvaluationDetailsVOBuilder() {
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder projectTenderingId(final Long projectTenderingId) {
         this.projectTenderingId = projectTenderingId;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder iPAddress(final String iPAddress) {
         this.iPAddress = iPAddress;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder bidAmount(final BigDecimal bidAmount) {
         this.bidAmount = bidAmount;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder OfferTime(final Date OfferTime) {
         this.OfferTime = OfferTime;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder contactPerson(final String contactPerson) {
         this.contactPerson = contactPerson;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder extremeValue(final Integer extremeValue) {
         this.extremeValue = extremeValue;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder contrastBidAmount(final BigDecimal contrastBidAmount) {
         this.contrastBidAmount = contrastBidAmount;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder depositUrl(final String depositUrl) {
         this.depositUrl = depositUrl;
         return this;
      }

      public EvaluationDetailsVO.EvaluationDetailsVOBuilder depositName(final String depositName) {
         this.depositName = depositName;
         return this;
      }

      public EvaluationDetailsVO build() {
         return new EvaluationDetailsVO(
            this.id,
            this.projectTenderingId,
            this.supplierName,
            this.iPAddress,
            this.round,
            this.bidAmount,
            this.remark,
            this.OfferTime,
            this.contactPerson,
            this.phone,
            this.extremeValue,
            this.contrastBidAmount,
            this.source,
            this.depositUrl,
            this.depositName
         );
      }

      @Override
      public String toString() {
         return "EvaluationDetailsVO.EvaluationDetailsVOBuilder(id="
            + this.id
            + ", projectTenderingId="
            + this.projectTenderingId
            + ", supplierName="
            + this.supplierName
            + ", iPAddress="
            + this.iPAddress
            + ", round="
            + this.round
            + ", bidAmount="
            + this.bidAmount
            + ", remark="
            + this.remark
            + ", OfferTime="
            + this.OfferTime
            + ", contactPerson="
            + this.contactPerson
            + ", phone="
            + this.phone
            + ", extremeValue="
            + this.extremeValue
            + ", contrastBidAmount="
            + this.contrastBidAmount
            + ", source="
            + this.source
            + ", depositUrl="
            + this.depositUrl
            + ", depositName="
            + this.depositName
            + ")";
      }
   }
}
