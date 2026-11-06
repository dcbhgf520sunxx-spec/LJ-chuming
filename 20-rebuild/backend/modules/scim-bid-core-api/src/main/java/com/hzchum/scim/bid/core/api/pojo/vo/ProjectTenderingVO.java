package com.hzchum.scim.bid.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProjectTenderingVO {
   private Long id;
   private Long roundId;
   private Long userId;
   private String userName;
   private String name;
   private Integer projectType;
   private String projectTypeName;
   private String contractNo;
   private Integer biddingType;
   private BigDecimal cashDeposit;
   private Integer isCashDeposit;
   private String bankAccountName;
   private String bankAccount;
   private String depositBank;
   private Long verifierId;
   private String verifierName;
   private Date verifierTime;
   private Date releaseDate;
   private Integer status;
   private Integer projectProgress;
   private Integer isOpen;
   private String contactPerson;
   private String phone;
   private Long modifierId;
   private String deliveryAddress;
   private Date deliveryTime;
   private Integer deliveryType;
   private Integer invoiceType;
   private Double taxRate;
   private Date bidDeadline;
   private Integer tickSizeNum;
   private Integer invitingNum;
   private Integer respondNum;
   private Date bidOpeningTime;
   private Integer round;
   @JsonIgnore
   private String companyName;
   private String remark;
   private List<TenderingSupplierVO> supplierVOList;
   private List<BiddingRoundsVO> biddingRoundsVOS;
   private List<SubjectProjectVO> subjectProjectVOS;
   private TenderNoticeVO tenderNoticeVO;
   private List<SupplierAmountVO> supplierAmountVOS;
   private Date createTime;
   private Date updateTime;

   public static ProjectTenderingVO.ProjectTenderingVOBuilder builder() {
      return new ProjectTenderingVO.ProjectTenderingVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getRoundId() {
      return this.roundId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
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

   public String getContractNo() {
      return this.contractNo;
   }

   public Integer getBiddingType() {
      return this.biddingType;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Integer getIsCashDeposit() {
      return this.isCashDeposit;
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

   public Long getVerifierId() {
      return this.verifierId;
   }

   public String getVerifierName() {
      return this.verifierName;
   }

   public Date getVerifierTime() {
      return this.verifierTime;
   }

   public Date getReleaseDate() {
      return this.releaseDate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getProjectProgress() {
      return this.projectProgress;
   }

   public Integer getIsOpen() {
      return this.isOpen;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getPhone() {
      return this.phone;
   }

   public Long getModifierId() {
      return this.modifierId;
   }

   public String getDeliveryAddress() {
      return this.deliveryAddress;
   }

   public Date getDeliveryTime() {
      return this.deliveryTime;
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

   public Date getBidDeadline() {
      return this.bidDeadline;
   }

   public Integer getTickSizeNum() {
      return this.tickSizeNum;
   }

   public Integer getInvitingNum() {
      return this.invitingNum;
   }

   public Integer getRespondNum() {
      return this.respondNum;
   }

   public Date getBidOpeningTime() {
      return this.bidOpeningTime;
   }

   public Integer getRound() {
      return this.round;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<TenderingSupplierVO> getSupplierVOList() {
      return this.supplierVOList;
   }

   public List<BiddingRoundsVO> getBiddingRoundsVOS() {
      return this.biddingRoundsVOS;
   }

   public List<SubjectProjectVO> getSubjectProjectVOS() {
      return this.subjectProjectVOS;
   }

   public TenderNoticeVO getTenderNoticeVO() {
      return this.tenderNoticeVO;
   }

   public List<SupplierAmountVO> getSupplierAmountVOS() {
      return this.supplierAmountVOS;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRoundId(final Long roundId) {
      this.roundId = roundId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
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

   public void setContractNo(final String contractNo) {
      this.contractNo = contractNo;
   }

   public void setBiddingType(final Integer biddingType) {
      this.biddingType = biddingType;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setIsCashDeposit(final Integer isCashDeposit) {
      this.isCashDeposit = isCashDeposit;
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

   public void setVerifierId(final Long verifierId) {
      this.verifierId = verifierId;
   }

   public void setVerifierName(final String verifierName) {
      this.verifierName = verifierName;
   }

   public void setVerifierTime(final Date verifierTime) {
      this.verifierTime = verifierTime;
   }

   public void setReleaseDate(final Date releaseDate) {
      this.releaseDate = releaseDate;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setProjectProgress(final Integer projectProgress) {
      this.projectProgress = projectProgress;
   }

   public void setIsOpen(final Integer isOpen) {
      this.isOpen = isOpen;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setModifierId(final Long modifierId) {
      this.modifierId = modifierId;
   }

   public void setDeliveryAddress(final String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   public void setDeliveryTime(final Date deliveryTime) {
      this.deliveryTime = deliveryTime;
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

   public void setBidDeadline(final Date bidDeadline) {
      this.bidDeadline = bidDeadline;
   }

   public void setTickSizeNum(final Integer tickSizeNum) {
      this.tickSizeNum = tickSizeNum;
   }

   public void setInvitingNum(final Integer invitingNum) {
      this.invitingNum = invitingNum;
   }

   public void setRespondNum(final Integer respondNum) {
      this.respondNum = respondNum;
   }

   public void setBidOpeningTime(final Date bidOpeningTime) {
      this.bidOpeningTime = bidOpeningTime;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   @JsonIgnore
   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSupplierVOList(final List<TenderingSupplierVO> supplierVOList) {
      this.supplierVOList = supplierVOList;
   }

   public void setBiddingRoundsVOS(final List<BiddingRoundsVO> biddingRoundsVOS) {
      this.biddingRoundsVOS = biddingRoundsVOS;
   }

   public void setSubjectProjectVOS(final List<SubjectProjectVO> subjectProjectVOS) {
      this.subjectProjectVOS = subjectProjectVOS;
   }

   public void setTenderNoticeVO(final TenderNoticeVO tenderNoticeVO) {
      this.tenderNoticeVO = tenderNoticeVO;
   }

   public void setSupplierAmountVOS(final List<SupplierAmountVO> supplierAmountVOS) {
      this.supplierAmountVOS = supplierAmountVOS;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectTenderingVO)) {
         return false;
      }

      ProjectTenderingVO other = (ProjectTenderingVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$roundId = this.getRoundId();
         Object other$roundId = other.getRoundId();
         if (this$roundId == null ? other$roundId == null : this$roundId.equals(other$roundId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$biddingType = this.getBiddingType();
                  Object other$biddingType = other.getBiddingType();
                  if (this$biddingType == null ? other$biddingType == null : this$biddingType.equals(other$biddingType)) {
                     Object this$isCashDeposit = this.getIsCashDeposit();
                     Object other$isCashDeposit = other.getIsCashDeposit();
                     if (this$isCashDeposit == null ? other$isCashDeposit == null : this$isCashDeposit.equals(other$isCashDeposit)) {
                        Object this$verifierId = this.getVerifierId();
                        Object other$verifierId = other.getVerifierId();
                        if (this$verifierId == null ? other$verifierId == null : this$verifierId.equals(other$verifierId)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$projectProgress = this.getProjectProgress();
                              Object other$projectProgress = other.getProjectProgress();
                              if (this$projectProgress == null ? other$projectProgress == null : this$projectProgress.equals(other$projectProgress)) {
                                 Object this$isOpen = this.getIsOpen();
                                 Object other$isOpen = other.getIsOpen();
                                 if (this$isOpen == null ? other$isOpen == null : this$isOpen.equals(other$isOpen)) {
                                    Object this$modifierId = this.getModifierId();
                                    Object other$modifierId = other.getModifierId();
                                    if (this$modifierId == null ? other$modifierId == null : this$modifierId.equals(other$modifierId)) {
                                       Object this$deliveryType = this.getDeliveryType();
                                       Object other$deliveryType = other.getDeliveryType();
                                       if (this$deliveryType == null ? other$deliveryType == null : this$deliveryType.equals(other$deliveryType)) {
                                          Object this$invoiceType = this.getInvoiceType();
                                          Object other$invoiceType = other.getInvoiceType();
                                          if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                             Object this$taxRate = this.getTaxRate();
                                             Object other$taxRate = other.getTaxRate();
                                             if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                Object this$tickSizeNum = this.getTickSizeNum();
                                                Object other$tickSizeNum = other.getTickSizeNum();
                                                if (this$tickSizeNum == null ? other$tickSizeNum == null : this$tickSizeNum.equals(other$tickSizeNum)) {
                                                   Object this$invitingNum = this.getInvitingNum();
                                                   Object other$invitingNum = other.getInvitingNum();
                                                   if (this$invitingNum == null ? other$invitingNum == null : this$invitingNum.equals(other$invitingNum)) {
                                                      Object this$respondNum = this.getRespondNum();
                                                      Object other$respondNum = other.getRespondNum();
                                                      if (this$respondNum == null ? other$respondNum == null : this$respondNum.equals(other$respondNum)) {
                                                         Object this$round = this.getRound();
                                                         Object other$round = other.getRound();
                                                         if (this$round == null ? other$round == null : this$round.equals(other$round)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$name = this.getName();
                                                               Object other$name = other.getName();
                                                               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                  Object this$projectTypeName = this.getProjectTypeName();
                                                                  Object other$projectTypeName = other.getProjectTypeName();
                                                                  if (this$projectTypeName == null
                                                                     ? other$projectTypeName == null
                                                                     : this$projectTypeName.equals(other$projectTypeName)) {
                                                                     Object this$contractNo = this.getContractNo();
                                                                     Object other$contractNo = other.getContractNo();
                                                                     if (this$contractNo == null
                                                                        ? other$contractNo == null
                                                                        : this$contractNo.equals(other$contractNo)) {
                                                                        Object this$cashDeposit = this.getCashDeposit();
                                                                        Object other$cashDeposit = other.getCashDeposit();
                                                                        if (this$cashDeposit == null
                                                                           ? other$cashDeposit == null
                                                                           : this$cashDeposit.equals(other$cashDeposit)) {
                                                                           Object this$bankAccountName = this.getBankAccountName();
                                                                           Object other$bankAccountName = other.getBankAccountName();
                                                                           if (this$bankAccountName == null
                                                                              ? other$bankAccountName == null
                                                                              : this$bankAccountName.equals(other$bankAccountName)) {
                                                                              Object this$bankAccount = this.getBankAccount();
                                                                              Object other$bankAccount = other.getBankAccount();
                                                                              if (this$bankAccount == null
                                                                                 ? other$bankAccount == null
                                                                                 : this$bankAccount.equals(other$bankAccount)) {
                                                                                 Object this$depositBank = this.getDepositBank();
                                                                                 Object other$depositBank = other.getDepositBank();
                                                                                 if (this$depositBank == null
                                                                                    ? other$depositBank == null
                                                                                    : this$depositBank.equals(other$depositBank)) {
                                                                                    Object this$verifierName = this.getVerifierName();
                                                                                    Object other$verifierName = other.getVerifierName();
                                                                                    if (this$verifierName == null
                                                                                       ? other$verifierName == null
                                                                                       : this$verifierName.equals(other$verifierName)) {
                                                                                       Object this$verifierTime = this.getVerifierTime();
                                                                                       Object other$verifierTime = other.getVerifierTime();
                                                                                       if (this$verifierTime == null
                                                                                          ? other$verifierTime == null
                                                                                          : this$verifierTime.equals(other$verifierTime)) {
                                                                                          Object this$releaseDate = this.getReleaseDate();
                                                                                          Object other$releaseDate = other.getReleaseDate();
                                                                                          if (this$releaseDate == null
                                                                                             ? other$releaseDate == null
                                                                                             : this$releaseDate.equals(other$releaseDate)) {
                                                                                             Object this$contactPerson = this.getContactPerson();
                                                                                             Object other$contactPerson = other.getContactPerson();
                                                                                             if (this$contactPerson == null
                                                                                                ? other$contactPerson == null
                                                                                                : this$contactPerson.equals(other$contactPerson)) {
                                                                                                Object this$phone = this.getPhone();
                                                                                                Object other$phone = other.getPhone();
                                                                                                if (this$phone == null
                                                                                                   ? other$phone == null
                                                                                                   : this$phone.equals(other$phone)) {
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
                                                                                                         Object this$bidDeadline = this.getBidDeadline();
                                                                                                         Object other$bidDeadline = other.getBidDeadline();
                                                                                                         if (this$bidDeadline == null
                                                                                                            ? other$bidDeadline == null
                                                                                                            : this$bidDeadline.equals(other$bidDeadline)) {
                                                                                                            Object this$bidOpeningTime = this.getBidOpeningTime();
                                                                                                            Object other$bidOpeningTime = other.getBidOpeningTime();
                                                                                                            if (this$bidOpeningTime == null
                                                                                                               ? other$bidOpeningTime == null
                                                                                                               : this$bidOpeningTime.equals(
                                                                                                                  other$bidOpeningTime
                                                                                                               )) {
                                                                                                               Object this$companyName = this.getCompanyName();
                                                                                                               Object other$companyName = other.getCompanyName();
                                                                                                               if (this$companyName == null
                                                                                                                  ? other$companyName == null
                                                                                                                  : this$companyName.equals(other$companyName)) {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  if (this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark)) {
                                                                                                                     Object this$supplierVOList = this.getSupplierVOList();
                                                                                                                     Object other$supplierVOList = other.getSupplierVOList();
                                                                                                                     if (this$supplierVOList == null
                                                                                                                        ? other$supplierVOList == null
                                                                                                                        : this$supplierVOList.equals(
                                                                                                                           other$supplierVOList
                                                                                                                        )) {
                                                                                                                        Object this$biddingRoundsVOS = this.getBiddingRoundsVOS();
                                                                                                                        Object other$biddingRoundsVOS = other.getBiddingRoundsVOS();
                                                                                                                        if (this$biddingRoundsVOS == null
                                                                                                                           ? other$biddingRoundsVOS == null
                                                                                                                           : this$biddingRoundsVOS.equals(
                                                                                                                              other$biddingRoundsVOS
                                                                                                                           )) {
                                                                                                                           Object this$subjectProjectVOS = this.getSubjectProjectVOS();
                                                                                                                           Object other$subjectProjectVOS = other.getSubjectProjectVOS();
                                                                                                                           if (this$subjectProjectVOS == null
                                                                                                                              ? other$subjectProjectVOS == null
                                                                                                                              : this$subjectProjectVOS.equals(
                                                                                                                                 other$subjectProjectVOS
                                                                                                                              )) {
                                                                                                                              Object this$tenderNoticeVO = this.getTenderNoticeVO();
                                                                                                                              Object other$tenderNoticeVO = other.getTenderNoticeVO();
                                                                                                                              if (this$tenderNoticeVO == null
                                                                                                                                 ? other$tenderNoticeVO == null
                                                                                                                                 : this$tenderNoticeVO.equals(
                                                                                                                                    other$tenderNoticeVO
                                                                                                                                 )) {
                                                                                                                                 Object this$supplierAmountVOS = this.getSupplierAmountVOS();
                                                                                                                                 Object other$supplierAmountVOS = other.getSupplierAmountVOS();
                                                                                                                                 if (this$supplierAmountVOS
                                                                                                                                       == null
                                                                                                                                    ? other$supplierAmountVOS
                                                                                                                                       == null
                                                                                                                                    : this$supplierAmountVOS.equals(
                                                                                                                                       other$supplierAmountVOS
                                                                                                                                    )) {
                                                                                                                                    Object this$createTime = this.getCreateTime();
                                                                                                                                    Object other$createTime = other.getCreateTime();
                                                                                                                                    if (this$createTime == null
                                                                                                                                       ? other$createTime
                                                                                                                                          == null
                                                                                                                                       : this$createTime.equals(
                                                                                                                                          other$createTime
                                                                                                                                       )) {
                                                                                                                                       Object this$updateTime = this.getUpdateTime();
                                                                                                                                       Object other$updateTime = other.getUpdateTime();
                                                                                                                                       return this$updateTime
                                                                                                                                             == null
                                                                                                                                          ? other$updateTime
                                                                                                                                             == null
                                                                                                                                          : this$updateTime.equals(
                                                                                                                                             other$updateTime
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
      return other instanceof ProjectTenderingVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $roundId = this.getRoundId();
      result = result * 59 + ($roundId == null ? 43 : $roundId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $biddingType = this.getBiddingType();
      result = result * 59 + ($biddingType == null ? 43 : $biddingType.hashCode());
      Object $isCashDeposit = this.getIsCashDeposit();
      result = result * 59 + ($isCashDeposit == null ? 43 : $isCashDeposit.hashCode());
      Object $verifierId = this.getVerifierId();
      result = result * 59 + ($verifierId == null ? 43 : $verifierId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectProgress = this.getProjectProgress();
      result = result * 59 + ($projectProgress == null ? 43 : $projectProgress.hashCode());
      Object $isOpen = this.getIsOpen();
      result = result * 59 + ($isOpen == null ? 43 : $isOpen.hashCode());
      Object $modifierId = this.getModifierId();
      result = result * 59 + ($modifierId == null ? 43 : $modifierId.hashCode());
      Object $deliveryType = this.getDeliveryType();
      result = result * 59 + ($deliveryType == null ? 43 : $deliveryType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $tickSizeNum = this.getTickSizeNum();
      result = result * 59 + ($tickSizeNum == null ? 43 : $tickSizeNum.hashCode());
      Object $invitingNum = this.getInvitingNum();
      result = result * 59 + ($invitingNum == null ? 43 : $invitingNum.hashCode());
      Object $respondNum = this.getRespondNum();
      result = result * 59 + ($respondNum == null ? 43 : $respondNum.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $projectTypeName = this.getProjectTypeName();
      result = result * 59 + ($projectTypeName == null ? 43 : $projectTypeName.hashCode());
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
      Object $verifierName = this.getVerifierName();
      result = result * 59 + ($verifierName == null ? 43 : $verifierName.hashCode());
      Object $verifierTime = this.getVerifierTime();
      result = result * 59 + ($verifierTime == null ? 43 : $verifierTime.hashCode());
      Object $releaseDate = this.getReleaseDate();
      result = result * 59 + ($releaseDate == null ? 43 : $releaseDate.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $deliveryAddress = this.getDeliveryAddress();
      result = result * 59 + ($deliveryAddress == null ? 43 : $deliveryAddress.hashCode());
      Object $deliveryTime = this.getDeliveryTime();
      result = result * 59 + ($deliveryTime == null ? 43 : $deliveryTime.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      result = result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $supplierVOList = this.getSupplierVOList();
      result = result * 59 + ($supplierVOList == null ? 43 : $supplierVOList.hashCode());
      Object $biddingRoundsVOS = this.getBiddingRoundsVOS();
      result = result * 59 + ($biddingRoundsVOS == null ? 43 : $biddingRoundsVOS.hashCode());
      Object $subjectProjectVOS = this.getSubjectProjectVOS();
      result = result * 59 + ($subjectProjectVOS == null ? 43 : $subjectProjectVOS.hashCode());
      Object $tenderNoticeVO = this.getTenderNoticeVO();
      result = result * 59 + ($tenderNoticeVO == null ? 43 : $tenderNoticeVO.hashCode());
      Object $supplierAmountVOS = this.getSupplierAmountVOS();
      result = result * 59 + ($supplierAmountVOS == null ? 43 : $supplierAmountVOS.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectTenderingVO(id="
         + this.getId()
         + ", roundId="
         + this.getRoundId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", projectTypeName="
         + this.getProjectTypeName()
         + ", contractNo="
         + this.getContractNo()
         + ", biddingType="
         + this.getBiddingType()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", isCashDeposit="
         + this.getIsCashDeposit()
         + ", bankAccountName="
         + this.getBankAccountName()
         + ", bankAccount="
         + this.getBankAccount()
         + ", depositBank="
         + this.getDepositBank()
         + ", verifierId="
         + this.getVerifierId()
         + ", verifierName="
         + this.getVerifierName()
         + ", verifierTime="
         + this.getVerifierTime()
         + ", releaseDate="
         + this.getReleaseDate()
         + ", status="
         + this.getStatus()
         + ", projectProgress="
         + this.getProjectProgress()
         + ", isOpen="
         + this.getIsOpen()
         + ", contactPerson="
         + this.getContactPerson()
         + ", phone="
         + this.getPhone()
         + ", modifierId="
         + this.getModifierId()
         + ", deliveryAddress="
         + this.getDeliveryAddress()
         + ", deliveryTime="
         + this.getDeliveryTime()
         + ", deliveryType="
         + this.getDeliveryType()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", tickSizeNum="
         + this.getTickSizeNum()
         + ", invitingNum="
         + this.getInvitingNum()
         + ", respondNum="
         + this.getRespondNum()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ", round="
         + this.getRound()
         + ", companyName="
         + this.getCompanyName()
         + ", remark="
         + this.getRemark()
         + ", supplierVOList="
         + this.getSupplierVOList()
         + ", biddingRoundsVOS="
         + this.getBiddingRoundsVOS()
         + ", subjectProjectVOS="
         + this.getSubjectProjectVOS()
         + ", tenderNoticeVO="
         + this.getTenderNoticeVO()
         + ", supplierAmountVOS="
         + this.getSupplierAmountVOS()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }

   public ProjectTenderingVO() {
   }

   public ProjectTenderingVO(
      final Long id,
      final Long roundId,
      final Long userId,
      final String userName,
      final String name,
      final Integer projectType,
      final String projectTypeName,
      final String contractNo,
      final Integer biddingType,
      final BigDecimal cashDeposit,
      final Integer isCashDeposit,
      final String bankAccountName,
      final String bankAccount,
      final String depositBank,
      final Long verifierId,
      final String verifierName,
      final Date verifierTime,
      final Date releaseDate,
      final Integer status,
      final Integer projectProgress,
      final Integer isOpen,
      final String contactPerson,
      final String phone,
      final Long modifierId,
      final String deliveryAddress,
      final Date deliveryTime,
      final Integer deliveryType,
      final Integer invoiceType,
      final Double taxRate,
      final Date bidDeadline,
      final Integer tickSizeNum,
      final Integer invitingNum,
      final Integer respondNum,
      final Date bidOpeningTime,
      final Integer round,
      final String companyName,
      final String remark,
      final List<TenderingSupplierVO> supplierVOList,
      final List<BiddingRoundsVO> biddingRoundsVOS,
      final List<SubjectProjectVO> subjectProjectVOS,
      final TenderNoticeVO tenderNoticeVO,
      final List<SupplierAmountVO> supplierAmountVOS,
      final Date createTime,
      final Date updateTime
   ) {
      this.id = id;
      this.roundId = roundId;
      this.userId = userId;
      this.userName = userName;
      this.name = name;
      this.projectType = projectType;
      this.projectTypeName = projectTypeName;
      this.contractNo = contractNo;
      this.biddingType = biddingType;
      this.cashDeposit = cashDeposit;
      this.isCashDeposit = isCashDeposit;
      this.bankAccountName = bankAccountName;
      this.bankAccount = bankAccount;
      this.depositBank = depositBank;
      this.verifierId = verifierId;
      this.verifierName = verifierName;
      this.verifierTime = verifierTime;
      this.releaseDate = releaseDate;
      this.status = status;
      this.projectProgress = projectProgress;
      this.isOpen = isOpen;
      this.contactPerson = contactPerson;
      this.phone = phone;
      this.modifierId = modifierId;
      this.deliveryAddress = deliveryAddress;
      this.deliveryTime = deliveryTime;
      this.deliveryType = deliveryType;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.bidDeadline = bidDeadline;
      this.tickSizeNum = tickSizeNum;
      this.invitingNum = invitingNum;
      this.respondNum = respondNum;
      this.bidOpeningTime = bidOpeningTime;
      this.round = round;
      this.companyName = companyName;
      this.remark = remark;
      this.supplierVOList = supplierVOList;
      this.biddingRoundsVOS = biddingRoundsVOS;
      this.subjectProjectVOS = subjectProjectVOS;
      this.tenderNoticeVO = tenderNoticeVO;
      this.supplierAmountVOS = supplierAmountVOS;
      this.createTime = createTime;
      this.updateTime = updateTime;
   }

   public static class ProjectTenderingVOBuilder {
      private Long id;
      private Long roundId;
      private Long userId;
      private String userName;
      private String name;
      private Integer projectType;
      private String projectTypeName;
      private String contractNo;
      private Integer biddingType;
      private BigDecimal cashDeposit;
      private Integer isCashDeposit;
      private String bankAccountName;
      private String bankAccount;
      private String depositBank;
      private Long verifierId;
      private String verifierName;
      private Date verifierTime;
      private Date releaseDate;
      private Integer status;
      private Integer projectProgress;
      private Integer isOpen;
      private String contactPerson;
      private String phone;
      private Long modifierId;
      private String deliveryAddress;
      private Date deliveryTime;
      private Integer deliveryType;
      private Integer invoiceType;
      private Double taxRate;
      private Date bidDeadline;
      private Integer tickSizeNum;
      private Integer invitingNum;
      private Integer respondNum;
      private Date bidOpeningTime;
      private Integer round;
      private String companyName;
      private String remark;
      private List<TenderingSupplierVO> supplierVOList;
      private List<BiddingRoundsVO> biddingRoundsVOS;
      private List<SubjectProjectVO> subjectProjectVOS;
      private TenderNoticeVO tenderNoticeVO;
      private List<SupplierAmountVO> supplierAmountVOS;
      private Date createTime;
      private Date updateTime;

      ProjectTenderingVOBuilder() {
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder roundId(final Long roundId) {
         this.roundId = roundId;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder projectTypeName(final String projectTypeName) {
         this.projectTypeName = projectTypeName;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder biddingType(final Integer biddingType) {
         this.biddingType = biddingType;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder isCashDeposit(final Integer isCashDeposit) {
         this.isCashDeposit = isCashDeposit;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder bankAccountName(final String bankAccountName) {
         this.bankAccountName = bankAccountName;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder verifierId(final Long verifierId) {
         this.verifierId = verifierId;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder verifierName(final String verifierName) {
         this.verifierName = verifierName;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder verifierTime(final Date verifierTime) {
         this.verifierTime = verifierTime;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder releaseDate(final Date releaseDate) {
         this.releaseDate = releaseDate;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder projectProgress(final Integer projectProgress) {
         this.projectProgress = projectProgress;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder isOpen(final Integer isOpen) {
         this.isOpen = isOpen;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder contactPerson(final String contactPerson) {
         this.contactPerson = contactPerson;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder modifierId(final Long modifierId) {
         this.modifierId = modifierId;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder deliveryAddress(final String deliveryAddress) {
         this.deliveryAddress = deliveryAddress;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder deliveryTime(final Date deliveryTime) {
         this.deliveryTime = deliveryTime;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder deliveryType(final Integer deliveryType) {
         this.deliveryType = deliveryType;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder taxRate(final Double taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder bidDeadline(final Date bidDeadline) {
         this.bidDeadline = bidDeadline;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder tickSizeNum(final Integer tickSizeNum) {
         this.tickSizeNum = tickSizeNum;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder invitingNum(final Integer invitingNum) {
         this.invitingNum = invitingNum;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder respondNum(final Integer respondNum) {
         this.respondNum = respondNum;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder bidOpeningTime(final Date bidOpeningTime) {
         this.bidOpeningTime = bidOpeningTime;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      @JsonIgnore
      public ProjectTenderingVO.ProjectTenderingVOBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder supplierVOList(final List<TenderingSupplierVO> supplierVOList) {
         this.supplierVOList = supplierVOList;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder biddingRoundsVOS(final List<BiddingRoundsVO> biddingRoundsVOS) {
         this.biddingRoundsVOS = biddingRoundsVOS;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder subjectProjectVOS(final List<SubjectProjectVO> subjectProjectVOS) {
         this.subjectProjectVOS = subjectProjectVOS;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder tenderNoticeVO(final TenderNoticeVO tenderNoticeVO) {
         this.tenderNoticeVO = tenderNoticeVO;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder supplierAmountVOS(final List<SupplierAmountVO> supplierAmountVOS) {
         this.supplierAmountVOS = supplierAmountVOS;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder createTime(final Date createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectTenderingVO.ProjectTenderingVOBuilder updateTime(final Date updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public ProjectTenderingVO build() {
         return new ProjectTenderingVO(
            this.id,
            this.roundId,
            this.userId,
            this.userName,
            this.name,
            this.projectType,
            this.projectTypeName,
            this.contractNo,
            this.biddingType,
            this.cashDeposit,
            this.isCashDeposit,
            this.bankAccountName,
            this.bankAccount,
            this.depositBank,
            this.verifierId,
            this.verifierName,
            this.verifierTime,
            this.releaseDate,
            this.status,
            this.projectProgress,
            this.isOpen,
            this.contactPerson,
            this.phone,
            this.modifierId,
            this.deliveryAddress,
            this.deliveryTime,
            this.deliveryType,
            this.invoiceType,
            this.taxRate,
            this.bidDeadline,
            this.tickSizeNum,
            this.invitingNum,
            this.respondNum,
            this.bidOpeningTime,
            this.round,
            this.companyName,
            this.remark,
            this.supplierVOList,
            this.biddingRoundsVOS,
            this.subjectProjectVOS,
            this.tenderNoticeVO,
            this.supplierAmountVOS,
            this.createTime,
            this.updateTime
         );
      }

      @Override
      public String toString() {
         return "ProjectTenderingVO.ProjectTenderingVOBuilder(id="
            + this.id
            + ", roundId="
            + this.roundId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", projectTypeName="
            + this.projectTypeName
            + ", contractNo="
            + this.contractNo
            + ", biddingType="
            + this.biddingType
            + ", cashDeposit="
            + this.cashDeposit
            + ", isCashDeposit="
            + this.isCashDeposit
            + ", bankAccountName="
            + this.bankAccountName
            + ", bankAccount="
            + this.bankAccount
            + ", depositBank="
            + this.depositBank
            + ", verifierId="
            + this.verifierId
            + ", verifierName="
            + this.verifierName
            + ", verifierTime="
            + this.verifierTime
            + ", releaseDate="
            + this.releaseDate
            + ", status="
            + this.status
            + ", projectProgress="
            + this.projectProgress
            + ", isOpen="
            + this.isOpen
            + ", contactPerson="
            + this.contactPerson
            + ", phone="
            + this.phone
            + ", modifierId="
            + this.modifierId
            + ", deliveryAddress="
            + this.deliveryAddress
            + ", deliveryTime="
            + this.deliveryTime
            + ", deliveryType="
            + this.deliveryType
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", bidDeadline="
            + this.bidDeadline
            + ", tickSizeNum="
            + this.tickSizeNum
            + ", invitingNum="
            + this.invitingNum
            + ", respondNum="
            + this.respondNum
            + ", bidOpeningTime="
            + this.bidOpeningTime
            + ", round="
            + this.round
            + ", companyName="
            + this.companyName
            + ", remark="
            + this.remark
            + ", supplierVOList="
            + this.supplierVOList
            + ", biddingRoundsVOS="
            + this.biddingRoundsVOS
            + ", subjectProjectVOS="
            + this.subjectProjectVOS
            + ", tenderNoticeVO="
            + this.tenderNoticeVO
            + ", supplierAmountVOS="
            + this.supplierAmountVOS
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ")";
      }
   }
}
