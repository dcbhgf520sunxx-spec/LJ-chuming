package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractRegistrationDTOParam {
   private Long id;
   @ApiModelProperty("合同登记编号")
   private String registrationNo;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号")
   private String contractNumber;
   @ApiModelProperty("登记类型 1评审登记 2直接登记")
   private Integer registrationType;
   @ApiModelProperty("标题")
   private String title;
   @ApiModelProperty("预登记ID")
   private Long preRegistrationId;
   @ApiModelProperty("合同目录ID")
   private Long contractCatalogueId;
   @ApiModelProperty("申请人ID")
   private Long applicantId;
   @ApiModelProperty("申请人名称")
   private String applicantName;
   @ApiModelProperty("申请人部门Id")
   private Long deptId;
   @ApiModelProperty("申请编号")
   private String applicationNumber;
   @ApiModelProperty("申请日期")
   private LocalDateTime applicationDate;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("签订人ID")
   private Long signerId;
   @ApiModelProperty("签订人姓名")
   private String signerName;
   @ApiModelProperty("所属一级部门")
   private Long firstLevelDept;
   @ApiModelProperty("所属二级部门")
   private Long secondLevelDept;
   @ApiModelProperty("合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty("合同类型")
   private Long contractType;
   @ApiModelProperty("信息来源")
   private Integer infoSource;
   @ApiModelProperty("项目经理")
   private String projectManager;
   @ApiModelProperty("销售员是否配合")
   private Boolean boolCoordinate;
   @ApiModelProperty("甲方")
   private String partyA;
   @ApiModelProperty("乙方")
   private String partyB;
   @ApiModelProperty("丙方")
   private String partyC;
   @ApiModelProperty("丁方")
   private String partyD;
   @ApiModelProperty("是否存在中标通知书")
   private Boolean boolBidWinningNotice;
   @ApiModelProperty("图纸 1有、2无、3电子版")
   private Integer drawing;
   @ApiModelProperty("是否有报价书")
   private Boolean boolBidProposals;
   @ApiModelProperty("是否有招标文件")
   private Boolean boolBidDocument;
   @ApiModelProperty("承包性质")
   private Long contractualNature;
   @ApiModelProperty("招标方式")
   private Long biddingMethod;
   @ApiModelProperty("甲方类别")
   private Long partyType;
   @ApiModelProperty("是否装配式建筑")
   private Boolean boolFabricatedStructure;
   @ApiModelProperty("是否示范合同")
   private Boolean boolModelContract;
   @ApiModelProperty("区域Id")
   private Integer locationId;
   @ApiModelProperty("国家ID")
   private Long countryId;
   @ApiModelProperty("省份ID")
   private Long provinceId;
   @ApiModelProperty("城市ID")
   private Long cityId;
   @ApiModelProperty("区ID")
   private Long regionId;
   @ApiModelProperty("结构类型")
   private Long structureType;
   @ApiModelProperty("建筑面积（平方米）")
   private BigDecimal structureArea;
   @ApiModelProperty("主结构用钢量(吨)")
   private BigDecimal mainStructureSteelMete;
   @ApiModelProperty("次结构用钢量(吨)")
   private BigDecimal subfabricSteelMete;
   @ApiModelProperty("最大跨度/高度")
   private BigDecimal maximumSpan;
   @ApiModelProperty("开工时间")
   private LocalDateTime contractStartDate;
   @ApiModelProperty("竣工时间")
   private LocalDateTime contractEndDate;
   @ApiModelProperty("总工期（天）")
   private Integer allDays;
   @ApiModelProperty("预付款比例")
   private String prepaymentRatio;
   @ApiModelProperty("质保金比例")
   private String warrantyRatio;
   @ApiModelProperty("是否有农民工工资专户")
   private Boolean boolPeasantWorkerWageAccount;
   @ApiModelProperty("农民工工资比例")
   private String peasantWorkerWageRatio;
   @ApiModelProperty("进度款")
   private String progressPayment;
   @ApiModelProperty("材料调差")
   private String materialInspection;
   @ApiModelProperty("合同附件ID集")
   private String attachments;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty(name = "initDataId", value = "初始数据ID")
   private Long initDataId;
   @ApiModelProperty(name = "是否增补合同", value = "是否增补合同")
   private Boolean boolSupplement;

   public static ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder builder() {
      return new ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder();
   }

   public ContractRegistrationDTOParam() {
   }

   public ContractRegistrationDTOParam(
      final Long id,
      final String registrationNo,
      final String contractNumber,
      final Integer registrationType,
      final String title,
      final Long preRegistrationId,
      final Long contractCatalogueId,
      final Long applicantId,
      final String applicantName,
      final Long deptId,
      final String applicationNumber,
      final LocalDateTime applicationDate,
      final String projectName,
      final Long signerId,
      final String signerName,
      final Long firstLevelDept,
      final Long secondLevelDept,
      final BigDecimal contractAmount,
      final BigDecimal taxRate,
      final Long contractType,
      final Integer infoSource,
      final String projectManager,
      final Boolean boolCoordinate,
      final String partyA,
      final String partyB,
      final String partyC,
      final String partyD,
      final Boolean boolBidWinningNotice,
      final Integer drawing,
      final Boolean boolBidProposals,
      final Boolean boolBidDocument,
      final Long contractualNature,
      final Long biddingMethod,
      final Long partyType,
      final Boolean boolFabricatedStructure,
      final Boolean boolModelContract,
      final Integer locationId,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final Long structureType,
      final BigDecimal structureArea,
      final BigDecimal mainStructureSteelMete,
      final BigDecimal subfabricSteelMete,
      final BigDecimal maximumSpan,
      final LocalDateTime contractStartDate,
      final LocalDateTime contractEndDate,
      final Integer allDays,
      final String prepaymentRatio,
      final String warrantyRatio,
      final Boolean boolPeasantWorkerWageAccount,
      final String peasantWorkerWageRatio,
      final String progressPayment,
      final String materialInspection,
      final String attachments,
      final String remark,
      final Long initDataId,
      final Boolean boolSupplement
   ) {
      this.id = id;
      this.registrationNo = registrationNo;
      this.contractNumber = contractNumber;
      this.registrationType = registrationType;
      this.title = title;
      this.preRegistrationId = preRegistrationId;
      this.contractCatalogueId = contractCatalogueId;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.deptId = deptId;
      this.applicationNumber = applicationNumber;
      this.applicationDate = applicationDate;
      this.projectName = projectName;
      this.signerId = signerId;
      this.signerName = signerName;
      this.firstLevelDept = firstLevelDept;
      this.secondLevelDept = secondLevelDept;
      this.contractAmount = contractAmount;
      this.taxRate = taxRate;
      this.contractType = contractType;
      this.infoSource = infoSource;
      this.projectManager = projectManager;
      this.boolCoordinate = boolCoordinate;
      this.partyA = partyA;
      this.partyB = partyB;
      this.partyC = partyC;
      this.partyD = partyD;
      this.boolBidWinningNotice = boolBidWinningNotice;
      this.drawing = drawing;
      this.boolBidProposals = boolBidProposals;
      this.boolBidDocument = boolBidDocument;
      this.contractualNature = contractualNature;
      this.biddingMethod = biddingMethod;
      this.partyType = partyType;
      this.boolFabricatedStructure = boolFabricatedStructure;
      this.boolModelContract = boolModelContract;
      this.locationId = locationId;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.structureType = structureType;
      this.structureArea = structureArea;
      this.mainStructureSteelMete = mainStructureSteelMete;
      this.subfabricSteelMete = subfabricSteelMete;
      this.maximumSpan = maximumSpan;
      this.contractStartDate = contractStartDate;
      this.contractEndDate = contractEndDate;
      this.allDays = allDays;
      this.prepaymentRatio = prepaymentRatio;
      this.warrantyRatio = warrantyRatio;
      this.boolPeasantWorkerWageAccount = boolPeasantWorkerWageAccount;
      this.peasantWorkerWageRatio = peasantWorkerWageRatio;
      this.progressPayment = progressPayment;
      this.materialInspection = materialInspection;
      this.attachments = attachments;
      this.remark = remark;
      this.initDataId = initDataId;
      this.boolSupplement = boolSupplement;
   }

   public Long getId() {
      return this.id;
   }

   public String getRegistrationNo() {
      return this.registrationNo;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public Integer getRegistrationType() {
      return this.registrationType;
   }

   public String getTitle() {
      return this.title;
   }

   public Long getPreRegistrationId() {
      return this.preRegistrationId;
   }

   public Long getContractCatalogueId() {
      return this.contractCatalogueId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getApplicationNumber() {
      return this.applicationNumber;
   }

   public LocalDateTime getApplicationDate() {
      return this.applicationDate;
   }

   public String getProjectName() {
      return this.projectName;
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

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getContractType() {
      return this.contractType;
   }

   public Integer getInfoSource() {
      return this.infoSource;
   }

   public String getProjectManager() {
      return this.projectManager;
   }

   public Boolean getBoolCoordinate() {
      return this.boolCoordinate;
   }

   public String getPartyA() {
      return this.partyA;
   }

   public String getPartyB() {
      return this.partyB;
   }

   public String getPartyC() {
      return this.partyC;
   }

   public String getPartyD() {
      return this.partyD;
   }

   public Boolean getBoolBidWinningNotice() {
      return this.boolBidWinningNotice;
   }

   public Integer getDrawing() {
      return this.drawing;
   }

   public Boolean getBoolBidProposals() {
      return this.boolBidProposals;
   }

   public Boolean getBoolBidDocument() {
      return this.boolBidDocument;
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

   public Integer getLocationId() {
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

   public LocalDateTime getContractStartDate() {
      return this.contractStartDate;
   }

   public LocalDateTime getContractEndDate() {
      return this.contractEndDate;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public String getPrepaymentRatio() {
      return this.prepaymentRatio;
   }

   public String getWarrantyRatio() {
      return this.warrantyRatio;
   }

   public Boolean getBoolPeasantWorkerWageAccount() {
      return this.boolPeasantWorkerWageAccount;
   }

   public String getPeasantWorkerWageRatio() {
      return this.peasantWorkerWageRatio;
   }

   public String getProgressPayment() {
      return this.progressPayment;
   }

   public String getMaterialInspection() {
      return this.materialInspection;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getInitDataId() {
      return this.initDataId;
   }

   public Boolean getBoolSupplement() {
      return this.boolSupplement;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRegistrationNo(final String registrationNo) {
      this.registrationNo = registrationNo;
   }

   public void setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
   }

   public void setRegistrationType(final Integer registrationType) {
      this.registrationType = registrationType;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setPreRegistrationId(final Long preRegistrationId) {
      this.preRegistrationId = preRegistrationId;
   }

   public void setContractCatalogueId(final Long contractCatalogueId) {
      this.contractCatalogueId = contractCatalogueId;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setApplicationNumber(final String applicationNumber) {
      this.applicationNumber = applicationNumber;
   }

   public void setApplicationDate(final LocalDateTime applicationDate) {
      this.applicationDate = applicationDate;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
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

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setContractType(final Long contractType) {
      this.contractType = contractType;
   }

   public void setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
   }

   public void setProjectManager(final String projectManager) {
      this.projectManager = projectManager;
   }

   public void setBoolCoordinate(final Boolean boolCoordinate) {
      this.boolCoordinate = boolCoordinate;
   }

   public void setPartyA(final String partyA) {
      this.partyA = partyA;
   }

   public void setPartyB(final String partyB) {
      this.partyB = partyB;
   }

   public void setPartyC(final String partyC) {
      this.partyC = partyC;
   }

   public void setPartyD(final String partyD) {
      this.partyD = partyD;
   }

   public void setBoolBidWinningNotice(final Boolean boolBidWinningNotice) {
      this.boolBidWinningNotice = boolBidWinningNotice;
   }

   public void setDrawing(final Integer drawing) {
      this.drawing = drawing;
   }

   public void setBoolBidProposals(final Boolean boolBidProposals) {
      this.boolBidProposals = boolBidProposals;
   }

   public void setBoolBidDocument(final Boolean boolBidDocument) {
      this.boolBidDocument = boolBidDocument;
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

   public void setLocationId(final Integer locationId) {
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

   public void setContractStartDate(final LocalDateTime contractStartDate) {
      this.contractStartDate = contractStartDate;
   }

   public void setContractEndDate(final LocalDateTime contractEndDate) {
      this.contractEndDate = contractEndDate;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setPrepaymentRatio(final String prepaymentRatio) {
      this.prepaymentRatio = prepaymentRatio;
   }

   public void setWarrantyRatio(final String warrantyRatio) {
      this.warrantyRatio = warrantyRatio;
   }

   public void setBoolPeasantWorkerWageAccount(final Boolean boolPeasantWorkerWageAccount) {
      this.boolPeasantWorkerWageAccount = boolPeasantWorkerWageAccount;
   }

   public void setPeasantWorkerWageRatio(final String peasantWorkerWageRatio) {
      this.peasantWorkerWageRatio = peasantWorkerWageRatio;
   }

   public void setProgressPayment(final String progressPayment) {
      this.progressPayment = progressPayment;
   }

   public void setMaterialInspection(final String materialInspection) {
      this.materialInspection = materialInspection;
   }

   public void setAttachments(final String attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setInitDataId(final Long initDataId) {
      this.initDataId = initDataId;
   }

   public void setBoolSupplement(final Boolean boolSupplement) {
      this.boolSupplement = boolSupplement;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractRegistrationDTOParam)) {
         return false;
      }

      ContractRegistrationDTOParam other = (ContractRegistrationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$registrationType = this.getRegistrationType();
         Object other$registrationType = other.getRegistrationType();
         if (this$registrationType == null ? other$registrationType == null : this$registrationType.equals(other$registrationType)) {
            Object this$preRegistrationId = this.getPreRegistrationId();
            Object other$preRegistrationId = other.getPreRegistrationId();
            if (this$preRegistrationId == null ? other$preRegistrationId == null : this$preRegistrationId.equals(other$preRegistrationId)) {
               Object this$contractCatalogueId = this.getContractCatalogueId();
               Object other$contractCatalogueId = other.getContractCatalogueId();
               if (this$contractCatalogueId == null ? other$contractCatalogueId == null : this$contractCatalogueId.equals(other$contractCatalogueId)) {
                  Object this$applicantId = this.getApplicantId();
                  Object other$applicantId = other.getApplicantId();
                  if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                     Object this$deptId = this.getDeptId();
                     Object other$deptId = other.getDeptId();
                     if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                        Object this$signerId = this.getSignerId();
                        Object other$signerId = other.getSignerId();
                        if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                           Object this$firstLevelDept = this.getFirstLevelDept();
                           Object other$firstLevelDept = other.getFirstLevelDept();
                           if (this$firstLevelDept == null ? other$firstLevelDept == null : this$firstLevelDept.equals(other$firstLevelDept)) {
                              Object this$secondLevelDept = this.getSecondLevelDept();
                              Object other$secondLevelDept = other.getSecondLevelDept();
                              if (this$secondLevelDept == null ? other$secondLevelDept == null : this$secondLevelDept.equals(other$secondLevelDept)) {
                                 Object this$contractType = this.getContractType();
                                 Object other$contractType = other.getContractType();
                                 if (this$contractType == null ? other$contractType == null : this$contractType.equals(other$contractType)) {
                                    Object this$infoSource = this.getInfoSource();
                                    Object other$infoSource = other.getInfoSource();
                                    if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                       Object this$boolCoordinate = this.getBoolCoordinate();
                                       Object other$boolCoordinate = other.getBoolCoordinate();
                                       if (this$boolCoordinate == null ? other$boolCoordinate == null : this$boolCoordinate.equals(other$boolCoordinate)) {
                                          Object this$boolBidWinningNotice = this.getBoolBidWinningNotice();
                                          Object other$boolBidWinningNotice = other.getBoolBidWinningNotice();
                                          if (this$boolBidWinningNotice == null
                                             ? other$boolBidWinningNotice == null
                                             : this$boolBidWinningNotice.equals(other$boolBidWinningNotice)) {
                                             Object this$drawing = this.getDrawing();
                                             Object other$drawing = other.getDrawing();
                                             if (this$drawing == null ? other$drawing == null : this$drawing.equals(other$drawing)) {
                                                Object this$boolBidProposals = this.getBoolBidProposals();
                                                Object other$boolBidProposals = other.getBoolBidProposals();
                                                if (this$boolBidProposals == null
                                                   ? other$boolBidProposals == null
                                                   : this$boolBidProposals.equals(other$boolBidProposals)) {
                                                   Object this$boolBidDocument = this.getBoolBidDocument();
                                                   Object other$boolBidDocument = other.getBoolBidDocument();
                                                   if (this$boolBidDocument == null
                                                      ? other$boolBidDocument == null
                                                      : this$boolBidDocument.equals(other$boolBidDocument)) {
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
                                                                     Object this$locationId = this.getLocationId();
                                                                     Object other$locationId = other.getLocationId();
                                                                     if (this$locationId == null
                                                                        ? other$locationId == null
                                                                        : this$locationId.equals(other$locationId)) {
                                                                        Object this$countryId = this.getCountryId();
                                                                        Object other$countryId = other.getCountryId();
                                                                        if (this$countryId == null
                                                                           ? other$countryId == null
                                                                           : this$countryId.equals(other$countryId)) {
                                                                           Object this$provinceId = this.getProvinceId();
                                                                           Object other$provinceId = other.getProvinceId();
                                                                           if (this$provinceId == null
                                                                              ? other$provinceId == null
                                                                              : this$provinceId.equals(other$provinceId)) {
                                                                              Object this$cityId = this.getCityId();
                                                                              Object other$cityId = other.getCityId();
                                                                              if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)
                                                                                 )
                                                                               {
                                                                                 Object this$regionId = this.getRegionId();
                                                                                 Object other$regionId = other.getRegionId();
                                                                                 if (this$regionId == null
                                                                                    ? other$regionId == null
                                                                                    : this$regionId.equals(other$regionId)) {
                                                                                    Object this$structureType = this.getStructureType();
                                                                                    Object other$structureType = other.getStructureType();
                                                                                    if (this$structureType == null
                                                                                       ? other$structureType == null
                                                                                       : this$structureType.equals(other$structureType)) {
                                                                                       Object this$allDays = this.getAllDays();
                                                                                       Object other$allDays = other.getAllDays();
                                                                                       if (this$allDays == null
                                                                                          ? other$allDays == null
                                                                                          : this$allDays.equals(other$allDays)) {
                                                                                          Object this$boolPeasantWorkerWageAccount = this.getBoolPeasantWorkerWageAccount();
                                                                                          Object other$boolPeasantWorkerWageAccount = other.getBoolPeasantWorkerWageAccount();
                                                                                          if (this$boolPeasantWorkerWageAccount == null
                                                                                             ? other$boolPeasantWorkerWageAccount == null
                                                                                             : this$boolPeasantWorkerWageAccount.equals(
                                                                                                other$boolPeasantWorkerWageAccount
                                                                                             )) {
                                                                                             Object this$initDataId = this.getInitDataId();
                                                                                             Object other$initDataId = other.getInitDataId();
                                                                                             if (this$initDataId == null
                                                                                                ? other$initDataId == null
                                                                                                : this$initDataId.equals(other$initDataId)) {
                                                                                                Object this$boolSupplement = this.getBoolSupplement();
                                                                                                Object other$boolSupplement = other.getBoolSupplement();
                                                                                                if (this$boolSupplement == null
                                                                                                   ? other$boolSupplement == null
                                                                                                   : this$boolSupplement.equals(other$boolSupplement)) {
                                                                                                   Object this$registrationNo = this.getRegistrationNo();
                                                                                                   Object other$registrationNo = other.getRegistrationNo();
                                                                                                   if (this$registrationNo == null
                                                                                                      ? other$registrationNo == null
                                                                                                      : this$registrationNo.equals(other$registrationNo)) {
                                                                                                      Object this$contractNumber = this.getContractNumber();
                                                                                                      Object other$contractNumber = other.getContractNumber();
                                                                                                      if (this$contractNumber == null
                                                                                                         ? other$contractNumber == null
                                                                                                         : this$contractNumber.equals(other$contractNumber)) {
                                                                                                         Object this$title = this.getTitle();
                                                                                                         Object other$title = other.getTitle();
                                                                                                         if (this$title == null
                                                                                                            ? other$title == null
                                                                                                            : this$title.equals(other$title)) {
                                                                                                            Object this$applicantName = this.getApplicantName();
                                                                                                            Object other$applicantName = other.getApplicantName();
                                                                                                            if (this$applicantName == null
                                                                                                               ? other$applicantName == null
                                                                                                               : this$applicantName.equals(other$applicantName)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$applicationNumber = this.getApplicationNumber();
                                                                                                               Object other$applicationNumber = other.getApplicationNumber();
                                                                                                               if (this$applicationNumber == null
                                                                                                                  ? other$applicationNumber == null
                                                                                                                  : this$applicationNumber.equals(
                                                                                                                     other$applicationNumber
                                                                                                                  )) {
                                                                                                                  Object this$applicationDate = this.getApplicationDate();
                                                                                                                  Object other$applicationDate = other.getApplicationDate();
                                                                                                                  if (this$applicationDate == null
                                                                                                                     ? other$applicationDate == null
                                                                                                                     : this$applicationDate.equals(
                                                                                                                        other$applicationDate
                                                                                                                     )) {
                                                                                                                     Object this$projectName = this.getProjectName();
                                                                                                                     Object other$projectName = other.getProjectName();
                                                                                                                     if (this$projectName == null
                                                                                                                        ? other$projectName == null
                                                                                                                        : this$projectName.equals(
                                                                                                                           other$projectName
                                                                                                                        )) {
                                                                                                                        Object this$signerName = this.getSignerName();
                                                                                                                        Object other$signerName = other.getSignerName();
                                                                                                                        if (this$signerName == null
                                                                                                                           ? other$signerName == null
                                                                                                                           : this$signerName.equals(
                                                                                                                              other$signerName
                                                                                                                           )) {
                                                                                                                           Object this$contractAmount = this.getContractAmount();
                                                                                                                           Object other$contractAmount = other.getContractAmount();
                                                                                                                           if (this$contractAmount == null
                                                                                                                              ? other$contractAmount == null
                                                                                                                              : this$contractAmount.equals(
                                                                                                                                 other$contractAmount
                                                                                                                              )) {
                                                                                                                              Object this$taxRate = this.getTaxRate();
                                                                                                                              Object other$taxRate = other.getTaxRate();
                                                                                                                              if (this$taxRate == null
                                                                                                                                 ? other$taxRate == null
                                                                                                                                 : this$taxRate.equals(
                                                                                                                                    other$taxRate
                                                                                                                                 )) {
                                                                                                                                 Object this$projectManager = this.getProjectManager();
                                                                                                                                 Object other$projectManager = other.getProjectManager();
                                                                                                                                 if (this$projectManager
                                                                                                                                       == null
                                                                                                                                    ? other$projectManager
                                                                                                                                       == null
                                                                                                                                    : this$projectManager.equals(
                                                                                                                                       other$projectManager
                                                                                                                                    )) {
                                                                                                                                    Object this$partyA = this.getPartyA();
                                                                                                                                    Object other$partyA = other.getPartyA();
                                                                                                                                    if (this$partyA == null
                                                                                                                                       ? other$partyA == null
                                                                                                                                       : this$partyA.equals(
                                                                                                                                          other$partyA
                                                                                                                                       )) {
                                                                                                                                       Object this$partyB = this.getPartyB();
                                                                                                                                       Object other$partyB = other.getPartyB();
                                                                                                                                       if (this$partyB == null
                                                                                                                                          ? other$partyB
                                                                                                                                             == null
                                                                                                                                          : this$partyB.equals(
                                                                                                                                             other$partyB
                                                                                                                                          )) {
                                                                                                                                          Object this$partyC = this.getPartyC();
                                                                                                                                          Object other$partyC = other.getPartyC();
                                                                                                                                          if (this$partyC
                                                                                                                                                == null
                                                                                                                                             ? other$partyC
                                                                                                                                                == null
                                                                                                                                             : this$partyC.equals(
                                                                                                                                                other$partyC
                                                                                                                                             )) {
                                                                                                                                             Object this$partyD = this.getPartyD();
                                                                                                                                             Object other$partyD = other.getPartyD();
                                                                                                                                             if (this$partyD
                                                                                                                                                   == null
                                                                                                                                                ? other$partyD
                                                                                                                                                   == null
                                                                                                                                                : this$partyD.equals(
                                                                                                                                                   other$partyD
                                                                                                                                                )) {
                                                                                                                                                Object this$structureArea = this.getStructureArea();
                                                                                                                                                Object other$structureArea = other.getStructureArea();
                                                                                                                                                if (this$structureArea
                                                                                                                                                      == null
                                                                                                                                                   ? other$structureArea
                                                                                                                                                      == null
                                                                                                                                                   : this$structureArea.equals(
                                                                                                                                                      other$structureArea
                                                                                                                                                   )) {
                                                                                                                                                   Object this$mainStructureSteelMete = this.getMainStructureSteelMete();
                                                                                                                                                   Object other$mainStructureSteelMete = other.getMainStructureSteelMete();
                                                                                                                                                   if (this$mainStructureSteelMete
                                                                                                                                                         == null
                                                                                                                                                      ? other$mainStructureSteelMete
                                                                                                                                                         == null
                                                                                                                                                      : this$mainStructureSteelMete.equals(
                                                                                                                                                         other$mainStructureSteelMete
                                                                                                                                                      )) {
                                                                                                                                                      Object this$subfabricSteelMete = this.getSubfabricSteelMete();
                                                                                                                                                      Object other$subfabricSteelMete = other.getSubfabricSteelMete();
                                                                                                                                                      if (this$subfabricSteelMete
                                                                                                                                                            == null
                                                                                                                                                         ? other$subfabricSteelMete
                                                                                                                                                            == null
                                                                                                                                                         : this$subfabricSteelMete.equals(
                                                                                                                                                            other$subfabricSteelMete
                                                                                                                                                         )) {
                                                                                                                                                         Object this$maximumSpan = this.getMaximumSpan();
                                                                                                                                                         Object other$maximumSpan = other.getMaximumSpan();
                                                                                                                                                         if (this$maximumSpan
                                                                                                                                                               == null
                                                                                                                                                            ? other$maximumSpan
                                                                                                                                                               == null
                                                                                                                                                            : this$maximumSpan.equals(
                                                                                                                                                               other$maximumSpan
                                                                                                                                                            )) {
                                                                                                                                                            Object this$contractStartDate = this.getContractStartDate();
                                                                                                                                                            Object other$contractStartDate = other.getContractStartDate();
                                                                                                                                                            if (this$contractStartDate
                                                                                                                                                                  == null
                                                                                                                                                               ? other$contractStartDate
                                                                                                                                                                  == null
                                                                                                                                                               : this$contractStartDate.equals(
                                                                                                                                                                  other$contractStartDate
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$contractEndDate = this.getContractEndDate();
                                                                                                                                                               Object other$contractEndDate = other.getContractEndDate();
                                                                                                                                                               if (this$contractEndDate
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$contractEndDate
                                                                                                                                                                     == null
                                                                                                                                                                  : this$contractEndDate.equals(
                                                                                                                                                                     other$contractEndDate
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$prepaymentRatio = this.getPrepaymentRatio();
                                                                                                                                                                  Object other$prepaymentRatio = other.getPrepaymentRatio();
                                                                                                                                                                  if (this$prepaymentRatio
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$prepaymentRatio
                                                                                                                                                                        == null
                                                                                                                                                                     : this$prepaymentRatio.equals(
                                                                                                                                                                        other$prepaymentRatio
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$warrantyRatio = this.getWarrantyRatio();
                                                                                                                                                                     Object other$warrantyRatio = other.getWarrantyRatio();
                                                                                                                                                                     if (this$warrantyRatio
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$warrantyRatio
                                                                                                                                                                           == null
                                                                                                                                                                        : this$warrantyRatio.equals(
                                                                                                                                                                           other$warrantyRatio
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$peasantWorkerWageRatio = this.getPeasantWorkerWageRatio();
                                                                                                                                                                        Object other$peasantWorkerWageRatio = other.getPeasantWorkerWageRatio();
                                                                                                                                                                        if (this$peasantWorkerWageRatio
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$peasantWorkerWageRatio
                                                                                                                                                                              == null
                                                                                                                                                                           : this$peasantWorkerWageRatio.equals(
                                                                                                                                                                              other$peasantWorkerWageRatio
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$progressPayment = this.getProgressPayment();
                                                                                                                                                                           Object other$progressPayment = other.getProgressPayment();
                                                                                                                                                                           if (this$progressPayment
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$progressPayment
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$progressPayment.equals(
                                                                                                                                                                                 other$progressPayment
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$materialInspection = this.getMaterialInspection();
                                                                                                                                                                              Object other$materialInspection = other.getMaterialInspection();
                                                                                                                                                                              if (this$materialInspection
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$materialInspection
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$materialInspection.equals(
                                                                                                                                                                                    other$materialInspection
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractRegistrationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $registrationType = this.getRegistrationType();
      result = result * 59 + ($registrationType == null ? 43 : $registrationType.hashCode());
      Object $preRegistrationId = this.getPreRegistrationId();
      result = result * 59 + ($preRegistrationId == null ? 43 : $preRegistrationId.hashCode());
      Object $contractCatalogueId = this.getContractCatalogueId();
      result = result * 59 + ($contractCatalogueId == null ? 43 : $contractCatalogueId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $firstLevelDept = this.getFirstLevelDept();
      result = result * 59 + ($firstLevelDept == null ? 43 : $firstLevelDept.hashCode());
      Object $secondLevelDept = this.getSecondLevelDept();
      result = result * 59 + ($secondLevelDept == null ? 43 : $secondLevelDept.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $boolCoordinate = this.getBoolCoordinate();
      result = result * 59 + ($boolCoordinate == null ? 43 : $boolCoordinate.hashCode());
      Object $boolBidWinningNotice = this.getBoolBidWinningNotice();
      result = result * 59 + ($boolBidWinningNotice == null ? 43 : $boolBidWinningNotice.hashCode());
      Object $drawing = this.getDrawing();
      result = result * 59 + ($drawing == null ? 43 : $drawing.hashCode());
      Object $boolBidProposals = this.getBoolBidProposals();
      result = result * 59 + ($boolBidProposals == null ? 43 : $boolBidProposals.hashCode());
      Object $boolBidDocument = this.getBoolBidDocument();
      result = result * 59 + ($boolBidDocument == null ? 43 : $boolBidDocument.hashCode());
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
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $boolPeasantWorkerWageAccount = this.getBoolPeasantWorkerWageAccount();
      result = result * 59 + ($boolPeasantWorkerWageAccount == null ? 43 : $boolPeasantWorkerWageAccount.hashCode());
      Object $initDataId = this.getInitDataId();
      result = result * 59 + ($initDataId == null ? 43 : $initDataId.hashCode());
      Object $boolSupplement = this.getBoolSupplement();
      result = result * 59 + ($boolSupplement == null ? 43 : $boolSupplement.hashCode());
      Object $registrationNo = this.getRegistrationNo();
      result = result * 59 + ($registrationNo == null ? 43 : $registrationNo.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicationNumber = this.getApplicationNumber();
      result = result * 59 + ($applicationNumber == null ? 43 : $applicationNumber.hashCode());
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $partyA = this.getPartyA();
      result = result * 59 + ($partyA == null ? 43 : $partyA.hashCode());
      Object $partyB = this.getPartyB();
      result = result * 59 + ($partyB == null ? 43 : $partyB.hashCode());
      Object $partyC = this.getPartyC();
      result = result * 59 + ($partyC == null ? 43 : $partyC.hashCode());
      Object $partyD = this.getPartyD();
      result = result * 59 + ($partyD == null ? 43 : $partyD.hashCode());
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
      Object $prepaymentRatio = this.getPrepaymentRatio();
      result = result * 59 + ($prepaymentRatio == null ? 43 : $prepaymentRatio.hashCode());
      Object $warrantyRatio = this.getWarrantyRatio();
      result = result * 59 + ($warrantyRatio == null ? 43 : $warrantyRatio.hashCode());
      Object $peasantWorkerWageRatio = this.getPeasantWorkerWageRatio();
      result = result * 59 + ($peasantWorkerWageRatio == null ? 43 : $peasantWorkerWageRatio.hashCode());
      Object $progressPayment = this.getProgressPayment();
      result = result * 59 + ($progressPayment == null ? 43 : $progressPayment.hashCode());
      Object $materialInspection = this.getMaterialInspection();
      result = result * 59 + ($materialInspection == null ? 43 : $materialInspection.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractRegistrationDTOParam(id="
         + this.getId()
         + ", registrationNo="
         + this.getRegistrationNo()
         + ", contractNumber="
         + this.getContractNumber()
         + ", registrationType="
         + this.getRegistrationType()
         + ", title="
         + this.getTitle()
         + ", preRegistrationId="
         + this.getPreRegistrationId()
         + ", contractCatalogueId="
         + this.getContractCatalogueId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", deptId="
         + this.getDeptId()
         + ", applicationNumber="
         + this.getApplicationNumber()
         + ", applicationDate="
         + this.getApplicationDate()
         + ", projectName="
         + this.getProjectName()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", firstLevelDept="
         + this.getFirstLevelDept()
         + ", secondLevelDept="
         + this.getSecondLevelDept()
         + ", contractAmount="
         + this.getContractAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", contractType="
         + this.getContractType()
         + ", infoSource="
         + this.getInfoSource()
         + ", projectManager="
         + this.getProjectManager()
         + ", boolCoordinate="
         + this.getBoolCoordinate()
         + ", partyA="
         + this.getPartyA()
         + ", partyB="
         + this.getPartyB()
         + ", partyC="
         + this.getPartyC()
         + ", partyD="
         + this.getPartyD()
         + ", boolBidWinningNotice="
         + this.getBoolBidWinningNotice()
         + ", drawing="
         + this.getDrawing()
         + ", boolBidProposals="
         + this.getBoolBidProposals()
         + ", boolBidDocument="
         + this.getBoolBidDocument()
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
         + ", contractStartDate="
         + this.getContractStartDate()
         + ", contractEndDate="
         + this.getContractEndDate()
         + ", allDays="
         + this.getAllDays()
         + ", prepaymentRatio="
         + this.getPrepaymentRatio()
         + ", warrantyRatio="
         + this.getWarrantyRatio()
         + ", boolPeasantWorkerWageAccount="
         + this.getBoolPeasantWorkerWageAccount()
         + ", peasantWorkerWageRatio="
         + this.getPeasantWorkerWageRatio()
         + ", progressPayment="
         + this.getProgressPayment()
         + ", materialInspection="
         + this.getMaterialInspection()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", initDataId="
         + this.getInitDataId()
         + ", boolSupplement="
         + this.getBoolSupplement()
         + ")";
   }

   public static class ContractRegistrationDTOParamBuilder {
      private Long id;
      private String registrationNo;
      private String contractNumber;
      private Integer registrationType;
      private String title;
      private Long preRegistrationId;
      private Long contractCatalogueId;
      private Long applicantId;
      private String applicantName;
      private Long deptId;
      private String applicationNumber;
      private LocalDateTime applicationDate;
      private String projectName;
      private Long signerId;
      private String signerName;
      private Long firstLevelDept;
      private Long secondLevelDept;
      private BigDecimal contractAmount;
      private BigDecimal taxRate;
      private Long contractType;
      private Integer infoSource;
      private String projectManager;
      private Boolean boolCoordinate;
      private String partyA;
      private String partyB;
      private String partyC;
      private String partyD;
      private Boolean boolBidWinningNotice;
      private Integer drawing;
      private Boolean boolBidProposals;
      private Boolean boolBidDocument;
      private Long contractualNature;
      private Long biddingMethod;
      private Long partyType;
      private Boolean boolFabricatedStructure;
      private Boolean boolModelContract;
      private Integer locationId;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private Long structureType;
      private BigDecimal structureArea;
      private BigDecimal mainStructureSteelMete;
      private BigDecimal subfabricSteelMete;
      private BigDecimal maximumSpan;
      private LocalDateTime contractStartDate;
      private LocalDateTime contractEndDate;
      private Integer allDays;
      private String prepaymentRatio;
      private String warrantyRatio;
      private Boolean boolPeasantWorkerWageAccount;
      private String peasantWorkerWageRatio;
      private String progressPayment;
      private String materialInspection;
      private String attachments;
      private String remark;
      private Long initDataId;
      private Boolean boolSupplement;

      ContractRegistrationDTOParamBuilder() {
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder registrationNo(final String registrationNo) {
         this.registrationNo = registrationNo;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder registrationType(final Integer registrationType) {
         this.registrationType = registrationType;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder preRegistrationId(final Long preRegistrationId) {
         this.preRegistrationId = preRegistrationId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractCatalogueId(final Long contractCatalogueId) {
         this.contractCatalogueId = contractCatalogueId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder applicationNumber(final String applicationNumber) {
         this.applicationNumber = applicationNumber;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractType(final Long contractType) {
         this.contractType = contractType;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder projectManager(final String projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolCoordinate(final Boolean boolCoordinate) {
         this.boolCoordinate = boolCoordinate;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder partyA(final String partyA) {
         this.partyA = partyA;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder partyB(final String partyB) {
         this.partyB = partyB;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder partyC(final String partyC) {
         this.partyC = partyC;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder partyD(final String partyD) {
         this.partyD = partyD;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolBidWinningNotice(final Boolean boolBidWinningNotice) {
         this.boolBidWinningNotice = boolBidWinningNotice;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder drawing(final Integer drawing) {
         this.drawing = drawing;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolBidProposals(final Boolean boolBidProposals) {
         this.boolBidProposals = boolBidProposals;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolBidDocument(final Boolean boolBidDocument) {
         this.boolBidDocument = boolBidDocument;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder biddingMethod(final Long biddingMethod) {
         this.biddingMethod = biddingMethod;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolFabricatedStructure(final Boolean boolFabricatedStructure) {
         this.boolFabricatedStructure = boolFabricatedStructure;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolModelContract(final Boolean boolModelContract) {
         this.boolModelContract = boolModelContract;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder locationId(final Integer locationId) {
         this.locationId = locationId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder mainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
         this.mainStructureSteelMete = mainStructureSteelMete;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder subfabricSteelMete(final BigDecimal subfabricSteelMete) {
         this.subfabricSteelMete = subfabricSteelMete;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder maximumSpan(final BigDecimal maximumSpan) {
         this.maximumSpan = maximumSpan;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractStartDate(final LocalDateTime contractStartDate) {
         this.contractStartDate = contractStartDate;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder contractEndDate(final LocalDateTime contractEndDate) {
         this.contractEndDate = contractEndDate;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder prepaymentRatio(final String prepaymentRatio) {
         this.prepaymentRatio = prepaymentRatio;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder warrantyRatio(final String warrantyRatio) {
         this.warrantyRatio = warrantyRatio;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolPeasantWorkerWageAccount(final Boolean boolPeasantWorkerWageAccount) {
         this.boolPeasantWorkerWageAccount = boolPeasantWorkerWageAccount;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder peasantWorkerWageRatio(final String peasantWorkerWageRatio) {
         this.peasantWorkerWageRatio = peasantWorkerWageRatio;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder progressPayment(final String progressPayment) {
         this.progressPayment = progressPayment;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder materialInspection(final String materialInspection) {
         this.materialInspection = materialInspection;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      public ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder boolSupplement(final Boolean boolSupplement) {
         this.boolSupplement = boolSupplement;
         return this;
      }

      public ContractRegistrationDTOParam build() {
         return new ContractRegistrationDTOParam(
            this.id,
            this.registrationNo,
            this.contractNumber,
            this.registrationType,
            this.title,
            this.preRegistrationId,
            this.contractCatalogueId,
            this.applicantId,
            this.applicantName,
            this.deptId,
            this.applicationNumber,
            this.applicationDate,
            this.projectName,
            this.signerId,
            this.signerName,
            this.firstLevelDept,
            this.secondLevelDept,
            this.contractAmount,
            this.taxRate,
            this.contractType,
            this.infoSource,
            this.projectManager,
            this.boolCoordinate,
            this.partyA,
            this.partyB,
            this.partyC,
            this.partyD,
            this.boolBidWinningNotice,
            this.drawing,
            this.boolBidProposals,
            this.boolBidDocument,
            this.contractualNature,
            this.biddingMethod,
            this.partyType,
            this.boolFabricatedStructure,
            this.boolModelContract,
            this.locationId,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.structureType,
            this.structureArea,
            this.mainStructureSteelMete,
            this.subfabricSteelMete,
            this.maximumSpan,
            this.contractStartDate,
            this.contractEndDate,
            this.allDays,
            this.prepaymentRatio,
            this.warrantyRatio,
            this.boolPeasantWorkerWageAccount,
            this.peasantWorkerWageRatio,
            this.progressPayment,
            this.materialInspection,
            this.attachments,
            this.remark,
            this.initDataId,
            this.boolSupplement
         );
      }

      @Override
      public String toString() {
         return "ContractRegistrationDTOParam.ContractRegistrationDTOParamBuilder(id="
            + this.id
            + ", registrationNo="
            + this.registrationNo
            + ", contractNumber="
            + this.contractNumber
            + ", registrationType="
            + this.registrationType
            + ", title="
            + this.title
            + ", preRegistrationId="
            + this.preRegistrationId
            + ", contractCatalogueId="
            + this.contractCatalogueId
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", deptId="
            + this.deptId
            + ", applicationNumber="
            + this.applicationNumber
            + ", applicationDate="
            + this.applicationDate
            + ", projectName="
            + this.projectName
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", firstLevelDept="
            + this.firstLevelDept
            + ", secondLevelDept="
            + this.secondLevelDept
            + ", contractAmount="
            + this.contractAmount
            + ", taxRate="
            + this.taxRate
            + ", contractType="
            + this.contractType
            + ", infoSource="
            + this.infoSource
            + ", projectManager="
            + this.projectManager
            + ", boolCoordinate="
            + this.boolCoordinate
            + ", partyA="
            + this.partyA
            + ", partyB="
            + this.partyB
            + ", partyC="
            + this.partyC
            + ", partyD="
            + this.partyD
            + ", boolBidWinningNotice="
            + this.boolBidWinningNotice
            + ", drawing="
            + this.drawing
            + ", boolBidProposals="
            + this.boolBidProposals
            + ", boolBidDocument="
            + this.boolBidDocument
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
            + ", contractStartDate="
            + this.contractStartDate
            + ", contractEndDate="
            + this.contractEndDate
            + ", allDays="
            + this.allDays
            + ", prepaymentRatio="
            + this.prepaymentRatio
            + ", warrantyRatio="
            + this.warrantyRatio
            + ", boolPeasantWorkerWageAccount="
            + this.boolPeasantWorkerWageAccount
            + ", peasantWorkerWageRatio="
            + this.peasantWorkerWageRatio
            + ", progressPayment="
            + this.progressPayment
            + ", materialInspection="
            + this.materialInspection
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", initDataId="
            + this.initDataId
            + ", boolSupplement="
            + this.boolSupplement
            + ")";
      }
   }
}
