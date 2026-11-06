package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CrmSupplierWarehousingPageDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "liaisons", value = "联系人", notes = "联系人")
   private String liaisons;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案id", notes = "企业备案id")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "qualificationAndAbility", value = "资质能力", notes = "资质能力")
   private String qualificationAndAbility;
   @ApiModelProperty(name = "address", value = "地址", notes = "地址")
   private String address;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
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
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   private String businessEmail;
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
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "attachmentIds", value = "入库附件", notes = "入库附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "attachmentIdsByString", value = "附件ids", notes = "附件ids")
   private String attachmentIdsByString;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   private LocalDate caLockDate;

   public static CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder builder() {
      return new CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder();
   }

   public CrmSupplierWarehousingPageDTO() {
   }

   public CrmSupplierWarehousingPageDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String businessName,
      final String liaisons,
      final String creditCode,
      final Long crmEnterpriseWarehousingId,
      final String crmEnterpriseWarehousingName,
      final String qualificationAndAbility,
      final String address,
      final String regionNameList,
      final List<Long> regionList,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String projectName,
      final String businessPhone,
      final String businessEmail,
      final Long unitPropertyAllocationConfigId,
      final String unitPropertyAllocationConfigName,
      final Long unitClassConfigurationId,
      final String unitClassConfigurationName,
      final Long industryConfigurationId,
      final String industryConfigurationName,
      final Long unitReputationAllocationConfigId,
      final String unitReputationAllocationConfigName,
      final String informantUserName,
      final String createUserName,
      final List<AttachmentDTO> attachmentIds,
      final String attachmentIdsByString,
      final LocalDateTime deadlineForAcceptanceTime,
      final LocalDate caLockDate
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.businessName = businessName;
      this.liaisons = liaisons;
      this.creditCode = creditCode;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.qualificationAndAbility = qualificationAndAbility;
      this.address = address;
      this.regionNameList = regionNameList;
      this.regionList = regionList;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.projectName = projectName;
      this.businessPhone = businessPhone;
      this.businessEmail = businessEmail;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.unitClassConfigurationName = unitClassConfigurationName;
      this.industryConfigurationId = industryConfigurationId;
      this.industryConfigurationName = industryConfigurationName;
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      this.informantUserName = informantUserName;
      this.createUserName = createUserName;
      this.attachmentIds = attachmentIds;
      this.attachmentIdsByString = attachmentIdsByString;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.caLockDate = caLockDate;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public String getLiaisons() {
      return this.liaisons;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public String getQualificationAndAbility() {
      return this.qualificationAndAbility;
   }

   public String getAddress() {
      return this.address;
   }

   public String getRegionNameList() {
      return this.regionNameList;
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

   public String getProjectName() {
      return this.projectName;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public String getBusinessEmail() {
      return this.businessEmail;
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

   public String getCreateUserName() {
      return this.createUserName;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAttachmentIdsByString() {
      return this.attachmentIdsByString;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public CrmSupplierWarehousingPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setLiaisons(final String liaisons) {
      this.liaisons = liaisons;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setQualificationAndAbility(final String qualificationAndAbility) {
      this.qualificationAndAbility = qualificationAndAbility;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setUnitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setUnitReputationAllocationConfigName(final String unitReputationAllocationConfigName) {
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setAttachmentIdsByString(final String attachmentIdsByString) {
      this.attachmentIdsByString = attachmentIdsByString;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmSupplierWarehousingPageDTO setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmSupplierWarehousingPageDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", businessName="
         + this.getBusinessName()
         + ", liaisons="
         + this.getLiaisons()
         + ", creditCode="
         + this.getCreditCode()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", qualificationAndAbility="
         + this.getQualificationAndAbility()
         + ", address="
         + this.getAddress()
         + ", regionNameList="
         + this.getRegionNameList()
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
         + ", projectName="
         + this.getProjectName()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", businessEmail="
         + this.getBusinessEmail()
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
         + ", createUserName="
         + this.getCreateUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentIdsByString="
         + this.getAttachmentIdsByString()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", caLockDate="
         + this.getCaLockDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSupplierWarehousingPageDTO)) {
         return false;
      }

      CrmSupplierWarehousingPageDTO other = (CrmSupplierWarehousingPageDTO)o;
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
                                    Object this$informantDateTime = this.getInformantDateTime();
                                    Object other$informantDateTime = other.getInformantDateTime();
                                    if (this$informantDateTime == null
                                       ? other$informantDateTime == null
                                       : this$informantDateTime.equals(other$informantDateTime)) {
                                       Object this$businessName = this.getBusinessName();
                                       Object other$businessName = other.getBusinessName();
                                       if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
                                          Object this$liaisons = this.getLiaisons();
                                          Object other$liaisons = other.getLiaisons();
                                          if (this$liaisons == null ? other$liaisons == null : this$liaisons.equals(other$liaisons)) {
                                             Object this$creditCode = this.getCreditCode();
                                             Object other$creditCode = other.getCreditCode();
                                             if (this$creditCode == null ? other$creditCode == null : this$creditCode.equals(other$creditCode)) {
                                                Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                                Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                                if (this$crmEnterpriseWarehousingName == null
                                                   ? other$crmEnterpriseWarehousingName == null
                                                   : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                                   Object this$qualificationAndAbility = this.getQualificationAndAbility();
                                                   Object other$qualificationAndAbility = other.getQualificationAndAbility();
                                                   if (this$qualificationAndAbility == null
                                                      ? other$qualificationAndAbility == null
                                                      : this$qualificationAndAbility.equals(other$qualificationAndAbility)) {
                                                      Object this$address = this.getAddress();
                                                      Object other$address = other.getAddress();
                                                      if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                         Object this$regionNameList = this.getRegionNameList();
                                                         Object other$regionNameList = other.getRegionNameList();
                                                         if (this$regionNameList == null
                                                            ? other$regionNameList == null
                                                            : this$regionNameList.equals(other$regionNameList)) {
                                                            Object this$regionList = this.getRegionList();
                                                            Object other$regionList = other.getRegionList();
                                                            if (this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList)) {
                                                               Object this$countryName = this.getCountryName();
                                                               Object other$countryName = other.getCountryName();
                                                               if (this$countryName == null
                                                                  ? other$countryName == null
                                                                  : this$countryName.equals(other$countryName)) {
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
                                                                           Object this$projectName = this.getProjectName();
                                                                           Object other$projectName = other.getProjectName();
                                                                           if (this$projectName == null
                                                                              ? other$projectName == null
                                                                              : this$projectName.equals(other$projectName)) {
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
                                                                                                   Object this$createUserName = this.getCreateUserName();
                                                                                                   Object other$createUserName = other.getCreateUserName();
                                                                                                   if (this$createUserName == null
                                                                                                      ? other$createUserName == null
                                                                                                      : this$createUserName.equals(other$createUserName)) {
                                                                                                      Object this$attachmentIds = this.getAttachmentIds();
                                                                                                      Object other$attachmentIds = other.getAttachmentIds();
                                                                                                      if (this$attachmentIds == null
                                                                                                         ? other$attachmentIds == null
                                                                                                         : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                         Object this$attachmentIdsByString = this.getAttachmentIdsByString();
                                                                                                         Object other$attachmentIdsByString = other.getAttachmentIdsByString();
                                                                                                         if (this$attachmentIdsByString == null
                                                                                                            ? other$attachmentIdsByString == null
                                                                                                            : this$attachmentIdsByString.equals(
                                                                                                               other$attachmentIdsByString
                                                                                                            )) {
                                                                                                            Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                                                                                                            Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                                                                                                            if (this$deadlineForAcceptanceTime == null
                                                                                                               ? other$deadlineForAcceptanceTime == null
                                                                                                               : this$deadlineForAcceptanceTime.equals(
                                                                                                                  other$deadlineForAcceptanceTime
                                                                                                               )) {
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
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CrmSupplierWarehousingPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
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
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $liaisons = this.getLiaisons();
      result = result * 59 + ($liaisons == null ? 43 : $liaisons.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $qualificationAndAbility = this.getQualificationAndAbility();
      result = result * 59 + ($qualificationAndAbility == null ? 43 : $qualificationAndAbility.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
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
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
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
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentIdsByString = this.getAttachmentIdsByString();
      result = result * 59 + ($attachmentIdsByString == null ? 43 : $attachmentIdsByString.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $caLockDate = this.getCaLockDate();
      return result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
   }

   public static class CrmSupplierWarehousingPageDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String businessName;
      private String liaisons;
      private String creditCode;
      private Long crmEnterpriseWarehousingId;
      private String crmEnterpriseWarehousingName;
      private String qualificationAndAbility;
      private String address;
      private String regionNameList;
      private List<Long> regionList;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String projectName;
      private String businessPhone;
      private String businessEmail;
      private Long unitPropertyAllocationConfigId;
      private String unitPropertyAllocationConfigName;
      private Long unitClassConfigurationId;
      private String unitClassConfigurationName;
      private Long industryConfigurationId;
      private String industryConfigurationName;
      private Long unitReputationAllocationConfigId;
      private String unitReputationAllocationConfigName;
      private String informantUserName;
      private String createUserName;
      private List<AttachmentDTO> attachmentIds;
      private String attachmentIdsByString;
      private LocalDateTime deadlineForAcceptanceTime;
      private LocalDate caLockDate;

      CrmSupplierWarehousingPageDTOBuilder() {
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder liaisons(final String liaisons) {
         this.liaisons = liaisons;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder qualificationAndAbility(final String qualificationAndAbility) {
         this.qualificationAndAbility = qualificationAndAbility;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder businessEmail(final String businessEmail) {
         this.businessEmail = businessEmail;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder unitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
         this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder unitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder unitClassConfigurationName(final String unitClassConfigurationName) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder industryConfigurationId(final Long industryConfigurationId) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder industryConfigurationName(final String industryConfigurationName) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder unitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
         this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder unitReputationAllocationConfigName(
         final String unitReputationAllocationConfigName
      ) {
         this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder attachmentIdsByString(final String attachmentIdsByString) {
         this.attachmentIdsByString = attachmentIdsByString;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder deadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmSupplierWarehousingPageDTO build() {
         return new CrmSupplierWarehousingPageDTO(
            this.id,
            this.informantDateTime,
            this.businessName,
            this.liaisons,
            this.creditCode,
            this.crmEnterpriseWarehousingId,
            this.crmEnterpriseWarehousingName,
            this.qualificationAndAbility,
            this.address,
            this.regionNameList,
            this.regionList,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.projectName,
            this.businessPhone,
            this.businessEmail,
            this.unitPropertyAllocationConfigId,
            this.unitPropertyAllocationConfigName,
            this.unitClassConfigurationId,
            this.unitClassConfigurationName,
            this.industryConfigurationId,
            this.industryConfigurationName,
            this.unitReputationAllocationConfigId,
            this.unitReputationAllocationConfigName,
            this.informantUserName,
            this.createUserName,
            this.attachmentIds,
            this.attachmentIdsByString,
            this.deadlineForAcceptanceTime,
            this.caLockDate
         );
      }

      @Override
      public String toString() {
         return "CrmSupplierWarehousingPageDTO.CrmSupplierWarehousingPageDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", businessName="
            + this.businessName
            + ", liaisons="
            + this.liaisons
            + ", creditCode="
            + this.creditCode
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", qualificationAndAbility="
            + this.qualificationAndAbility
            + ", address="
            + this.address
            + ", regionNameList="
            + this.regionNameList
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
            + ", projectName="
            + this.projectName
            + ", businessPhone="
            + this.businessPhone
            + ", businessEmail="
            + this.businessEmail
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
            + ", createUserName="
            + this.createUserName
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentIdsByString="
            + this.attachmentIdsByString
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", caLockDate="
            + this.caLockDate
            + ")";
      }
   }
}
