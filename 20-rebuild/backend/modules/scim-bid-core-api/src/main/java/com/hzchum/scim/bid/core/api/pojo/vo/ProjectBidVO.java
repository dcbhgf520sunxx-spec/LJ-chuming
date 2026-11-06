package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProjectBidVO {
   private Long id;
   private String name;
   private Integer projectType;
   private String projectTypeName;
   private String companyName;
   private String contractNo;
   private Integer biddingType;
   private Integer status;
   private Integer isHold;
   private Integer projectProgress;
   private Integer isCashDeposit;
   private BigDecimal cashDeposit;
   private String bankAccountName;
   private String bankAccount;
   private String depositBank;
   private String contactPerson;
   private String phone;
   private String deliveryAddress;
   private Date deliveryTime;
   private String remark;
   private Integer deliveryType;
   private Integer invoiceType;
   private Double taxRate;
   private Date releaseDate;
   private Date bidDeadline;
   private Date bidOpeningTime;
   private Integer round;
   private Date createTime;
   private Date updateTime;
   private List<OfferRoundsVO> offerRoundsVOS;
   private List<SubjectProjectVO> subjectProjectVOS;
   private TenderNoticeVO tenderNoticeVO;
   private List<SubjectProjectVO> supplierOfferDetails;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public String getProjectTypeName() {
      return this.projectTypeName;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public Integer getBiddingType() {
      return this.biddingType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getIsHold() {
      return this.isHold;
   }

   public Integer getProjectProgress() {
      return this.projectProgress;
   }

   public Integer getIsCashDeposit() {
      return this.isCashDeposit;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public String getBankAccountName() {
      return this.bankAccountName;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getDeliveryAddress() {
      return this.deliveryAddress;
   }

   public Date getDeliveryTime() {
      return this.deliveryTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getDeliveryType() {
      return this.deliveryType;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Double getTaxRate() {
      return this.taxRate;
   }

   public Date getReleaseDate() {
      return this.releaseDate;
   }

   public Date getBidDeadline() {
      return this.bidDeadline;
   }

   public Date getBidOpeningTime() {
      return this.bidOpeningTime;
   }

   public Integer getRound() {
      return this.round;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public List<OfferRoundsVO> getOfferRoundsVOS() {
      return this.offerRoundsVOS;
   }

   public List<SubjectProjectVO> getSubjectProjectVOS() {
      return this.subjectProjectVOS;
   }

   public TenderNoticeVO getTenderNoticeVO() {
      return this.tenderNoticeVO;
   }

   public List<SubjectProjectVO> getSupplierOfferDetails() {
      return this.supplierOfferDetails;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProjectTypeName(final String projectTypeName) {
      this.projectTypeName = projectTypeName;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setContractNo(final String contractNo) {
      this.contractNo = contractNo;
   }

   public void setBiddingType(final Integer biddingType) {
      this.biddingType = biddingType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setIsHold(final Integer isHold) {
      this.isHold = isHold;
   }

   public void setProjectProgress(final Integer projectProgress) {
      this.projectProgress = projectProgress;
   }

   public void setIsCashDeposit(final Integer isCashDeposit) {
      this.isCashDeposit = isCashDeposit;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setBankAccountName(final String bankAccountName) {
      this.bankAccountName = bankAccountName;
   }

   public void setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
   }

   public void setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setDeliveryAddress(final String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   public void setDeliveryTime(final Date deliveryTime) {
      this.deliveryTime = deliveryTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDeliveryType(final Integer deliveryType) {
      this.deliveryType = deliveryType;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final Double taxRate) {
      this.taxRate = taxRate;
   }

   public void setReleaseDate(final Date releaseDate) {
      this.releaseDate = releaseDate;
   }

   public void setBidDeadline(final Date bidDeadline) {
      this.bidDeadline = bidDeadline;
   }

   public void setBidOpeningTime(final Date bidOpeningTime) {
      this.bidOpeningTime = bidOpeningTime;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setOfferRoundsVOS(final List<OfferRoundsVO> offerRoundsVOS) {
      this.offerRoundsVOS = offerRoundsVOS;
   }

   public void setSubjectProjectVOS(final List<SubjectProjectVO> subjectProjectVOS) {
      this.subjectProjectVOS = subjectProjectVOS;
   }

   public void setTenderNoticeVO(final TenderNoticeVO tenderNoticeVO) {
      this.tenderNoticeVO = tenderNoticeVO;
   }

   public void setSupplierOfferDetails(final List<SubjectProjectVO> supplierOfferDetails) {
      this.supplierOfferDetails = supplierOfferDetails;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBidVO)) {
         return false;
      }

      ProjectBidVO other = (ProjectBidVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$biddingType = this.getBiddingType();
            Object other$biddingType = other.getBiddingType();
            if (this$biddingType == null ? other$biddingType == null : this$biddingType.equals(other$biddingType)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$isHold = this.getIsHold();
                  Object other$isHold = other.getIsHold();
                  if (this$isHold == null ? other$isHold == null : this$isHold.equals(other$isHold)) {
                     Object this$projectProgress = this.getProjectProgress();
                     Object other$projectProgress = other.getProjectProgress();
                     if (this$projectProgress == null ? other$projectProgress == null : this$projectProgress.equals(other$projectProgress)) {
                        Object this$isCashDeposit = this.getIsCashDeposit();
                        Object other$isCashDeposit = other.getIsCashDeposit();
                        if (this$isCashDeposit == null ? other$isCashDeposit == null : this$isCashDeposit.equals(other$isCashDeposit)) {
                           Object this$deliveryType = this.getDeliveryType();
                           Object other$deliveryType = other.getDeliveryType();
                           if (this$deliveryType == null ? other$deliveryType == null : this$deliveryType.equals(other$deliveryType)) {
                              Object this$invoiceType = this.getInvoiceType();
                              Object other$invoiceType = other.getInvoiceType();
                              if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                 Object this$taxRate = this.getTaxRate();
                                 Object other$taxRate = other.getTaxRate();
                                 if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                    Object this$round = this.getRound();
                                    Object other$round = other.getRound();
                                    if (this$round == null ? other$round == null : this$round.equals(other$round)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$projectTypeName = this.getProjectTypeName();
                                          Object other$projectTypeName = other.getProjectTypeName();
                                          if (this$projectTypeName == null ? other$projectTypeName == null : this$projectTypeName.equals(other$projectTypeName)
                                             )
                                           {
                                             Object this$companyName = this.getCompanyName();
                                             Object other$companyName = other.getCompanyName();
                                             if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                                                Object this$contractNo = this.getContractNo();
                                                Object other$contractNo = other.getContractNo();
                                                if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                                                   Object this$cashDeposit = this.getCashDeposit();
                                                   Object other$cashDeposit = other.getCashDeposit();
                                                   if (this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit)) {
                                                      Object this$bankAccountName = this.getBankAccountName();
                                                      Object other$bankAccountName = other.getBankAccountName();
                                                      if (this$bankAccountName == null
                                                         ? other$bankAccountName == null
                                                         : this$bankAccountName.equals(other$bankAccountName)) {
                                                         Object this$bankAccount = this.getBankAccount();
                                                         Object other$bankAccount = other.getBankAccount();
                                                         if (this$bankAccount == null ? other$bankAccount == null : this$bankAccount.equals(other$bankAccount)) {
                                                            Object this$depositBank = this.getDepositBank();
                                                            Object other$depositBank = other.getDepositBank();
                                                            if (this$depositBank == null
                                                               ? other$depositBank == null
                                                               : this$depositBank.equals(other$depositBank)) {
                                                               Object this$contactPerson = this.getContactPerson();
                                                               Object other$contactPerson = other.getContactPerson();
                                                               if (this$contactPerson == null
                                                                  ? other$contactPerson == null
                                                                  : this$contactPerson.equals(other$contactPerson)) {
                                                                  Object this$phone = this.getPhone();
                                                                  Object other$phone = other.getPhone();
                                                                  if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                                     Object this$deliveryAddress = this.getDeliveryAddress();
                                                                     Object other$deliveryAddress = other.getDeliveryAddress();
                                                                     if (this$deliveryAddress == null
                                                                        ? other$deliveryAddress == null
                                                                        : this$deliveryAddress.equals(other$deliveryAddress)) {
                                                                        Object this$deliveryTime = this.getDeliveryTime();
                                                                        Object other$deliveryTime = other.getDeliveryTime();
                                                                        if (this$deliveryTime == null
                                                                           ? other$deliveryTime == null
                                                                           : this$deliveryTime.equals(other$deliveryTime)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$releaseDate = this.getReleaseDate();
                                                                              Object other$releaseDate = other.getReleaseDate();
                                                                              if (this$releaseDate == null
                                                                                 ? other$releaseDate == null
                                                                                 : this$releaseDate.equals(other$releaseDate)) {
                                                                                 Object this$bidDeadline = this.getBidDeadline();
                                                                                 Object other$bidDeadline = other.getBidDeadline();
                                                                                 if (this$bidDeadline == null
                                                                                    ? other$bidDeadline == null
                                                                                    : this$bidDeadline.equals(other$bidDeadline)) {
                                                                                    Object this$bidOpeningTime = this.getBidOpeningTime();
                                                                                    Object other$bidOpeningTime = other.getBidOpeningTime();
                                                                                    if (this$bidOpeningTime == null
                                                                                       ? other$bidOpeningTime == null
                                                                                       : this$bidOpeningTime.equals(other$bidOpeningTime)) {
                                                                                       Object this$createTime = this.getCreateTime();
                                                                                       Object other$createTime = other.getCreateTime();
                                                                                       if (this$createTime == null
                                                                                          ? other$createTime == null
                                                                                          : this$createTime.equals(other$createTime)) {
                                                                                          Object this$updateTime = this.getUpdateTime();
                                                                                          Object other$updateTime = other.getUpdateTime();
                                                                                          if (this$updateTime == null
                                                                                             ? other$updateTime == null
                                                                                             : this$updateTime.equals(other$updateTime)) {
                                                                                             Object this$offerRoundsVOS = this.getOfferRoundsVOS();
                                                                                             Object other$offerRoundsVOS = other.getOfferRoundsVOS();
                                                                                             if (this$offerRoundsVOS == null
                                                                                                ? other$offerRoundsVOS == null
                                                                                                : this$offerRoundsVOS.equals(other$offerRoundsVOS)) {
                                                                                                Object this$subjectProjectVOS = this.getSubjectProjectVOS();
                                                                                                Object other$subjectProjectVOS = other.getSubjectProjectVOS();
                                                                                                if (this$subjectProjectVOS == null
                                                                                                   ? other$subjectProjectVOS == null
                                                                                                   : this$subjectProjectVOS.equals(other$subjectProjectVOS)) {
                                                                                                   Object this$tenderNoticeVO = this.getTenderNoticeVO();
                                                                                                   Object other$tenderNoticeVO = other.getTenderNoticeVO();
                                                                                                   if (this$tenderNoticeVO == null
                                                                                                      ? other$tenderNoticeVO == null
                                                                                                      : this$tenderNoticeVO.equals(other$tenderNoticeVO)) {
                                                                                                      Object this$supplierOfferDetails = this.getSupplierOfferDetails();
                                                                                                      Object other$supplierOfferDetails = other.getSupplierOfferDetails();
                                                                                                      return this$supplierOfferDetails == null
                                                                                                         ? other$supplierOfferDetails == null
                                                                                                         : this$supplierOfferDetails.equals(
                                                                                                            other$supplierOfferDetails
                                                                                                         );
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
      return other instanceof ProjectBidVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $biddingType = this.getBiddingType();
      result = result * 59 + ($biddingType == null ? 43 : $biddingType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $isHold = this.getIsHold();
      result = result * 59 + ($isHold == null ? 43 : $isHold.hashCode());
      Object $projectProgress = this.getProjectProgress();
      result = result * 59 + ($projectProgress == null ? 43 : $projectProgress.hashCode());
      Object $isCashDeposit = this.getIsCashDeposit();
      result = result * 59 + ($isCashDeposit == null ? 43 : $isCashDeposit.hashCode());
      Object $deliveryType = this.getDeliveryType();
      result = result * 59 + ($deliveryType == null ? 43 : $deliveryType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $projectTypeName = this.getProjectTypeName();
      result = result * 59 + ($projectTypeName == null ? 43 : $projectTypeName.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $bankAccountName = this.getBankAccountName();
      result = result * 59 + ($bankAccountName == null ? 43 : $bankAccountName.hashCode());
      Object $bankAccount = this.getBankAccount();
      result = result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $deliveryAddress = this.getDeliveryAddress();
      result = result * 59 + ($deliveryAddress == null ? 43 : $deliveryAddress.hashCode());
      Object $deliveryTime = this.getDeliveryTime();
      result = result * 59 + ($deliveryTime == null ? 43 : $deliveryTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $releaseDate = this.getReleaseDate();
      result = result * 59 + ($releaseDate == null ? 43 : $releaseDate.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      result = result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $offerRoundsVOS = this.getOfferRoundsVOS();
      result = result * 59 + ($offerRoundsVOS == null ? 43 : $offerRoundsVOS.hashCode());
      Object $subjectProjectVOS = this.getSubjectProjectVOS();
      result = result * 59 + ($subjectProjectVOS == null ? 43 : $subjectProjectVOS.hashCode());
      Object $tenderNoticeVO = this.getTenderNoticeVO();
      result = result * 59 + ($tenderNoticeVO == null ? 43 : $tenderNoticeVO.hashCode());
      Object $supplierOfferDetails = this.getSupplierOfferDetails();
      return result * 59 + ($supplierOfferDetails == null ? 43 : $supplierOfferDetails.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBidVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", projectTypeName="
         + this.getProjectTypeName()
         + ", companyName="
         + this.getCompanyName()
         + ", contractNo="
         + this.getContractNo()
         + ", biddingType="
         + this.getBiddingType()
         + ", status="
         + this.getStatus()
         + ", isHold="
         + this.getIsHold()
         + ", projectProgress="
         + this.getProjectProgress()
         + ", isCashDeposit="
         + this.getIsCashDeposit()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", bankAccountName="
         + this.getBankAccountName()
         + ", bankAccount="
         + this.getBankAccount()
         + ", depositBank="
         + this.getDepositBank()
         + ", contactPerson="
         + this.getContactPerson()
         + ", phone="
         + this.getPhone()
         + ", deliveryAddress="
         + this.getDeliveryAddress()
         + ", deliveryTime="
         + this.getDeliveryTime()
         + ", remark="
         + this.getRemark()
         + ", deliveryType="
         + this.getDeliveryType()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", releaseDate="
         + this.getReleaseDate()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ", round="
         + this.getRound()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", offerRoundsVOS="
         + this.getOfferRoundsVOS()
         + ", subjectProjectVOS="
         + this.getSubjectProjectVOS()
         + ", tenderNoticeVO="
         + this.getTenderNoticeVO()
         + ", supplierOfferDetails="
         + this.getSupplierOfferDetails()
         + ")";
   }
}
