package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmEnterpriseWarehousingDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "备案编号")
   private String serialNumber;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "部门名称", notes = "部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "unitPropertyAllocationConfigId", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private Long unitPropertyAllocationConfigId;
   @ApiModelProperty(name = "unitPropertyAllocationConfigName", value = "单位类别名称  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private String unitPropertyAllocationConfigName;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private Long unitClassConfigurationId;
   @ApiModelProperty(name = "unitClassConfigurationName", value = "单位性质名称  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private String unitClassConfigurationName;
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
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "regionNameList", value = "地区名称列表", notes = "地区名称列表")
   private String regionNameList;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "industryConfigurationId", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private Long industryConfigurationId;
   @ApiModelProperty(name = "industryConfigurationName", value = "单位所属行业名称  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private String industryConfigurationName;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   private String businessEmail;
   @ApiModelProperty(name = "liaisons", value = "联系人", notes = "联系人")
   private String liaisons;
   @ApiModelProperty(name = "qualificationAndAbility", value = "资质能力", notes = "资质能力")
   private String qualificationAndAbility;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "attachmentIds", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "remark", value = "其他信息备注", notes = "其他信息备注")
   private String remark;
   @ApiModelProperty(name = "unitReputationAllocationConfigId", value = "企业信誉  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   private Long unitReputationAllocationConfigId;
   @ApiModelProperty(name = "unitReputationAllocationConfigName", value = "企业信誉名称  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   private String unitReputationAllocationConfigName;

   public static CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder builder() {
      return new CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder();
   }

   public CrmEnterpriseWarehousingDetailDTO() {
   }

   public CrmEnterpriseWarehousingDetailDTO(
      final Long id,
      final String serialNumber,
      final Long informantUserId,
      final String informantUserName,
      final Integer crmCheckStatusEnum,
      final Long departmentId,
      final String departmentName,
      final LocalDateTime informantDateTime,
      final String businessName,
      final Long unitPropertyAllocationConfigId,
      final String unitPropertyAllocationConfigName,
      final Long unitClassConfigurationId,
      final String unitClassConfigurationName,
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
      final String address,
      final String creditCode,
      final Long industryConfigurationId,
      final String industryConfigurationName,
      final String businessPhone,
      final String businessEmail,
      final String liaisons,
      final String qualificationAndAbility,
      final Long approveRecordId,
      final List<AttachmentDTO> attachmentDTOList,
      final List<AttachmentDTO> attachmentIds,
      final Integer crmCountryTypeEnum,
      final String remark,
      final Long unitReputationAllocationConfigId,
      final String unitReputationAllocationConfigName
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.informantDateTime = informantDateTime;
      this.businessName = businessName;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.unitClassConfigurationName = unitClassConfigurationName;
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
      this.address = address;
      this.creditCode = creditCode;
      this.industryConfigurationId = industryConfigurationId;
      this.industryConfigurationName = industryConfigurationName;
      this.businessPhone = businessPhone;
      this.businessEmail = businessEmail;
      this.liaisons = liaisons;
      this.qualificationAndAbility = qualificationAndAbility;
      this.approveRecordId = approveRecordId;
      this.attachmentDTOList = attachmentDTOList;
      this.attachmentIds = attachmentIds;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.remark = remark;
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
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

   public String getUnitPropertyAllocationConfigName() {
      return this.unitPropertyAllocationConfigName;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
   }

   public String getUnitClassConfigurationName() {
      return this.unitClassConfigurationName;
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

   public String getAddress() {
      return this.address;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
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

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUnitReputationAllocationConfigId() {
      return this.unitReputationAllocationConfigId;
   }

   public String getUnitReputationAllocationConfigName() {
      return this.unitReputationAllocationConfigName;
   }

   public CrmEnterpriseWarehousingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setLiaisons(final String liaisons) {
      this.liaisons = liaisons;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setQualificationAndAbility(final String qualificationAndAbility) {
      this.qualificationAndAbility = qualificationAndAbility;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setUnitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      return this;
   }

   public CrmEnterpriseWarehousingDetailDTO setUnitReputationAllocationConfigName(final String unitReputationAllocationConfigName) {
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmEnterpriseWarehousingDetailDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", businessName="
         + this.getBusinessName()
         + ", unitPropertyAllocationConfigId="
         + this.getUnitPropertyAllocationConfigId()
         + ", unitPropertyAllocationConfigName="
         + this.getUnitPropertyAllocationConfigName()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
         + ", unitClassConfigurationName="
         + this.getUnitClassConfigurationName()
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
         + ", address="
         + this.getAddress()
         + ", creditCode="
         + this.getCreditCode()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", businessEmail="
         + this.getBusinessEmail()
         + ", liaisons="
         + this.getLiaisons()
         + ", qualificationAndAbility="
         + this.getQualificationAndAbility()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", remark="
         + this.getRemark()
         + ", unitReputationAllocationConfigId="
         + this.getUnitReputationAllocationConfigId()
         + ", unitReputationAllocationConfigName="
         + this.getUnitReputationAllocationConfigName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseWarehousingDetailDTO)) {
         return false;
      }

      CrmEnterpriseWarehousingDetailDTO other = (CrmEnterpriseWarehousingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
            Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
            if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
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
                                       Object this$approveRecordId = this.getApproveRecordId();
                                       Object other$approveRecordId = other.getApproveRecordId();
                                       if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
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
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$informantUserName = this.getInformantUserName();
                                                   Object other$informantUserName = other.getInformantUserName();
                                                   if (this$informantUserName == null
                                                      ? other$informantUserName == null
                                                      : this$informantUserName.equals(other$informantUserName)) {
                                                      Object this$departmentName = this.getDepartmentName();
                                                      Object other$departmentName = other.getDepartmentName();
                                                      if (this$departmentName == null
                                                         ? other$departmentName == null
                                                         : this$departmentName.equals(other$departmentName)) {
                                                         Object this$informantDateTime = this.getInformantDateTime();
                                                         Object other$informantDateTime = other.getInformantDateTime();
                                                         if (this$informantDateTime == null
                                                            ? other$informantDateTime == null
                                                            : this$informantDateTime.equals(other$informantDateTime)) {
                                                            Object this$businessName = this.getBusinessName();
                                                            Object other$businessName = other.getBusinessName();
                                                            if (this$businessName == null
                                                               ? other$businessName == null
                                                               : this$businessName.equals(other$businessName)) {
                                                               Object this$unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
                                                               Object other$unitPropertyAllocationConfigName = other.getUnitPropertyAllocationConfigName();
                                                               if (this$unitPropertyAllocationConfigName == null
                                                                  ? other$unitPropertyAllocationConfigName == null
                                                                  : this$unitPropertyAllocationConfigName.equals(other$unitPropertyAllocationConfigName)) {
                                                                  Object this$unitClassConfigurationName = this.getUnitClassConfigurationName();
                                                                  Object other$unitClassConfigurationName = other.getUnitClassConfigurationName();
                                                                  if (this$unitClassConfigurationName == null
                                                                     ? other$unitClassConfigurationName == null
                                                                     : this$unitClassConfigurationName.equals(other$unitClassConfigurationName)) {
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
                                                                           if (this$cityName == null
                                                                              ? other$cityName == null
                                                                              : this$cityName.equals(other$cityName)) {
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
                                                                                       Object this$address = this.getAddress();
                                                                                       Object other$address = other.getAddress();
                                                                                       if (this$address == null
                                                                                          ? other$address == null
                                                                                          : this$address.equals(other$address)) {
                                                                                          Object this$creditCode = this.getCreditCode();
                                                                                          Object other$creditCode = other.getCreditCode();
                                                                                          if (this$creditCode == null
                                                                                             ? other$creditCode == null
                                                                                             : this$creditCode.equals(other$creditCode)) {
                                                                                             Object this$industryConfigurationName = this.getIndustryConfigurationName();
                                                                                             Object other$industryConfigurationName = other.getIndustryConfigurationName();
                                                                                             if (this$industryConfigurationName == null
                                                                                                ? other$industryConfigurationName == null
                                                                                                : this$industryConfigurationName.equals(
                                                                                                   other$industryConfigurationName
                                                                                                )) {
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
                                                                                                            : this$qualificationAndAbility.equals(
                                                                                                               other$qualificationAndAbility
                                                                                                            )) {
                                                                                                            Object this$attachmentDTOList = this.getAttachmentDTOList();
                                                                                                            Object other$attachmentDTOList = other.getAttachmentDTOList();
                                                                                                            if (this$attachmentDTOList == null
                                                                                                               ? other$attachmentDTOList == null
                                                                                                               : this$attachmentDTOList.equals(
                                                                                                                  other$attachmentDTOList
                                                                                                               )) {
                                                                                                               Object this$attachmentIds = this.getAttachmentIds();
                                                                                                               Object other$attachmentIds = other.getAttachmentIds();
                                                                                                               if (this$attachmentIds == null
                                                                                                                  ? other$attachmentIds == null
                                                                                                                  : this$attachmentIds.equals(
                                                                                                                     other$attachmentIds
                                                                                                                  )) {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  if (this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark)) {
                                                                                                                     Object this$unitReputationAllocationConfigName = this.getUnitReputationAllocationConfigName();
                                                                                                                     Object other$unitReputationAllocationConfigName = other.getUnitReputationAllocationConfigName();
                                                                                                                     return this$unitReputationAllocationConfigName
                                                                                                                           == null
                                                                                                                        ? other$unitReputationAllocationConfigName
                                                                                                                           == null
                                                                                                                        : this$unitReputationAllocationConfigName.equals(
                                                                                                                           other$unitReputationAllocationConfigName
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmEnterpriseWarehousingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
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
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
      result = result * 59 + ($unitReputationAllocationConfigId == null ? 43 : $unitReputationAllocationConfigId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
      result = result * 59 + ($unitPropertyAllocationConfigName == null ? 43 : $unitPropertyAllocationConfigName.hashCode());
      Object $unitClassConfigurationName = this.getUnitClassConfigurationName();
      result = result * 59 + ($unitClassConfigurationName == null ? 43 : $unitClassConfigurationName.hashCode());
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
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
      Object $liaisons = this.getLiaisons();
      result = result * 59 + ($liaisons == null ? 43 : $liaisons.hashCode());
      Object $qualificationAndAbility = this.getQualificationAndAbility();
      result = result * 59 + ($qualificationAndAbility == null ? 43 : $qualificationAndAbility.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $unitReputationAllocationConfigName = this.getUnitReputationAllocationConfigName();
      return result * 59 + ($unitReputationAllocationConfigName == null ? 43 : $unitReputationAllocationConfigName.hashCode());
   }

   public static class CrmEnterpriseWarehousingDetailDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long informantUserId;
      private String informantUserName;
      private Integer crmCheckStatusEnum;
      private Long departmentId;
      private String departmentName;
      private LocalDateTime informantDateTime;
      private String businessName;
      private Long unitPropertyAllocationConfigId;
      private String unitPropertyAllocationConfigName;
      private Long unitClassConfigurationId;
      private String unitClassConfigurationName;
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
      private String address;
      private String creditCode;
      private Long industryConfigurationId;
      private String industryConfigurationName;
      private String businessPhone;
      private String businessEmail;
      private String liaisons;
      private String qualificationAndAbility;
      private Long approveRecordId;
      private List<AttachmentDTO> attachmentDTOList;
      private List<AttachmentDTO> attachmentIds;
      private Integer crmCountryTypeEnum;
      private String remark;
      private Long unitReputationAllocationConfigId;
      private String unitReputationAllocationConfigName;

      CrmEnterpriseWarehousingDetailDTOBuilder() {
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder unitPropertyAllocationConfigId(
         final Long unitPropertyAllocationConfigId
      ) {
         this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder unitPropertyAllocationConfigName(
         final String unitPropertyAllocationConfigName
      ) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder unitClassConfigurationName(final String unitClassConfigurationName) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder industryConfigurationId(final Long industryConfigurationId) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder industryConfigurationName(final String industryConfigurationName) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder businessEmail(final String businessEmail) {
         this.businessEmail = businessEmail;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder liaisons(final String liaisons) {
         this.liaisons = liaisons;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder qualificationAndAbility(final String qualificationAndAbility) {
         this.qualificationAndAbility = qualificationAndAbility;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder crmCountryTypeEnum(final Integer crmCountryTypeEnum) {
         this.crmCountryTypeEnum = crmCountryTypeEnum;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder unitReputationAllocationConfigId(
         final Long unitReputationAllocationConfigId
      ) {
         this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder unitReputationAllocationConfigName(
         final String unitReputationAllocationConfigName
      ) {
         this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
         return this;
      }

      public CrmEnterpriseWarehousingDetailDTO build() {
         return new CrmEnterpriseWarehousingDetailDTO(
            this.id,
            this.serialNumber,
            this.informantUserId,
            this.informantUserName,
            this.crmCheckStatusEnum,
            this.departmentId,
            this.departmentName,
            this.informantDateTime,
            this.businessName,
            this.unitPropertyAllocationConfigId,
            this.unitPropertyAllocationConfigName,
            this.unitClassConfigurationId,
            this.unitClassConfigurationName,
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
            this.address,
            this.creditCode,
            this.industryConfigurationId,
            this.industryConfigurationName,
            this.businessPhone,
            this.businessEmail,
            this.liaisons,
            this.qualificationAndAbility,
            this.approveRecordId,
            this.attachmentDTOList,
            this.attachmentIds,
            this.crmCountryTypeEnum,
            this.remark,
            this.unitReputationAllocationConfigId,
            this.unitReputationAllocationConfigName
         );
      }

      @Override
      public String toString() {
         return "CrmEnterpriseWarehousingDetailDTO.CrmEnterpriseWarehousingDetailDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", informantDateTime="
            + this.informantDateTime
            + ", businessName="
            + this.businessName
            + ", unitPropertyAllocationConfigId="
            + this.unitPropertyAllocationConfigId
            + ", unitPropertyAllocationConfigName="
            + this.unitPropertyAllocationConfigName
            + ", unitClassConfigurationId="
            + this.unitClassConfigurationId
            + ", unitClassConfigurationName="
            + this.unitClassConfigurationName
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
            + ", address="
            + this.address
            + ", creditCode="
            + this.creditCode
            + ", industryConfigurationId="
            + this.industryConfigurationId
            + ", industryConfigurationName="
            + this.industryConfigurationName
            + ", businessPhone="
            + this.businessPhone
            + ", businessEmail="
            + this.businessEmail
            + ", liaisons="
            + this.liaisons
            + ", qualificationAndAbility="
            + this.qualificationAndAbility
            + ", approveRecordId="
            + this.approveRecordId
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", attachmentIds="
            + this.attachmentIds
            + ", crmCountryTypeEnum="
            + this.crmCountryTypeEnum
            + ", remark="
            + this.remark
            + ", unitReputationAllocationConfigId="
            + this.unitReputationAllocationConfigId
            + ", unitReputationAllocationConfigName="
            + this.unitReputationAllocationConfigName
            + ")";
      }
   }
}
