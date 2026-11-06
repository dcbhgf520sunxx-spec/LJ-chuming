package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CrmGovernmentWarehousingPageDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
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
   @ApiModelProperty(name = "regionList", value = "地区id集合", notes = "地区id集合")
   private List<Long> regionList;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "attachmentDTOS", value = "附件集合", notes = "附件集合")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty(name = "attachmentIds", value = "附件集合", notes = "附件集合")
   private String attachmentIds;
   @ApiModelProperty(name = "unitPropertyAllocationConfigId", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private Long unitPropertyAllocationConfigId;
   @ApiModelProperty(name = "unitPropertyAllocationConfigName", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private String unitPropertyAllocationConfigName;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private Long unitClassConfigurationId;
   @ApiModelProperty(name = "unitClassConfigurationName", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private String unitClassConfigurationName;
   @ApiModelProperty(name = "industryConfigurationId", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private Long industryConfigurationId;
   @ApiModelProperty(name = "industryConfigurationName", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private String industryConfigurationName;
   @ApiModelProperty(name = "unitReputationAllocationConfigId", value = "企业信誉  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   private Long unitReputationAllocationConfigId;
   @ApiModelProperty(name = "unitReputationAllocationConfigName", value = "企业信誉  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   private String unitReputationAllocationConfigName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   private String businessEmail;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   private LocalDate caLockDate;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;

   public static CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder builder() {
      return new CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder();
   }

   public CrmGovernmentWarehousingPageDTO() {
   }

   public CrmGovernmentWarehousingPageDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final Long crmEnterpriseWarehousingId,
      final String businessName,
      final String address,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final String creditCode,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final List<Long> regionList,
      final String regionNameList,
      final List<AttachmentDTO> attachmentDTOS,
      final String attachmentIds,
      final Long unitPropertyAllocationConfigId,
      final String unitPropertyAllocationConfigName,
      final Long unitClassConfigurationId,
      final String unitClassConfigurationName,
      final Long industryConfigurationId,
      final String industryConfigurationName,
      final Long unitReputationAllocationConfigId,
      final String unitReputationAllocationConfigName,
      final String informantUserName,
      final String businessPhone,
      final String businessEmail,
      final Integer crmCheckStatusEnum,
      final LocalDate caLockDate,
      final String createUserName
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.businessName = businessName;
      this.address = address;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.creditCode = creditCode;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.regionList = regionList;
      this.regionNameList = regionNameList;
      this.attachmentDTOS = attachmentDTOS;
      this.attachmentIds = attachmentIds;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.unitClassConfigurationName = unitClassConfigurationName;
      this.industryConfigurationId = industryConfigurationId;
      this.industryConfigurationName = industryConfigurationName;
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      this.informantUserName = informantUserName;
      this.businessPhone = businessPhone;
      this.businessEmail = businessEmail;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.caLockDate = caLockDate;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getBusinessName() {
      return this.businessName;
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

   public String getCreditCode() {
      return this.creditCode;
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

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Long getUnitPropertyAllocationConfigId() {
      return this.unitPropertyAllocationConfigId;
   }

   public String getUnitPropertyAllocationConfigName() {
      return this.unitPropertyAllocationConfigName;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
   }

   public String getUnitClassConfigurationName() {
      return this.unitClassConfigurationName;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
   }

   public Long getUnitReputationAllocationConfigId() {
      return this.unitReputationAllocationConfigId;
   }

   public String getUnitReputationAllocationConfigName() {
      return this.unitReputationAllocationConfigName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public String getBusinessEmail() {
      return this.businessEmail;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public CrmGovernmentWarehousingPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setUnitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setUnitReputationAllocationConfigName(final String unitReputationAllocationConfigName) {
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   public CrmGovernmentWarehousingPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmGovernmentWarehousingPageDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", businessName="
         + this.getBusinessName()
         + ", address="
         + this.getAddress()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", creditCode="
         + this.getCreditCode()
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
         + ", regionList="
         + this.getRegionList()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", unitPropertyAllocationConfigId="
         + this.getUnitPropertyAllocationConfigId()
         + ", unitPropertyAllocationConfigName="
         + this.getUnitPropertyAllocationConfigName()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
         + ", unitClassConfigurationName="
         + this.getUnitClassConfigurationName()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
         + ", unitReputationAllocationConfigId="
         + this.getUnitReputationAllocationConfigId()
         + ", unitReputationAllocationConfigName="
         + this.getUnitReputationAllocationConfigName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", businessEmail="
         + this.getBusinessEmail()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", caLockDate="
         + this.getCaLockDate()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentWarehousingPageDTO)) {
         return false;
      }

      CrmGovernmentWarehousingPageDTO other = (CrmGovernmentWarehousingPageDTO)o;
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
                                 Object this$industryConfigurationId = this.getIndustryConfigurationId();
                                 Object other$industryConfigurationId = other.getIndustryConfigurationId();
                                 if (this$industryConfigurationId == null
                                    ? other$industryConfigurationId == null
                                    : this$industryConfigurationId.equals(other$industryConfigurationId)) {
                                    Object this$unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
                                    Object other$unitReputationAllocationConfigId = other.getUnitReputationAllocationConfigId();
                                    if (this$unitReputationAllocationConfigId == null
                                       ? other$unitReputationAllocationConfigId == null
                                       : this$unitReputationAllocationConfigId.equals(other$unitReputationAllocationConfigId)) {
                                       Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                                       Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                                       if (this$crmCheckStatusEnum == null
                                          ? other$crmCheckStatusEnum == null
                                          : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                                          Object this$informantDateTime = this.getInformantDateTime();
                                          Object other$informantDateTime = other.getInformantDateTime();
                                          if (this$informantDateTime == null
                                             ? other$informantDateTime == null
                                             : this$informantDateTime.equals(other$informantDateTime)) {
                                             Object this$businessName = this.getBusinessName();
                                             Object other$businessName = other.getBusinessName();
                                             if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
                                                Object this$address = this.getAddress();
                                                Object other$address = other.getAddress();
                                                if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                   Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                                                   Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                                                   if (this$crmProjectInformationWarehousingName == null
                                                      ? other$crmProjectInformationWarehousingName == null
                                                      : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                                                      Object this$creditCode = this.getCreditCode();
                                                      Object other$creditCode = other.getCreditCode();
                                                      if (this$creditCode == null ? other$creditCode == null : this$creditCode.equals(other$creditCode)) {
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
                                                                     Object this$regionList = this.getRegionList();
                                                                     Object other$regionList = other.getRegionList();
                                                                     if (this$regionList == null
                                                                        ? other$regionList == null
                                                                        : this$regionList.equals(other$regionList)) {
                                                                        Object this$regionNameList = this.getRegionNameList();
                                                                        Object other$regionNameList = other.getRegionNameList();
                                                                        if (this$regionNameList == null
                                                                           ? other$regionNameList == null
                                                                           : this$regionNameList.equals(other$regionNameList)) {
                                                                           Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                                           Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                                           if (this$attachmentDTOS == null
                                                                              ? other$attachmentDTOS == null
                                                                              : this$attachmentDTOS.equals(other$attachmentDTOS)) {
                                                                              Object this$attachmentIds = this.getAttachmentIds();
                                                                              Object other$attachmentIds = other.getAttachmentIds();
                                                                              if (this$attachmentIds == null
                                                                                 ? other$attachmentIds == null
                                                                                 : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                 Object this$unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
                                                                                 Object other$unitPropertyAllocationConfigName = other.getUnitPropertyAllocationConfigName();
                                                                                 if (this$unitPropertyAllocationConfigName == null
                                                                                    ? other$unitPropertyAllocationConfigName == null
                                                                                    : this$unitPropertyAllocationConfigName.equals(
                                                                                       other$unitPropertyAllocationConfigName
                                                                                    )) {
                                                                                    Object this$unitClassConfigurationName = this.getUnitClassConfigurationName();
                                                                                    Object other$unitClassConfigurationName = other.getUnitClassConfigurationName();
                                                                                    if (this$unitClassConfigurationName == null
                                                                                       ? other$unitClassConfigurationName == null
                                                                                       : this$unitClassConfigurationName.equals(
                                                                                          other$unitClassConfigurationName
                                                                                       )) {
                                                                                       Object this$industryConfigurationName = this.getIndustryConfigurationName();
                                                                                       Object other$industryConfigurationName = other.getIndustryConfigurationName();
                                                                                       if (this$industryConfigurationName == null
                                                                                          ? other$industryConfigurationName == null
                                                                                          : this$industryConfigurationName.equals(
                                                                                             other$industryConfigurationName
                                                                                          )) {
                                                                                          Object this$unitReputationAllocationConfigName = this.getUnitReputationAllocationConfigName();
                                                                                          Object other$unitReputationAllocationConfigName = other.getUnitReputationAllocationConfigName();
                                                                                          if (this$unitReputationAllocationConfigName == null
                                                                                             ? other$unitReputationAllocationConfigName == null
                                                                                             : this$unitReputationAllocationConfigName.equals(
                                                                                                other$unitReputationAllocationConfigName
                                                                                             )) {
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
                                                                                                   Object this$businessEmail = this.getBusinessEmail();
                                                                                                   Object other$businessEmail = other.getBusinessEmail();
                                                                                                   if (this$businessEmail == null
                                                                                                      ? other$businessEmail == null
                                                                                                      : this$businessEmail.equals(other$businessEmail)) {
                                                                                                      Object this$caLockDate = this.getCaLockDate();
                                                                                                      Object other$caLockDate = other.getCaLockDate();
                                                                                                      if (this$caLockDate == null
                                                                                                         ? other$caLockDate == null
                                                                                                         : this$caLockDate.equals(other$caLockDate)) {
                                                                                                         Object this$createUserName = this.getCreateUserName();
                                                                                                         Object other$createUserName = other.getCreateUserName();
                                                                                                         return this$createUserName == null
                                                                                                            ? other$createUserName == null
                                                                                                            : this$createUserName.equals(other$createUserName);
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CrmGovernmentWarehousingPageDTO;
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
      Object $unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
      result = result * 59 + ($unitPropertyAllocationConfigId == null ? 43 : $unitPropertyAllocationConfigId.hashCode());
      Object $unitClassConfigurationId = this.getUnitClassConfigurationId();
      result = result * 59 + ($unitClassConfigurationId == null ? 43 : $unitClassConfigurationId.hashCode());
      Object $industryConfigurationId = this.getIndustryConfigurationId();
      result = result * 59 + ($industryConfigurationId == null ? 43 : $industryConfigurationId.hashCode());
      Object $unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
      result = result * 59 + ($unitReputationAllocationConfigId == null ? 43 : $unitReputationAllocationConfigId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
      result = result * 59 + ($unitPropertyAllocationConfigName == null ? 43 : $unitPropertyAllocationConfigName.hashCode());
      Object $unitClassConfigurationName = this.getUnitClassConfigurationName();
      result = result * 59 + ($unitClassConfigurationName == null ? 43 : $unitClassConfigurationName.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
      Object $unitReputationAllocationConfigName = this.getUnitReputationAllocationConfigName();
      result = result * 59 + ($unitReputationAllocationConfigName == null ? 43 : $unitReputationAllocationConfigName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
      Object $caLockDate = this.getCaLockDate();
      result = result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmGovernmentWarehousingPageDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private Long crmEnterpriseWarehousingId;
      private String businessName;
      private String address;
      private Long crmProjectInformationWarehousingId;
      private String crmProjectInformationWarehousingName;
      private String creditCode;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private List<Long> regionList;
      private String regionNameList;
      private List<AttachmentDTO> attachmentDTOS;
      private String attachmentIds;
      private Long unitPropertyAllocationConfigId;
      private String unitPropertyAllocationConfigName;
      private Long unitClassConfigurationId;
      private String unitClassConfigurationName;
      private Long industryConfigurationId;
      private String industryConfigurationName;
      private Long unitReputationAllocationConfigId;
      private String unitReputationAllocationConfigName;
      private String informantUserName;
      private String businessPhone;
      private String businessEmail;
      private Integer crmCheckStatusEnum;
      private LocalDate caLockDate;
      private String createUserName;

      CrmGovernmentWarehousingPageDTOBuilder() {
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder unitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
         this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder unitPropertyAllocationConfigName(
         final String unitPropertyAllocationConfigName
      ) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder unitClassConfigurationName(final String unitClassConfigurationName) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder industryConfigurationId(final Long industryConfigurationId) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder industryConfigurationName(final String industryConfigurationName) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder unitReputationAllocationConfigId(
         final Long unitReputationAllocationConfigId
      ) {
         this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder unitReputationAllocationConfigName(
         final String unitReputationAllocationConfigName
      ) {
         this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder businessEmail(final String businessEmail) {
         this.businessEmail = businessEmail;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmGovernmentWarehousingPageDTO build() {
         return new CrmGovernmentWarehousingPageDTO(
            this.id,
            this.informantDateTime,
            this.crmEnterpriseWarehousingId,
            this.businessName,
            this.address,
            this.crmProjectInformationWarehousingId,
            this.crmProjectInformationWarehousingName,
            this.creditCode,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.regionList,
            this.regionNameList,
            this.attachmentDTOS,
            this.attachmentIds,
            this.unitPropertyAllocationConfigId,
            this.unitPropertyAllocationConfigName,
            this.unitClassConfigurationId,
            this.unitClassConfigurationName,
            this.industryConfigurationId,
            this.industryConfigurationName,
            this.unitReputationAllocationConfigId,
            this.unitReputationAllocationConfigName,
            this.informantUserName,
            this.businessPhone,
            this.businessEmail,
            this.crmCheckStatusEnum,
            this.caLockDate,
            this.createUserName
         );
      }

      @Override
      public String toString() {
         return "CrmGovernmentWarehousingPageDTO.CrmGovernmentWarehousingPageDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", businessName="
            + this.businessName
            + ", address="
            + this.address
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", creditCode="
            + this.creditCode
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
            + ", regionList="
            + this.regionList
            + ", regionNameList="
            + this.regionNameList
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ", attachmentIds="
            + this.attachmentIds
            + ", unitPropertyAllocationConfigId="
            + this.unitPropertyAllocationConfigId
            + ", unitPropertyAllocationConfigName="
            + this.unitPropertyAllocationConfigName
            + ", unitClassConfigurationId="
            + this.unitClassConfigurationId
            + ", unitClassConfigurationName="
            + this.unitClassConfigurationName
            + ", industryConfigurationId="
            + this.industryConfigurationId
            + ", industryConfigurationName="
            + this.industryConfigurationName
            + ", unitReputationAllocationConfigId="
            + this.unitReputationAllocationConfigId
            + ", unitReputationAllocationConfigName="
            + this.unitReputationAllocationConfigName
            + ", informantUserName="
            + this.informantUserName
            + ", businessPhone="
            + this.businessPhone
            + ", businessEmail="
            + this.businessEmail
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", caLockDate="
            + this.caLockDate
            + ", createUserName="
            + this.createUserName
            + ")";
      }
   }
}
