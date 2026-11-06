package com.hzchum.scim.crm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmProjectInformationWarehousingDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "departmentId", value = "所属部门id", notes = "所属部门id")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "所属部门", notes = "所属部门")
   private String departmentName;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号", notes = "项目编号")
   private String projectSerialNumber;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "typeOfContractorId", value = "承建类别 CrmProjectInformationConfig", notes = "承建类别 CrmProjectInformationConfig")
   private Long typeOfContractorId;
   @ApiModelProperty(name = "typeOfContractorName", value = "承建类别 CrmProjectInformationConfig", notes = "承建类别 CrmProjectInformationConfig")
   private String typeOfContractorName;
   @ApiModelProperty(name = "keyProjectId", value = "重点项目CrmProjectInformationConfig", notes = "重点项目CrmProjectInformationConfig")
   private Long keyProjectId;
   @ApiModelProperty(name = "keyProjectName", value = "重点项目CrmProjectInformationConfig", notes = "重点项目CrmProjectInformationConfig")
   private String keyProjectName;
   @ApiModelProperty(name = "itemCategoryId", value = "项目类别 CrmProjectInformationConfig", notes = "项目类别 CrmProjectInformationConfig")
   private Long itemCategoryId;
   @ApiModelProperty(name = "itemCategoryName", value = "项目类别 CrmProjectInformationConfig", notes = "项目类别 CrmProjectInformationConfig")
   private String itemCategoryName;
   @ApiModelProperty(name = "configurationOfArchitecturalFormId", value = "建筑形式 CrmProjectInformationConfig", notes = "建筑形式 CrmProjectInformationConfig")
   private Long configurationOfArchitecturalFormId;
   @ApiModelProperty(name = "configurationOfArchitecturalFormName", value = "建筑形式 CrmProjectInformationConfig", notes = "建筑形式 CrmProjectInformationConfig")
   private String configurationOfArchitecturalFormName;
   @ApiModelProperty(name = "structureTypeConfigurationId", value = "结构类型 CrmProjectInformationConfig", notes = "结构类型 CrmProjectInformationConfig")
   private Long structureTypeConfigurationId;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型 CrmProjectInformationConfig", notes = "结构类型 CrmProjectInformationConfig")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "industryConfigurationId", value = "所属行业 CrmBasicsConfig", notes = "所属行业 CrmBasicsConfig")
   private Long industryConfigurationId;
   @ApiModelProperty(name = "industryConfigurationName", value = "所属行业 CrmBasicsConfig", notes = "所属行业 CrmBasicsConfig")
   private String industryConfigurationName;
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
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "aUnitClassConfigurationId", value = "建设单位", notes = "建设单位")
   @JsonProperty("aUnitClassConfigurationId")
   private Long aUnitClassConfigurationId;
   @ApiModelProperty(name = "aUnitClassConfigurationName", value = "建设单位名称", notes = "建设单位名称")
   @JsonProperty("aUnitClassConfigurationName")
   private String aUnitClassConfigurationName;
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
   @ApiModelProperty(name = "bUnitClassConfigurationName", value = "代建单位名称", notes = "代建单位名称")
   @JsonProperty("bUnitClassConfigurationName")
   private String bUnitClassConfigurationName;
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
   @ApiModelProperty(name = "cUnitClassConfigurationName", value = "EPC单位名称", notes = "EPC单位名称")
   @JsonProperty("cUnitClassConfigurationName")
   private String cUnitClassConfigurationName;
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
   @ApiModelProperty(name = "dUnitClassConfigurationName", value = "设计单位名称", notes = "设计单位名称")
   @JsonProperty("dUnitClassConfigurationName")
   private String dUnitClassConfigurationName;
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
   @ApiModelProperty(name = "eUnitClassConfigurationName", value = "总包单位名称", notes = "总包单位名称")
   @JsonProperty("eUnitClassConfigurationName")
   private String eUnitClassConfigurationName;
   @ApiModelProperty(name = "eUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @JsonProperty("eUnitClassConfigurationContactName")
   private String eUnitClassConfigurationContactName;
   @ApiModelProperty(name = "eUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @JsonProperty("eUnitClassConfigurationOffice")
   private String eUnitClassConfigurationOffice;
   @ApiModelProperty(name = "eUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @JsonProperty("eUnitClassConfigurationPhone")
   private String eUnitClassConfigurationPhone;
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
   @ApiModelProperty(name = "biddingMethodName", value = "招标方式  CrmTenderRequestConfig", notes = "招标方式  CrmTenderRequestConfig")
   private String biddingMethodName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "difficultyFactorId", value = "难度系数 CrmProjectInformationConfig", notes = "难度系数 CrmProjectInformationConfig")
   private Long difficultyFactorId;
   @ApiModelProperty(name = "difficultyFactorName", value = "难度系数 CrmProjectInformationConfig", notes = "难度系数 CrmProjectInformationConfig")
   private String difficultyFactorName;
   @ApiModelProperty(name = "isProjectManagerCoordinate", value = "是否项目经理配合", notes = "是否项目经理配合")
   private Boolean isProjectManagerCoordinate;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "projectLevelConfigId", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   private Long projectLevelConfigId;
   @ApiModelProperty(name = "projectLevelConfigName", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "projectAttachmentList", value = "项目附件列表", notes = "项目附件列表")
   private List<AttachmentDTO> projectAttachmentList;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "infoSource", value = "信息来源 参考字典 ")
   private String infoSource;
   @ApiModelProperty(name = "projectManagerName", notes = "项目（销售）经理")
   private String projectManagerName;

   public static CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder builder() {
      return new CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder();
   }

   public CrmProjectInformationWarehousingDetailDTO() {
   }

   public CrmProjectInformationWarehousingDetailDTO(
      final Long id,
      final Long informantUserId,
      final String informantUserName,
      final LocalDateTime informantDateTime,
      final Long createUserId,
      final String createUserName,
      final Integer crmCheckStatusEnum,
      final Long departmentId,
      final String departmentName,
      final Long approveRecordId,
      final String projectName,
      final String projectSerialNumber,
      final String serialNumber,
      final Long typeOfContractorId,
      final String typeOfContractorName,
      final Long keyProjectId,
      final String keyProjectName,
      final Long itemCategoryId,
      final String itemCategoryName,
      final Long configurationOfArchitecturalFormId,
      final String configurationOfArchitecturalFormName,
      final Long structureTypeConfigurationId,
      final String structureTypeConfigurationName,
      final Long industryConfigurationId,
      final String industryConfigurationName,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String address,
      final Integer crmCountryTypeEnum,
      final Long aUnitClassConfigurationId,
      final String aUnitClassConfigurationName,
      final String aUnitClassConfigurationContactName,
      final String aUnitClassConfigurationOffice,
      final String aUnitClassConfigurationPhone,
      final Long bUnitClassConfigurationId,
      final String bUnitClassConfigurationName,
      final String bUnitClassConfigurationContactName,
      final String bUnitClassConfigurationOffice,
      final String bUnitClassConfigurationPhone,
      final Long cUnitClassConfigurationId,
      final String cUnitClassConfigurationName,
      final String cUnitClassConfigurationContactName,
      final String cUnitClassConfigurationOffice,
      final String cUnitClassConfigurationPhone,
      final Long dUnitClassConfigurationId,
      final String dUnitClassConfigurationName,
      final String dUnitClassConfigurationContactName,
      final String dUnitClassConfigurationOffice,
      final String dUnitClassConfigurationPhone,
      final Long eUnitClassConfigurationId,
      final String eUnitClassConfigurationName,
      final String eUnitClassConfigurationContactName,
      final String eUnitClassConfigurationOffice,
      final String eUnitClassConfigurationPhone,
      final String projectOverview,
      final BigDecimal estimatedWorks,
      final BigDecimal estimatedCost,
      final BigDecimal areaOfStructure,
      final Long biddingMethodId,
      final String biddingMethodName,
      final Long crmEnterpriseWarehousingId,
      final String crmEnterpriseWarehousingName,
      final Long difficultyFactorId,
      final String difficultyFactorName,
      final Boolean isProjectManagerCoordinate,
      final List<Long> regionList,
      final Long projectLevelConfigId,
      final String projectLevelConfigName,
      final List<AttachmentDTO> projectAttachmentList,
      final String remark,
      final String infoSource,
      final String projectManagerName
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.informantDateTime = informantDateTime;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.approveRecordId = approveRecordId;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.serialNumber = serialNumber;
      this.typeOfContractorId = typeOfContractorId;
      this.typeOfContractorName = typeOfContractorName;
      this.keyProjectId = keyProjectId;
      this.keyProjectName = keyProjectName;
      this.itemCategoryId = itemCategoryId;
      this.itemCategoryName = itemCategoryName;
      this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
      this.configurationOfArchitecturalFormName = configurationOfArchitecturalFormName;
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.industryConfigurationId = industryConfigurationId;
      this.industryConfigurationName = industryConfigurationName;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.address = address;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.aUnitClassConfigurationId = aUnitClassConfigurationId;
      this.aUnitClassConfigurationName = aUnitClassConfigurationName;
      this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
      this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
      this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
      this.bUnitClassConfigurationId = bUnitClassConfigurationId;
      this.bUnitClassConfigurationName = bUnitClassConfigurationName;
      this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
      this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
      this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
      this.cUnitClassConfigurationId = cUnitClassConfigurationId;
      this.cUnitClassConfigurationName = cUnitClassConfigurationName;
      this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
      this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
      this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
      this.dUnitClassConfigurationId = dUnitClassConfigurationId;
      this.dUnitClassConfigurationName = dUnitClassConfigurationName;
      this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
      this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
      this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
      this.eUnitClassConfigurationId = eUnitClassConfigurationId;
      this.eUnitClassConfigurationName = eUnitClassConfigurationName;
      this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
      this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
      this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
      this.projectOverview = projectOverview;
      this.estimatedWorks = estimatedWorks;
      this.estimatedCost = estimatedCost;
      this.areaOfStructure = areaOfStructure;
      this.biddingMethodId = biddingMethodId;
      this.biddingMethodName = biddingMethodName;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.difficultyFactorId = difficultyFactorId;
      this.difficultyFactorName = difficultyFactorName;
      this.isProjectManagerCoordinate = isProjectManagerCoordinate;
      this.regionList = regionList;
      this.projectLevelConfigId = projectLevelConfigId;
      this.projectLevelConfigName = projectLevelConfigName;
      this.projectAttachmentList = projectAttachmentList;
      this.remark = remark;
      this.infoSource = infoSource;
      this.projectManagerName = projectManagerName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
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

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getTypeOfContractorId() {
      return this.typeOfContractorId;
   }

   public String getTypeOfContractorName() {
      return this.typeOfContractorName;
   }

   public Long getKeyProjectId() {
      return this.keyProjectId;
   }

   public String getKeyProjectName() {
      return this.keyProjectName;
   }

   public Long getItemCategoryId() {
      return this.itemCategoryId;
   }

   public String getItemCategoryName() {
      return this.itemCategoryName;
   }

   public Long getConfigurationOfArchitecturalFormId() {
      return this.configurationOfArchitecturalFormId;
   }

   public String getConfigurationOfArchitecturalFormName() {
      return this.configurationOfArchitecturalFormName;
   }

   public Long getStructureTypeConfigurationId() {
      return this.structureTypeConfigurationId;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
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

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public Long getAUnitClassConfigurationId() {
      return this.aUnitClassConfigurationId;
   }

   public String getAUnitClassConfigurationName() {
      return this.aUnitClassConfigurationName;
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

   public String getBUnitClassConfigurationName() {
      return this.bUnitClassConfigurationName;
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

   public String getCUnitClassConfigurationName() {
      return this.cUnitClassConfigurationName;
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

   public String getDUnitClassConfigurationName() {
      return this.dUnitClassConfigurationName;
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

   public String getEUnitClassConfigurationName() {
      return this.eUnitClassConfigurationName;
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

   public String getBiddingMethodName() {
      return this.biddingMethodName;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getDifficultyFactorId() {
      return this.difficultyFactorId;
   }

   public String getDifficultyFactorName() {
      return this.difficultyFactorName;
   }

   public Boolean getIsProjectManagerCoordinate() {
      return this.isProjectManagerCoordinate;
   }

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public Long getProjectLevelConfigId() {
      return this.projectLevelConfigId;
   }

   public String getProjectLevelConfigName() {
      return this.projectLevelConfigName;
   }

   public List<AttachmentDTO> getProjectAttachmentList() {
      return this.projectAttachmentList;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getInfoSource() {
      return this.infoSource;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public CrmProjectInformationWarehousingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setTypeOfContractorId(final Long typeOfContractorId) {
      this.typeOfContractorId = typeOfContractorId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setTypeOfContractorName(final String typeOfContractorName) {
      this.typeOfContractorName = typeOfContractorName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setKeyProjectId(final Long keyProjectId) {
      this.keyProjectId = keyProjectId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setKeyProjectName(final String keyProjectName) {
      this.keyProjectName = keyProjectName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setItemCategoryId(final Long itemCategoryId) {
      this.itemCategoryId = itemCategoryId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setItemCategoryName(final String itemCategoryName) {
      this.itemCategoryName = itemCategoryName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setConfigurationOfArchitecturalFormId(final Long configurationOfArchitecturalFormId) {
      this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setConfigurationOfArchitecturalFormName(final String configurationOfArchitecturalFormName) {
      this.configurationOfArchitecturalFormName = configurationOfArchitecturalFormName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setStructureTypeConfigurationId(final Long structureTypeConfigurationId) {
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      return this;
   }

   @JsonProperty("aUnitClassConfigurationId")
   public CrmProjectInformationWarehousingDetailDTO setAUnitClassConfigurationId(final Long aUnitClassConfigurationId) {
      this.aUnitClassConfigurationId = aUnitClassConfigurationId;
      return this;
   }

   @JsonProperty("aUnitClassConfigurationName")
   public CrmProjectInformationWarehousingDetailDTO setAUnitClassConfigurationName(final String aUnitClassConfigurationName) {
      this.aUnitClassConfigurationName = aUnitClassConfigurationName;
      return this;
   }

   @JsonProperty("aUnitClassConfigurationContactName")
   public CrmProjectInformationWarehousingDetailDTO setAUnitClassConfigurationContactName(final String aUnitClassConfigurationContactName) {
      this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
      return this;
   }

   @JsonProperty("aUnitClassConfigurationOffice")
   public CrmProjectInformationWarehousingDetailDTO setAUnitClassConfigurationOffice(final String aUnitClassConfigurationOffice) {
      this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
      return this;
   }

   @JsonProperty("aUnitClassConfigurationPhone")
   public CrmProjectInformationWarehousingDetailDTO setAUnitClassConfigurationPhone(final String aUnitClassConfigurationPhone) {
      this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
      return this;
   }

   @JsonProperty("bUnitClassConfigurationId")
   public CrmProjectInformationWarehousingDetailDTO setBUnitClassConfigurationId(final Long bUnitClassConfigurationId) {
      this.bUnitClassConfigurationId = bUnitClassConfigurationId;
      return this;
   }

   @JsonProperty("bUnitClassConfigurationName")
   public CrmProjectInformationWarehousingDetailDTO setBUnitClassConfigurationName(final String bUnitClassConfigurationName) {
      this.bUnitClassConfigurationName = bUnitClassConfigurationName;
      return this;
   }

   @JsonProperty("bUnitClassConfigurationContactName")
   public CrmProjectInformationWarehousingDetailDTO setBUnitClassConfigurationContactName(final String bUnitClassConfigurationContactName) {
      this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
      return this;
   }

   @JsonProperty("bUnitClassConfigurationOffice")
   public CrmProjectInformationWarehousingDetailDTO setBUnitClassConfigurationOffice(final String bUnitClassConfigurationOffice) {
      this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
      return this;
   }

   @JsonProperty("bUnitClassConfigurationPhone")
   public CrmProjectInformationWarehousingDetailDTO setBUnitClassConfigurationPhone(final String bUnitClassConfigurationPhone) {
      this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
      return this;
   }

   @JsonProperty("cUnitClassConfigurationId")
   public CrmProjectInformationWarehousingDetailDTO setCUnitClassConfigurationId(final Long cUnitClassConfigurationId) {
      this.cUnitClassConfigurationId = cUnitClassConfigurationId;
      return this;
   }

   @JsonProperty("cUnitClassConfigurationName")
   public CrmProjectInformationWarehousingDetailDTO setCUnitClassConfigurationName(final String cUnitClassConfigurationName) {
      this.cUnitClassConfigurationName = cUnitClassConfigurationName;
      return this;
   }

   @JsonProperty("cUnitClassConfigurationContactName")
   public CrmProjectInformationWarehousingDetailDTO setCUnitClassConfigurationContactName(final String cUnitClassConfigurationContactName) {
      this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
      return this;
   }

   @JsonProperty("cUnitClassConfigurationOffice")
   public CrmProjectInformationWarehousingDetailDTO setCUnitClassConfigurationOffice(final String cUnitClassConfigurationOffice) {
      this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
      return this;
   }

   @JsonProperty("cUnitClassConfigurationPhone")
   public CrmProjectInformationWarehousingDetailDTO setCUnitClassConfigurationPhone(final String cUnitClassConfigurationPhone) {
      this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
      return this;
   }

   @JsonProperty("dUnitClassConfigurationId")
   public CrmProjectInformationWarehousingDetailDTO setDUnitClassConfigurationId(final Long dUnitClassConfigurationId) {
      this.dUnitClassConfigurationId = dUnitClassConfigurationId;
      return this;
   }

   @JsonProperty("dUnitClassConfigurationName")
   public CrmProjectInformationWarehousingDetailDTO setDUnitClassConfigurationName(final String dUnitClassConfigurationName) {
      this.dUnitClassConfigurationName = dUnitClassConfigurationName;
      return this;
   }

   @JsonProperty("dUnitClassConfigurationContactName")
   public CrmProjectInformationWarehousingDetailDTO setDUnitClassConfigurationContactName(final String dUnitClassConfigurationContactName) {
      this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
      return this;
   }

   @JsonProperty("dUnitClassConfigurationOffice")
   public CrmProjectInformationWarehousingDetailDTO setDUnitClassConfigurationOffice(final String dUnitClassConfigurationOffice) {
      this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
      return this;
   }

   @JsonProperty("dUnitClassConfigurationPhone")
   public CrmProjectInformationWarehousingDetailDTO setDUnitClassConfigurationPhone(final String dUnitClassConfigurationPhone) {
      this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
      return this;
   }

   @JsonProperty("eUnitClassConfigurationId")
   public CrmProjectInformationWarehousingDetailDTO setEUnitClassConfigurationId(final Long eUnitClassConfigurationId) {
      this.eUnitClassConfigurationId = eUnitClassConfigurationId;
      return this;
   }

   @JsonProperty("eUnitClassConfigurationName")
   public CrmProjectInformationWarehousingDetailDTO setEUnitClassConfigurationName(final String eUnitClassConfigurationName) {
      this.eUnitClassConfigurationName = eUnitClassConfigurationName;
      return this;
   }

   @JsonProperty("eUnitClassConfigurationContactName")
   public CrmProjectInformationWarehousingDetailDTO setEUnitClassConfigurationContactName(final String eUnitClassConfigurationContactName) {
      this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
      return this;
   }

   @JsonProperty("eUnitClassConfigurationOffice")
   public CrmProjectInformationWarehousingDetailDTO setEUnitClassConfigurationOffice(final String eUnitClassConfigurationOffice) {
      this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
      return this;
   }

   @JsonProperty("eUnitClassConfigurationPhone")
   public CrmProjectInformationWarehousingDetailDTO setEUnitClassConfigurationPhone(final String eUnitClassConfigurationPhone) {
      this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectOverview(final String projectOverview) {
      this.projectOverview = projectOverview;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setEstimatedWorks(final BigDecimal estimatedWorks) {
      this.estimatedWorks = estimatedWorks;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setBiddingMethodName(final String biddingMethodName) {
      this.biddingMethodName = biddingMethodName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setDifficultyFactorName(final String difficultyFactorName) {
      this.difficultyFactorName = difficultyFactorName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setIsProjectManagerCoordinate(final Boolean isProjectManagerCoordinate) {
      this.isProjectManagerCoordinate = isProjectManagerCoordinate;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectLevelConfigId(final Long projectLevelConfigId) {
      this.projectLevelConfigId = projectLevelConfigId;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectLevelConfigName(final String projectLevelConfigName) {
      this.projectLevelConfigName = projectLevelConfigName;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectAttachmentList(final List<AttachmentDTO> projectAttachmentList) {
      this.projectAttachmentList = projectAttachmentList;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setInfoSource(final String infoSource) {
      this.infoSource = infoSource;
      return this;
   }

   public CrmProjectInformationWarehousingDetailDTO setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationWarehousingDetailDTO(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", typeOfContractorId="
         + this.getTypeOfContractorId()
         + ", typeOfContractorName="
         + this.getTypeOfContractorName()
         + ", keyProjectId="
         + this.getKeyProjectId()
         + ", keyProjectName="
         + this.getKeyProjectName()
         + ", itemCategoryId="
         + this.getItemCategoryId()
         + ", itemCategoryName="
         + this.getItemCategoryName()
         + ", configurationOfArchitecturalFormId="
         + this.getConfigurationOfArchitecturalFormId()
         + ", configurationOfArchitecturalFormName="
         + this.getConfigurationOfArchitecturalFormName()
         + ", structureTypeConfigurationId="
         + this.getStructureTypeConfigurationId()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
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
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", aUnitClassConfigurationId="
         + this.getAUnitClassConfigurationId()
         + ", aUnitClassConfigurationName="
         + this.getAUnitClassConfigurationName()
         + ", aUnitClassConfigurationContactName="
         + this.getAUnitClassConfigurationContactName()
         + ", aUnitClassConfigurationOffice="
         + this.getAUnitClassConfigurationOffice()
         + ", aUnitClassConfigurationPhone="
         + this.getAUnitClassConfigurationPhone()
         + ", bUnitClassConfigurationId="
         + this.getBUnitClassConfigurationId()
         + ", bUnitClassConfigurationName="
         + this.getBUnitClassConfigurationName()
         + ", bUnitClassConfigurationContactName="
         + this.getBUnitClassConfigurationContactName()
         + ", bUnitClassConfigurationOffice="
         + this.getBUnitClassConfigurationOffice()
         + ", bUnitClassConfigurationPhone="
         + this.getBUnitClassConfigurationPhone()
         + ", cUnitClassConfigurationId="
         + this.getCUnitClassConfigurationId()
         + ", cUnitClassConfigurationName="
         + this.getCUnitClassConfigurationName()
         + ", cUnitClassConfigurationContactName="
         + this.getCUnitClassConfigurationContactName()
         + ", cUnitClassConfigurationOffice="
         + this.getCUnitClassConfigurationOffice()
         + ", cUnitClassConfigurationPhone="
         + this.getCUnitClassConfigurationPhone()
         + ", dUnitClassConfigurationId="
         + this.getDUnitClassConfigurationId()
         + ", dUnitClassConfigurationName="
         + this.getDUnitClassConfigurationName()
         + ", dUnitClassConfigurationContactName="
         + this.getDUnitClassConfigurationContactName()
         + ", dUnitClassConfigurationOffice="
         + this.getDUnitClassConfigurationOffice()
         + ", dUnitClassConfigurationPhone="
         + this.getDUnitClassConfigurationPhone()
         + ", eUnitClassConfigurationId="
         + this.getEUnitClassConfigurationId()
         + ", eUnitClassConfigurationName="
         + this.getEUnitClassConfigurationName()
         + ", eUnitClassConfigurationContactName="
         + this.getEUnitClassConfigurationContactName()
         + ", eUnitClassConfigurationOffice="
         + this.getEUnitClassConfigurationOffice()
         + ", eUnitClassConfigurationPhone="
         + this.getEUnitClassConfigurationPhone()
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
         + ", biddingMethodName="
         + this.getBiddingMethodName()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", difficultyFactorId="
         + this.getDifficultyFactorId()
         + ", difficultyFactorName="
         + this.getDifficultyFactorName()
         + ", isProjectManagerCoordinate="
         + this.getIsProjectManagerCoordinate()
         + ", regionList="
         + this.getRegionList()
         + ", projectLevelConfigId="
         + this.getProjectLevelConfigId()
         + ", projectLevelConfigName="
         + this.getProjectLevelConfigName()
         + ", projectAttachmentList="
         + this.getProjectAttachmentList()
         + ", remark="
         + this.getRemark()
         + ", infoSource="
         + this.getInfoSource()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationWarehousingDetailDTO)) {
         return false;
      }

      CrmProjectInformationWarehousingDetailDTO other = (CrmProjectInformationWarehousingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
               Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
               if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                  Object this$departmentId = this.getDepartmentId();
                  Object other$departmentId = other.getDepartmentId();
                  if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
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
                                                      Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                                                      Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                                                      if (this$crmCountryTypeEnum == null
                                                         ? other$crmCountryTypeEnum == null
                                                         : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
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
                                                                        Object this$biddingMethodId = this.getBiddingMethodId();
                                                                        Object other$biddingMethodId = other.getBiddingMethodId();
                                                                        if (this$biddingMethodId == null
                                                                           ? other$biddingMethodId == null
                                                                           : this$biddingMethodId.equals(other$biddingMethodId)) {
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
                                                                                 Object this$isProjectManagerCoordinate = this.getIsProjectManagerCoordinate();
                                                                                 Object other$isProjectManagerCoordinate = other.getIsProjectManagerCoordinate();
                                                                                 if (this$isProjectManagerCoordinate == null
                                                                                    ? other$isProjectManagerCoordinate == null
                                                                                    : this$isProjectManagerCoordinate.equals(other$isProjectManagerCoordinate)) {
                                                                                    Object this$projectLevelConfigId = this.getProjectLevelConfigId();
                                                                                    Object other$projectLevelConfigId = other.getProjectLevelConfigId();
                                                                                    if (this$projectLevelConfigId == null
                                                                                       ? other$projectLevelConfigId == null
                                                                                       : this$projectLevelConfigId.equals(other$projectLevelConfigId)) {
                                                                                       Object this$informantUserName = this.getInformantUserName();
                                                                                       Object other$informantUserName = other.getInformantUserName();
                                                                                       if (this$informantUserName == null
                                                                                          ? other$informantUserName == null
                                                                                          : this$informantUserName.equals(other$informantUserName)) {
                                                                                          Object this$informantDateTime = this.getInformantDateTime();
                                                                                          Object other$informantDateTime = other.getInformantDateTime();
                                                                                          if (this$informantDateTime == null
                                                                                             ? other$informantDateTime == null
                                                                                             : this$informantDateTime.equals(other$informantDateTime)) {
                                                                                             Object this$createUserName = this.getCreateUserName();
                                                                                             Object other$createUserName = other.getCreateUserName();
                                                                                             if (this$createUserName == null
                                                                                                ? other$createUserName == null
                                                                                                : this$createUserName.equals(other$createUserName)) {
                                                                                                Object this$departmentName = this.getDepartmentName();
                                                                                                Object other$departmentName = other.getDepartmentName();
                                                                                                if (this$departmentName == null
                                                                                                   ? other$departmentName == null
                                                                                                   : this$departmentName.equals(other$departmentName)) {
                                                                                                   Object this$projectName = this.getProjectName();
                                                                                                   Object other$projectName = other.getProjectName();
                                                                                                   if (this$projectName == null
                                                                                                      ? other$projectName == null
                                                                                                      : this$projectName.equals(other$projectName)) {
                                                                                                      Object this$projectSerialNumber = this.getProjectSerialNumber();
                                                                                                      Object other$projectSerialNumber = other.getProjectSerialNumber();
                                                                                                      if (this$projectSerialNumber == null
                                                                                                         ? other$projectSerialNumber == null
                                                                                                         : this$projectSerialNumber.equals(
                                                                                                            other$projectSerialNumber
                                                                                                         )) {
                                                                                                         Object this$serialNumber = this.getSerialNumber();
                                                                                                         Object other$serialNumber = other.getSerialNumber();
                                                                                                         if (this$serialNumber == null
                                                                                                            ? other$serialNumber == null
                                                                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                                                                            Object this$typeOfContractorName = this.getTypeOfContractorName();
                                                                                                            Object other$typeOfContractorName = other.getTypeOfContractorName();
                                                                                                            if (this$typeOfContractorName == null
                                                                                                               ? other$typeOfContractorName == null
                                                                                                               : this$typeOfContractorName.equals(
                                                                                                                  other$typeOfContractorName
                                                                                                               )) {
                                                                                                               Object this$keyProjectName = this.getKeyProjectName();
                                                                                                               Object other$keyProjectName = other.getKeyProjectName();
                                                                                                               if (this$keyProjectName == null
                                                                                                                  ? other$keyProjectName == null
                                                                                                                  : this$keyProjectName.equals(
                                                                                                                     other$keyProjectName
                                                                                                                  )) {
                                                                                                                  Object this$itemCategoryName = this.getItemCategoryName();
                                                                                                                  Object other$itemCategoryName = other.getItemCategoryName();
                                                                                                                  if (this$itemCategoryName == null
                                                                                                                     ? other$itemCategoryName == null
                                                                                                                     : this$itemCategoryName.equals(
                                                                                                                        other$itemCategoryName
                                                                                                                     )) {
                                                                                                                     Object this$configurationOfArchitecturalFormName = this.getConfigurationOfArchitecturalFormName();
                                                                                                                     Object other$configurationOfArchitecturalFormName = other.getConfigurationOfArchitecturalFormName();
                                                                                                                     if (this$configurationOfArchitecturalFormName
                                                                                                                           == null
                                                                                                                        ? other$configurationOfArchitecturalFormName
                                                                                                                           == null
                                                                                                                        : this$configurationOfArchitecturalFormName.equals(
                                                                                                                           other$configurationOfArchitecturalFormName
                                                                                                                        )) {
                                                                                                                        Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                                                                                                                        Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                                                                                                                        if (this$structureTypeConfigurationName
                                                                                                                              == null
                                                                                                                           ? other$structureTypeConfigurationName
                                                                                                                              == null
                                                                                                                           : this$structureTypeConfigurationName.equals(
                                                                                                                              other$structureTypeConfigurationName
                                                                                                                           )) {
                                                                                                                           Object this$industryConfigurationName = this.getIndustryConfigurationName();
                                                                                                                           Object other$industryConfigurationName = other.getIndustryConfigurationName();
                                                                                                                           if (this$industryConfigurationName
                                                                                                                                 == null
                                                                                                                              ? other$industryConfigurationName
                                                                                                                                 == null
                                                                                                                              : this$industryConfigurationName.equals(
                                                                                                                                 other$industryConfigurationName
                                                                                                                              )) {
                                                                                                                              Object this$countryName = this.getCountryName();
                                                                                                                              Object other$countryName = other.getCountryName();
                                                                                                                              if (this$countryName == null
                                                                                                                                 ? other$countryName == null
                                                                                                                                 : this$countryName.equals(
                                                                                                                                    other$countryName
                                                                                                                                 )) {
                                                                                                                                 Object this$provinceName = this.getProvinceName();
                                                                                                                                 Object other$provinceName = other.getProvinceName();
                                                                                                                                 if (this$provinceName == null
                                                                                                                                    ? other$provinceName
                                                                                                                                       == null
                                                                                                                                    : this$provinceName.equals(
                                                                                                                                       other$provinceName
                                                                                                                                    )) {
                                                                                                                                    Object this$cityName = this.getCityName();
                                                                                                                                    Object other$cityName = other.getCityName();
                                                                                                                                    if (this$cityName == null
                                                                                                                                       ? other$cityName == null
                                                                                                                                       : this$cityName.equals(
                                                                                                                                          other$cityName
                                                                                                                                       )) {
                                                                                                                                       Object this$regionName = this.getRegionName();
                                                                                                                                       Object other$regionName = other.getRegionName();
                                                                                                                                       if (this$regionName
                                                                                                                                             == null
                                                                                                                                          ? other$regionName
                                                                                                                                             == null
                                                                                                                                          : this$regionName.equals(
                                                                                                                                             other$regionName
                                                                                                                                          )) {
                                                                                                                                          Object this$address = this.getAddress();
                                                                                                                                          Object other$address = other.getAddress();
                                                                                                                                          if (this$address
                                                                                                                                                == null
                                                                                                                                             ? other$address
                                                                                                                                                == null
                                                                                                                                             : this$address.equals(
                                                                                                                                                other$address
                                                                                                                                             )) {
                                                                                                                                             Object this$aUnitClassConfigurationName = this.getAUnitClassConfigurationName();
                                                                                                                                             Object other$aUnitClassConfigurationName = other.getAUnitClassConfigurationName();
                                                                                                                                             if (this$aUnitClassConfigurationName
                                                                                                                                                   == null
                                                                                                                                                ? other$aUnitClassConfigurationName
                                                                                                                                                   == null
                                                                                                                                                : this$aUnitClassConfigurationName.equals(
                                                                                                                                                   other$aUnitClassConfigurationName
                                                                                                                                                )) {
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
                                                                                                                                                         Object this$bUnitClassConfigurationName = this.getBUnitClassConfigurationName();
                                                                                                                                                         Object other$bUnitClassConfigurationName = other.getBUnitClassConfigurationName();
                                                                                                                                                         if (this$bUnitClassConfigurationName
                                                                                                                                                               == null
                                                                                                                                                            ? other$bUnitClassConfigurationName
                                                                                                                                                               == null
                                                                                                                                                            : this$bUnitClassConfigurationName.equals(
                                                                                                                                                               other$bUnitClassConfigurationName
                                                                                                                                                            )) {
                                                                                                                                                            Object this$bUnitClassConfigurationContactName = this.getBUnitClassConfigurationContactName();
                                                                                                                                                            Object other$bUnitClassConfigurationContactName = other.getBUnitClassConfigurationContactName();
                                                                                                                                                            if (this$bUnitClassConfigurationContactName
                                                                                                                                                                  == null
                                                                                                                                                               ? other$bUnitClassConfigurationContactName
                                                                                                                                                                  == null
                                                                                                                                                               : this$bUnitClassConfigurationContactName.equals(
                                                                                                                                                                  other$bUnitClassConfigurationContactName
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$bUnitClassConfigurationOffice = this.getBUnitClassConfigurationOffice();
                                                                                                                                                               Object other$bUnitClassConfigurationOffice = other.getBUnitClassConfigurationOffice();
                                                                                                                                                               if (this$bUnitClassConfigurationOffice
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$bUnitClassConfigurationOffice
                                                                                                                                                                     == null
                                                                                                                                                                  : this$bUnitClassConfigurationOffice.equals(
                                                                                                                                                                     other$bUnitClassConfigurationOffice
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$bUnitClassConfigurationPhone = this.getBUnitClassConfigurationPhone();
                                                                                                                                                                  Object other$bUnitClassConfigurationPhone = other.getBUnitClassConfigurationPhone();
                                                                                                                                                                  if (this$bUnitClassConfigurationPhone
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$bUnitClassConfigurationPhone
                                                                                                                                                                        == null
                                                                                                                                                                     : this$bUnitClassConfigurationPhone.equals(
                                                                                                                                                                        other$bUnitClassConfigurationPhone
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$cUnitClassConfigurationName = this.getCUnitClassConfigurationName();
                                                                                                                                                                     Object other$cUnitClassConfigurationName = other.getCUnitClassConfigurationName();
                                                                                                                                                                     if (this$cUnitClassConfigurationName
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$cUnitClassConfigurationName
                                                                                                                                                                           == null
                                                                                                                                                                        : this$cUnitClassConfigurationName.equals(
                                                                                                                                                                           other$cUnitClassConfigurationName
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$cUnitClassConfigurationContactName = this.getCUnitClassConfigurationContactName();
                                                                                                                                                                        Object other$cUnitClassConfigurationContactName = other.getCUnitClassConfigurationContactName();
                                                                                                                                                                        if (this$cUnitClassConfigurationContactName
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$cUnitClassConfigurationContactName
                                                                                                                                                                              == null
                                                                                                                                                                           : this$cUnitClassConfigurationContactName.equals(
                                                                                                                                                                              other$cUnitClassConfigurationContactName
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$cUnitClassConfigurationOffice = this.getCUnitClassConfigurationOffice();
                                                                                                                                                                           Object other$cUnitClassConfigurationOffice = other.getCUnitClassConfigurationOffice();
                                                                                                                                                                           if (this$cUnitClassConfigurationOffice
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$cUnitClassConfigurationOffice
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$cUnitClassConfigurationOffice.equals(
                                                                                                                                                                                 other$cUnitClassConfigurationOffice
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$cUnitClassConfigurationPhone = this.getCUnitClassConfigurationPhone();
                                                                                                                                                                              Object other$cUnitClassConfigurationPhone = other.getCUnitClassConfigurationPhone();
                                                                                                                                                                              if (this$cUnitClassConfigurationPhone
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$cUnitClassConfigurationPhone
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$cUnitClassConfigurationPhone.equals(
                                                                                                                                                                                    other$cUnitClassConfigurationPhone
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$dUnitClassConfigurationName = this.getDUnitClassConfigurationName();
                                                                                                                                                                                 Object other$dUnitClassConfigurationName = other.getDUnitClassConfigurationName();
                                                                                                                                                                                 if (this$dUnitClassConfigurationName
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$dUnitClassConfigurationName
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$dUnitClassConfigurationName.equals(
                                                                                                                                                                                       other$dUnitClassConfigurationName
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$dUnitClassConfigurationContactName = this.getDUnitClassConfigurationContactName();
                                                                                                                                                                                    Object other$dUnitClassConfigurationContactName = other.getDUnitClassConfigurationContactName();
                                                                                                                                                                                    if (this$dUnitClassConfigurationContactName
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$dUnitClassConfigurationContactName
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$dUnitClassConfigurationContactName.equals(
                                                                                                                                                                                          other$dUnitClassConfigurationContactName
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$dUnitClassConfigurationOffice = this.getDUnitClassConfigurationOffice();
                                                                                                                                                                                       Object other$dUnitClassConfigurationOffice = other.getDUnitClassConfigurationOffice();
                                                                                                                                                                                       if (this$dUnitClassConfigurationOffice
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$dUnitClassConfigurationOffice
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$dUnitClassConfigurationOffice.equals(
                                                                                                                                                                                             other$dUnitClassConfigurationOffice
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
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
                                                                                                                                                                                             Object this$eUnitClassConfigurationName = this.getEUnitClassConfigurationName();
                                                                                                                                                                                             Object other$eUnitClassConfigurationName = other.getEUnitClassConfigurationName();
                                                                                                                                                                                             if (this$eUnitClassConfigurationName
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$eUnitClassConfigurationName
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$eUnitClassConfigurationName.equals(
                                                                                                                                                                                                   other$eUnitClassConfigurationName
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
                                                                                                                                                                                                         Object this$projectOverview = this.getProjectOverview();
                                                                                                                                                                                                         Object other$projectOverview = other.getProjectOverview();
                                                                                                                                                                                                         if (this$projectOverview
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$projectOverview
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$projectOverview.equals(
                                                                                                                                                                                                               other$projectOverview
                                                                                                                                                                                                            )
                                                                                                                                                                                                            )
                                                                                                                                                                                                          {
                                                                                                                                                                                                            Object this$estimatedWorks = this.getEstimatedWorks();
                                                                                                                                                                                                            Object other$estimatedWorks = other.getEstimatedWorks();
                                                                                                                                                                                                            if (this$estimatedWorks
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$estimatedWorks
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$estimatedWorks.equals(
                                                                                                                                                                                                                  other$estimatedWorks
                                                                                                                                                                                                               )
                                                                                                                                                                                                               )
                                                                                                                                                                                                             {
                                                                                                                                                                                                               Object this$estimatedCost = this.getEstimatedCost();
                                                                                                                                                                                                               Object other$estimatedCost = other.getEstimatedCost();
                                                                                                                                                                                                               if (this$estimatedCost
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  ? other$estimatedCost
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  : this$estimatedCost.equals(
                                                                                                                                                                                                                     other$estimatedCost
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                {
                                                                                                                                                                                                                  Object this$areaOfStructure = this.getAreaOfStructure();
                                                                                                                                                                                                                  Object other$areaOfStructure = other.getAreaOfStructure();
                                                                                                                                                                                                                  if (this$areaOfStructure
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     ? other$areaOfStructure
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     : this$areaOfStructure.equals(
                                                                                                                                                                                                                        other$areaOfStructure
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                   {
                                                                                                                                                                                                                     Object this$biddingMethodName = this.getBiddingMethodName();
                                                                                                                                                                                                                     Object other$biddingMethodName = other.getBiddingMethodName();
                                                                                                                                                                                                                     if (this$biddingMethodName
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        ? other$biddingMethodName
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        : this$biddingMethodName.equals(
                                                                                                                                                                                                                           other$biddingMethodName
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                      {
                                                                                                                                                                                                                        Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                                                                                                                                                                                                        Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                                                                                                                                                                                                        if (this$crmEnterpriseWarehousingName
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           ? other$crmEnterpriseWarehousingName
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           : this$crmEnterpriseWarehousingName.equals(
                                                                                                                                                                                                                              other$crmEnterpriseWarehousingName
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                         {
                                                                                                                                                                                                                           Object this$difficultyFactorName = this.getDifficultyFactorName();
                                                                                                                                                                                                                           Object other$difficultyFactorName = other.getDifficultyFactorName();
                                                                                                                                                                                                                           if (this$difficultyFactorName
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              ? other$difficultyFactorName
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              : this$difficultyFactorName.equals(
                                                                                                                                                                                                                                 other$difficultyFactorName
                                                                                                                                                                                                                              )
                                                                                                                                                                                                                              )
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                              Object this$regionList = this.getRegionList();
                                                                                                                                                                                                                              Object other$regionList = other.getRegionList();
                                                                                                                                                                                                                              if (this$regionList
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 ? other$regionList
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 : this$regionList.equals(
                                                                                                                                                                                                                                    other$regionList
                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                 Object this$projectLevelConfigName = this.getProjectLevelConfigName();
                                                                                                                                                                                                                                 Object other$projectLevelConfigName = other.getProjectLevelConfigName();
                                                                                                                                                                                                                                 if (this$projectLevelConfigName
                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                    ? other$projectLevelConfigName
                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                    : this$projectLevelConfigName.equals(
                                                                                                                                                                                                                                       other$projectLevelConfigName
                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                    Object this$projectAttachmentList = this.getProjectAttachmentList();
                                                                                                                                                                                                                                    Object other$projectAttachmentList = other.getProjectAttachmentList();
                                                                                                                                                                                                                                    if (this$projectAttachmentList
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       ? other$projectAttachmentList
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       : this$projectAttachmentList.equals(
                                                                                                                                                                                                                                          other$projectAttachmentList
                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                       Object this$remark = this.getRemark();
                                                                                                                                                                                                                                       Object other$remark = other.getRemark();
                                                                                                                                                                                                                                       if (this$remark
                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                          ? other$remark
                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                          : this$remark.equals(
                                                                                                                                                                                                                                             other$remark
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
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CrmProjectInformationWarehousingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
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
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
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
      Object $biddingMethodId = this.getBiddingMethodId();
      result = result * 59 + ($biddingMethodId == null ? 43 : $biddingMethodId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $difficultyFactorId = this.getDifficultyFactorId();
      result = result * 59 + ($difficultyFactorId == null ? 43 : $difficultyFactorId.hashCode());
      Object $isProjectManagerCoordinate = this.getIsProjectManagerCoordinate();
      result = result * 59 + ($isProjectManagerCoordinate == null ? 43 : $isProjectManagerCoordinate.hashCode());
      Object $projectLevelConfigId = this.getProjectLevelConfigId();
      result = result * 59 + ($projectLevelConfigId == null ? 43 : $projectLevelConfigId.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $typeOfContractorName = this.getTypeOfContractorName();
      result = result * 59 + ($typeOfContractorName == null ? 43 : $typeOfContractorName.hashCode());
      Object $keyProjectName = this.getKeyProjectName();
      result = result * 59 + ($keyProjectName == null ? 43 : $keyProjectName.hashCode());
      Object $itemCategoryName = this.getItemCategoryName();
      result = result * 59 + ($itemCategoryName == null ? 43 : $itemCategoryName.hashCode());
      Object $configurationOfArchitecturalFormName = this.getConfigurationOfArchitecturalFormName();
      result = result * 59 + ($configurationOfArchitecturalFormName == null ? 43 : $configurationOfArchitecturalFormName.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
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
      Object $aUnitClassConfigurationName = this.getAUnitClassConfigurationName();
      result = result * 59 + ($aUnitClassConfigurationName == null ? 43 : $aUnitClassConfigurationName.hashCode());
      Object $aUnitClassConfigurationContactName = this.getAUnitClassConfigurationContactName();
      result = result * 59 + ($aUnitClassConfigurationContactName == null ? 43 : $aUnitClassConfigurationContactName.hashCode());
      Object $aUnitClassConfigurationOffice = this.getAUnitClassConfigurationOffice();
      result = result * 59 + ($aUnitClassConfigurationOffice == null ? 43 : $aUnitClassConfigurationOffice.hashCode());
      Object $aUnitClassConfigurationPhone = this.getAUnitClassConfigurationPhone();
      result = result * 59 + ($aUnitClassConfigurationPhone == null ? 43 : $aUnitClassConfigurationPhone.hashCode());
      Object $bUnitClassConfigurationName = this.getBUnitClassConfigurationName();
      result = result * 59 + ($bUnitClassConfigurationName == null ? 43 : $bUnitClassConfigurationName.hashCode());
      Object $bUnitClassConfigurationContactName = this.getBUnitClassConfigurationContactName();
      result = result * 59 + ($bUnitClassConfigurationContactName == null ? 43 : $bUnitClassConfigurationContactName.hashCode());
      Object $bUnitClassConfigurationOffice = this.getBUnitClassConfigurationOffice();
      result = result * 59 + ($bUnitClassConfigurationOffice == null ? 43 : $bUnitClassConfigurationOffice.hashCode());
      Object $bUnitClassConfigurationPhone = this.getBUnitClassConfigurationPhone();
      result = result * 59 + ($bUnitClassConfigurationPhone == null ? 43 : $bUnitClassConfigurationPhone.hashCode());
      Object $cUnitClassConfigurationName = this.getCUnitClassConfigurationName();
      result = result * 59 + ($cUnitClassConfigurationName == null ? 43 : $cUnitClassConfigurationName.hashCode());
      Object $cUnitClassConfigurationContactName = this.getCUnitClassConfigurationContactName();
      result = result * 59 + ($cUnitClassConfigurationContactName == null ? 43 : $cUnitClassConfigurationContactName.hashCode());
      Object $cUnitClassConfigurationOffice = this.getCUnitClassConfigurationOffice();
      result = result * 59 + ($cUnitClassConfigurationOffice == null ? 43 : $cUnitClassConfigurationOffice.hashCode());
      Object $cUnitClassConfigurationPhone = this.getCUnitClassConfigurationPhone();
      result = result * 59 + ($cUnitClassConfigurationPhone == null ? 43 : $cUnitClassConfigurationPhone.hashCode());
      Object $dUnitClassConfigurationName = this.getDUnitClassConfigurationName();
      result = result * 59 + ($dUnitClassConfigurationName == null ? 43 : $dUnitClassConfigurationName.hashCode());
      Object $dUnitClassConfigurationContactName = this.getDUnitClassConfigurationContactName();
      result = result * 59 + ($dUnitClassConfigurationContactName == null ? 43 : $dUnitClassConfigurationContactName.hashCode());
      Object $dUnitClassConfigurationOffice = this.getDUnitClassConfigurationOffice();
      result = result * 59 + ($dUnitClassConfigurationOffice == null ? 43 : $dUnitClassConfigurationOffice.hashCode());
      Object $dUnitClassConfigurationPhone = this.getDUnitClassConfigurationPhone();
      result = result * 59 + ($dUnitClassConfigurationPhone == null ? 43 : $dUnitClassConfigurationPhone.hashCode());
      Object $eUnitClassConfigurationName = this.getEUnitClassConfigurationName();
      result = result * 59 + ($eUnitClassConfigurationName == null ? 43 : $eUnitClassConfigurationName.hashCode());
      Object $eUnitClassConfigurationContactName = this.getEUnitClassConfigurationContactName();
      result = result * 59 + ($eUnitClassConfigurationContactName == null ? 43 : $eUnitClassConfigurationContactName.hashCode());
      Object $eUnitClassConfigurationOffice = this.getEUnitClassConfigurationOffice();
      result = result * 59 + ($eUnitClassConfigurationOffice == null ? 43 : $eUnitClassConfigurationOffice.hashCode());
      Object $eUnitClassConfigurationPhone = this.getEUnitClassConfigurationPhone();
      result = result * 59 + ($eUnitClassConfigurationPhone == null ? 43 : $eUnitClassConfigurationPhone.hashCode());
      Object $projectOverview = this.getProjectOverview();
      result = result * 59 + ($projectOverview == null ? 43 : $projectOverview.hashCode());
      Object $estimatedWorks = this.getEstimatedWorks();
      result = result * 59 + ($estimatedWorks == null ? 43 : $estimatedWorks.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $biddingMethodName = this.getBiddingMethodName();
      result = result * 59 + ($biddingMethodName == null ? 43 : $biddingMethodName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $difficultyFactorName = this.getDifficultyFactorName();
      result = result * 59 + ($difficultyFactorName == null ? 43 : $difficultyFactorName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $projectAttachmentList = this.getProjectAttachmentList();
      result = result * 59 + ($projectAttachmentList == null ? 43 : $projectAttachmentList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      return result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
   }

   public static class CrmProjectInformationWarehousingDetailDTOBuilder {
      private Long id;
      private Long informantUserId;
      private String informantUserName;
      private LocalDateTime informantDateTime;
      private Long createUserId;
      private String createUserName;
      private Integer crmCheckStatusEnum;
      private Long departmentId;
      private String departmentName;
      private Long approveRecordId;
      private String projectName;
      private String projectSerialNumber;
      private String serialNumber;
      private Long typeOfContractorId;
      private String typeOfContractorName;
      private Long keyProjectId;
      private String keyProjectName;
      private Long itemCategoryId;
      private String itemCategoryName;
      private Long configurationOfArchitecturalFormId;
      private String configurationOfArchitecturalFormName;
      private Long structureTypeConfigurationId;
      private String structureTypeConfigurationName;
      private Long industryConfigurationId;
      private String industryConfigurationName;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String address;
      private Integer crmCountryTypeEnum;
      private Long aUnitClassConfigurationId;
      private String aUnitClassConfigurationName;
      private String aUnitClassConfigurationContactName;
      private String aUnitClassConfigurationOffice;
      private String aUnitClassConfigurationPhone;
      private Long bUnitClassConfigurationId;
      private String bUnitClassConfigurationName;
      private String bUnitClassConfigurationContactName;
      private String bUnitClassConfigurationOffice;
      private String bUnitClassConfigurationPhone;
      private Long cUnitClassConfigurationId;
      private String cUnitClassConfigurationName;
      private String cUnitClassConfigurationContactName;
      private String cUnitClassConfigurationOffice;
      private String cUnitClassConfigurationPhone;
      private Long dUnitClassConfigurationId;
      private String dUnitClassConfigurationName;
      private String dUnitClassConfigurationContactName;
      private String dUnitClassConfigurationOffice;
      private String dUnitClassConfigurationPhone;
      private Long eUnitClassConfigurationId;
      private String eUnitClassConfigurationName;
      private String eUnitClassConfigurationContactName;
      private String eUnitClassConfigurationOffice;
      private String eUnitClassConfigurationPhone;
      private String projectOverview;
      private BigDecimal estimatedWorks;
      private BigDecimal estimatedCost;
      private BigDecimal areaOfStructure;
      private Long biddingMethodId;
      private String biddingMethodName;
      private Long crmEnterpriseWarehousingId;
      private String crmEnterpriseWarehousingName;
      private Long difficultyFactorId;
      private String difficultyFactorName;
      private Boolean isProjectManagerCoordinate;
      private List<Long> regionList;
      private Long projectLevelConfigId;
      private String projectLevelConfigName;
      private List<AttachmentDTO> projectAttachmentList;
      private String remark;
      private String infoSource;
      private String projectManagerName;

      CrmProjectInformationWarehousingDetailDTOBuilder() {
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder typeOfContractorId(final Long typeOfContractorId) {
         this.typeOfContractorId = typeOfContractorId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder typeOfContractorName(final String typeOfContractorName) {
         this.typeOfContractorName = typeOfContractorName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder keyProjectId(final Long keyProjectId) {
         this.keyProjectId = keyProjectId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder keyProjectName(final String keyProjectName) {
         this.keyProjectName = keyProjectName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder itemCategoryId(final Long itemCategoryId) {
         this.itemCategoryId = itemCategoryId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder itemCategoryName(final String itemCategoryName) {
         this.itemCategoryName = itemCategoryName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder configurationOfArchitecturalFormId(
         final Long configurationOfArchitecturalFormId
      ) {
         this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder configurationOfArchitecturalFormName(
         final String configurationOfArchitecturalFormName
      ) {
         this.configurationOfArchitecturalFormName = configurationOfArchitecturalFormName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder structureTypeConfigurationId(
         final Long structureTypeConfigurationId
      ) {
         this.structureTypeConfigurationId = structureTypeConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder structureTypeConfigurationName(
         final String structureTypeConfigurationName
      ) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder industryConfigurationId(
         final Long industryConfigurationId
      ) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder industryConfigurationName(
         final String industryConfigurationName
      ) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder crmCountryTypeEnum(final Integer crmCountryTypeEnum) {
         this.crmCountryTypeEnum = crmCountryTypeEnum;
         return this;
      }

      @JsonProperty("aUnitClassConfigurationId")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder aUnitClassConfigurationId(
         final Long aUnitClassConfigurationId
      ) {
         this.aUnitClassConfigurationId = aUnitClassConfigurationId;
         return this;
      }

      @JsonProperty("aUnitClassConfigurationName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder aUnitClassConfigurationName(
         final String aUnitClassConfigurationName
      ) {
         this.aUnitClassConfigurationName = aUnitClassConfigurationName;
         return this;
      }

      @JsonProperty("aUnitClassConfigurationContactName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder aUnitClassConfigurationContactName(
         final String aUnitClassConfigurationContactName
      ) {
         this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
         return this;
      }

      @JsonProperty("aUnitClassConfigurationOffice")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder aUnitClassConfigurationOffice(
         final String aUnitClassConfigurationOffice
      ) {
         this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
         return this;
      }

      @JsonProperty("aUnitClassConfigurationPhone")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder aUnitClassConfigurationPhone(
         final String aUnitClassConfigurationPhone
      ) {
         this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
         return this;
      }

      @JsonProperty("bUnitClassConfigurationId")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder bUnitClassConfigurationId(
         final Long bUnitClassConfigurationId
      ) {
         this.bUnitClassConfigurationId = bUnitClassConfigurationId;
         return this;
      }

      @JsonProperty("bUnitClassConfigurationName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder bUnitClassConfigurationName(
         final String bUnitClassConfigurationName
      ) {
         this.bUnitClassConfigurationName = bUnitClassConfigurationName;
         return this;
      }

      @JsonProperty("bUnitClassConfigurationContactName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder bUnitClassConfigurationContactName(
         final String bUnitClassConfigurationContactName
      ) {
         this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
         return this;
      }

      @JsonProperty("bUnitClassConfigurationOffice")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder bUnitClassConfigurationOffice(
         final String bUnitClassConfigurationOffice
      ) {
         this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
         return this;
      }

      @JsonProperty("bUnitClassConfigurationPhone")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder bUnitClassConfigurationPhone(
         final String bUnitClassConfigurationPhone
      ) {
         this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
         return this;
      }

      @JsonProperty("cUnitClassConfigurationId")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cUnitClassConfigurationId(
         final Long cUnitClassConfigurationId
      ) {
         this.cUnitClassConfigurationId = cUnitClassConfigurationId;
         return this;
      }

      @JsonProperty("cUnitClassConfigurationName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cUnitClassConfigurationName(
         final String cUnitClassConfigurationName
      ) {
         this.cUnitClassConfigurationName = cUnitClassConfigurationName;
         return this;
      }

      @JsonProperty("cUnitClassConfigurationContactName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cUnitClassConfigurationContactName(
         final String cUnitClassConfigurationContactName
      ) {
         this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
         return this;
      }

      @JsonProperty("cUnitClassConfigurationOffice")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cUnitClassConfigurationOffice(
         final String cUnitClassConfigurationOffice
      ) {
         this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
         return this;
      }

      @JsonProperty("cUnitClassConfigurationPhone")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder cUnitClassConfigurationPhone(
         final String cUnitClassConfigurationPhone
      ) {
         this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
         return this;
      }

      @JsonProperty("dUnitClassConfigurationId")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder dUnitClassConfigurationId(
         final Long dUnitClassConfigurationId
      ) {
         this.dUnitClassConfigurationId = dUnitClassConfigurationId;
         return this;
      }

      @JsonProperty("dUnitClassConfigurationName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder dUnitClassConfigurationName(
         final String dUnitClassConfigurationName
      ) {
         this.dUnitClassConfigurationName = dUnitClassConfigurationName;
         return this;
      }

      @JsonProperty("dUnitClassConfigurationContactName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder dUnitClassConfigurationContactName(
         final String dUnitClassConfigurationContactName
      ) {
         this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
         return this;
      }

      @JsonProperty("dUnitClassConfigurationOffice")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder dUnitClassConfigurationOffice(
         final String dUnitClassConfigurationOffice
      ) {
         this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
         return this;
      }

      @JsonProperty("dUnitClassConfigurationPhone")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder dUnitClassConfigurationPhone(
         final String dUnitClassConfigurationPhone
      ) {
         this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
         return this;
      }

      @JsonProperty("eUnitClassConfigurationId")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder eUnitClassConfigurationId(
         final Long eUnitClassConfigurationId
      ) {
         this.eUnitClassConfigurationId = eUnitClassConfigurationId;
         return this;
      }

      @JsonProperty("eUnitClassConfigurationName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder eUnitClassConfigurationName(
         final String eUnitClassConfigurationName
      ) {
         this.eUnitClassConfigurationName = eUnitClassConfigurationName;
         return this;
      }

      @JsonProperty("eUnitClassConfigurationContactName")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder eUnitClassConfigurationContactName(
         final String eUnitClassConfigurationContactName
      ) {
         this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
         return this;
      }

      @JsonProperty("eUnitClassConfigurationOffice")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder eUnitClassConfigurationOffice(
         final String eUnitClassConfigurationOffice
      ) {
         this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
         return this;
      }

      @JsonProperty("eUnitClassConfigurationPhone")
      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder eUnitClassConfigurationPhone(
         final String eUnitClassConfigurationPhone
      ) {
         this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectOverview(final String projectOverview) {
         this.projectOverview = projectOverview;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder estimatedWorks(final BigDecimal estimatedWorks) {
         this.estimatedWorks = estimatedWorks;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder areaOfStructure(final BigDecimal areaOfStructure) {
         this.areaOfStructure = areaOfStructure;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder biddingMethodId(final Long biddingMethodId) {
         this.biddingMethodId = biddingMethodId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder biddingMethodName(final String biddingMethodName) {
         this.biddingMethodName = biddingMethodName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder crmEnterpriseWarehousingId(
         final Long crmEnterpriseWarehousingId
      ) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder crmEnterpriseWarehousingName(
         final String crmEnterpriseWarehousingName
      ) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder difficultyFactorId(final Long difficultyFactorId) {
         this.difficultyFactorId = difficultyFactorId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder difficultyFactorName(final String difficultyFactorName) {
         this.difficultyFactorName = difficultyFactorName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder isProjectManagerCoordinate(
         final Boolean isProjectManagerCoordinate
      ) {
         this.isProjectManagerCoordinate = isProjectManagerCoordinate;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectLevelConfigId(final Long projectLevelConfigId) {
         this.projectLevelConfigId = projectLevelConfigId;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectLevelConfigName(
         final String projectLevelConfigName
      ) {
         this.projectLevelConfigName = projectLevelConfigName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectAttachmentList(
         final List<AttachmentDTO> projectAttachmentList
      ) {
         this.projectAttachmentList = projectAttachmentList;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder infoSource(final String infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public CrmProjectInformationWarehousingDetailDTO build() {
         return new CrmProjectInformationWarehousingDetailDTO(
            this.id,
            this.informantUserId,
            this.informantUserName,
            this.informantDateTime,
            this.createUserId,
            this.createUserName,
            this.crmCheckStatusEnum,
            this.departmentId,
            this.departmentName,
            this.approveRecordId,
            this.projectName,
            this.projectSerialNumber,
            this.serialNumber,
            this.typeOfContractorId,
            this.typeOfContractorName,
            this.keyProjectId,
            this.keyProjectName,
            this.itemCategoryId,
            this.itemCategoryName,
            this.configurationOfArchitecturalFormId,
            this.configurationOfArchitecturalFormName,
            this.structureTypeConfigurationId,
            this.structureTypeConfigurationName,
            this.industryConfigurationId,
            this.industryConfigurationName,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.address,
            this.crmCountryTypeEnum,
            this.aUnitClassConfigurationId,
            this.aUnitClassConfigurationName,
            this.aUnitClassConfigurationContactName,
            this.aUnitClassConfigurationOffice,
            this.aUnitClassConfigurationPhone,
            this.bUnitClassConfigurationId,
            this.bUnitClassConfigurationName,
            this.bUnitClassConfigurationContactName,
            this.bUnitClassConfigurationOffice,
            this.bUnitClassConfigurationPhone,
            this.cUnitClassConfigurationId,
            this.cUnitClassConfigurationName,
            this.cUnitClassConfigurationContactName,
            this.cUnitClassConfigurationOffice,
            this.cUnitClassConfigurationPhone,
            this.dUnitClassConfigurationId,
            this.dUnitClassConfigurationName,
            this.dUnitClassConfigurationContactName,
            this.dUnitClassConfigurationOffice,
            this.dUnitClassConfigurationPhone,
            this.eUnitClassConfigurationId,
            this.eUnitClassConfigurationName,
            this.eUnitClassConfigurationContactName,
            this.eUnitClassConfigurationOffice,
            this.eUnitClassConfigurationPhone,
            this.projectOverview,
            this.estimatedWorks,
            this.estimatedCost,
            this.areaOfStructure,
            this.biddingMethodId,
            this.biddingMethodName,
            this.crmEnterpriseWarehousingId,
            this.crmEnterpriseWarehousingName,
            this.difficultyFactorId,
            this.difficultyFactorName,
            this.isProjectManagerCoordinate,
            this.regionList,
            this.projectLevelConfigId,
            this.projectLevelConfigName,
            this.projectAttachmentList,
            this.remark,
            this.infoSource,
            this.projectManagerName
         );
      }

      @Override
      public String toString() {
         return "CrmProjectInformationWarehousingDetailDTO.CrmProjectInformationWarehousingDetailDTOBuilder(id="
            + this.id
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", informantDateTime="
            + this.informantDateTime
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", approveRecordId="
            + this.approveRecordId
            + ", projectName="
            + this.projectName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", serialNumber="
            + this.serialNumber
            + ", typeOfContractorId="
            + this.typeOfContractorId
            + ", typeOfContractorName="
            + this.typeOfContractorName
            + ", keyProjectId="
            + this.keyProjectId
            + ", keyProjectName="
            + this.keyProjectName
            + ", itemCategoryId="
            + this.itemCategoryId
            + ", itemCategoryName="
            + this.itemCategoryName
            + ", configurationOfArchitecturalFormId="
            + this.configurationOfArchitecturalFormId
            + ", configurationOfArchitecturalFormName="
            + this.configurationOfArchitecturalFormName
            + ", structureTypeConfigurationId="
            + this.structureTypeConfigurationId
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", industryConfigurationId="
            + this.industryConfigurationId
            + ", industryConfigurationName="
            + this.industryConfigurationName
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
            + ", crmCountryTypeEnum="
            + this.crmCountryTypeEnum
            + ", aUnitClassConfigurationId="
            + this.aUnitClassConfigurationId
            + ", aUnitClassConfigurationName="
            + this.aUnitClassConfigurationName
            + ", aUnitClassConfigurationContactName="
            + this.aUnitClassConfigurationContactName
            + ", aUnitClassConfigurationOffice="
            + this.aUnitClassConfigurationOffice
            + ", aUnitClassConfigurationPhone="
            + this.aUnitClassConfigurationPhone
            + ", bUnitClassConfigurationId="
            + this.bUnitClassConfigurationId
            + ", bUnitClassConfigurationName="
            + this.bUnitClassConfigurationName
            + ", bUnitClassConfigurationContactName="
            + this.bUnitClassConfigurationContactName
            + ", bUnitClassConfigurationOffice="
            + this.bUnitClassConfigurationOffice
            + ", bUnitClassConfigurationPhone="
            + this.bUnitClassConfigurationPhone
            + ", cUnitClassConfigurationId="
            + this.cUnitClassConfigurationId
            + ", cUnitClassConfigurationName="
            + this.cUnitClassConfigurationName
            + ", cUnitClassConfigurationContactName="
            + this.cUnitClassConfigurationContactName
            + ", cUnitClassConfigurationOffice="
            + this.cUnitClassConfigurationOffice
            + ", cUnitClassConfigurationPhone="
            + this.cUnitClassConfigurationPhone
            + ", dUnitClassConfigurationId="
            + this.dUnitClassConfigurationId
            + ", dUnitClassConfigurationName="
            + this.dUnitClassConfigurationName
            + ", dUnitClassConfigurationContactName="
            + this.dUnitClassConfigurationContactName
            + ", dUnitClassConfigurationOffice="
            + this.dUnitClassConfigurationOffice
            + ", dUnitClassConfigurationPhone="
            + this.dUnitClassConfigurationPhone
            + ", eUnitClassConfigurationId="
            + this.eUnitClassConfigurationId
            + ", eUnitClassConfigurationName="
            + this.eUnitClassConfigurationName
            + ", eUnitClassConfigurationContactName="
            + this.eUnitClassConfigurationContactName
            + ", eUnitClassConfigurationOffice="
            + this.eUnitClassConfigurationOffice
            + ", eUnitClassConfigurationPhone="
            + this.eUnitClassConfigurationPhone
            + ", projectOverview="
            + this.projectOverview
            + ", estimatedWorks="
            + this.estimatedWorks
            + ", estimatedCost="
            + this.estimatedCost
            + ", areaOfStructure="
            + this.areaOfStructure
            + ", biddingMethodId="
            + this.biddingMethodId
            + ", biddingMethodName="
            + this.biddingMethodName
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", difficultyFactorId="
            + this.difficultyFactorId
            + ", difficultyFactorName="
            + this.difficultyFactorName
            + ", isProjectManagerCoordinate="
            + this.isProjectManagerCoordinate
            + ", regionList="
            + this.regionList
            + ", projectLevelConfigId="
            + this.projectLevelConfigId
            + ", projectLevelConfigName="
            + this.projectLevelConfigName
            + ", projectAttachmentList="
            + this.projectAttachmentList
            + ", remark="
            + this.remark
            + ", infoSource="
            + this.infoSource
            + ", projectManagerName="
            + this.projectManagerName
            + ")";
      }
   }
}
