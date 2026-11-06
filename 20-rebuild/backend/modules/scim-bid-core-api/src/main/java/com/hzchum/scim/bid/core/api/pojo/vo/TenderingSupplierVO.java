package com.hzchum.scim.bid.core.api.pojo.vo;

import java.util.Date;
import java.util.List;

public class TenderingSupplierVO {
   private Long id;
   private Long supplierId;
   private String supplierName;
   private String shortName;
   private String phone;
   private Integer bidStatus;
   private Date biddingTime;
   private Integer isFollow;
   private Long projectTenderingId;
   private Integer source;
   private String DepositUrl;
   private String DepositName;
   private List<OfferRoundsVO> offerRoundsVOS;

   public Long getId() {
      return this.id;
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

   public String getPhone() {
      return this.phone;
   }

   public Integer getBidStatus() {
      return this.bidStatus;
   }

   public Date getBiddingTime() {
      return this.biddingTime;
   }

   public Integer getIsFollow() {
      return this.isFollow;
   }

   public Long getProjectTenderingId() {
      return this.projectTenderingId;
   }

   public Integer getSource() {
      return this.source;
   }

   public String getDepositUrl() {
      return this.DepositUrl;
   }

   public String getDepositName() {
      return this.DepositName;
   }

   public List<OfferRoundsVO> getOfferRoundsVOS() {
      return this.offerRoundsVOS;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setBidStatus(final Integer bidStatus) {
      this.bidStatus = bidStatus;
   }

   public void setBiddingTime(final Date biddingTime) {
      this.biddingTime = biddingTime;
   }

   public void setIsFollow(final Integer isFollow) {
      this.isFollow = isFollow;
   }

   public void setProjectTenderingId(final Long projectTenderingId) {
      this.projectTenderingId = projectTenderingId;
   }

   public void setSource(final Integer source) {
      this.source = source;
   }

   public void setDepositUrl(final String DepositUrl) {
      this.DepositUrl = DepositUrl;
   }

   public void setDepositName(final String DepositName) {
      this.DepositName = DepositName;
   }

   public void setOfferRoundsVOS(final List<OfferRoundsVO> offerRoundsVOS) {
      this.offerRoundsVOS = offerRoundsVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TenderingSupplierVO)) {
         return false;
      }

      TenderingSupplierVO other = (TenderingSupplierVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$bidStatus = this.getBidStatus();
            Object other$bidStatus = other.getBidStatus();
            if (this$bidStatus == null ? other$bidStatus == null : this$bidStatus.equals(other$bidStatus)) {
               Object this$isFollow = this.getIsFollow();
               Object other$isFollow = other.getIsFollow();
               if (this$isFollow == null ? other$isFollow == null : this$isFollow.equals(other$isFollow)) {
                  Object this$projectTenderingId = this.getProjectTenderingId();
                  Object other$projectTenderingId = other.getProjectTenderingId();
                  if (this$projectTenderingId == null ? other$projectTenderingId == null : this$projectTenderingId.equals(other$projectTenderingId)) {
                     Object this$source = this.getSource();
                     Object other$source = other.getSource();
                     if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$phone = this.getPhone();
                              Object other$phone = other.getPhone();
                              if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                 Object this$biddingTime = this.getBiddingTime();
                                 Object other$biddingTime = other.getBiddingTime();
                                 if (this$biddingTime == null ? other$biddingTime == null : this$biddingTime.equals(other$biddingTime)) {
                                    Object this$DepositUrl = this.getDepositUrl();
                                    Object other$DepositUrl = other.getDepositUrl();
                                    if (this$DepositUrl == null ? other$DepositUrl == null : this$DepositUrl.equals(other$DepositUrl)) {
                                       Object this$DepositName = this.getDepositName();
                                       Object other$DepositName = other.getDepositName();
                                       if (this$DepositName == null ? other$DepositName == null : this$DepositName.equals(other$DepositName)) {
                                          Object this$offerRoundsVOS = this.getOfferRoundsVOS();
                                          Object other$offerRoundsVOS = other.getOfferRoundsVOS();
                                          return this$offerRoundsVOS == null ? other$offerRoundsVOS == null : this$offerRoundsVOS.equals(other$offerRoundsVOS);
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
      return other instanceof TenderingSupplierVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $bidStatus = this.getBidStatus();
      result = result * 59 + ($bidStatus == null ? 43 : $bidStatus.hashCode());
      Object $isFollow = this.getIsFollow();
      result = result * 59 + ($isFollow == null ? 43 : $isFollow.hashCode());
      Object $projectTenderingId = this.getProjectTenderingId();
      result = result * 59 + ($projectTenderingId == null ? 43 : $projectTenderingId.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $biddingTime = this.getBiddingTime();
      result = result * 59 + ($biddingTime == null ? 43 : $biddingTime.hashCode());
      Object $DepositUrl = this.getDepositUrl();
      result = result * 59 + ($DepositUrl == null ? 43 : $DepositUrl.hashCode());
      Object $DepositName = this.getDepositName();
      result = result * 59 + ($DepositName == null ? 43 : $DepositName.hashCode());
      Object $offerRoundsVOS = this.getOfferRoundsVOS();
      return result * 59 + ($offerRoundsVOS == null ? 43 : $offerRoundsVOS.hashCode());
   }

   @Override
   public String toString() {
      return "TenderingSupplierVO(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", shortName="
         + this.getShortName()
         + ", phone="
         + this.getPhone()
         + ", bidStatus="
         + this.getBidStatus()
         + ", biddingTime="
         + this.getBiddingTime()
         + ", isFollow="
         + this.getIsFollow()
         + ", projectTenderingId="
         + this.getProjectTenderingId()
         + ", source="
         + this.getSource()
         + ", DepositUrl="
         + this.getDepositUrl()
         + ", DepositName="
         + this.getDepositName()
         + ", offerRoundsVOS="
         + this.getOfferRoundsVOS()
         + ")";
   }
}
