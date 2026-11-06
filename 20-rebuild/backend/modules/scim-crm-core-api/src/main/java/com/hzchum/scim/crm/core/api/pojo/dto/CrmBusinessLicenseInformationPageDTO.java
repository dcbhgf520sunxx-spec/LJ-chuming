package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmBusinessLicenseInformationPageDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "companyName", value = "公司名称", notes = "公司名称")
   private String companyName;
   @ApiModelProperty(name = "creditCode", value = "统一社会信用代码", notes = "统一社会信用代码")
   private String creditCode;
   @ApiModelProperty(name = "orgNumber", value = "组织机构代码", notes = "组织机构代码")
   private String orgNumber;
   @ApiModelProperty(name = "companyType", value = "企业类型", notes = "企业类型")
   private String companyType;
   @ApiModelProperty(name = "keyPersonName", value = "法人", notes = "法人")
   private String keyPersonName;
   @ApiModelProperty(name = "keyPersonType", value = "法人类型", notes = "法人类型")
   private String keyPersonType;
   @ApiModelProperty(name = "regCapital", value = "注册资本", notes = "注册资本")
   private String regCapital;
   @ApiModelProperty(name = "actualCapital", value = "实缴资本", notes = "实缴资本")
   private String actualCapital;
   @ApiModelProperty(name = "province", value = "省份名称", notes = "省份名称")
   private String province;
   @ApiModelProperty(name = "province_id", value = "省份id", notes = "省份id")
   private Long provinceId;
   @ApiModelProperty(name = "city", value = "城市名称", notes = "城市名称")
   private String city;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "district", value = "区县名称", notes = "区县名称")
   private String district;
   @ApiModelProperty(name = "districtId", value = "区县id", notes = "区县id")
   private Long districtId;
   @ApiModelProperty(name = "regNumber", value = "注册号", notes = "注册号")
   private String regNumber;
   @ApiModelProperty(name = "authority", value = "登记机关", notes = "登记机关")
   private String authority;
   @ApiModelProperty(name = "regLocation", value = "注册地址", notes = "注册地址")
   private String regLocation;
   @ApiModelProperty(name = "regStatus", value = "运营状态", notes = "运营状态")
   private String regStatus;
   @ApiModelProperty(name = "businessScope", value = "经营范围", notes = "经营范围")
   private String businessScope;
   @ApiModelProperty(name = "establishTime", value = "成立时间", notes = "成立时间")
   private String establishTime;
   @ApiModelProperty(name = "approvedTime", value = "核准日期", notes = "核准日期")
   private String approvedTime;
   @ApiModelProperty(name = "termStart", value = "运营时间从", notes = "运营时间从")
   private String termStart;
   @ApiModelProperty(name = "termEnd", value = "运营商时间至", notes = "运营商时间至")
   private String termEnd;
   @ApiModelProperty(name = "lastUpdatedTime", value = "更新时间", notes = "更新时间")
   private String lastUpdatedTime;
   @ApiModelProperty(name = "historyNames", value = "历史曾用名", notes = "历史曾用名")
   private String historyNames;
   @ApiModelProperty(name = "industry", value = "行业门类描述", notes = "行业门类描述")
   private String industry;
   @ApiModelProperty(name = "subIndustry", value = "行业大类描述", notes = "行业大类描述")
   private String subIndustry;
   @ApiModelProperty(name = "middleCategory", value = "行业中类描述", notes = "行业中类描述")
   private String middleCategory;
   @ApiModelProperty(name = "smallCategory", value = "行业小类描述", notes = "行业小类描述")
   private String smallCategory;
   @ApiModelProperty(name = "address", value = "联系地址", notes = "联系地址")
   private String address;
   @ApiModelProperty(name = "phoneNumber", value = "电话号码", notes = "电话号码")
   private String phoneNumber;
   @ApiModelProperty(name = "email", value = "邮箱", notes = "邮箱")
   private String email;

   public static CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder builder() {
      return new CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder();
   }

   public CrmBusinessLicenseInformationPageDTO() {
   }

   public CrmBusinessLicenseInformationPageDTO(
      final Long id,
      final String companyName,
      final String creditCode,
      final String orgNumber,
      final String companyType,
      final String keyPersonName,
      final String keyPersonType,
      final String regCapital,
      final String actualCapital,
      final String province,
      final Long provinceId,
      final String city,
      final Long cityId,
      final String district,
      final Long districtId,
      final String regNumber,
      final String authority,
      final String regLocation,
      final String regStatus,
      final String businessScope,
      final String establishTime,
      final String approvedTime,
      final String termStart,
      final String termEnd,
      final String lastUpdatedTime,
      final String historyNames,
      final String industry,
      final String subIndustry,
      final String middleCategory,
      final String smallCategory,
      final String address,
      final String phoneNumber,
      final String email
   ) {
      this.id = id;
      this.companyName = companyName;
      this.creditCode = creditCode;
      this.orgNumber = orgNumber;
      this.companyType = companyType;
      this.keyPersonName = keyPersonName;
      this.keyPersonType = keyPersonType;
      this.regCapital = regCapital;
      this.actualCapital = actualCapital;
      this.province = province;
      this.provinceId = provinceId;
      this.city = city;
      this.cityId = cityId;
      this.district = district;
      this.districtId = districtId;
      this.regNumber = regNumber;
      this.authority = authority;
      this.regLocation = regLocation;
      this.regStatus = regStatus;
      this.businessScope = businessScope;
      this.establishTime = establishTime;
      this.approvedTime = approvedTime;
      this.termStart = termStart;
      this.termEnd = termEnd;
      this.lastUpdatedTime = lastUpdatedTime;
      this.historyNames = historyNames;
      this.industry = industry;
      this.subIndustry = subIndustry;
      this.middleCategory = middleCategory;
      this.smallCategory = smallCategory;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.email = email;
   }

   public Long getId() {
      return this.id;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public String getOrgNumber() {
      return this.orgNumber;
   }

   public String getCompanyType() {
      return this.companyType;
   }

   public String getKeyPersonName() {
      return this.keyPersonName;
   }

   public String getKeyPersonType() {
      return this.keyPersonType;
   }

   public String getRegCapital() {
      return this.regCapital;
   }

   public String getActualCapital() {
      return this.actualCapital;
   }

   public String getProvince() {
      return this.province;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getCity() {
      return this.city;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getDistrict() {
      return this.district;
   }

   public Long getDistrictId() {
      return this.districtId;
   }

   public String getRegNumber() {
      return this.regNumber;
   }

   public String getAuthority() {
      return this.authority;
   }

   public String getRegLocation() {
      return this.regLocation;
   }

   public String getRegStatus() {
      return this.regStatus;
   }

   public String getBusinessScope() {
      return this.businessScope;
   }

   public String getEstablishTime() {
      return this.establishTime;
   }

   public String getApprovedTime() {
      return this.approvedTime;
   }

   public String getTermStart() {
      return this.termStart;
   }

   public String getTermEnd() {
      return this.termEnd;
   }

   public String getLastUpdatedTime() {
      return this.lastUpdatedTime;
   }

   public String getHistoryNames() {
      return this.historyNames;
   }

   public String getIndustry() {
      return this.industry;
   }

   public String getSubIndustry() {
      return this.subIndustry;
   }

   public String getMiddleCategory() {
      return this.middleCategory;
   }

   public String getSmallCategory() {
      return this.smallCategory;
   }

   public String getAddress() {
      return this.address;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public String getEmail() {
      return this.email;
   }

   public CrmBusinessLicenseInformationPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setOrgNumber(final String orgNumber) {
      this.orgNumber = orgNumber;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setCompanyType(final String companyType) {
      this.companyType = companyType;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setKeyPersonName(final String keyPersonName) {
      this.keyPersonName = keyPersonName;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setKeyPersonType(final String keyPersonType) {
      this.keyPersonType = keyPersonType;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setRegCapital(final String regCapital) {
      this.regCapital = regCapital;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setActualCapital(final String actualCapital) {
      this.actualCapital = actualCapital;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setProvince(final String province) {
      this.province = province;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setCity(final String city) {
      this.city = city;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setDistrict(final String district) {
      this.district = district;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setDistrictId(final Long districtId) {
      this.districtId = districtId;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setRegNumber(final String regNumber) {
      this.regNumber = regNumber;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setAuthority(final String authority) {
      this.authority = authority;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setRegLocation(final String regLocation) {
      this.regLocation = regLocation;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setRegStatus(final String regStatus) {
      this.regStatus = regStatus;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setBusinessScope(final String businessScope) {
      this.businessScope = businessScope;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setEstablishTime(final String establishTime) {
      this.establishTime = establishTime;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setApprovedTime(final String approvedTime) {
      this.approvedTime = approvedTime;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setTermStart(final String termStart) {
      this.termStart = termStart;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setTermEnd(final String termEnd) {
      this.termEnd = termEnd;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setLastUpdatedTime(final String lastUpdatedTime) {
      this.lastUpdatedTime = lastUpdatedTime;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setHistoryNames(final String historyNames) {
      this.historyNames = historyNames;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setIndustry(final String industry) {
      this.industry = industry;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setSubIndustry(final String subIndustry) {
      this.subIndustry = subIndustry;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setMiddleCategory(final String middleCategory) {
      this.middleCategory = middleCategory;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setSmallCategory(final String smallCategory) {
      this.smallCategory = smallCategory;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setPhoneNumber(final String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
   }

   public CrmBusinessLicenseInformationPageDTO setEmail(final String email) {
      this.email = email;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBusinessLicenseInformationPageDTO(id="
         + this.getId()
         + ", companyName="
         + this.getCompanyName()
         + ", creditCode="
         + this.getCreditCode()
         + ", orgNumber="
         + this.getOrgNumber()
         + ", companyType="
         + this.getCompanyType()
         + ", keyPersonName="
         + this.getKeyPersonName()
         + ", keyPersonType="
         + this.getKeyPersonType()
         + ", regCapital="
         + this.getRegCapital()
         + ", actualCapital="
         + this.getActualCapital()
         + ", province="
         + this.getProvince()
         + ", provinceId="
         + this.getProvinceId()
         + ", city="
         + this.getCity()
         + ", cityId="
         + this.getCityId()
         + ", district="
         + this.getDistrict()
         + ", districtId="
         + this.getDistrictId()
         + ", regNumber="
         + this.getRegNumber()
         + ", authority="
         + this.getAuthority()
         + ", regLocation="
         + this.getRegLocation()
         + ", regStatus="
         + this.getRegStatus()
         + ", businessScope="
         + this.getBusinessScope()
         + ", establishTime="
         + this.getEstablishTime()
         + ", approvedTime="
         + this.getApprovedTime()
         + ", termStart="
         + this.getTermStart()
         + ", termEnd="
         + this.getTermEnd()
         + ", lastUpdatedTime="
         + this.getLastUpdatedTime()
         + ", historyNames="
         + this.getHistoryNames()
         + ", industry="
         + this.getIndustry()
         + ", subIndustry="
         + this.getSubIndustry()
         + ", middleCategory="
         + this.getMiddleCategory()
         + ", smallCategory="
         + this.getSmallCategory()
         + ", address="
         + this.getAddress()
         + ", phoneNumber="
         + this.getPhoneNumber()
         + ", email="
         + this.getEmail()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBusinessLicenseInformationPageDTO)) {
         return false;
      }

      CrmBusinessLicenseInformationPageDTO other = (CrmBusinessLicenseInformationPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$provinceId = this.getProvinceId();
         Object other$provinceId = other.getProvinceId();
         if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
            Object this$cityId = this.getCityId();
            Object other$cityId = other.getCityId();
            if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
               Object this$districtId = this.getDistrictId();
               Object other$districtId = other.getDistrictId();
               if (this$districtId == null ? other$districtId == null : this$districtId.equals(other$districtId)) {
                  Object this$companyName = this.getCompanyName();
                  Object other$companyName = other.getCompanyName();
                  if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                     Object this$creditCode = this.getCreditCode();
                     Object other$creditCode = other.getCreditCode();
                     if (this$creditCode == null ? other$creditCode == null : this$creditCode.equals(other$creditCode)) {
                        Object this$orgNumber = this.getOrgNumber();
                        Object other$orgNumber = other.getOrgNumber();
                        if (this$orgNumber == null ? other$orgNumber == null : this$orgNumber.equals(other$orgNumber)) {
                           Object this$companyType = this.getCompanyType();
                           Object other$companyType = other.getCompanyType();
                           if (this$companyType == null ? other$companyType == null : this$companyType.equals(other$companyType)) {
                              Object this$keyPersonName = this.getKeyPersonName();
                              Object other$keyPersonName = other.getKeyPersonName();
                              if (this$keyPersonName == null ? other$keyPersonName == null : this$keyPersonName.equals(other$keyPersonName)) {
                                 Object this$keyPersonType = this.getKeyPersonType();
                                 Object other$keyPersonType = other.getKeyPersonType();
                                 if (this$keyPersonType == null ? other$keyPersonType == null : this$keyPersonType.equals(other$keyPersonType)) {
                                    Object this$regCapital = this.getRegCapital();
                                    Object other$regCapital = other.getRegCapital();
                                    if (this$regCapital == null ? other$regCapital == null : this$regCapital.equals(other$regCapital)) {
                                       Object this$actualCapital = this.getActualCapital();
                                       Object other$actualCapital = other.getActualCapital();
                                       if (this$actualCapital == null ? other$actualCapital == null : this$actualCapital.equals(other$actualCapital)) {
                                          Object this$province = this.getProvince();
                                          Object other$province = other.getProvince();
                                          if (this$province == null ? other$province == null : this$province.equals(other$province)) {
                                             Object this$city = this.getCity();
                                             Object other$city = other.getCity();
                                             if (this$city == null ? other$city == null : this$city.equals(other$city)) {
                                                Object this$district = this.getDistrict();
                                                Object other$district = other.getDistrict();
                                                if (this$district == null ? other$district == null : this$district.equals(other$district)) {
                                                   Object this$regNumber = this.getRegNumber();
                                                   Object other$regNumber = other.getRegNumber();
                                                   if (this$regNumber == null ? other$regNumber == null : this$regNumber.equals(other$regNumber)) {
                                                      Object this$authority = this.getAuthority();
                                                      Object other$authority = other.getAuthority();
                                                      if (this$authority == null ? other$authority == null : this$authority.equals(other$authority)) {
                                                         Object this$regLocation = this.getRegLocation();
                                                         Object other$regLocation = other.getRegLocation();
                                                         if (this$regLocation == null ? other$regLocation == null : this$regLocation.equals(other$regLocation)) {
                                                            Object this$regStatus = this.getRegStatus();
                                                            Object other$regStatus = other.getRegStatus();
                                                            if (this$regStatus == null ? other$regStatus == null : this$regStatus.equals(other$regStatus)) {
                                                               Object this$businessScope = this.getBusinessScope();
                                                               Object other$businessScope = other.getBusinessScope();
                                                               if (this$businessScope == null
                                                                  ? other$businessScope == null
                                                                  : this$businessScope.equals(other$businessScope)) {
                                                                  Object this$establishTime = this.getEstablishTime();
                                                                  Object other$establishTime = other.getEstablishTime();
                                                                  if (this$establishTime == null
                                                                     ? other$establishTime == null
                                                                     : this$establishTime.equals(other$establishTime)) {
                                                                     Object this$approvedTime = this.getApprovedTime();
                                                                     Object other$approvedTime = other.getApprovedTime();
                                                                     if (this$approvedTime == null
                                                                        ? other$approvedTime == null
                                                                        : this$approvedTime.equals(other$approvedTime)) {
                                                                        Object this$termStart = this.getTermStart();
                                                                        Object other$termStart = other.getTermStart();
                                                                        if (this$termStart == null
                                                                           ? other$termStart == null
                                                                           : this$termStart.equals(other$termStart)) {
                                                                           Object this$termEnd = this.getTermEnd();
                                                                           Object other$termEnd = other.getTermEnd();
                                                                           if (this$termEnd == null
                                                                              ? other$termEnd == null
                                                                              : this$termEnd.equals(other$termEnd)) {
                                                                              Object this$lastUpdatedTime = this.getLastUpdatedTime();
                                                                              Object other$lastUpdatedTime = other.getLastUpdatedTime();
                                                                              if (this$lastUpdatedTime == null
                                                                                 ? other$lastUpdatedTime == null
                                                                                 : this$lastUpdatedTime.equals(other$lastUpdatedTime)) {
                                                                                 Object this$historyNames = this.getHistoryNames();
                                                                                 Object other$historyNames = other.getHistoryNames();
                                                                                 if (this$historyNames == null
                                                                                    ? other$historyNames == null
                                                                                    : this$historyNames.equals(other$historyNames)) {
                                                                                    Object this$industry = this.getIndustry();
                                                                                    Object other$industry = other.getIndustry();
                                                                                    if (this$industry == null
                                                                                       ? other$industry == null
                                                                                       : this$industry.equals(other$industry)) {
                                                                                       Object this$subIndustry = this.getSubIndustry();
                                                                                       Object other$subIndustry = other.getSubIndustry();
                                                                                       if (this$subIndustry == null
                                                                                          ? other$subIndustry == null
                                                                                          : this$subIndustry.equals(other$subIndustry)) {
                                                                                          Object this$middleCategory = this.getMiddleCategory();
                                                                                          Object other$middleCategory = other.getMiddleCategory();
                                                                                          if (this$middleCategory == null
                                                                                             ? other$middleCategory == null
                                                                                             : this$middleCategory.equals(other$middleCategory)) {
                                                                                             Object this$smallCategory = this.getSmallCategory();
                                                                                             Object other$smallCategory = other.getSmallCategory();
                                                                                             if (this$smallCategory == null
                                                                                                ? other$smallCategory == null
                                                                                                : this$smallCategory.equals(other$smallCategory)) {
                                                                                                Object this$address = this.getAddress();
                                                                                                Object other$address = other.getAddress();
                                                                                                if (this$address == null
                                                                                                   ? other$address == null
                                                                                                   : this$address.equals(other$address)) {
                                                                                                   Object this$phoneNumber = this.getPhoneNumber();
                                                                                                   Object other$phoneNumber = other.getPhoneNumber();
                                                                                                   if (this$phoneNumber == null
                                                                                                      ? other$phoneNumber == null
                                                                                                      : this$phoneNumber.equals(other$phoneNumber)) {
                                                                                                      Object this$email = this.getEmail();
                                                                                                      Object other$email = other.getEmail();
                                                                                                      return this$email == null
                                                                                                         ? other$email == null
                                                                                                         : this$email.equals(other$email);
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
      return other instanceof CrmBusinessLicenseInformationPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $districtId = this.getDistrictId();
      result = result * 59 + ($districtId == null ? 43 : $districtId.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $orgNumber = this.getOrgNumber();
      result = result * 59 + ($orgNumber == null ? 43 : $orgNumber.hashCode());
      Object $companyType = this.getCompanyType();
      result = result * 59 + ($companyType == null ? 43 : $companyType.hashCode());
      Object $keyPersonName = this.getKeyPersonName();
      result = result * 59 + ($keyPersonName == null ? 43 : $keyPersonName.hashCode());
      Object $keyPersonType = this.getKeyPersonType();
      result = result * 59 + ($keyPersonType == null ? 43 : $keyPersonType.hashCode());
      Object $regCapital = this.getRegCapital();
      result = result * 59 + ($regCapital == null ? 43 : $regCapital.hashCode());
      Object $actualCapital = this.getActualCapital();
      result = result * 59 + ($actualCapital == null ? 43 : $actualCapital.hashCode());
      Object $province = this.getProvince();
      result = result * 59 + ($province == null ? 43 : $province.hashCode());
      Object $city = this.getCity();
      result = result * 59 + ($city == null ? 43 : $city.hashCode());
      Object $district = this.getDistrict();
      result = result * 59 + ($district == null ? 43 : $district.hashCode());
      Object $regNumber = this.getRegNumber();
      result = result * 59 + ($regNumber == null ? 43 : $regNumber.hashCode());
      Object $authority = this.getAuthority();
      result = result * 59 + ($authority == null ? 43 : $authority.hashCode());
      Object $regLocation = this.getRegLocation();
      result = result * 59 + ($regLocation == null ? 43 : $regLocation.hashCode());
      Object $regStatus = this.getRegStatus();
      result = result * 59 + ($regStatus == null ? 43 : $regStatus.hashCode());
      Object $businessScope = this.getBusinessScope();
      result = result * 59 + ($businessScope == null ? 43 : $businessScope.hashCode());
      Object $establishTime = this.getEstablishTime();
      result = result * 59 + ($establishTime == null ? 43 : $establishTime.hashCode());
      Object $approvedTime = this.getApprovedTime();
      result = result * 59 + ($approvedTime == null ? 43 : $approvedTime.hashCode());
      Object $termStart = this.getTermStart();
      result = result * 59 + ($termStart == null ? 43 : $termStart.hashCode());
      Object $termEnd = this.getTermEnd();
      result = result * 59 + ($termEnd == null ? 43 : $termEnd.hashCode());
      Object $lastUpdatedTime = this.getLastUpdatedTime();
      result = result * 59 + ($lastUpdatedTime == null ? 43 : $lastUpdatedTime.hashCode());
      Object $historyNames = this.getHistoryNames();
      result = result * 59 + ($historyNames == null ? 43 : $historyNames.hashCode());
      Object $industry = this.getIndustry();
      result = result * 59 + ($industry == null ? 43 : $industry.hashCode());
      Object $subIndustry = this.getSubIndustry();
      result = result * 59 + ($subIndustry == null ? 43 : $subIndustry.hashCode());
      Object $middleCategory = this.getMiddleCategory();
      result = result * 59 + ($middleCategory == null ? 43 : $middleCategory.hashCode());
      Object $smallCategory = this.getSmallCategory();
      result = result * 59 + ($smallCategory == null ? 43 : $smallCategory.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $phoneNumber = this.getPhoneNumber();
      result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
      Object $email = this.getEmail();
      return result * 59 + ($email == null ? 43 : $email.hashCode());
   }

   public static class CrmBusinessLicenseInformationPageDTOBuilder {
      private Long id;
      private String companyName;
      private String creditCode;
      private String orgNumber;
      private String companyType;
      private String keyPersonName;
      private String keyPersonType;
      private String regCapital;
      private String actualCapital;
      private String province;
      private Long provinceId;
      private String city;
      private Long cityId;
      private String district;
      private Long districtId;
      private String regNumber;
      private String authority;
      private String regLocation;
      private String regStatus;
      private String businessScope;
      private String establishTime;
      private String approvedTime;
      private String termStart;
      private String termEnd;
      private String lastUpdatedTime;
      private String historyNames;
      private String industry;
      private String subIndustry;
      private String middleCategory;
      private String smallCategory;
      private String address;
      private String phoneNumber;
      private String email;

      CrmBusinessLicenseInformationPageDTOBuilder() {
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder orgNumber(final String orgNumber) {
         this.orgNumber = orgNumber;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder companyType(final String companyType) {
         this.companyType = companyType;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder keyPersonName(final String keyPersonName) {
         this.keyPersonName = keyPersonName;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder keyPersonType(final String keyPersonType) {
         this.keyPersonType = keyPersonType;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder regCapital(final String regCapital) {
         this.regCapital = regCapital;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder actualCapital(final String actualCapital) {
         this.actualCapital = actualCapital;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder province(final String province) {
         this.province = province;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder city(final String city) {
         this.city = city;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder district(final String district) {
         this.district = district;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder districtId(final Long districtId) {
         this.districtId = districtId;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder regNumber(final String regNumber) {
         this.regNumber = regNumber;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder authority(final String authority) {
         this.authority = authority;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder regLocation(final String regLocation) {
         this.regLocation = regLocation;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder regStatus(final String regStatus) {
         this.regStatus = regStatus;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder businessScope(final String businessScope) {
         this.businessScope = businessScope;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder establishTime(final String establishTime) {
         this.establishTime = establishTime;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder approvedTime(final String approvedTime) {
         this.approvedTime = approvedTime;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder termStart(final String termStart) {
         this.termStart = termStart;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder termEnd(final String termEnd) {
         this.termEnd = termEnd;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder lastUpdatedTime(final String lastUpdatedTime) {
         this.lastUpdatedTime = lastUpdatedTime;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder historyNames(final String historyNames) {
         this.historyNames = historyNames;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder industry(final String industry) {
         this.industry = industry;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder subIndustry(final String subIndustry) {
         this.subIndustry = subIndustry;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder middleCategory(final String middleCategory) {
         this.middleCategory = middleCategory;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder smallCategory(final String smallCategory) {
         this.smallCategory = smallCategory;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder phoneNumber(final String phoneNumber) {
         this.phoneNumber = phoneNumber;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder email(final String email) {
         this.email = email;
         return this;
      }

      public CrmBusinessLicenseInformationPageDTO build() {
         return new CrmBusinessLicenseInformationPageDTO(
            this.id,
            this.companyName,
            this.creditCode,
            this.orgNumber,
            this.companyType,
            this.keyPersonName,
            this.keyPersonType,
            this.regCapital,
            this.actualCapital,
            this.province,
            this.provinceId,
            this.city,
            this.cityId,
            this.district,
            this.districtId,
            this.regNumber,
            this.authority,
            this.regLocation,
            this.regStatus,
            this.businessScope,
            this.establishTime,
            this.approvedTime,
            this.termStart,
            this.termEnd,
            this.lastUpdatedTime,
            this.historyNames,
            this.industry,
            this.subIndustry,
            this.middleCategory,
            this.smallCategory,
            this.address,
            this.phoneNumber,
            this.email
         );
      }

      @Override
      public String toString() {
         return "CrmBusinessLicenseInformationPageDTO.CrmBusinessLicenseInformationPageDTOBuilder(id="
            + this.id
            + ", companyName="
            + this.companyName
            + ", creditCode="
            + this.creditCode
            + ", orgNumber="
            + this.orgNumber
            + ", companyType="
            + this.companyType
            + ", keyPersonName="
            + this.keyPersonName
            + ", keyPersonType="
            + this.keyPersonType
            + ", regCapital="
            + this.regCapital
            + ", actualCapital="
            + this.actualCapital
            + ", province="
            + this.province
            + ", provinceId="
            + this.provinceId
            + ", city="
            + this.city
            + ", cityId="
            + this.cityId
            + ", district="
            + this.district
            + ", districtId="
            + this.districtId
            + ", regNumber="
            + this.regNumber
            + ", authority="
            + this.authority
            + ", regLocation="
            + this.regLocation
            + ", regStatus="
            + this.regStatus
            + ", businessScope="
            + this.businessScope
            + ", establishTime="
            + this.establishTime
            + ", approvedTime="
            + this.approvedTime
            + ", termStart="
            + this.termStart
            + ", termEnd="
            + this.termEnd
            + ", lastUpdatedTime="
            + this.lastUpdatedTime
            + ", historyNames="
            + this.historyNames
            + ", industry="
            + this.industry
            + ", subIndustry="
            + this.subIndustry
            + ", middleCategory="
            + this.middleCategory
            + ", smallCategory="
            + this.smallCategory
            + ", address="
            + this.address
            + ", phoneNumber="
            + this.phoneNumber
            + ", email="
            + this.email
            + ")";
      }
   }
}
