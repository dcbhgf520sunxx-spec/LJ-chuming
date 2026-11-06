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

@ApiModel(value = "CrmApplyTechnologyBiddingRecord对象", description = "投标申请(技术)")
@Entity
@TableName("crm_apply_technology_bidding_record")
@Table(name = "crm_apply_technology_bidding_record")
@org.hibernate.annotations.Table(appliesTo = "crm_apply_technology_bidding_record", comment = "投标申请(技术)")
public class CrmApplyTechnologyBiddingRecord extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "technologyBidManagerJobDescriptionId", value = "技术投标工作内容", notes = "技术投标工作内容")
   @TableField("technology_bid_manager_job_description_id")
   @Column(name = "technology_bid_manager_job_description_id", columnDefinition = "bigint(20)  COMMENT '技术投标工作内容 参考投标申请配置'", nullable = true)
   private Long technologyBidManagerJobDescriptionId;
   @ApiModelProperty(name = "technologyBidManagerRenderings", value = "技术投标效果图", notes = "技术投标效果图")
   @TableField("technology_bid_manager_renderings")
   @Column(name = "technology_bid_manager_renderings", columnDefinition = "varchar(255)  COMMENT '技术投标效果图'", nullable = true)
   private String technologyBidManagerRenderings;
   @ApiModelProperty(name = "technologyBidManagerStructureName", value = "技术投标结构名称", notes = "技术投标结构名称")
   @TableField("technology_bid_manager_structure_name")
   @Column(name = "technology_bid_manager_structure_name", columnDefinition = "varchar(255)  COMMENT '技术投标结构名称'", nullable = true)
   private String technologyBidManagerStructureName;
   @ApiModelProperty(name = "technologyBidManagerCompletion", value = "技术投标完成情况", notes = "技术投标完成情况")
   @TableField("technology_bid_manager_completion")
   @Column(name = "technology_bid_manager_completion", columnDefinition = "varchar(255)  COMMENT '技术投标完成情况'", nullable = true)
   private String technologyBidManagerCompletion;
   @ApiModelProperty(name = "technologyBidManagerBusinessTrip", value = "技术投标出差", notes = "技术投标出差")
   @TableField("technology_bid_manager_business_trip")
   @Column(name = "technology_bid_manager_business_trip", columnDefinition = "varchar(255)  COMMENT '技术投标出差'", nullable = true)
   private String technologyBidManagerBusinessTrip;
   @ApiModelProperty(name = "technologyBidManagerCustomerReception", value = "技术投标客户接待", notes = "技术投标客户接待")
   @TableField("technology_bid_manager_customer_reception")
   @Column(name = "technology_bid_manager_customer_reception", columnDefinition = "varchar(255)  COMMENT '技术投标客户接待'", nullable = true)
   private String technologyBidManagerCustomerReception;
   @ApiModelProperty(name = "technologyBidManagerRemarks", value = "技术投标备注", notes = "技术投标备注")
   @TableField("technology_bid_manager_remarks")
   @Column(name = "technology_bid_manager_remarks", columnDefinition = "varchar(255)  COMMENT '技术投标备注'", nullable = true)
   private String technologyBidManagerRemarks;
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", value = "专项提报类型", notes = "专项提报类型")
   @TableField("crm_special_bubmission_status_enum")
   @Column(
      name = "crm_special_bubmission_status_enum",
      columnDefinition = "int(11)  COMMENT '专项提报类型 参考枚举 CrmSpecialBubmissionStatusEnum 默认为 投标分配类型'",
      nullable = false
   )
   private Integer crmSpecialBubmissionStatusEnum;
   @ApiModelProperty(name = "specialReportUserIds", value = "专项提报人员ids", notes = "专项提报人员ids")
   @TableField("special_report_user_ids")
   @Column(name = "special_report_user_ids", columnDefinition = "varchar(255)  COMMENT '专项提报人员ids'", nullable = true)
   private String specialReportUserIds;
   @ApiModelProperty(name = "technologyProjectBidManagerActualFinishDate", value = "技术标投标实际完成时间", notes = "技术标投标实际完成时间")
   @TableField("technology_project_bid_manager_actual_finish_date")
   @Column(name = "technology_project_bid_manager_actual_finish_date", columnDefinition = "datetime  COMMENT '技术标投标实际完成时间'", nullable = true)
   private LocalDateTime technologyProjectBidManagerActualFinishDate;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "结算业务类型", notes = "结算业务类型")
   @TableField("crm_settlement_business_type_enum")
   @Column(
      name = "crm_settlement_business_type_enum",
      columnDefinition = "int(11) default '1'  COMMENT '结算业务类型  参考枚举 CrmSettlementBusinessTypeEnum 默认为 '",
      nullable = false
   )
   private Integer crmSettlementBusinessTypeEnum;
   @ApiModelProperty(name = "businessEssentials", value = "业务要点", notes = "业务要点")
   @TableField("business_essentials")
   @Column(name = "business_essentials", columnDefinition = "varchar(255)  COMMENT '业务要点'", nullable = true)
   private String businessEssentials;
   @ApiModelProperty(name = "visualizationQuantity", value = "可视化数量", notes = "可视化数量")
   @TableField("visualization_quantity")
   @Column(name = "visualization_quantity", columnDefinition = "int(11)  COMMENT '可视化数量'", nullable = true)
   private Integer visualizationQuantity;
   @ApiModelProperty(name = "contactPerson", value = "对接人", notes = "对接人")
   @TableField("contact_person")
   @Column(name = "contact_person", columnDefinition = "varchar(255)  COMMENT '对接人'", nullable = true)
   private String contactPerson;

   public static CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder builder() {
      return new CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder();
   }

   public CrmApplyTechnologyBiddingRecord() {
   }

   public CrmApplyTechnologyBiddingRecord(
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
      final Long technologyBidManagerJobDescriptionId,
      final String technologyBidManagerRenderings,
      final String technologyBidManagerStructureName,
      final String technologyBidManagerCompletion,
      final String technologyBidManagerBusinessTrip,
      final String technologyBidManagerCustomerReception,
      final String technologyBidManagerRemarks,
      final Integer crmSpecialBubmissionStatusEnum,
      final String specialReportUserIds,
      final LocalDateTime technologyProjectBidManagerActualFinishDate,
      final Integer crmSettlementBusinessTypeEnum,
      final String businessEssentials,
      final Integer visualizationQuantity,
      final String contactPerson
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
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.specialReportUserIds = specialReportUserIds;
      this.technologyProjectBidManagerActualFinishDate = technologyProjectBidManagerActualFinishDate;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.businessEssentials = businessEssentials;
      this.visualizationQuantity = visualizationQuantity;
      this.contactPerson = contactPerson;
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

   public Long getTechnologyBidManagerJobDescriptionId() {
      return this.technologyBidManagerJobDescriptionId;
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

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public String getSpecialReportUserIds() {
      return this.specialReportUserIds;
   }

   public LocalDateTime getTechnologyProjectBidManagerActualFinishDate() {
      return this.technologyProjectBidManagerActualFinishDate;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public String getBusinessEssentials() {
      return this.businessEssentials;
   }

   public Integer getVisualizationQuantity() {
      return this.visualizationQuantity;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public CrmApplyTechnologyBiddingRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCrmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setBidExpirationDate(final LocalDateTime bidExpirationDate) {
      this.bidExpirationDate = bidExpirationDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setBidOpeningDate(final LocalDateTime bidOpeningDate) {
      this.bidOpeningDate = bidOpeningDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setBidEvaluationMethodId(final Long bidEvaluationMethodId) {
      this.bidEvaluationMethodId = bidEvaluationMethodId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setControlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
      this.controlledBiddingPrice = controlledBiddingPrice;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setSettlementMethodId(final Long settlementMethodId) {
      this.settlementMethodId = settlementMethodId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTenderBond(final BigDecimal tenderBond) {
      this.tenderBond = tenderBond;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTenderBondDeadline(final LocalDateTime tenderBondDeadline) {
      this.tenderBondDeadline = tenderBondDeadline;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setAccount(final String account) {
      this.account = account;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTypeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setWarrantyRatio(final String warrantyRatio) {
      this.warrantyRatio = warrantyRatio;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setWarrantyDate(final String warrantyDate) {
      this.warrantyDate = warrantyDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setMaterialAdjustment(final String materialAdjustment) {
      this.materialAdjustment = materialAdjustment;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setMaterialBrandRegulations(final String materialBrandRegulations) {
      this.materialBrandRegulations = materialBrandRegulations;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setSpecialRulesForMaterials(final String specialRulesForMaterials) {
      this.specialRulesForMaterials = specialRulesForMaterials;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setOfferSample(final String offerSample) {
      this.offerSample = offerSample;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setProjectBidManagerUserId(final String projectBidManagerUserId) {
      this.projectBidManagerUserId = projectBidManagerUserId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setBidManagerAttachmentIds(final String bidManagerAttachmentIds) {
      this.bidManagerAttachmentIds = bidManagerAttachmentIds;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCrmProjectBidStatus(final Integer crmProjectBidStatus) {
      this.crmProjectBidStatus = crmProjectBidStatus;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerJobDescriptionId(final Long technologyBidManagerJobDescriptionId) {
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerRenderings(final String technologyBidManagerRenderings) {
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerStructureName(final String technologyBidManagerStructureName) {
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerCompletion(final String technologyBidManagerCompletion) {
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerBusinessTrip(final String technologyBidManagerBusinessTrip) {
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerCustomerReception(final String technologyBidManagerCustomerReception) {
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyBidManagerRemarks(final String technologyBidManagerRemarks) {
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setSpecialReportUserIds(final String specialReportUserIds) {
      this.specialReportUserIds = specialReportUserIds;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setTechnologyProjectBidManagerActualFinishDate(final LocalDateTime technologyProjectBidManagerActualFinishDate) {
      this.technologyProjectBidManagerActualFinishDate = technologyProjectBidManagerActualFinishDate;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setBusinessEssentials(final String businessEssentials) {
      this.businessEssentials = businessEssentials;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setVisualizationQuantity(final Integer visualizationQuantity) {
      this.visualizationQuantity = visualizationQuantity;
      return this;
   }

   public CrmApplyTechnologyBiddingRecord setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
      return this;
   }

   @Override
   public String toString() {
      return "CrmApplyTechnologyBiddingRecord(id="
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
         + ", technologyBidManagerJobDescriptionId="
         + this.getTechnologyBidManagerJobDescriptionId()
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
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", specialReportUserIds="
         + this.getSpecialReportUserIds()
         + ", technologyProjectBidManagerActualFinishDate="
         + this.getTechnologyProjectBidManagerActualFinishDate()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", businessEssentials="
         + this.getBusinessEssentials()
         + ", visualizationQuantity="
         + this.getVisualizationQuantity()
         + ", contactPerson="
         + this.getContactPerson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmApplyTechnologyBiddingRecord)) {
         return false;
      }

      CrmApplyTechnologyBiddingRecord other = (CrmApplyTechnologyBiddingRecord)o;
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
                                                   Object this$technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
                                                   Object other$technologyBidManagerJobDescriptionId = other.getTechnologyBidManagerJobDescriptionId();
                                                   if (this$technologyBidManagerJobDescriptionId == null
                                                      ? other$technologyBidManagerJobDescriptionId == null
                                                      : this$technologyBidManagerJobDescriptionId.equals(other$technologyBidManagerJobDescriptionId)) {
                                                      Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
                                                      Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
                                                      if (this$crmSpecialBubmissionStatusEnum == null
                                                         ? other$crmSpecialBubmissionStatusEnum == null
                                                         : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
                                                         Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
                                                         Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
                                                         if (this$crmSettlementBusinessTypeEnum == null
                                                            ? other$crmSettlementBusinessTypeEnum == null
                                                            : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
                                                            Object this$visualizationQuantity = this.getVisualizationQuantity();
                                                            Object other$visualizationQuantity = other.getVisualizationQuantity();
                                                            if (this$visualizationQuantity == null
                                                               ? other$visualizationQuantity == null
                                                               : this$visualizationQuantity.equals(other$visualizationQuantity)) {
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
                                                                                                               : this$materialAdjustment.equals(
                                                                                                                  other$materialAdjustment
                                                                                                               )) {
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
                                                                                                                        : this$offerSample.equals(
                                                                                                                           other$offerSample
                                                                                                                        )) {
                                                                                                                        Object this$paymentMethod = this.getPaymentMethod();
                                                                                                                        Object other$paymentMethod = other.getPaymentMethod();
                                                                                                                        if (this$paymentMethod == null
                                                                                                                           ? other$paymentMethod == null
                                                                                                                           : this$paymentMethod.equals(
                                                                                                                              other$paymentMethod
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
                                                                                                                                 : this$remark.equals(
                                                                                                                                    other$remark
                                                                                                                                 )) {
                                                                                                                                 Object this$projectBidManagerUserId = this.getProjectBidManagerUserId();
                                                                                                                                 Object other$projectBidManagerUserId = other.getProjectBidManagerUserId();
                                                                                                                                 if (this$projectBidManagerUserId
                                                                                                                                       == null
                                                                                                                                    ? other$projectBidManagerUserId
                                                                                                                                       == null
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
                                                                                                                                          Object this$technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
                                                                                                                                          Object other$technologyBidManagerRenderings = other.getTechnologyBidManagerRenderings();
                                                                                                                                          if (this$technologyBidManagerRenderings
                                                                                                                                                == null
                                                                                                                                             ? other$technologyBidManagerRenderings
                                                                                                                                                == null
                                                                                                                                             : this$technologyBidManagerRenderings.equals(
                                                                                                                                                other$technologyBidManagerRenderings
                                                                                                                                             )) {
                                                                                                                                             Object this$technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
                                                                                                                                             Object other$technologyBidManagerStructureName = other.getTechnologyBidManagerStructureName();
                                                                                                                                             if (this$technologyBidManagerStructureName
                                                                                                                                                   == null
                                                                                                                                                ? other$technologyBidManagerStructureName
                                                                                                                                                   == null
                                                                                                                                                : this$technologyBidManagerStructureName.equals(
                                                                                                                                                   other$technologyBidManagerStructureName
                                                                                                                                                )) {
                                                                                                                                                Object this$technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
                                                                                                                                                Object other$technologyBidManagerCompletion = other.getTechnologyBidManagerCompletion();
                                                                                                                                                if (this$technologyBidManagerCompletion
                                                                                                                                                      == null
                                                                                                                                                   ? other$technologyBidManagerCompletion
                                                                                                                                                      == null
                                                                                                                                                   : this$technologyBidManagerCompletion.equals(
                                                                                                                                                      other$technologyBidManagerCompletion
                                                                                                                                                   )) {
                                                                                                                                                   Object this$technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
                                                                                                                                                   Object other$technologyBidManagerBusinessTrip = other.getTechnologyBidManagerBusinessTrip();
                                                                                                                                                   if (this$technologyBidManagerBusinessTrip
                                                                                                                                                         == null
                                                                                                                                                      ? other$technologyBidManagerBusinessTrip
                                                                                                                                                         == null
                                                                                                                                                      : this$technologyBidManagerBusinessTrip.equals(
                                                                                                                                                         other$technologyBidManagerBusinessTrip
                                                                                                                                                      )) {
                                                                                                                                                      Object this$technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
                                                                                                                                                      Object other$technologyBidManagerCustomerReception = other.getTechnologyBidManagerCustomerReception();
                                                                                                                                                      if (this$technologyBidManagerCustomerReception
                                                                                                                                                            == null
                                                                                                                                                         ? other$technologyBidManagerCustomerReception
                                                                                                                                                            == null
                                                                                                                                                         : this$technologyBidManagerCustomerReception.equals(
                                                                                                                                                            other$technologyBidManagerCustomerReception
                                                                                                                                                         )) {
                                                                                                                                                         Object this$technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
                                                                                                                                                         Object other$technologyBidManagerRemarks = other.getTechnologyBidManagerRemarks();
                                                                                                                                                         if (this$technologyBidManagerRemarks
                                                                                                                                                               == null
                                                                                                                                                            ? other$technologyBidManagerRemarks
                                                                                                                                                               == null
                                                                                                                                                            : this$technologyBidManagerRemarks.equals(
                                                                                                                                                               other$technologyBidManagerRemarks
                                                                                                                                                            )) {
                                                                                                                                                            Object this$specialReportUserIds = this.getSpecialReportUserIds();
                                                                                                                                                            Object other$specialReportUserIds = other.getSpecialReportUserIds();
                                                                                                                                                            if (this$specialReportUserIds
                                                                                                                                                                  == null
                                                                                                                                                               ? other$specialReportUserIds
                                                                                                                                                                  == null
                                                                                                                                                               : this$specialReportUserIds.equals(
                                                                                                                                                                  other$specialReportUserIds
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$technologyProjectBidManagerActualFinishDate = this.getTechnologyProjectBidManagerActualFinishDate();
                                                                                                                                                               Object other$technologyProjectBidManagerActualFinishDate = other.getTechnologyProjectBidManagerActualFinishDate();
                                                                                                                                                               if (this$technologyProjectBidManagerActualFinishDate
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$technologyProjectBidManagerActualFinishDate
                                                                                                                                                                     == null
                                                                                                                                                                  : this$technologyProjectBidManagerActualFinishDate.equals(
                                                                                                                                                                     other$technologyProjectBidManagerActualFinishDate
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$businessEssentials = this.getBusinessEssentials();
                                                                                                                                                                  Object other$businessEssentials = other.getBusinessEssentials();
                                                                                                                                                                  if (this$businessEssentials
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$businessEssentials
                                                                                                                                                                        == null
                                                                                                                                                                     : this$businessEssentials.equals(
                                                                                                                                                                        other$businessEssentials
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$contactPerson = this.getContactPerson();
                                                                                                                                                                     Object other$contactPerson = other.getContactPerson();
                                                                                                                                                                     return this$contactPerson
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$contactPerson
                                                                                                                                                                           == null
                                                                                                                                                                        : this$contactPerson.equals(
                                                                                                                                                                           other$contactPerson
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmApplyTechnologyBiddingRecord;
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
      Object $technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
      result = result * 59 + ($technologyBidManagerJobDescriptionId == null ? 43 : $technologyBidManagerJobDescriptionId.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $visualizationQuantity = this.getVisualizationQuantity();
      result = result * 59 + ($visualizationQuantity == null ? 43 : $visualizationQuantity.hashCode());
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
      result = result * 59 + ($technologyBidManagerRemarks == null ? 43 : $technologyBidManagerRemarks.hashCode());
      Object $specialReportUserIds = this.getSpecialReportUserIds();
      result = result * 59 + ($specialReportUserIds == null ? 43 : $specialReportUserIds.hashCode());
      Object $technologyProjectBidManagerActualFinishDate = this.getTechnologyProjectBidManagerActualFinishDate();
      result = result * 59 + ($technologyProjectBidManagerActualFinishDate == null ? 43 : $technologyProjectBidManagerActualFinishDate.hashCode());
      Object $businessEssentials = this.getBusinessEssentials();
      result = result * 59 + ($businessEssentials == null ? 43 : $businessEssentials.hashCode());
      Object $contactPerson = this.getContactPerson();
      return result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
   }

   public static class CrmApplyTechnologyBiddingRecordBuilder {
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
      private Long technologyBidManagerJobDescriptionId;
      private String technologyBidManagerRenderings;
      private String technologyBidManagerStructureName;
      private String technologyBidManagerCompletion;
      private String technologyBidManagerBusinessTrip;
      private String technologyBidManagerCustomerReception;
      private String technologyBidManagerRemarks;
      private Integer crmSpecialBubmissionStatusEnum;
      private String specialReportUserIds;
      private LocalDateTime technologyProjectBidManagerActualFinishDate;
      private Integer crmSettlementBusinessTypeEnum;
      private String businessEssentials;
      private Integer visualizationQuantity;
      private String contactPerson;

      CrmApplyTechnologyBiddingRecordBuilder() {
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder biddingMethodId(final Long biddingMethodId) {
         this.biddingMethodId = biddingMethodId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder crmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
         this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder tenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
         this.tenderSubmissionMethodId = tenderSubmissionMethodId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder bidExpirationDate(final LocalDateTime bidExpirationDate) {
         this.bidExpirationDate = bidExpirationDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder bidOpeningDate(final LocalDateTime bidOpeningDate) {
         this.bidOpeningDate = bidOpeningDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder bidEvaluationMethodId(final Long bidEvaluationMethodId) {
         this.bidEvaluationMethodId = bidEvaluationMethodId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder controlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
         this.controlledBiddingPrice = controlledBiddingPrice;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder settlementMethodId(final Long settlementMethodId) {
         this.settlementMethodId = settlementMethodId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder tenderBond(final BigDecimal tenderBond) {
         this.tenderBond = tenderBond;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder tenderBondDeadline(final LocalDateTime tenderBondDeadline) {
         this.tenderBondDeadline = tenderBondDeadline;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder account(final String account) {
         this.account = account;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder typeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
         this.typeOfPerformanceBondId = typeOfPerformanceBondId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder warrantyRatio(final String warrantyRatio) {
         this.warrantyRatio = warrantyRatio;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder warrantyDate(final String warrantyDate) {
         this.warrantyDate = warrantyDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder materialAdjustment(final String materialAdjustment) {
         this.materialAdjustment = materialAdjustment;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder materialBrandRegulations(final String materialBrandRegulations) {
         this.materialBrandRegulations = materialBrandRegulations;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder specialRulesForMaterials(final String specialRulesForMaterials) {
         this.specialRulesForMaterials = specialRulesForMaterials;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder offerSample(final String offerSample) {
         this.offerSample = offerSample;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder projectBidManagerUserId(final String projectBidManagerUserId) {
         this.projectBidManagerUserId = projectBidManagerUserId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder difficultyFactorId(final Long difficultyFactorId) {
         this.difficultyFactorId = difficultyFactorId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder bidManagerAttachmentIds(final String bidManagerAttachmentIds) {
         this.bidManagerAttachmentIds = bidManagerAttachmentIds;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder crmProjectBidStatus(final Integer crmProjectBidStatus) {
         this.crmProjectBidStatus = crmProjectBidStatus;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerJobDescriptionId(
         final Long technologyBidManagerJobDescriptionId
      ) {
         this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerRenderings(final String technologyBidManagerRenderings) {
         this.technologyBidManagerRenderings = technologyBidManagerRenderings;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerStructureName(
         final String technologyBidManagerStructureName
      ) {
         this.technologyBidManagerStructureName = technologyBidManagerStructureName;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerCompletion(final String technologyBidManagerCompletion) {
         this.technologyBidManagerCompletion = technologyBidManagerCompletion;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerBusinessTrip(
         final String technologyBidManagerBusinessTrip
      ) {
         this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerCustomerReception(
         final String technologyBidManagerCustomerReception
      ) {
         this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyBidManagerRemarks(final String technologyBidManagerRemarks) {
         this.technologyBidManagerRemarks = technologyBidManagerRemarks;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder crmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
         this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder specialReportUserIds(final String specialReportUserIds) {
         this.specialReportUserIds = specialReportUserIds;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder technologyProjectBidManagerActualFinishDate(
         final LocalDateTime technologyProjectBidManagerActualFinishDate
      ) {
         this.technologyProjectBidManagerActualFinishDate = technologyProjectBidManagerActualFinishDate;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder crmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
         this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder businessEssentials(final String businessEssentials) {
         this.businessEssentials = businessEssentials;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder visualizationQuantity(final Integer visualizationQuantity) {
         this.visualizationQuantity = visualizationQuantity;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder contactPerson(final String contactPerson) {
         this.contactPerson = contactPerson;
         return this;
      }

      public CrmApplyTechnologyBiddingRecord build() {
         return new CrmApplyTechnologyBiddingRecord(
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
            this.technologyBidManagerJobDescriptionId,
            this.technologyBidManagerRenderings,
            this.technologyBidManagerStructureName,
            this.technologyBidManagerCompletion,
            this.technologyBidManagerBusinessTrip,
            this.technologyBidManagerCustomerReception,
            this.technologyBidManagerRemarks,
            this.crmSpecialBubmissionStatusEnum,
            this.specialReportUserIds,
            this.technologyProjectBidManagerActualFinishDate,
            this.crmSettlementBusinessTypeEnum,
            this.businessEssentials,
            this.visualizationQuantity,
            this.contactPerson
         );
      }

      @Override
      public String toString() {
         return "CrmApplyTechnologyBiddingRecord.CrmApplyTechnologyBiddingRecordBuilder(id="
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
            + ", technologyBidManagerJobDescriptionId="
            + this.technologyBidManagerJobDescriptionId
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
            + ", crmSpecialBubmissionStatusEnum="
            + this.crmSpecialBubmissionStatusEnum
            + ", specialReportUserIds="
            + this.specialReportUserIds
            + ", technologyProjectBidManagerActualFinishDate="
            + this.technologyProjectBidManagerActualFinishDate
            + ", crmSettlementBusinessTypeEnum="
            + this.crmSettlementBusinessTypeEnum
            + ", businessEssentials="
            + this.businessEssentials
            + ", visualizationQuantity="
            + this.visualizationQuantity
            + ", contactPerson="
            + this.contactPerson
            + ")";
      }
   }
}
