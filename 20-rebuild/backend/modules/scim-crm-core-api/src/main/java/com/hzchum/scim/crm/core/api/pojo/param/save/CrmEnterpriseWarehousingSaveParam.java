package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmEnterpriseWarehousingSaveParam {
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "unitPropertyAllocationConfigId", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private Long unitPropertyAllocationConfigId;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private Long unitClassConfigurationId;
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   private Long regionId;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "industryConfigurationId", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private Long industryConfigurationId;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   private String businessEmail;
   @ApiModelProperty(name = "liaisons", value = "联系人", notes = "联系人")
   private String liaisons;
   @ApiModelProperty(name = "qualificationAndAbility", value = "资质能力", notes = "资质能力")
   private String qualificationAndAbility;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids", notes = "附件ids")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "remark", value = "其他信息备注", notes = "其他信息备注")
   private String remark;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "unitReputationAllocationConfigId", value = "企业信誉  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   private Long unitReputationAllocationConfigId;

   public CrmEnterpriseWarehousingSaveParam(
      final Long informantUserId,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final String businessName,
      final Long unitPropertyAllocationConfigId,
      final Long unitClassConfigurationId,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final List<Long> regionList,
      final String regionName,
      final String address,
      final String creditCode,
      final Long industryConfigurationId,
      final String businessPhone,
      final String businessEmail,
      final String liaisons,
      final String qualificationAndAbility,
      final List<AttachmentDTO> attachmentIds,
      final String remark,
      final Integer crmCountryTypeEnum,
      final Long unitReputationAllocationConfigId
   ) {
      this.informantUserId = informantUserId;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.businessName = businessName;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionList = regionList;
      this.regionName = regionName;
      this.address = address;
      this.creditCode = creditCode;
      this.industryConfigurationId = industryConfigurationId;
      this.businessPhone = businessPhone;
      this.businessEmail = businessEmail;
      this.liaisons = liaisons;
      this.qualificationAndAbility = qualificationAndAbility;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
   }

   public CrmEnterpriseWarehousingSaveParam() {
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public Long getUnitPropertyAllocationConfigId() {
      return this.unitPropertyAllocationConfigId;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
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

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAddress() {
      return this.address;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public String getBusinessEmail() {
      return this.businessEmail;
   }

   public String getLiaisons() {
      return this.liaisons;
   }

   public String getQualificationAndAbility() {
      return this.qualificationAndAbility;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public Long getUnitReputationAllocationConfigId() {
      return this.unitReputationAllocationConfigId;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setBusinessName(final String businessName) {
      this.businessName = businessName;
   }

   public void setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
   }

   public void setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
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

   public void setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
   }

   public void setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
   }

   public void setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
   }

   public void setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
   }

   public void setLiaisons(final String liaisons) {
      this.liaisons = liaisons;
   }

   public void setQualificationAndAbility(final String qualificationAndAbility) {
      this.qualificationAndAbility = qualificationAndAbility;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
   }

   public void setUnitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseWarehousingSaveParam)) {
         return false;
      }

      CrmEnterpriseWarehousingSaveParam other = (CrmEnterpriseWarehousingSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$informantUserId = this.getInformantUserId();
      Object other$informantUserId = other.getInformantUserId();
      if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
            Object other$unitPropertyAllocationConfigId = other.getUnitPropertyAllocationConfigId();
            if (this$unitPropertyAllocationConfigId == null
               ? other$unitPropertyAllocationConfigId == null
               : this$unitPropertyAllocationConfigId.equals(other$unitPropertyAllocationConfigId)) {
               Object this$unitClassConfigurationId = this.getUnitClassConfigurationId();
               Object other$unitClassConfigurationId = other.getUnitClassConfigurationId();
               if (this$unitClassConfigurationId == null
                  ? other$unitClassConfigurationId == null
                  : this$unitClassConfigurationId.equals(other$unitClassConfigurationId)) {
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
                              Object this$industryConfigurationId = this.getIndustryConfigurationId();
                              Object other$industryConfigurationId = other.getIndustryConfigurationId();
                              if (this$industryConfigurationId == null
                                 ? other$industryConfigurationId == null
                                 : this$industryConfigurationId.equals(other$industryConfigurationId)) {
                                 Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                                 Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                                 if (this$crmCountryTypeEnum == null
                                    ? other$crmCountryTypeEnum == null
                                    : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
                                    Object this$unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
                                    Object other$unitReputationAllocationConfigId = other.getUnitReputationAllocationConfigId();
                                    if (this$unitReputationAllocationConfigId == null
                                       ? other$unitReputationAllocationConfigId == null
                                       : this$unitReputationAllocationConfigId.equals(other$unitReputationAllocationConfigId)) {
                                       Object this$informantDateTime = this.getInformantDateTime();
                                       Object other$informantDateTime = other.getInformantDateTime();
                                       if (this$informantDateTime == null
                                          ? other$informantDateTime == null
                                          : this$informantDateTime.equals(other$informantDateTime)) {
                                          Object this$businessName = this.getBusinessName();
                                          Object other$businessName = other.getBusinessName();
                                          if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
                                             Object this$countryName = this.getCountryName();
                                             Object other$countryName = other.getCountryName();
                                             if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                                                Object this$provinceName = this.getProvinceName();
                                                Object other$provinceName = other.getProvinceName();
                                                if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                                                   Object this$cityName = this.getCityName();
                                                   Object other$cityName = other.getCityName();
                                                   if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                                      Object this$regionList = this.getRegionList();
                                                      Object other$regionList = other.getRegionList();
                                                      if (this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList)) {
                                                         Object this$regionName = this.getRegionName();
                                                         Object other$regionName = other.getRegionName();
                                                         if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                                            Object this$address = this.getAddress();
                                                            Object other$address = other.getAddress();
                                                            if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                               Object this$creditCode = this.getCreditCode();
                                                               Object other$creditCode = other.getCreditCode();
                                                               if (this$creditCode == null
                                                                  ? other$creditCode == null
                                                                  : this$creditCode.equals(other$creditCode)) {
                                                                  Object this$businessPhone = this.getBusinessPhone();
                                                                  Object other$businessPhone = other.getBusinessPhone();
                                                                  if (this$businessPhone == null
                                                                     ? other$businessPhone == null
                                                                     : this$businessPhone.equals(other$businessPhone)) {
                                                                     Object this$businessEmail = this.getBusinessEmail();
                                                                     Object other$businessEmail = other.getBusinessEmail();
                                                                     if (this$businessEmail == null
                                                                        ? other$businessEmail == null
                                                                        : this$businessEmail.equals(other$businessEmail)) {
                                                                        Object this$liaisons = this.getLiaisons();
                                                                        Object other$liaisons = other.getLiaisons();
                                                                        if (this$liaisons == null
                                                                           ? other$liaisons == null
                                                                           : this$liaisons.equals(other$liaisons)) {
                                                                           Object this$qualificationAndAbility = this.getQualificationAndAbility();
                                                                           Object other$qualificationAndAbility = other.getQualificationAndAbility();
                                                                           if (this$qualificationAndAbility == null
                                                                              ? other$qualificationAndAbility == null
                                                                              : this$qualificationAndAbility.equals(other$qualificationAndAbility)) {
                                                                              Object this$attachmentIds = this.getAttachmentIds();
                                                                              Object other$attachmentIds = other.getAttachmentIds();
                                                                              if (this$attachmentIds == null
                                                                                 ? other$attachmentIds == null
                                                                                 : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 return this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark);
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
      return other instanceof CrmEnterpriseWarehousingSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
      result = result * 59 + ($unitPropertyAllocationConfigId == null ? 43 : $unitPropertyAllocationConfigId.hashCode());
      Object $unitClassConfigurationId = this.getUnitClassConfigurationId();
      result = result * 59 + ($unitClassConfigurationId == null ? 43 : $unitClassConfigurationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $industryConfigurationId = this.getIndustryConfigurationId();
      result = result * 59 + ($industryConfigurationId == null ? 43 : $industryConfigurationId.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
      result = result * 59 + ($unitReputationAllocationConfigId == null ? 43 : $unitReputationAllocationConfigId.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
      Object $liaisons = this.getLiaisons();
      result = result * 59 + ($liaisons == null ? 43 : $liaisons.hashCode());
      Object $qualificationAndAbility = this.getQualificationAndAbility();
      result = result * 59 + ($qualificationAndAbility == null ? 43 : $qualificationAndAbility.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmEnterpriseWarehousingSaveParam(informantUserId="
         + this.getInformantUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", businessName="
         + this.getBusinessName()
         + ", unitPropertyAllocationConfigId="
         + this.getUnitPropertyAllocationConfigId()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
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
         + ", regionList="
         + this.getRegionList()
         + ", regionName="
         + this.getRegionName()
         + ", address="
         + this.getAddress()
         + ", creditCode="
         + this.getCreditCode()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", businessEmail="
         + this.getBusinessEmail()
         + ", liaisons="
         + this.getLiaisons()
         + ", qualificationAndAbility="
         + this.getQualificationAndAbility()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", unitReputationAllocationConfigId="
         + this.getUnitReputationAllocationConfigId()
         + ")";
   }
}
