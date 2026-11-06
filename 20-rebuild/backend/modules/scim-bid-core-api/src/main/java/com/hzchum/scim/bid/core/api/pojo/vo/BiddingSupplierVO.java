package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BiddingSupplierVO {
   private Long id;
   private Long supplierId;
   private String name;
   private String shortName;
   private String address;
   private String website;
   private Date registerDate;
   private String enterprisePhone;
   private String subjectName;
   private String firstSubjectName;
   private List<String> subjectNameList;
   private String subjectIds;
   private String bankDeposit;
   private String bankAccount;
   private String contactPerson;
   private String contactPhone;
   private String enterpriseEmail;
   private String contactEmail;
   private String regionName;
   private List<String> regionNameList;
   private String regionIds;
   private String socialCreditCode;
   private String businessTerm;
   private BigDecimal registeredFund;
   private String registeredAddress;
   private String businessLicense;
   private Long businessLicenseId;
   private Long powerAttorneyId;
   private String powerAttorney;
   private String legalPerson;
   private Integer isBlock;
   private Date settleInTime;
   private Date createTime;

   public static BiddingSupplierVO.BiddingSupplierVOBuilder builder() {
      return new BiddingSupplierVO.BiddingSupplierVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getAddress() {
      return this.address;
   }

   public String getWebsite() {
      return this.website;
   }

   public Date getRegisterDate() {
      return this.registerDate;
   }

   public String getEnterprisePhone() {
      return this.enterprisePhone;
   }

   public String getSubjectName() {
      return this.subjectName;
   }

   public String getFirstSubjectName() {
      return this.firstSubjectName;
   }

   public List<String> getSubjectNameList() {
      return this.subjectNameList;
   }

   public String getSubjectIds() {
      return this.subjectIds;
   }

   public String getBankDeposit() {
      return this.bankDeposit;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getContactPhone() {
      return this.contactPhone;
   }

   public String getEnterpriseEmail() {
      return this.enterpriseEmail;
   }

   public String getContactEmail() {
      return this.contactEmail;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public List<String> getRegionNameList() {
      return this.regionNameList;
   }

   public String getRegionIds() {
      return this.regionIds;
   }

   public String getSocialCreditCode() {
      return this.socialCreditCode;
   }

   public String getBusinessTerm() {
      return this.businessTerm;
   }

   public BigDecimal getRegisteredFund() {
      return this.registeredFund;
   }

   public String getRegisteredAddress() {
      return this.registeredAddress;
   }

   public String getBusinessLicense() {
      return this.businessLicense;
   }

   public Long getBusinessLicenseId() {
      return this.businessLicenseId;
   }

   public Long getPowerAttorneyId() {
      return this.powerAttorneyId;
   }

   public String getPowerAttorney() {
      return this.powerAttorney;
   }

   public String getLegalPerson() {
      return this.legalPerson;
   }

   public Integer getIsBlock() {
      return this.isBlock;
   }

   public Date getSettleInTime() {
      return this.settleInTime;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setWebsite(final String website) {
      this.website = website;
   }

   public void setRegisterDate(final Date registerDate) {
      this.registerDate = registerDate;
   }

   public void setEnterprisePhone(final String enterprisePhone) {
      this.enterprisePhone = enterprisePhone;
   }

   public void setSubjectName(final String subjectName) {
      this.subjectName = subjectName;
   }

   public void setFirstSubjectName(final String firstSubjectName) {
      this.firstSubjectName = firstSubjectName;
   }

   public void setSubjectNameList(final List<String> subjectNameList) {
      this.subjectNameList = subjectNameList;
   }

   public void setSubjectIds(final String subjectIds) {
      this.subjectIds = subjectIds;
   }

   public void setBankDeposit(final String bankDeposit) {
      this.bankDeposit = bankDeposit;
   }

   public void setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   public void setContactPhone(final String contactPhone) {
      this.contactPhone = contactPhone;
   }

   public void setEnterpriseEmail(final String enterpriseEmail) {
      this.enterpriseEmail = enterpriseEmail;
   }

   public void setContactEmail(final String contactEmail) {
      this.contactEmail = contactEmail;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setRegionNameList(final List<String> regionNameList) {
      this.regionNameList = regionNameList;
   }

   public void setRegionIds(final String regionIds) {
      this.regionIds = regionIds;
   }

   public void setSocialCreditCode(final String socialCreditCode) {
      this.socialCreditCode = socialCreditCode;
   }

   public void setBusinessTerm(final String businessTerm) {
      this.businessTerm = businessTerm;
   }

   public void setRegisteredFund(final BigDecimal registeredFund) {
      this.registeredFund = registeredFund;
   }

   public void setRegisteredAddress(final String registeredAddress) {
      this.registeredAddress = registeredAddress;
   }

   public void setBusinessLicense(final String businessLicense) {
      this.businessLicense = businessLicense;
   }

   public void setBusinessLicenseId(final Long businessLicenseId) {
      this.businessLicenseId = businessLicenseId;
   }

   public void setPowerAttorneyId(final Long powerAttorneyId) {
      this.powerAttorneyId = powerAttorneyId;
   }

   public void setPowerAttorney(final String powerAttorney) {
      this.powerAttorney = powerAttorney;
   }

   public void setLegalPerson(final String legalPerson) {
      this.legalPerson = legalPerson;
   }

   public void setIsBlock(final Integer isBlock) {
      this.isBlock = isBlock;
   }

   public void setSettleInTime(final Date settleInTime) {
      this.settleInTime = settleInTime;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiddingSupplierVO)) {
         return false;
      }

      BiddingSupplierVO other = (BiddingSupplierVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$businessLicenseId = this.getBusinessLicenseId();
            Object other$businessLicenseId = other.getBusinessLicenseId();
            if (this$businessLicenseId == null ? other$businessLicenseId == null : this$businessLicenseId.equals(other$businessLicenseId)) {
               Object this$powerAttorneyId = this.getPowerAttorneyId();
               Object other$powerAttorneyId = other.getPowerAttorneyId();
               if (this$powerAttorneyId == null ? other$powerAttorneyId == null : this$powerAttorneyId.equals(other$powerAttorneyId)) {
                  Object this$isBlock = this.getIsBlock();
                  Object other$isBlock = other.getIsBlock();
                  if (this$isBlock == null ? other$isBlock == null : this$isBlock.equals(other$isBlock)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$shortName = this.getShortName();
                        Object other$shortName = other.getShortName();
                        if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                           Object this$address = this.getAddress();
                           Object other$address = other.getAddress();
                           if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                              Object this$website = this.getWebsite();
                              Object other$website = other.getWebsite();
                              if (this$website == null ? other$website == null : this$website.equals(other$website)) {
                                 Object this$registerDate = this.getRegisterDate();
                                 Object other$registerDate = other.getRegisterDate();
                                 if (this$registerDate == null ? other$registerDate == null : this$registerDate.equals(other$registerDate)) {
                                    Object this$enterprisePhone = this.getEnterprisePhone();
                                    Object other$enterprisePhone = other.getEnterprisePhone();
                                    if (this$enterprisePhone == null ? other$enterprisePhone == null : this$enterprisePhone.equals(other$enterprisePhone)) {
                                       Object this$subjectName = this.getSubjectName();
                                       Object other$subjectName = other.getSubjectName();
                                       if (this$subjectName == null ? other$subjectName == null : this$subjectName.equals(other$subjectName)) {
                                          Object this$firstSubjectName = this.getFirstSubjectName();
                                          Object other$firstSubjectName = other.getFirstSubjectName();
                                          if (this$firstSubjectName == null
                                             ? other$firstSubjectName == null
                                             : this$firstSubjectName.equals(other$firstSubjectName)) {
                                             Object this$subjectNameList = this.getSubjectNameList();
                                             Object other$subjectNameList = other.getSubjectNameList();
                                             if (this$subjectNameList == null
                                                ? other$subjectNameList == null
                                                : this$subjectNameList.equals(other$subjectNameList)) {
                                                Object this$subjectIds = this.getSubjectIds();
                                                Object other$subjectIds = other.getSubjectIds();
                                                if (this$subjectIds == null ? other$subjectIds == null : this$subjectIds.equals(other$subjectIds)) {
                                                   Object this$bankDeposit = this.getBankDeposit();
                                                   Object other$bankDeposit = other.getBankDeposit();
                                                   if (this$bankDeposit == null ? other$bankDeposit == null : this$bankDeposit.equals(other$bankDeposit)) {
                                                      Object this$bankAccount = this.getBankAccount();
                                                      Object other$bankAccount = other.getBankAccount();
                                                      if (this$bankAccount == null ? other$bankAccount == null : this$bankAccount.equals(other$bankAccount)) {
                                                         Object this$contactPerson = this.getContactPerson();
                                                         Object other$contactPerson = other.getContactPerson();
                                                         if (this$contactPerson == null
                                                            ? other$contactPerson == null
                                                            : this$contactPerson.equals(other$contactPerson)) {
                                                            Object this$contactPhone = this.getContactPhone();
                                                            Object other$contactPhone = other.getContactPhone();
                                                            if (this$contactPhone == null
                                                               ? other$contactPhone == null
                                                               : this$contactPhone.equals(other$contactPhone)) {
                                                               Object this$enterpriseEmail = this.getEnterpriseEmail();
                                                               Object other$enterpriseEmail = other.getEnterpriseEmail();
                                                               if (this$enterpriseEmail == null
                                                                  ? other$enterpriseEmail == null
                                                                  : this$enterpriseEmail.equals(other$enterpriseEmail)) {
                                                                  Object this$contactEmail = this.getContactEmail();
                                                                  Object other$contactEmail = other.getContactEmail();
                                                                  if (this$contactEmail == null
                                                                     ? other$contactEmail == null
                                                                     : this$contactEmail.equals(other$contactEmail)) {
                                                                     Object this$regionName = this.getRegionName();
                                                                     Object other$regionName = other.getRegionName();
                                                                     if (this$regionName == null
                                                                        ? other$regionName == null
                                                                        : this$regionName.equals(other$regionName)) {
                                                                        Object this$regionNameList = this.getRegionNameList();
                                                                        Object other$regionNameList = other.getRegionNameList();
                                                                        if (this$regionNameList == null
                                                                           ? other$regionNameList == null
                                                                           : this$regionNameList.equals(other$regionNameList)) {
                                                                           Object this$regionIds = this.getRegionIds();
                                                                           Object other$regionIds = other.getRegionIds();
                                                                           if (this$regionIds == null
                                                                              ? other$regionIds == null
                                                                              : this$regionIds.equals(other$regionIds)) {
                                                                              Object this$socialCreditCode = this.getSocialCreditCode();
                                                                              Object other$socialCreditCode = other.getSocialCreditCode();
                                                                              if (this$socialCreditCode == null
                                                                                 ? other$socialCreditCode == null
                                                                                 : this$socialCreditCode.equals(other$socialCreditCode)) {
                                                                                 Object this$businessTerm = this.getBusinessTerm();
                                                                                 Object other$businessTerm = other.getBusinessTerm();
                                                                                 if (this$businessTerm == null
                                                                                    ? other$businessTerm == null
                                                                                    : this$businessTerm.equals(other$businessTerm)) {
                                                                                    Object this$registeredFund = this.getRegisteredFund();
                                                                                    Object other$registeredFund = other.getRegisteredFund();
                                                                                    if (this$registeredFund == null
                                                                                       ? other$registeredFund == null
                                                                                       : this$registeredFund.equals(other$registeredFund)) {
                                                                                       Object this$registeredAddress = this.getRegisteredAddress();
                                                                                       Object other$registeredAddress = other.getRegisteredAddress();
                                                                                       if (this$registeredAddress == null
                                                                                          ? other$registeredAddress == null
                                                                                          : this$registeredAddress.equals(other$registeredAddress)) {
                                                                                          Object this$businessLicense = this.getBusinessLicense();
                                                                                          Object other$businessLicense = other.getBusinessLicense();
                                                                                          if (this$businessLicense == null
                                                                                             ? other$businessLicense == null
                                                                                             : this$businessLicense.equals(other$businessLicense)) {
                                                                                             Object this$powerAttorney = this.getPowerAttorney();
                                                                                             Object other$powerAttorney = other.getPowerAttorney();
                                                                                             if (this$powerAttorney == null
                                                                                                ? other$powerAttorney == null
                                                                                                : this$powerAttorney.equals(other$powerAttorney)) {
                                                                                                Object this$legalPerson = this.getLegalPerson();
                                                                                                Object other$legalPerson = other.getLegalPerson();
                                                                                                if (this$legalPerson == null
                                                                                                   ? other$legalPerson == null
                                                                                                   : this$legalPerson.equals(other$legalPerson)) {
                                                                                                   Object this$settleInTime = this.getSettleInTime();
                                                                                                   Object other$settleInTime = other.getSettleInTime();
                                                                                                   if (this$settleInTime == null
                                                                                                      ? other$settleInTime == null
                                                                                                      : this$settleInTime.equals(other$settleInTime)) {
                                                                                                      Object this$createTime = this.getCreateTime();
                                                                                                      Object other$createTime = other.getCreateTime();
                                                                                                      return this$createTime == null
                                                                                                         ? other$createTime == null
                                                                                                         : this$createTime.equals(other$createTime);
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
      return other instanceof BiddingSupplierVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $businessLicenseId = this.getBusinessLicenseId();
      result = result * 59 + ($businessLicenseId == null ? 43 : $businessLicenseId.hashCode());
      Object $powerAttorneyId = this.getPowerAttorneyId();
      result = result * 59 + ($powerAttorneyId == null ? 43 : $powerAttorneyId.hashCode());
      Object $isBlock = this.getIsBlock();
      result = result * 59 + ($isBlock == null ? 43 : $isBlock.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $website = this.getWebsite();
      result = result * 59 + ($website == null ? 43 : $website.hashCode());
      Object $registerDate = this.getRegisterDate();
      result = result * 59 + ($registerDate == null ? 43 : $registerDate.hashCode());
      Object $enterprisePhone = this.getEnterprisePhone();
      result = result * 59 + ($enterprisePhone == null ? 43 : $enterprisePhone.hashCode());
      Object $subjectName = this.getSubjectName();
      result = result * 59 + ($subjectName == null ? 43 : $subjectName.hashCode());
      Object $firstSubjectName = this.getFirstSubjectName();
      result = result * 59 + ($firstSubjectName == null ? 43 : $firstSubjectName.hashCode());
      Object $subjectNameList = this.getSubjectNameList();
      result = result * 59 + ($subjectNameList == null ? 43 : $subjectNameList.hashCode());
      Object $subjectIds = this.getSubjectIds();
      result = result * 59 + ($subjectIds == null ? 43 : $subjectIds.hashCode());
      Object $bankDeposit = this.getBankDeposit();
      result = result * 59 + ($bankDeposit == null ? 43 : $bankDeposit.hashCode());
      Object $bankAccount = this.getBankAccount();
      result = result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $contactPhone = this.getContactPhone();
      result = result * 59 + ($contactPhone == null ? 43 : $contactPhone.hashCode());
      Object $enterpriseEmail = this.getEnterpriseEmail();
      result = result * 59 + ($enterpriseEmail == null ? 43 : $enterpriseEmail.hashCode());
      Object $contactEmail = this.getContactEmail();
      result = result * 59 + ($contactEmail == null ? 43 : $contactEmail.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $regionIds = this.getRegionIds();
      result = result * 59 + ($regionIds == null ? 43 : $regionIds.hashCode());
      Object $socialCreditCode = this.getSocialCreditCode();
      result = result * 59 + ($socialCreditCode == null ? 43 : $socialCreditCode.hashCode());
      Object $businessTerm = this.getBusinessTerm();
      result = result * 59 + ($businessTerm == null ? 43 : $businessTerm.hashCode());
      Object $registeredFund = this.getRegisteredFund();
      result = result * 59 + ($registeredFund == null ? 43 : $registeredFund.hashCode());
      Object $registeredAddress = this.getRegisteredAddress();
      result = result * 59 + ($registeredAddress == null ? 43 : $registeredAddress.hashCode());
      Object $businessLicense = this.getBusinessLicense();
      result = result * 59 + ($businessLicense == null ? 43 : $businessLicense.hashCode());
      Object $powerAttorney = this.getPowerAttorney();
      result = result * 59 + ($powerAttorney == null ? 43 : $powerAttorney.hashCode());
      Object $legalPerson = this.getLegalPerson();
      result = result * 59 + ($legalPerson == null ? 43 : $legalPerson.hashCode());
      Object $settleInTime = this.getSettleInTime();
      result = result * 59 + ($settleInTime == null ? 43 : $settleInTime.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "BiddingSupplierVO(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", address="
         + this.getAddress()
         + ", website="
         + this.getWebsite()
         + ", registerDate="
         + this.getRegisterDate()
         + ", enterprisePhone="
         + this.getEnterprisePhone()
         + ", subjectName="
         + this.getSubjectName()
         + ", firstSubjectName="
         + this.getFirstSubjectName()
         + ", subjectNameList="
         + this.getSubjectNameList()
         + ", subjectIds="
         + this.getSubjectIds()
         + ", bankDeposit="
         + this.getBankDeposit()
         + ", bankAccount="
         + this.getBankAccount()
         + ", contactPerson="
         + this.getContactPerson()
         + ", contactPhone="
         + this.getContactPhone()
         + ", enterpriseEmail="
         + this.getEnterpriseEmail()
         + ", contactEmail="
         + this.getContactEmail()
         + ", regionName="
         + this.getRegionName()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", regionIds="
         + this.getRegionIds()
         + ", socialCreditCode="
         + this.getSocialCreditCode()
         + ", businessTerm="
         + this.getBusinessTerm()
         + ", registeredFund="
         + this.getRegisteredFund()
         + ", registeredAddress="
         + this.getRegisteredAddress()
         + ", businessLicense="
         + this.getBusinessLicense()
         + ", businessLicenseId="
         + this.getBusinessLicenseId()
         + ", powerAttorneyId="
         + this.getPowerAttorneyId()
         + ", powerAttorney="
         + this.getPowerAttorney()
         + ", legalPerson="
         + this.getLegalPerson()
         + ", isBlock="
         + this.getIsBlock()
         + ", settleInTime="
         + this.getSettleInTime()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public BiddingSupplierVO() {
   }

   public BiddingSupplierVO(
      final Long id,
      final Long supplierId,
      final String name,
      final String shortName,
      final String address,
      final String website,
      final Date registerDate,
      final String enterprisePhone,
      final String subjectName,
      final String firstSubjectName,
      final List<String> subjectNameList,
      final String subjectIds,
      final String bankDeposit,
      final String bankAccount,
      final String contactPerson,
      final String contactPhone,
      final String enterpriseEmail,
      final String contactEmail,
      final String regionName,
      final List<String> regionNameList,
      final String regionIds,
      final String socialCreditCode,
      final String businessTerm,
      final BigDecimal registeredFund,
      final String registeredAddress,
      final String businessLicense,
      final Long businessLicenseId,
      final Long powerAttorneyId,
      final String powerAttorney,
      final String legalPerson,
      final Integer isBlock,
      final Date settleInTime,
      final Date createTime
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.name = name;
      this.shortName = shortName;
      this.address = address;
      this.website = website;
      this.registerDate = registerDate;
      this.enterprisePhone = enterprisePhone;
      this.subjectName = subjectName;
      this.firstSubjectName = firstSubjectName;
      this.subjectNameList = subjectNameList;
      this.subjectIds = subjectIds;
      this.bankDeposit = bankDeposit;
      this.bankAccount = bankAccount;
      this.contactPerson = contactPerson;
      this.contactPhone = contactPhone;
      this.enterpriseEmail = enterpriseEmail;
      this.contactEmail = contactEmail;
      this.regionName = regionName;
      this.regionNameList = regionNameList;
      this.regionIds = regionIds;
      this.socialCreditCode = socialCreditCode;
      this.businessTerm = businessTerm;
      this.registeredFund = registeredFund;
      this.registeredAddress = registeredAddress;
      this.businessLicense = businessLicense;
      this.businessLicenseId = businessLicenseId;
      this.powerAttorneyId = powerAttorneyId;
      this.powerAttorney = powerAttorney;
      this.legalPerson = legalPerson;
      this.isBlock = isBlock;
      this.settleInTime = settleInTime;
      this.createTime = createTime;
   }

   public static class BiddingSupplierVOBuilder {
      private Long id;
      private Long supplierId;
      private String name;
      private String shortName;
      private String address;
      private String website;
      private Date registerDate;
      private String enterprisePhone;
      private String subjectName;
      private String firstSubjectName;
      private List<String> subjectNameList;
      private String subjectIds;
      private String bankDeposit;
      private String bankAccount;
      private String contactPerson;
      private String contactPhone;
      private String enterpriseEmail;
      private String contactEmail;
      private String regionName;
      private List<String> regionNameList;
      private String regionIds;
      private String socialCreditCode;
      private String businessTerm;
      private BigDecimal registeredFund;
      private String registeredAddress;
      private String businessLicense;
      private Long businessLicenseId;
      private Long powerAttorneyId;
      private String powerAttorney;
      private String legalPerson;
      private Integer isBlock;
      private Date settleInTime;
      private Date createTime;

      BiddingSupplierVOBuilder() {
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder website(final String website) {
         this.website = website;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder registerDate(final Date registerDate) {
         this.registerDate = registerDate;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder enterprisePhone(final String enterprisePhone) {
         this.enterprisePhone = enterprisePhone;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder subjectName(final String subjectName) {
         this.subjectName = subjectName;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder firstSubjectName(final String firstSubjectName) {
         this.firstSubjectName = firstSubjectName;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder subjectNameList(final List<String> subjectNameList) {
         this.subjectNameList = subjectNameList;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder subjectIds(final String subjectIds) {
         this.subjectIds = subjectIds;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder bankDeposit(final String bankDeposit) {
         this.bankDeposit = bankDeposit;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder contactPerson(final String contactPerson) {
         this.contactPerson = contactPerson;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder contactPhone(final String contactPhone) {
         this.contactPhone = contactPhone;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder enterpriseEmail(final String enterpriseEmail) {
         this.enterpriseEmail = enterpriseEmail;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder contactEmail(final String contactEmail) {
         this.contactEmail = contactEmail;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder regionNameList(final List<String> regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder regionIds(final String regionIds) {
         this.regionIds = regionIds;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder socialCreditCode(final String socialCreditCode) {
         this.socialCreditCode = socialCreditCode;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder businessTerm(final String businessTerm) {
         this.businessTerm = businessTerm;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder registeredFund(final BigDecimal registeredFund) {
         this.registeredFund = registeredFund;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder registeredAddress(final String registeredAddress) {
         this.registeredAddress = registeredAddress;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder businessLicense(final String businessLicense) {
         this.businessLicense = businessLicense;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder businessLicenseId(final Long businessLicenseId) {
         this.businessLicenseId = businessLicenseId;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder powerAttorneyId(final Long powerAttorneyId) {
         this.powerAttorneyId = powerAttorneyId;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder powerAttorney(final String powerAttorney) {
         this.powerAttorney = powerAttorney;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder legalPerson(final String legalPerson) {
         this.legalPerson = legalPerson;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder isBlock(final Integer isBlock) {
         this.isBlock = isBlock;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder settleInTime(final Date settleInTime) {
         this.settleInTime = settleInTime;
         return this;
      }

      public BiddingSupplierVO.BiddingSupplierVOBuilder createTime(final Date createTime) {
         this.createTime = createTime;
         return this;
      }

      public BiddingSupplierVO build() {
         return new BiddingSupplierVO(
            this.id,
            this.supplierId,
            this.name,
            this.shortName,
            this.address,
            this.website,
            this.registerDate,
            this.enterprisePhone,
            this.subjectName,
            this.firstSubjectName,
            this.subjectNameList,
            this.subjectIds,
            this.bankDeposit,
            this.bankAccount,
            this.contactPerson,
            this.contactPhone,
            this.enterpriseEmail,
            this.contactEmail,
            this.regionName,
            this.regionNameList,
            this.regionIds,
            this.socialCreditCode,
            this.businessTerm,
            this.registeredFund,
            this.registeredAddress,
            this.businessLicense,
            this.businessLicenseId,
            this.powerAttorneyId,
            this.powerAttorney,
            this.legalPerson,
            this.isBlock,
            this.settleInTime,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "BiddingSupplierVO.BiddingSupplierVOBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", address="
            + this.address
            + ", website="
            + this.website
            + ", registerDate="
            + this.registerDate
            + ", enterprisePhone="
            + this.enterprisePhone
            + ", subjectName="
            + this.subjectName
            + ", firstSubjectName="
            + this.firstSubjectName
            + ", subjectNameList="
            + this.subjectNameList
            + ", subjectIds="
            + this.subjectIds
            + ", bankDeposit="
            + this.bankDeposit
            + ", bankAccount="
            + this.bankAccount
            + ", contactPerson="
            + this.contactPerson
            + ", contactPhone="
            + this.contactPhone
            + ", enterpriseEmail="
            + this.enterpriseEmail
            + ", contactEmail="
            + this.contactEmail
            + ", regionName="
            + this.regionName
            + ", regionNameList="
            + this.regionNameList
            + ", regionIds="
            + this.regionIds
            + ", socialCreditCode="
            + this.socialCreditCode
            + ", businessTerm="
            + this.businessTerm
            + ", registeredFund="
            + this.registeredFund
            + ", registeredAddress="
            + this.registeredAddress
            + ", businessLicense="
            + this.businessLicense
            + ", businessLicenseId="
            + this.businessLicenseId
            + ", powerAttorneyId="
            + this.powerAttorneyId
            + ", powerAttorney="
            + this.powerAttorney
            + ", legalPerson="
            + this.legalPerson
            + ", isBlock="
            + this.isBlock
            + ", settleInTime="
            + this.settleInTime
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
