package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.scm.core.api.pojo._do.SupplierContacts;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierConfigDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

public class SupplierDetailDTO {
   private Long id;
   private String name;
   private String shortName;
   private String supplierNumber;
   private Long countryId;
   private String countryName;
   private Long provinceId;
   private String provinceName;
   private Long cityId;
   private String cityName;
   private Long regionId;
   private String regionName;
   private String address;
   private String socialCode;
   private LocalDate registrationDate;
   private String businessTerm;
   private String legalRepresentative;
   private String registeredCapital;
   private String enterpriseType;
   private String bankName;
   private String bankAccount;
   private String website;
   private String companyEmail;
   private String companyPhone;
   List<SupplierContacts> contacts;
   private String mainBusiness;
   private List<AttachmentDTO> attachments;
   private Boolean boolHide;
   private Integer supplierClassification;
   @ApiModelProperty("分数评级")
   private String scoreRating;
   @ApiModelProperty("评价分类")
   ScmSupplierConfigDTO scmSupplierConfigDTO;

   public static SupplierDetailDTO.SupplierDetailDTOBuilder builder() {
      return new SupplierDetailDTO.SupplierDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSupplierNumber() {
      return this.supplierNumber;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAddress() {
      return this.address;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public LocalDate getRegistrationDate() {
      return this.registrationDate;
   }

   public String getBusinessTerm() {
      return this.businessTerm;
   }

   public String getLegalRepresentative() {
      return this.legalRepresentative;
   }

   public String getRegisteredCapital() {
      return this.registeredCapital;
   }

   public String getEnterpriseType() {
      return this.enterpriseType;
   }

   public String getBankName() {
      return this.bankName;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public String getWebsite() {
      return this.website;
   }

   public String getCompanyEmail() {
      return this.companyEmail;
   }

   public String getCompanyPhone() {
      return this.companyPhone;
   }

   public List<SupplierContacts> getContacts() {
      return this.contacts;
   }

   public String getMainBusiness() {
      return this.mainBusiness;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Boolean getBoolHide() {
      return this.boolHide;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public String getScoreRating() {
      return this.scoreRating;
   }

   public ScmSupplierConfigDTO getScmSupplierConfigDTO() {
      return this.scmSupplierConfigDTO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSupplierNumber(final String supplierNumber) {
      this.supplierNumber = supplierNumber;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setRegistrationDate(final LocalDate registrationDate) {
      this.registrationDate = registrationDate;
   }

   public void setBusinessTerm(final String businessTerm) {
      this.businessTerm = businessTerm;
   }

   public void setLegalRepresentative(final String legalRepresentative) {
      this.legalRepresentative = legalRepresentative;
   }

   public void setRegisteredCapital(final String registeredCapital) {
      this.registeredCapital = registeredCapital;
   }

   public void setEnterpriseType(final String enterpriseType) {
      this.enterpriseType = enterpriseType;
   }

   public void setBankName(final String bankName) {
      this.bankName = bankName;
   }

   public void setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
   }

   public void setWebsite(final String website) {
      this.website = website;
   }

   public void setCompanyEmail(final String companyEmail) {
      this.companyEmail = companyEmail;
   }

   public void setCompanyPhone(final String companyPhone) {
      this.companyPhone = companyPhone;
   }

   public void setContacts(final List<SupplierContacts> contacts) {
      this.contacts = contacts;
   }

   public void setMainBusiness(final String mainBusiness) {
      this.mainBusiness = mainBusiness;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setBoolHide(final Boolean boolHide) {
      this.boolHide = boolHide;
   }

   public void setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
   }

   public void setScoreRating(final String scoreRating) {
      this.scoreRating = scoreRating;
   }

   public void setScmSupplierConfigDTO(final ScmSupplierConfigDTO scmSupplierConfigDTO) {
      this.scmSupplierConfigDTO = scmSupplierConfigDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierDetailDTO)) {
         return false;
      }

      SupplierDetailDTO other = (SupplierDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$countryId = this.getCountryId();
         Object other$countryId = other.getCountryId();
         if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
            Object this$provinceId = this.getProvinceId();
            Object other$provinceId = other.getProvinceId();
            if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
               Object this$cityId = this.getCityId();
               Object other$cityId = other.getCityId();
               if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                  Object this$regionId = this.getRegionId();
                  Object other$regionId = other.getRegionId();
                  if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                     Object this$boolHide = this.getBoolHide();
                     Object other$boolHide = other.getBoolHide();
                     if (this$boolHide == null ? other$boolHide == null : this$boolHide.equals(other$boolHide)) {
                        Object this$supplierClassification = this.getSupplierClassification();
                        Object other$supplierClassification = other.getSupplierClassification();
                        if (this$supplierClassification == null
                           ? other$supplierClassification == null
                           : this$supplierClassification.equals(other$supplierClassification)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$shortName = this.getShortName();
                              Object other$shortName = other.getShortName();
                              if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                 Object this$supplierNumber = this.getSupplierNumber();
                                 Object other$supplierNumber = other.getSupplierNumber();
                                 if (this$supplierNumber == null ? other$supplierNumber == null : this$supplierNumber.equals(other$supplierNumber)) {
                                    Object this$countryName = this.getCountryName();
                                    Object other$countryName = other.getCountryName();
                                    if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                                       Object this$provinceName = this.getProvinceName();
                                       Object other$provinceName = other.getProvinceName();
                                       if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                                          Object this$cityName = this.getCityName();
                                          Object other$cityName = other.getCityName();
                                          if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                             Object this$regionName = this.getRegionName();
                                             Object other$regionName = other.getRegionName();
                                             if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                                Object this$address = this.getAddress();
                                                Object other$address = other.getAddress();
                                                if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                   Object this$socialCode = this.getSocialCode();
                                                   Object other$socialCode = other.getSocialCode();
                                                   if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                                                      Object this$registrationDate = this.getRegistrationDate();
                                                      Object other$registrationDate = other.getRegistrationDate();
                                                      if (this$registrationDate == null
                                                         ? other$registrationDate == null
                                                         : this$registrationDate.equals(other$registrationDate)) {
                                                         Object this$businessTerm = this.getBusinessTerm();
                                                         Object other$businessTerm = other.getBusinessTerm();
                                                         if (this$businessTerm == null
                                                            ? other$businessTerm == null
                                                            : this$businessTerm.equals(other$businessTerm)) {
                                                            Object this$legalRepresentative = this.getLegalRepresentative();
                                                            Object other$legalRepresentative = other.getLegalRepresentative();
                                                            if (this$legalRepresentative == null
                                                               ? other$legalRepresentative == null
                                                               : this$legalRepresentative.equals(other$legalRepresentative)) {
                                                               Object this$registeredCapital = this.getRegisteredCapital();
                                                               Object other$registeredCapital = other.getRegisteredCapital();
                                                               if (this$registeredCapital == null
                                                                  ? other$registeredCapital == null
                                                                  : this$registeredCapital.equals(other$registeredCapital)) {
                                                                  Object this$enterpriseType = this.getEnterpriseType();
                                                                  Object other$enterpriseType = other.getEnterpriseType();
                                                                  if (this$enterpriseType == null
                                                                     ? other$enterpriseType == null
                                                                     : this$enterpriseType.equals(other$enterpriseType)) {
                                                                     Object this$bankName = this.getBankName();
                                                                     Object other$bankName = other.getBankName();
                                                                     if (this$bankName == null ? other$bankName == null : this$bankName.equals(other$bankName)) {
                                                                        Object this$bankAccount = this.getBankAccount();
                                                                        Object other$bankAccount = other.getBankAccount();
                                                                        if (this$bankAccount == null
                                                                           ? other$bankAccount == null
                                                                           : this$bankAccount.equals(other$bankAccount)) {
                                                                           Object this$website = this.getWebsite();
                                                                           Object other$website = other.getWebsite();
                                                                           if (this$website == null
                                                                              ? other$website == null
                                                                              : this$website.equals(other$website)) {
                                                                              Object this$companyEmail = this.getCompanyEmail();
                                                                              Object other$companyEmail = other.getCompanyEmail();
                                                                              if (this$companyEmail == null
                                                                                 ? other$companyEmail == null
                                                                                 : this$companyEmail.equals(other$companyEmail)) {
                                                                                 Object this$companyPhone = this.getCompanyPhone();
                                                                                 Object other$companyPhone = other.getCompanyPhone();
                                                                                 if (this$companyPhone == null
                                                                                    ? other$companyPhone == null
                                                                                    : this$companyPhone.equals(other$companyPhone)) {
                                                                                    Object this$contacts = this.getContacts();
                                                                                    Object other$contacts = other.getContacts();
                                                                                    if (this$contacts == null
                                                                                       ? other$contacts == null
                                                                                       : this$contacts.equals(other$contacts)) {
                                                                                       Object this$mainBusiness = this.getMainBusiness();
                                                                                       Object other$mainBusiness = other.getMainBusiness();
                                                                                       if (this$mainBusiness == null
                                                                                          ? other$mainBusiness == null
                                                                                          : this$mainBusiness.equals(other$mainBusiness)) {
                                                                                          Object this$attachments = this.getAttachments();
                                                                                          Object other$attachments = other.getAttachments();
                                                                                          if (this$attachments == null
                                                                                             ? other$attachments == null
                                                                                             : this$attachments.equals(other$attachments)) {
                                                                                             Object this$scoreRating = this.getScoreRating();
                                                                                             Object other$scoreRating = other.getScoreRating();
                                                                                             if (this$scoreRating == null
                                                                                                ? other$scoreRating == null
                                                                                                : this$scoreRating.equals(other$scoreRating)) {
                                                                                                Object this$scmSupplierConfigDTO = this.getScmSupplierConfigDTO();
                                                                                                Object other$scmSupplierConfigDTO = other.getScmSupplierConfigDTO();
                                                                                                return this$scmSupplierConfigDTO == null
                                                                                                   ? other$scmSupplierConfigDTO == null
                                                                                                   : this$scmSupplierConfigDTO.equals(
                                                                                                      other$scmSupplierConfigDTO
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $boolHide = this.getBoolHide();
      result = result * 59 + ($boolHide == null ? 43 : $boolHide.hashCode());
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $registrationDate = this.getRegistrationDate();
      result = result * 59 + ($registrationDate == null ? 43 : $registrationDate.hashCode());
      Object $businessTerm = this.getBusinessTerm();
      result = result * 59 + ($businessTerm == null ? 43 : $businessTerm.hashCode());
      Object $legalRepresentative = this.getLegalRepresentative();
      result = result * 59 + ($legalRepresentative == null ? 43 : $legalRepresentative.hashCode());
      Object $registeredCapital = this.getRegisteredCapital();
      result = result * 59 + ($registeredCapital == null ? 43 : $registeredCapital.hashCode());
      Object $enterpriseType = this.getEnterpriseType();
      result = result * 59 + ($enterpriseType == null ? 43 : $enterpriseType.hashCode());
      Object $bankName = this.getBankName();
      result = result * 59 + ($bankName == null ? 43 : $bankName.hashCode());
      Object $bankAccount = this.getBankAccount();
      result = result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
      Object $website = this.getWebsite();
      result = result * 59 + ($website == null ? 43 : $website.hashCode());
      Object $companyEmail = this.getCompanyEmail();
      result = result * 59 + ($companyEmail == null ? 43 : $companyEmail.hashCode());
      Object $companyPhone = this.getCompanyPhone();
      result = result * 59 + ($companyPhone == null ? 43 : $companyPhone.hashCode());
      Object $contacts = this.getContacts();
      result = result * 59 + ($contacts == null ? 43 : $contacts.hashCode());
      Object $mainBusiness = this.getMainBusiness();
      result = result * 59 + ($mainBusiness == null ? 43 : $mainBusiness.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $scoreRating = this.getScoreRating();
      result = result * 59 + ($scoreRating == null ? 43 : $scoreRating.hashCode());
      Object $scmSupplierConfigDTO = this.getScmSupplierConfigDTO();
      return result * 59 + ($scmSupplierConfigDTO == null ? 43 : $scmSupplierConfigDTO.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierDetailDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", supplierNumber="
         + this.getSupplierNumber()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", address="
         + this.getAddress()
         + ", socialCode="
         + this.getSocialCode()
         + ", registrationDate="
         + this.getRegistrationDate()
         + ", businessTerm="
         + this.getBusinessTerm()
         + ", legalRepresentative="
         + this.getLegalRepresentative()
         + ", registeredCapital="
         + this.getRegisteredCapital()
         + ", enterpriseType="
         + this.getEnterpriseType()
         + ", bankName="
         + this.getBankName()
         + ", bankAccount="
         + this.getBankAccount()
         + ", website="
         + this.getWebsite()
         + ", companyEmail="
         + this.getCompanyEmail()
         + ", companyPhone="
         + this.getCompanyPhone()
         + ", contacts="
         + this.getContacts()
         + ", mainBusiness="
         + this.getMainBusiness()
         + ", attachments="
         + this.getAttachments()
         + ", boolHide="
         + this.getBoolHide()
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", scoreRating="
         + this.getScoreRating()
         + ", scmSupplierConfigDTO="
         + this.getScmSupplierConfigDTO()
         + ")";
   }

   public SupplierDetailDTO(
      final Long id,
      final String name,
      final String shortName,
      final String supplierNumber,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String address,
      final String socialCode,
      final LocalDate registrationDate,
      final String businessTerm,
      final String legalRepresentative,
      final String registeredCapital,
      final String enterpriseType,
      final String bankName,
      final String bankAccount,
      final String website,
      final String companyEmail,
      final String companyPhone,
      final List<SupplierContacts> contacts,
      final String mainBusiness,
      final List<AttachmentDTO> attachments,
      final Boolean boolHide,
      final Integer supplierClassification,
      final String scoreRating,
      final ScmSupplierConfigDTO scmSupplierConfigDTO
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.supplierNumber = supplierNumber;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.address = address;
      this.socialCode = socialCode;
      this.registrationDate = registrationDate;
      this.businessTerm = businessTerm;
      this.legalRepresentative = legalRepresentative;
      this.registeredCapital = registeredCapital;
      this.enterpriseType = enterpriseType;
      this.bankName = bankName;
      this.bankAccount = bankAccount;
      this.website = website;
      this.companyEmail = companyEmail;
      this.companyPhone = companyPhone;
      this.contacts = contacts;
      this.mainBusiness = mainBusiness;
      this.attachments = attachments;
      this.boolHide = boolHide;
      this.supplierClassification = supplierClassification;
      this.scoreRating = scoreRating;
      this.scmSupplierConfigDTO = scmSupplierConfigDTO;
   }

   public SupplierDetailDTO() {
   }

   public static class SupplierDetailDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String supplierNumber;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String address;
      private String socialCode;
      private LocalDate registrationDate;
      private String businessTerm;
      private String legalRepresentative;
      private String registeredCapital;
      private String enterpriseType;
      private String bankName;
      private String bankAccount;
      private String website;
      private String companyEmail;
      private String companyPhone;
      private List<SupplierContacts> contacts;
      private String mainBusiness;
      private List<AttachmentDTO> attachments;
      private Boolean boolHide;
      private Integer supplierClassification;
      private String scoreRating;
      private ScmSupplierConfigDTO scmSupplierConfigDTO;

      SupplierDetailDTOBuilder() {
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder supplierNumber(final String supplierNumber) {
         this.supplierNumber = supplierNumber;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder registrationDate(final LocalDate registrationDate) {
         this.registrationDate = registrationDate;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder businessTerm(final String businessTerm) {
         this.businessTerm = businessTerm;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder legalRepresentative(final String legalRepresentative) {
         this.legalRepresentative = legalRepresentative;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder registeredCapital(final String registeredCapital) {
         this.registeredCapital = registeredCapital;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder enterpriseType(final String enterpriseType) {
         this.enterpriseType = enterpriseType;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder bankName(final String bankName) {
         this.bankName = bankName;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder website(final String website) {
         this.website = website;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder companyEmail(final String companyEmail) {
         this.companyEmail = companyEmail;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder companyPhone(final String companyPhone) {
         this.companyPhone = companyPhone;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder contacts(final List<SupplierContacts> contacts) {
         this.contacts = contacts;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder mainBusiness(final String mainBusiness) {
         this.mainBusiness = mainBusiness;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder boolHide(final Boolean boolHide) {
         this.boolHide = boolHide;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder supplierClassification(final Integer supplierClassification) {
         this.supplierClassification = supplierClassification;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder scoreRating(final String scoreRating) {
         this.scoreRating = scoreRating;
         return this;
      }

      public SupplierDetailDTO.SupplierDetailDTOBuilder scmSupplierConfigDTO(final ScmSupplierConfigDTO scmSupplierConfigDTO) {
         this.scmSupplierConfigDTO = scmSupplierConfigDTO;
         return this;
      }

      public SupplierDetailDTO build() {
         return new SupplierDetailDTO(
            this.id,
            this.name,
            this.shortName,
            this.supplierNumber,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.address,
            this.socialCode,
            this.registrationDate,
            this.businessTerm,
            this.legalRepresentative,
            this.registeredCapital,
            this.enterpriseType,
            this.bankName,
            this.bankAccount,
            this.website,
            this.companyEmail,
            this.companyPhone,
            this.contacts,
            this.mainBusiness,
            this.attachments,
            this.boolHide,
            this.supplierClassification,
            this.scoreRating,
            this.scmSupplierConfigDTO
         );
      }

      @Override
      public String toString() {
         return "SupplierDetailDTO.SupplierDetailDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", supplierNumber="
            + this.supplierNumber
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", address="
            + this.address
            + ", socialCode="
            + this.socialCode
            + ", registrationDate="
            + this.registrationDate
            + ", businessTerm="
            + this.businessTerm
            + ", legalRepresentative="
            + this.legalRepresentative
            + ", registeredCapital="
            + this.registeredCapital
            + ", enterpriseType="
            + this.enterpriseType
            + ", bankName="
            + this.bankName
            + ", bankAccount="
            + this.bankAccount
            + ", website="
            + this.website
            + ", companyEmail="
            + this.companyEmail
            + ", companyPhone="
            + this.companyPhone
            + ", contacts="
            + this.contacts
            + ", mainBusiness="
            + this.mainBusiness
            + ", attachments="
            + this.attachments
            + ", boolHide="
            + this.boolHide
            + ", supplierClassification="
            + this.supplierClassification
            + ", scoreRating="
            + this.scoreRating
            + ", scmSupplierConfigDTO="
            + this.scmSupplierConfigDTO
            + ")";
      }
   }
}
