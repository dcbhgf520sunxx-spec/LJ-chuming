package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmBusinessLicenseInformationDetailDTO {
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
   @ApiModelProperty(name = "provinceCode", value = "省份代码", notes = "省份代码")
   private String provinceCode;
   @ApiModelProperty(name = "city", value = "城市名称", notes = "城市名称")
   private String city;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "cityCode", value = "城市代码", notes = "城市代码")
   private String cityCode;
   @ApiModelProperty(name = "district", value = "区县名称", notes = "区县名称")
   private String district;
   @ApiModelProperty(name = "districtId", value = "区县id", notes = "区县id")
   private Long districtId;
   @ApiModelProperty(name = "districtCode", value = "区县代码", notes = "区县代码")
   private String districtCode;
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
   @ApiModelProperty(name = "isFilingRecord", value = "是否拥有备案记录", notes = "是否拥有备案记录")
   private Boolean isFilingRecord;

   public CrmBusinessLicenseInformationDetailDTO(
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
      final String provinceCode,
      final String city,
      final Long cityId,
      final String cityCode,
      final String district,
      final Long districtId,
      final String districtCode,
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
      final String email,
      final Boolean isFilingRecord
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
      this.provinceCode = provinceCode;
      this.city = city;
      this.cityId = cityId;
      this.cityCode = cityCode;
      this.district = district;
      this.districtId = districtId;
      this.districtCode = districtCode;
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
      this.isFilingRecord = isFilingRecord;
   }

   public CrmBusinessLicenseInformationDetailDTO() {
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

   public String getProvinceCode() {
      return this.provinceCode;
   }

   public String getCity() {
      return this.city;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityCode() {
      return this.cityCode;
   }

   public String getDistrict() {
      return this.district;
   }

   public Long getDistrictId() {
      return this.districtId;
   }

   public String getDistrictCode() {
      return this.districtCode;
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

   public Boolean getIsFilingRecord() {
      return this.isFilingRecord;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
   }

   public void setOrgNumber(final String orgNumber) {
      this.orgNumber = orgNumber;
   }

   public void setCompanyType(final String companyType) {
      this.companyType = companyType;
   }

   public void setKeyPersonName(final String keyPersonName) {
      this.keyPersonName = keyPersonName;
   }

   public void setKeyPersonType(final String keyPersonType) {
      this.keyPersonType = keyPersonType;
   }

   public void setRegCapital(final String regCapital) {
      this.regCapital = regCapital;
   }

   public void setActualCapital(final String actualCapital) {
      this.actualCapital = actualCapital;
   }

   public void setProvince(final String province) {
      this.province = province;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceCode(final String provinceCode) {
      this.provinceCode = provinceCode;
   }

   public void setCity(final String city) {
      this.city = city;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityCode(final String cityCode) {
      this.cityCode = cityCode;
   }

   public void setDistrict(final String district) {
      this.district = district;
   }

   public void setDistrictId(final Long districtId) {
      this.districtId = districtId;
   }

   public void setDistrictCode(final String districtCode) {
      this.districtCode = districtCode;
   }

   public void setRegNumber(final String regNumber) {
      this.regNumber = regNumber;
   }

   public void setAuthority(final String authority) {
      this.authority = authority;
   }

   public void setRegLocation(final String regLocation) {
      this.regLocation = regLocation;
   }

   public void setRegStatus(final String regStatus) {
      this.regStatus = regStatus;
   }

   public void setBusinessScope(final String businessScope) {
      this.businessScope = businessScope;
   }

   public void setEstablishTime(final String establishTime) {
      this.establishTime = establishTime;
   }

   public void setApprovedTime(final String approvedTime) {
      this.approvedTime = approvedTime;
   }

   public void setTermStart(final String termStart) {
      this.termStart = termStart;
   }

   public void setTermEnd(final String termEnd) {
      this.termEnd = termEnd;
   }

   public void setLastUpdatedTime(final String lastUpdatedTime) {
      this.lastUpdatedTime = lastUpdatedTime;
   }

   public void setHistoryNames(final String historyNames) {
      this.historyNames = historyNames;
   }

   public void setIndustry(final String industry) {
      this.industry = industry;
   }

   public void setSubIndustry(final String subIndustry) {
      this.subIndustry = subIndustry;
   }

   public void setMiddleCategory(final String middleCategory) {
      this.middleCategory = middleCategory;
   }

   public void setSmallCategory(final String smallCategory) {
      this.smallCategory = smallCategory;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setPhoneNumber(final String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setIsFilingRecord(final Boolean isFilingRecord) {
      this.isFilingRecord = isFilingRecord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBusinessLicenseInformationDetailDTO)) {
         return false;
      }

      CrmBusinessLicenseInformationDetailDTO other = (CrmBusinessLicenseInformationDetailDTO)o;
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
                  Object this$isFilingRecord = this.getIsFilingRecord();
                  Object other$isFilingRecord = other.getIsFilingRecord();
                  if (this$isFilingRecord == null ? other$isFilingRecord == null : this$isFilingRecord.equals(other$isFilingRecord)) {
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
                                                Object this$provinceCode = this.getProvinceCode();
                                                Object other$provinceCode = other.getProvinceCode();
                                                if (this$provinceCode == null ? other$provinceCode == null : this$provinceCode.equals(other$provinceCode)) {
                                                   Object this$city = this.getCity();
                                                   Object other$city = other.getCity();
                                                   if (this$city == null ? other$city == null : this$city.equals(other$city)) {
                                                      Object this$cityCode = this.getCityCode();
                                                      Object other$cityCode = other.getCityCode();
                                                      if (this$cityCode == null ? other$cityCode == null : this$cityCode.equals(other$cityCode)) {
                                                         Object this$district = this.getDistrict();
                                                         Object other$district = other.getDistrict();
                                                         if (this$district == null ? other$district == null : this$district.equals(other$district)) {
                                                            Object this$districtCode = this.getDistrictCode();
                                                            Object other$districtCode = other.getDistrictCode();
                                                            if (this$districtCode == null
                                                               ? other$districtCode == null
                                                               : this$districtCode.equals(other$districtCode)) {
                                                               Object this$regNumber = this.getRegNumber();
                                                               Object other$regNumber = other.getRegNumber();
                                                               if (this$regNumber == null ? other$regNumber == null : this$regNumber.equals(other$regNumber)) {
                                                                  Object this$authority = this.getAuthority();
                                                                  Object other$authority = other.getAuthority();
                                                                  if (this$authority == null ? other$authority == null : this$authority.equals(other$authority)
                                                                     )
                                                                   {
                                                                     Object this$regLocation = this.getRegLocation();
                                                                     Object other$regLocation = other.getRegLocation();
                                                                     if (this$regLocation == null
                                                                        ? other$regLocation == null
                                                                        : this$regLocation.equals(other$regLocation)) {
                                                                        Object this$regStatus = this.getRegStatus();
                                                                        Object other$regStatus = other.getRegStatus();
                                                                        if (this$regStatus == null
                                                                           ? other$regStatus == null
                                                                           : this$regStatus.equals(other$regStatus)) {
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
      return other instanceof CrmBusinessLicenseInformationDetailDTO;
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
      Object $isFilingRecord = this.getIsFilingRecord();
      result = result * 59 + ($isFilingRecord == null ? 43 : $isFilingRecord.hashCode());
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
      Object $provinceCode = this.getProvinceCode();
      result = result * 59 + ($provinceCode == null ? 43 : $provinceCode.hashCode());
      Object $city = this.getCity();
      result = result * 59 + ($city == null ? 43 : $city.hashCode());
      Object $cityCode = this.getCityCode();
      result = result * 59 + ($cityCode == null ? 43 : $cityCode.hashCode());
      Object $district = this.getDistrict();
      result = result * 59 + ($district == null ? 43 : $district.hashCode());
      Object $districtCode = this.getDistrictCode();
      result = result * 59 + ($districtCode == null ? 43 : $districtCode.hashCode());
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

   @Override
   public String toString() {
      return "CrmBusinessLicenseInformationDetailDTO(id="
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
         + ", provinceCode="
         + this.getProvinceCode()
         + ", city="
         + this.getCity()
         + ", cityId="
         + this.getCityId()
         + ", cityCode="
         + this.getCityCode()
         + ", district="
         + this.getDistrict()
         + ", districtId="
         + this.getDistrictId()
         + ", districtCode="
         + this.getDistrictCode()
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
         + ", isFilingRecord="
         + this.getIsFilingRecord()
         + ")";
   }
}
