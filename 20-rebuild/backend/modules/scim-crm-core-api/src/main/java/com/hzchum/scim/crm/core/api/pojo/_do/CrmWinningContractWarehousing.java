package com.hzchum.scim.crm.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "CrmWinningContractWarehousing对象", description = "")
@Entity
@TableName("crm_winning_contract_warehousing")
@Table(name = "crm_winning_contract_warehousing")
@org.hibernate.annotations.Table(appliesTo = "crm_winning_contract_warehousing")
public class CrmWinningContractWarehousing extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   @TableField("informant_user_id")
   @Column(name = "informant_user_id", columnDefinition = "bigint(20)  COMMENT '填报人'", nullable = false)
   private Long informantUserId;
   @ApiModelProperty(name = "estimatedWorks", value = "用钢量", notes = "用钢量")
   @TableField("estimated_works")
   @Column(name = "estimated_works", columnDefinition = "decimal(20,2)  COMMENT '用钢量'", nullable = true)
   private BigDecimal estimatedWorks;
   @ApiModelProperty(name = "shortName", notes = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20)  COMMENT '所属部门'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '填报日期'", nullable = false)
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255)  COMMENT '项目名称'", nullable = false)
   private String projectName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '项目备案id'", nullable = false)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "amount", value = "合同额", notes = "合同额")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '合同额'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "structureTypeConfigurationId", value = "结构类型id", notes = "结构类型id")
   @TableField("structure_type_configuration_id")
   @Column(name = "structure_type_configuration_id", columnDefinition = "bigint(20)  COMMENT '结构类型id'", nullable = true)
   private Long structureTypeConfigurationId;
   @ApiModelProperty(name = "areaOfStructure", value = "建筑面积", notes = "建筑面积")
   @TableField("area_of_structure")
   @Column(name = "area_of_structure", columnDefinition = "decimal(20,2)  COMMENT '建筑面积'", nullable = true)
   private BigDecimal areaOfStructure;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(8,4) unsigned zerofill  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "quantityWork", value = "工程量", notes = "工程量")
   @TableField("quantity_work")
   @Column(name = "quantity_work", columnDefinition = "decimal(32,8)  COMMENT '工程量'", nullable = true)
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "structuralRemark", value = "结构备注", notes = "结构备注")
   @TableField("structural_remark")
   @Column(name = "structural_remark", columnDefinition = "varchar(255)  COMMENT '结构备注'", nullable = true)
   private String structuralRemark;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime  COMMENT '开始时间'", nullable = true)
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "datetime  COMMENT '结束时间'", nullable = true)
   private LocalDateTime endDate;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", value = "质保金比例", notes = "质保金比例")
   @TableField("quality_guarantee_deposit")
   @Column(name = "quality_guarantee_deposit", columnDefinition = "decimal(10,2)  COMMENT '质保金比例'", nullable = true)
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "qualityGuaranteeDepositRemark", value = "质保金备注", notes = "质保金备注")
   @TableField("quality_guarantee_deposit_remark")
   @Column(name = "quality_guarantee_deposit_remark", columnDefinition = "varchar(255)  COMMENT '质保金备注'", nullable = true)
   private String qualityGuaranteeDepositRemark;
   @ApiModelProperty(name = "partyAName", value = "甲方名称", notes = "甲方名称")
   @TableField("party_a_name")
   @Column(name = "party_a_name", columnDefinition = "varchar(255)  COMMENT '甲方名称'", nullable = true)
   private String partyAName;
   @ApiModelProperty(name = "partyAPersonName", value = "甲方联系人名称", notes = "甲方联系人名称")
   @TableField("party_a_person_name")
   @Column(name = "party_a_person_name", columnDefinition = "varchar(255)  COMMENT '甲方联系人名称'", nullable = true)
   private String partyAPersonName;
   @ApiModelProperty(name = "partyAPhone", value = "甲方联系人电话", notes = "甲方联系人电话")
   @TableField("party_a_phone")
   @Column(name = "party_a_phone", columnDefinition = "varchar(255)  COMMENT '甲方联系人电话'", nullable = true)
   private String partyAPhone;
   @ApiModelProperty(name = "partyBName", value = "乙方名称", notes = "乙方名称")
   @TableField("party_b_name")
   @Column(name = "party_b_name", columnDefinition = "varchar(255)  COMMENT '乙方名称'", nullable = true)
   private String partyBName;
   @ApiModelProperty(name = "partyBPersonName", value = "乙方联系人", notes = "乙方联系人")
   @TableField("party_b_person_name")
   @Column(name = "party_b_person_name", columnDefinition = "varchar(255)  COMMENT '乙方联系人'", nullable = true)
   private String partyBPersonName;
   @ApiModelProperty(name = "partyBPhone", value = "乙方联系人电话", notes = "乙方联系人电话")
   @TableField("party_b_phone")
   @Column(name = "party_b_phone", columnDefinition = "varchar(255)  COMMENT '乙方联系人电话'", nullable = true)
   private String partyBPhone;
   @ApiModelProperty(name = "partyCName", value = "丙方名称", notes = "丙方名称")
   @TableField("party_c_name")
   @Column(name = "party_c_name", columnDefinition = "varchar(255)  COMMENT '丙方名称'", nullable = true)
   private String partyCName;
   @ApiModelProperty(name = "partyCPersonName", value = "丙方联系人", notes = "丙方联系人")
   @TableField("party_c_person_name")
   @Column(name = "party_c_person_name", columnDefinition = "varchar(255)  COMMENT '丙方联系人'", nullable = true)
   private String partyCPersonName;
   @ApiModelProperty(name = "partyCPhone", value = "丙方联系人电话", notes = "丙方联系人电话")
   @TableField("party_c_phone")
   @Column(name = "party_c_phone", columnDefinition = "varchar(255)  COMMENT '丙方联系人电话'", nullable = true)
   private String partyCPhone;
   @ApiModelProperty(name = "paymentMethod", value = "付款方式描述", notes = "付款方式描述")
   @TableField("payment_method")
   @Column(name = "payment_method", columnDefinition = "varchar(1024)  COMMENT '付款方式描述'", nullable = true)
   private String paymentMethod;
   @ApiModelProperty(name = "attachment_ids", value = "附件ids", notes = "附件ids")
   @TableField("attachment_ids")
   @Column(name = "attachmentIds", columnDefinition = "varchar(255)  COMMENT '附件ids'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "causeAnalysis", value = "原因分析", notes = "原因分析")
   @TableField("cause_analysis")
   @Column(name = "cause_analysis", columnDefinition = "varchar(1024)  COMMENT '原因分析'", nullable = true)
   private String causeAnalysis;
   @ApiModelProperty(name = "reasonsForBidFail", value = "失败原因(引用字典值)", notes = "失败原因(引用字典值)")
   @TableField("reasons_for_bid_fail")
   @Column(name = "reasons_for_bid_fail", columnDefinition = "varchar(1024)  COMMENT '失败原因(引用字典值)'", nullable = true)
   private String reasonsForBidFail;
   @ApiModelProperty(name = "reportingStatus", value = "专项方案是否提报人员", notes = "专项方案是否提报人员")
   @TableField("reporting_status")
   @Column(name = "reporting_status", columnDefinition = "tinyint(1) default '0'  COMMENT '专项方案是否提报人员'", nullable = false)
   private Boolean reportingStatus;
   @ApiModelProperty(name = "numberOfBidsParticipated", value = "参与竞标人数", notes = "参与竞标人数")
   @TableField("number_of_bids_participated")
   @Column(name = "number_of_bids_participated", columnDefinition = "int(11)  COMMENT '参与竞标人数'", nullable = true)
   private Integer numberOfBidsParticipated;
   @ApiModelProperty(name = "bidRanking", value = "投标排名", notes = "投标排名")
   @TableField("bid_ranking")
   @Column(name = "bid_ranking", columnDefinition = "int(11)  COMMENT '投标排名'", nullable = true)
   private Integer bidRanking;
   @ApiModelProperty(name = "reportingTime", value = "专项方案提报时间", notes = "专项方案提报时间")
   @TableField("reporting_time")
   @Column(name = "reporting_time", columnDefinition = "datetime  COMMENT '专项方案提报时间'", nullable = true)
   private LocalDateTime reportingTime;
   @ApiModelProperty(name = "reportingUserId", value = "专项方案提报人员id", notes = "专项方案提报人员id")
   @TableField("reporting_user_id")
   @Column(name = "reporting_user_id", columnDefinition = "bigint(20)  COMMENT '专项方案提报人员id'", nullable = true)
   private Long reportingUserId;
   @ApiModelProperty(name = "constructionOrganizationReportingStatus", value = "施工组织是否提报人员", notes = "施工组织是否提报人员")
   @TableField("construction_organization_reporting_status")
   @Column(name = "construction_organization_reporting_status", columnDefinition = "tinyint(1) default '0'  COMMENT '施工组织是否提报人员'", nullable = false)
   private Boolean constructionOrganizationReportingStatus;
   @ApiModelProperty(name = "constructionOrganizationReportingTime", value = "施工组织专项方案提报时间", notes = "施工组织专项方案提报时间")
   @TableField("construction_organization_reporting_time")
   @Column(name = "construction_organization_reporting_time", columnDefinition = "datetime  COMMENT '施工组织专项方案提报时间'", nullable = true)
   private LocalDateTime constructionOrganizationReportingTime;
   @ApiModelProperty(name = "constructionOrganizationReportingUserId", value = "施工组织专项方案提报人员id", notes = "施工组织专项方案提报人员id")
   @TableField("construction_organization_reporting_user_id")
   @Column(name = "construction_organization_reporting_user_id", columnDefinition = "bigint(20)  COMMENT '施工组织专项方案提报人员id'", nullable = true)
   private Long constructionOrganizationReportingUserId;
   @ApiModelProperty(name = "constructionSupportServiceReportingStatus", value = "现场支持服务是否提报人员", notes = "现场支持服务是否提报人员")
   @TableField("construction_support_service_reporting_status")
   @Column(name = "construction_support_service_reporting_status", columnDefinition = "tinyint(1) default '0'  COMMENT '现场支持服务是否提报人员'", nullable = false)
   private Boolean constructionSupportServiceReportingStatus;
   @ApiModelProperty(name = "constructionSupportServiceReportingTime", value = "现场支持服务专项方案提报时间", notes = "现场支持服务专项方案提报时间")
   @TableField("construction_support_service_reporting_time")
   @Column(name = "construction_support_service_reporting_time", columnDefinition = "datetime  COMMENT '现场支持服务专项方案提报时间'", nullable = true)
   private LocalDateTime constructionSupportServiceReportingTime;
   @ApiModelProperty(name = "constructionSupportServiceReportingUserId", value = "现场支持服务专项方案提报人员id", notes = "现场支持服务专项方案提报人员id")
   @TableField("construction_support_service_reporting_user_id")
   @Column(name = "construction_support_service_reporting_user_id", columnDefinition = "bigint(20)  COMMENT '现场支持服务专项方案提报人员id'", nullable = true)
   private Long constructionSupportServiceReportingUserId;
   @ApiModelProperty(name = "constructionCalculationReportingStatus", value = "施工验算是否提报人员", notes = "施工验算是否提报人员")
   @TableField("construction_calculation_reporting_status")
   @Column(name = "construction_calculation_reporting_status", columnDefinition = "tinyint(1) default '0'  COMMENT '施工验算是否提报人员'", nullable = false)
   private Boolean constructionCalculationReportingStatus;
   @ApiModelProperty(name = "constructionCalculationReportingTime", value = "施工验算专项方案提报时间", notes = "施工验算专项方案提报时间")
   @TableField("construction_calculation_reporting_time")
   @Column(name = "construction_calculation_reporting_time", columnDefinition = "datetime  COMMENT '施工验算专项方案提报时间'", nullable = true)
   private LocalDateTime constructionCalculationReportingTime;
   @ApiModelProperty(name = "constructionCalculationReportingUserId", value = "施工验算专项方案提报人员id", notes = "施工验算专项方案提报人员id")
   @TableField("construction_calculation_reporting_user_id")
   @Column(name = "construction_calculation_reporting_user_id", columnDefinition = "bigint(20)  COMMENT '施工验算专项方案提报人员id'", nullable = true)
   private Long constructionCalculationReportingUserId;
   @ApiModelProperty(name = "animationReportingStatus", value = "动画集效果是否提报人员", notes = "动画集效果是否提报人员")
   @TableField("animation_reporting_status")
   @Column(name = "animation_reporting_status", columnDefinition = "tinyint(1) default '0'  COMMENT '动画集效果是否提报人员'", nullable = false)
   private Boolean animationReportingStatus;
   @ApiModelProperty(name = "animationReportingTime", value = "动画集效果专项方案提报时间", notes = "动画集效果专项方案提报时间")
   @TableField("animation_reporting_time")
   @Column(name = "animation_reporting_time", columnDefinition = "datetime  COMMENT '动画集效果专项方案提报时间'", nullable = true)
   private LocalDateTime animationReportingTime;
   @ApiModelProperty(name = "animationReportingUserId", value = "动画集效果专项方案提报人员id", notes = "动画集效果专项方案提报人员id")
   @TableField("animation_reporting_user_id")
   @Column(name = "animation_reporting_user_id", columnDefinition = "bigint(20)  COMMENT '动画集效果专项方案提报人员id'", nullable = true)
   private Long animationReportingUserId;
   @ApiModelProperty(name = "innovationReportingStatus", value = "科技创新是否提报人员", notes = "科技创新是否提报人员")
   @TableField("innovation_reporting_status")
   @Column(name = "innovation_reporting_status", columnDefinition = "tinyint(1) default '0'  COMMENT '科技创新是否提报人员'", nullable = false)
   private Boolean innovationReportingStatus;
   @ApiModelProperty(name = "innovationReportingTime", value = "科技创新专项方案提报时间", notes = "科技创新专项方案提报时间")
   @TableField("innovation_reporting_time")
   @Column(name = "innovation_reporting_time", columnDefinition = "datetime  COMMENT '科技创新专项方案提报时间'", nullable = true)
   private LocalDateTime innovationReportingTime;
   @ApiModelProperty(name = "innovationReportingUserId", value = "科技创新专项方案提报人员id", notes = "科技创新专项方案提报人员id")
   @TableField("innovation_reporting_user_id")
   @Column(name = "innovation_reporting_user_id", columnDefinition = "bigint(20)  COMMENT '科技创新专项方案提报人员id'", nullable = true)
   private Long innovationReportingUserId;

   public static CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder builder() {
      return new CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder();
   }

   public CrmWinningContractWarehousing() {
   }

   public CrmWinningContractWarehousing(
      final Long id,
      final Long createUserId,
      final Long informantUserId,
      final BigDecimal estimatedWorks,
      final String shortName,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final String projectName,
      final Long crmProjectInformationWarehousingId,
      final BigDecimal amount,
      final Long structureTypeConfigurationId,
      final BigDecimal areaOfStructure,
      final BigDecimal taxRate,
      final BigDecimal quantityWork,
      final String structuralRemark,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final BigDecimal qualityGuaranteeDeposit,
      final String qualityGuaranteeDepositRemark,
      final String partyAName,
      final String partyAPersonName,
      final String partyAPhone,
      final String partyBName,
      final String partyBPersonName,
      final String partyBPhone,
      final String partyCName,
      final String partyCPersonName,
      final String partyCPhone,
      final String paymentMethod,
      final String attachmentIds,
      final String remark,
      final String causeAnalysis,
      final String reasonsForBidFail,
      final Boolean reportingStatus,
      final Integer numberOfBidsParticipated,
      final Integer bidRanking,
      final LocalDateTime reportingTime,
      final Long reportingUserId,
      final Boolean constructionOrganizationReportingStatus,
      final LocalDateTime constructionOrganizationReportingTime,
      final Long constructionOrganizationReportingUserId,
      final Boolean constructionSupportServiceReportingStatus,
      final LocalDateTime constructionSupportServiceReportingTime,
      final Long constructionSupportServiceReportingUserId,
      final Boolean constructionCalculationReportingStatus,
      final LocalDateTime constructionCalculationReportingTime,
      final Long constructionCalculationReportingUserId,
      final Boolean animationReportingStatus,
      final LocalDateTime animationReportingTime,
      final Long animationReportingUserId,
      final Boolean innovationReportingStatus,
      final LocalDateTime innovationReportingTime,
      final Long innovationReportingUserId
   ) {
      this.id = id;
      this.createUserId = createUserId;
      this.informantUserId = informantUserId;
      this.estimatedWorks = estimatedWorks;
      this.shortName = shortName;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.projectName = projectName;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.amount = amount;
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      this.areaOfStructure = areaOfStructure;
      this.taxRate = taxRate;
      this.quantityWork = quantityWork;
      this.structuralRemark = structuralRemark;
      this.startDate = startDate;
      this.endDate = endDate;
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
      this.partyAName = partyAName;
      this.partyAPersonName = partyAPersonName;
      this.partyAPhone = partyAPhone;
      this.partyBName = partyBName;
      this.partyBPersonName = partyBPersonName;
      this.partyBPhone = partyBPhone;
      this.partyCName = partyCName;
      this.partyCPersonName = partyCPersonName;
      this.partyCPhone = partyCPhone;
      this.paymentMethod = paymentMethod;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.causeAnalysis = causeAnalysis;
      this.reasonsForBidFail = reasonsForBidFail;
      this.reportingStatus = reportingStatus;
      this.numberOfBidsParticipated = numberOfBidsParticipated;
      this.bidRanking = bidRanking;
      this.reportingTime = reportingTime;
      this.reportingUserId = reportingUserId;
      this.constructionOrganizationReportingStatus = constructionOrganizationReportingStatus;
      this.constructionOrganizationReportingTime = constructionOrganizationReportingTime;
      this.constructionOrganizationReportingUserId = constructionOrganizationReportingUserId;
      this.constructionSupportServiceReportingStatus = constructionSupportServiceReportingStatus;
      this.constructionSupportServiceReportingTime = constructionSupportServiceReportingTime;
      this.constructionSupportServiceReportingUserId = constructionSupportServiceReportingUserId;
      this.constructionCalculationReportingStatus = constructionCalculationReportingStatus;
      this.constructionCalculationReportingTime = constructionCalculationReportingTime;
      this.constructionCalculationReportingUserId = constructionCalculationReportingUserId;
      this.animationReportingStatus = animationReportingStatus;
      this.animationReportingTime = animationReportingTime;
      this.animationReportingUserId = animationReportingUserId;
      this.innovationReportingStatus = innovationReportingStatus;
      this.innovationReportingTime = innovationReportingTime;
      this.innovationReportingUserId = innovationReportingUserId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public BigDecimal getEstimatedWorks() {
      return this.estimatedWorks;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getStructureTypeConfigurationId() {
      return this.structureTypeConfigurationId;
   }

   public BigDecimal getAreaOfStructure() {
      return this.areaOfStructure;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public String getStructuralRemark() {
      return this.structuralRemark;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
   }

   public String getQualityGuaranteeDepositRemark() {
      return this.qualityGuaranteeDepositRemark;
   }

   public String getPartyAName() {
      return this.partyAName;
   }

   public String getPartyAPersonName() {
      return this.partyAPersonName;
   }

   public String getPartyAPhone() {
      return this.partyAPhone;
   }

   public String getPartyBName() {
      return this.partyBName;
   }

   public String getPartyBPersonName() {
      return this.partyBPersonName;
   }

   public String getPartyBPhone() {
      return this.partyBPhone;
   }

   public String getPartyCName() {
      return this.partyCName;
   }

   public String getPartyCPersonName() {
      return this.partyCPersonName;
   }

   public String getPartyCPhone() {
      return this.partyCPhone;
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

   public String getCauseAnalysis() {
      return this.causeAnalysis;
   }

   public String getReasonsForBidFail() {
      return this.reasonsForBidFail;
   }

   public Boolean getReportingStatus() {
      return this.reportingStatus;
   }

   public Integer getNumberOfBidsParticipated() {
      return this.numberOfBidsParticipated;
   }

   public Integer getBidRanking() {
      return this.bidRanking;
   }

   public LocalDateTime getReportingTime() {
      return this.reportingTime;
   }

   public Long getReportingUserId() {
      return this.reportingUserId;
   }

   public Boolean getConstructionOrganizationReportingStatus() {
      return this.constructionOrganizationReportingStatus;
   }

   public LocalDateTime getConstructionOrganizationReportingTime() {
      return this.constructionOrganizationReportingTime;
   }

   public Long getConstructionOrganizationReportingUserId() {
      return this.constructionOrganizationReportingUserId;
   }

   public Boolean getConstructionSupportServiceReportingStatus() {
      return this.constructionSupportServiceReportingStatus;
   }

   public LocalDateTime getConstructionSupportServiceReportingTime() {
      return this.constructionSupportServiceReportingTime;
   }

   public Long getConstructionSupportServiceReportingUserId() {
      return this.constructionSupportServiceReportingUserId;
   }

   public Boolean getConstructionCalculationReportingStatus() {
      return this.constructionCalculationReportingStatus;
   }

   public LocalDateTime getConstructionCalculationReportingTime() {
      return this.constructionCalculationReportingTime;
   }

   public Long getConstructionCalculationReportingUserId() {
      return this.constructionCalculationReportingUserId;
   }

   public Boolean getAnimationReportingStatus() {
      return this.animationReportingStatus;
   }

   public LocalDateTime getAnimationReportingTime() {
      return this.animationReportingTime;
   }

   public Long getAnimationReportingUserId() {
      return this.animationReportingUserId;
   }

   public Boolean getInnovationReportingStatus() {
      return this.innovationReportingStatus;
   }

   public LocalDateTime getInnovationReportingTime() {
      return this.innovationReportingTime;
   }

   public Long getInnovationReportingUserId() {
      return this.innovationReportingUserId;
   }

   public CrmWinningContractWarehousing setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmWinningContractWarehousing setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmWinningContractWarehousing setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmWinningContractWarehousing setEstimatedWorks(final BigDecimal estimatedWorks) {
      this.estimatedWorks = estimatedWorks;
      return this;
   }

   @JsonProperty("shortName")
   public CrmWinningContractWarehousing setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public CrmWinningContractWarehousing setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmWinningContractWarehousing setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmWinningContractWarehousing setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmWinningContractWarehousing setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmWinningContractWarehousing setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public CrmWinningContractWarehousing setStructureTypeConfigurationId(final Long structureTypeConfigurationId) {
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      return this;
   }

   public CrmWinningContractWarehousing setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
      return this;
   }

   public CrmWinningContractWarehousing setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public CrmWinningContractWarehousing setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
      return this;
   }

   public CrmWinningContractWarehousing setStructuralRemark(final String structuralRemark) {
      this.structuralRemark = structuralRemark;
      return this;
   }

   public CrmWinningContractWarehousing setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public CrmWinningContractWarehousing setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public CrmWinningContractWarehousing setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      return this;
   }

   public CrmWinningContractWarehousing setQualityGuaranteeDepositRemark(final String qualityGuaranteeDepositRemark) {
      this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
      return this;
   }

   public CrmWinningContractWarehousing setPartyAName(final String partyAName) {
      this.partyAName = partyAName;
      return this;
   }

   public CrmWinningContractWarehousing setPartyAPersonName(final String partyAPersonName) {
      this.partyAPersonName = partyAPersonName;
      return this;
   }

   public CrmWinningContractWarehousing setPartyAPhone(final String partyAPhone) {
      this.partyAPhone = partyAPhone;
      return this;
   }

   public CrmWinningContractWarehousing setPartyBName(final String partyBName) {
      this.partyBName = partyBName;
      return this;
   }

   public CrmWinningContractWarehousing setPartyBPersonName(final String partyBPersonName) {
      this.partyBPersonName = partyBPersonName;
      return this;
   }

   public CrmWinningContractWarehousing setPartyBPhone(final String partyBPhone) {
      this.partyBPhone = partyBPhone;
      return this;
   }

   public CrmWinningContractWarehousing setPartyCName(final String partyCName) {
      this.partyCName = partyCName;
      return this;
   }

   public CrmWinningContractWarehousing setPartyCPersonName(final String partyCPersonName) {
      this.partyCPersonName = partyCPersonName;
      return this;
   }

   public CrmWinningContractWarehousing setPartyCPhone(final String partyCPhone) {
      this.partyCPhone = partyCPhone;
      return this;
   }

   public CrmWinningContractWarehousing setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public CrmWinningContractWarehousing setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmWinningContractWarehousing setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmWinningContractWarehousing setCauseAnalysis(final String causeAnalysis) {
      this.causeAnalysis = causeAnalysis;
      return this;
   }

   public CrmWinningContractWarehousing setReasonsForBidFail(final String reasonsForBidFail) {
      this.reasonsForBidFail = reasonsForBidFail;
      return this;
   }

   public CrmWinningContractWarehousing setReportingStatus(final Boolean reportingStatus) {
      this.reportingStatus = reportingStatus;
      return this;
   }

   public CrmWinningContractWarehousing setNumberOfBidsParticipated(final Integer numberOfBidsParticipated) {
      this.numberOfBidsParticipated = numberOfBidsParticipated;
      return this;
   }

   public CrmWinningContractWarehousing setBidRanking(final Integer bidRanking) {
      this.bidRanking = bidRanking;
      return this;
   }

   public CrmWinningContractWarehousing setReportingTime(final LocalDateTime reportingTime) {
      this.reportingTime = reportingTime;
      return this;
   }

   public CrmWinningContractWarehousing setReportingUserId(final Long reportingUserId) {
      this.reportingUserId = reportingUserId;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionOrganizationReportingStatus(final Boolean constructionOrganizationReportingStatus) {
      this.constructionOrganizationReportingStatus = constructionOrganizationReportingStatus;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionOrganizationReportingTime(final LocalDateTime constructionOrganizationReportingTime) {
      this.constructionOrganizationReportingTime = constructionOrganizationReportingTime;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionOrganizationReportingUserId(final Long constructionOrganizationReportingUserId) {
      this.constructionOrganizationReportingUserId = constructionOrganizationReportingUserId;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionSupportServiceReportingStatus(final Boolean constructionSupportServiceReportingStatus) {
      this.constructionSupportServiceReportingStatus = constructionSupportServiceReportingStatus;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionSupportServiceReportingTime(final LocalDateTime constructionSupportServiceReportingTime) {
      this.constructionSupportServiceReportingTime = constructionSupportServiceReportingTime;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionSupportServiceReportingUserId(final Long constructionSupportServiceReportingUserId) {
      this.constructionSupportServiceReportingUserId = constructionSupportServiceReportingUserId;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionCalculationReportingStatus(final Boolean constructionCalculationReportingStatus) {
      this.constructionCalculationReportingStatus = constructionCalculationReportingStatus;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionCalculationReportingTime(final LocalDateTime constructionCalculationReportingTime) {
      this.constructionCalculationReportingTime = constructionCalculationReportingTime;
      return this;
   }

   public CrmWinningContractWarehousing setConstructionCalculationReportingUserId(final Long constructionCalculationReportingUserId) {
      this.constructionCalculationReportingUserId = constructionCalculationReportingUserId;
      return this;
   }

   public CrmWinningContractWarehousing setAnimationReportingStatus(final Boolean animationReportingStatus) {
      this.animationReportingStatus = animationReportingStatus;
      return this;
   }

   public CrmWinningContractWarehousing setAnimationReportingTime(final LocalDateTime animationReportingTime) {
      this.animationReportingTime = animationReportingTime;
      return this;
   }

   public CrmWinningContractWarehousing setAnimationReportingUserId(final Long animationReportingUserId) {
      this.animationReportingUserId = animationReportingUserId;
      return this;
   }

   public CrmWinningContractWarehousing setInnovationReportingStatus(final Boolean innovationReportingStatus) {
      this.innovationReportingStatus = innovationReportingStatus;
      return this;
   }

   public CrmWinningContractWarehousing setInnovationReportingTime(final LocalDateTime innovationReportingTime) {
      this.innovationReportingTime = innovationReportingTime;
      return this;
   }

   public CrmWinningContractWarehousing setInnovationReportingUserId(final Long innovationReportingUserId) {
      this.innovationReportingUserId = innovationReportingUserId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmWinningContractWarehousing(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", estimatedWorks="
         + this.getEstimatedWorks()
         + ", shortName="
         + this.getShortName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", projectName="
         + this.getProjectName()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", amount="
         + this.getAmount()
         + ", structureTypeConfigurationId="
         + this.getStructureTypeConfigurationId()
         + ", areaOfStructure="
         + this.getAreaOfStructure()
         + ", taxRate="
         + this.getTaxRate()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", structuralRemark="
         + this.getStructuralRemark()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", qualityGuaranteeDepositRemark="
         + this.getQualityGuaranteeDepositRemark()
         + ", partyAName="
         + this.getPartyAName()
         + ", partyAPersonName="
         + this.getPartyAPersonName()
         + ", partyAPhone="
         + this.getPartyAPhone()
         + ", partyBName="
         + this.getPartyBName()
         + ", partyBPersonName="
         + this.getPartyBPersonName()
         + ", partyBPhone="
         + this.getPartyBPhone()
         + ", partyCName="
         + this.getPartyCName()
         + ", partyCPersonName="
         + this.getPartyCPersonName()
         + ", partyCPhone="
         + this.getPartyCPhone()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", causeAnalysis="
         + this.getCauseAnalysis()
         + ", reasonsForBidFail="
         + this.getReasonsForBidFail()
         + ", reportingStatus="
         + this.getReportingStatus()
         + ", numberOfBidsParticipated="
         + this.getNumberOfBidsParticipated()
         + ", bidRanking="
         + this.getBidRanking()
         + ", reportingTime="
         + this.getReportingTime()
         + ", reportingUserId="
         + this.getReportingUserId()
         + ", constructionOrganizationReportingStatus="
         + this.getConstructionOrganizationReportingStatus()
         + ", constructionOrganizationReportingTime="
         + this.getConstructionOrganizationReportingTime()
         + ", constructionOrganizationReportingUserId="
         + this.getConstructionOrganizationReportingUserId()
         + ", constructionSupportServiceReportingStatus="
         + this.getConstructionSupportServiceReportingStatus()
         + ", constructionSupportServiceReportingTime="
         + this.getConstructionSupportServiceReportingTime()
         + ", constructionSupportServiceReportingUserId="
         + this.getConstructionSupportServiceReportingUserId()
         + ", constructionCalculationReportingStatus="
         + this.getConstructionCalculationReportingStatus()
         + ", constructionCalculationReportingTime="
         + this.getConstructionCalculationReportingTime()
         + ", constructionCalculationReportingUserId="
         + this.getConstructionCalculationReportingUserId()
         + ", animationReportingStatus="
         + this.getAnimationReportingStatus()
         + ", animationReportingTime="
         + this.getAnimationReportingTime()
         + ", animationReportingUserId="
         + this.getAnimationReportingUserId()
         + ", innovationReportingStatus="
         + this.getInnovationReportingStatus()
         + ", innovationReportingTime="
         + this.getInnovationReportingTime()
         + ", innovationReportingUserId="
         + this.getInnovationReportingUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmWinningContractWarehousing)) {
         return false;
      }

      CrmWinningContractWarehousing other = (CrmWinningContractWarehousing)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
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
                     Object this$structureTypeConfigurationId = this.getStructureTypeConfigurationId();
                     Object other$structureTypeConfigurationId = other.getStructureTypeConfigurationId();
                     if (this$structureTypeConfigurationId == null
                        ? other$structureTypeConfigurationId == null
                        : this$structureTypeConfigurationId.equals(other$structureTypeConfigurationId)) {
                        Object this$reportingStatus = this.getReportingStatus();
                        Object other$reportingStatus = other.getReportingStatus();
                        if (this$reportingStatus == null ? other$reportingStatus == null : this$reportingStatus.equals(other$reportingStatus)) {
                           Object this$numberOfBidsParticipated = this.getNumberOfBidsParticipated();
                           Object other$numberOfBidsParticipated = other.getNumberOfBidsParticipated();
                           if (this$numberOfBidsParticipated == null
                              ? other$numberOfBidsParticipated == null
                              : this$numberOfBidsParticipated.equals(other$numberOfBidsParticipated)) {
                              Object this$bidRanking = this.getBidRanking();
                              Object other$bidRanking = other.getBidRanking();
                              if (this$bidRanking == null ? other$bidRanking == null : this$bidRanking.equals(other$bidRanking)) {
                                 Object this$reportingUserId = this.getReportingUserId();
                                 Object other$reportingUserId = other.getReportingUserId();
                                 if (this$reportingUserId == null ? other$reportingUserId == null : this$reportingUserId.equals(other$reportingUserId)) {
                                    Object this$constructionOrganizationReportingStatus = this.getConstructionOrganizationReportingStatus();
                                    Object other$constructionOrganizationReportingStatus = other.getConstructionOrganizationReportingStatus();
                                    if (this$constructionOrganizationReportingStatus == null
                                       ? other$constructionOrganizationReportingStatus == null
                                       : this$constructionOrganizationReportingStatus.equals(other$constructionOrganizationReportingStatus)) {
                                       Object this$constructionOrganizationReportingUserId = this.getConstructionOrganizationReportingUserId();
                                       Object other$constructionOrganizationReportingUserId = other.getConstructionOrganizationReportingUserId();
                                       if (this$constructionOrganizationReportingUserId == null
                                          ? other$constructionOrganizationReportingUserId == null
                                          : this$constructionOrganizationReportingUserId.equals(other$constructionOrganizationReportingUserId)) {
                                          Object this$constructionSupportServiceReportingStatus = this.getConstructionSupportServiceReportingStatus();
                                          Object other$constructionSupportServiceReportingStatus = other.getConstructionSupportServiceReportingStatus();
                                          if (this$constructionSupportServiceReportingStatus == null
                                             ? other$constructionSupportServiceReportingStatus == null
                                             : this$constructionSupportServiceReportingStatus.equals(other$constructionSupportServiceReportingStatus)) {
                                             Object this$constructionSupportServiceReportingUserId = this.getConstructionSupportServiceReportingUserId();
                                             Object other$constructionSupportServiceReportingUserId = other.getConstructionSupportServiceReportingUserId();
                                             if (this$constructionSupportServiceReportingUserId == null
                                                ? other$constructionSupportServiceReportingUserId == null
                                                : this$constructionSupportServiceReportingUserId.equals(other$constructionSupportServiceReportingUserId)) {
                                                Object this$constructionCalculationReportingStatus = this.getConstructionCalculationReportingStatus();
                                                Object other$constructionCalculationReportingStatus = other.getConstructionCalculationReportingStatus();
                                                if (this$constructionCalculationReportingStatus == null
                                                   ? other$constructionCalculationReportingStatus == null
                                                   : this$constructionCalculationReportingStatus.equals(other$constructionCalculationReportingStatus)) {
                                                   Object this$constructionCalculationReportingUserId = this.getConstructionCalculationReportingUserId();
                                                   Object other$constructionCalculationReportingUserId = other.getConstructionCalculationReportingUserId();
                                                   if (this$constructionCalculationReportingUserId == null
                                                      ? other$constructionCalculationReportingUserId == null
                                                      : this$constructionCalculationReportingUserId.equals(other$constructionCalculationReportingUserId)) {
                                                      Object this$animationReportingStatus = this.getAnimationReportingStatus();
                                                      Object other$animationReportingStatus = other.getAnimationReportingStatus();
                                                      if (this$animationReportingStatus == null
                                                         ? other$animationReportingStatus == null
                                                         : this$animationReportingStatus.equals(other$animationReportingStatus)) {
                                                         Object this$animationReportingUserId = this.getAnimationReportingUserId();
                                                         Object other$animationReportingUserId = other.getAnimationReportingUserId();
                                                         if (this$animationReportingUserId == null
                                                            ? other$animationReportingUserId == null
                                                            : this$animationReportingUserId.equals(other$animationReportingUserId)) {
                                                            Object this$innovationReportingStatus = this.getInnovationReportingStatus();
                                                            Object other$innovationReportingStatus = other.getInnovationReportingStatus();
                                                            if (this$innovationReportingStatus == null
                                                               ? other$innovationReportingStatus == null
                                                               : this$innovationReportingStatus.equals(other$innovationReportingStatus)) {
                                                               Object this$innovationReportingUserId = this.getInnovationReportingUserId();
                                                               Object other$innovationReportingUserId = other.getInnovationReportingUserId();
                                                               if (this$innovationReportingUserId == null
                                                                  ? other$innovationReportingUserId == null
                                                                  : this$innovationReportingUserId.equals(other$innovationReportingUserId)) {
                                                                  Object this$estimatedWorks = this.getEstimatedWorks();
                                                                  Object other$estimatedWorks = other.getEstimatedWorks();
                                                                  if (this$estimatedWorks == null
                                                                     ? other$estimatedWorks == null
                                                                     : this$estimatedWorks.equals(other$estimatedWorks)) {
                                                                     Object this$shortName = this.getShortName();
                                                                     Object other$shortName = other.getShortName();
                                                                     if (this$shortName == null
                                                                        ? other$shortName == null
                                                                        : this$shortName.equals(other$shortName)) {
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
                                                                              Object this$amount = this.getAmount();
                                                                              Object other$amount = other.getAmount();
                                                                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)
                                                                                 )
                                                                               {
                                                                                 Object this$areaOfStructure = this.getAreaOfStructure();
                                                                                 Object other$areaOfStructure = other.getAreaOfStructure();
                                                                                 if (this$areaOfStructure == null
                                                                                    ? other$areaOfStructure == null
                                                                                    : this$areaOfStructure.equals(other$areaOfStructure)) {
                                                                                    Object this$taxRate = this.getTaxRate();
                                                                                    Object other$taxRate = other.getTaxRate();
                                                                                    if (this$taxRate == null
                                                                                       ? other$taxRate == null
                                                                                       : this$taxRate.equals(other$taxRate)) {
                                                                                       Object this$quantityWork = this.getQuantityWork();
                                                                                       Object other$quantityWork = other.getQuantityWork();
                                                                                       if (this$quantityWork == null
                                                                                          ? other$quantityWork == null
                                                                                          : this$quantityWork.equals(other$quantityWork)) {
                                                                                          Object this$structuralRemark = this.getStructuralRemark();
                                                                                          Object other$structuralRemark = other.getStructuralRemark();
                                                                                          if (this$structuralRemark == null
                                                                                             ? other$structuralRemark == null
                                                                                             : this$structuralRemark.equals(other$structuralRemark)) {
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
                                                                                                   Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                                                                   Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                                                                   if (this$qualityGuaranteeDeposit == null
                                                                                                      ? other$qualityGuaranteeDeposit == null
                                                                                                      : this$qualityGuaranteeDeposit.equals(
                                                                                                         other$qualityGuaranteeDeposit
                                                                                                      )) {
                                                                                                      Object this$qualityGuaranteeDepositRemark = this.getQualityGuaranteeDepositRemark();
                                                                                                      Object other$qualityGuaranteeDepositRemark = other.getQualityGuaranteeDepositRemark();
                                                                                                      if (this$qualityGuaranteeDepositRemark == null
                                                                                                         ? other$qualityGuaranteeDepositRemark == null
                                                                                                         : this$qualityGuaranteeDepositRemark.equals(
                                                                                                            other$qualityGuaranteeDepositRemark
                                                                                                         )) {
                                                                                                         Object this$partyAName = this.getPartyAName();
                                                                                                         Object other$partyAName = other.getPartyAName();
                                                                                                         if (this$partyAName == null
                                                                                                            ? other$partyAName == null
                                                                                                            : this$partyAName.equals(other$partyAName)) {
                                                                                                            Object this$partyAPersonName = this.getPartyAPersonName();
                                                                                                            Object other$partyAPersonName = other.getPartyAPersonName();
                                                                                                            if (this$partyAPersonName == null
                                                                                                               ? other$partyAPersonName == null
                                                                                                               : this$partyAPersonName.equals(
                                                                                                                  other$partyAPersonName
                                                                                                               )) {
                                                                                                               Object this$partyAPhone = this.getPartyAPhone();
                                                                                                               Object other$partyAPhone = other.getPartyAPhone();
                                                                                                               if (this$partyAPhone == null
                                                                                                                  ? other$partyAPhone == null
                                                                                                                  : this$partyAPhone.equals(other$partyAPhone)) {
                                                                                                                  Object this$partyBName = this.getPartyBName();
                                                                                                                  Object other$partyBName = other.getPartyBName();
                                                                                                                  if (this$partyBName == null
                                                                                                                     ? other$partyBName == null
                                                                                                                     : this$partyBName.equals(other$partyBName)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$partyBPersonName = this.getPartyBPersonName();
                                                                                                                     Object other$partyBPersonName = other.getPartyBPersonName();
                                                                                                                     if (this$partyBPersonName == null
                                                                                                                        ? other$partyBPersonName == null
                                                                                                                        : this$partyBPersonName.equals(
                                                                                                                           other$partyBPersonName
                                                                                                                        )) {
                                                                                                                        Object this$partyBPhone = this.getPartyBPhone();
                                                                                                                        Object other$partyBPhone = other.getPartyBPhone();
                                                                                                                        if (this$partyBPhone == null
                                                                                                                           ? other$partyBPhone == null
                                                                                                                           : this$partyBPhone.equals(
                                                                                                                              other$partyBPhone
                                                                                                                           )) {
                                                                                                                           Object this$partyCName = this.getPartyCName();
                                                                                                                           Object other$partyCName = other.getPartyCName();
                                                                                                                           if (this$partyCName == null
                                                                                                                              ? other$partyCName == null
                                                                                                                              : this$partyCName.equals(
                                                                                                                                 other$partyCName
                                                                                                                              )) {
                                                                                                                              Object this$partyCPersonName = this.getPartyCPersonName();
                                                                                                                              Object other$partyCPersonName = other.getPartyCPersonName();
                                                                                                                              if (this$partyCPersonName == null
                                                                                                                                 ? other$partyCPersonName
                                                                                                                                    == null
                                                                                                                                 : this$partyCPersonName.equals(
                                                                                                                                    other$partyCPersonName
                                                                                                                                 )) {
                                                                                                                                 Object this$partyCPhone = this.getPartyCPhone();
                                                                                                                                 Object other$partyCPhone = other.getPartyCPhone();
                                                                                                                                 if (this$partyCPhone == null
                                                                                                                                    ? other$partyCPhone == null
                                                                                                                                    : this$partyCPhone.equals(
                                                                                                                                       other$partyCPhone
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
                                                                                                                                       Object this$attachmentIds = this.getAttachmentIds();
                                                                                                                                       Object other$attachmentIds = other.getAttachmentIds();
                                                                                                                                       if (this$attachmentIds
                                                                                                                                             == null
                                                                                                                                          ? other$attachmentIds
                                                                                                                                             == null
                                                                                                                                          : this$attachmentIds.equals(
                                                                                                                                             other$attachmentIds
                                                                                                                                          )) {
                                                                                                                                          Object this$remark = this.getRemark();
                                                                                                                                          Object other$remark = other.getRemark();
                                                                                                                                          if (this$remark
                                                                                                                                                == null
                                                                                                                                             ? other$remark
                                                                                                                                                == null
                                                                                                                                             : this$remark.equals(
                                                                                                                                                other$remark
                                                                                                                                             )) {
                                                                                                                                             Object this$causeAnalysis = this.getCauseAnalysis();
                                                                                                                                             Object other$causeAnalysis = other.getCauseAnalysis();
                                                                                                                                             if (this$causeAnalysis
                                                                                                                                                   == null
                                                                                                                                                ? other$causeAnalysis
                                                                                                                                                   == null
                                                                                                                                                : this$causeAnalysis.equals(
                                                                                                                                                   other$causeAnalysis
                                                                                                                                                )) {
                                                                                                                                                Object this$reasonsForBidFail = this.getReasonsForBidFail();
                                                                                                                                                Object other$reasonsForBidFail = other.getReasonsForBidFail();
                                                                                                                                                if (this$reasonsForBidFail
                                                                                                                                                      == null
                                                                                                                                                   ? other$reasonsForBidFail
                                                                                                                                                      == null
                                                                                                                                                   : this$reasonsForBidFail.equals(
                                                                                                                                                      other$reasonsForBidFail
                                                                                                                                                   )) {
                                                                                                                                                   Object this$reportingTime = this.getReportingTime();
                                                                                                                                                   Object other$reportingTime = other.getReportingTime();
                                                                                                                                                   if (this$reportingTime
                                                                                                                                                         == null
                                                                                                                                                      ? other$reportingTime
                                                                                                                                                         == null
                                                                                                                                                      : this$reportingTime.equals(
                                                                                                                                                         other$reportingTime
                                                                                                                                                      )) {
                                                                                                                                                      Object this$constructionOrganizationReportingTime = this.getConstructionOrganizationReportingTime();
                                                                                                                                                      Object other$constructionOrganizationReportingTime = other.getConstructionOrganizationReportingTime();
                                                                                                                                                      if (this$constructionOrganizationReportingTime
                                                                                                                                                            == null
                                                                                                                                                         ? other$constructionOrganizationReportingTime
                                                                                                                                                            == null
                                                                                                                                                         : this$constructionOrganizationReportingTime.equals(
                                                                                                                                                            other$constructionOrganizationReportingTime
                                                                                                                                                         )) {
                                                                                                                                                         Object this$constructionSupportServiceReportingTime = this.getConstructionSupportServiceReportingTime();
                                                                                                                                                         Object other$constructionSupportServiceReportingTime = other.getConstructionSupportServiceReportingTime();
                                                                                                                                                         if (this$constructionSupportServiceReportingTime
                                                                                                                                                               == null
                                                                                                                                                            ? other$constructionSupportServiceReportingTime
                                                                                                                                                               == null
                                                                                                                                                            : this$constructionSupportServiceReportingTime.equals(
                                                                                                                                                               other$constructionSupportServiceReportingTime
                                                                                                                                                            )) {
                                                                                                                                                            Object this$constructionCalculationReportingTime = this.getConstructionCalculationReportingTime();
                                                                                                                                                            Object other$constructionCalculationReportingTime = other.getConstructionCalculationReportingTime();
                                                                                                                                                            if (this$constructionCalculationReportingTime
                                                                                                                                                                  == null
                                                                                                                                                               ? other$constructionCalculationReportingTime
                                                                                                                                                                  == null
                                                                                                                                                               : this$constructionCalculationReportingTime.equals(
                                                                                                                                                                  other$constructionCalculationReportingTime
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$animationReportingTime = this.getAnimationReportingTime();
                                                                                                                                                               Object other$animationReportingTime = other.getAnimationReportingTime();
                                                                                                                                                               if (this$animationReportingTime
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$animationReportingTime
                                                                                                                                                                     == null
                                                                                                                                                                  : this$animationReportingTime.equals(
                                                                                                                                                                     other$animationReportingTime
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$innovationReportingTime = this.getInnovationReportingTime();
                                                                                                                                                                  Object other$innovationReportingTime = other.getInnovationReportingTime();
                                                                                                                                                                  return this$innovationReportingTime
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$innovationReportingTime
                                                                                                                                                                        == null
                                                                                                                                                                     : this$innovationReportingTime.equals(
                                                                                                                                                                        other$innovationReportingTime
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmWinningContractWarehousing;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $structureTypeConfigurationId = this.getStructureTypeConfigurationId();
      result = result * 59 + ($structureTypeConfigurationId == null ? 43 : $structureTypeConfigurationId.hashCode());
      Object $reportingStatus = this.getReportingStatus();
      result = result * 59 + ($reportingStatus == null ? 43 : $reportingStatus.hashCode());
      Object $numberOfBidsParticipated = this.getNumberOfBidsParticipated();
      result = result * 59 + ($numberOfBidsParticipated == null ? 43 : $numberOfBidsParticipated.hashCode());
      Object $bidRanking = this.getBidRanking();
      result = result * 59 + ($bidRanking == null ? 43 : $bidRanking.hashCode());
      Object $reportingUserId = this.getReportingUserId();
      result = result * 59 + ($reportingUserId == null ? 43 : $reportingUserId.hashCode());
      Object $constructionOrganizationReportingStatus = this.getConstructionOrganizationReportingStatus();
      result = result * 59 + ($constructionOrganizationReportingStatus == null ? 43 : $constructionOrganizationReportingStatus.hashCode());
      Object $constructionOrganizationReportingUserId = this.getConstructionOrganizationReportingUserId();
      result = result * 59 + ($constructionOrganizationReportingUserId == null ? 43 : $constructionOrganizationReportingUserId.hashCode());
      Object $constructionSupportServiceReportingStatus = this.getConstructionSupportServiceReportingStatus();
      result = result * 59 + ($constructionSupportServiceReportingStatus == null ? 43 : $constructionSupportServiceReportingStatus.hashCode());
      Object $constructionSupportServiceReportingUserId = this.getConstructionSupportServiceReportingUserId();
      result = result * 59 + ($constructionSupportServiceReportingUserId == null ? 43 : $constructionSupportServiceReportingUserId.hashCode());
      Object $constructionCalculationReportingStatus = this.getConstructionCalculationReportingStatus();
      result = result * 59 + ($constructionCalculationReportingStatus == null ? 43 : $constructionCalculationReportingStatus.hashCode());
      Object $constructionCalculationReportingUserId = this.getConstructionCalculationReportingUserId();
      result = result * 59 + ($constructionCalculationReportingUserId == null ? 43 : $constructionCalculationReportingUserId.hashCode());
      Object $animationReportingStatus = this.getAnimationReportingStatus();
      result = result * 59 + ($animationReportingStatus == null ? 43 : $animationReportingStatus.hashCode());
      Object $animationReportingUserId = this.getAnimationReportingUserId();
      result = result * 59 + ($animationReportingUserId == null ? 43 : $animationReportingUserId.hashCode());
      Object $innovationReportingStatus = this.getInnovationReportingStatus();
      result = result * 59 + ($innovationReportingStatus == null ? 43 : $innovationReportingStatus.hashCode());
      Object $innovationReportingUserId = this.getInnovationReportingUserId();
      result = result * 59 + ($innovationReportingUserId == null ? 43 : $innovationReportingUserId.hashCode());
      Object $estimatedWorks = this.getEstimatedWorks();
      result = result * 59 + ($estimatedWorks == null ? 43 : $estimatedWorks.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $structuralRemark = this.getStructuralRemark();
      result = result * 59 + ($structuralRemark == null ? 43 : $structuralRemark.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $qualityGuaranteeDepositRemark = this.getQualityGuaranteeDepositRemark();
      result = result * 59 + ($qualityGuaranteeDepositRemark == null ? 43 : $qualityGuaranteeDepositRemark.hashCode());
      Object $partyAName = this.getPartyAName();
      result = result * 59 + ($partyAName == null ? 43 : $partyAName.hashCode());
      Object $partyAPersonName = this.getPartyAPersonName();
      result = result * 59 + ($partyAPersonName == null ? 43 : $partyAPersonName.hashCode());
      Object $partyAPhone = this.getPartyAPhone();
      result = result * 59 + ($partyAPhone == null ? 43 : $partyAPhone.hashCode());
      Object $partyBName = this.getPartyBName();
      result = result * 59 + ($partyBName == null ? 43 : $partyBName.hashCode());
      Object $partyBPersonName = this.getPartyBPersonName();
      result = result * 59 + ($partyBPersonName == null ? 43 : $partyBPersonName.hashCode());
      Object $partyBPhone = this.getPartyBPhone();
      result = result * 59 + ($partyBPhone == null ? 43 : $partyBPhone.hashCode());
      Object $partyCName = this.getPartyCName();
      result = result * 59 + ($partyCName == null ? 43 : $partyCName.hashCode());
      Object $partyCPersonName = this.getPartyCPersonName();
      result = result * 59 + ($partyCPersonName == null ? 43 : $partyCPersonName.hashCode());
      Object $partyCPhone = this.getPartyCPhone();
      result = result * 59 + ($partyCPhone == null ? 43 : $partyCPhone.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $causeAnalysis = this.getCauseAnalysis();
      result = result * 59 + ($causeAnalysis == null ? 43 : $causeAnalysis.hashCode());
      Object $reasonsForBidFail = this.getReasonsForBidFail();
      result = result * 59 + ($reasonsForBidFail == null ? 43 : $reasonsForBidFail.hashCode());
      Object $reportingTime = this.getReportingTime();
      result = result * 59 + ($reportingTime == null ? 43 : $reportingTime.hashCode());
      Object $constructionOrganizationReportingTime = this.getConstructionOrganizationReportingTime();
      result = result * 59 + ($constructionOrganizationReportingTime == null ? 43 : $constructionOrganizationReportingTime.hashCode());
      Object $constructionSupportServiceReportingTime = this.getConstructionSupportServiceReportingTime();
      result = result * 59 + ($constructionSupportServiceReportingTime == null ? 43 : $constructionSupportServiceReportingTime.hashCode());
      Object $constructionCalculationReportingTime = this.getConstructionCalculationReportingTime();
      result = result * 59 + ($constructionCalculationReportingTime == null ? 43 : $constructionCalculationReportingTime.hashCode());
      Object $animationReportingTime = this.getAnimationReportingTime();
      result = result * 59 + ($animationReportingTime == null ? 43 : $animationReportingTime.hashCode());
      Object $innovationReportingTime = this.getInnovationReportingTime();
      return result * 59 + ($innovationReportingTime == null ? 43 : $innovationReportingTime.hashCode());
   }

   public static class CrmWinningContractWarehousingBuilder {
      private Long id;
      private Long createUserId;
      private Long informantUserId;
      private BigDecimal estimatedWorks;
      private String shortName;
      private Long departmentId;
      private LocalDateTime informantDateTime;
      private String projectName;
      private Long crmProjectInformationWarehousingId;
      private BigDecimal amount;
      private Long structureTypeConfigurationId;
      private BigDecimal areaOfStructure;
      private BigDecimal taxRate;
      private BigDecimal quantityWork;
      private String structuralRemark;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private BigDecimal qualityGuaranteeDeposit;
      private String qualityGuaranteeDepositRemark;
      private String partyAName;
      private String partyAPersonName;
      private String partyAPhone;
      private String partyBName;
      private String partyBPersonName;
      private String partyBPhone;
      private String partyCName;
      private String partyCPersonName;
      private String partyCPhone;
      private String paymentMethod;
      private String attachmentIds;
      private String remark;
      private String causeAnalysis;
      private String reasonsForBidFail;
      private Boolean reportingStatus;
      private Integer numberOfBidsParticipated;
      private Integer bidRanking;
      private LocalDateTime reportingTime;
      private Long reportingUserId;
      private Boolean constructionOrganizationReportingStatus;
      private LocalDateTime constructionOrganizationReportingTime;
      private Long constructionOrganizationReportingUserId;
      private Boolean constructionSupportServiceReportingStatus;
      private LocalDateTime constructionSupportServiceReportingTime;
      private Long constructionSupportServiceReportingUserId;
      private Boolean constructionCalculationReportingStatus;
      private LocalDateTime constructionCalculationReportingTime;
      private Long constructionCalculationReportingUserId;
      private Boolean animationReportingStatus;
      private LocalDateTime animationReportingTime;
      private Long animationReportingUserId;
      private Boolean innovationReportingStatus;
      private LocalDateTime innovationReportingTime;
      private Long innovationReportingUserId;

      CrmWinningContractWarehousingBuilder() {
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder estimatedWorks(final BigDecimal estimatedWorks) {
         this.estimatedWorks = estimatedWorks;
         return this;
      }

      @JsonProperty("shortName")
      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder structureTypeConfigurationId(final Long structureTypeConfigurationId) {
         this.structureTypeConfigurationId = structureTypeConfigurationId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder areaOfStructure(final BigDecimal areaOfStructure) {
         this.areaOfStructure = areaOfStructure;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder structuralRemark(final String structuralRemark) {
         this.structuralRemark = structuralRemark;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder qualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
         this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder qualityGuaranteeDepositRemark(final String qualityGuaranteeDepositRemark) {
         this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyAName(final String partyAName) {
         this.partyAName = partyAName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyAPersonName(final String partyAPersonName) {
         this.partyAPersonName = partyAPersonName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyAPhone(final String partyAPhone) {
         this.partyAPhone = partyAPhone;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyBName(final String partyBName) {
         this.partyBName = partyBName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyBPersonName(final String partyBPersonName) {
         this.partyBPersonName = partyBPersonName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyBPhone(final String partyBPhone) {
         this.partyBPhone = partyBPhone;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyCName(final String partyCName) {
         this.partyCName = partyCName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyCPersonName(final String partyCPersonName) {
         this.partyCPersonName = partyCPersonName;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder partyCPhone(final String partyCPhone) {
         this.partyCPhone = partyCPhone;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder causeAnalysis(final String causeAnalysis) {
         this.causeAnalysis = causeAnalysis;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder reasonsForBidFail(final String reasonsForBidFail) {
         this.reasonsForBidFail = reasonsForBidFail;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder reportingStatus(final Boolean reportingStatus) {
         this.reportingStatus = reportingStatus;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder numberOfBidsParticipated(final Integer numberOfBidsParticipated) {
         this.numberOfBidsParticipated = numberOfBidsParticipated;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder bidRanking(final Integer bidRanking) {
         this.bidRanking = bidRanking;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder reportingTime(final LocalDateTime reportingTime) {
         this.reportingTime = reportingTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder reportingUserId(final Long reportingUserId) {
         this.reportingUserId = reportingUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionOrganizationReportingStatus(
         final Boolean constructionOrganizationReportingStatus
      ) {
         this.constructionOrganizationReportingStatus = constructionOrganizationReportingStatus;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionOrganizationReportingTime(
         final LocalDateTime constructionOrganizationReportingTime
      ) {
         this.constructionOrganizationReportingTime = constructionOrganizationReportingTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionOrganizationReportingUserId(
         final Long constructionOrganizationReportingUserId
      ) {
         this.constructionOrganizationReportingUserId = constructionOrganizationReportingUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionSupportServiceReportingStatus(
         final Boolean constructionSupportServiceReportingStatus
      ) {
         this.constructionSupportServiceReportingStatus = constructionSupportServiceReportingStatus;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionSupportServiceReportingTime(
         final LocalDateTime constructionSupportServiceReportingTime
      ) {
         this.constructionSupportServiceReportingTime = constructionSupportServiceReportingTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionSupportServiceReportingUserId(
         final Long constructionSupportServiceReportingUserId
      ) {
         this.constructionSupportServiceReportingUserId = constructionSupportServiceReportingUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionCalculationReportingStatus(
         final Boolean constructionCalculationReportingStatus
      ) {
         this.constructionCalculationReportingStatus = constructionCalculationReportingStatus;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionCalculationReportingTime(
         final LocalDateTime constructionCalculationReportingTime
      ) {
         this.constructionCalculationReportingTime = constructionCalculationReportingTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder constructionCalculationReportingUserId(
         final Long constructionCalculationReportingUserId
      ) {
         this.constructionCalculationReportingUserId = constructionCalculationReportingUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder animationReportingStatus(final Boolean animationReportingStatus) {
         this.animationReportingStatus = animationReportingStatus;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder animationReportingTime(final LocalDateTime animationReportingTime) {
         this.animationReportingTime = animationReportingTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder animationReportingUserId(final Long animationReportingUserId) {
         this.animationReportingUserId = animationReportingUserId;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder innovationReportingStatus(final Boolean innovationReportingStatus) {
         this.innovationReportingStatus = innovationReportingStatus;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder innovationReportingTime(final LocalDateTime innovationReportingTime) {
         this.innovationReportingTime = innovationReportingTime;
         return this;
      }

      public CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder innovationReportingUserId(final Long innovationReportingUserId) {
         this.innovationReportingUserId = innovationReportingUserId;
         return this;
      }

      public CrmWinningContractWarehousing build() {
         return new CrmWinningContractWarehousing(
            this.id,
            this.createUserId,
            this.informantUserId,
            this.estimatedWorks,
            this.shortName,
            this.departmentId,
            this.informantDateTime,
            this.projectName,
            this.crmProjectInformationWarehousingId,
            this.amount,
            this.structureTypeConfigurationId,
            this.areaOfStructure,
            this.taxRate,
            this.quantityWork,
            this.structuralRemark,
            this.startDate,
            this.endDate,
            this.qualityGuaranteeDeposit,
            this.qualityGuaranteeDepositRemark,
            this.partyAName,
            this.partyAPersonName,
            this.partyAPhone,
            this.partyBName,
            this.partyBPersonName,
            this.partyBPhone,
            this.partyCName,
            this.partyCPersonName,
            this.partyCPhone,
            this.paymentMethod,
            this.attachmentIds,
            this.remark,
            this.causeAnalysis,
            this.reasonsForBidFail,
            this.reportingStatus,
            this.numberOfBidsParticipated,
            this.bidRanking,
            this.reportingTime,
            this.reportingUserId,
            this.constructionOrganizationReportingStatus,
            this.constructionOrganizationReportingTime,
            this.constructionOrganizationReportingUserId,
            this.constructionSupportServiceReportingStatus,
            this.constructionSupportServiceReportingTime,
            this.constructionSupportServiceReportingUserId,
            this.constructionCalculationReportingStatus,
            this.constructionCalculationReportingTime,
            this.constructionCalculationReportingUserId,
            this.animationReportingStatus,
            this.animationReportingTime,
            this.animationReportingUserId,
            this.innovationReportingStatus,
            this.innovationReportingTime,
            this.innovationReportingUserId
         );
      }

      @Override
      public String toString() {
         return "CrmWinningContractWarehousing.CrmWinningContractWarehousingBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", informantUserId="
            + this.informantUserId
            + ", estimatedWorks="
            + this.estimatedWorks
            + ", shortName="
            + this.shortName
            + ", departmentId="
            + this.departmentId
            + ", informantDateTime="
            + this.informantDateTime
            + ", projectName="
            + this.projectName
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", amount="
            + this.amount
            + ", structureTypeConfigurationId="
            + this.structureTypeConfigurationId
            + ", areaOfStructure="
            + this.areaOfStructure
            + ", taxRate="
            + this.taxRate
            + ", quantityWork="
            + this.quantityWork
            + ", structuralRemark="
            + this.structuralRemark
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", qualityGuaranteeDeposit="
            + this.qualityGuaranteeDeposit
            + ", qualityGuaranteeDepositRemark="
            + this.qualityGuaranteeDepositRemark
            + ", partyAName="
            + this.partyAName
            + ", partyAPersonName="
            + this.partyAPersonName
            + ", partyAPhone="
            + this.partyAPhone
            + ", partyBName="
            + this.partyBName
            + ", partyBPersonName="
            + this.partyBPersonName
            + ", partyBPhone="
            + this.partyBPhone
            + ", partyCName="
            + this.partyCName
            + ", partyCPersonName="
            + this.partyCPersonName
            + ", partyCPhone="
            + this.partyCPhone
            + ", paymentMethod="
            + this.paymentMethod
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", causeAnalysis="
            + this.causeAnalysis
            + ", reasonsForBidFail="
            + this.reasonsForBidFail
            + ", reportingStatus="
            + this.reportingStatus
            + ", numberOfBidsParticipated="
            + this.numberOfBidsParticipated
            + ", bidRanking="
            + this.bidRanking
            + ", reportingTime="
            + this.reportingTime
            + ", reportingUserId="
            + this.reportingUserId
            + ", constructionOrganizationReportingStatus="
            + this.constructionOrganizationReportingStatus
            + ", constructionOrganizationReportingTime="
            + this.constructionOrganizationReportingTime
            + ", constructionOrganizationReportingUserId="
            + this.constructionOrganizationReportingUserId
            + ", constructionSupportServiceReportingStatus="
            + this.constructionSupportServiceReportingStatus
            + ", constructionSupportServiceReportingTime="
            + this.constructionSupportServiceReportingTime
            + ", constructionSupportServiceReportingUserId="
            + this.constructionSupportServiceReportingUserId
            + ", constructionCalculationReportingStatus="
            + this.constructionCalculationReportingStatus
            + ", constructionCalculationReportingTime="
            + this.constructionCalculationReportingTime
            + ", constructionCalculationReportingUserId="
            + this.constructionCalculationReportingUserId
            + ", animationReportingStatus="
            + this.animationReportingStatus
            + ", animationReportingTime="
            + this.animationReportingTime
            + ", animationReportingUserId="
            + this.animationReportingUserId
            + ", innovationReportingStatus="
            + this.innovationReportingStatus
            + ", innovationReportingTime="
            + this.innovationReportingTime
            + ", innovationReportingUserId="
            + this.innovationReportingUserId
            + ")";
      }
   }
}
