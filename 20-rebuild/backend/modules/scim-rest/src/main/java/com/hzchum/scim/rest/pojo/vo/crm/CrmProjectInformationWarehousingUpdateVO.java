package com.hzchum.scim.rest.pojo.vo.crm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmProjectInformationWarehousingUpdateVO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号", notes = "项目编号")
   private String projectSerialNumber;
   @ApiModelProperty(name = "typeOfContractorId", value = "承建类别 CrmProjectInformationConfig", notes = "承建类别 CrmProjectInformationConfig")
   private Long typeOfContractorId;
   @ApiModelProperty(name = "keyProjectId", value = "重点项目CrmProjectInformationConfig", notes = "重点项目CrmProjectInformationConfig")
   private Long keyProjectId;
   @ApiModelProperty(name = "itemCategoryId", value = "项目类别 CrmProjectInformationConfig", notes = "项目类别 CrmProjectInformationConfig")
   private Long itemCategoryId;
   @ApiModelProperty(name = "configurationOfArchitecturalFormId", value = "建筑形式 CrmProjectInformationConfig", notes = "建筑形式 CrmProjectInformationConfig")
   private Long configurationOfArchitecturalFormId;
   @ApiModelProperty(name = "structureTypeConfigurationId", value = "结构类型 CrmProjectInformationConfig", notes = "结构类型 CrmProjectInformationConfig")
   private Long structureTypeConfigurationId;
   @ApiModelProperty(name = "industryConfigurationId", value = "所属行业 CrmBasicsConfig", notes = "所属行业 CrmBasicsConfig")
   private Long industryConfigurationId;
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
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "projectOverview", value = "项目概况", notes = "项目概况")
   private String projectOverview;
   @ApiModelProperty(name = "estimatedWorks", value = "预估工程量", notes = "预估工程量")
   private BigDecimal estimatedWorks;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "areaOfStructure", value = "建筑面积", notes = "建筑面积")
   private BigDecimal areaOfStructure;
   @ApiModelProperty(name = "biddingMethodId", value = "招标方式  CrmTenderRequestConfig", notes = "招标方式  CrmTenderRequestConfig")
   private Long biddingMethodId;
   @ApiModelProperty(name = "fileFormatId", value = "文件格式 CrmProjectInformationConfig", notes = "文件格式 CrmProjectInformationConfig")
   private Long fileFormatId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "difficultyFactorId", value = "难度系数 CrmProjectInformationConfig", notes = "难度系数 CrmProjectInformationConfig")
   private Long difficultyFactorId;
   @ApiModelProperty(name = "projectAttachments", value = "项目附件", notes = "项目附件")
   private List<AttachmentDTO> projectAttachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "aUnitClassConfigurationId", value = "建设单位", notes = "建设单位")
   @JsonProperty("aUnitClassConfigurationId")
   private Long aUnitClassConfigurationId;
   @ApiModelProperty(name = "aUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @JsonProperty("aUnitClassConfigurationContactName")
   private String aUnitClassConfigurationContactName;
   @ApiModelProperty(name = "aUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @JsonProperty("aUnitClassConfigurationOffice")
   private String aUnitClassConfigurationOffice;
   @ApiModelProperty(name = "aUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @JsonProperty("aUnitClassConfigurationPhone")
   private String aUnitClassConfigurationPhone;
   @ApiModelProperty(name = "bUnitClassConfigurationId", value = "代建单位", notes = "代建单位")
   @JsonProperty("bUnitClassConfigurationId")
   private Long bUnitClassConfigurationId;
   @ApiModelProperty(name = "bUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @JsonProperty("bUnitClassConfigurationContactName")
   private String bUnitClassConfigurationContactName;
   @ApiModelProperty(name = "bUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @JsonProperty("bUnitClassConfigurationOffice")
   private String bUnitClassConfigurationOffice;
   @ApiModelProperty(name = "bUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @JsonProperty("bUnitClassConfigurationPhone")
   private String bUnitClassConfigurationPhone;
   @ApiModelProperty(name = "cUnitClassConfigurationId", value = "EPC单位", notes = "EPC单位")
   @JsonProperty("cUnitClassConfigurationId")
   private Long cUnitClassConfigurationId;
   @ApiModelProperty(name = "cUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @JsonProperty("cUnitClassConfigurationContactName")
   private String cUnitClassConfigurationContactName;
   @ApiModelProperty(name = "cUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @JsonProperty("cUnitClassConfigurationOffice")
   private String cUnitClassConfigurationOffice;
   @ApiModelProperty(name = "cUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @JsonProperty("cUnitClassConfigurationPhone")
   private String cUnitClassConfigurationPhone;
   @ApiModelProperty(name = "dUnitClassConfigurationId", value = "设计单位", notes = "设计单位")
   @JsonProperty("dUnitClassConfigurationId")
   private Long dUnitClassConfigurationId;
   @ApiModelProperty(name = "dUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @JsonProperty("dUnitClassConfigurationContactName")
   private String dUnitClassConfigurationContactName;
   @ApiModelProperty(name = "dUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @JsonProperty("dUnitClassConfigurationOffice")
   private String dUnitClassConfigurationOffice;
   @ApiModelProperty(name = "dUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @JsonProperty("dUnitClassConfigurationPhone")
   private String dUnitClassConfigurationPhone;
   @ApiModelProperty(name = "eUnitClassConfigurationId", value = "总包单位", notes = "总包单位")
   @JsonProperty("eUnitClassConfigurationId")
   private Long eUnitClassConfigurationId;
   @ApiModelProperty(name = "eUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @JsonProperty("eUnitClassConfigurationContactName")
   private String eUnitClassConfigurationContactName;
   @ApiModelProperty(name = "eUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @JsonProperty("eUnitClassConfigurationOffice")
   private String eUnitClassConfigurationOffice;
   @ApiModelProperty(name = "eUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @JsonProperty("eUnitClassConfigurationPhone")
   private String eUnitClassConfigurationPhone;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态", notes = "当前状态")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "crmProjectTrackerWireSaveVOList", value = "跟踪人员", notes = "跟踪人员")
   private List<CrmProjectTrackerWireSaveVO> crmProjectTrackerWireSaveVOList;
   @ApiModelProperty(name = "infoSource", value = "信息来源 参考字典 ")
   private String infoSource;
   @ApiModelProperty(name = "projectManagerName", notes = "项目（销售）经理")
   private String projectManagerName;
   @ApiModelProperty(name = "isProjectManagerCoordinate", value = "是否项目经理配合", notes = "是否项目经理配合")
   private Boolean isProjectManagerCoordinate;

   public CrmProjectInformationWarehousingUpdateVO(
      final Long id,
      final Long informantUserId,
      final LocalDateTime informantDateTime,
      final Integer crmCheckStatusEnum,
      final String projectName,
      final String projectSerialNumber,
      final Long typeOfContractorId,
      final Long keyProjectId,
      final Long itemCategoryId,
      final Long configurationOfArchitecturalFormId,
      final Long structureTypeConfigurationId,
      final Long industryConfigurationId,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String address,
      final String projectOverview,
      final BigDecimal estimatedWorks,
      final BigDecimal estimatedCost,
      final BigDecimal areaOfStructure,
      final Long biddingMethodId,
      final Long fileFormatId,
      final Long crmEnterpriseWarehousingId,
      final Long difficultyFactorId,
      final List<AttachmentDTO> projectAttachments,
      final String remark,
      final Long aUnitClassConfigurationId,
      final String aUnitClassConfigurationContactName,
      final String aUnitClassConfigurationOffice,
      final String aUnitClassConfigurationPhone,
      final Long bUnitClassConfigurationId,
      final String bUnitClassConfigurationContactName,
      final String bUnitClassConfigurationOffice,
      final String bUnitClassConfigurationPhone,
      final Long cUnitClassConfigurationId,
      final String cUnitClassConfigurationContactName,
      final String cUnitClassConfigurationOffice,
      final String cUnitClassConfigurationPhone,
      final Long dUnitClassConfigurationId,
      final String dUnitClassConfigurationContactName,
      final String dUnitClassConfigurationOffice,
      final String dUnitClassConfigurationPhone,
      final Long eUnitClassConfigurationId,
      final String eUnitClassConfigurationContactName,
      final String eUnitClassConfigurationOffice,
      final String eUnitClassConfigurationPhone,
      final Integer crmCountryTypeEnum,
      final Integer crmProjectScheduleTypeEnum,
      final List<CrmProjectTrackerWireSaveVO> crmProjectTrackerWireSaveVOList,
      final String infoSource,
      final String projectManagerName,
      final Boolean isProjectManagerCoordinate
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantDateTime = informantDateTime;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.typeOfContractorId = typeOfContractorId;
      this.keyProjectId = keyProjectId;
      this.itemCategoryId = itemCategoryId;
      this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      this.industryConfigurationId = industryConfigurationId;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.address = address;
      this.projectOverview = projectOverview;
      this.estimatedWorks = estimatedWorks;
      this.estimatedCost = estimatedCost;
      this.areaOfStructure = areaOfStructure;
      this.biddingMethodId = biddingMethodId;
      this.fileFormatId = fileFormatId;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.difficultyFactorId = difficultyFactorId;
      this.projectAttachments = projectAttachments;
      this.remark = remark;
      this.aUnitClassConfigurationId = aUnitClassConfigurationId;
      this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
      this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
      this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
      this.bUnitClassConfigurationId = bUnitClassConfigurationId;
      this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
      this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
      this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
      this.cUnitClassConfigurationId = cUnitClassConfigurationId;
      this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
      this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
      this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
      this.dUnitClassConfigurationId = dUnitClassConfigurationId;
      this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
      this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
      this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
      this.eUnitClassConfigurationId = eUnitClassConfigurationId;
      this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
      this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
      this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.crmProjectTrackerWireSaveVOList = crmProjectTrackerWireSaveVOList;
      this.infoSource = infoSource;
      this.projectManagerName = projectManagerName;
      this.isProjectManagerCoordinate = isProjectManagerCoordinate;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public Long getTypeOfContractorId() {
      return this.typeOfContractorId;
   }

   public Long getKeyProjectId() {
      return this.keyProjectId;
   }

   public Long getItemCategoryId() {
      return this.itemCategoryId;
   }

   public Long getConfigurationOfArchitecturalFormId() {
      return this.configurationOfArchitecturalFormId;
   }

   public Long getStructureTypeConfigurationId() {
      return this.structureTypeConfigurationId;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
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

   public String getProjectOverview() {
      return this.projectOverview;
   }

   public BigDecimal getEstimatedWorks() {
      return this.estimatedWorks;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public BigDecimal getAreaOfStructure() {
      return this.areaOfStructure;
   }

   public Long getBiddingMethodId() {
      return this.biddingMethodId;
   }

   public Long getFileFormatId() {
      return this.fileFormatId;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public Long getDifficultyFactorId() {
      return this.difficultyFactorId;
   }

   public List<AttachmentDTO> getProjectAttachments() {
      return this.projectAttachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getAUnitClassConfigurationId() {
      return this.aUnitClassConfigurationId;
   }

   public String getAUnitClassConfigurationContactName() {
      return this.aUnitClassConfigurationContactName;
   }

   public String getAUnitClassConfigurationOffice() {
      return this.aUnitClassConfigurationOffice;
   }

   public String getAUnitClassConfigurationPhone() {
      return this.aUnitClassConfigurationPhone;
   }

   public Long getBUnitClassConfigurationId() {
      return this.bUnitClassConfigurationId;
   }

   public String getBUnitClassConfigurationContactName() {
      return this.bUnitClassConfigurationContactName;
   }

   public String getBUnitClassConfigurationOffice() {
      return this.bUnitClassConfigurationOffice;
   }

   public String getBUnitClassConfigurationPhone() {
      return this.bUnitClassConfigurationPhone;
   }

   public Long getCUnitClassConfigurationId() {
      return this.cUnitClassConfigurationId;
   }

   public String getCUnitClassConfigurationContactName() {
      return this.cUnitClassConfigurationContactName;
   }

   public String getCUnitClassConfigurationOffice() {
      return this.cUnitClassConfigurationOffice;
   }

   public String getCUnitClassConfigurationPhone() {
      return this.cUnitClassConfigurationPhone;
   }

   public Long getDUnitClassConfigurationId() {
      return this.dUnitClassConfigurationId;
   }

   public String getDUnitClassConfigurationContactName() {
      return this.dUnitClassConfigurationContactName;
   }

   public String getDUnitClassConfigurationOffice() {
      return this.dUnitClassConfigurationOffice;
   }

   public String getDUnitClassConfigurationPhone() {
      return this.dUnitClassConfigurationPhone;
   }

   public Long getEUnitClassConfigurationId() {
      return this.eUnitClassConfigurationId;
   }

   public String getEUnitClassConfigurationContactName() {
      return this.eUnitClassConfigurationContactName;
   }

   public String getEUnitClassConfigurationOffice() {
      return this.eUnitClassConfigurationOffice;
   }

   public String getEUnitClassConfigurationPhone() {
      return this.eUnitClassConfigurationPhone;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public List<CrmProjectTrackerWireSaveVO> getCrmProjectTrackerWireSaveVOList() {
      return this.crmProjectTrackerWireSaveVOList;
   }

   public String getInfoSource() {
      return this.infoSource;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Boolean getIsProjectManagerCoordinate() {
      return this.isProjectManagerCoordinate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setTypeOfContractorId(final Long typeOfContractorId) {
      this.typeOfContractorId = typeOfContractorId;
   }

   public void setKeyProjectId(final Long keyProjectId) {
      this.keyProjectId = keyProjectId;
   }

   public void setItemCategoryId(final Long itemCategoryId) {
      this.itemCategoryId = itemCategoryId;
   }

   public void setConfigurationOfArchitecturalFormId(final Long configurationOfArchitecturalFormId) {
      this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
   }

   public void setStructureTypeConfigurationId(final Long structureTypeConfigurationId) {
      this.structureTypeConfigurationId = structureTypeConfigurationId;
   }

   public void setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
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

   public void setProjectOverview(final String projectOverview) {
      this.projectOverview = projectOverview;
   }

   public void setEstimatedWorks(final BigDecimal estimatedWorks) {
      this.estimatedWorks = estimatedWorks;
   }

   public void setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
   }

   public void setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
   }

   public void setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
   }

   public void setFileFormatId(final Long fileFormatId) {
      this.fileFormatId = fileFormatId;
   }

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public void setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
   }

   public void setProjectAttachments(final List<AttachmentDTO> projectAttachments) {
      this.projectAttachments = projectAttachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("aUnitClassConfigurationId")
   public void setAUnitClassConfigurationId(final Long aUnitClassConfigurationId) {
      this.aUnitClassConfigurationId = aUnitClassConfigurationId;
   }

   @JsonProperty("aUnitClassConfigurationContactName")
   public void setAUnitClassConfigurationContactName(final String aUnitClassConfigurationContactName) {
      this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
   }

   @JsonProperty("aUnitClassConfigurationOffice")
   public void setAUnitClassConfigurationOffice(final String aUnitClassConfigurationOffice) {
      this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
   }

   @JsonProperty("aUnitClassConfigurationPhone")
   public void setAUnitClassConfigurationPhone(final String aUnitClassConfigurationPhone) {
      this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
   }

   @JsonProperty("bUnitClassConfigurationId")
   public void setBUnitClassConfigurationId(final Long bUnitClassConfigurationId) {
      this.bUnitClassConfigurationId = bUnitClassConfigurationId;
   }

   @JsonProperty("bUnitClassConfigurationContactName")
   public void setBUnitClassConfigurationContactName(final String bUnitClassConfigurationContactName) {
      this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
   }

   @JsonProperty("bUnitClassConfigurationOffice")
   public void setBUnitClassConfigurationOffice(final String bUnitClassConfigurationOffice) {
      this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
   }

   @JsonProperty("bUnitClassConfigurationPhone")
   public void setBUnitClassConfigurationPhone(final String bUnitClassConfigurationPhone) {
      this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
   }

   @JsonProperty("cUnitClassConfigurationId")
   public void setCUnitClassConfigurationId(final Long cUnitClassConfigurationId) {
      this.cUnitClassConfigurationId = cUnitClassConfigurationId;
   }

   @JsonProperty("cUnitClassConfigurationContactName")
   public void setCUnitClassConfigurationContactName(final String cUnitClassConfigurationContactName) {
      this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
   }

   @JsonProperty("cUnitClassConfigurationOffice")
   public void setCUnitClassConfigurationOffice(final String cUnitClassConfigurationOffice) {
      this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
   }

   @JsonProperty("cUnitClassConfigurationPhone")
   public void setCUnitClassConfigurationPhone(final String cUnitClassConfigurationPhone) {
      this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
   }

   @JsonProperty("dUnitClassConfigurationId")
   public void setDUnitClassConfigurationId(final Long dUnitClassConfigurationId) {
      this.dUnitClassConfigurationId = dUnitClassConfigurationId;
   }

   @JsonProperty("dUnitClassConfigurationContactName")
   public void setDUnitClassConfigurationContactName(final String dUnitClassConfigurationContactName) {
      this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
   }

   @JsonProperty("dUnitClassConfigurationOffice")
   public void setDUnitClassConfigurationOffice(final String dUnitClassConfigurationOffice) {
      this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
   }

   @JsonProperty("dUnitClassConfigurationPhone")
   public void setDUnitClassConfigurationPhone(final String dUnitClassConfigurationPhone) {
      this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
   }

   @JsonProperty("eUnitClassConfigurationId")
   public void setEUnitClassConfigurationId(final Long eUnitClassConfigurationId) {
      this.eUnitClassConfigurationId = eUnitClassConfigurationId;
   }

   @JsonProperty("eUnitClassConfigurationContactName")
   public void setEUnitClassConfigurationContactName(final String eUnitClassConfigurationContactName) {
      this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
   }

   @JsonProperty("eUnitClassConfigurationOffice")
   public void setEUnitClassConfigurationOffice(final String eUnitClassConfigurationOffice) {
      this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
   }

   @JsonProperty("eUnitClassConfigurationPhone")
   public void setEUnitClassConfigurationPhone(final String eUnitClassConfigurationPhone) {
      this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
   }

   public void setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
   }

   public void setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
   }

   public void setCrmProjectTrackerWireSaveVOList(final List<CrmProjectTrackerWireSaveVO> crmProjectTrackerWireSaveVOList) {
      this.crmProjectTrackerWireSaveVOList = crmProjectTrackerWireSaveVOList;
   }

   public void setInfoSource(final String infoSource) {
      this.infoSource = infoSource;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setIsProjectManagerCoordinate(final Boolean isProjectManagerCoordinate) {
      this.isProjectManagerCoordinate = isProjectManagerCoordinate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationWarehousingUpdateVO)) {
         return false;
      }

      CrmProjectInformationWarehousingUpdateVO other = (CrmProjectInformationWarehousingUpdateVO)o;
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
               Object this$typeOfContractorId = this.getTypeOfContractorId();
               Object other$typeOfContractorId = other.getTypeOfContractorId();
               if (this$typeOfContractorId == null ? other$typeOfContractorId == null : this$typeOfContractorId.equals(other$typeOfContractorId)) {
                  Object this$keyProjectId = this.getKeyProjectId();
                  Object other$keyProjectId = other.getKeyProjectId();
                  if (this$keyProjectId == null ? other$keyProjectId == null : this$keyProjectId.equals(other$keyProjectId)) {
                     Object this$itemCategoryId = this.getItemCategoryId();
                     Object other$itemCategoryId = other.getItemCategoryId();
                     if (this$itemCategoryId == null ? other$itemCategoryId == null : this$itemCategoryId.equals(other$itemCategoryId)) {
                        Object this$configurationOfArchitecturalFormId = this.getConfigurationOfArchitecturalFormId();
                        Object other$configurationOfArchitecturalFormId = other.getConfigurationOfArchitecturalFormId();
                        if (this$configurationOfArchitecturalFormId == null
                           ? other$configurationOfArchitecturalFormId == null
                           : this$configurationOfArchitecturalFormId.equals(other$configurationOfArchitecturalFormId)) {
                           Object this$structureTypeConfigurationId = this.getStructureTypeConfigurationId();
                           Object other$structureTypeConfigurationId = other.getStructureTypeConfigurationId();
                           if (this$structureTypeConfigurationId == null
                              ? other$structureTypeConfigurationId == null
                              : this$structureTypeConfigurationId.equals(other$structureTypeConfigurationId)) {
                              Object this$industryConfigurationId = this.getIndustryConfigurationId();
                              Object other$industryConfigurationId = other.getIndustryConfigurationId();
                              if (this$industryConfigurationId == null
                                 ? other$industryConfigurationId == null
                                 : this$industryConfigurationId.equals(other$industryConfigurationId)) {
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
                                             Object this$biddingMethodId = this.getBiddingMethodId();
                                             Object other$biddingMethodId = other.getBiddingMethodId();
                                             if (this$biddingMethodId == null
                                                ? other$biddingMethodId == null
                                                : this$biddingMethodId.equals(other$biddingMethodId)) {
                                                Object this$fileFormatId = this.getFileFormatId();
                                                Object other$fileFormatId = other.getFileFormatId();
                                                if (this$fileFormatId == null ? other$fileFormatId == null : this$fileFormatId.equals(other$fileFormatId)) {
                                                   Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
                                                   Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
                                                   if (this$crmEnterpriseWarehousingId == null
                                                      ? other$crmEnterpriseWarehousingId == null
                                                      : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
                                                      Object this$difficultyFactorId = this.getDifficultyFactorId();
                                                      Object other$difficultyFactorId = other.getDifficultyFactorId();
                                                      if (this$difficultyFactorId == null
                                                         ? other$difficultyFactorId == null
                                                         : this$difficultyFactorId.equals(other$difficultyFactorId)) {
                                                         Object this$aUnitClassConfigurationId = this.getAUnitClassConfigurationId();
                                                         Object other$aUnitClassConfigurationId = other.getAUnitClassConfigurationId();
                                                         if (this$aUnitClassConfigurationId == null
                                                            ? other$aUnitClassConfigurationId == null
                                                            : this$aUnitClassConfigurationId.equals(other$aUnitClassConfigurationId)) {
                                                            Object this$bUnitClassConfigurationId = this.getBUnitClassConfigurationId();
                                                            Object other$bUnitClassConfigurationId = other.getBUnitClassConfigurationId();
                                                            if (this$bUnitClassConfigurationId == null
                                                               ? other$bUnitClassConfigurationId == null
                                                               : this$bUnitClassConfigurationId.equals(other$bUnitClassConfigurationId)) {
                                                               Object this$cUnitClassConfigurationId = this.getCUnitClassConfigurationId();
                                                               Object other$cUnitClassConfigurationId = other.getCUnitClassConfigurationId();
                                                               if (this$cUnitClassConfigurationId == null
                                                                  ? other$cUnitClassConfigurationId == null
                                                                  : this$cUnitClassConfigurationId.equals(other$cUnitClassConfigurationId)) {
                                                                  Object this$dUnitClassConfigurationId = this.getDUnitClassConfigurationId();
                                                                  Object other$dUnitClassConfigurationId = other.getDUnitClassConfigurationId();
                                                                  if (this$dUnitClassConfigurationId == null
                                                                     ? other$dUnitClassConfigurationId == null
                                                                     : this$dUnitClassConfigurationId.equals(other$dUnitClassConfigurationId)) {
                                                                     Object this$eUnitClassConfigurationId = this.getEUnitClassConfigurationId();
                                                                     Object other$eUnitClassConfigurationId = other.getEUnitClassConfigurationId();
                                                                     if (this$eUnitClassConfigurationId == null
                                                                        ? other$eUnitClassConfigurationId == null
                                                                        : this$eUnitClassConfigurationId.equals(other$eUnitClassConfigurationId)) {
                                                                        Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                                                                        Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                                                                        if (this$crmCountryTypeEnum == null
                                                                           ? other$crmCountryTypeEnum == null
                                                                           : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
                                                                           Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
                                                                           Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
                                                                           if (this$crmProjectScheduleTypeEnum == null
                                                                              ? other$crmProjectScheduleTypeEnum == null
                                                                              : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
                                                                              Object this$isProjectManagerCoordinate = this.getIsProjectManagerCoordinate();
                                                                              Object other$isProjectManagerCoordinate = other.getIsProjectManagerCoordinate();
                                                                              if (this$isProjectManagerCoordinate == null
                                                                                 ? other$isProjectManagerCoordinate == null
                                                                                 : this$isProjectManagerCoordinate.equals(other$isProjectManagerCoordinate)) {
                                                                                 Object this$informantDateTime = this.getInformantDateTime();
                                                                                 Object other$informantDateTime = other.getInformantDateTime();
                                                                                 if (this$informantDateTime == null
                                                                                    ? other$informantDateTime == null
                                                                                    : this$informantDateTime.equals(other$informantDateTime)) {
                                                                                    Object this$projectName = this.getProjectName();
                                                                                    Object other$projectName = other.getProjectName();
                                                                                    if (this$projectName == null
                                                                                       ? other$projectName == null
                                                                                       : this$projectName.equals(other$projectName)) {
                                                                                       Object this$projectSerialNumber = this.getProjectSerialNumber();
                                                                                       Object other$projectSerialNumber = other.getProjectSerialNumber();
                                                                                       if (this$projectSerialNumber == null
                                                                                          ? other$projectSerialNumber == null
                                                                                          : this$projectSerialNumber.equals(other$projectSerialNumber)) {
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
                                                                                                      Object this$address = this.getAddress();
                                                                                                      Object other$address = other.getAddress();
                                                                                                      if (this$address == null
                                                                                                         ? other$address == null
                                                                                                         : this$address.equals(other$address)) {
                                                                                                         Object this$projectOverview = this.getProjectOverview();
                                                                                                         Object other$projectOverview = other.getProjectOverview();
                                                                                                         if (this$projectOverview == null
                                                                                                            ? other$projectOverview == null
                                                                                                            : this$projectOverview.equals(other$projectOverview)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$estimatedWorks = this.getEstimatedWorks();
                                                                                                            Object other$estimatedWorks = other.getEstimatedWorks();
                                                                                                            if (this$estimatedWorks == null
                                                                                                               ? other$estimatedWorks == null
                                                                                                               : this$estimatedWorks.equals(
                                                                                                                  other$estimatedWorks
                                                                                                               )) {
                                                                                                               Object this$estimatedCost = this.getEstimatedCost();
                                                                                                               Object other$estimatedCost = other.getEstimatedCost();
                                                                                                               if (this$estimatedCost == null
                                                                                                                  ? other$estimatedCost == null
                                                                                                                  : this$estimatedCost.equals(
                                                                                                                     other$estimatedCost
                                                                                                                  )) {
                                                                                                                  Object this$areaOfStructure = this.getAreaOfStructure();
                                                                                                                  Object other$areaOfStructure = other.getAreaOfStructure();
                                                                                                                  if (this$areaOfStructure == null
                                                                                                                     ? other$areaOfStructure == null
                                                                                                                     : this$areaOfStructure.equals(
                                                                                                                        other$areaOfStructure
                                                                                                                     )) {
                                                                                                                     Object this$projectAttachments = this.getProjectAttachments();
                                                                                                                     Object other$projectAttachments = other.getProjectAttachments();
                                                                                                                     if (this$projectAttachments == null
                                                                                                                        ? other$projectAttachments == null
                                                                                                                        : this$projectAttachments.equals(
                                                                                                                           other$projectAttachments
                                                                                                                        )) {
                                                                                                                        Object this$remark = this.getRemark();
                                                                                                                        Object other$remark = other.getRemark();
                                                                                                                        if (this$remark == null
                                                                                                                           ? other$remark == null
                                                                                                                           : this$remark.equals(other$remark)) {
                                                                                                                           Object this$aUnitClassConfigurationContactName = this.getAUnitClassConfigurationContactName();
                                                                                                                           Object other$aUnitClassConfigurationContactName = other.getAUnitClassConfigurationContactName();
                                                                                                                           if (this$aUnitClassConfigurationContactName
                                                                                                                                 == null
                                                                                                                              ? other$aUnitClassConfigurationContactName
                                                                                                                                 == null
                                                                                                                              : this$aUnitClassConfigurationContactName.equals(
                                                                                                                                 other$aUnitClassConfigurationContactName
                                                                                                                              )) {
                                                                                                                              Object this$aUnitClassConfigurationOffice = this.getAUnitClassConfigurationOffice();
                                                                                                                              Object other$aUnitClassConfigurationOffice = other.getAUnitClassConfigurationOffice();
                                                                                                                              if (this$aUnitClassConfigurationOffice
                                                                                                                                    == null
                                                                                                                                 ? other$aUnitClassConfigurationOffice
                                                                                                                                    == null
                                                                                                                                 : this$aUnitClassConfigurationOffice.equals(
                                                                                                                                    other$aUnitClassConfigurationOffice
                                                                                                                                 )) {
                                                                                                                                 Object this$aUnitClassConfigurationPhone = this.getAUnitClassConfigurationPhone();
                                                                                                                                 Object other$aUnitClassConfigurationPhone = other.getAUnitClassConfigurationPhone();
                                                                                                                                 if (this$aUnitClassConfigurationPhone
                                                                                                                                       == null
                                                                                                                                    ? other$aUnitClassConfigurationPhone
                                                                                                                                       == null
                                                                                                                                    : this$aUnitClassConfigurationPhone.equals(
                                                                                                                                       other$aUnitClassConfigurationPhone
                                                                                                                                    )) {
                                                                                                                                    Object this$bUnitClassConfigurationContactName = this.getBUnitClassConfigurationContactName();
                                                                                                                                    Object other$bUnitClassConfigurationContactName = other.getBUnitClassConfigurationContactName();
                                                                                                                                    if (this$bUnitClassConfigurationContactName
                                                                                                                                          == null
                                                                                                                                       ? other$bUnitClassConfigurationContactName
                                                                                                                                          == null
                                                                                                                                       : this$bUnitClassConfigurationContactName.equals(
                                                                                                                                          other$bUnitClassConfigurationContactName
                                                                                                                                       )) {
                                                                                                                                       Object this$bUnitClassConfigurationOffice = this.getBUnitClassConfigurationOffice();
                                                                                                                                       Object other$bUnitClassConfigurationOffice = other.getBUnitClassConfigurationOffice();
                                                                                                                                       if (this$bUnitClassConfigurationOffice
                                                                                                                                             == null
                                                                                                                                          ? other$bUnitClassConfigurationOffice
                                                                                                                                             == null
                                                                                                                                          : this$bUnitClassConfigurationOffice.equals(
                                                                                                                                             other$bUnitClassConfigurationOffice
                                                                                                                                          )) {
                                                                                                                                          Object this$bUnitClassConfigurationPhone = this.getBUnitClassConfigurationPhone();
                                                                                                                                          Object other$bUnitClassConfigurationPhone = other.getBUnitClassConfigurationPhone();
                                                                                                                                          if (this$bUnitClassConfigurationPhone
                                                                                                                                                == null
                                                                                                                                             ? other$bUnitClassConfigurationPhone
                                                                                                                                                == null
                                                                                                                                             : this$bUnitClassConfigurationPhone.equals(
                                                                                                                                                other$bUnitClassConfigurationPhone
                                                                                                                                             )) {
                                                                                                                                             Object this$cUnitClassConfigurationContactName = this.getCUnitClassConfigurationContactName();
                                                                                                                                             Object other$cUnitClassConfigurationContactName = other.getCUnitClassConfigurationContactName();
                                                                                                                                             if (this$cUnitClassConfigurationContactName
                                                                                                                                                   == null
                                                                                                                                                ? other$cUnitClassConfigurationContactName
                                                                                                                                                   == null
                                                                                                                                                : this$cUnitClassConfigurationContactName.equals(
                                                                                                                                                   other$cUnitClassConfigurationContactName
                                                                                                                                                )) {
                                                                                                                                                Object this$cUnitClassConfigurationOffice = this.getCUnitClassConfigurationOffice();
                                                                                                                                                Object other$cUnitClassConfigurationOffice = other.getCUnitClassConfigurationOffice();
                                                                                                                                                if (this$cUnitClassConfigurationOffice
                                                                                                                                                      == null
                                                                                                                                                   ? other$cUnitClassConfigurationOffice
                                                                                                                                                      == null
                                                                                                                                                   : this$cUnitClassConfigurationOffice.equals(
                                                                                                                                                      other$cUnitClassConfigurationOffice
                                                                                                                                                   )) {
                                                                                                                                                   Object this$cUnitClassConfigurationPhone = this.getCUnitClassConfigurationPhone();
                                                                                                                                                   Object other$cUnitClassConfigurationPhone = other.getCUnitClassConfigurationPhone();
                                                                                                                                                   if (this$cUnitClassConfigurationPhone
                                                                                                                                                         == null
                                                                                                                                                      ? other$cUnitClassConfigurationPhone
                                                                                                                                                         == null
                                                                                                                                                      : this$cUnitClassConfigurationPhone.equals(
                                                                                                                                                         other$cUnitClassConfigurationPhone
                                                                                                                                                      )) {
                                                                                                                                                      Object this$dUnitClassConfigurationContactName = this.getDUnitClassConfigurationContactName();
                                                                                                                                                      Object other$dUnitClassConfigurationContactName = other.getDUnitClassConfigurationContactName();
                                                                                                                                                      if (this$dUnitClassConfigurationContactName
                                                                                                                                                            == null
                                                                                                                                                         ? other$dUnitClassConfigurationContactName
                                                                                                                                                            == null
                                                                                                                                                         : this$dUnitClassConfigurationContactName.equals(
                                                                                                                                                            other$dUnitClassConfigurationContactName
                                                                                                                                                         )) {
                                                                                                                                                         Object this$dUnitClassConfigurationOffice = this.getDUnitClassConfigurationOffice();
                                                                                                                                                         Object other$dUnitClassConfigurationOffice = other.getDUnitClassConfigurationOffice();
                                                                                                                                                         if (this$dUnitClassConfigurationOffice
                                                                                                                                                               == null
                                                                                                                                                            ? other$dUnitClassConfigurationOffice
                                                                                                                                                               == null
                                                                                                                                                            : this$dUnitClassConfigurationOffice.equals(
                                                                                                                                                               other$dUnitClassConfigurationOffice
                                                                                                                                                            )) {
                                                                                                                                                            Object this$dUnitClassConfigurationPhone = this.getDUnitClassConfigurationPhone();
                                                                                                                                                            Object other$dUnitClassConfigurationPhone = other.getDUnitClassConfigurationPhone();
                                                                                                                                                            if (this$dUnitClassConfigurationPhone
                                                                                                                                                                  == null
                                                                                                                                                               ? other$dUnitClassConfigurationPhone
                                                                                                                                                                  == null
                                                                                                                                                               : this$dUnitClassConfigurationPhone.equals(
                                                                                                                                                                  other$dUnitClassConfigurationPhone
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$eUnitClassConfigurationContactName = this.getEUnitClassConfigurationContactName();
                                                                                                                                                               Object other$eUnitClassConfigurationContactName = other.getEUnitClassConfigurationContactName();
                                                                                                                                                               if (this$eUnitClassConfigurationContactName
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$eUnitClassConfigurationContactName
                                                                                                                                                                     == null
                                                                                                                                                                  : this$eUnitClassConfigurationContactName.equals(
                                                                                                                                                                     other$eUnitClassConfigurationContactName
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$eUnitClassConfigurationOffice = this.getEUnitClassConfigurationOffice();
                                                                                                                                                                  Object other$eUnitClassConfigurationOffice = other.getEUnitClassConfigurationOffice();
                                                                                                                                                                  if (this$eUnitClassConfigurationOffice
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$eUnitClassConfigurationOffice
                                                                                                                                                                        == null
                                                                                                                                                                     : this$eUnitClassConfigurationOffice.equals(
                                                                                                                                                                        other$eUnitClassConfigurationOffice
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$eUnitClassConfigurationPhone = this.getEUnitClassConfigurationPhone();
                                                                                                                                                                     Object other$eUnitClassConfigurationPhone = other.getEUnitClassConfigurationPhone();
                                                                                                                                                                     if (this$eUnitClassConfigurationPhone
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$eUnitClassConfigurationPhone
                                                                                                                                                                           == null
                                                                                                                                                                        : this$eUnitClassConfigurationPhone.equals(
                                                                                                                                                                           other$eUnitClassConfigurationPhone
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$crmProjectTrackerWireSaveVOList = this.getCrmProjectTrackerWireSaveVOList();
                                                                                                                                                                        Object other$crmProjectTrackerWireSaveVOList = other.getCrmProjectTrackerWireSaveVOList();
                                                                                                                                                                        if (this$crmProjectTrackerWireSaveVOList
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$crmProjectTrackerWireSaveVOList
                                                                                                                                                                              == null
                                                                                                                                                                           : this$crmProjectTrackerWireSaveVOList.equals(
                                                                                                                                                                              other$crmProjectTrackerWireSaveVOList
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$infoSource = this.getInfoSource();
                                                                                                                                                                           Object other$infoSource = other.getInfoSource();
                                                                                                                                                                           if (this$infoSource
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$infoSource
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$infoSource.equals(
                                                                                                                                                                                 other$infoSource
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$projectManagerName = this.getProjectManagerName();
                                                                                                                                                                              Object other$projectManagerName = other.getProjectManagerName();
                                                                                                                                                                              return this$projectManagerName
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$projectManagerName
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$projectManagerName.equals(
                                                                                                                                                                                    other$projectManagerName
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
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CrmProjectInformationWarehousingUpdateVO;
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
      Object $typeOfContractorId = this.getTypeOfContractorId();
      result = result * 59 + ($typeOfContractorId == null ? 43 : $typeOfContractorId.hashCode());
      Object $keyProjectId = this.getKeyProjectId();
      result = result * 59 + ($keyProjectId == null ? 43 : $keyProjectId.hashCode());
      Object $itemCategoryId = this.getItemCategoryId();
      result = result * 59 + ($itemCategoryId == null ? 43 : $itemCategoryId.hashCode());
      Object $configurationOfArchitecturalFormId = this.getConfigurationOfArchitecturalFormId();
      result = result * 59 + ($configurationOfArchitecturalFormId == null ? 43 : $configurationOfArchitecturalFormId.hashCode());
      Object $structureTypeConfigurationId = this.getStructureTypeConfigurationId();
      result = result * 59 + ($structureTypeConfigurationId == null ? 43 : $structureTypeConfigurationId.hashCode());
      Object $industryConfigurationId = this.getIndustryConfigurationId();
      result = result * 59 + ($industryConfigurationId == null ? 43 : $industryConfigurationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $biddingMethodId = this.getBiddingMethodId();
      result = result * 59 + ($biddingMethodId == null ? 43 : $biddingMethodId.hashCode());
      Object $fileFormatId = this.getFileFormatId();
      result = result * 59 + ($fileFormatId == null ? 43 : $fileFormatId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $difficultyFactorId = this.getDifficultyFactorId();
      result = result * 59 + ($difficultyFactorId == null ? 43 : $difficultyFactorId.hashCode());
      Object $aUnitClassConfigurationId = this.getAUnitClassConfigurationId();
      result = result * 59 + ($aUnitClassConfigurationId == null ? 43 : $aUnitClassConfigurationId.hashCode());
      Object $bUnitClassConfigurationId = this.getBUnitClassConfigurationId();
      result = result * 59 + ($bUnitClassConfigurationId == null ? 43 : $bUnitClassConfigurationId.hashCode());
      Object $cUnitClassConfigurationId = this.getCUnitClassConfigurationId();
      result = result * 59 + ($cUnitClassConfigurationId == null ? 43 : $cUnitClassConfigurationId.hashCode());
      Object $dUnitClassConfigurationId = this.getDUnitClassConfigurationId();
      result = result * 59 + ($dUnitClassConfigurationId == null ? 43 : $dUnitClassConfigurationId.hashCode());
      Object $eUnitClassConfigurationId = this.getEUnitClassConfigurationId();
      result = result * 59 + ($eUnitClassConfigurationId == null ? 43 : $eUnitClassConfigurationId.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $isProjectManagerCoordinate = this.getIsProjectManagerCoordinate();
      result = result * 59 + ($isProjectManagerCoordinate == null ? 43 : $isProjectManagerCoordinate.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
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
      Object $projectOverview = this.getProjectOverview();
      result = result * 59 + ($projectOverview == null ? 43 : $projectOverview.hashCode());
      Object $estimatedWorks = this.getEstimatedWorks();
      result = result * 59 + ($estimatedWorks == null ? 43 : $estimatedWorks.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $projectAttachments = this.getProjectAttachments();
      result = result * 59 + ($projectAttachments == null ? 43 : $projectAttachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $aUnitClassConfigurationContactName = this.getAUnitClassConfigurationContactName();
      result = result * 59 + ($aUnitClassConfigurationContactName == null ? 43 : $aUnitClassConfigurationContactName.hashCode());
      Object $aUnitClassConfigurationOffice = this.getAUnitClassConfigurationOffice();
      result = result * 59 + ($aUnitClassConfigurationOffice == null ? 43 : $aUnitClassConfigurationOffice.hashCode());
      Object $aUnitClassConfigurationPhone = this.getAUnitClassConfigurationPhone();
      result = result * 59 + ($aUnitClassConfigurationPhone == null ? 43 : $aUnitClassConfigurationPhone.hashCode());
      Object $bUnitClassConfigurationContactName = this.getBUnitClassConfigurationContactName();
      result = result * 59 + ($bUnitClassConfigurationContactName == null ? 43 : $bUnitClassConfigurationContactName.hashCode());
      Object $bUnitClassConfigurationOffice = this.getBUnitClassConfigurationOffice();
      result = result * 59 + ($bUnitClassConfigurationOffice == null ? 43 : $bUnitClassConfigurationOffice.hashCode());
      Object $bUnitClassConfigurationPhone = this.getBUnitClassConfigurationPhone();
      result = result * 59 + ($bUnitClassConfigurationPhone == null ? 43 : $bUnitClassConfigurationPhone.hashCode());
      Object $cUnitClassConfigurationContactName = this.getCUnitClassConfigurationContactName();
      result = result * 59 + ($cUnitClassConfigurationContactName == null ? 43 : $cUnitClassConfigurationContactName.hashCode());
      Object $cUnitClassConfigurationOffice = this.getCUnitClassConfigurationOffice();
      result = result * 59 + ($cUnitClassConfigurationOffice == null ? 43 : $cUnitClassConfigurationOffice.hashCode());
      Object $cUnitClassConfigurationPhone = this.getCUnitClassConfigurationPhone();
      result = result * 59 + ($cUnitClassConfigurationPhone == null ? 43 : $cUnitClassConfigurationPhone.hashCode());
      Object $dUnitClassConfigurationContactName = this.getDUnitClassConfigurationContactName();
      result = result * 59 + ($dUnitClassConfigurationContactName == null ? 43 : $dUnitClassConfigurationContactName.hashCode());
      Object $dUnitClassConfigurationOffice = this.getDUnitClassConfigurationOffice();
      result = result * 59 + ($dUnitClassConfigurationOffice == null ? 43 : $dUnitClassConfigurationOffice.hashCode());
      Object $dUnitClassConfigurationPhone = this.getDUnitClassConfigurationPhone();
      result = result * 59 + ($dUnitClassConfigurationPhone == null ? 43 : $dUnitClassConfigurationPhone.hashCode());
      Object $eUnitClassConfigurationContactName = this.getEUnitClassConfigurationContactName();
      result = result * 59 + ($eUnitClassConfigurationContactName == null ? 43 : $eUnitClassConfigurationContactName.hashCode());
      Object $eUnitClassConfigurationOffice = this.getEUnitClassConfigurationOffice();
      result = result * 59 + ($eUnitClassConfigurationOffice == null ? 43 : $eUnitClassConfigurationOffice.hashCode());
      Object $eUnitClassConfigurationPhone = this.getEUnitClassConfigurationPhone();
      result = result * 59 + ($eUnitClassConfigurationPhone == null ? 43 : $eUnitClassConfigurationPhone.hashCode());
      Object $crmProjectTrackerWireSaveVOList = this.getCrmProjectTrackerWireSaveVOList();
      result = result * 59 + ($crmProjectTrackerWireSaveVOList == null ? 43 : $crmProjectTrackerWireSaveVOList.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      return result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectInformationWarehousingUpdateVO(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", typeOfContractorId="
         + this.getTypeOfContractorId()
         + ", keyProjectId="
         + this.getKeyProjectId()
         + ", itemCategoryId="
         + this.getItemCategoryId()
         + ", configurationOfArchitecturalFormId="
         + this.getConfigurationOfArchitecturalFormId()
         + ", structureTypeConfigurationId="
         + this.getStructureTypeConfigurationId()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
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
         + ", projectOverview="
         + this.getProjectOverview()
         + ", estimatedWorks="
         + this.getEstimatedWorks()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", areaOfStructure="
         + this.getAreaOfStructure()
         + ", biddingMethodId="
         + this.getBiddingMethodId()
         + ", fileFormatId="
         + this.getFileFormatId()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", difficultyFactorId="
         + this.getDifficultyFactorId()
         + ", projectAttachments="
         + this.getProjectAttachments()
         + ", remark="
         + this.getRemark()
         + ", aUnitClassConfigurationId="
         + this.getAUnitClassConfigurationId()
         + ", aUnitClassConfigurationContactName="
         + this.getAUnitClassConfigurationContactName()
         + ", aUnitClassConfigurationOffice="
         + this.getAUnitClassConfigurationOffice()
         + ", aUnitClassConfigurationPhone="
         + this.getAUnitClassConfigurationPhone()
         + ", bUnitClassConfigurationId="
         + this.getBUnitClassConfigurationId()
         + ", bUnitClassConfigurationContactName="
         + this.getBUnitClassConfigurationContactName()
         + ", bUnitClassConfigurationOffice="
         + this.getBUnitClassConfigurationOffice()
         + ", bUnitClassConfigurationPhone="
         + this.getBUnitClassConfigurationPhone()
         + ", cUnitClassConfigurationId="
         + this.getCUnitClassConfigurationId()
         + ", cUnitClassConfigurationContactName="
         + this.getCUnitClassConfigurationContactName()
         + ", cUnitClassConfigurationOffice="
         + this.getCUnitClassConfigurationOffice()
         + ", cUnitClassConfigurationPhone="
         + this.getCUnitClassConfigurationPhone()
         + ", dUnitClassConfigurationId="
         + this.getDUnitClassConfigurationId()
         + ", dUnitClassConfigurationContactName="
         + this.getDUnitClassConfigurationContactName()
         + ", dUnitClassConfigurationOffice="
         + this.getDUnitClassConfigurationOffice()
         + ", dUnitClassConfigurationPhone="
         + this.getDUnitClassConfigurationPhone()
         + ", eUnitClassConfigurationId="
         + this.getEUnitClassConfigurationId()
         + ", eUnitClassConfigurationContactName="
         + this.getEUnitClassConfigurationContactName()
         + ", eUnitClassConfigurationOffice="
         + this.getEUnitClassConfigurationOffice()
         + ", eUnitClassConfigurationPhone="
         + this.getEUnitClassConfigurationPhone()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", crmProjectTrackerWireSaveVOList="
         + this.getCrmProjectTrackerWireSaveVOList()
         + ", infoSource="
         + this.getInfoSource()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", isProjectManagerCoordinate="
         + this.getIsProjectManagerCoordinate()
         + ")";
   }

   public CrmProjectInformationWarehousingUpdateVO() {
   }
}
