package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmApplyBusinessBiddingRecord对象", description = "投标申请(商务)")
@Entity
@TableName("crm_apply_business_bidding_record")
@Table(name = "crm_apply_business_bidding_record")
@org.hibernate.annotations.Table(appliesTo = "crm_apply_business_bidding_record", comment = "投标申请(商务)")
public class CrmApplyBusinessBiddingRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   @TableField("informant_user_id")
   @Column(name = "informant_user_id", columnDefinition = "bigint(20)  COMMENT '填报人id'", nullable = true)
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   @TableField("informant_user_name")
   @Column(name = "informant_user_name", columnDefinition = "varchar(255)  COMMENT '填报人名称'", nullable = true)
   private String informantUserName;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20)  COMMENT '所属部门'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '填报日期'", nullable = true)
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '项目备案id'", nullable = true)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "biddingMethodId", value = "招标方式id", notes = "招标方式id")
   @TableField("bidding_method_id")
   @Column(name = "bidding_method_id", columnDefinition = "bigint(20)  COMMENT '招标方式id'", nullable = true)
   private Long biddingMethodId;
   @ApiModelProperty(name = "crmBiddingRegulationsTypeEnum", value = "招标规定枚举", notes = "招标规定枚举")
   @TableField("crm_bidding_regulations_type_enum")
   @Column(name = "crm_bidding_regulations_type_enum", columnDefinition = "int(11)  COMMENT '招标规定枚举'", nullable = true)
   private Integer crmBiddingRegulationsTypeEnum;
   @ApiModelProperty(name = "tenderSubmissionMethodId", value = "标书交付方式", notes = "标书交付方式")
   @TableField("tender_submission_method_id")
   @Column(name = "tender_submission_method_id", columnDefinition = "bigint(20)  COMMENT '标书交付方式'", nullable = true)
   private Long tenderSubmissionMethodId;
   @ApiModelProperty(name = "bidExpirationDate", value = "投标截至日期", notes = "投标截至日期")
   @TableField("bid_expiration_date")
   @Column(name = "bid_expiration_date", columnDefinition = "datetime  COMMENT '投标截至日期'", nullable = true)
   private LocalDateTime bidExpirationDate;
   @ApiModelProperty(name = "bidOpeningDate", value = "开标日期", notes = "开标日期")
   @TableField("bid_opening_date")
   @Column(name = "bid_opening_date", columnDefinition = "datetime  COMMENT '开标日期'", nullable = true)
   private LocalDateTime bidOpeningDate;
   @ApiModelProperty(name = "bidEvaluationMethodId", value = "评标方式", notes = "评标方式")
   @TableField("bid_evaluation_method_id")
   @Column(name = "bid_evaluation_method_id", columnDefinition = "bigint(20)  COMMENT '评标方式'", nullable = true)
   private Long bidEvaluationMethodId;
   @ApiModelProperty(name = "controlledBiddingPrice", value = "招标控制价", notes = "招标控制价")
   @TableField("controlled_bidding_price")
   @Column(name = "controlled_bidding_price", columnDefinition = "decimal(20,2)  COMMENT '招标控制价'", nullable = true)
   private BigDecimal controlledBiddingPrice;
   @ApiModelProperty(name = "settlementMethodId", value = "结算方式", notes = "结算方式")
   @TableField("settlement_method_id")
   @Column(name = "settlement_method_id", columnDefinition = "bigint(20)  COMMENT '结算方式'", nullable = true)
   private Long settlementMethodId;
   @ApiModelProperty(name = "tenderBond", value = "投标保证金(万元)", notes = "投标保证金(万元)")
   @TableField("tender_bond")
   @Column(name = "tender_bond", columnDefinition = "decimal(20,2)  COMMENT '投标保证金(万元)'", nullable = true)
   private BigDecimal tenderBond;
   @ApiModelProperty(name = "tenderBondDeadline", value = "投标保证金截止日", notes = "投标保证金截止日")
   @TableField("tender_bond_deadline")
   @Column(name = "tender_bond_deadline", columnDefinition = "datetime  COMMENT '投标保证金截止日'", nullable = true)
   private LocalDateTime tenderBondDeadline;
   @ApiModelProperty(name = "companyName", value = "单位名称", notes = "单位名称")
   @TableField("company_name")
   @Column(name = "company_name", columnDefinition = "varchar(255)  COMMENT '单位名称'", nullable = true)
   private String companyName;
   @ApiModelProperty(name = "depositBank", value = "开户行", notes = "开户行")
   @TableField("deposit_bank")
   @Column(name = "deposit_bank", columnDefinition = "varchar(255)  COMMENT '开户行'", nullable = true)
   private String depositBank;
   @ApiModelProperty(name = "account", value = "银行账号", notes = "银行账号")
   @TableField("account")
   @Column(name = "account", columnDefinition = "varchar(255)  COMMENT '银行账号'", nullable = true)
   private String account;
   @ApiModelProperty(name = "cashDeposit", value = "履约保证金金额", notes = "履约保证金金额")
   @TableField("cash_deposit")
   @Column(name = "cash_deposit", columnDefinition = "decimal(20,2)  COMMENT '履约保证金金额'", nullable = true)
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "typeOfPerformanceBondId", value = "履约保证金类型", notes = "履约保证金类型")
   @TableField("type_of_performance_bond_id")
   @Column(name = "type_of_performance_bond_id", columnDefinition = "bigint(20)  COMMENT '履约保证金类型'", nullable = true)
   private Long typeOfPerformanceBondId;
   @ApiModelProperty(name = "warrantyRatio", value = "保修比例", notes = "保修比例")
   @TableField("warranty_ratio")
   @Column(name = "warranty_ratio", columnDefinition = "varchar(255)  COMMENT '保修比例'", nullable = true)
   private String warrantyRatio;
   @ApiModelProperty(name = "startDate", value = "计划开工日期", notes = "计划开工日期")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime  COMMENT '计划开工日期'", nullable = true)
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "计划完工日期", notes = "计划完工日期")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "datetime  COMMENT '计划完工日期'", nullable = true)
   private LocalDateTime endDate;
   @ApiModelProperty(name = "warrantyDate", value = "保修期限", notes = "保修期限")
   @TableField("warranty_date")
   @Column(name = "warranty_date", columnDefinition = "varchar(255)  COMMENT '保修期限'", nullable = true)
   private String warrantyDate;
   @ApiModelProperty(name = "materialAdjustment", value = "材料调差", notes = "材料调差")
   @TableField("material_adjustment")
   @Column(name = "material_adjustment", columnDefinition = "varchar(255)  COMMENT '材料调差'", nullable = true)
   private String materialAdjustment;
   @ApiModelProperty(name = "materialBrandRegulations", value = "材料品牌规定", notes = "材料品牌规定")
   @TableField("material_brand_regulations")
   @Column(name = "material_brand_regulations", columnDefinition = "varchar(255)  COMMENT '材料品牌规定'", nullable = true)
   private String materialBrandRegulations;
   @ApiModelProperty(name = "specialRulesForMaterials", value = "材料特殊规定", notes = "材料特殊规定")
   @TableField("special_rules_for_materials")
   @Column(name = "special_rules_for_materials", columnDefinition = "varchar(255)  COMMENT '材料特殊规定'", nullable = true)
   private String specialRulesForMaterials;
   @ApiModelProperty(name = "offerSample", value = "样品", notes = "样品")
   @TableField("offer_sample")
   @Column(name = "offer_sample", columnDefinition = "varchar(255)  COMMENT '样品'", nullable = true)
   private String offerSample;
   @ApiModelProperty(name = "paymentMethod", value = "付款方式", notes = "付款方式")
   @TableField("payment_method")
   @Column(name = "payment_method", columnDefinition = "varchar(255)  COMMENT '付款方式'", nullable = true)
   private String paymentMethod;
   @ApiModelProperty(name = "attachmentIds", value = "附件id集合", notes = "附件id集合")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id集合'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态", notes = "审核状态")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "projectBidManagerUserId", value = "项目投标负责人", notes = "项目投标负责人")
   @TableField("project_bid_manager_user_id")
   @Column(name = "project_bid_manager_user_id", columnDefinition = "varchar(255)  COMMENT '项目投标负责人'", nullable = true)
   private String projectBidManagerUserId;
   @ApiModelProperty(name = "projectBidManagerFinishDate", value = "投标完成时间", notes = "投标完成时间")
   @TableField("project_bid_manager_finish_date")
   @Column(name = "project_bid_manager_finish_date", columnDefinition = "datetime  COMMENT '投标完成时间'", nullable = true)
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "difficultyFactorId", value = "难度系数", notes = "设计难度系数")
   @TableField("difficulty_factor_id")
   @Column(name = "difficulty_factor_id", columnDefinition = "bigint(20)  COMMENT '难度系数'", nullable = true)
   private Long difficultyFactorId;
   @ApiModelProperty(name = "bidManagerAttachmentIds", value = "投标附件", notes = "投标附件")
   @TableField("bid_manager_attachment_ids")
   @Column(name = "bid_manager_attachment_ids", columnDefinition = "varchar(255)  COMMENT '投标附件'", nullable = true)
   private String bidManagerAttachmentIds;
   @ApiModelProperty(name = "crmProjectBidStatus", value = "投标状态", notes = "投标状态")
   @TableField("crm_project_bid_status")
   @Column(name = "crm_project_bid_status", columnDefinition = "int(11) default '1' COMMENT '投标状态'", nullable = true)
   private Integer crmProjectBidStatus;
   @ApiModelProperty(name = "businessProjectBidManagerQuote", value = "商务投标报价", notes = "商务投标报价")
   @TableField("business_project_bid_manager_quote")
   @Column(name = "business_project_bid_manager_quote", columnDefinition = "decimal(10,2)  COMMENT '商务投标报价'", nullable = true)
   private BigDecimal businessProjectBidManagerQuote;
   @ApiModelProperty(name = "businessProjectBidManagerEstimatedWorks", value = "商务工程量", notes = "商务工程量")
   @TableField("business_project_bid_manager_estimated_works")
   @Column(name = "business_project_bid_manager_estimated_works", columnDefinition = "decimal(10,2)  COMMENT '商务工程量'", nullable = true)
   private BigDecimal businessProjectBidManagerEstimatedWorks;
   @ApiModelProperty(name = "businessProjectBidManagerCost", value = "商务成本", notes = "商务成本")
   @TableField("business_project_bid_manager_cost")
   @Column(name = "business_project_bid_manager_cost", columnDefinition = "decimal(10,2)  COMMENT '商务成本'", nullable = true)
   private BigDecimal businessProjectBidManagerCost;
   @ApiModelProperty(name = "businessProjectBidManagerGrossProfit", value = "商务毛利", notes = "商务毛利")
   @TableField("business_project_bid_manager_gross_profit")
   @Column(name = "business_project_bid_manager_gross_profit", columnDefinition = "decimal(10,2)  COMMENT '商务毛利'", nullable = true)
   private BigDecimal businessProjectBidManagerGrossProfit;
   @ApiModelProperty(name = "businessProjectBidManagerRemark", value = "商务投标备注", notes = "商务投标备注")
   @TableField("business_project_bid_manager_remark")
   @Column(name = "business_project_bid_manager_remark", columnDefinition = "varchar(1024)  COMMENT '商务投标备注'", nullable = true)
   private String businessProjectBidManagerRemark;
   @ApiModelProperty(name = "businessProjectBidManagerActualFinishDate", value = "商务投标实际完成时间", notes = "商务投标实际完成时间")
   @TableField("business_project_bid_manager_actual_finish_date")
   @Column(name = "business_project_bid_manager_actual_finish_date", columnDefinition = "datetime  COMMENT '商务投标实际完成时间'", nullable = true)
   private LocalDateTime businessProjectBidManagerActualFinishDate;

   public static CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder builder() {
      return new CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder();
   }

   public CrmApplyBusinessBiddingRecord() {
   }

   public CrmApplyBusinessBiddingRecord(
      final Long id,
      final Long informantUserId,
      final String informantUserName,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final Long createUserId,
      final Long crmProjectInformationWarehousingId,
      final Long biddingMethodId,
      final Integer crmBiddingRegulationsTypeEnum,
      final Long tenderSubmissionMethodId,
      final LocalDateTime bidExpirationDate,
      final LocalDateTime bidOpeningDate,
      final Long bidEvaluationMethodId,
      final BigDecimal controlledBiddingPrice,
      final Long settlementMethodId,
      final BigDecimal tenderBond,
      final LocalDateTime tenderBondDeadline,
      final String companyName,
      final String depositBank,
      final String account,
      final BigDecimal cashDeposit,
      final Long typeOfPerformanceBondId,
      final String warrantyRatio,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final String warrantyDate,
      final String materialAdjustment,
      final String materialBrandRegulations,
      final String specialRulesForMaterials,
      final String offerSample,
      final String paymentMethod,
      final String attachmentIds,
      final String remark,
      final Integer crmCheckStatusEnum,
      final Long approveRecordId,
      final String projectBidManagerUserId,
      final LocalDateTime projectBidManagerFinishDate,
      final Long difficultyFactorId,
      final String bidManagerAttachmentIds,
      final Integer crmProjectBidStatus,
      final BigDecimal businessProjectBidManagerQuote,
      final BigDecimal businessProjectBidManagerEstimatedWorks,
      final BigDecimal businessProjectBidManagerCost,
      final BigDecimal businessProjectBidManagerGrossProfit,
      final String businessProjectBidManagerRemark,
      final LocalDateTime businessProjectBidManagerActualFinishDate
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.createUserId = createUserId;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.biddingMethodId = biddingMethodId;
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
      this.bidExpirationDate = bidExpirationDate;
      this.bidOpeningDate = bidOpeningDate;
      this.bidEvaluationMethodId = bidEvaluationMethodId;
      this.controlledBiddingPrice = controlledBiddingPrice;
      this.settlementMethodId = settlementMethodId;
      this.tenderBond = tenderBond;
      this.tenderBondDeadline = tenderBondDeadline;
      this.companyName = companyName;
      this.depositBank = depositBank;
      this.account = account;
      this.cashDeposit = cashDeposit;
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
      this.warrantyRatio = warrantyRatio;
      this.startDate = startDate;
      this.endDate = endDate;
      this.warrantyDate = warrantyDate;
      this.materialAdjustment = materialAdjustment;
      this.materialBrandRegulations = materialBrandRegulations;
      this.specialRulesForMaterials = specialRulesForMaterials;
      this.offerSample = offerSample;
      this.paymentMethod = paymentMethod;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.approveRecordId = approveRecordId;
      this.projectBidManagerUserId = projectBidManagerUserId;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      this.difficultyFactorId = difficultyFactorId;
      this.bidManagerAttachmentIds = bidManagerAttachmentIds;
      this.crmProjectBidStatus = crmProjectBidStatus;
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      this.businessProjectBidManagerActualFinishDate = businessProjectBidManagerActualFinishDate;
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

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Long getBiddingMethodId() {
      return this.biddingMethodId;
   }

   public Integer getCrmBiddingRegulationsTypeEnum() {
      return this.crmBiddingRegulationsTypeEnum;
   }

   public Long getTenderSubmissionMethodId() {
      return this.tenderSubmissionMethodId;
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

   public BigDecimal getControlledBiddingPrice() {
      return this.controlledBiddingPrice;
   }

   public Long getSettlementMethodId() {
      return this.settlementMethodId;
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

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Long getTypeOfPerformanceBondId() {
      return this.typeOfPerformanceBondId;
   }

   public String getWarrantyRatio() {
      return this.warrantyRatio;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public String getWarrantyDate() {
      return this.warrantyDate;
   }

   public String getMaterialAdjustment() {
      return this.materialAdjustment;
   }

   public String getMaterialBrandRegulations() {
      return this.materialBrandRegulations;
   }

   public String getSpecialRulesForMaterials() {
      return this.specialRulesForMaterials;
   }

   public String getOfferSample() {
      return this.offerSample;
   }

   public String getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getProjectBidManagerUserId() {
      return this.projectBidManagerUserId;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public Long getDifficultyFactorId() {
      return this.difficultyFactorId;
   }

   public String getBidManagerAttachmentIds() {
      return this.bidManagerAttachmentIds;
   }

   public Integer getCrmProjectBidStatus() {
      return this.crmProjectBidStatus;
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

   public LocalDateTime getBusinessProjectBidManagerActualFinishDate() {
      return this.businessProjectBidManagerActualFinishDate;
   }

   public CrmApplyBusinessBiddingRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCrmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setTenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBidExpirationDate(final LocalDateTime bidExpirationDate) {
      this.bidExpirationDate = bidExpirationDate;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBidOpeningDate(final LocalDateTime bidOpeningDate) {
      this.bidOpeningDate = bidOpeningDate;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBidEvaluationMethodId(final Long bidEvaluationMethodId) {
      this.bidEvaluationMethodId = bidEvaluationMethodId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setControlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
      this.controlledBiddingPrice = controlledBiddingPrice;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setSettlementMethodId(final Long settlementMethodId) {
      this.settlementMethodId = settlementMethodId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setTenderBond(final BigDecimal tenderBond) {
      this.tenderBond = tenderBond;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setTenderBondDeadline(final LocalDateTime tenderBondDeadline) {
      this.tenderBondDeadline = tenderBondDeadline;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setAccount(final String account) {
      this.account = account;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setTypeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setWarrantyRatio(final String warrantyRatio) {
      this.warrantyRatio = warrantyRatio;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setWarrantyDate(final String warrantyDate) {
      this.warrantyDate = warrantyDate;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setMaterialAdjustment(final String materialAdjustment) {
      this.materialAdjustment = materialAdjustment;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setMaterialBrandRegulations(final String materialBrandRegulations) {
      this.materialBrandRegulations = materialBrandRegulations;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setSpecialRulesForMaterials(final String specialRulesForMaterials) {
      this.specialRulesForMaterials = specialRulesForMaterials;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setOfferSample(final String offerSample) {
      this.offerSample = offerSample;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setProjectBidManagerUserId(final String projectBidManagerUserId) {
      this.projectBidManagerUserId = projectBidManagerUserId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBidManagerAttachmentIds(final String bidManagerAttachmentIds) {
      this.bidManagerAttachmentIds = bidManagerAttachmentIds;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setCrmProjectBidStatus(final Integer crmProjectBidStatus) {
      this.crmProjectBidStatus = crmProjectBidStatus;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBusinessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBusinessProjectBidManagerEstimatedWorks(final BigDecimal businessProjectBidManagerEstimatedWorks) {
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBusinessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBusinessProjectBidManagerGrossProfit(final BigDecimal businessProjectBidManagerGrossProfit) {
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBusinessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      return this;
   }

   public CrmApplyBusinessBiddingRecord setBusinessProjectBidManagerActualFinishDate(final LocalDateTime businessProjectBidManagerActualFinishDate) {
      this.businessProjectBidManagerActualFinishDate = businessProjectBidManagerActualFinishDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmApplyBusinessBiddingRecord(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", biddingMethodId="
         + this.getBiddingMethodId()
         + ", crmBiddingRegulationsTypeEnum="
         + this.getCrmBiddingRegulationsTypeEnum()
         + ", tenderSubmissionMethodId="
         + this.getTenderSubmissionMethodId()
         + ", bidExpirationDate="
         + this.getBidExpirationDate()
         + ", bidOpeningDate="
         + this.getBidOpeningDate()
         + ", bidEvaluationMethodId="
         + this.getBidEvaluationMethodId()
         + ", controlledBiddingPrice="
         + this.getControlledBiddingPrice()
         + ", settlementMethodId="
         + this.getSettlementMethodId()
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
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", typeOfPerformanceBondId="
         + this.getTypeOfPerformanceBondId()
         + ", warrantyRatio="
         + this.getWarrantyRatio()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", warrantyDate="
         + this.getWarrantyDate()
         + ", materialAdjustment="
         + this.getMaterialAdjustment()
         + ", materialBrandRegulations="
         + this.getMaterialBrandRegulations()
         + ", specialRulesForMaterials="
         + this.getSpecialRulesForMaterials()
         + ", offerSample="
         + this.getOfferSample()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", projectBidManagerUserId="
         + this.getProjectBidManagerUserId()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", difficultyFactorId="
         + this.getDifficultyFactorId()
         + ", bidManagerAttachmentIds="
         + this.getBidManagerAttachmentIds()
         + ", crmProjectBidStatus="
         + this.getCrmProjectBidStatus()
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
         + ", businessProjectBidManagerActualFinishDate="
         + this.getBusinessProjectBidManagerActualFinishDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmApplyBusinessBiddingRecord)) {
         return false;
      }

      CrmApplyBusinessBiddingRecord other = (CrmApplyBusinessBiddingRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
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
                                 Object this$settlementMethodId = this.getSettlementMethodId();
                                 Object other$settlementMethodId = other.getSettlementMethodId();
                                 if (this$settlementMethodId == null
                                    ? other$settlementMethodId == null
                                    : this$settlementMethodId.equals(other$settlementMethodId)) {
                                    Object this$typeOfPerformanceBondId = this.getTypeOfPerformanceBondId();
                                    Object other$typeOfPerformanceBondId = other.getTypeOfPerformanceBondId();
                                    if (this$typeOfPerformanceBondId == null
                                       ? other$typeOfPerformanceBondId == null
                                       : this$typeOfPerformanceBondId.equals(other$typeOfPerformanceBondId)) {
                                       Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                                       Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                                       if (this$crmCheckStatusEnum == null
                                          ? other$crmCheckStatusEnum == null
                                          : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                                          Object this$approveRecordId = this.getApproveRecordId();
                                          Object other$approveRecordId = other.getApproveRecordId();
                                          if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)
                                             )
                                           {
                                             Object this$difficultyFactorId = this.getDifficultyFactorId();
                                             Object other$difficultyFactorId = other.getDifficultyFactorId();
                                             if (this$difficultyFactorId == null
                                                ? other$difficultyFactorId == null
                                                : this$difficultyFactorId.equals(other$difficultyFactorId)) {
                                                Object this$crmProjectBidStatus = this.getCrmProjectBidStatus();
                                                Object other$crmProjectBidStatus = other.getCrmProjectBidStatus();
                                                if (this$crmProjectBidStatus == null
                                                   ? other$crmProjectBidStatus == null
                                                   : this$crmProjectBidStatus.equals(other$crmProjectBidStatus)) {
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
                                                               Object this$controlledBiddingPrice = this.getControlledBiddingPrice();
                                                               Object other$controlledBiddingPrice = other.getControlledBiddingPrice();
                                                               if (this$controlledBiddingPrice == null
                                                                  ? other$controlledBiddingPrice == null
                                                                  : this$controlledBiddingPrice.equals(other$controlledBiddingPrice)) {
                                                                  Object this$tenderBond = this.getTenderBond();
                                                                  Object other$tenderBond = other.getTenderBond();
                                                                  if (this$tenderBond == null
                                                                     ? other$tenderBond == null
                                                                     : this$tenderBond.equals(other$tenderBond)) {
                                                                     Object this$tenderBondDeadline = this.getTenderBondDeadline();
                                                                     Object other$tenderBondDeadline = other.getTenderBondDeadline();
                                                                     if (this$tenderBondDeadline == null
                                                                        ? other$tenderBondDeadline == null
                                                                        : this$tenderBondDeadline.equals(other$tenderBondDeadline)) {
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
                                                                                    : this$cashDeposit.equals(other$cashDeposit)) {
                                                                                    Object this$warrantyRatio = this.getWarrantyRatio();
                                                                                    Object other$warrantyRatio = other.getWarrantyRatio();
                                                                                    if (this$warrantyRatio == null
                                                                                       ? other$warrantyRatio == null
                                                                                       : this$warrantyRatio.equals(other$warrantyRatio)) {
                                                                                       Object this$startDate = this.getStartDate();
                                                                                       Object other$startDate = other.getStartDate();
                                                                                       if (this$startDate == null
                                                                                          ? other$startDate == null
                                                                                          : this$startDate.equals(other$startDate)) {
                                                                                          Object this$endDate = this.getEndDate();
                                                                                          Object other$endDate = other.getEndDate();
                                                                                          if (this$endDate == null
                                                                                             ? other$endDate == null
                                                                                             : this$endDate.equals(other$endDate)) {
                                                                                             Object this$warrantyDate = this.getWarrantyDate();
                                                                                             Object other$warrantyDate = other.getWarrantyDate();
                                                                                             if (this$warrantyDate == null
                                                                                                ? other$warrantyDate == null
                                                                                                : this$warrantyDate.equals(other$warrantyDate)) {
                                                                                                Object this$materialAdjustment = this.getMaterialAdjustment();
                                                                                                Object other$materialAdjustment = other.getMaterialAdjustment();
                                                                                                if (this$materialAdjustment == null
                                                                                                   ? other$materialAdjustment == null
                                                                                                   : this$materialAdjustment.equals(other$materialAdjustment)) {
                                                                                                   Object this$materialBrandRegulations = this.getMaterialBrandRegulations();
                                                                                                   Object other$materialBrandRegulations = other.getMaterialBrandRegulations();
                                                                                                   if (this$materialBrandRegulations == null
                                                                                                      ? other$materialBrandRegulations == null
                                                                                                      : this$materialBrandRegulations.equals(
                                                                                                         other$materialBrandRegulations
                                                                                                      )) {
                                                                                                      Object this$specialRulesForMaterials = this.getSpecialRulesForMaterials();
                                                                                                      Object other$specialRulesForMaterials = other.getSpecialRulesForMaterials();
                                                                                                      if (this$specialRulesForMaterials == null
                                                                                                         ? other$specialRulesForMaterials == null
                                                                                                         : this$specialRulesForMaterials.equals(
                                                                                                            other$specialRulesForMaterials
                                                                                                         )) {
                                                                                                         Object this$offerSample = this.getOfferSample();
                                                                                                         Object other$offerSample = other.getOfferSample();
                                                                                                         if (this$offerSample == null
                                                                                                            ? other$offerSample == null
                                                                                                            : this$offerSample.equals(other$offerSample)) {
                                                                                                            Object this$paymentMethod = this.getPaymentMethod();
                                                                                                            Object other$paymentMethod = other.getPaymentMethod();
                                                                                                            if (this$paymentMethod == null
                                                                                                               ? other$paymentMethod == null
                                                                                                               : this$paymentMethod.equals(other$paymentMethod)
                                                                                                               )
                                                                                                             {
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
                                                                                                                     Object this$projectBidManagerUserId = this.getProjectBidManagerUserId();
                                                                                                                     Object other$projectBidManagerUserId = other.getProjectBidManagerUserId();
                                                                                                                     if (this$projectBidManagerUserId == null
                                                                                                                        ? other$projectBidManagerUserId == null
                                                                                                                        : this$projectBidManagerUserId.equals(
                                                                                                                           other$projectBidManagerUserId
                                                                                                                        )) {
                                                                                                                        Object this$projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
                                                                                                                        Object other$projectBidManagerFinishDate = other.getProjectBidManagerFinishDate();
                                                                                                                        if (this$projectBidManagerFinishDate
                                                                                                                              == null
                                                                                                                           ? other$projectBidManagerFinishDate
                                                                                                                              == null
                                                                                                                           : this$projectBidManagerFinishDate.equals(
                                                                                                                              other$projectBidManagerFinishDate
                                                                                                                           )) {
                                                                                                                           Object this$bidManagerAttachmentIds = this.getBidManagerAttachmentIds();
                                                                                                                           Object other$bidManagerAttachmentIds = other.getBidManagerAttachmentIds();
                                                                                                                           if (this$bidManagerAttachmentIds
                                                                                                                                 == null
                                                                                                                              ? other$bidManagerAttachmentIds
                                                                                                                                 == null
                                                                                                                              : this$bidManagerAttachmentIds.equals(
                                                                                                                                 other$bidManagerAttachmentIds
                                                                                                                              )) {
                                                                                                                              Object this$businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
                                                                                                                              Object other$businessProjectBidManagerQuote = other.getBusinessProjectBidManagerQuote();
                                                                                                                              if (this$businessProjectBidManagerQuote
                                                                                                                                    == null
                                                                                                                                 ? other$businessProjectBidManagerQuote
                                                                                                                                    == null
                                                                                                                                 : this$businessProjectBidManagerQuote.equals(
                                                                                                                                    other$businessProjectBidManagerQuote
                                                                                                                                 )) {
                                                                                                                                 Object this$businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
                                                                                                                                 Object other$businessProjectBidManagerEstimatedWorks = other.getBusinessProjectBidManagerEstimatedWorks();
                                                                                                                                 if (this$businessProjectBidManagerEstimatedWorks
                                                                                                                                       == null
                                                                                                                                    ? other$businessProjectBidManagerEstimatedWorks
                                                                                                                                       == null
                                                                                                                                    : this$businessProjectBidManagerEstimatedWorks.equals(
                                                                                                                                       other$businessProjectBidManagerEstimatedWorks
                                                                                                                                    )) {
                                                                                                                                    Object this$businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
                                                                                                                                    Object other$businessProjectBidManagerCost = other.getBusinessProjectBidManagerCost();
                                                                                                                                    if (this$businessProjectBidManagerCost
                                                                                                                                          == null
                                                                                                                                       ? other$businessProjectBidManagerCost
                                                                                                                                          == null
                                                                                                                                       : this$businessProjectBidManagerCost.equals(
                                                                                                                                          other$businessProjectBidManagerCost
                                                                                                                                       )) {
                                                                                                                                       Object this$businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
                                                                                                                                       Object other$businessProjectBidManagerGrossProfit = other.getBusinessProjectBidManagerGrossProfit();
                                                                                                                                       if (this$businessProjectBidManagerGrossProfit
                                                                                                                                             == null
                                                                                                                                          ? other$businessProjectBidManagerGrossProfit
                                                                                                                                             == null
                                                                                                                                          : this$businessProjectBidManagerGrossProfit.equals(
                                                                                                                                             other$businessProjectBidManagerGrossProfit
                                                                                                                                          )) {
                                                                                                                                          Object this$businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
                                                                                                                                          Object other$businessProjectBidManagerRemark = other.getBusinessProjectBidManagerRemark();
                                                                                                                                          if (this$businessProjectBidManagerRemark
                                                                                                                                                == null
                                                                                                                                             ? other$businessProjectBidManagerRemark
                                                                                                                                                == null
                                                                                                                                             : this$businessProjectBidManagerRemark.equals(
                                                                                                                                                other$businessProjectBidManagerRemark
                                                                                                                                             )) {
                                                                                                                                             Object this$businessProjectBidManagerActualFinishDate = this.getBusinessProjectBidManagerActualFinishDate();
                                                                                                                                             Object other$businessProjectBidManagerActualFinishDate = other.getBusinessProjectBidManagerActualFinishDate();
                                                                                                                                             return this$businessProjectBidManagerActualFinishDate
                                                                                                                                                   == null
                                                                                                                                                ? other$businessProjectBidManagerActualFinishDate
                                                                                                                                                   == null
                                                                                                                                                : this$businessProjectBidManagerActualFinishDate.equals(
                                                                                                                                                   other$businessProjectBidManagerActualFinishDate
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmApplyBusinessBiddingRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
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
      Object $settlementMethodId = this.getSettlementMethodId();
      result = result * 59 + ($settlementMethodId == null ? 43 : $settlementMethodId.hashCode());
      Object $typeOfPerformanceBondId = this.getTypeOfPerformanceBondId();
      result = result * 59 + ($typeOfPerformanceBondId == null ? 43 : $typeOfPerformanceBondId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $difficultyFactorId = this.getDifficultyFactorId();
      result = result * 59 + ($difficultyFactorId == null ? 43 : $difficultyFactorId.hashCode());
      Object $crmProjectBidStatus = this.getCrmProjectBidStatus();
      result = result * 59 + ($crmProjectBidStatus == null ? 43 : $crmProjectBidStatus.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $bidExpirationDate = this.getBidExpirationDate();
      result = result * 59 + ($bidExpirationDate == null ? 43 : $bidExpirationDate.hashCode());
      Object $bidOpeningDate = this.getBidOpeningDate();
      result = result * 59 + ($bidOpeningDate == null ? 43 : $bidOpeningDate.hashCode());
      Object $controlledBiddingPrice = this.getControlledBiddingPrice();
      result = result * 59 + ($controlledBiddingPrice == null ? 43 : $controlledBiddingPrice.hashCode());
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
      Object $warrantyRatio = this.getWarrantyRatio();
      result = result * 59 + ($warrantyRatio == null ? 43 : $warrantyRatio.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $warrantyDate = this.getWarrantyDate();
      result = result * 59 + ($warrantyDate == null ? 43 : $warrantyDate.hashCode());
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
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $projectBidManagerUserId = this.getProjectBidManagerUserId();
      result = result * 59 + ($projectBidManagerUserId == null ? 43 : $projectBidManagerUserId.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $bidManagerAttachmentIds = this.getBidManagerAttachmentIds();
      result = result * 59 + ($bidManagerAttachmentIds == null ? 43 : $bidManagerAttachmentIds.hashCode());
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
      Object $businessProjectBidManagerActualFinishDate = this.getBusinessProjectBidManagerActualFinishDate();
      return result * 59 + ($businessProjectBidManagerActualFinishDate == null ? 43 : $businessProjectBidManagerActualFinishDate.hashCode());
   }

   public static class CrmApplyBusinessBiddingRecordBuilder {
      private Long id;
      private Long informantUserId;
      private String informantUserName;
      private Long departmentId;
      private LocalDateTime informantDateTime;
      private Long createUserId;
      private Long crmProjectInformationWarehousingId;
      private Long biddingMethodId;
      private Integer crmBiddingRegulationsTypeEnum;
      private Long tenderSubmissionMethodId;
      private LocalDateTime bidExpirationDate;
      private LocalDateTime bidOpeningDate;
      private Long bidEvaluationMethodId;
      private BigDecimal controlledBiddingPrice;
      private Long settlementMethodId;
      private BigDecimal tenderBond;
      private LocalDateTime tenderBondDeadline;
      private String companyName;
      private String depositBank;
      private String account;
      private BigDecimal cashDeposit;
      private Long typeOfPerformanceBondId;
      private String warrantyRatio;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private String warrantyDate;
      private String materialAdjustment;
      private String materialBrandRegulations;
      private String specialRulesForMaterials;
      private String offerSample;
      private String paymentMethod;
      private String attachmentIds;
      private String remark;
      private Integer crmCheckStatusEnum;
      private Long approveRecordId;
      private String projectBidManagerUserId;
      private LocalDateTime projectBidManagerFinishDate;
      private Long difficultyFactorId;
      private String bidManagerAttachmentIds;
      private Integer crmProjectBidStatus;
      private BigDecimal businessProjectBidManagerQuote;
      private BigDecimal businessProjectBidManagerEstimatedWorks;
      private BigDecimal businessProjectBidManagerCost;
      private BigDecimal businessProjectBidManagerGrossProfit;
      private String businessProjectBidManagerRemark;
      private LocalDateTime businessProjectBidManagerActualFinishDate;

      CrmApplyBusinessBiddingRecordBuilder() {
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder biddingMethodId(final Long biddingMethodId) {
         this.biddingMethodId = biddingMethodId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder crmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
         this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder tenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
         this.tenderSubmissionMethodId = tenderSubmissionMethodId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder bidExpirationDate(final LocalDateTime bidExpirationDate) {
         this.bidExpirationDate = bidExpirationDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder bidOpeningDate(final LocalDateTime bidOpeningDate) {
         this.bidOpeningDate = bidOpeningDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder bidEvaluationMethodId(final Long bidEvaluationMethodId) {
         this.bidEvaluationMethodId = bidEvaluationMethodId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder controlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
         this.controlledBiddingPrice = controlledBiddingPrice;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder settlementMethodId(final Long settlementMethodId) {
         this.settlementMethodId = settlementMethodId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder tenderBond(final BigDecimal tenderBond) {
         this.tenderBond = tenderBond;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder tenderBondDeadline(final LocalDateTime tenderBondDeadline) {
         this.tenderBondDeadline = tenderBondDeadline;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder account(final String account) {
         this.account = account;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder typeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
         this.typeOfPerformanceBondId = typeOfPerformanceBondId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder warrantyRatio(final String warrantyRatio) {
         this.warrantyRatio = warrantyRatio;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder warrantyDate(final String warrantyDate) {
         this.warrantyDate = warrantyDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder materialAdjustment(final String materialAdjustment) {
         this.materialAdjustment = materialAdjustment;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder materialBrandRegulations(final String materialBrandRegulations) {
         this.materialBrandRegulations = materialBrandRegulations;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder specialRulesForMaterials(final String specialRulesForMaterials) {
         this.specialRulesForMaterials = specialRulesForMaterials;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder offerSample(final String offerSample) {
         this.offerSample = offerSample;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder projectBidManagerUserId(final String projectBidManagerUserId) {
         this.projectBidManagerUserId = projectBidManagerUserId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder difficultyFactorId(final Long difficultyFactorId) {
         this.difficultyFactorId = difficultyFactorId;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder bidManagerAttachmentIds(final String bidManagerAttachmentIds) {
         this.bidManagerAttachmentIds = bidManagerAttachmentIds;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder crmProjectBidStatus(final Integer crmProjectBidStatus) {
         this.crmProjectBidStatus = crmProjectBidStatus;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder businessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
         this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder businessProjectBidManagerEstimatedWorks(
         final BigDecimal businessProjectBidManagerEstimatedWorks
      ) {
         this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder businessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
         this.businessProjectBidManagerCost = businessProjectBidManagerCost;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder businessProjectBidManagerGrossProfit(
         final BigDecimal businessProjectBidManagerGrossProfit
      ) {
         this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder businessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
         this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
         return this;
      }

      public CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder businessProjectBidManagerActualFinishDate(
         final LocalDateTime businessProjectBidManagerActualFinishDate
      ) {
         this.businessProjectBidManagerActualFinishDate = businessProjectBidManagerActualFinishDate;
         return this;
      }

      public CrmApplyBusinessBiddingRecord build() {
         return new CrmApplyBusinessBiddingRecord(
            this.id,
            this.informantUserId,
            this.informantUserName,
            this.departmentId,
            this.informantDateTime,
            this.createUserId,
            this.crmProjectInformationWarehousingId,
            this.biddingMethodId,
            this.crmBiddingRegulationsTypeEnum,
            this.tenderSubmissionMethodId,
            this.bidExpirationDate,
            this.bidOpeningDate,
            this.bidEvaluationMethodId,
            this.controlledBiddingPrice,
            this.settlementMethodId,
            this.tenderBond,
            this.tenderBondDeadline,
            this.companyName,
            this.depositBank,
            this.account,
            this.cashDeposit,
            this.typeOfPerformanceBondId,
            this.warrantyRatio,
            this.startDate,
            this.endDate,
            this.warrantyDate,
            this.materialAdjustment,
            this.materialBrandRegulations,
            this.specialRulesForMaterials,
            this.offerSample,
            this.paymentMethod,
            this.attachmentIds,
            this.remark,
            this.crmCheckStatusEnum,
            this.approveRecordId,
            this.projectBidManagerUserId,
            this.projectBidManagerFinishDate,
            this.difficultyFactorId,
            this.bidManagerAttachmentIds,
            this.crmProjectBidStatus,
            this.businessProjectBidManagerQuote,
            this.businessProjectBidManagerEstimatedWorks,
            this.businessProjectBidManagerCost,
            this.businessProjectBidManagerGrossProfit,
            this.businessProjectBidManagerRemark,
            this.businessProjectBidManagerActualFinishDate
         );
      }

      @Override
      public String toString() {
         return "CrmApplyBusinessBiddingRecord.CrmApplyBusinessBiddingRecordBuilder(id="
            + this.id
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", departmentId="
            + this.departmentId
            + ", informantDateTime="
            + this.informantDateTime
            + ", createUserId="
            + this.createUserId
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", biddingMethodId="
            + this.biddingMethodId
            + ", crmBiddingRegulationsTypeEnum="
            + this.crmBiddingRegulationsTypeEnum
            + ", tenderSubmissionMethodId="
            + this.tenderSubmissionMethodId
            + ", bidExpirationDate="
            + this.bidExpirationDate
            + ", bidOpeningDate="
            + this.bidOpeningDate
            + ", bidEvaluationMethodId="
            + this.bidEvaluationMethodId
            + ", controlledBiddingPrice="
            + this.controlledBiddingPrice
            + ", settlementMethodId="
            + this.settlementMethodId
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
            + ", cashDeposit="
            + this.cashDeposit
            + ", typeOfPerformanceBondId="
            + this.typeOfPerformanceBondId
            + ", warrantyRatio="
            + this.warrantyRatio
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", warrantyDate="
            + this.warrantyDate
            + ", materialAdjustment="
            + this.materialAdjustment
            + ", materialBrandRegulations="
            + this.materialBrandRegulations
            + ", specialRulesForMaterials="
            + this.specialRulesForMaterials
            + ", offerSample="
            + this.offerSample
            + ", paymentMethod="
            + this.paymentMethod
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", approveRecordId="
            + this.approveRecordId
            + ", projectBidManagerUserId="
            + this.projectBidManagerUserId
            + ", projectBidManagerFinishDate="
            + this.projectBidManagerFinishDate
            + ", difficultyFactorId="
            + this.difficultyFactorId
            + ", bidManagerAttachmentIds="
            + this.bidManagerAttachmentIds
            + ", crmProjectBidStatus="
            + this.crmProjectBidStatus
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
            + ", businessProjectBidManagerActualFinishDate="
            + this.businessProjectBidManagerActualFinishDate
            + ")";
      }
   }
}
