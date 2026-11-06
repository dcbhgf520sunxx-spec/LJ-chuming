package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmApplyForBidRecordDetailDTO {
   @ApiModelProperty(name = "id", value = "投标申请id", notes = "投标申请id")
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "所属部门名称", notes = "所属部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号", notes = "项目编号")
   private String projectSerialNumber;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "备案单位", notes = "备案单位")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "biddingMethodId", value = "招标方式id", notes = "招标方式id")
   private Long biddingMethodId;
   @ApiModelProperty(name = "biddingMethodName", value = "招标方式名称", notes = "招标方式名称")
   private String biddingMethodName;
   @ApiModelProperty(name = "crmBiddingRegulationsTypeEnum", value = "招标规定枚举", notes = "招标规定枚举")
   private Integer crmBiddingRegulationsTypeEnum;
   @ApiModelProperty(name = "tenderSubmissionMethodId", value = "标书提交方式", notes = "标书提交方式")
   private Long tenderSubmissionMethodId;
   @ApiModelProperty(name = "tenderSubmissionMethodName", value = "标书提交方式名称", notes = "标书提交方式名称")
   private String tenderSubmissionMethodName;
   @ApiModelProperty(name = "bidExpirationDate", value = "投标截至日期", notes = "投标截至日期")
   private LocalDateTime bidExpirationDate;
   @ApiModelProperty(name = "bidOpeningDate", value = "开标日期", notes = "开标日期")
   private LocalDateTime bidOpeningDate;
   @ApiModelProperty(name = "bidEvaluationMethodId", value = "评标方式", notes = "评标方式")
   private Long bidEvaluationMethodId;
   @ApiModelProperty(name = "bidEvaluationMethodName", value = "评标方式名称", notes = "评标方式名称")
   private String bidEvaluationMethodName;
   @ApiModelProperty(name = "isControlledBiddingPrice", value = "有无招标控制价", notes = "有无招标控制价")
   private Boolean isControlledBiddingPrice;
   @ApiModelProperty(name = "controlledBiddingPrice", value = "招标控制价", notes = "招标控制价")
   private BigDecimal controlledBiddingPrice;
   @ApiModelProperty(name = "settlementMethodId", value = "结算方式", notes = "结算方式")
   private Long settlementMethodId;
   @ApiModelProperty(name = "settlementMethodName", value = "结算方式名称", notes = "结算方式名称")
   private String settlementMethodName;
   @ApiModelProperty(name = "isTenderBond", value = "有无投标保证金", notes = "有无投标保证金")
   private Boolean isTenderBond;
   @ApiModelProperty(name = "tenderBond", value = "投标保证金(万元)", notes = "投标保证金(万元)")
   private BigDecimal tenderBond;
   @ApiModelProperty(name = "tenderBondDeadline", value = "投标保证金截止日", notes = "投标保证金截止日")
   private LocalDateTime tenderBondDeadline;
   @ApiModelProperty(name = "companyName", value = "单位名称", notes = "单位名称")
   private String companyName;
   @ApiModelProperty(name = "depositBank", value = "开户行", notes = "开户行")
   private String depositBank;
   @ApiModelProperty(name = "account", value = "银行账号", notes = "银行账号")
   private String account;
   @ApiModelProperty(name = "isCashDeposit", value = "是否履约保证金", notes = "是否履约保证金")
   private Boolean isCashDeposit;
   @ApiModelProperty(name = "cashDeposit", value = "履约保证金金额", notes = "履约保证金金额")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "typeOfPerformanceBondId", value = "履约保证金类型", notes = "履约保证金类型")
   private Long typeOfPerformanceBondId;
   @ApiModelProperty(name = "typeOfPerformanceBondName", value = "履约保证金类型名称", notes = "履约保证金类型名称")
   private String typeOfPerformanceBondName;
   @ApiModelProperty(name = "warrantyRatio", value = "保修比例", notes = "保修比例")
   private String warrantyRatio;
   @ApiModelProperty(name = "warrantyRatio", value = "保修期限", notes = "保修期限")
   private String warrantyDate;
   @ApiModelProperty(name = "startDate", value = "计划开工日期", notes = "计划开工日期")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "计划完工日期", notes = "计划完工日期")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "isMaterialAdjustment", value = "是否材料调差", notes = "是否材料调差")
   private Boolean isMaterialAdjustment;
   @ApiModelProperty(name = "materialAdjustment", value = "材料调差", notes = "材料调差")
   private String materialAdjustment;
   @ApiModelProperty(name = "materialBrandRegulations", value = "材料品牌规定", notes = "材料品牌规定")
   private String materialBrandRegulations;
   @ApiModelProperty(name = "isSpecialRulesForMaterials", value = "是否材料特殊规定", notes = "是否材料特殊规定")
   private Boolean isSpecialRulesForMaterials;
   @ApiModelProperty(name = "specialRulesForMaterials", value = "材料特殊规定", notes = "材料特殊规定")
   private String specialRulesForMaterials;
   @ApiModelProperty(name = "isOfferSample", value = "是否提供样品", notes = "是否提供样品")
   private Boolean isOfferSample;
   @ApiModelProperty(name = "offerSample", value = "样品", notes = "样品")
   private String offerSample;
   @ApiModelProperty(name = "paymentMethod", value = "付款方式", notes = "付款方式")
   private String paymentMethod;
   @ApiModelProperty(name = "biddingPlatformName", value = "招标平台名称", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "tenderRequirement", value = "标书需求 类型拼接", notes = "标书需求 类型拼接")
   private String tenderRequirement;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件id集合", notes = "附件id集合")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "businessProjectBidManagerQuote", value = "商务投标报价", notes = "商务投标报价")
   private BigDecimal businessProjectBidManagerQuote;
   @ApiModelProperty(name = "businessProjectBidManagerEstimatedWorks", value = "商务工程量", notes = "商务工程量")
   private BigDecimal businessProjectBidManagerEstimatedWorks;
   @ApiModelProperty(name = "businessProjectBidManagerCost", value = "商务成本", notes = "商务成本")
   private BigDecimal businessProjectBidManagerCost;
   @ApiModelProperty(name = "businessProjectBidManagerGrossProfit", value = "商务毛利", notes = "商务毛利")
   private BigDecimal businessProjectBidManagerGrossProfit;
   @ApiModelProperty(name = "businessProjectBidManagerRemark", value = "商务投标备注", notes = "商务投标备注")
   private String businessProjectBidManagerRemark;
   @ApiModelProperty(name = "technologyBidManagerJobDescriptionId", value = "技术投标工作内容", notes = "技术投标工作内容")
   private Long technologyBidManagerJobDescriptionId;
   @ApiModelProperty(name = "technologyBidManagerJobDescriptionName", value = "技术投标工作内容", notes = "技术投标工作内容")
   private String technologyBidManagerJobDescriptionName;
   @ApiModelProperty(name = "technologyBidManagerRenderings", value = "技术投标效果图", notes = "技术投标效果图")
   private String technologyBidManagerRenderings;
   @ApiModelProperty(name = "technologyBidManagerStructureName", value = "技术投标结构名称", notes = "技术投标结构名称")
   private String technologyBidManagerStructureName;
   @ApiModelProperty(name = "technologyBidManagerCompletion", value = "技术投标完成情况", notes = "技术投标完成情况")
   private String technologyBidManagerCompletion;
   @ApiModelProperty(name = "technologyBidManagerBusinessTrip", value = "技术投标出差", notes = "技术投标出差")
   private String technologyBidManagerBusinessTrip;
   @ApiModelProperty(name = "technologyBidManagerCustomerReception", value = "技术投标客户接待", notes = "技术投标客户接待")
   private String technologyBidManagerCustomerReception;
   @ApiModelProperty(name = "technologyBidManagerRemarks", value = "技术投标备注", notes = "技术投标备注")
   private String technologyBidManagerRemarks;

   public static CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder builder() {
      return new CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder();
   }

   public CrmApplyForBidRecordDetailDTO() {
   }

   public CrmApplyForBidRecordDetailDTO(
      final Long id,
      final Long informantUserId,
      final String informantUserName,
      final Long departmentId,
      final String departmentName,
      final LocalDateTime informantDateTime,
      final String projectName,
      final String projectSerialNumber,
      final String crmEnterpriseWarehousingName,
      final String createUserName,
      final Long crmProjectInformationWarehousingId,
      final Long biddingMethodId,
      final String biddingMethodName,
      final Integer crmBiddingRegulationsTypeEnum,
      final Long tenderSubmissionMethodId,
      final String tenderSubmissionMethodName,
      final LocalDateTime bidExpirationDate,
      final LocalDateTime bidOpeningDate,
      final Long bidEvaluationMethodId,
      final String bidEvaluationMethodName,
      final Boolean isControlledBiddingPrice,
      final BigDecimal controlledBiddingPrice,
      final Long settlementMethodId,
      final String settlementMethodName,
      final Boolean isTenderBond,
      final BigDecimal tenderBond,
      final LocalDateTime tenderBondDeadline,
      final String companyName,
      final String depositBank,
      final String account,
      final Boolean isCashDeposit,
      final BigDecimal cashDeposit,
      final Long typeOfPerformanceBondId,
      final String typeOfPerformanceBondName,
      final String warrantyRatio,
      final String warrantyDate,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Boolean isMaterialAdjustment,
      final String materialAdjustment,
      final String materialBrandRegulations,
      final Boolean isSpecialRulesForMaterials,
      final String specialRulesForMaterials,
      final Boolean isOfferSample,
      final String offerSample,
      final String paymentMethod,
      final String biddingPlatformName,
      final String tenderRequirement,
      final Long approveRecordId,
      final List<AttachmentDTO> attachmentDTOList,
      final String remark,
      final BigDecimal businessProjectBidManagerQuote,
      final BigDecimal businessProjectBidManagerEstimatedWorks,
      final BigDecimal businessProjectBidManagerCost,
      final BigDecimal businessProjectBidManagerGrossProfit,
      final String businessProjectBidManagerRemark,
      final Long technologyBidManagerJobDescriptionId,
      final String technologyBidManagerJobDescriptionName,
      final String technologyBidManagerRenderings,
      final String technologyBidManagerStructureName,
      final String technologyBidManagerCompletion,
      final String technologyBidManagerBusinessTrip,
      final String technologyBidManagerCustomerReception,
      final String technologyBidManagerRemarks
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.informantDateTime = informantDateTime;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.createUserName = createUserName;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.biddingMethodId = biddingMethodId;
      this.biddingMethodName = biddingMethodName;
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
      this.tenderSubmissionMethodName = tenderSubmissionMethodName;
      this.bidExpirationDate = bidExpirationDate;
      this.bidOpeningDate = bidOpeningDate;
      this.bidEvaluationMethodId = bidEvaluationMethodId;
      this.bidEvaluationMethodName = bidEvaluationMethodName;
      this.isControlledBiddingPrice = isControlledBiddingPrice;
      this.controlledBiddingPrice = controlledBiddingPrice;
      this.settlementMethodId = settlementMethodId;
      this.settlementMethodName = settlementMethodName;
      this.isTenderBond = isTenderBond;
      this.tenderBond = tenderBond;
      this.tenderBondDeadline = tenderBondDeadline;
      this.companyName = companyName;
      this.depositBank = depositBank;
      this.account = account;
      this.isCashDeposit = isCashDeposit;
      this.cashDeposit = cashDeposit;
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
      this.typeOfPerformanceBondName = typeOfPerformanceBondName;
      this.warrantyRatio = warrantyRatio;
      this.warrantyDate = warrantyDate;
      this.startDate = startDate;
      this.endDate = endDate;
      this.isMaterialAdjustment = isMaterialAdjustment;
      this.materialAdjustment = materialAdjustment;
      this.materialBrandRegulations = materialBrandRegulations;
      this.isSpecialRulesForMaterials = isSpecialRulesForMaterials;
      this.specialRulesForMaterials = specialRulesForMaterials;
      this.isOfferSample = isOfferSample;
      this.offerSample = offerSample;
      this.paymentMethod = paymentMethod;
      this.biddingPlatformName = biddingPlatformName;
      this.tenderRequirement = tenderRequirement;
      this.approveRecordId = approveRecordId;
      this.attachmentDTOList = attachmentDTOList;
      this.remark = remark;
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      this.technologyBidManagerJobDescriptionName = technologyBidManagerJobDescriptionName;
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
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

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Long getBiddingMethodId() {
      return this.biddingMethodId;
   }

   public String getBiddingMethodName() {
      return this.biddingMethodName;
   }

   public Integer getCrmBiddingRegulationsTypeEnum() {
      return this.crmBiddingRegulationsTypeEnum;
   }

   public Long getTenderSubmissionMethodId() {
      return this.tenderSubmissionMethodId;
   }

   public String getTenderSubmissionMethodName() {
      return this.tenderSubmissionMethodName;
   }

   public LocalDateTime getBidExpirationDate() {
      return this.bidExpirationDate;
   }

   public LocalDateTime getBidOpeningDate() {
      return this.bidOpeningDate;
   }

   public Long getBidEvaluationMethodId() {
      return this.bidEvaluationMethodId;
   }

   public String getBidEvaluationMethodName() {
      return this.bidEvaluationMethodName;
   }

   public Boolean getIsControlledBiddingPrice() {
      return this.isControlledBiddingPrice;
   }

   public BigDecimal getControlledBiddingPrice() {
      return this.controlledBiddingPrice;
   }

   public Long getSettlementMethodId() {
      return this.settlementMethodId;
   }

   public String getSettlementMethodName() {
      return this.settlementMethodName;
   }

   public Boolean getIsTenderBond() {
      return this.isTenderBond;
   }

   public BigDecimal getTenderBond() {
      return this.tenderBond;
   }

   public LocalDateTime getTenderBondDeadline() {
      return this.tenderBondDeadline;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getAccount() {
      return this.account;
   }

   public Boolean getIsCashDeposit() {
      return this.isCashDeposit;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Long getTypeOfPerformanceBondId() {
      return this.typeOfPerformanceBondId;
   }

   public String getTypeOfPerformanceBondName() {
      return this.typeOfPerformanceBondName;
   }

   public String getWarrantyRatio() {
      return this.warrantyRatio;
   }

   public String getWarrantyDate() {
      return this.warrantyDate;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Boolean getIsMaterialAdjustment() {
      return this.isMaterialAdjustment;
   }

   public String getMaterialAdjustment() {
      return this.materialAdjustment;
   }

   public String getMaterialBrandRegulations() {
      return this.materialBrandRegulations;
   }

   public Boolean getIsSpecialRulesForMaterials() {
      return this.isSpecialRulesForMaterials;
   }

   public String getSpecialRulesForMaterials() {
      return this.specialRulesForMaterials;
   }

   public Boolean getIsOfferSample() {
      return this.isOfferSample;
   }

   public String getOfferSample() {
      return this.offerSample;
   }

   public String getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public String getTenderRequirement() {
      return this.tenderRequirement;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getBusinessProjectBidManagerQuote() {
      return this.businessProjectBidManagerQuote;
   }

   public BigDecimal getBusinessProjectBidManagerEstimatedWorks() {
      return this.businessProjectBidManagerEstimatedWorks;
   }

   public BigDecimal getBusinessProjectBidManagerCost() {
      return this.businessProjectBidManagerCost;
   }

   public BigDecimal getBusinessProjectBidManagerGrossProfit() {
      return this.businessProjectBidManagerGrossProfit;
   }

   public String getBusinessProjectBidManagerRemark() {
      return this.businessProjectBidManagerRemark;
   }

   public Long getTechnologyBidManagerJobDescriptionId() {
      return this.technologyBidManagerJobDescriptionId;
   }

   public String getTechnologyBidManagerJobDescriptionName() {
      return this.technologyBidManagerJobDescriptionName;
   }

   public String getTechnologyBidManagerRenderings() {
      return this.technologyBidManagerRenderings;
   }

   public String getTechnologyBidManagerStructureName() {
      return this.technologyBidManagerStructureName;
   }

   public String getTechnologyBidManagerCompletion() {
      return this.technologyBidManagerCompletion;
   }

   public String getTechnologyBidManagerBusinessTrip() {
      return this.technologyBidManagerBusinessTrip;
   }

   public String getTechnologyBidManagerCustomerReception() {
      return this.technologyBidManagerCustomerReception;
   }

   public String getTechnologyBidManagerRemarks() {
      return this.technologyBidManagerRemarks;
   }

   public CrmApplyForBidRecordDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBiddingMethodName(final String biddingMethodName) {
      this.biddingMethodName = biddingMethodName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setCrmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTenderSubmissionMethodName(final String tenderSubmissionMethodName) {
      this.tenderSubmissionMethodName = tenderSubmissionMethodName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBidExpirationDate(final LocalDateTime bidExpirationDate) {
      this.bidExpirationDate = bidExpirationDate;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBidOpeningDate(final LocalDateTime bidOpeningDate) {
      this.bidOpeningDate = bidOpeningDate;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBidEvaluationMethodId(final Long bidEvaluationMethodId) {
      this.bidEvaluationMethodId = bidEvaluationMethodId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBidEvaluationMethodName(final String bidEvaluationMethodName) {
      this.bidEvaluationMethodName = bidEvaluationMethodName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setIsControlledBiddingPrice(final Boolean isControlledBiddingPrice) {
      this.isControlledBiddingPrice = isControlledBiddingPrice;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setControlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
      this.controlledBiddingPrice = controlledBiddingPrice;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setSettlementMethodId(final Long settlementMethodId) {
      this.settlementMethodId = settlementMethodId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setSettlementMethodName(final String settlementMethodName) {
      this.settlementMethodName = settlementMethodName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setIsTenderBond(final Boolean isTenderBond) {
      this.isTenderBond = isTenderBond;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTenderBond(final BigDecimal tenderBond) {
      this.tenderBond = tenderBond;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTenderBondDeadline(final LocalDateTime tenderBondDeadline) {
      this.tenderBondDeadline = tenderBondDeadline;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setAccount(final String account) {
      this.account = account;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setIsCashDeposit(final Boolean isCashDeposit) {
      this.isCashDeposit = isCashDeposit;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTypeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTypeOfPerformanceBondName(final String typeOfPerformanceBondName) {
      this.typeOfPerformanceBondName = typeOfPerformanceBondName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setWarrantyRatio(final String warrantyRatio) {
      this.warrantyRatio = warrantyRatio;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setWarrantyDate(final String warrantyDate) {
      this.warrantyDate = warrantyDate;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setIsMaterialAdjustment(final Boolean isMaterialAdjustment) {
      this.isMaterialAdjustment = isMaterialAdjustment;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setMaterialAdjustment(final String materialAdjustment) {
      this.materialAdjustment = materialAdjustment;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setMaterialBrandRegulations(final String materialBrandRegulations) {
      this.materialBrandRegulations = materialBrandRegulations;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setIsSpecialRulesForMaterials(final Boolean isSpecialRulesForMaterials) {
      this.isSpecialRulesForMaterials = isSpecialRulesForMaterials;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setSpecialRulesForMaterials(final String specialRulesForMaterials) {
      this.specialRulesForMaterials = specialRulesForMaterials;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setIsOfferSample(final Boolean isOfferSample) {
      this.isOfferSample = isOfferSample;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setOfferSample(final String offerSample) {
      this.offerSample = offerSample;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTenderRequirement(final String tenderRequirement) {
      this.tenderRequirement = tenderRequirement;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBusinessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBusinessProjectBidManagerEstimatedWorks(final BigDecimal businessProjectBidManagerEstimatedWorks) {
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBusinessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBusinessProjectBidManagerGrossProfit(final BigDecimal businessProjectBidManagerGrossProfit) {
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setBusinessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerJobDescriptionId(final Long technologyBidManagerJobDescriptionId) {
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerJobDescriptionName(final String technologyBidManagerJobDescriptionName) {
      this.technologyBidManagerJobDescriptionName = technologyBidManagerJobDescriptionName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerRenderings(final String technologyBidManagerRenderings) {
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerStructureName(final String technologyBidManagerStructureName) {
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerCompletion(final String technologyBidManagerCompletion) {
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerBusinessTrip(final String technologyBidManagerBusinessTrip) {
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerCustomerReception(final String technologyBidManagerCustomerReception) {
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      return this;
   }

   public CrmApplyForBidRecordDetailDTO setTechnologyBidManagerRemarks(final String technologyBidManagerRemarks) {
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
      return this;
   }

   @Override
   public String toString() {
      return "CrmApplyForBidRecordDetailDTO(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", biddingMethodId="
         + this.getBiddingMethodId()
         + ", biddingMethodName="
         + this.getBiddingMethodName()
         + ", crmBiddingRegulationsTypeEnum="
         + this.getCrmBiddingRegulationsTypeEnum()
         + ", tenderSubmissionMethodId="
         + this.getTenderSubmissionMethodId()
         + ", tenderSubmissionMethodName="
         + this.getTenderSubmissionMethodName()
         + ", bidExpirationDate="
         + this.getBidExpirationDate()
         + ", bidOpeningDate="
         + this.getBidOpeningDate()
         + ", bidEvaluationMethodId="
         + this.getBidEvaluationMethodId()
         + ", bidEvaluationMethodName="
         + this.getBidEvaluationMethodName()
         + ", isControlledBiddingPrice="
         + this.getIsControlledBiddingPrice()
         + ", controlledBiddingPrice="
         + this.getControlledBiddingPrice()
         + ", settlementMethodId="
         + this.getSettlementMethodId()
         + ", settlementMethodName="
         + this.getSettlementMethodName()
         + ", isTenderBond="
         + this.getIsTenderBond()
         + ", tenderBond="
         + this.getTenderBond()
         + ", tenderBondDeadline="
         + this.getTenderBondDeadline()
         + ", companyName="
         + this.getCompanyName()
         + ", depositBank="
         + this.getDepositBank()
         + ", account="
         + this.getAccount()
         + ", isCashDeposit="
         + this.getIsCashDeposit()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", typeOfPerformanceBondId="
         + this.getTypeOfPerformanceBondId()
         + ", typeOfPerformanceBondName="
         + this.getTypeOfPerformanceBondName()
         + ", warrantyRatio="
         + this.getWarrantyRatio()
         + ", warrantyDate="
         + this.getWarrantyDate()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", isMaterialAdjustment="
         + this.getIsMaterialAdjustment()
         + ", materialAdjustment="
         + this.getMaterialAdjustment()
         + ", materialBrandRegulations="
         + this.getMaterialBrandRegulations()
         + ", isSpecialRulesForMaterials="
         + this.getIsSpecialRulesForMaterials()
         + ", specialRulesForMaterials="
         + this.getSpecialRulesForMaterials()
         + ", isOfferSample="
         + this.getIsOfferSample()
         + ", offerSample="
         + this.getOfferSample()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", tenderRequirement="
         + this.getTenderRequirement()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", remark="
         + this.getRemark()
         + ", businessProjectBidManagerQuote="
         + this.getBusinessProjectBidManagerQuote()
         + ", businessProjectBidManagerEstimatedWorks="
         + this.getBusinessProjectBidManagerEstimatedWorks()
         + ", businessProjectBidManagerCost="
         + this.getBusinessProjectBidManagerCost()
         + ", businessProjectBidManagerGrossProfit="
         + this.getBusinessProjectBidManagerGrossProfit()
         + ", businessProjectBidManagerRemark="
         + this.getBusinessProjectBidManagerRemark()
         + ", technologyBidManagerJobDescriptionId="
         + this.getTechnologyBidManagerJobDescriptionId()
         + ", technologyBidManagerJobDescriptionName="
         + this.getTechnologyBidManagerJobDescriptionName()
         + ", technologyBidManagerRenderings="
         + this.getTechnologyBidManagerRenderings()
         + ", technologyBidManagerStructureName="
         + this.getTechnologyBidManagerStructureName()
         + ", technologyBidManagerCompletion="
         + this.getTechnologyBidManagerCompletion()
         + ", technologyBidManagerBusinessTrip="
         + this.getTechnologyBidManagerBusinessTrip()
         + ", technologyBidManagerCustomerReception="
         + this.getTechnologyBidManagerCustomerReception()
         + ", technologyBidManagerRemarks="
         + this.getTechnologyBidManagerRemarks()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmApplyForBidRecordDetailDTO)) {
         return false;
      }

      CrmApplyForBidRecordDetailDTO other = (CrmApplyForBidRecordDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$departmentId = this.getDepartmentId();
            Object other$departmentId = other.getDepartmentId();
            if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
               Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
               Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
               if (this$crmProjectInformationWarehousingId == null
                  ? other$crmProjectInformationWarehousingId == null
                  : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                  Object this$biddingMethodId = this.getBiddingMethodId();
                  Object other$biddingMethodId = other.getBiddingMethodId();
                  if (this$biddingMethodId == null ? other$biddingMethodId == null : this$biddingMethodId.equals(other$biddingMethodId)) {
                     Object this$crmBiddingRegulationsTypeEnum = this.getCrmBiddingRegulationsTypeEnum();
                     Object other$crmBiddingRegulationsTypeEnum = other.getCrmBiddingRegulationsTypeEnum();
                     if (this$crmBiddingRegulationsTypeEnum == null
                        ? other$crmBiddingRegulationsTypeEnum == null
                        : this$crmBiddingRegulationsTypeEnum.equals(other$crmBiddingRegulationsTypeEnum)) {
                        Object this$tenderSubmissionMethodId = this.getTenderSubmissionMethodId();
                        Object other$tenderSubmissionMethodId = other.getTenderSubmissionMethodId();
                        if (this$tenderSubmissionMethodId == null
                           ? other$tenderSubmissionMethodId == null
                           : this$tenderSubmissionMethodId.equals(other$tenderSubmissionMethodId)) {
                           Object this$bidEvaluationMethodId = this.getBidEvaluationMethodId();
                           Object other$bidEvaluationMethodId = other.getBidEvaluationMethodId();
                           if (this$bidEvaluationMethodId == null
                              ? other$bidEvaluationMethodId == null
                              : this$bidEvaluationMethodId.equals(other$bidEvaluationMethodId)) {
                              Object this$isControlledBiddingPrice = this.getIsControlledBiddingPrice();
                              Object other$isControlledBiddingPrice = other.getIsControlledBiddingPrice();
                              if (this$isControlledBiddingPrice == null
                                 ? other$isControlledBiddingPrice == null
                                 : this$isControlledBiddingPrice.equals(other$isControlledBiddingPrice)) {
                                 Object this$settlementMethodId = this.getSettlementMethodId();
                                 Object other$settlementMethodId = other.getSettlementMethodId();
                                 if (this$settlementMethodId == null
                                    ? other$settlementMethodId == null
                                    : this$settlementMethodId.equals(other$settlementMethodId)) {
                                    Object this$isTenderBond = this.getIsTenderBond();
                                    Object other$isTenderBond = other.getIsTenderBond();
                                    if (this$isTenderBond == null ? other$isTenderBond == null : this$isTenderBond.equals(other$isTenderBond)) {
                                       Object this$isCashDeposit = this.getIsCashDeposit();
                                       Object other$isCashDeposit = other.getIsCashDeposit();
                                       if (this$isCashDeposit == null ? other$isCashDeposit == null : this$isCashDeposit.equals(other$isCashDeposit)) {
                                          Object this$typeOfPerformanceBondId = this.getTypeOfPerformanceBondId();
                                          Object other$typeOfPerformanceBondId = other.getTypeOfPerformanceBondId();
                                          if (this$typeOfPerformanceBondId == null
                                             ? other$typeOfPerformanceBondId == null
                                             : this$typeOfPerformanceBondId.equals(other$typeOfPerformanceBondId)) {
                                             Object this$isMaterialAdjustment = this.getIsMaterialAdjustment();
                                             Object other$isMaterialAdjustment = other.getIsMaterialAdjustment();
                                             if (this$isMaterialAdjustment == null
                                                ? other$isMaterialAdjustment == null
                                                : this$isMaterialAdjustment.equals(other$isMaterialAdjustment)) {
                                                Object this$isSpecialRulesForMaterials = this.getIsSpecialRulesForMaterials();
                                                Object other$isSpecialRulesForMaterials = other.getIsSpecialRulesForMaterials();
                                                if (this$isSpecialRulesForMaterials == null
                                                   ? other$isSpecialRulesForMaterials == null
                                                   : this$isSpecialRulesForMaterials.equals(other$isSpecialRulesForMaterials)) {
                                                   Object this$isOfferSample = this.getIsOfferSample();
                                                   Object other$isOfferSample = other.getIsOfferSample();
                                                   if (this$isOfferSample == null
                                                      ? other$isOfferSample == null
                                                      : this$isOfferSample.equals(other$isOfferSample)) {
                                                      Object this$approveRecordId = this.getApproveRecordId();
                                                      Object other$approveRecordId = other.getApproveRecordId();
                                                      if (this$approveRecordId == null
                                                         ? other$approveRecordId == null
                                                         : this$approveRecordId.equals(other$approveRecordId)) {
                                                         Object this$technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
                                                         Object other$technologyBidManagerJobDescriptionId = other.getTechnologyBidManagerJobDescriptionId();
                                                         if (this$technologyBidManagerJobDescriptionId == null
                                                            ? other$technologyBidManagerJobDescriptionId == null
                                                            : this$technologyBidManagerJobDescriptionId.equals(other$technologyBidManagerJobDescriptionId)) {
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
                                                                           Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                                                           Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                                                           if (this$crmEnterpriseWarehousingName == null
                                                                              ? other$crmEnterpriseWarehousingName == null
                                                                              : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                                                              Object this$createUserName = this.getCreateUserName();
                                                                              Object other$createUserName = other.getCreateUserName();
                                                                              if (this$createUserName == null
                                                                                 ? other$createUserName == null
                                                                                 : this$createUserName.equals(other$createUserName)) {
                                                                                 Object this$biddingMethodName = this.getBiddingMethodName();
                                                                                 Object other$biddingMethodName = other.getBiddingMethodName();
                                                                                 if (this$biddingMethodName == null
                                                                                    ? other$biddingMethodName == null
                                                                                    : this$biddingMethodName.equals(other$biddingMethodName)) {
                                                                                    Object this$tenderSubmissionMethodName = this.getTenderSubmissionMethodName();
                                                                                    Object other$tenderSubmissionMethodName = other.getTenderSubmissionMethodName();
                                                                                    if (this$tenderSubmissionMethodName == null
                                                                                       ? other$tenderSubmissionMethodName == null
                                                                                       : this$tenderSubmissionMethodName.equals(
                                                                                          other$tenderSubmissionMethodName
                                                                                       )) {
                                                                                       Object this$bidExpirationDate = this.getBidExpirationDate();
                                                                                       Object other$bidExpirationDate = other.getBidExpirationDate();
                                                                                       if (this$bidExpirationDate == null
                                                                                          ? other$bidExpirationDate == null
                                                                                          : this$bidExpirationDate.equals(other$bidExpirationDate)) {
                                                                                          Object this$bidOpeningDate = this.getBidOpeningDate();
                                                                                          Object other$bidOpeningDate = other.getBidOpeningDate();
                                                                                          if (this$bidOpeningDate == null
                                                                                             ? other$bidOpeningDate == null
                                                                                             : this$bidOpeningDate.equals(other$bidOpeningDate)) {
                                                                                             Object this$bidEvaluationMethodName = this.getBidEvaluationMethodName();
                                                                                             Object other$bidEvaluationMethodName = other.getBidEvaluationMethodName();
                                                                                             if (this$bidEvaluationMethodName == null
                                                                                                ? other$bidEvaluationMethodName == null
                                                                                                : this$bidEvaluationMethodName.equals(
                                                                                                   other$bidEvaluationMethodName
                                                                                                )) {
                                                                                                Object this$controlledBiddingPrice = this.getControlledBiddingPrice();
                                                                                                Object other$controlledBiddingPrice = other.getControlledBiddingPrice();
                                                                                                if (this$controlledBiddingPrice == null
                                                                                                   ? other$controlledBiddingPrice == null
                                                                                                   : this$controlledBiddingPrice.equals(
                                                                                                      other$controlledBiddingPrice
                                                                                                   )) {
                                                                                                   Object this$settlementMethodName = this.getSettlementMethodName();
                                                                                                   Object other$settlementMethodName = other.getSettlementMethodName();
                                                                                                   if (this$settlementMethodName == null
                                                                                                      ? other$settlementMethodName == null
                                                                                                      : this$settlementMethodName.equals(
                                                                                                         other$settlementMethodName
                                                                                                      )) {
                                                                                                      Object this$tenderBond = this.getTenderBond();
                                                                                                      Object other$tenderBond = other.getTenderBond();
                                                                                                      if (this$tenderBond == null
                                                                                                         ? other$tenderBond == null
                                                                                                         : this$tenderBond.equals(other$tenderBond)) {
                                                                                                         Object this$tenderBondDeadline = this.getTenderBondDeadline();
                                                                                                         Object other$tenderBondDeadline = other.getTenderBondDeadline();
                                                                                                         if (this$tenderBondDeadline == null
                                                                                                            ? other$tenderBondDeadline == null
                                                                                                            : this$tenderBondDeadline.equals(
                                                                                                               other$tenderBondDeadline
                                                                                                            )) {
                                                                                                            Object this$companyName = this.getCompanyName();
                                                                                                            Object other$companyName = other.getCompanyName();
                                                                                                            if (this$companyName == null
                                                                                                               ? other$companyName == null
                                                                                                               : this$companyName.equals(other$companyName)) {
                                                                                                               Object this$depositBank = this.getDepositBank();
                                                                                                               Object other$depositBank = other.getDepositBank();
                                                                                                               if (this$depositBank == null
                                                                                                                  ? other$depositBank == null
                                                                                                                  : this$depositBank.equals(other$depositBank)) {
                                                                                                                  Object this$account = this.getAccount();
                                                                                                                  Object other$account = other.getAccount();
                                                                                                                  if (this$account == null
                                                                                                                     ? other$account == null
                                                                                                                     : this$account.equals(other$account)) {
                                                                                                                     Object this$cashDeposit = this.getCashDeposit();
                                                                                                                     Object other$cashDeposit = other.getCashDeposit();
                                                                                                                     if (this$cashDeposit == null
                                                                                                                        ? other$cashDeposit == null
                                                                                                                        : this$cashDeposit.equals(
                                                                                                                           other$cashDeposit
                                                                                                                        )) {
                                                                                                                        Object this$typeOfPerformanceBondName = this.getTypeOfPerformanceBondName();
                                                                                                                        Object other$typeOfPerformanceBondName = other.getTypeOfPerformanceBondName();
                                                                                                                        if (this$typeOfPerformanceBondName
                                                                                                                              == null
                                                                                                                           ? other$typeOfPerformanceBondName
                                                                                                                              == null
                                                                                                                           : this$typeOfPerformanceBondName.equals(
                                                                                                                              other$typeOfPerformanceBondName
                                                                                                                           )) {
                                                                                                                           Object this$warrantyRatio = this.getWarrantyRatio();
                                                                                                                           Object other$warrantyRatio = other.getWarrantyRatio();
                                                                                                                           if (this$warrantyRatio == null
                                                                                                                              ? other$warrantyRatio == null
                                                                                                                              : this$warrantyRatio.equals(
                                                                                                                                 other$warrantyRatio
                                                                                                                              )) {
                                                                                                                              Object this$warrantyDate = this.getWarrantyDate();
                                                                                                                              Object other$warrantyDate = other.getWarrantyDate();
                                                                                                                              if (this$warrantyDate == null
                                                                                                                                 ? other$warrantyDate == null
                                                                                                                                 : this$warrantyDate.equals(
                                                                                                                                    other$warrantyDate
                                                                                                                                 )) {
                                                                                                                                 Object this$startDate = this.getStartDate();
                                                                                                                                 Object other$startDate = other.getStartDate();
                                                                                                                                 if (this$startDate == null
                                                                                                                                    ? other$startDate == null
                                                                                                                                    : this$startDate.equals(
                                                                                                                                       other$startDate
                                                                                                                                    )) {
                                                                                                                                    Object this$endDate = this.getEndDate();
                                                                                                                                    Object other$endDate = other.getEndDate();
                                                                                                                                    if (this$endDate == null
                                                                                                                                       ? other$endDate == null
                                                                                                                                       : this$endDate.equals(
                                                                                                                                          other$endDate
                                                                                                                                       )) {
                                                                                                                                       Object this$materialAdjustment = this.getMaterialAdjustment();
                                                                                                                                       Object other$materialAdjustment = other.getMaterialAdjustment();
                                                                                                                                       if (this$materialAdjustment
                                                                                                                                             == null
                                                                                                                                          ? other$materialAdjustment
                                                                                                                                             == null
                                                                                                                                          : this$materialAdjustment.equals(
                                                                                                                                             other$materialAdjustment
                                                                                                                                          )) {
                                                                                                                                          Object this$materialBrandRegulations = this.getMaterialBrandRegulations();
                                                                                                                                          Object other$materialBrandRegulations = other.getMaterialBrandRegulations();
                                                                                                                                          if (this$materialBrandRegulations
                                                                                                                                                == null
                                                                                                                                             ? other$materialBrandRegulations
                                                                                                                                                == null
                                                                                                                                             : this$materialBrandRegulations.equals(
                                                                                                                                                other$materialBrandRegulations
                                                                                                                                             )) {
                                                                                                                                             Object this$specialRulesForMaterials = this.getSpecialRulesForMaterials();
                                                                                                                                             Object other$specialRulesForMaterials = other.getSpecialRulesForMaterials();
                                                                                                                                             if (this$specialRulesForMaterials
                                                                                                                                                   == null
                                                                                                                                                ? other$specialRulesForMaterials
                                                                                                                                                   == null
                                                                                                                                                : this$specialRulesForMaterials.equals(
                                                                                                                                                   other$specialRulesForMaterials
                                                                                                                                                )) {
                                                                                                                                                Object this$offerSample = this.getOfferSample();
                                                                                                                                                Object other$offerSample = other.getOfferSample();
                                                                                                                                                if (this$offerSample
                                                                                                                                                      == null
                                                                                                                                                   ? other$offerSample
                                                                                                                                                      == null
                                                                                                                                                   : this$offerSample.equals(
                                                                                                                                                      other$offerSample
                                                                                                                                                   )) {
                                                                                                                                                   Object this$paymentMethod = this.getPaymentMethod();
                                                                                                                                                   Object other$paymentMethod = other.getPaymentMethod();
                                                                                                                                                   if (this$paymentMethod
                                                                                                                                                         == null
                                                                                                                                                      ? other$paymentMethod
                                                                                                                                                         == null
                                                                                                                                                      : this$paymentMethod.equals(
                                                                                                                                                         other$paymentMethod
                                                                                                                                                      )) {
                                                                                                                                                      Object this$biddingPlatformName = this.getBiddingPlatformName();
                                                                                                                                                      Object other$biddingPlatformName = other.getBiddingPlatformName();
                                                                                                                                                      if (this$biddingPlatformName
                                                                                                                                                            == null
                                                                                                                                                         ? other$biddingPlatformName
                                                                                                                                                            == null
                                                                                                                                                         : this$biddingPlatformName.equals(
                                                                                                                                                            other$biddingPlatformName
                                                                                                                                                         )) {
                                                                                                                                                         Object this$tenderRequirement = this.getTenderRequirement();
                                                                                                                                                         Object other$tenderRequirement = other.getTenderRequirement();
                                                                                                                                                         if (this$tenderRequirement
                                                                                                                                                               == null
                                                                                                                                                            ? other$tenderRequirement
                                                                                                                                                               == null
                                                                                                                                                            : this$tenderRequirement.equals(
                                                                                                                                                               other$tenderRequirement
                                                                                                                                                            )) {
                                                                                                                                                            Object this$attachmentDTOList = this.getAttachmentDTOList();
                                                                                                                                                            Object other$attachmentDTOList = other.getAttachmentDTOList();
                                                                                                                                                            if (this$attachmentDTOList
                                                                                                                                                                  == null
                                                                                                                                                               ? other$attachmentDTOList
                                                                                                                                                                  == null
                                                                                                                                                               : this$attachmentDTOList.equals(
                                                                                                                                                                  other$attachmentDTOList
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
                                                                                                                                                                  Object this$businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
                                                                                                                                                                  Object other$businessProjectBidManagerQuote = other.getBusinessProjectBidManagerQuote();
                                                                                                                                                                  if (this$businessProjectBidManagerQuote
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$businessProjectBidManagerQuote
                                                                                                                                                                        == null
                                                                                                                                                                     : this$businessProjectBidManagerQuote.equals(
                                                                                                                                                                        other$businessProjectBidManagerQuote
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
                                                                                                                                                                     Object other$businessProjectBidManagerEstimatedWorks = other.getBusinessProjectBidManagerEstimatedWorks();
                                                                                                                                                                     if (this$businessProjectBidManagerEstimatedWorks
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$businessProjectBidManagerEstimatedWorks
                                                                                                                                                                           == null
                                                                                                                                                                        : this$businessProjectBidManagerEstimatedWorks.equals(
                                                                                                                                                                           other$businessProjectBidManagerEstimatedWorks
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
                                                                                                                                                                        Object other$businessProjectBidManagerCost = other.getBusinessProjectBidManagerCost();
                                                                                                                                                                        if (this$businessProjectBidManagerCost
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$businessProjectBidManagerCost
                                                                                                                                                                              == null
                                                                                                                                                                           : this$businessProjectBidManagerCost.equals(
                                                                                                                                                                              other$businessProjectBidManagerCost
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
                                                                                                                                                                           Object other$businessProjectBidManagerGrossProfit = other.getBusinessProjectBidManagerGrossProfit();
                                                                                                                                                                           if (this$businessProjectBidManagerGrossProfit
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$businessProjectBidManagerGrossProfit
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$businessProjectBidManagerGrossProfit.equals(
                                                                                                                                                                                 other$businessProjectBidManagerGrossProfit
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
                                                                                                                                                                              Object other$businessProjectBidManagerRemark = other.getBusinessProjectBidManagerRemark();
                                                                                                                                                                              if (this$businessProjectBidManagerRemark
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$businessProjectBidManagerRemark
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$businessProjectBidManagerRemark.equals(
                                                                                                                                                                                    other$businessProjectBidManagerRemark
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$technologyBidManagerJobDescriptionName = this.getTechnologyBidManagerJobDescriptionName();
                                                                                                                                                                                 Object other$technologyBidManagerJobDescriptionName = other.getTechnologyBidManagerJobDescriptionName();
                                                                                                                                                                                 if (this$technologyBidManagerJobDescriptionName
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$technologyBidManagerJobDescriptionName
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$technologyBidManagerJobDescriptionName.equals(
                                                                                                                                                                                       other$technologyBidManagerJobDescriptionName
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
                                                                                                                                                                                    Object other$technologyBidManagerRenderings = other.getTechnologyBidManagerRenderings();
                                                                                                                                                                                    if (this$technologyBidManagerRenderings
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$technologyBidManagerRenderings
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$technologyBidManagerRenderings.equals(
                                                                                                                                                                                          other$technologyBidManagerRenderings
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
                                                                                                                                                                                       Object other$technologyBidManagerStructureName = other.getTechnologyBidManagerStructureName();
                                                                                                                                                                                       if (this$technologyBidManagerStructureName
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$technologyBidManagerStructureName
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$technologyBidManagerStructureName.equals(
                                                                                                                                                                                             other$technologyBidManagerStructureName
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
                                                                                                                                                                                          Object other$technologyBidManagerCompletion = other.getTechnologyBidManagerCompletion();
                                                                                                                                                                                          if (this$technologyBidManagerCompletion
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$technologyBidManagerCompletion
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$technologyBidManagerCompletion.equals(
                                                                                                                                                                                                other$technologyBidManagerCompletion
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
                                                                                                                                                                                             Object other$technologyBidManagerBusinessTrip = other.getTechnologyBidManagerBusinessTrip();
                                                                                                                                                                                             if (this$technologyBidManagerBusinessTrip
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$technologyBidManagerBusinessTrip
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$technologyBidManagerBusinessTrip.equals(
                                                                                                                                                                                                   other$technologyBidManagerBusinessTrip
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
                                                                                                                                                                                                Object other$technologyBidManagerCustomerReception = other.getTechnologyBidManagerCustomerReception();
                                                                                                                                                                                                if (this$technologyBidManagerCustomerReception
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$technologyBidManagerCustomerReception
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$technologyBidManagerCustomerReception.equals(
                                                                                                                                                                                                      other$technologyBidManagerCustomerReception
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
                                                                                                                                                                                                   Object other$technologyBidManagerRemarks = other.getTechnologyBidManagerRemarks();
                                                                                                                                                                                                   return this$technologyBidManagerRemarks
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$technologyBidManagerRemarks
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$technologyBidManagerRemarks.equals(
                                                                                                                                                                                                         other$technologyBidManagerRemarks
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmApplyForBidRecordDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $biddingMethodId = this.getBiddingMethodId();
      result = result * 59 + ($biddingMethodId == null ? 43 : $biddingMethodId.hashCode());
      Object $crmBiddingRegulationsTypeEnum = this.getCrmBiddingRegulationsTypeEnum();
      result = result * 59 + ($crmBiddingRegulationsTypeEnum == null ? 43 : $crmBiddingRegulationsTypeEnum.hashCode());
      Object $tenderSubmissionMethodId = this.getTenderSubmissionMethodId();
      result = result * 59 + ($tenderSubmissionMethodId == null ? 43 : $tenderSubmissionMethodId.hashCode());
      Object $bidEvaluationMethodId = this.getBidEvaluationMethodId();
      result = result * 59 + ($bidEvaluationMethodId == null ? 43 : $bidEvaluationMethodId.hashCode());
      Object $isControlledBiddingPrice = this.getIsControlledBiddingPrice();
      result = result * 59 + ($isControlledBiddingPrice == null ? 43 : $isControlledBiddingPrice.hashCode());
      Object $settlementMethodId = this.getSettlementMethodId();
      result = result * 59 + ($settlementMethodId == null ? 43 : $settlementMethodId.hashCode());
      Object $isTenderBond = this.getIsTenderBond();
      result = result * 59 + ($isTenderBond == null ? 43 : $isTenderBond.hashCode());
      Object $isCashDeposit = this.getIsCashDeposit();
      result = result * 59 + ($isCashDeposit == null ? 43 : $isCashDeposit.hashCode());
      Object $typeOfPerformanceBondId = this.getTypeOfPerformanceBondId();
      result = result * 59 + ($typeOfPerformanceBondId == null ? 43 : $typeOfPerformanceBondId.hashCode());
      Object $isMaterialAdjustment = this.getIsMaterialAdjustment();
      result = result * 59 + ($isMaterialAdjustment == null ? 43 : $isMaterialAdjustment.hashCode());
      Object $isSpecialRulesForMaterials = this.getIsSpecialRulesForMaterials();
      result = result * 59 + ($isSpecialRulesForMaterials == null ? 43 : $isSpecialRulesForMaterials.hashCode());
      Object $isOfferSample = this.getIsOfferSample();
      result = result * 59 + ($isOfferSample == null ? 43 : $isOfferSample.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
      result = result * 59 + ($technologyBidManagerJobDescriptionId == null ? 43 : $technologyBidManagerJobDescriptionId.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $biddingMethodName = this.getBiddingMethodName();
      result = result * 59 + ($biddingMethodName == null ? 43 : $biddingMethodName.hashCode());
      Object $tenderSubmissionMethodName = this.getTenderSubmissionMethodName();
      result = result * 59 + ($tenderSubmissionMethodName == null ? 43 : $tenderSubmissionMethodName.hashCode());
      Object $bidExpirationDate = this.getBidExpirationDate();
      result = result * 59 + ($bidExpirationDate == null ? 43 : $bidExpirationDate.hashCode());
      Object $bidOpeningDate = this.getBidOpeningDate();
      result = result * 59 + ($bidOpeningDate == null ? 43 : $bidOpeningDate.hashCode());
      Object $bidEvaluationMethodName = this.getBidEvaluationMethodName();
      result = result * 59 + ($bidEvaluationMethodName == null ? 43 : $bidEvaluationMethodName.hashCode());
      Object $controlledBiddingPrice = this.getControlledBiddingPrice();
      result = result * 59 + ($controlledBiddingPrice == null ? 43 : $controlledBiddingPrice.hashCode());
      Object $settlementMethodName = this.getSettlementMethodName();
      result = result * 59 + ($settlementMethodName == null ? 43 : $settlementMethodName.hashCode());
      Object $tenderBond = this.getTenderBond();
      result = result * 59 + ($tenderBond == null ? 43 : $tenderBond.hashCode());
      Object $tenderBondDeadline = this.getTenderBondDeadline();
      result = result * 59 + ($tenderBondDeadline == null ? 43 : $tenderBondDeadline.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $account = this.getAccount();
      result = result * 59 + ($account == null ? 43 : $account.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $typeOfPerformanceBondName = this.getTypeOfPerformanceBondName();
      result = result * 59 + ($typeOfPerformanceBondName == null ? 43 : $typeOfPerformanceBondName.hashCode());
      Object $warrantyRatio = this.getWarrantyRatio();
      result = result * 59 + ($warrantyRatio == null ? 43 : $warrantyRatio.hashCode());
      Object $warrantyDate = this.getWarrantyDate();
      result = result * 59 + ($warrantyDate == null ? 43 : $warrantyDate.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $materialAdjustment = this.getMaterialAdjustment();
      result = result * 59 + ($materialAdjustment == null ? 43 : $materialAdjustment.hashCode());
      Object $materialBrandRegulations = this.getMaterialBrandRegulations();
      result = result * 59 + ($materialBrandRegulations == null ? 43 : $materialBrandRegulations.hashCode());
      Object $specialRulesForMaterials = this.getSpecialRulesForMaterials();
      result = result * 59 + ($specialRulesForMaterials == null ? 43 : $specialRulesForMaterials.hashCode());
      Object $offerSample = this.getOfferSample();
      result = result * 59 + ($offerSample == null ? 43 : $offerSample.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $tenderRequirement = this.getTenderRequirement();
      result = result * 59 + ($tenderRequirement == null ? 43 : $tenderRequirement.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
      result = result * 59 + ($businessProjectBidManagerQuote == null ? 43 : $businessProjectBidManagerQuote.hashCode());
      Object $businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
      result = result * 59 + ($businessProjectBidManagerEstimatedWorks == null ? 43 : $businessProjectBidManagerEstimatedWorks.hashCode());
      Object $businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
      result = result * 59 + ($businessProjectBidManagerCost == null ? 43 : $businessProjectBidManagerCost.hashCode());
      Object $businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
      result = result * 59 + ($businessProjectBidManagerGrossProfit == null ? 43 : $businessProjectBidManagerGrossProfit.hashCode());
      Object $businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
      result = result * 59 + ($businessProjectBidManagerRemark == null ? 43 : $businessProjectBidManagerRemark.hashCode());
      Object $technologyBidManagerJobDescriptionName = this.getTechnologyBidManagerJobDescriptionName();
      result = result * 59 + ($technologyBidManagerJobDescriptionName == null ? 43 : $technologyBidManagerJobDescriptionName.hashCode());
      Object $technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
      result = result * 59 + ($technologyBidManagerRenderings == null ? 43 : $technologyBidManagerRenderings.hashCode());
      Object $technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
      result = result * 59 + ($technologyBidManagerStructureName == null ? 43 : $technologyBidManagerStructureName.hashCode());
      Object $technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
      result = result * 59 + ($technologyBidManagerCompletion == null ? 43 : $technologyBidManagerCompletion.hashCode());
      Object $technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
      result = result * 59 + ($technologyBidManagerBusinessTrip == null ? 43 : $technologyBidManagerBusinessTrip.hashCode());
      Object $technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
      result = result * 59 + ($technologyBidManagerCustomerReception == null ? 43 : $technologyBidManagerCustomerReception.hashCode());
      Object $technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
      return result * 59 + ($technologyBidManagerRemarks == null ? 43 : $technologyBidManagerRemarks.hashCode());
   }

   public static class CrmApplyForBidRecordDetailDTOBuilder {
      private Long id;
      private Long informantUserId;
      private String informantUserName;
      private Long departmentId;
      private String departmentName;
      private LocalDateTime informantDateTime;
      private String projectName;
      private String projectSerialNumber;
      private String crmEnterpriseWarehousingName;
      private String createUserName;
      private Long crmProjectInformationWarehousingId;
      private Long biddingMethodId;
      private String biddingMethodName;
      private Integer crmBiddingRegulationsTypeEnum;
      private Long tenderSubmissionMethodId;
      private String tenderSubmissionMethodName;
      private LocalDateTime bidExpirationDate;
      private LocalDateTime bidOpeningDate;
      private Long bidEvaluationMethodId;
      private String bidEvaluationMethodName;
      private Boolean isControlledBiddingPrice;
      private BigDecimal controlledBiddingPrice;
      private Long settlementMethodId;
      private String settlementMethodName;
      private Boolean isTenderBond;
      private BigDecimal tenderBond;
      private LocalDateTime tenderBondDeadline;
      private String companyName;
      private String depositBank;
      private String account;
      private Boolean isCashDeposit;
      private BigDecimal cashDeposit;
      private Long typeOfPerformanceBondId;
      private String typeOfPerformanceBondName;
      private String warrantyRatio;
      private String warrantyDate;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Boolean isMaterialAdjustment;
      private String materialAdjustment;
      private String materialBrandRegulations;
      private Boolean isSpecialRulesForMaterials;
      private String specialRulesForMaterials;
      private Boolean isOfferSample;
      private String offerSample;
      private String paymentMethod;
      private String biddingPlatformName;
      private String tenderRequirement;
      private Long approveRecordId;
      private List<AttachmentDTO> attachmentDTOList;
      private String remark;
      private BigDecimal businessProjectBidManagerQuote;
      private BigDecimal businessProjectBidManagerEstimatedWorks;
      private BigDecimal businessProjectBidManagerCost;
      private BigDecimal businessProjectBidManagerGrossProfit;
      private String businessProjectBidManagerRemark;
      private Long technologyBidManagerJobDescriptionId;
      private String technologyBidManagerJobDescriptionName;
      private String technologyBidManagerRenderings;
      private String technologyBidManagerStructureName;
      private String technologyBidManagerCompletion;
      private String technologyBidManagerBusinessTrip;
      private String technologyBidManagerCustomerReception;
      private String technologyBidManagerRemarks;

      CrmApplyForBidRecordDetailDTOBuilder() {
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder biddingMethodId(final Long biddingMethodId) {
         this.biddingMethodId = biddingMethodId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder biddingMethodName(final String biddingMethodName) {
         this.biddingMethodName = biddingMethodName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder crmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
         this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder tenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
         this.tenderSubmissionMethodId = tenderSubmissionMethodId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder tenderSubmissionMethodName(final String tenderSubmissionMethodName) {
         this.tenderSubmissionMethodName = tenderSubmissionMethodName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder bidExpirationDate(final LocalDateTime bidExpirationDate) {
         this.bidExpirationDate = bidExpirationDate;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder bidOpeningDate(final LocalDateTime bidOpeningDate) {
         this.bidOpeningDate = bidOpeningDate;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder bidEvaluationMethodId(final Long bidEvaluationMethodId) {
         this.bidEvaluationMethodId = bidEvaluationMethodId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder bidEvaluationMethodName(final String bidEvaluationMethodName) {
         this.bidEvaluationMethodName = bidEvaluationMethodName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder isControlledBiddingPrice(final Boolean isControlledBiddingPrice) {
         this.isControlledBiddingPrice = isControlledBiddingPrice;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder controlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
         this.controlledBiddingPrice = controlledBiddingPrice;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder settlementMethodId(final Long settlementMethodId) {
         this.settlementMethodId = settlementMethodId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder settlementMethodName(final String settlementMethodName) {
         this.settlementMethodName = settlementMethodName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder isTenderBond(final Boolean isTenderBond) {
         this.isTenderBond = isTenderBond;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder tenderBond(final BigDecimal tenderBond) {
         this.tenderBond = tenderBond;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder tenderBondDeadline(final LocalDateTime tenderBondDeadline) {
         this.tenderBondDeadline = tenderBondDeadline;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder account(final String account) {
         this.account = account;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder isCashDeposit(final Boolean isCashDeposit) {
         this.isCashDeposit = isCashDeposit;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder typeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
         this.typeOfPerformanceBondId = typeOfPerformanceBondId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder typeOfPerformanceBondName(final String typeOfPerformanceBondName) {
         this.typeOfPerformanceBondName = typeOfPerformanceBondName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder warrantyRatio(final String warrantyRatio) {
         this.warrantyRatio = warrantyRatio;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder warrantyDate(final String warrantyDate) {
         this.warrantyDate = warrantyDate;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder isMaterialAdjustment(final Boolean isMaterialAdjustment) {
         this.isMaterialAdjustment = isMaterialAdjustment;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder materialAdjustment(final String materialAdjustment) {
         this.materialAdjustment = materialAdjustment;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder materialBrandRegulations(final String materialBrandRegulations) {
         this.materialBrandRegulations = materialBrandRegulations;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder isSpecialRulesForMaterials(final Boolean isSpecialRulesForMaterials) {
         this.isSpecialRulesForMaterials = isSpecialRulesForMaterials;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder specialRulesForMaterials(final String specialRulesForMaterials) {
         this.specialRulesForMaterials = specialRulesForMaterials;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder isOfferSample(final Boolean isOfferSample) {
         this.isOfferSample = isOfferSample;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder offerSample(final String offerSample) {
         this.offerSample = offerSample;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder biddingPlatformName(final String biddingPlatformName) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder tenderRequirement(final String tenderRequirement) {
         this.tenderRequirement = tenderRequirement;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder businessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
         this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder businessProjectBidManagerEstimatedWorks(
         final BigDecimal businessProjectBidManagerEstimatedWorks
      ) {
         this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder businessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
         this.businessProjectBidManagerCost = businessProjectBidManagerCost;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder businessProjectBidManagerGrossProfit(
         final BigDecimal businessProjectBidManagerGrossProfit
      ) {
         this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder businessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
         this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerJobDescriptionId(
         final Long technologyBidManagerJobDescriptionId
      ) {
         this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerJobDescriptionName(
         final String technologyBidManagerJobDescriptionName
      ) {
         this.technologyBidManagerJobDescriptionName = technologyBidManagerJobDescriptionName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerRenderings(final String technologyBidManagerRenderings) {
         this.technologyBidManagerRenderings = technologyBidManagerRenderings;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerStructureName(
         final String technologyBidManagerStructureName
      ) {
         this.technologyBidManagerStructureName = technologyBidManagerStructureName;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerCompletion(final String technologyBidManagerCompletion) {
         this.technologyBidManagerCompletion = technologyBidManagerCompletion;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerBusinessTrip(final String technologyBidManagerBusinessTrip) {
         this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerCustomerReception(
         final String technologyBidManagerCustomerReception
      ) {
         this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder technologyBidManagerRemarks(final String technologyBidManagerRemarks) {
         this.technologyBidManagerRemarks = technologyBidManagerRemarks;
         return this;
      }

      public CrmApplyForBidRecordDetailDTO build() {
         return new CrmApplyForBidRecordDetailDTO(
            this.id,
            this.informantUserId,
            this.informantUserName,
            this.departmentId,
            this.departmentName,
            this.informantDateTime,
            this.projectName,
            this.projectSerialNumber,
            this.crmEnterpriseWarehousingName,
            this.createUserName,
            this.crmProjectInformationWarehousingId,
            this.biddingMethodId,
            this.biddingMethodName,
            this.crmBiddingRegulationsTypeEnum,
            this.tenderSubmissionMethodId,
            this.tenderSubmissionMethodName,
            this.bidExpirationDate,
            this.bidOpeningDate,
            this.bidEvaluationMethodId,
            this.bidEvaluationMethodName,
            this.isControlledBiddingPrice,
            this.controlledBiddingPrice,
            this.settlementMethodId,
            this.settlementMethodName,
            this.isTenderBond,
            this.tenderBond,
            this.tenderBondDeadline,
            this.companyName,
            this.depositBank,
            this.account,
            this.isCashDeposit,
            this.cashDeposit,
            this.typeOfPerformanceBondId,
            this.typeOfPerformanceBondName,
            this.warrantyRatio,
            this.warrantyDate,
            this.startDate,
            this.endDate,
            this.isMaterialAdjustment,
            this.materialAdjustment,
            this.materialBrandRegulations,
            this.isSpecialRulesForMaterials,
            this.specialRulesForMaterials,
            this.isOfferSample,
            this.offerSample,
            this.paymentMethod,
            this.biddingPlatformName,
            this.tenderRequirement,
            this.approveRecordId,
            this.attachmentDTOList,
            this.remark,
            this.businessProjectBidManagerQuote,
            this.businessProjectBidManagerEstimatedWorks,
            this.businessProjectBidManagerCost,
            this.businessProjectBidManagerGrossProfit,
            this.businessProjectBidManagerRemark,
            this.technologyBidManagerJobDescriptionId,
            this.technologyBidManagerJobDescriptionName,
            this.technologyBidManagerRenderings,
            this.technologyBidManagerStructureName,
            this.technologyBidManagerCompletion,
            this.technologyBidManagerBusinessTrip,
            this.technologyBidManagerCustomerReception,
            this.technologyBidManagerRemarks
         );
      }

      @Override
      public String toString() {
         return "CrmApplyForBidRecordDetailDTO.CrmApplyForBidRecordDetailDTOBuilder(id="
            + this.id
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", informantDateTime="
            + this.informantDateTime
            + ", projectName="
            + this.projectName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", createUserName="
            + this.createUserName
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", biddingMethodId="
            + this.biddingMethodId
            + ", biddingMethodName="
            + this.biddingMethodName
            + ", crmBiddingRegulationsTypeEnum="
            + this.crmBiddingRegulationsTypeEnum
            + ", tenderSubmissionMethodId="
            + this.tenderSubmissionMethodId
            + ", tenderSubmissionMethodName="
            + this.tenderSubmissionMethodName
            + ", bidExpirationDate="
            + this.bidExpirationDate
            + ", bidOpeningDate="
            + this.bidOpeningDate
            + ", bidEvaluationMethodId="
            + this.bidEvaluationMethodId
            + ", bidEvaluationMethodName="
            + this.bidEvaluationMethodName
            + ", isControlledBiddingPrice="
            + this.isControlledBiddingPrice
            + ", controlledBiddingPrice="
            + this.controlledBiddingPrice
            + ", settlementMethodId="
            + this.settlementMethodId
            + ", settlementMethodName="
            + this.settlementMethodName
            + ", isTenderBond="
            + this.isTenderBond
            + ", tenderBond="
            + this.tenderBond
            + ", tenderBondDeadline="
            + this.tenderBondDeadline
            + ", companyName="
            + this.companyName
            + ", depositBank="
            + this.depositBank
            + ", account="
            + this.account
            + ", isCashDeposit="
            + this.isCashDeposit
            + ", cashDeposit="
            + this.cashDeposit
            + ", typeOfPerformanceBondId="
            + this.typeOfPerformanceBondId
            + ", typeOfPerformanceBondName="
            + this.typeOfPerformanceBondName
            + ", warrantyRatio="
            + this.warrantyRatio
            + ", warrantyDate="
            + this.warrantyDate
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", isMaterialAdjustment="
            + this.isMaterialAdjustment
            + ", materialAdjustment="
            + this.materialAdjustment
            + ", materialBrandRegulations="
            + this.materialBrandRegulations
            + ", isSpecialRulesForMaterials="
            + this.isSpecialRulesForMaterials
            + ", specialRulesForMaterials="
            + this.specialRulesForMaterials
            + ", isOfferSample="
            + this.isOfferSample
            + ", offerSample="
            + this.offerSample
            + ", paymentMethod="
            + this.paymentMethod
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", tenderRequirement="
            + this.tenderRequirement
            + ", approveRecordId="
            + this.approveRecordId
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", remark="
            + this.remark
            + ", businessProjectBidManagerQuote="
            + this.businessProjectBidManagerQuote
            + ", businessProjectBidManagerEstimatedWorks="
            + this.businessProjectBidManagerEstimatedWorks
            + ", businessProjectBidManagerCost="
            + this.businessProjectBidManagerCost
            + ", businessProjectBidManagerGrossProfit="
            + this.businessProjectBidManagerGrossProfit
            + ", businessProjectBidManagerRemark="
            + this.businessProjectBidManagerRemark
            + ", technologyBidManagerJobDescriptionId="
            + this.technologyBidManagerJobDescriptionId
            + ", technologyBidManagerJobDescriptionName="
            + this.technologyBidManagerJobDescriptionName
            + ", technologyBidManagerRenderings="
            + this.technologyBidManagerRenderings
            + ", technologyBidManagerStructureName="
            + this.technologyBidManagerStructureName
            + ", technologyBidManagerCompletion="
            + this.technologyBidManagerCompletion
            + ", technologyBidManagerBusinessTrip="
            + this.technologyBidManagerBusinessTrip
            + ", technologyBidManagerCustomerReception="
            + this.technologyBidManagerCustomerReception
            + ", technologyBidManagerRemarks="
            + this.technologyBidManagerRemarks
            + ")";
      }
   }
}
