package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CrmBiddingPlatformWarehousingPageDTO {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "biddingPlatformName", value = "招标平台名称", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "createTime", notes = "下达日期")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目信息备案id", notes = "项目信息备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目信息备案名称", notes = "项目信息备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
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
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "attachmentIdsList", value = "附件id", notes = "附件id")
   private String attachmentIdsList;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   private String reasonForRegistration;
   @ApiModelProperty(name = "informantUserName", value = "下发人（由于配置原因用informantUserName）", notes = "下发人（由于配置原因用informantUserName）")
   private String informantUserName;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "crmRecordTypeEnum", value = "备案状态", notes = "备案状态")
   private Integer crmRecordTypeEnum;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   private LocalDate caLockDate;

   public static CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder builder() {
      return new CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder();
   }

   public CrmBiddingPlatformWarehousingPageDTO() {
   }

   public CrmBiddingPlatformWarehousingPageDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String biddingPlatformName,
      final LocalDateTime createTime,
      final String createUserName,
      final Long crmEnterpriseWarehousingId,
      final String crmEnterpriseWarehousingName,
      final String address,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final List<Long> regionList,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String regionNameList,
      final List<AttachmentDTO> attachmentIds,
      final String attachmentIdsList,
      final String reasonForRegistration,
      final String informantUserName,
      final String businessPhone,
      final Integer crmRecordTypeEnum,
      final LocalDate caLockDate
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.biddingPlatformName = biddingPlatformName;
      this.createTime = createTime;
      this.createUserName = createUserName;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.address = address;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.regionList = regionList;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.regionNameList = regionNameList;
      this.attachmentIds = attachmentIds;
      this.attachmentIdsList = attachmentIdsList;
      this.reasonForRegistration = reasonForRegistration;
      this.informantUserName = informantUserName;
      this.businessPhone = businessPhone;
      this.crmRecordTypeEnum = crmRecordTypeEnum;
      this.caLockDate = caLockDate;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public String getAddress() {
      return this.address;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public List<Long> getRegionList() {
      return this.regionList;
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

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAttachmentIdsList() {
      return this.attachmentIdsList;
   }

   public String getReasonForRegistration() {
      return this.reasonForRegistration;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public Integer getCrmRecordTypeEnum() {
      return this.crmRecordTypeEnum;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public CrmBiddingPlatformWarehousingPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setAttachmentIdsList(final String attachmentIdsList) {
      this.attachmentIdsList = attachmentIdsList;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCrmRecordTypeEnum(final Integer crmRecordTypeEnum) {
      this.crmRecordTypeEnum = crmRecordTypeEnum;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDTO setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformWarehousingPageDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", createTime="
         + this.getCreateTime()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", address="
         + this.getAddress()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", regionList="
         + this.getRegionList()
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
         + ", regionNameList="
         + this.getRegionNameList()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentIdsList="
         + this.getAttachmentIdsList()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", crmRecordTypeEnum="
         + this.getCrmRecordTypeEnum()
         + ", caLockDate="
         + this.getCaLockDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingPlatformWarehousingPageDTO)) {
         return false;
      }

      CrmBiddingPlatformWarehousingPageDTO other = (CrmBiddingPlatformWarehousingPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
         Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
         if (this$crmEnterpriseWarehousingId == null
            ? other$crmEnterpriseWarehousingId == null
            : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
            Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
            Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
            if (this$crmProjectInformationWarehousingId == null
               ? other$crmProjectInformationWarehousingId == null
               : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
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
                           Object this$crmRecordTypeEnum = this.getCrmRecordTypeEnum();
                           Object other$crmRecordTypeEnum = other.getCrmRecordTypeEnum();
                           if (this$crmRecordTypeEnum == null ? other$crmRecordTypeEnum == null : this$crmRecordTypeEnum.equals(other$crmRecordTypeEnum)) {
                              Object this$informantDateTime = this.getInformantDateTime();
                              Object other$informantDateTime = other.getInformantDateTime();
                              if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                                 Object this$biddingPlatformName = this.getBiddingPlatformName();
                                 Object other$biddingPlatformName = other.getBiddingPlatformName();
                                 if (this$biddingPlatformName == null
                                    ? other$biddingPlatformName == null
                                    : this$biddingPlatformName.equals(other$biddingPlatformName)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                       Object this$createUserName = this.getCreateUserName();
                                       Object other$createUserName = other.getCreateUserName();
                                       if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                          Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                          Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                          if (this$crmEnterpriseWarehousingName == null
                                             ? other$crmEnterpriseWarehousingName == null
                                             : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                             Object this$address = this.getAddress();
                                             Object other$address = other.getAddress();
                                             if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                                                Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                                                if (this$crmProjectInformationWarehousingName == null
                                                   ? other$crmProjectInformationWarehousingName == null
                                                   : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                                                   Object this$regionList = this.getRegionList();
                                                   Object other$regionList = other.getRegionList();
                                                   if (this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList)) {
                                                      Object this$countryName = this.getCountryName();
                                                      Object other$countryName = other.getCountryName();
                                                      if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                                                         Object this$provinceName = this.getProvinceName();
                                                         Object other$provinceName = other.getProvinceName();
                                                         if (this$provinceName == null
                                                            ? other$provinceName == null
                                                            : this$provinceName.equals(other$provinceName)) {
                                                            Object this$cityName = this.getCityName();
                                                            Object other$cityName = other.getCityName();
                                                            if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
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
                                                                     Object this$attachmentIds = this.getAttachmentIds();
                                                                     Object other$attachmentIds = other.getAttachmentIds();
                                                                     if (this$attachmentIds == null
                                                                        ? other$attachmentIds == null
                                                                        : this$attachmentIds.equals(other$attachmentIds)) {
                                                                        Object this$attachmentIdsList = this.getAttachmentIdsList();
                                                                        Object other$attachmentIdsList = other.getAttachmentIdsList();
                                                                        if (this$attachmentIdsList == null
                                                                           ? other$attachmentIdsList == null
                                                                           : this$attachmentIdsList.equals(other$attachmentIdsList)) {
                                                                           Object this$reasonForRegistration = this.getReasonForRegistration();
                                                                           Object other$reasonForRegistration = other.getReasonForRegistration();
                                                                           if (this$reasonForRegistration == null
                                                                              ? other$reasonForRegistration == null
                                                                              : this$reasonForRegistration.equals(other$reasonForRegistration)) {
                                                                              Object this$informantUserName = this.getInformantUserName();
                                                                              Object other$informantUserName = other.getInformantUserName();
                                                                              if (this$informantUserName == null
                                                                                 ? other$informantUserName == null
                                                                                 : this$informantUserName.equals(other$informantUserName)) {
                                                                                 Object this$businessPhone = this.getBusinessPhone();
                                                                                 Object other$businessPhone = other.getBusinessPhone();
                                                                                 if (this$businessPhone == null
                                                                                    ? other$businessPhone == null
                                                                                    : this$businessPhone.equals(other$businessPhone)) {
                                                                                    Object this$caLockDate = this.getCaLockDate();
                                                                                    Object other$caLockDate = other.getCaLockDate();
                                                                                    return this$caLockDate == null
                                                                                       ? other$caLockDate == null
                                                                                       : this$caLockDate.equals(other$caLockDate);
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
      return other instanceof CrmBiddingPlatformWarehousingPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $crmRecordTypeEnum = this.getCrmRecordTypeEnum();
      result = result * 59 + ($crmRecordTypeEnum == null ? 43 : $crmRecordTypeEnum.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentIdsList = this.getAttachmentIdsList();
      result = result * 59 + ($attachmentIdsList == null ? 43 : $attachmentIdsList.hashCode());
      Object $reasonForRegistration = this.getReasonForRegistration();
      result = result * 59 + ($reasonForRegistration == null ? 43 : $reasonForRegistration.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $caLockDate = this.getCaLockDate();
      return result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
   }

   public static class CrmBiddingPlatformWarehousingPageDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String biddingPlatformName;
      private LocalDateTime createTime;
      private String createUserName;
      private Long crmEnterpriseWarehousingId;
      private String crmEnterpriseWarehousingName;
      private String address;
      private Long crmProjectInformationWarehousingId;
      private String crmProjectInformationWarehousingName;
      private List<Long> regionList;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String regionNameList;
      private List<AttachmentDTO> attachmentIds;
      private String attachmentIdsList;
      private String reasonForRegistration;
      private String informantUserName;
      private String businessPhone;
      private Integer crmRecordTypeEnum;
      private LocalDate caLockDate;

      CrmBiddingPlatformWarehousingPageDTOBuilder() {
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder biddingPlatformName(final String biddingPlatformName) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder crmEnterpriseWarehousingName(
         final String crmEnterpriseWarehousingName
      ) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder attachmentIdsList(final String attachmentIdsList) {
         this.attachmentIdsList = attachmentIdsList;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder reasonForRegistration(final String reasonForRegistration) {
         this.reasonForRegistration = reasonForRegistration;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder crmRecordTypeEnum(final Integer crmRecordTypeEnum) {
         this.crmRecordTypeEnum = crmRecordTypeEnum;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDTO build() {
         return new CrmBiddingPlatformWarehousingPageDTO(
            this.id,
            this.informantDateTime,
            this.biddingPlatformName,
            this.createTime,
            this.createUserName,
            this.crmEnterpriseWarehousingId,
            this.crmEnterpriseWarehousingName,
            this.address,
            this.crmProjectInformationWarehousingId,
            this.crmProjectInformationWarehousingName,
            this.regionList,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.regionNameList,
            this.attachmentIds,
            this.attachmentIdsList,
            this.reasonForRegistration,
            this.informantUserName,
            this.businessPhone,
            this.crmRecordTypeEnum,
            this.caLockDate
         );
      }

      @Override
      public String toString() {
         return "CrmBiddingPlatformWarehousingPageDTO.CrmBiddingPlatformWarehousingPageDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", createTime="
            + this.createTime
            + ", createUserName="
            + this.createUserName
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", address="
            + this.address
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", regionList="
            + this.regionList
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
            + ", regionNameList="
            + this.regionNameList
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentIdsList="
            + this.attachmentIdsList
            + ", reasonForRegistration="
            + this.reasonForRegistration
            + ", informantUserName="
            + this.informantUserName
            + ", businessPhone="
            + this.businessPhone
            + ", crmRecordTypeEnum="
            + this.crmRecordTypeEnum
            + ", caLockDate="
            + this.caLockDate
            + ")";
      }
   }
}
