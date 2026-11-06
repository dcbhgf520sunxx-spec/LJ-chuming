package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ContractRegistrationDTO {
   private Long id;
   @ApiModelProperty(name = "registrationNo", value = "合同登记编号")
   private String registrationNo;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号")
   private String contractNumber;
   @ApiModelProperty(name = "registrationType", value = "登记类型 1评审登记 2直接登记")
   private Integer registrationType;
   @ApiModelProperty(name = "title", value = "标题")
   private String title;
   @ApiModelProperty(name = "boolBindingPreRegistration", value = "是否绑定合同预登记")
   private Boolean boolBindingPreRegistration;
   @ApiModelProperty(name = "preRegistrationId", value = "预登记ID")
   private Long preRegistrationId;
   @ApiModelProperty(name = "preRegistration", value = "预登记信息")
   private IdAndNameDTO preRegistration;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "applicantDeptId", value = "申请人部门Id")
   private Long applicantDeptId;
   @ApiModelProperty(name = "applicantDeptName", value = "申请人部门")
   private String applicantDeptName;
   @ApiModelProperty(name = "applicationNumber", value = "申请编号")
   private String applicationNumber;
   @ApiModelProperty(name = "applicationDate", value = "申请时间")
   private LocalDateTime applicationDate;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
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
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "taxRate", value = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "contractType", value = "合同类型")
   private Long contractType;
   @ApiModelProperty(name = "contractTypeValue", value = "合同类型值")
   private String contractTypeValue;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Integer infoSource;
   @ApiModelProperty(name = "projectManager", value = "项目经理")
   private String projectManager;
   @ApiModelProperty(name = "boolCoordinate", value = "销售员是否配合")
   private Boolean boolCoordinate;
   @ApiModelProperty(name = "partyA", value = "甲方")
   private String partyA;
   @ApiModelProperty(name = "partyB", value = "乙方")
   private String partyB;
   @ApiModelProperty(name = "partyC", value = "丙方")
   private String partyC;
   @ApiModelProperty(name = "partyD", value = "丁方")
   private String partyD;
   @ApiModelProperty(name = "boolBidWinningNotice", value = "是否存在中标通知书")
   private Boolean boolBidWinningNotice;
   @ApiModelProperty(name = "drawing", value = "图纸 1有、2无、3电子版")
   private Integer drawing;
   @ApiModelProperty(name = "boolBidProposals", value = "是否有报价书")
   private Boolean boolBidProposals;
   @ApiModelProperty(name = "boolBidDocument", value = "是否有招标文件")
   private Boolean boolBidDocument;
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
   @ApiModelProperty(name = "boolFabricatedStructure", value = "是否装配式建筑")
   private Boolean boolFabricatedStructure;
   @ApiModelProperty(name = "boolModelContract", value = "是否示范合同")
   private Boolean boolModelContract;
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
   @ApiModelProperty(name = "contractStartDate", value = "开工时间")
   private LocalDateTime contractStartDate;
   @ApiModelProperty(name = "contractEndDate", value = "竣工时间")
   private LocalDateTime contractEndDate;
   @ApiModelProperty(name = "allDays", value = "总工期（天）")
   private Integer allDays;
   @ApiModelProperty(name = "prepaymentRatio", value = "预付款比例")
   private String prepaymentRatio;
   @ApiModelProperty(name = "warrantyRatio", value = "质保金比例")
   private String warrantyRatio;
   @ApiModelProperty(name = "boolPeasantWorkerWageAccount", value = "是否有农民工工资专户")
   private Boolean boolPeasantWorkerWageAccount;
   @ApiModelProperty(name = "peasantWorkerWageRatio", value = "农民工工资比例")
   private String peasantWorkerWageRatio;
   @ApiModelProperty(name = "progressPayment", value = "进度款")
   private String progressPayment;
   @ApiModelProperty(name = "materialInspection", value = "材料调差")
   private String materialInspection;
   @ApiModelProperty(name = "reviewStatus", value = "审批状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewPassTime", value = "审批通过时间")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "attachments", value = "合同附件ID集")
   private String attachments;
   @ApiModelProperty(name = "attachmentList", value = "合同附件")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "initDataId", value = "初始数据ID")
   private Long initDataId;
   @ApiModelProperty(name = "boolSupplement", value = "是否增补合同")
   private Boolean boolSupplement;
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

   ContractRegistrationDTO(
      final Long id,
      final String registrationNo,
      final String contractNumber,
      final Integer registrationType,
      final String title,
      final Boolean boolBindingPreRegistration,
      final Long preRegistrationId,
      final IdAndNameDTO preRegistration,
      final Long applicantId,
      final String applicantName,
      final Long applicantDeptId,
      final String applicantDeptName,
      final String applicationNumber,
      final LocalDateTime applicationDate,
      final String projectName,
      final Long signerId,
      final String signerName,
      final Long firstLevelDept,
      final String firstLevelDeptValue,
      final Long secondLevelDept,
      final String secondLevelDeptValue,
      final BigDecimal contractAmount,
      final BigDecimal taxRate,
      final Long contractType,
      final String contractTypeValue,
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
      final String contractualNatureValue,
      final Long biddingMethod,
      final String biddingMethodValue,
      final Long partyType,
      final String partyTypeValue,
      final Boolean boolFabricatedStructure,
      final Boolean boolModelContract,
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
      final Long structureType,
      final String structureTypeValue,
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
      final Integer reviewStatus,
      final LocalDateTime reviewPassTime,
      final String attachments,
      final List<AttachmentDTO> attachmentList,
      final String remark,
      final Long initDataId,
      final Boolean boolSupplement,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO
   ) {
      this.id = id;
      this.registrationNo = registrationNo;
      this.contractNumber = contractNumber;
      this.registrationType = registrationType;
      this.title = title;
      this.boolBindingPreRegistration = boolBindingPreRegistration;
      this.preRegistrationId = preRegistrationId;
      this.preRegistration = preRegistration;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.applicantDeptId = applicantDeptId;
      this.applicantDeptName = applicantDeptName;
      this.applicationNumber = applicationNumber;
      this.applicationDate = applicationDate;
      this.projectName = projectName;
      this.signerId = signerId;
      this.signerName = signerName;
      this.firstLevelDept = firstLevelDept;
      this.firstLevelDeptValue = firstLevelDeptValue;
      this.secondLevelDept = secondLevelDept;
      this.secondLevelDeptValue = secondLevelDeptValue;
      this.contractAmount = contractAmount;
      this.taxRate = taxRate;
      this.contractType = contractType;
      this.contractTypeValue = contractTypeValue;
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
      this.contractualNatureValue = contractualNatureValue;
      this.biddingMethod = biddingMethod;
      this.biddingMethodValue = biddingMethodValue;
      this.partyType = partyType;
      this.partyTypeValue = partyTypeValue;
      this.boolFabricatedStructure = boolFabricatedStructure;
      this.boolModelContract = boolModelContract;
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
      this.structureType = structureType;
      this.structureTypeValue = structureTypeValue;
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
      this.reviewStatus = reviewStatus;
      this.reviewPassTime = reviewPassTime;
      this.attachments = attachments;
      this.attachmentList = attachmentList;
      this.remark = remark;
      this.initDataId = initDataId;
      this.boolSupplement = boolSupplement;
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public static ContractRegistrationDTO.ContractRegistrationDTOBuilder builder() {
      return new ContractRegistrationDTO.ContractRegistrationDTOBuilder();
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

   public Boolean getBoolBindingPreRegistration() {
      return this.boolBindingPreRegistration;
   }

   public Long getPreRegistrationId() {
      return this.preRegistrationId;
   }

   public IdAndNameDTO getPreRegistration() {
      return this.preRegistration;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApplicantDeptId() {
      return this.applicantDeptId;
   }

   public String getApplicantDeptName() {
      return this.applicantDeptName;
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

   public String getFirstLevelDeptValue() {
      return this.firstLevelDeptValue;
   }

   public Long getSecondLevelDept() {
      return this.secondLevelDept;
   }

   public String getSecondLevelDeptValue() {
      return this.secondLevelDeptValue;
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

   public String getContractTypeValue() {
      return this.contractTypeValue;
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

   public Boolean getBoolFabricatedStructure() {
      return this.boolFabricatedStructure;
   }

   public Boolean getBoolModelContract() {
      return this.boolModelContract;
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

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
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

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
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

   public void setBoolBindingPreRegistration(final Boolean boolBindingPreRegistration) {
      this.boolBindingPreRegistration = boolBindingPreRegistration;
   }

   public void setPreRegistrationId(final Long preRegistrationId) {
      this.preRegistrationId = preRegistrationId;
   }

   public void setPreRegistration(final IdAndNameDTO preRegistration) {
      this.preRegistration = preRegistration;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicantDeptId(final Long applicantDeptId) {
      this.applicantDeptId = applicantDeptId;
   }

   public void setApplicantDeptName(final String applicantDeptName) {
      this.applicantDeptName = applicantDeptName;
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

   public void setFirstLevelDeptValue(final String firstLevelDeptValue) {
      this.firstLevelDeptValue = firstLevelDeptValue;
   }

   public void setSecondLevelDept(final Long secondLevelDept) {
      this.secondLevelDept = secondLevelDept;
   }

   public void setSecondLevelDeptValue(final String secondLevelDeptValue) {
      this.secondLevelDeptValue = secondLevelDeptValue;
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

   public void setContractTypeValue(final String contractTypeValue) {
      this.contractTypeValue = contractTypeValue;
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

   public void setBoolFabricatedStructure(final Boolean boolFabricatedStructure) {
      this.boolFabricatedStructure = boolFabricatedStructure;
   }

   public void setBoolModelContract(final Boolean boolModelContract) {
      this.boolModelContract = boolModelContract;
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

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setAttachments(final String attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
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

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractRegistrationDTO)) {
         return false;
      }

      ContractRegistrationDTO other = (ContractRegistrationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$registrationType = this.getRegistrationType();
         Object other$registrationType = other.getRegistrationType();
         if (this$registrationType == null ? other$registrationType == null : this$registrationType.equals(other$registrationType)) {
            Object this$boolBindingPreRegistration = this.getBoolBindingPreRegistration();
            Object other$boolBindingPreRegistration = other.getBoolBindingPreRegistration();
            if (this$boolBindingPreRegistration == null
               ? other$boolBindingPreRegistration == null
               : this$boolBindingPreRegistration.equals(other$boolBindingPreRegistration)) {
               Object this$preRegistrationId = this.getPreRegistrationId();
               Object other$preRegistrationId = other.getPreRegistrationId();
               if (this$preRegistrationId == null ? other$preRegistrationId == null : this$preRegistrationId.equals(other$preRegistrationId)) {
                  Object this$applicantId = this.getApplicantId();
                  Object other$applicantId = other.getApplicantId();
                  if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                     Object this$applicantDeptId = this.getApplicantDeptId();
                     Object other$applicantDeptId = other.getApplicantDeptId();
                     if (this$applicantDeptId == null ? other$applicantDeptId == null : this$applicantDeptId.equals(other$applicantDeptId)) {
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
                                                                                             Object this$reviewStatus = this.getReviewStatus();
                                                                                             Object other$reviewStatus = other.getReviewStatus();
                                                                                             if (this$reviewStatus == null
                                                                                                ? other$reviewStatus == null
                                                                                                : this$reviewStatus.equals(other$reviewStatus)) {
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
                                                                                                               Object this$preRegistration = this.getPreRegistration();
                                                                                                               Object other$preRegistration = other.getPreRegistration();
                                                                                                               if (this$preRegistration == null
                                                                                                                  ? other$preRegistration == null
                                                                                                                  : this$preRegistration.equals(
                                                                                                                     other$preRegistration
                                                                                                                  )) {
                                                                                                                  Object this$applicantName = this.getApplicantName();
                                                                                                                  Object other$applicantName = other.getApplicantName();
                                                                                                                  if (this$applicantName == null
                                                                                                                     ? other$applicantName == null
                                                                                                                     : this$applicantName.equals(
                                                                                                                        other$applicantName
                                                                                                                     )) {
                                                                                                                     Object this$applicantDeptName = this.getApplicantDeptName();
                                                                                                                     Object other$applicantDeptName = other.getApplicantDeptName();
                                                                                                                     if (this$applicantDeptName == null
                                                                                                                        ? other$applicantDeptName == null
                                                                                                                        : this$applicantDeptName.equals(
                                                                                                                           other$applicantDeptName
                                                                                                                        )) {
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
                                                                                                                                    Object this$firstLevelDeptValue = this.getFirstLevelDeptValue();
                                                                                                                                    Object other$firstLevelDeptValue = other.getFirstLevelDeptValue();
                                                                                                                                    if (this$firstLevelDeptValue
                                                                                                                                          == null
                                                                                                                                       ? other$firstLevelDeptValue
                                                                                                                                          == null
                                                                                                                                       : this$firstLevelDeptValue.equals(
                                                                                                                                          other$firstLevelDeptValue
                                                                                                                                       )) {
                                                                                                                                       Object this$secondLevelDeptValue = this.getSecondLevelDeptValue();
                                                                                                                                       Object other$secondLevelDeptValue = other.getSecondLevelDeptValue();
                                                                                                                                       if (this$secondLevelDeptValue
                                                                                                                                             == null
                                                                                                                                          ? other$secondLevelDeptValue
                                                                                                                                             == null
                                                                                                                                          : this$secondLevelDeptValue.equals(
                                                                                                                                             other$secondLevelDeptValue
                                                                                                                                          )) {
                                                                                                                                          Object this$contractAmount = this.getContractAmount();
                                                                                                                                          Object other$contractAmount = other.getContractAmount();
                                                                                                                                          if (this$contractAmount
                                                                                                                                                == null
                                                                                                                                             ? other$contractAmount
                                                                                                                                                == null
                                                                                                                                             : this$contractAmount.equals(
                                                                                                                                                other$contractAmount
                                                                                                                                             )) {
                                                                                                                                             Object this$taxRate = this.getTaxRate();
                                                                                                                                             Object other$taxRate = other.getTaxRate();
                                                                                                                                             if (this$taxRate
                                                                                                                                                   == null
                                                                                                                                                ? other$taxRate
                                                                                                                                                   == null
                                                                                                                                                : this$taxRate.equals(
                                                                                                                                                   other$taxRate
                                                                                                                                                )) {
                                                                                                                                                Object this$contractTypeValue = this.getContractTypeValue();
                                                                                                                                                Object other$contractTypeValue = other.getContractTypeValue();
                                                                                                                                                if (this$contractTypeValue
                                                                                                                                                      == null
                                                                                                                                                   ? other$contractTypeValue
                                                                                                                                                      == null
                                                                                                                                                   : this$contractTypeValue.equals(
                                                                                                                                                      other$contractTypeValue
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
                                                                                                                                                      if (this$partyA
                                                                                                                                                            == null
                                                                                                                                                         ? other$partyA
                                                                                                                                                            == null
                                                                                                                                                         : this$partyA.equals(
                                                                                                                                                            other$partyA
                                                                                                                                                         )) {
                                                                                                                                                         Object this$partyB = this.getPartyB();
                                                                                                                                                         Object other$partyB = other.getPartyB();
                                                                                                                                                         if (this$partyB
                                                                                                                                                               == null
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
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$partyD = this.getPartyD();
                                                                                                                                                               Object other$partyD = other.getPartyD();
                                                                                                                                                               if (this$partyD
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$partyD
                                                                                                                                                                     == null
                                                                                                                                                                  : this$partyD.equals(
                                                                                                                                                                     other$partyD
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$contractualNatureValue = this.getContractualNatureValue();
                                                                                                                                                                  Object other$contractualNatureValue = other.getContractualNatureValue();
                                                                                                                                                                  if (this$contractualNatureValue
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$contractualNatureValue
                                                                                                                                                                        == null
                                                                                                                                                                     : this$contractualNatureValue.equals(
                                                                                                                                                                        other$contractualNatureValue
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$biddingMethodValue = this.getBiddingMethodValue();
                                                                                                                                                                     Object other$biddingMethodValue = other.getBiddingMethodValue();
                                                                                                                                                                     if (this$biddingMethodValue
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$biddingMethodValue
                                                                                                                                                                           == null
                                                                                                                                                                        : this$biddingMethodValue.equals(
                                                                                                                                                                           other$biddingMethodValue
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
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
                                                                                                                                                                           Object this$locationValue = this.getLocationValue();
                                                                                                                                                                           Object other$locationValue = other.getLocationValue();
                                                                                                                                                                           if (this$locationValue
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$locationValue
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$locationValue.equals(
                                                                                                                                                                                 other$locationValue
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$countryValue = this.getCountryValue();
                                                                                                                                                                              Object other$countryValue = other.getCountryValue();
                                                                                                                                                                              if (this$countryValue
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$countryValue
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$countryValue.equals(
                                                                                                                                                                                    other$countryValue
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$provinceValue = this.getProvinceValue();
                                                                                                                                                                                 Object other$provinceValue = other.getProvinceValue();
                                                                                                                                                                                 if (this$provinceValue
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$provinceValue
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$provinceValue.equals(
                                                                                                                                                                                       other$provinceValue
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$cityValue = this.getCityValue();
                                                                                                                                                                                    Object other$cityValue = other.getCityValue();
                                                                                                                                                                                    if (this$cityValue
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$cityValue
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$cityValue.equals(
                                                                                                                                                                                          other$cityValue
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$regionValue = this.getRegionValue();
                                                                                                                                                                                       Object other$regionValue = other.getRegionValue();
                                                                                                                                                                                       if (this$regionValue
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$regionValue
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$regionValue.equals(
                                                                                                                                                                                             other$regionValue
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$structureTypeValue = this.getStructureTypeValue();
                                                                                                                                                                                          Object other$structureTypeValue = other.getStructureTypeValue();
                                                                                                                                                                                          if (this$structureTypeValue
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$structureTypeValue
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$structureTypeValue.equals(
                                                                                                                                                                                                other$structureTypeValue
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$structureArea = this.getStructureArea();
                                                                                                                                                                                             Object other$structureArea = other.getStructureArea();
                                                                                                                                                                                             if (this$structureArea
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$structureArea
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$structureArea.equals(
                                                                                                                                                                                                   other$structureArea
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$mainStructureSteelMete = this.getMainStructureSteelMete();
                                                                                                                                                                                                Object other$mainStructureSteelMete = other.getMainStructureSteelMete();
                                                                                                                                                                                                if (this$mainStructureSteelMete
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$mainStructureSteelMete
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$mainStructureSteelMete.equals(
                                                                                                                                                                                                      other$mainStructureSteelMete
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$subfabricSteelMete = this.getSubfabricSteelMete();
                                                                                                                                                                                                   Object other$subfabricSteelMete = other.getSubfabricSteelMete();
                                                                                                                                                                                                   if (this$subfabricSteelMete
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$subfabricSteelMete
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$subfabricSteelMete.equals(
                                                                                                                                                                                                         other$subfabricSteelMete
                                                                                                                                                                                                      )
                                                                                                                                                                                                      )
                                                                                                                                                                                                    {
                                                                                                                                                                                                      Object this$maximumSpan = this.getMaximumSpan();
                                                                                                                                                                                                      Object other$maximumSpan = other.getMaximumSpan();
                                                                                                                                                                                                      if (this$maximumSpan
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         ? other$maximumSpan
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         : this$maximumSpan.equals(
                                                                                                                                                                                                            other$maximumSpan
                                                                                                                                                                                                         )
                                                                                                                                                                                                         )
                                                                                                                                                                                                       {
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
                                                                                                                                                                                                                              Object this$reviewPassTime = this.getReviewPassTime();
                                                                                                                                                                                                                              Object other$reviewPassTime = other.getReviewPassTime();
                                                                                                                                                                                                                              if (this$reviewPassTime
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 ? other$reviewPassTime
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 : this$reviewPassTime.equals(
                                                                                                                                                                                                                                    other$reviewPassTime
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
                                                                                                                                                                                                                                          Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                                                                                                                                                                                                                          Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                                                                                                                                                                                                                          return this$wmsApproveRecordFlowDTO
                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                             ? other$wmsApproveRecordFlowDTO
                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                             : this$wmsApproveRecordFlowDTO.equals(
                                                                                                                                                                                                                                                other$wmsApproveRecordFlowDTO
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractRegistrationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $registrationType = this.getRegistrationType();
      result = result * 59 + ($registrationType == null ? 43 : $registrationType.hashCode());
      Object $boolBindingPreRegistration = this.getBoolBindingPreRegistration();
      result = result * 59 + ($boolBindingPreRegistration == null ? 43 : $boolBindingPreRegistration.hashCode());
      Object $preRegistrationId = this.getPreRegistrationId();
      result = result * 59 + ($preRegistrationId == null ? 43 : $preRegistrationId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $applicantDeptId = this.getApplicantDeptId();
      result = result * 59 + ($applicantDeptId == null ? 43 : $applicantDeptId.hashCode());
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
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
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
      Object $preRegistration = this.getPreRegistration();
      result = result * 59 + ($preRegistration == null ? 43 : $preRegistration.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicantDeptName = this.getApplicantDeptName();
      result = result * 59 + ($applicantDeptName == null ? 43 : $applicantDeptName.hashCode());
      Object $applicationNumber = this.getApplicationNumber();
      result = result * 59 + ($applicationNumber == null ? 43 : $applicationNumber.hashCode());
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $firstLevelDeptValue = this.getFirstLevelDeptValue();
      result = result * 59 + ($firstLevelDeptValue == null ? 43 : $firstLevelDeptValue.hashCode());
      Object $secondLevelDeptValue = this.getSecondLevelDeptValue();
      result = result * 59 + ($secondLevelDeptValue == null ? 43 : $secondLevelDeptValue.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $contractTypeValue = this.getContractTypeValue();
      result = result * 59 + ($contractTypeValue == null ? 43 : $contractTypeValue.hashCode());
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
      Object $contractualNatureValue = this.getContractualNatureValue();
      result = result * 59 + ($contractualNatureValue == null ? 43 : $contractualNatureValue.hashCode());
      Object $biddingMethodValue = this.getBiddingMethodValue();
      result = result * 59 + ($biddingMethodValue == null ? 43 : $biddingMethodValue.hashCode());
      Object $partyTypeValue = this.getPartyTypeValue();
      result = result * 59 + ($partyTypeValue == null ? 43 : $partyTypeValue.hashCode());
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
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      return result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ContractRegistrationDTO(id="
         + this.getId()
         + ", registrationNo="
         + this.getRegistrationNo()
         + ", contractNumber="
         + this.getContractNumber()
         + ", registrationType="
         + this.getRegistrationType()
         + ", title="
         + this.getTitle()
         + ", boolBindingPreRegistration="
         + this.getBoolBindingPreRegistration()
         + ", preRegistrationId="
         + this.getPreRegistrationId()
         + ", preRegistration="
         + this.getPreRegistration()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantDeptId="
         + this.getApplicantDeptId()
         + ", applicantDeptName="
         + this.getApplicantDeptName()
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
         + ", firstLevelDeptValue="
         + this.getFirstLevelDeptValue()
         + ", secondLevelDept="
         + this.getSecondLevelDept()
         + ", secondLevelDeptValue="
         + this.getSecondLevelDeptValue()
         + ", contractAmount="
         + this.getContractAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", contractType="
         + this.getContractType()
         + ", contractTypeValue="
         + this.getContractTypeValue()
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
         + ", boolFabricatedStructure="
         + this.getBoolFabricatedStructure()
         + ", boolModelContract="
         + this.getBoolModelContract()
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
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", remark="
         + this.getRemark()
         + ", initDataId="
         + this.getInitDataId()
         + ", boolSupplement="
         + this.getBoolSupplement()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ")";
   }

   public static class ContractRegistrationDTOBuilder {
      private Long id;
      private String registrationNo;
      private String contractNumber;
      private Integer registrationType;
      private String title;
      private Boolean boolBindingPreRegistration;
      private Long preRegistrationId;
      private IdAndNameDTO preRegistration;
      private Long applicantId;
      private String applicantName;
      private Long applicantDeptId;
      private String applicantDeptName;
      private String applicationNumber;
      private LocalDateTime applicationDate;
      private String projectName;
      private Long signerId;
      private String signerName;
      private Long firstLevelDept;
      private String firstLevelDeptValue;
      private Long secondLevelDept;
      private String secondLevelDeptValue;
      private BigDecimal contractAmount;
      private BigDecimal taxRate;
      private Long contractType;
      private String contractTypeValue;
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
      private String contractualNatureValue;
      private Long biddingMethod;
      private String biddingMethodValue;
      private Long partyType;
      private String partyTypeValue;
      private Boolean boolFabricatedStructure;
      private Boolean boolModelContract;
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
      private Long structureType;
      private String structureTypeValue;
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
      private Integer reviewStatus;
      private LocalDateTime reviewPassTime;
      private String attachments;
      private List<AttachmentDTO> attachmentList;
      private String remark;
      private Long initDataId;
      private Boolean boolSupplement;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

      ContractRegistrationDTOBuilder() {
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder registrationNo(final String registrationNo) {
         this.registrationNo = registrationNo;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder registrationType(final Integer registrationType) {
         this.registrationType = registrationType;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolBindingPreRegistration(final Boolean boolBindingPreRegistration) {
         this.boolBindingPreRegistration = boolBindingPreRegistration;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder preRegistrationId(final Long preRegistrationId) {
         this.preRegistrationId = preRegistrationId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder preRegistration(final IdAndNameDTO preRegistration) {
         this.preRegistration = preRegistration;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder applicantDeptId(final Long applicantDeptId) {
         this.applicantDeptId = applicantDeptId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder applicantDeptName(final String applicantDeptName) {
         this.applicantDeptName = applicantDeptName;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder applicationNumber(final String applicationNumber) {
         this.applicationNumber = applicationNumber;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder firstLevelDeptValue(final String firstLevelDeptValue) {
         this.firstLevelDeptValue = firstLevelDeptValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder secondLevelDeptValue(final String secondLevelDeptValue) {
         this.secondLevelDeptValue = secondLevelDeptValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractType(final Long contractType) {
         this.contractType = contractType;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractTypeValue(final String contractTypeValue) {
         this.contractTypeValue = contractTypeValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder projectManager(final String projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolCoordinate(final Boolean boolCoordinate) {
         this.boolCoordinate = boolCoordinate;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder partyA(final String partyA) {
         this.partyA = partyA;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder partyB(final String partyB) {
         this.partyB = partyB;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder partyC(final String partyC) {
         this.partyC = partyC;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder partyD(final String partyD) {
         this.partyD = partyD;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolBidWinningNotice(final Boolean boolBidWinningNotice) {
         this.boolBidWinningNotice = boolBidWinningNotice;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder drawing(final Integer drawing) {
         this.drawing = drawing;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolBidProposals(final Boolean boolBidProposals) {
         this.boolBidProposals = boolBidProposals;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolBidDocument(final Boolean boolBidDocument) {
         this.boolBidDocument = boolBidDocument;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractualNatureValue(final String contractualNatureValue) {
         this.contractualNatureValue = contractualNatureValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder biddingMethod(final Long biddingMethod) {
         this.biddingMethod = biddingMethod;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder biddingMethodValue(final String biddingMethodValue) {
         this.biddingMethodValue = biddingMethodValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder partyTypeValue(final String partyTypeValue) {
         this.partyTypeValue = partyTypeValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolFabricatedStructure(final Boolean boolFabricatedStructure) {
         this.boolFabricatedStructure = boolFabricatedStructure;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolModelContract(final Boolean boolModelContract) {
         this.boolModelContract = boolModelContract;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder locationValue(final String locationValue) {
         this.locationValue = locationValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder countryValue(final String countryValue) {
         this.countryValue = countryValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder provinceValue(final String provinceValue) {
         this.provinceValue = provinceValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder cityValue(final String cityValue) {
         this.cityValue = cityValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder regionValue(final String regionValue) {
         this.regionValue = regionValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder structureTypeValue(final String structureTypeValue) {
         this.structureTypeValue = structureTypeValue;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder mainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
         this.mainStructureSteelMete = mainStructureSteelMete;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder subfabricSteelMete(final BigDecimal subfabricSteelMete) {
         this.subfabricSteelMete = subfabricSteelMete;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder maximumSpan(final BigDecimal maximumSpan) {
         this.maximumSpan = maximumSpan;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractStartDate(final LocalDateTime contractStartDate) {
         this.contractStartDate = contractStartDate;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder contractEndDate(final LocalDateTime contractEndDate) {
         this.contractEndDate = contractEndDate;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder prepaymentRatio(final String prepaymentRatio) {
         this.prepaymentRatio = prepaymentRatio;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder warrantyRatio(final String warrantyRatio) {
         this.warrantyRatio = warrantyRatio;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolPeasantWorkerWageAccount(final Boolean boolPeasantWorkerWageAccount) {
         this.boolPeasantWorkerWageAccount = boolPeasantWorkerWageAccount;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder peasantWorkerWageRatio(final String peasantWorkerWageRatio) {
         this.peasantWorkerWageRatio = peasantWorkerWageRatio;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder progressPayment(final String progressPayment) {
         this.progressPayment = progressPayment;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder materialInspection(final String materialInspection) {
         this.materialInspection = materialInspection;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder boolSupplement(final Boolean boolSupplement) {
         this.boolSupplement = boolSupplement;
         return this;
      }

      public ContractRegistrationDTO.ContractRegistrationDTOBuilder wmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
         this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
         return this;
      }

      public ContractRegistrationDTO build() {
         return new ContractRegistrationDTO(
            this.id,
            this.registrationNo,
            this.contractNumber,
            this.registrationType,
            this.title,
            this.boolBindingPreRegistration,
            this.preRegistrationId,
            this.preRegistration,
            this.applicantId,
            this.applicantName,
            this.applicantDeptId,
            this.applicantDeptName,
            this.applicationNumber,
            this.applicationDate,
            this.projectName,
            this.signerId,
            this.signerName,
            this.firstLevelDept,
            this.firstLevelDeptValue,
            this.secondLevelDept,
            this.secondLevelDeptValue,
            this.contractAmount,
            this.taxRate,
            this.contractType,
            this.contractTypeValue,
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
            this.contractualNatureValue,
            this.biddingMethod,
            this.biddingMethodValue,
            this.partyType,
            this.partyTypeValue,
            this.boolFabricatedStructure,
            this.boolModelContract,
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
            this.structureType,
            this.structureTypeValue,
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
            this.reviewStatus,
            this.reviewPassTime,
            this.attachments,
            this.attachmentList,
            this.remark,
            this.initDataId,
            this.boolSupplement,
            this.wmsApproveRecordFlowDTO
         );
      }

      @Override
      public String toString() {
         return "ContractRegistrationDTO.ContractRegistrationDTOBuilder(id="
            + this.id
            + ", registrationNo="
            + this.registrationNo
            + ", contractNumber="
            + this.contractNumber
            + ", registrationType="
            + this.registrationType
            + ", title="
            + this.title
            + ", boolBindingPreRegistration="
            + this.boolBindingPreRegistration
            + ", preRegistrationId="
            + this.preRegistrationId
            + ", preRegistration="
            + this.preRegistration
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", applicantDeptId="
            + this.applicantDeptId
            + ", applicantDeptName="
            + this.applicantDeptName
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
            + ", firstLevelDeptValue="
            + this.firstLevelDeptValue
            + ", secondLevelDept="
            + this.secondLevelDept
            + ", secondLevelDeptValue="
            + this.secondLevelDeptValue
            + ", contractAmount="
            + this.contractAmount
            + ", taxRate="
            + this.taxRate
            + ", contractType="
            + this.contractType
            + ", contractTypeValue="
            + this.contractTypeValue
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
            + ", boolFabricatedStructure="
            + this.boolFabricatedStructure
            + ", boolModelContract="
            + this.boolModelContract
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
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", attachments="
            + this.attachments
            + ", attachmentList="
            + this.attachmentList
            + ", remark="
            + this.remark
            + ", initDataId="
            + this.initDataId
            + ", boolSupplement="
            + this.boolSupplement
            + ", wmsApproveRecordFlowDTO="
            + this.wmsApproveRecordFlowDTO
            + ")";
      }
   }
}
