package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import com.hzchum.scim.scm.core.api.pojo._do.SupplierContacts;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SupplierDTOParam implements Serializable {
   private Long id;
   @NotBlank(message = "供应商名称不能为空")
   private String name;
   private String shortName;
   private String supplierNumber;
   private Long countryId;
   private Long provinceId;
   private Long cityId;
   private Long regionId;
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
   private List<Long> attachments;
   @NotNull(message = "供应商分类不能为空")
   private Integer supplierClassification;
   private Integer createSource;
   @ApiModelProperty(name = "classifyId", value = "分类id", notes = "分类id")
   private Long classifyId;
   @ApiModelProperty(name = "qualificationsId", value = "资质id", notes = "资质id")
   private Long qualificationsId;

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

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
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

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public Integer getCreateSource() {
      return this.createSource;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getQualificationsId() {
      return this.qualificationsId;
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

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
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

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   public void setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
   }

   public void setCreateSource(final Integer createSource) {
      this.createSource = createSource;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setQualificationsId(final Long qualificationsId) {
      this.qualificationsId = qualificationsId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierDTOParam)) {
         return false;
      }

      SupplierDTOParam other = (SupplierDTOParam)o;
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
                     Object this$supplierClassification = this.getSupplierClassification();
                     Object other$supplierClassification = other.getSupplierClassification();
                     if (this$supplierClassification == null
                        ? other$supplierClassification == null
                        : this$supplierClassification.equals(other$supplierClassification)) {
                        Object this$createSource = this.getCreateSource();
                        Object other$createSource = other.getCreateSource();
                        if (this$createSource == null ? other$createSource == null : this$createSource.equals(other$createSource)) {
                           Object this$classifyId = this.getClassifyId();
                           Object other$classifyId = other.getClassifyId();
                           if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                              Object this$qualificationsId = this.getQualificationsId();
                              Object other$qualificationsId = other.getQualificationsId();
                              if (this$qualificationsId == null ? other$qualificationsId == null : this$qualificationsId.equals(other$qualificationsId)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$shortName = this.getShortName();
                                    Object other$shortName = other.getShortName();
                                    if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                       Object this$supplierNumber = this.getSupplierNumber();
                                       Object other$supplierNumber = other.getSupplierNumber();
                                       if (this$supplierNumber == null ? other$supplierNumber == null : this$supplierNumber.equals(other$supplierNumber)) {
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
                                                   if (this$businessTerm == null ? other$businessTerm == null : this$businessTerm.equals(other$businessTerm)) {
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
                                                                     if (this$website == null ? other$website == null : this$website.equals(other$website)) {
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
                                                                                    return this$attachments == null
                                                                                       ? other$attachments == null
                                                                                       : this$attachments.equals(other$attachments);
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
      return other instanceof SupplierDTOParam;
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
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $createSource = this.getCreateSource();
      result = result * 59 + ($createSource == null ? 43 : $createSource.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $qualificationsId = this.getQualificationsId();
      result = result * 59 + ($qualificationsId == null ? 43 : $qualificationsId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
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
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", supplierNumber="
         + this.getSupplierNumber()
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
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
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", createSource="
         + this.getCreateSource()
         + ", classifyId="
         + this.getClassifyId()
         + ", qualificationsId="
         + this.getQualificationsId()
         + ")";
   }
}
