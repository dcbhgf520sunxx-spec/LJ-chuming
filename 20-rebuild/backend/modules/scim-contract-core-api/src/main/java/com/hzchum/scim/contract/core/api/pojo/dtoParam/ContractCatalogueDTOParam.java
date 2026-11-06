package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractCatalogueDTOParam {
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
   private LocalDateTime issueTime;
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
   @ApiModelProperty(name = "secondLevelDept", value = "所属二级部门")
   private Long secondLevelDept;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Integer infoSource;
   @ApiModelProperty(name = "boolCoordinate", value = "销售员是否配合")
   private Boolean boolCoordinate;
   @ApiModelProperty(name = "projectManager", value = "项目经理")
   private String projectManager;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private Long structureType;
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
   @ApiModelProperty(name = "countryId", value = "国家ID")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省份ID")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "城市ID")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "区ID")
   private Long regionId;
   @ApiModelProperty(name = "contractStartDate", value = "开工时间")
   private LocalDateTime contractStartDate;
   @ApiModelProperty(name = "contractEndDate", value = "竣工时间")
   private LocalDateTime contractEndDate;
   @ApiModelProperty(name = "contractualNature", value = "承包性质")
   private Long contractualNature;
   @ApiModelProperty(name = "biddingMethod", value = "招标方式")
   private Long biddingMethod;
   @ApiModelProperty(name = "partyType", value = "甲方类别")
   private Long partyType;
   @ApiModelProperty(name = "boolFabricatedStructure", value = "是否装配式建筑")
   private Boolean boolFabricatedStructure;
   @ApiModelProperty(name = "boolModelContract", value = "是否示范合同")
   private Boolean boolModelContract;
   @ApiModelProperty(name = "attachments", value = "合同附件ID集")
   private String attachments;
   @ApiModelProperty(name = "preRegistrationId", value = "预登记ID")
   private Long preRegistrationId;
   @ApiModelProperty(name = "registrationId", value = "合同登记ID")
   private Long registrationId;
   @ApiModelProperty(name = "createSource", value = "创建来源 0预登记 1评审登记 2直接登记")
   private Integer createSource;
   @ApiModelProperty(name = "contractVersion", value = "合同版本")
   private String contractVersion;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人")
   private String applicantName;
   @ApiModelProperty(name = "lastEditTime", value = "最后编辑时间")
   private LocalDateTime lastEditTime;
   @ApiModelProperty(name = "lastEditUserId", value = "最后编辑人ID")
   private Long lastEditUserId;
   @ApiModelProperty(name = "lastEditUserName", value = "最后编辑人名称")
   private String lastEditUserName;
   @ApiModelProperty(name = "initDataId", value = "初始化数据ID")
   private Long initDataId;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;

   public static ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder builder() {
      return new ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder();
   }

   public ContractCatalogueDTOParam() {
   }

   public ContractCatalogueDTOParam(
      final Long id,
      final String contractNumber,
      final LocalDateTime registerDate,
      final LocalDateTime transferDate,
      final Boolean signStatus,
      final LocalDateTime signDate,
      final LocalDateTime issueTime,
      final String partyA,
      final String projectName,
      final BigDecimal contractAmount,
      final BigDecimal originalContractAmount,
      final Long signerId,
      final String signerName,
      final Long firstLevelDept,
      final Long secondLevelDept,
      final Integer infoSource,
      final Boolean boolCoordinate,
      final String projectManager,
      final Long structureType,
      final BigDecimal structureArea,
      final BigDecimal mainStructureSteelMete,
      final BigDecimal subfabricSteelMete,
      final BigDecimal maximumSpan,
      final Long locationId,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final LocalDateTime contractStartDate,
      final LocalDateTime contractEndDate,
      final Long contractualNature,
      final Long biddingMethod,
      final Long partyType,
      final Boolean boolFabricatedStructure,
      final Boolean boolModelContract,
      final String attachments,
      final Long preRegistrationId,
      final Long registrationId,
      final Integer createSource,
      final String contractVersion,
      final Long applicantId,
      final String applicantName,
      final LocalDateTime lastEditTime,
      final Long lastEditUserId,
      final String lastEditUserName,
      final Long initDataId,
      final String remark
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
      this.secondLevelDept = secondLevelDept;
      this.infoSource = infoSource;
      this.boolCoordinate = boolCoordinate;
      this.projectManager = projectManager;
      this.structureType = structureType;
      this.structureArea = structureArea;
      this.mainStructureSteelMete = mainStructureSteelMete;
      this.subfabricSteelMete = subfabricSteelMete;
      this.maximumSpan = maximumSpan;
      this.locationId = locationId;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.contractStartDate = contractStartDate;
      this.contractEndDate = contractEndDate;
      this.contractualNature = contractualNature;
      this.biddingMethod = biddingMethod;
      this.partyType = partyType;
      this.boolFabricatedStructure = boolFabricatedStructure;
      this.boolModelContract = boolModelContract;
      this.attachments = attachments;
      this.preRegistrationId = preRegistrationId;
      this.registrationId = registrationId;
      this.createSource = createSource;
      this.contractVersion = contractVersion;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.lastEditTime = lastEditTime;
      this.lastEditUserId = lastEditUserId;
      this.lastEditUserName = lastEditUserName;
      this.initDataId = initDataId;
      this.remark = remark;
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

   public LocalDateTime getIssueTime() {
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

   public Long getSecondLevelDept() {
      return this.secondLevelDept;
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

   public Long getCountryId() {
      return this.countryId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
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

   public Long getBiddingMethod() {
      return this.biddingMethod;
   }

   public Long getPartyType() {
      return this.partyType;
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

   public Long getPreRegistrationId() {
      return this.preRegistrationId;
   }

   public Long getRegistrationId() {
      return this.registrationId;
   }

   public Integer getCreateSource() {
      return this.createSource;
   }

   public String getContractVersion() {
      return this.contractVersion;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getLastEditTime() {
      return this.lastEditTime;
   }

   public Long getLastEditUserId() {
      return this.lastEditUserId;
   }

   public String getLastEditUserName() {
      return this.lastEditUserName;
   }

   public Long getInitDataId() {
      return this.initDataId;
   }

   public String getRemark() {
      return this.remark;
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

   public void setIssueTime(final LocalDateTime issueTime) {
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

   public void setSecondLevelDept(final Long secondLevelDept) {
      this.secondLevelDept = secondLevelDept;
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

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
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

   public void setBiddingMethod(final Long biddingMethod) {
      this.biddingMethod = biddingMethod;
   }

   public void setPartyType(final Long partyType) {
      this.partyType = partyType;
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

   public void setPreRegistrationId(final Long preRegistrationId) {
      this.preRegistrationId = preRegistrationId;
   }

   public void setRegistrationId(final Long registrationId) {
      this.registrationId = registrationId;
   }

   public void setCreateSource(final Integer createSource) {
      this.createSource = createSource;
   }

   public void setContractVersion(final String contractVersion) {
      this.contractVersion = contractVersion;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setLastEditTime(final LocalDateTime lastEditTime) {
      this.lastEditTime = lastEditTime;
   }

   public void setLastEditUserId(final Long lastEditUserId) {
      this.lastEditUserId = lastEditUserId;
   }

   public void setLastEditUserName(final String lastEditUserName) {
      this.lastEditUserName = lastEditUserName;
   }

   public void setInitDataId(final Long initDataId) {
      this.initDataId = initDataId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCatalogueDTOParam)) {
         return false;
      }

      ContractCatalogueDTOParam other = (ContractCatalogueDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$signStatus = this.getSignStatus();
         Object other$signStatus = other.getSignStatus();
         if (this$signStatus == null ? other$signStatus == null : this$signStatus.equals(other$signStatus)) {
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
                                                if (this$biddingMethod == null ? other$biddingMethod == null : this$biddingMethod.equals(other$biddingMethod)) {
                                                   Object this$partyType = this.getPartyType();
                                                   Object other$partyType = other.getPartyType();
                                                   if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
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
                                                                     Object this$applicantId = this.getApplicantId();
                                                                     Object other$applicantId = other.getApplicantId();
                                                                     if (this$applicantId == null
                                                                        ? other$applicantId == null
                                                                        : this$applicantId.equals(other$applicantId)) {
                                                                        Object this$lastEditUserId = this.getLastEditUserId();
                                                                        Object other$lastEditUserId = other.getLastEditUserId();
                                                                        if (this$lastEditUserId == null
                                                                           ? other$lastEditUserId == null
                                                                           : this$lastEditUserId.equals(other$lastEditUserId)) {
                                                                           Object this$initDataId = this.getInitDataId();
                                                                           Object other$initDataId = other.getInitDataId();
                                                                           if (this$initDataId == null
                                                                              ? other$initDataId == null
                                                                              : this$initDataId.equals(other$initDataId)) {
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
                                                                                          Object this$issueTime = this.getIssueTime();
                                                                                          Object other$issueTime = other.getIssueTime();
                                                                                          if (this$issueTime == null
                                                                                             ? other$issueTime == null
                                                                                             : this$issueTime.equals(other$issueTime)) {
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
                                                                                                            Object this$projectManager = this.getProjectManager();
                                                                                                            Object other$projectManager = other.getProjectManager();
                                                                                                            if (this$projectManager == null
                                                                                                               ? other$projectManager == null
                                                                                                               : this$projectManager.equals(
                                                                                                                  other$projectManager
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
                                                                                                                     ? other$mainStructureSteelMete == null
                                                                                                                     : this$mainStructureSteelMete.equals(
                                                                                                                        other$mainStructureSteelMete
                                                                                                                     )) {
                                                                                                                     Object this$subfabricSteelMete = this.getSubfabricSteelMete();
                                                                                                                     Object other$subfabricSteelMete = other.getSubfabricSteelMete();
                                                                                                                     if (this$subfabricSteelMete == null
                                                                                                                        ? other$subfabricSteelMete == null
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
                                                                                                                           Object this$contractStartDate = this.getContractStartDate();
                                                                                                                           Object other$contractStartDate = other.getContractStartDate();
                                                                                                                           if (this$contractStartDate == null
                                                                                                                              ? other$contractStartDate == null
                                                                                                                              : this$contractStartDate.equals(
                                                                                                                                 other$contractStartDate
                                                                                                                              )) {
                                                                                                                              Object this$contractEndDate = this.getContractEndDate();
                                                                                                                              Object other$contractEndDate = other.getContractEndDate();
                                                                                                                              if (this$contractEndDate == null
                                                                                                                                 ? other$contractEndDate
                                                                                                                                    == null
                                                                                                                                 : this$contractEndDate.equals(
                                                                                                                                    other$contractEndDate
                                                                                                                                 )) {
                                                                                                                                 Object this$attachments = this.getAttachments();
                                                                                                                                 Object other$attachments = other.getAttachments();
                                                                                                                                 if (this$attachments == null
                                                                                                                                    ? other$attachments == null
                                                                                                                                    : this$attachments.equals(
                                                                                                                                       other$attachments
                                                                                                                                    )) {
                                                                                                                                    Object this$contractVersion = this.getContractVersion();
                                                                                                                                    Object other$contractVersion = other.getContractVersion();
                                                                                                                                    if (this$contractVersion
                                                                                                                                          == null
                                                                                                                                       ? other$contractVersion
                                                                                                                                          == null
                                                                                                                                       : this$contractVersion.equals(
                                                                                                                                          other$contractVersion
                                                                                                                                       )) {
                                                                                                                                       Object this$applicantName = this.getApplicantName();
                                                                                                                                       Object other$applicantName = other.getApplicantName();
                                                                                                                                       if (this$applicantName
                                                                                                                                             == null
                                                                                                                                          ? other$applicantName
                                                                                                                                             == null
                                                                                                                                          : this$applicantName.equals(
                                                                                                                                             other$applicantName
                                                                                                                                          )) {
                                                                                                                                          Object this$lastEditTime = this.getLastEditTime();
                                                                                                                                          Object other$lastEditTime = other.getLastEditTime();
                                                                                                                                          if (this$lastEditTime
                                                                                                                                                == null
                                                                                                                                             ? other$lastEditTime
                                                                                                                                                == null
                                                                                                                                             : this$lastEditTime.equals(
                                                                                                                                                other$lastEditTime
                                                                                                                                             )) {
                                                                                                                                             Object this$lastEditUserName = this.getLastEditUserName();
                                                                                                                                             Object other$lastEditUserName = other.getLastEditUserName();
                                                                                                                                             if (this$lastEditUserName
                                                                                                                                                   == null
                                                                                                                                                ? other$lastEditUserName
                                                                                                                                                   == null
                                                                                                                                                : this$lastEditUserName.equals(
                                                                                                                                                   other$lastEditUserName
                                                                                                                                                )) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractCatalogueDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $signStatus = this.getSignStatus();
      result = result * 59 + ($signStatus == null ? 43 : $signStatus.hashCode());
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
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $lastEditUserId = this.getLastEditUserId();
      result = result * 59 + ($lastEditUserId == null ? 43 : $lastEditUserId.hashCode());
      Object $initDataId = this.getInitDataId();
      result = result * 59 + ($initDataId == null ? 43 : $initDataId.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $registerDate = this.getRegisterDate();
      result = result * 59 + ($registerDate == null ? 43 : $registerDate.hashCode());
      Object $transferDate = this.getTransferDate();
      result = result * 59 + ($transferDate == null ? 43 : $transferDate.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $issueTime = this.getIssueTime();
      result = result * 59 + ($issueTime == null ? 43 : $issueTime.hashCode());
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
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $mainStructureSteelMete = this.getMainStructureSteelMete();
      result = result * 59 + ($mainStructureSteelMete == null ? 43 : $mainStructureSteelMete.hashCode());
      Object $subfabricSteelMete = this.getSubfabricSteelMete();
      result = result * 59 + ($subfabricSteelMete == null ? 43 : $subfabricSteelMete.hashCode());
      Object $maximumSpan = this.getMaximumSpan();
      result = result * 59 + ($maximumSpan == null ? 43 : $maximumSpan.hashCode());
      Object $contractStartDate = this.getContractStartDate();
      result = result * 59 + ($contractStartDate == null ? 43 : $contractStartDate.hashCode());
      Object $contractEndDate = this.getContractEndDate();
      result = result * 59 + ($contractEndDate == null ? 43 : $contractEndDate.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $contractVersion = this.getContractVersion();
      result = result * 59 + ($contractVersion == null ? 43 : $contractVersion.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $lastEditTime = this.getLastEditTime();
      result = result * 59 + ($lastEditTime == null ? 43 : $lastEditTime.hashCode());
      Object $lastEditUserName = this.getLastEditUserName();
      result = result * 59 + ($lastEditUserName == null ? 43 : $lastEditUserName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCatalogueDTOParam(id="
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
         + ", secondLevelDept="
         + this.getSecondLevelDept()
         + ", infoSource="
         + this.getInfoSource()
         + ", boolCoordinate="
         + this.getBoolCoordinate()
         + ", projectManager="
         + this.getProjectManager()
         + ", structureType="
         + this.getStructureType()
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
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
         + ", contractStartDate="
         + this.getContractStartDate()
         + ", contractEndDate="
         + this.getContractEndDate()
         + ", contractualNature="
         + this.getContractualNature()
         + ", biddingMethod="
         + this.getBiddingMethod()
         + ", partyType="
         + this.getPartyType()
         + ", boolFabricatedStructure="
         + this.getBoolFabricatedStructure()
         + ", boolModelContract="
         + this.getBoolModelContract()
         + ", attachments="
         + this.getAttachments()
         + ", preRegistrationId="
         + this.getPreRegistrationId()
         + ", registrationId="
         + this.getRegistrationId()
         + ", createSource="
         + this.getCreateSource()
         + ", contractVersion="
         + this.getContractVersion()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", lastEditTime="
         + this.getLastEditTime()
         + ", lastEditUserId="
         + this.getLastEditUserId()
         + ", lastEditUserName="
         + this.getLastEditUserName()
         + ", initDataId="
         + this.getInitDataId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractCatalogueDTOParamBuilder {
      private Long id;
      private String contractNumber;
      private LocalDateTime registerDate;
      private LocalDateTime transferDate;
      private Boolean signStatus;
      private LocalDateTime signDate;
      private LocalDateTime issueTime;
      private String partyA;
      private String projectName;
      private BigDecimal contractAmount;
      private BigDecimal originalContractAmount;
      private Long signerId;
      private String signerName;
      private Long firstLevelDept;
      private Long secondLevelDept;
      private Integer infoSource;
      private Boolean boolCoordinate;
      private String projectManager;
      private Long structureType;
      private BigDecimal structureArea;
      private BigDecimal mainStructureSteelMete;
      private BigDecimal subfabricSteelMete;
      private BigDecimal maximumSpan;
      private Long locationId;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private LocalDateTime contractStartDate;
      private LocalDateTime contractEndDate;
      private Long contractualNature;
      private Long biddingMethod;
      private Long partyType;
      private Boolean boolFabricatedStructure;
      private Boolean boolModelContract;
      private String attachments;
      private Long preRegistrationId;
      private Long registrationId;
      private Integer createSource;
      private String contractVersion;
      private Long applicantId;
      private String applicantName;
      private LocalDateTime lastEditTime;
      private Long lastEditUserId;
      private String lastEditUserName;
      private Long initDataId;
      private String remark;

      ContractCatalogueDTOParamBuilder() {
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder registerDate(final LocalDateTime registerDate) {
         this.registerDate = registerDate;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder transferDate(final LocalDateTime transferDate) {
         this.transferDate = transferDate;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder signStatus(final Boolean signStatus) {
         this.signStatus = signStatus;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder signDate(final LocalDateTime signDate) {
         this.signDate = signDate;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder issueTime(final LocalDateTime issueTime) {
         this.issueTime = issueTime;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder partyA(final String partyA) {
         this.partyA = partyA;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder originalContractAmount(final BigDecimal originalContractAmount) {
         this.originalContractAmount = originalContractAmount;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder boolCoordinate(final Boolean boolCoordinate) {
         this.boolCoordinate = boolCoordinate;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder projectManager(final String projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder mainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
         this.mainStructureSteelMete = mainStructureSteelMete;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder subfabricSteelMete(final BigDecimal subfabricSteelMete) {
         this.subfabricSteelMete = subfabricSteelMete;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder maximumSpan(final BigDecimal maximumSpan) {
         this.maximumSpan = maximumSpan;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder contractStartDate(final LocalDateTime contractStartDate) {
         this.contractStartDate = contractStartDate;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder contractEndDate(final LocalDateTime contractEndDate) {
         this.contractEndDate = contractEndDate;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder biddingMethod(final Long biddingMethod) {
         this.biddingMethod = biddingMethod;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder boolFabricatedStructure(final Boolean boolFabricatedStructure) {
         this.boolFabricatedStructure = boolFabricatedStructure;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder boolModelContract(final Boolean boolModelContract) {
         this.boolModelContract = boolModelContract;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder preRegistrationId(final Long preRegistrationId) {
         this.preRegistrationId = preRegistrationId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder registrationId(final Long registrationId) {
         this.registrationId = registrationId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder createSource(final Integer createSource) {
         this.createSource = createSource;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder contractVersion(final String contractVersion) {
         this.contractVersion = contractVersion;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder lastEditTime(final LocalDateTime lastEditTime) {
         this.lastEditTime = lastEditTime;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder lastEditUserId(final Long lastEditUserId) {
         this.lastEditUserId = lastEditUserId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder lastEditUserName(final String lastEditUserName) {
         this.lastEditUserName = lastEditUserName;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      public ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCatalogueDTOParam build() {
         return new ContractCatalogueDTOParam(
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
            this.secondLevelDept,
            this.infoSource,
            this.boolCoordinate,
            this.projectManager,
            this.structureType,
            this.structureArea,
            this.mainStructureSteelMete,
            this.subfabricSteelMete,
            this.maximumSpan,
            this.locationId,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.contractStartDate,
            this.contractEndDate,
            this.contractualNature,
            this.biddingMethod,
            this.partyType,
            this.boolFabricatedStructure,
            this.boolModelContract,
            this.attachments,
            this.preRegistrationId,
            this.registrationId,
            this.createSource,
            this.contractVersion,
            this.applicantId,
            this.applicantName,
            this.lastEditTime,
            this.lastEditUserId,
            this.lastEditUserName,
            this.initDataId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractCatalogueDTOParam.ContractCatalogueDTOParamBuilder(id="
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
            + ", secondLevelDept="
            + this.secondLevelDept
            + ", infoSource="
            + this.infoSource
            + ", boolCoordinate="
            + this.boolCoordinate
            + ", projectManager="
            + this.projectManager
            + ", structureType="
            + this.structureType
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
            + ", countryId="
            + this.countryId
            + ", provinceId="
            + this.provinceId
            + ", cityId="
            + this.cityId
            + ", regionId="
            + this.regionId
            + ", contractStartDate="
            + this.contractStartDate
            + ", contractEndDate="
            + this.contractEndDate
            + ", contractualNature="
            + this.contractualNature
            + ", biddingMethod="
            + this.biddingMethod
            + ", partyType="
            + this.partyType
            + ", boolFabricatedStructure="
            + this.boolFabricatedStructure
            + ", boolModelContract="
            + this.boolModelContract
            + ", attachments="
            + this.attachments
            + ", preRegistrationId="
            + this.preRegistrationId
            + ", registrationId="
            + this.registrationId
            + ", createSource="
            + this.createSource
            + ", contractVersion="
            + this.contractVersion
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", lastEditTime="
            + this.lastEditTime
            + ", lastEditUserId="
            + this.lastEditUserId
            + ", lastEditUserName="
            + this.lastEditUserName
            + ", initDataId="
            + this.initDataId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
