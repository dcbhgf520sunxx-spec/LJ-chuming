package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ContractCatalogueDTO {
   private Long id;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号")
   private String contractNumber;
   @ApiModelProperty(name = "registerDate", value = "登记日期")
   private LocalDateTime registerDate;
   @ApiModelProperty(name = "transferDate", value = "移交日期")
   private LocalDateTime transferDate;
   @ApiModelProperty(name = "signStatus", value = "签订情况")
   private Boolean signStatus;
   @ApiModelProperty(name = "signDate", value = "签订日期")
   private LocalDateTime signDate;
   @ApiModelProperty(name = "issueTime", value = "下发时间")
   private Integer issueTime;
   @ApiModelProperty(name = "partyA", value = "甲方")
   private String partyA;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "originalContractAmount", value = "原备案合同额")
   private BigDecimal originalContractAmount;
   @ApiModelProperty(name = "signerId", value = "签订人ID")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签订人姓名")
   private String signerName;
   @ApiModelProperty(name = "firstLevelDept", value = "所属一级部门")
   private Long firstLevelDept;
   @ApiModelProperty(name = "firstLevelDeptValue", value = "所属一级部门值")
   private String firstLevelDeptValue;
   @ApiModelProperty(name = "secondLevelDept", value = "所属二级部门")
   private Long secondLevelDept;
   @ApiModelProperty(name = "secondLevelDeptValue", value = "所属二级部门值")
   private String secondLevelDeptValue;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Integer infoSource;
   @ApiModelProperty(name = "boolCoordinate", value = "销售员是否配合")
   private Boolean boolCoordinate;
   @ApiModelProperty(name = "projectManager", value = "项目经理")
   private String projectManager;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private Long structureType;
   @ApiModelProperty(name = "structureTypeValue", value = "结构类型值")
   private String structureTypeValue;
   @ApiModelProperty(name = "structureArea", value = "建筑面积（平方米）")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "mainStructureSteelMete", value = "主结构用钢量(吨)")
   private BigDecimal mainStructureSteelMete;
   @ApiModelProperty(name = "subfabricSteelMete", value = "次结构用钢量(吨)")
   private BigDecimal subfabricSteelMete;
   @ApiModelProperty(name = "maximumSpan", value = "最大跨度/高度")
   private BigDecimal maximumSpan;
   @ApiModelProperty(name = "locationId", value = "区域Id")
   private Long locationId;
   @ApiModelProperty(name = "locationValue", value = "区域值")
   private String locationValue;
   @ApiModelProperty(name = "countryId", value = "国家ID")
   private Long countryId;
   @ApiModelProperty(name = "countryValue", value = "国家值")
   private String countryValue;
   @ApiModelProperty(name = "provinceId", value = "省份ID")
   private Long provinceId;
   @ApiModelProperty(name = "provinceValue", value = "省份值")
   private String provinceValue;
   @ApiModelProperty(name = "cityId", value = "城市ID")
   private Long cityId;
   @ApiModelProperty(name = "cityValue", value = "城市值")
   private String cityValue;
   @ApiModelProperty(name = "regionId", value = "区ID")
   private Long regionId;
   @ApiModelProperty(name = "regionValue", value = "区值")
   private String regionValue;
   @ApiModelProperty(name = "contractStartDate", value = "开工时间")
   private LocalDateTime contractStartDate;
   @ApiModelProperty(name = "contractEndDate", value = "竣工时间")
   private LocalDateTime contractEndDate;
   @ApiModelProperty(name = "contractualNature", value = "承包性质")
   private Long contractualNature;
   @ApiModelProperty(name = "contractualNatureValue", value = "承包性质值")
   private String contractualNatureValue;
   @ApiModelProperty(name = "biddingMethod", value = "招标方式")
   private Long biddingMethod;
   @ApiModelProperty(name = "biddingMethodValue", value = "招标方式值")
   private String biddingMethodValue;
   @ApiModelProperty(name = "partyType", value = "甲方类别")
   private Long partyType;
   @ApiModelProperty(name = "partyTypeValue", value = "甲方类别值")
   private String partyTypeValue;
   @ApiModelProperty(name = "contractType", value = "合同类型")
   private Long contractType;
   @ApiModelProperty(name = "contractTypeValue", value = "合同类型值")
   private String contractTypeValue;
   @ApiModelProperty(name = "boolFabricatedStructure", value = "是否装配式建筑")
   private Boolean boolFabricatedStructure;
   @ApiModelProperty(name = "boolModelContract", value = "是否示范合同")
   private Boolean boolModelContract;
   @ApiModelProperty(name = "attachments", value = "合同附件ID集")
   private String attachments;
   @ApiModelProperty(name = "attachmentList", value = "合同附件")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "preRegistrationId", value = "预登记ID")
   private Long preRegistrationId;
   @ApiModelProperty(name = "registrationId", value = "合同登记ID")
   private Long registrationId;
   @ApiModelProperty(name = "createSource", value = "创建来源 0预登记 1评审登记 2直接登记")
   private Integer createSource;
   @ApiModelProperty(name = "applicationDate", value = "申请时间")
   private LocalDateTime applicationDate;
   @ApiModelProperty(name = "applicantName", value = "申请人")
   private String applicantName;
   @ApiModelProperty(name = "lastEditTime", value = "最后编辑时间")
   private LocalDateTime lastEditTime;
   @ApiModelProperty(name = "lastEditUserName", value = "最后编辑人")
   private String lastEditUserName;
   @ApiModelProperty(name = "contractVersion", value = "合同版本")
   private String contractVersion;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   private Integer reviewStatus;

   public static ContractCatalogueDTO.ContractCatalogueDTOBuilder builder() {
      return new ContractCatalogueDTO.ContractCatalogueDTOBuilder();
   }

   public ContractCatalogueDTO() {
   }

   public ContractCatalogueDTO(
      final Long id,
      final String contractNumber,
      final LocalDateTime registerDate,
      final LocalDateTime transferDate,
      final Boolean signStatus,
      final LocalDateTime signDate,
      final Integer issueTime,
      final String partyA,
      final String projectName,
      final BigDecimal contractAmount,
      final BigDecimal originalContractAmount,
      final Long signerId,
      final String signerName,
      final Long firstLevelDept,
      final String firstLevelDeptValue,
      final Long secondLevelDept,
      final String secondLevelDeptValue,
      final Integer infoSource,
      final Boolean boolCoordinate,
      final String projectManager,
      final Long structureType,
      final String structureTypeValue,
      final BigDecimal structureArea,
      final BigDecimal mainStructureSteelMete,
      final BigDecimal subfabricSteelMete,
      final BigDecimal maximumSpan,
      final Long locationId,
      final String locationValue,
      final Long countryId,
      final String countryValue,
      final Long provinceId,
      final String provinceValue,
      final Long cityId,
      final String cityValue,
      final Long regionId,
      final String regionValue,
      final LocalDateTime contractStartDate,
      final LocalDateTime contractEndDate,
      final Long contractualNature,
      final String contractualNatureValue,
      final Long biddingMethod,
      final String biddingMethodValue,
      final Long partyType,
      final String partyTypeValue,
      final Long contractType,
      final String contractTypeValue,
      final Boolean boolFabricatedStructure,
      final Boolean boolModelContract,
      final String attachments,
      final List<AttachmentDTO> attachmentList,
      final Long preRegistrationId,
      final Long registrationId,
      final Integer createSource,
      final LocalDateTime applicationDate,
      final String applicantName,
      final LocalDateTime lastEditTime,
      final String lastEditUserName,
      final String contractVersion,
      final String remark,
      final Integer reviewStatus
   ) {
      this.id = id;
      this.contractNumber = contractNumber;
      this.registerDate = registerDate;
      this.transferDate = transferDate;
      this.signStatus = signStatus;
      this.signDate = signDate;
      this.issueTime = issueTime;
      this.partyA = partyA;
      this.projectName = projectName;
      this.contractAmount = contractAmount;
      this.originalContractAmount = originalContractAmount;
      this.signerId = signerId;
      this.signerName = signerName;
      this.firstLevelDept = firstLevelDept;
      this.firstLevelDeptValue = firstLevelDeptValue;
      this.secondLevelDept = secondLevelDept;
      this.secondLevelDeptValue = secondLevelDeptValue;
      this.infoSource = infoSource;
      this.boolCoordinate = boolCoordinate;
      this.projectManager = projectManager;
      this.structureType = structureType;
      this.structureTypeValue = structureTypeValue;
      this.structureArea = structureArea;
      this.mainStructureSteelMete = mainStructureSteelMete;
      this.subfabricSteelMete = subfabricSteelMete;
      this.maximumSpan = maximumSpan;
      this.locationId = locationId;
      this.locationValue = locationValue;
      this.countryId = countryId;
      this.countryValue = countryValue;
      this.provinceId = provinceId;
      this.provinceValue = provinceValue;
      this.cityId = cityId;
      this.cityValue = cityValue;
      this.regionId = regionId;
      this.regionValue = regionValue;
      this.contractStartDate = contractStartDate;
      this.contractEndDate = contractEndDate;
      this.contractualNature = contractualNature;
      this.contractualNatureValue = contractualNatureValue;
      this.biddingMethod = biddingMethod;
      this.biddingMethodValue = biddingMethodValue;
      this.partyType = partyType;
      this.partyTypeValue = partyTypeValue;
      this.contractType = contractType;
      this.contractTypeValue = contractTypeValue;
      this.boolFabricatedStructure = boolFabricatedStructure;
      this.boolModelContract = boolModelContract;
      this.attachments = attachments;
      this.attachmentList = attachmentList;
      this.preRegistrationId = preRegistrationId;
      this.registrationId = registrationId;
      this.createSource = createSource;
      this.applicationDate = applicationDate;
      this.applicantName = applicantName;
      this.lastEditTime = lastEditTime;
      this.lastEditUserName = lastEditUserName;
      this.contractVersion = contractVersion;
      this.remark = remark;
      this.reviewStatus = reviewStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public LocalDateTime getRegisterDate() {
      return this.registerDate;
   }

   public LocalDateTime getTransferDate() {
      return this.transferDate;
   }

   public Boolean getSignStatus() {
      return this.signStatus;
   }

   public LocalDateTime getSignDate() {
      return this.signDate;
   }

   public Integer getIssueTime() {
      return this.issueTime;
   }

   public String getPartyA() {
      return this.partyA;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getOriginalContractAmount() {
      return this.originalContractAmount;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Long getFirstLevelDept() {
      return this.firstLevelDept;
   }

   public String getFirstLevelDeptValue() {
      return this.firstLevelDeptValue;
   }

   public Long getSecondLevelDept() {
      return this.secondLevelDept;
   }

   public String getSecondLevelDeptValue() {
      return this.secondLevelDeptValue;
   }

   public Integer getInfoSource() {
      return this.infoSource;
   }

   public Boolean getBoolCoordinate() {
      return this.boolCoordinate;
   }

   public String getProjectManager() {
      return this.projectManager;
   }

   public Long getStructureType() {
      return this.structureType;
   }

   public String getStructureTypeValue() {
      return this.structureTypeValue;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public BigDecimal getMainStructureSteelMete() {
      return this.mainStructureSteelMete;
   }

   public BigDecimal getSubfabricSteelMete() {
      return this.subfabricSteelMete;
   }

   public BigDecimal getMaximumSpan() {
      return this.maximumSpan;
   }

   public Long getLocationId() {
      return this.locationId;
   }

   public String getLocationValue() {
      return this.locationValue;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryValue() {
      return this.countryValue;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceValue() {
      return this.provinceValue;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityValue() {
      return this.cityValue;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionValue() {
      return this.regionValue;
   }

   public LocalDateTime getContractStartDate() {
      return this.contractStartDate;
   }

   public LocalDateTime getContractEndDate() {
      return this.contractEndDate;
   }

   public Long getContractualNature() {
      return this.contractualNature;
   }

   public String getContractualNatureValue() {
      return this.contractualNatureValue;
   }

   public Long getBiddingMethod() {
      return this.biddingMethod;
   }

   public String getBiddingMethodValue() {
      return this.biddingMethodValue;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public String getPartyTypeValue() {
      return this.partyTypeValue;
   }

   public Long getContractType() {
      return this.contractType;
   }

   public String getContractTypeValue() {
      return this.contractTypeValue;
   }

   public Boolean getBoolFabricatedStructure() {
      return this.boolFabricatedStructure;
   }

   public Boolean getBoolModelContract() {
      return this.boolModelContract;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public Long getPreRegistrationId() {
      return this.preRegistrationId;
   }

   public Long getRegistrationId() {
      return this.registrationId;
   }

   public Integer getCreateSource() {
      return this.createSource;
   }

   public LocalDateTime getApplicationDate() {
      return this.applicationDate;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getLastEditTime() {
      return this.lastEditTime;
   }

   public String getLastEditUserName() {
      return this.lastEditUserName;
   }

   public String getContractVersion() {
      return this.contractVersion;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
   }

   public void setRegisterDate(final LocalDateTime registerDate) {
      this.registerDate = registerDate;
   }

   public void setTransferDate(final LocalDateTime transferDate) {
      this.transferDate = transferDate;
   }

   public void setSignStatus(final Boolean signStatus) {
      this.signStatus = signStatus;
   }

   public void setSignDate(final LocalDateTime signDate) {
      this.signDate = signDate;
   }

   public void setIssueTime(final Integer issueTime) {
      this.issueTime = issueTime;
   }

   public void setPartyA(final String partyA) {
      this.partyA = partyA;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setOriginalContractAmount(final BigDecimal originalContractAmount) {
      this.originalContractAmount = originalContractAmount;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setFirstLevelDept(final Long firstLevelDept) {
      this.firstLevelDept = firstLevelDept;
   }

   public void setFirstLevelDeptValue(final String firstLevelDeptValue) {
      this.firstLevelDeptValue = firstLevelDeptValue;
   }

   public void setSecondLevelDept(final Long secondLevelDept) {
      this.secondLevelDept = secondLevelDept;
   }

   public void setSecondLevelDeptValue(final String secondLevelDeptValue) {
      this.secondLevelDeptValue = secondLevelDeptValue;
   }

   public void setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
   }

   public void setBoolCoordinate(final Boolean boolCoordinate) {
      this.boolCoordinate = boolCoordinate;
   }

   public void setProjectManager(final String projectManager) {
      this.projectManager = projectManager;
   }

   public void setStructureType(final Long structureType) {
      this.structureType = structureType;
   }

   public void setStructureTypeValue(final String structureTypeValue) {
      this.structureTypeValue = structureTypeValue;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setMainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
      this.mainStructureSteelMete = mainStructureSteelMete;
   }

   public void setSubfabricSteelMete(final BigDecimal subfabricSteelMete) {
      this.subfabricSteelMete = subfabricSteelMete;
   }

   public void setMaximumSpan(final BigDecimal maximumSpan) {
      this.maximumSpan = maximumSpan;
   }

   public void setLocationId(final Long locationId) {
      this.locationId = locationId;
   }

   public void setLocationValue(final String locationValue) {
      this.locationValue = locationValue;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryValue(final String countryValue) {
      this.countryValue = countryValue;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceValue(final String provinceValue) {
      this.provinceValue = provinceValue;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityValue(final String cityValue) {
      this.cityValue = cityValue;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionValue(final String regionValue) {
      this.regionValue = regionValue;
   }

   public void setContractStartDate(final LocalDateTime contractStartDate) {
      this.contractStartDate = contractStartDate;
   }

   public void setContractEndDate(final LocalDateTime contractEndDate) {
      this.contractEndDate = contractEndDate;
   }

   public void setContractualNature(final Long contractualNature) {
      this.contractualNature = contractualNature;
   }

   public void setContractualNatureValue(final String contractualNatureValue) {
      this.contractualNatureValue = contractualNatureValue;
   }

   public void setBiddingMethod(final Long biddingMethod) {
      this.biddingMethod = biddingMethod;
   }

   public void setBiddingMethodValue(final String biddingMethodValue) {
      this.biddingMethodValue = biddingMethodValue;
   }

   public void setPartyType(final Long partyType) {
      this.partyType = partyType;
   }

   public void setPartyTypeValue(final String partyTypeValue) {
      this.partyTypeValue = partyTypeValue;
   }

   public void setContractType(final Long contractType) {
      this.contractType = contractType;
   }

   public void setContractTypeValue(final String contractTypeValue) {
      this.contractTypeValue = contractTypeValue;
   }

   public void setBoolFabricatedStructure(final Boolean boolFabricatedStructure) {
      this.boolFabricatedStructure = boolFabricatedStructure;
   }

   public void setBoolModelContract(final Boolean boolModelContract) {
      this.boolModelContract = boolModelContract;
   }

   public void setAttachments(final String attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   public void setPreRegistrationId(final Long preRegistrationId) {
      this.preRegistrationId = preRegistrationId;
   }

   public void setRegistrationId(final Long registrationId) {
      this.registrationId = registrationId;
   }

   public void setCreateSource(final Integer createSource) {
      this.createSource = createSource;
   }

   public void setApplicationDate(final LocalDateTime applicationDate) {
      this.applicationDate = applicationDate;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setLastEditTime(final LocalDateTime lastEditTime) {
      this.lastEditTime = lastEditTime;
   }

   public void setLastEditUserName(final String lastEditUserName) {
      this.lastEditUserName = lastEditUserName;
   }

   public void setContractVersion(final String contractVersion) {
      this.contractVersion = contractVersion;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCatalogueDTO)) {
         return false;
      }

      ContractCatalogueDTO other = (ContractCatalogueDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$signStatus = this.getSignStatus();
         Object other$signStatus = other.getSignStatus();
         if (this$signStatus == null ? other$signStatus == null : this$signStatus.equals(other$signStatus)) {
            Object this$issueTime = this.getIssueTime();
            Object other$issueTime = other.getIssueTime();
            if (this$issueTime == null ? other$issueTime == null : this$issueTime.equals(other$issueTime)) {
               Object this$signerId = this.getSignerId();
               Object other$signerId = other.getSignerId();
               if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                  Object this$firstLevelDept = this.getFirstLevelDept();
                  Object other$firstLevelDept = other.getFirstLevelDept();
                  if (this$firstLevelDept == null ? other$firstLevelDept == null : this$firstLevelDept.equals(other$firstLevelDept)) {
                     Object this$secondLevelDept = this.getSecondLevelDept();
                     Object other$secondLevelDept = other.getSecondLevelDept();
                     if (this$secondLevelDept == null ? other$secondLevelDept == null : this$secondLevelDept.equals(other$secondLevelDept)) {
                        Object this$infoSource = this.getInfoSource();
                        Object other$infoSource = other.getInfoSource();
                        if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                           Object this$boolCoordinate = this.getBoolCoordinate();
                           Object other$boolCoordinate = other.getBoolCoordinate();
                           if (this$boolCoordinate == null ? other$boolCoordinate == null : this$boolCoordinate.equals(other$boolCoordinate)) {
                              Object this$structureType = this.getStructureType();
                              Object other$structureType = other.getStructureType();
                              if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                                 Object this$locationId = this.getLocationId();
                                 Object other$locationId = other.getLocationId();
                                 if (this$locationId == null ? other$locationId == null : this$locationId.equals(other$locationId)) {
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
                                                Object this$contractualNature = this.getContractualNature();
                                                Object other$contractualNature = other.getContractualNature();
                                                if (this$contractualNature == null
                                                   ? other$contractualNature == null
                                                   : this$contractualNature.equals(other$contractualNature)) {
                                                   Object this$biddingMethod = this.getBiddingMethod();
                                                   Object other$biddingMethod = other.getBiddingMethod();
                                                   if (this$biddingMethod == null
                                                      ? other$biddingMethod == null
                                                      : this$biddingMethod.equals(other$biddingMethod)) {
                                                      Object this$partyType = this.getPartyType();
                                                      Object other$partyType = other.getPartyType();
                                                      if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
                                                         Object this$contractType = this.getContractType();
                                                         Object other$contractType = other.getContractType();
                                                         if (this$contractType == null
                                                            ? other$contractType == null
                                                            : this$contractType.equals(other$contractType)) {
                                                            Object this$boolFabricatedStructure = this.getBoolFabricatedStructure();
                                                            Object other$boolFabricatedStructure = other.getBoolFabricatedStructure();
                                                            if (this$boolFabricatedStructure == null
                                                               ? other$boolFabricatedStructure == null
                                                               : this$boolFabricatedStructure.equals(other$boolFabricatedStructure)) {
                                                               Object this$boolModelContract = this.getBoolModelContract();
                                                               Object other$boolModelContract = other.getBoolModelContract();
                                                               if (this$boolModelContract == null
                                                                  ? other$boolModelContract == null
                                                                  : this$boolModelContract.equals(other$boolModelContract)) {
                                                                  Object this$preRegistrationId = this.getPreRegistrationId();
                                                                  Object other$preRegistrationId = other.getPreRegistrationId();
                                                                  if (this$preRegistrationId == null
                                                                     ? other$preRegistrationId == null
                                                                     : this$preRegistrationId.equals(other$preRegistrationId)) {
                                                                     Object this$registrationId = this.getRegistrationId();
                                                                     Object other$registrationId = other.getRegistrationId();
                                                                     if (this$registrationId == null
                                                                        ? other$registrationId == null
                                                                        : this$registrationId.equals(other$registrationId)) {
                                                                        Object this$createSource = this.getCreateSource();
                                                                        Object other$createSource = other.getCreateSource();
                                                                        if (this$createSource == null
                                                                           ? other$createSource == null
                                                                           : this$createSource.equals(other$createSource)) {
                                                                           Object this$reviewStatus = this.getReviewStatus();
                                                                           Object other$reviewStatus = other.getReviewStatus();
                                                                           if (this$reviewStatus == null
                                                                              ? other$reviewStatus == null
                                                                              : this$reviewStatus.equals(other$reviewStatus)) {
                                                                              Object this$contractNumber = this.getContractNumber();
                                                                              Object other$contractNumber = other.getContractNumber();
                                                                              if (this$contractNumber == null
                                                                                 ? other$contractNumber == null
                                                                                 : this$contractNumber.equals(other$contractNumber)) {
                                                                                 Object this$registerDate = this.getRegisterDate();
                                                                                 Object other$registerDate = other.getRegisterDate();
                                                                                 if (this$registerDate == null
                                                                                    ? other$registerDate == null
                                                                                    : this$registerDate.equals(other$registerDate)) {
                                                                                    Object this$transferDate = this.getTransferDate();
                                                                                    Object other$transferDate = other.getTransferDate();
                                                                                    if (this$transferDate == null
                                                                                       ? other$transferDate == null
                                                                                       : this$transferDate.equals(other$transferDate)) {
                                                                                       Object this$signDate = this.getSignDate();
                                                                                       Object other$signDate = other.getSignDate();
                                                                                       if (this$signDate == null
                                                                                          ? other$signDate == null
                                                                                          : this$signDate.equals(other$signDate)) {
                                                                                          Object this$partyA = this.getPartyA();
                                                                                          Object other$partyA = other.getPartyA();
                                                                                          if (this$partyA == null
                                                                                             ? other$partyA == null
                                                                                             : this$partyA.equals(other$partyA)) {
                                                                                             Object this$projectName = this.getProjectName();
                                                                                             Object other$projectName = other.getProjectName();
                                                                                             if (this$projectName == null
                                                                                                ? other$projectName == null
                                                                                                : this$projectName.equals(other$projectName)) {
                                                                                                Object this$contractAmount = this.getContractAmount();
                                                                                                Object other$contractAmount = other.getContractAmount();
                                                                                                if (this$contractAmount == null
                                                                                                   ? other$contractAmount == null
                                                                                                   : this$contractAmount.equals(other$contractAmount)) {
                                                                                                   Object this$originalContractAmount = this.getOriginalContractAmount();
                                                                                                   Object other$originalContractAmount = other.getOriginalContractAmount();
                                                                                                   if (this$originalContractAmount == null
                                                                                                      ? other$originalContractAmount == null
                                                                                                      : this$originalContractAmount.equals(
                                                                                                         other$originalContractAmount
                                                                                                      )) {
                                                                                                      Object this$signerName = this.getSignerName();
                                                                                                      Object other$signerName = other.getSignerName();
                                                                                                      if (this$signerName == null
                                                                                                         ? other$signerName == null
                                                                                                         : this$signerName.equals(other$signerName)) {
                                                                                                         Object this$firstLevelDeptValue = this.getFirstLevelDeptValue();
                                                                                                         Object other$firstLevelDeptValue = other.getFirstLevelDeptValue();
                                                                                                         if (this$firstLevelDeptValue == null
                                                                                                            ? other$firstLevelDeptValue == null
                                                                                                            : this$firstLevelDeptValue.equals(
                                                                                                               other$firstLevelDeptValue
                                                                                                            )) {
                                                                                                            Object this$secondLevelDeptValue = this.getSecondLevelDeptValue();
                                                                                                            Object other$secondLevelDeptValue = other.getSecondLevelDeptValue();
                                                                                                            if (this$secondLevelDeptValue == null
                                                                                                               ? other$secondLevelDeptValue == null
                                                                                                               : this$secondLevelDeptValue.equals(
                                                                                                                  other$secondLevelDeptValue
                                                                                                               )) {
                                                                                                               Object this$projectManager = this.getProjectManager();
                                                                                                               Object other$projectManager = other.getProjectManager();
                                                                                                               if (this$projectManager == null
                                                                                                                  ? other$projectManager == null
                                                                                                                  : this$projectManager.equals(
                                                                                                                     other$projectManager
                                                                                                                  )) {
                                                                                                                  Object this$structureTypeValue = this.getStructureTypeValue();
                                                                                                                  Object other$structureTypeValue = other.getStructureTypeValue();
                                                                                                                  if (this$structureTypeValue == null
                                                                                                                     ? other$structureTypeValue == null
                                                                                                                     : this$structureTypeValue.equals(
                                                                                                                        other$structureTypeValue
                                                                                                                     )) {
                                                                                                                     Object this$structureArea = this.getStructureArea();
                                                                                                                     Object other$structureArea = other.getStructureArea();
                                                                                                                     if (this$structureArea == null
                                                                                                                        ? other$structureArea == null
                                                                                                                        : this$structureArea.equals(
                                                                                                                           other$structureArea
                                                                                                                        )) {
                                                                                                                        Object this$mainStructureSteelMete = this.getMainStructureSteelMete();
                                                                                                                        Object other$mainStructureSteelMete = other.getMainStructureSteelMete();
                                                                                                                        if (this$mainStructureSteelMete == null
                                                                                                                           ? other$mainStructureSteelMete
                                                                                                                              == null
                                                                                                                           : this$mainStructureSteelMete.equals(
                                                                                                                              other$mainStructureSteelMete
                                                                                                                           )) {
                                                                                                                           Object this$subfabricSteelMete = this.getSubfabricSteelMete();
                                                                                                                           Object other$subfabricSteelMete = other.getSubfabricSteelMete();
                                                                                                                           if (this$subfabricSteelMete == null
                                                                                                                              ? other$subfabricSteelMete
                                                                                                                                 == null
                                                                                                                              : this$subfabricSteelMete.equals(
                                                                                                                                 other$subfabricSteelMete
                                                                                                                              )) {
                                                                                                                              Object this$maximumSpan = this.getMaximumSpan();
                                                                                                                              Object other$maximumSpan = other.getMaximumSpan();
                                                                                                                              if (this$maximumSpan == null
                                                                                                                                 ? other$maximumSpan == null
                                                                                                                                 : this$maximumSpan.equals(
                                                                                                                                    other$maximumSpan
                                                                                                                                 )) {
                                                                                                                                 Object this$locationValue = this.getLocationValue();
                                                                                                                                 Object other$locationValue = other.getLocationValue();
                                                                                                                                 if (this$locationValue == null
                                                                                                                                    ? other$locationValue
                                                                                                                                       == null
                                                                                                                                    : this$locationValue.equals(
                                                                                                                                       other$locationValue
                                                                                                                                    )) {
                                                                                                                                    Object this$countryValue = this.getCountryValue();
                                                                                                                                    Object other$countryValue = other.getCountryValue();
                                                                                                                                    if (this$countryValue
                                                                                                                                          == null
                                                                                                                                       ? other$countryValue
                                                                                                                                          == null
                                                                                                                                       : this$countryValue.equals(
                                                                                                                                          other$countryValue
                                                                                                                                       )) {
                                                                                                                                       Object this$provinceValue = this.getProvinceValue();
                                                                                                                                       Object other$provinceValue = other.getProvinceValue();
                                                                                                                                       if (this$provinceValue
                                                                                                                                             == null
                                                                                                                                          ? other$provinceValue
                                                                                                                                             == null
                                                                                                                                          : this$provinceValue.equals(
                                                                                                                                             other$provinceValue
                                                                                                                                          )) {
                                                                                                                                          Object this$cityValue = this.getCityValue();
                                                                                                                                          Object other$cityValue = other.getCityValue();
                                                                                                                                          if (this$cityValue
                                                                                                                                                == null
                                                                                                                                             ? other$cityValue
                                                                                                                                                == null
                                                                                                                                             : this$cityValue.equals(
                                                                                                                                                other$cityValue
                                                                                                                                             )) {
                                                                                                                                             Object this$regionValue = this.getRegionValue();
                                                                                                                                             Object other$regionValue = other.getRegionValue();
                                                                                                                                             if (this$regionValue
                                                                                                                                                   == null
                                                                                                                                                ? other$regionValue
                                                                                                                                                   == null
                                                                                                                                                : this$regionValue.equals(
                                                                                                                                                   other$regionValue
                                                                                                                                                )) {
                                                                                                                                                Object this$contractStartDate = this.getContractStartDate();
                                                                                                                                                Object other$contractStartDate = other.getContractStartDate();
                                                                                                                                                if (this$contractStartDate
                                                                                                                                                      == null
                                                                                                                                                   ? other$contractStartDate
                                                                                                                                                      == null
                                                                                                                                                   : this$contractStartDate.equals(
                                                                                                                                                      other$contractStartDate
                                                                                                                                                   )) {
                                                                                                                                                   Object this$contractEndDate = this.getContractEndDate();
                                                                                                                                                   Object other$contractEndDate = other.getContractEndDate();
                                                                                                                                                   if (this$contractEndDate
                                                                                                                                                         == null
                                                                                                                                                      ? other$contractEndDate
                                                                                                                                                         == null
                                                                                                                                                      : this$contractEndDate.equals(
                                                                                                                                                         other$contractEndDate
                                                                                                                                                      )) {
                                                                                                                                                      Object this$contractualNatureValue = this.getContractualNatureValue();
                                                                                                                                                      Object other$contractualNatureValue = other.getContractualNatureValue();
                                                                                                                                                      if (this$contractualNatureValue
                                                                                                                                                            == null
                                                                                                                                                         ? other$contractualNatureValue
                                                                                                                                                            == null
                                                                                                                                                         : this$contractualNatureValue.equals(
                                                                                                                                                            other$contractualNatureValue
                                                                                                                                                         )) {
                                                                                                                                                         Object this$biddingMethodValue = this.getBiddingMethodValue();
                                                                                                                                                         Object other$biddingMethodValue = other.getBiddingMethodValue();
                                                                                                                                                         if (this$biddingMethodValue
                                                                                                                                                               == null
                                                                                                                                                            ? other$biddingMethodValue
                                                                                                                                                               == null
                                                                                                                                                            : this$biddingMethodValue.equals(
                                                                                                                                                               other$biddingMethodValue
                                                                                                                                                            )) {
                                                                                                                                                            Object this$partyTypeValue = this.getPartyTypeValue();
                                                                                                                                                            Object other$partyTypeValue = other.getPartyTypeValue();
                                                                                                                                                            if (this$partyTypeValue
                                                                                                                                                                  == null
                                                                                                                                                               ? other$partyTypeValue
                                                                                                                                                                  == null
                                                                                                                                                               : this$partyTypeValue.equals(
                                                                                                                                                                  other$partyTypeValue
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$contractTypeValue = this.getContractTypeValue();
                                                                                                                                                               Object other$contractTypeValue = other.getContractTypeValue();
                                                                                                                                                               if (this$contractTypeValue
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$contractTypeValue
                                                                                                                                                                     == null
                                                                                                                                                                  : this$contractTypeValue.equals(
                                                                                                                                                                     other$contractTypeValue
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$attachments = this.getAttachments();
                                                                                                                                                                  Object other$attachments = other.getAttachments();
                                                                                                                                                                  if (this$attachments
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$attachments
                                                                                                                                                                        == null
                                                                                                                                                                     : this$attachments.equals(
                                                                                                                                                                        other$attachments
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$attachmentList = this.getAttachmentList();
                                                                                                                                                                     Object other$attachmentList = other.getAttachmentList();
                                                                                                                                                                     if (this$attachmentList
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$attachmentList
                                                                                                                                                                           == null
                                                                                                                                                                        : this$attachmentList.equals(
                                                                                                                                                                           other$attachmentList
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$applicationDate = this.getApplicationDate();
                                                                                                                                                                        Object other$applicationDate = other.getApplicationDate();
                                                                                                                                                                        if (this$applicationDate
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$applicationDate
                                                                                                                                                                              == null
                                                                                                                                                                           : this$applicationDate.equals(
                                                                                                                                                                              other$applicationDate
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$applicantName = this.getApplicantName();
                                                                                                                                                                           Object other$applicantName = other.getApplicantName();
                                                                                                                                                                           if (this$applicantName
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$applicantName
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$applicantName.equals(
                                                                                                                                                                                 other$applicantName
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$lastEditTime = this.getLastEditTime();
                                                                                                                                                                              Object other$lastEditTime = other.getLastEditTime();
                                                                                                                                                                              if (this$lastEditTime
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$lastEditTime
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$lastEditTime.equals(
                                                                                                                                                                                    other$lastEditTime
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$lastEditUserName = this.getLastEditUserName();
                                                                                                                                                                                 Object other$lastEditUserName = other.getLastEditUserName();
                                                                                                                                                                                 if (this$lastEditUserName
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$lastEditUserName
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$lastEditUserName.equals(
                                                                                                                                                                                       other$lastEditUserName
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$contractVersion = this.getContractVersion();
                                                                                                                                                                                    Object other$contractVersion = other.getContractVersion();
                                                                                                                                                                                    if (this$contractVersion
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$contractVersion
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$contractVersion.equals(
                                                                                                                                                                                          other$contractVersion
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$remark = this.getRemark();
                                                                                                                                                                                       Object other$remark = other.getRemark();
                                                                                                                                                                                       return this$remark
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$remark
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$remark.equals(
                                                                                                                                                                                             other$remark
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractCatalogueDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $signStatus = this.getSignStatus();
      result = result * 59 + ($signStatus == null ? 43 : $signStatus.hashCode());
      Object $issueTime = this.getIssueTime();
      result = result * 59 + ($issueTime == null ? 43 : $issueTime.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $firstLevelDept = this.getFirstLevelDept();
      result = result * 59 + ($firstLevelDept == null ? 43 : $firstLevelDept.hashCode());
      Object $secondLevelDept = this.getSecondLevelDept();
      result = result * 59 + ($secondLevelDept == null ? 43 : $secondLevelDept.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $boolCoordinate = this.getBoolCoordinate();
      result = result * 59 + ($boolCoordinate == null ? 43 : $boolCoordinate.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $locationId = this.getLocationId();
      result = result * 59 + ($locationId == null ? 43 : $locationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $contractualNature = this.getContractualNature();
      result = result * 59 + ($contractualNature == null ? 43 : $contractualNature.hashCode());
      Object $biddingMethod = this.getBiddingMethod();
      result = result * 59 + ($biddingMethod == null ? 43 : $biddingMethod.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $boolFabricatedStructure = this.getBoolFabricatedStructure();
      result = result * 59 + ($boolFabricatedStructure == null ? 43 : $boolFabricatedStructure.hashCode());
      Object $boolModelContract = this.getBoolModelContract();
      result = result * 59 + ($boolModelContract == null ? 43 : $boolModelContract.hashCode());
      Object $preRegistrationId = this.getPreRegistrationId();
      result = result * 59 + ($preRegistrationId == null ? 43 : $preRegistrationId.hashCode());
      Object $registrationId = this.getRegistrationId();
      result = result * 59 + ($registrationId == null ? 43 : $registrationId.hashCode());
      Object $createSource = this.getCreateSource();
      result = result * 59 + ($createSource == null ? 43 : $createSource.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $registerDate = this.getRegisterDate();
      result = result * 59 + ($registerDate == null ? 43 : $registerDate.hashCode());
      Object $transferDate = this.getTransferDate();
      result = result * 59 + ($transferDate == null ? 43 : $transferDate.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $partyA = this.getPartyA();
      result = result * 59 + ($partyA == null ? 43 : $partyA.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $originalContractAmount = this.getOriginalContractAmount();
      result = result * 59 + ($originalContractAmount == null ? 43 : $originalContractAmount.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $firstLevelDeptValue = this.getFirstLevelDeptValue();
      result = result * 59 + ($firstLevelDeptValue == null ? 43 : $firstLevelDeptValue.hashCode());
      Object $secondLevelDeptValue = this.getSecondLevelDeptValue();
      result = result * 59 + ($secondLevelDeptValue == null ? 43 : $secondLevelDeptValue.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $structureTypeValue = this.getStructureTypeValue();
      result = result * 59 + ($structureTypeValue == null ? 43 : $structureTypeValue.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $mainStructureSteelMete = this.getMainStructureSteelMete();
      result = result * 59 + ($mainStructureSteelMete == null ? 43 : $mainStructureSteelMete.hashCode());
      Object $subfabricSteelMete = this.getSubfabricSteelMete();
      result = result * 59 + ($subfabricSteelMete == null ? 43 : $subfabricSteelMete.hashCode());
      Object $maximumSpan = this.getMaximumSpan();
      result = result * 59 + ($maximumSpan == null ? 43 : $maximumSpan.hashCode());
      Object $locationValue = this.getLocationValue();
      result = result * 59 + ($locationValue == null ? 43 : $locationValue.hashCode());
      Object $countryValue = this.getCountryValue();
      result = result * 59 + ($countryValue == null ? 43 : $countryValue.hashCode());
      Object $provinceValue = this.getProvinceValue();
      result = result * 59 + ($provinceValue == null ? 43 : $provinceValue.hashCode());
      Object $cityValue = this.getCityValue();
      result = result * 59 + ($cityValue == null ? 43 : $cityValue.hashCode());
      Object $regionValue = this.getRegionValue();
      result = result * 59 + ($regionValue == null ? 43 : $regionValue.hashCode());
      Object $contractStartDate = this.getContractStartDate();
      result = result * 59 + ($contractStartDate == null ? 43 : $contractStartDate.hashCode());
      Object $contractEndDate = this.getContractEndDate();
      result = result * 59 + ($contractEndDate == null ? 43 : $contractEndDate.hashCode());
      Object $contractualNatureValue = this.getContractualNatureValue();
      result = result * 59 + ($contractualNatureValue == null ? 43 : $contractualNatureValue.hashCode());
      Object $biddingMethodValue = this.getBiddingMethodValue();
      result = result * 59 + ($biddingMethodValue == null ? 43 : $biddingMethodValue.hashCode());
      Object $partyTypeValue = this.getPartyTypeValue();
      result = result * 59 + ($partyTypeValue == null ? 43 : $partyTypeValue.hashCode());
      Object $contractTypeValue = this.getContractTypeValue();
      result = result * 59 + ($contractTypeValue == null ? 43 : $contractTypeValue.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $lastEditTime = this.getLastEditTime();
      result = result * 59 + ($lastEditTime == null ? 43 : $lastEditTime.hashCode());
      Object $lastEditUserName = this.getLastEditUserName();
      result = result * 59 + ($lastEditUserName == null ? 43 : $lastEditUserName.hashCode());
      Object $contractVersion = this.getContractVersion();
      result = result * 59 + ($contractVersion == null ? 43 : $contractVersion.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCatalogueDTO(id="
         + this.getId()
         + ", contractNumber="
         + this.getContractNumber()
         + ", registerDate="
         + this.getRegisterDate()
         + ", transferDate="
         + this.getTransferDate()
         + ", signStatus="
         + this.getSignStatus()
         + ", signDate="
         + this.getSignDate()
         + ", issueTime="
         + this.getIssueTime()
         + ", partyA="
         + this.getPartyA()
         + ", projectName="
         + this.getProjectName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", originalContractAmount="
         + this.getOriginalContractAmount()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", firstLevelDept="
         + this.getFirstLevelDept()
         + ", firstLevelDeptValue="
         + this.getFirstLevelDeptValue()
         + ", secondLevelDept="
         + this.getSecondLevelDept()
         + ", secondLevelDeptValue="
         + this.getSecondLevelDeptValue()
         + ", infoSource="
         + this.getInfoSource()
         + ", boolCoordinate="
         + this.getBoolCoordinate()
         + ", projectManager="
         + this.getProjectManager()
         + ", structureType="
         + this.getStructureType()
         + ", structureTypeValue="
         + this.getStructureTypeValue()
         + ", structureArea="
         + this.getStructureArea()
         + ", mainStructureSteelMete="
         + this.getMainStructureSteelMete()
         + ", subfabricSteelMete="
         + this.getSubfabricSteelMete()
         + ", maximumSpan="
         + this.getMaximumSpan()
         + ", locationId="
         + this.getLocationId()
         + ", locationValue="
         + this.getLocationValue()
         + ", countryId="
         + this.getCountryId()
         + ", countryValue="
         + this.getCountryValue()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceValue="
         + this.getProvinceValue()
         + ", cityId="
         + this.getCityId()
         + ", cityValue="
         + this.getCityValue()
         + ", regionId="
         + this.getRegionId()
         + ", regionValue="
         + this.getRegionValue()
         + ", contractStartDate="
         + this.getContractStartDate()
         + ", contractEndDate="
         + this.getContractEndDate()
         + ", contractualNature="
         + this.getContractualNature()
         + ", contractualNatureValue="
         + this.getContractualNatureValue()
         + ", biddingMethod="
         + this.getBiddingMethod()
         + ", biddingMethodValue="
         + this.getBiddingMethodValue()
         + ", partyType="
         + this.getPartyType()
         + ", partyTypeValue="
         + this.getPartyTypeValue()
         + ", contractType="
         + this.getContractType()
         + ", contractTypeValue="
         + this.getContractTypeValue()
         + ", boolFabricatedStructure="
         + this.getBoolFabricatedStructure()
         + ", boolModelContract="
         + this.getBoolModelContract()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", preRegistrationId="
         + this.getPreRegistrationId()
         + ", registrationId="
         + this.getRegistrationId()
         + ", createSource="
         + this.getCreateSource()
         + ", applicationDate="
         + this.getApplicationDate()
         + ", applicantName="
         + this.getApplicantName()
         + ", lastEditTime="
         + this.getLastEditTime()
         + ", lastEditUserName="
         + this.getLastEditUserName()
         + ", contractVersion="
         + this.getContractVersion()
         + ", remark="
         + this.getRemark()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   public static class ContractCatalogueDTOBuilder {
      private Long id;
      private String contractNumber;
      private LocalDateTime registerDate;
      private LocalDateTime transferDate;
      private Boolean signStatus;
      private LocalDateTime signDate;
      private Integer issueTime;
      private String partyA;
      private String projectName;
      private BigDecimal contractAmount;
      private BigDecimal originalContractAmount;
      private Long signerId;
      private String signerName;
      private Long firstLevelDept;
      private String firstLevelDeptValue;
      private Long secondLevelDept;
      private String secondLevelDeptValue;
      private Integer infoSource;
      private Boolean boolCoordinate;
      private String projectManager;
      private Long structureType;
      private String structureTypeValue;
      private BigDecimal structureArea;
      private BigDecimal mainStructureSteelMete;
      private BigDecimal subfabricSteelMete;
      private BigDecimal maximumSpan;
      private Long locationId;
      private String locationValue;
      private Long countryId;
      private String countryValue;
      private Long provinceId;
      private String provinceValue;
      private Long cityId;
      private String cityValue;
      private Long regionId;
      private String regionValue;
      private LocalDateTime contractStartDate;
      private LocalDateTime contractEndDate;
      private Long contractualNature;
      private String contractualNatureValue;
      private Long biddingMethod;
      private String biddingMethodValue;
      private Long partyType;
      private String partyTypeValue;
      private Long contractType;
      private String contractTypeValue;
      private Boolean boolFabricatedStructure;
      private Boolean boolModelContract;
      private String attachments;
      private List<AttachmentDTO> attachmentList;
      private Long preRegistrationId;
      private Long registrationId;
      private Integer createSource;
      private LocalDateTime applicationDate;
      private String applicantName;
      private LocalDateTime lastEditTime;
      private String lastEditUserName;
      private String contractVersion;
      private String remark;
      private Integer reviewStatus;

      ContractCatalogueDTOBuilder() {
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder registerDate(final LocalDateTime registerDate) {
         this.registerDate = registerDate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder transferDate(final LocalDateTime transferDate) {
         this.transferDate = transferDate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder signStatus(final Boolean signStatus) {
         this.signStatus = signStatus;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder signDate(final LocalDateTime signDate) {
         this.signDate = signDate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder issueTime(final Integer issueTime) {
         this.issueTime = issueTime;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder partyA(final String partyA) {
         this.partyA = partyA;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder originalContractAmount(final BigDecimal originalContractAmount) {
         this.originalContractAmount = originalContractAmount;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder firstLevelDeptValue(final String firstLevelDeptValue) {
         this.firstLevelDeptValue = firstLevelDeptValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder secondLevelDeptValue(final String secondLevelDeptValue) {
         this.secondLevelDeptValue = secondLevelDeptValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder boolCoordinate(final Boolean boolCoordinate) {
         this.boolCoordinate = boolCoordinate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder projectManager(final String projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder structureTypeValue(final String structureTypeValue) {
         this.structureTypeValue = structureTypeValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder mainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
         this.mainStructureSteelMete = mainStructureSteelMete;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder subfabricSteelMete(final BigDecimal subfabricSteelMete) {
         this.subfabricSteelMete = subfabricSteelMete;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder maximumSpan(final BigDecimal maximumSpan) {
         this.maximumSpan = maximumSpan;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder locationValue(final String locationValue) {
         this.locationValue = locationValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder countryValue(final String countryValue) {
         this.countryValue = countryValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder provinceValue(final String provinceValue) {
         this.provinceValue = provinceValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder cityValue(final String cityValue) {
         this.cityValue = cityValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder regionValue(final String regionValue) {
         this.regionValue = regionValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractStartDate(final LocalDateTime contractStartDate) {
         this.contractStartDate = contractStartDate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractEndDate(final LocalDateTime contractEndDate) {
         this.contractEndDate = contractEndDate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractualNatureValue(final String contractualNatureValue) {
         this.contractualNatureValue = contractualNatureValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder biddingMethod(final Long biddingMethod) {
         this.biddingMethod = biddingMethod;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder biddingMethodValue(final String biddingMethodValue) {
         this.biddingMethodValue = biddingMethodValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder partyTypeValue(final String partyTypeValue) {
         this.partyTypeValue = partyTypeValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractType(final Long contractType) {
         this.contractType = contractType;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractTypeValue(final String contractTypeValue) {
         this.contractTypeValue = contractTypeValue;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder boolFabricatedStructure(final Boolean boolFabricatedStructure) {
         this.boolFabricatedStructure = boolFabricatedStructure;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder boolModelContract(final Boolean boolModelContract) {
         this.boolModelContract = boolModelContract;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder preRegistrationId(final Long preRegistrationId) {
         this.preRegistrationId = preRegistrationId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder registrationId(final Long registrationId) {
         this.registrationId = registrationId;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder createSource(final Integer createSource) {
         this.createSource = createSource;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder lastEditTime(final LocalDateTime lastEditTime) {
         this.lastEditTime = lastEditTime;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder lastEditUserName(final String lastEditUserName) {
         this.lastEditUserName = lastEditUserName;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder contractVersion(final String contractVersion) {
         this.contractVersion = contractVersion;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCatalogueDTO.ContractCatalogueDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractCatalogueDTO build() {
         return new ContractCatalogueDTO(
            this.id,
            this.contractNumber,
            this.registerDate,
            this.transferDate,
            this.signStatus,
            this.signDate,
            this.issueTime,
            this.partyA,
            this.projectName,
            this.contractAmount,
            this.originalContractAmount,
            this.signerId,
            this.signerName,
            this.firstLevelDept,
            this.firstLevelDeptValue,
            this.secondLevelDept,
            this.secondLevelDeptValue,
            this.infoSource,
            this.boolCoordinate,
            this.projectManager,
            this.structureType,
            this.structureTypeValue,
            this.structureArea,
            this.mainStructureSteelMete,
            this.subfabricSteelMete,
            this.maximumSpan,
            this.locationId,
            this.locationValue,
            this.countryId,
            this.countryValue,
            this.provinceId,
            this.provinceValue,
            this.cityId,
            this.cityValue,
            this.regionId,
            this.regionValue,
            this.contractStartDate,
            this.contractEndDate,
            this.contractualNature,
            this.contractualNatureValue,
            this.biddingMethod,
            this.biddingMethodValue,
            this.partyType,
            this.partyTypeValue,
            this.contractType,
            this.contractTypeValue,
            this.boolFabricatedStructure,
            this.boolModelContract,
            this.attachments,
            this.attachmentList,
            this.preRegistrationId,
            this.registrationId,
            this.createSource,
            this.applicationDate,
            this.applicantName,
            this.lastEditTime,
            this.lastEditUserName,
            this.contractVersion,
            this.remark,
            this.reviewStatus
         );
      }

      @Override
      public String toString() {
         return "ContractCatalogueDTO.ContractCatalogueDTOBuilder(id="
            + this.id
            + ", contractNumber="
            + this.contractNumber
            + ", registerDate="
            + this.registerDate
            + ", transferDate="
            + this.transferDate
            + ", signStatus="
            + this.signStatus
            + ", signDate="
            + this.signDate
            + ", issueTime="
            + this.issueTime
            + ", partyA="
            + this.partyA
            + ", projectName="
            + this.projectName
            + ", contractAmount="
            + this.contractAmount
            + ", originalContractAmount="
            + this.originalContractAmount
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", firstLevelDept="
            + this.firstLevelDept
            + ", firstLevelDeptValue="
            + this.firstLevelDeptValue
            + ", secondLevelDept="
            + this.secondLevelDept
            + ", secondLevelDeptValue="
            + this.secondLevelDeptValue
            + ", infoSource="
            + this.infoSource
            + ", boolCoordinate="
            + this.boolCoordinate
            + ", projectManager="
            + this.projectManager
            + ", structureType="
            + this.structureType
            + ", structureTypeValue="
            + this.structureTypeValue
            + ", structureArea="
            + this.structureArea
            + ", mainStructureSteelMete="
            + this.mainStructureSteelMete
            + ", subfabricSteelMete="
            + this.subfabricSteelMete
            + ", maximumSpan="
            + this.maximumSpan
            + ", locationId="
            + this.locationId
            + ", locationValue="
            + this.locationValue
            + ", countryId="
            + this.countryId
            + ", countryValue="
            + this.countryValue
            + ", provinceId="
            + this.provinceId
            + ", provinceValue="
            + this.provinceValue
            + ", cityId="
            + this.cityId
            + ", cityValue="
            + this.cityValue
            + ", regionId="
            + this.regionId
            + ", regionValue="
            + this.regionValue
            + ", contractStartDate="
            + this.contractStartDate
            + ", contractEndDate="
            + this.contractEndDate
            + ", contractualNature="
            + this.contractualNature
            + ", contractualNatureValue="
            + this.contractualNatureValue
            + ", biddingMethod="
            + this.biddingMethod
            + ", biddingMethodValue="
            + this.biddingMethodValue
            + ", partyType="
            + this.partyType
            + ", partyTypeValue="
            + this.partyTypeValue
            + ", contractType="
            + this.contractType
            + ", contractTypeValue="
            + this.contractTypeValue
            + ", boolFabricatedStructure="
            + this.boolFabricatedStructure
            + ", boolModelContract="
            + this.boolModelContract
            + ", attachments="
            + this.attachments
            + ", attachmentList="
            + this.attachmentList
            + ", preRegistrationId="
            + this.preRegistrationId
            + ", registrationId="
            + this.registrationId
            + ", createSource="
            + this.createSource
            + ", applicationDate="
            + this.applicationDate
            + ", applicantName="
            + this.applicantName
            + ", lastEditTime="
            + this.lastEditTime
            + ", lastEditUserName="
            + this.lastEditUserName
            + ", contractVersion="
            + this.contractVersion
            + ", remark="
            + this.remark
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
