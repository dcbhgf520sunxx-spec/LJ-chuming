package com.hzchum.scim.contract.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "ContractRegistration对象", description = "合同登记")
@Entity
@TableName("contract_registration")
@Table(name = "contract_registration")
public class ContractRegistration extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "registrationNo", value = "合同登记编号", notes = "合同登记编号")
   @JsonProperty("registrationNo")
   @JSONField(name = "registrationNo")
   @TableField("registration_no")
   @Column(name = "registration_no", columnDefinition = "varchar(255) comment '合同登记编号'")
   private String registrationNo;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号", notes = "合同目录编号")
   @JsonProperty("contractNumber")
   @JSONField(name = "contractNumber")
   @TableField("contract_number")
   @Column(name = "contract_number", columnDefinition = "varchar(255) comment '合同目录编号'")
   private String contractNumber;
   @ApiModelProperty(name = "registrationType", value = "登记类型 1评审登记 2直接登记", notes = "登记类型 1评审登记 2直接登记")
   @JsonProperty("registrationType")
   @TableField("registration_type")
   @Column(name = "registration_type", columnDefinition = "int(11) comment '登记类型 1评审登记 2直接登记'")
   private Integer registrationType;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   @JsonProperty("title")
   @JSONField(name = "title")
   @TableField("title")
   @Column(name = "title", columnDefinition = "varchar(255) comment '标题'")
   private String title;
   @ApiModelProperty(name = "preRegistrationId", value = "预登记ID", notes = "预登记ID")
   @JsonProperty("preRegistrationId")
   @JSONField(name = "preRegistrationId")
   @TableField("pre_registration_id")
   @Column(name = "pre_registration_id", columnDefinition = "bigint comment '预登记ID'")
   private Long preRegistrationId;
   @ApiModelProperty(name = "contractCatalogueId", value = "合同目录ID", notes = "合同目录ID")
   @JsonProperty("contractCatalogueId")
   @JSONField(name = "contractCatalogueId")
   @TableField("contract_catalogue_id")
   @Column(name = "contract_catalogue_id", columnDefinition = "bigint comment '合同目录ID'")
   private Long contractCatalogueId;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint comment '申请人ID'")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255) comment '申请人名称'")
   private String applicantName;
   @ApiModelProperty(name = "applicantDeptId", value = "申请人部门Id", notes = "申请人部门Id")
   @JsonProperty("applicantDeptId")
   @JSONField(name = "applicantDeptId")
   @TableField("applicant_dept_id")
   @Column(name = "applicant_dept_id", columnDefinition = "bigint comment '申请人部门Id'")
   private Long applicantDeptId;
   @ApiModelProperty(name = "applicationNumber", value = "申请编号", notes = "申请编号")
   @JsonProperty("applicationNumber")
   @JSONField(name = "applicationNumber")
   @TableField("application_number")
   @Column(name = "application_number", columnDefinition = "varchar(255) comment '申请编号'")
   private String applicationNumber;
   @ApiModelProperty(name = "applicationDate", value = "申请时间", notes = "申请时间")
   @JsonProperty("applicationDate")
   @JSONField(name = "applicationDate")
   @TableField("application_date")
   @Column(name = "application_date", columnDefinition = "datetime comment '申请时间'")
   private LocalDateTime applicationDate;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255) comment '项目名称'")
   private String projectName;
   @ApiModelProperty(name = "signerId", value = "签订人ID", notes = "签订人ID")
   @JsonProperty("signerId")
   @JSONField(name = "signerId")
   @TableField("signer_id")
   @Column(name = "signer_id", columnDefinition = "bigint comment '签订人ID'")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签订人姓名", notes = "签订人姓名")
   @JsonProperty("signerName")
   @JSONField(name = "signerName")
   @TableField("signer_name")
   @Column(name = "signer_name", columnDefinition = "varchar(255) comment '签订人姓名'")
   private String signerName;
   @ApiModelProperty(name = "firstLevelDept", value = "所属一级部门", notes = "所属一级部门")
   @JsonProperty("firstLevelDept")
   @JSONField(name = "firstLevelDept")
   @TableField("first_level_dept")
   @Column(name = "first_level_dept", columnDefinition = "bigint(20) comment '所属一级部门'")
   private Long firstLevelDept;
   @ApiModelProperty(name = "secondLevelDept", value = "所属二级部门", notes = "所属二级部门")
   @JsonProperty("secondLevelDept")
   @JSONField(name = "secondLevelDept")
   @TableField("second_level_dept")
   @Column(name = "second_level_dept", columnDefinition = "bigint(20) comment '所属二级部门'")
   private Long secondLevelDept;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）", notes = "合同金额（元）")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   @TableField("contract_amount")
   @Column(name = "contract_amount", columnDefinition = "decimal(19,2) comment '合同金额（元）'")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "contractType", value = "合同类型", notes = "合同类型")
   @JsonProperty("contractType")
   @JSONField(name = "contractType")
   @TableField("contract_type")
   @Column(name = "contract_type", columnDefinition = "bigint(20) comment '合同类型'")
   private Long contractType;
   @ApiModelProperty(name = "infoSource", value = "信息来源", notes = "信息来源")
   @JsonProperty("infoSource")
   @JSONField(name = "infoSource")
   @TableField("info_source")
   @Column(name = "info_source", columnDefinition = "bigint comment '信息来源'")
   private Integer infoSource;
   @ApiModelProperty(name = "projectManager", value = "项目经理", notes = "项目经理")
   @JsonProperty("projectManager")
   @JSONField(name = "projectManager")
   @TableField("project_manager")
   @Column(name = "project_manager", columnDefinition = "varchar(255) comment '项目经理'")
   private String projectManager;
   @ApiModelProperty(name = "boolCoordinate", value = "销售员是否配合", notes = "销售员是否配合")
   @JsonProperty("boolCoordinate")
   @JSONField(name = "boolCoordinate")
   @TableField("bool_coordinate")
   @Column(name = "bool_coordinate", columnDefinition = "tinyint(1) comment '销售员是否配合'")
   private Boolean boolCoordinate;
   @ApiModelProperty(name = "partyA", value = "甲方", notes = "甲方")
   @JsonProperty("partyA")
   @JSONField(name = "partyA")
   @TableField("party_a")
   @Column(name = "party_a", columnDefinition = "varchar(255) comment '甲方'")
   private String partyA;
   @ApiModelProperty(name = "partyB", value = "乙方", notes = "乙方")
   @JsonProperty("partyB")
   @JSONField(name = "partyB")
   @TableField("party_b")
   @Column(name = "party_b", columnDefinition = "varchar(255) comment '乙方'")
   private String partyB;
   @ApiModelProperty(name = "partyC", value = "丙方", notes = "丙方")
   @JsonProperty("partyC")
   @JSONField(name = "partyC")
   @TableField("party_c")
   @Column(name = "party_c", columnDefinition = "varchar(255) comment '丙方'")
   private String partyC;
   @ApiModelProperty(name = "partyD", value = "丁方", notes = "丁方")
   @JsonProperty("partyD")
   @JSONField(name = "partyD")
   @TableField("party_d")
   @Column(name = "party_d", columnDefinition = "varchar(255) comment '丁方'")
   private String partyD;
   @ApiModelProperty(name = "boolBidWinningNotice", value = "是否存在中标通知书", notes = "是否存在中标通知书")
   @JsonProperty("boolBidWinningNotice")
   @JSONField(name = "boolBidWinningNotice")
   @TableField("bool_bid_winning_notice")
   @Column(name = "bool_bid_winning_notice", columnDefinition = "tinyint(1) comment '是否存在中标通知书'")
   private Boolean boolBidWinningNotice;
   @ApiModelProperty(name = "drawing", value = "图纸 1有、2无、3电子版", notes = "图纸 1有、2无、3电子版")
   @JsonProperty("drawing")
   @JSONField(name = "drawing")
   @TableField("drawing")
   @Column(name = "drawing", columnDefinition = "int(11) comment '图纸'")
   private Integer drawing;
   @ApiModelProperty(name = "boolBidProposals", value = "是否有报价书", notes = "是否有报价书")
   @JsonProperty("boolBidProposals")
   @JSONField(name = "boolBidProposals")
   @TableField("bool_bid_proposals")
   @Column(name = "bool_bid_proposals", columnDefinition = "tinyint(1) comment '是否有报价书'")
   private Boolean boolBidProposals;
   @ApiModelProperty(name = "boolBidDocument", value = "是否有招标文件", notes = "是否有招标文件")
   @JsonProperty("boolBidDocument")
   @JSONField(name = "boolBidDocument")
   @TableField("bool_bid_document")
   @Column(name = "bool_bid_document", columnDefinition = "tinyint(1) comment '是否有招标文件'")
   private Boolean boolBidDocument;
   @ApiModelProperty(name = "contractualNature", value = "承包性质", notes = "承包性质")
   @JsonProperty("contractualNature")
   @JSONField(name = "contractualNature")
   @TableField("contractual_nature")
   @Column(name = "contractual_nature", columnDefinition = "bigint(20) comment '承包性质'")
   private Long contractualNature;
   @ApiModelProperty(name = "biddingMethod", value = "招标方式", notes = "招标方式")
   @JsonProperty("biddingMethod")
   @JSONField(name = "biddingMethod")
   @TableField("bidding_method")
   @Column(name = "bidding_method", columnDefinition = "bigint(20) comment '招标方式'")
   private Long biddingMethod;
   @ApiModelProperty(name = "partyType", value = "甲方类别", notes = "甲方类别")
   @JsonProperty("partyType")
   @JSONField(name = "partyType")
   @TableField("party_type")
   @Column(name = "party_type", columnDefinition = "bigint(20) comment '甲方类别'")
   private Long partyType;
   @ApiModelProperty(name = "boolFabricatedStructure", value = "是否装配式建筑", notes = "是否装配式建筑")
   @JsonProperty("boolFabricatedStructure")
   @JSONField(name = "boolFabricatedStructure")
   @TableField("bool_fabricated_structure")
   @Column(name = "bool_fabricated_structure", columnDefinition = "tinyint(1) comment '是否装配式建筑'")
   private Boolean boolFabricatedStructure;
   @ApiModelProperty(name = "boolModelContract", value = "是否示范合同", notes = "是否示范合同")
   @JsonProperty("boolModelContract")
   @JSONField(name = "boolModelContract")
   @TableField("bool_model_contract")
   @Column(name = "bool_model_contract", columnDefinition = "tinyint(1) comment '是否示范合同'")
   private Boolean boolModelContract;
   @ApiModelProperty(name = "locationId", value = "区域Id", notes = "区域Id")
   @JsonProperty("locationId")
   @JSONField(name = "locationId")
   @TableField("location_id")
   @Column(name = "location_id", columnDefinition = "bigint comment '区域Id'")
   private Long locationId;
   @ApiModelProperty(name = "countryId", value = "国家ID", notes = "国家ID")
   @JsonProperty("countryId")
   @JSONField(name = "countryId")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint comment '国家ID'")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省份ID", notes = "省份ID")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint comment '省份ID'")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "城市ID", notes = "城市ID")
   @JsonProperty("cityId")
   @JSONField(name = "cityId")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint comment '城市ID'")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "区ID", notes = "区ID")
   @JsonProperty("regionId")
   @JSONField(name = "regionId")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint comment '区ID'")
   private Long regionId;
   @ApiModelProperty(name = "address", value = "工程所在地", notes = "工程所在地")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField("address")
   @Column(name = "address", columnDefinition = "varchar(1000) comment '工程所在地'")
   private String address;
   @ApiModelProperty(name = "structureType", value = "结构类型", notes = "结构类型")
   @JsonProperty("structureType")
   @JSONField(name = "structureType")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "bigint(20) comment '结构类型'")
   private Long structureType;
   @ApiModelProperty(name = "structureArea", value = "建筑面积（平方米）", notes = "建筑面积（平方米）")
   @JsonProperty("structureArea")
   @JSONField(name = "structureArea")
   @TableField("structure_area")
   @Column(name = "structure_area", columnDefinition = "decimal(32,8) comment '建筑面积（平方米）'")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "mainStructureSteelMete", value = "主结构用钢量(吨)", notes = "主结构用钢量(吨)")
   @JsonProperty("mainStructureSteelMete")
   @JSONField(name = "mainStructureSteelMete")
   @TableField("main_structure_steel_mete")
   @Column(name = "main_structure_steel_mete", columnDefinition = "decimal(32,8) comment '主结构用钢量(吨)'")
   private BigDecimal mainStructureSteelMete;
   @ApiModelProperty(name = "subfabricSteelMete", value = "次结构用钢量(吨)", notes = "次结构用钢量(吨)")
   @JsonProperty("subfabricSteelMete")
   @JSONField(name = "subfabricSteelMete")
   @TableField("subfabric_steel_mete")
   @Column(name = "subfabric_steel_mete", columnDefinition = "decimal(32,8) comment '次结构用钢量(吨)'")
   private BigDecimal subfabricSteelMete;
   @ApiModelProperty(name = "maximumSpan", value = "最大跨度/高度", notes = "最大跨度/高度")
   @JsonProperty("maximumSpan")
   @JSONField(name = "maximumSpan")
   @TableField("maximum_span")
   @Column(name = "maximum_span", columnDefinition = "decimal(32,8) comment '最大跨度/高度'")
   private BigDecimal maximumSpan;
   @ApiModelProperty(name = "contractStartDate", value = "开工时间", notes = "开工时间")
   @JsonProperty("contractStartDate")
   @JSONField(name = "contractStartDate")
   @TableField("contract_start_date")
   @Column(name = "contract_start_date", columnDefinition = "datetime comment '开工时间'")
   private LocalDateTime contractStartDate;
   @ApiModelProperty(name = "contractEndDate", value = "竣工时间", notes = "竣工时间")
   @JsonProperty("contractEndDate")
   @JSONField(name = "contractEndDate")
   @TableField("contract_end_date")
   @Column(name = "contract_end_date", columnDefinition = "datetime comment '竣工时间'")
   private LocalDateTime contractEndDate;
   @ApiModelProperty(name = "allDays", value = "总工期（天）", notes = "总工期（天）")
   @JsonProperty("allDays")
   @JSONField(name = "allDays")
   @TableField("all_days")
   @Column(name = "all_days", columnDefinition = "int(11) comment '总工期（天）'")
   private Integer allDays;
   @ApiModelProperty(name = "prepaymentRatio", value = "预付款比例", notes = "预付款比例")
   @JsonProperty("prepaymentRatio")
   @JSONField(name = "prepaymentRatio")
   @TableField("prepayment_ratio")
   @Column(name = "prepayment_ratio", columnDefinition = "varchar(255) comment '预付款比例'")
   private String prepaymentRatio;
   @ApiModelProperty(name = "warrantyRatio", value = "质保金比例", notes = "质保金比例")
   @JsonProperty("warrantyRatio")
   @JSONField(name = "warrantyRatio")
   @TableField("warranty_ratio")
   @Column(name = "warranty_ratio", columnDefinition = "varchar(255) comment '质保金比例'")
   private String warrantyRatio;
   @ApiModelProperty(name = "boolPeasantWorkerWageAccount", value = "是否有农民工工资专户", notes = "是否有农民工工资专户")
   @JsonProperty("boolPeasantWorkerWageAccount")
   @JSONField(name = "boolPeasantWorkerWageAccount")
   @TableField("bool_peasant_worker_wage_account")
   @Column(name = "bool_peasant_worker_wage_account", columnDefinition = "tinyint(1) comment '是否有农民工工资专户'")
   private Boolean boolPeasantWorkerWageAccount;
   @ApiModelProperty(name = "peasantWorkerWageRatio", value = "农民工工资比例", notes = "农民工工资比例")
   @JsonProperty("peasantWorkerWageRatio")
   @JSONField(name = "peasantWorkerWageRatio")
   @TableField("peasant_worker_wage_ratio")
   @Column(name = "peasant_worker_wage_ratio", columnDefinition = "varchar(255) comment '农民工工资比例'")
   private String peasantWorkerWageRatio;
   @ApiModelProperty(name = "progressPayment", value = "进度款", notes = "进度款")
   @JsonProperty("progressPayment")
   @JSONField(name = "progressPayment")
   @TableField("progress_payment")
   @Column(name = "progress_payment", columnDefinition = "varchar(255) comment '进度款'")
   private String progressPayment;
   @ApiModelProperty(name = "materialInspection", value = "材料调差", notes = "材料调差")
   @JsonProperty("materialInspection")
   @JSONField(name = "materialInspection")
   @TableField("material_inspection")
   @Column(name = "material_inspection", columnDefinition = "varchar(255) comment '材料调差'")
   private String materialInspection;
   @ApiModelProperty(name = "attachments", value = "合同附件ID集", notes = "合同附件ID集")
   @JsonProperty("attachments")
   @JSONField(name = "attachments")
   @TableField(value = "attachments", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments", columnDefinition = "varchar(255) comment '合同附件ID集'")
   private String attachments;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 [1未审核, 2审核通过, 4退回]", notes = "审核状态 [1未审核, 2审核通过, 4退回]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态 [1未审核, 2审核通过, 4退回]'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "reviewPassTime", value = "审批通过时间", notes = "审批通过时间")
   @JsonProperty("reviewPassTime")
   @JSONField(name = "reviewPassTime")
   @TableField("review_pass_time")
   @Column(name = "review_pass_time", columnDefinition = "datetime comment '审批通过时间'")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "initDataId", value = "初始数据ID", notes = "初始数据ID")
   @JsonProperty("initDataId")
   @JSONField(name = "initDataId")
   @TableField("init_data_id")
   @Column(name = "init_data_id", columnDefinition = "bigint comment '初始数据ID'")
   private Long initDataId;
   @ApiModelProperty(name = "boolSupplement", value = "是否增补合同", notes = "是否增补合同")
   @JsonProperty("boolSupplement")
   @JSONField(name = "boolSupplement")
   @TableField("bool_supplement")
   @Column(name = "bool_supplement", columnDefinition = "tinyint(1) DEFAULT 0 comment '是否增补合同'")
   private Boolean boolSupplement;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
   private String remark;

   public static ContractRegistration.ContractRegistrationBuilder builder() {
      return new ContractRegistration.ContractRegistrationBuilder();
   }

   public ContractRegistration() {
   }

   public ContractRegistration(
      final Long id,
      final String registrationNo,
      final String contractNumber,
      final Integer registrationType,
      final String title,
      final Long preRegistrationId,
      final Long contractCatalogueId,
      final Long applicantId,
      final String applicantName,
      final Long applicantDeptId,
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
      final Long locationId,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final String address,
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
      final Integer reviewStatus,
      final Long approveRecordId,
      final LocalDateTime reviewPassTime,
      final Long initDataId,
      final Boolean boolSupplement,
      final String remark
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
      this.applicantDeptId = applicantDeptId;
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
      this.address = address;
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
      this.reviewStatus = reviewStatus;
      this.approveRecordId = approveRecordId;
      this.reviewPassTime = reviewPassTime;
      this.initDataId = initDataId;
      this.boolSupplement = boolSupplement;
      this.remark = remark;
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

   public Long getApplicantDeptId() {
      return this.applicantDeptId;
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

   public String getAddress() {
      return this.address;
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

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Long getInitDataId() {
      return this.initDataId;
   }

   public Boolean getBoolSupplement() {
      return this.boolSupplement;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public ContractRegistration setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("registrationNo")
   public ContractRegistration setRegistrationNo(final String registrationNo) {
      this.registrationNo = registrationNo;
      return this;
   }

   @JsonProperty("contractNumber")
   public ContractRegistration setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
   }

   @JsonProperty("registrationType")
   public ContractRegistration setRegistrationType(final Integer registrationType) {
      this.registrationType = registrationType;
      return this;
   }

   @JsonProperty("title")
   public ContractRegistration setTitle(final String title) {
      this.title = title;
      return this;
   }

   @JsonProperty("preRegistrationId")
   public ContractRegistration setPreRegistrationId(final Long preRegistrationId) {
      this.preRegistrationId = preRegistrationId;
      return this;
   }

   @JsonProperty("contractCatalogueId")
   public ContractRegistration setContractCatalogueId(final Long contractCatalogueId) {
      this.contractCatalogueId = contractCatalogueId;
      return this;
   }

   @JsonProperty("applicantId")
   public ContractRegistration setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public ContractRegistration setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("applicantDeptId")
   public ContractRegistration setApplicantDeptId(final Long applicantDeptId) {
      this.applicantDeptId = applicantDeptId;
      return this;
   }

   @JsonProperty("applicationNumber")
   public ContractRegistration setApplicationNumber(final String applicationNumber) {
      this.applicationNumber = applicationNumber;
      return this;
   }

   @JsonProperty("applicationDate")
   public ContractRegistration setApplicationDate(final LocalDateTime applicationDate) {
      this.applicationDate = applicationDate;
      return this;
   }

   @JsonProperty("projectName")
   public ContractRegistration setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("signerId")
   public ContractRegistration setSignerId(final Long signerId) {
      this.signerId = signerId;
      return this;
   }

   @JsonProperty("signerName")
   public ContractRegistration setSignerName(final String signerName) {
      this.signerName = signerName;
      return this;
   }

   @JsonProperty("firstLevelDept")
   public ContractRegistration setFirstLevelDept(final Long firstLevelDept) {
      this.firstLevelDept = firstLevelDept;
      return this;
   }

   @JsonProperty("secondLevelDept")
   public ContractRegistration setSecondLevelDept(final Long secondLevelDept) {
      this.secondLevelDept = secondLevelDept;
      return this;
   }

   @JsonProperty("contractAmount")
   public ContractRegistration setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   @JsonProperty("taxRate")
   public ContractRegistration setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("contractType")
   public ContractRegistration setContractType(final Long contractType) {
      this.contractType = contractType;
      return this;
   }

   @JsonProperty("infoSource")
   public ContractRegistration setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
      return this;
   }

   @JsonProperty("projectManager")
   public ContractRegistration setProjectManager(final String projectManager) {
      this.projectManager = projectManager;
      return this;
   }

   @JsonProperty("boolCoordinate")
   public ContractRegistration setBoolCoordinate(final Boolean boolCoordinate) {
      this.boolCoordinate = boolCoordinate;
      return this;
   }

   @JsonProperty("partyA")
   public ContractRegistration setPartyA(final String partyA) {
      this.partyA = partyA;
      return this;
   }

   @JsonProperty("partyB")
   public ContractRegistration setPartyB(final String partyB) {
      this.partyB = partyB;
      return this;
   }

   @JsonProperty("partyC")
   public ContractRegistration setPartyC(final String partyC) {
      this.partyC = partyC;
      return this;
   }

   @JsonProperty("partyD")
   public ContractRegistration setPartyD(final String partyD) {
      this.partyD = partyD;
      return this;
   }

   @JsonProperty("boolBidWinningNotice")
   public ContractRegistration setBoolBidWinningNotice(final Boolean boolBidWinningNotice) {
      this.boolBidWinningNotice = boolBidWinningNotice;
      return this;
   }

   @JsonProperty("drawing")
   public ContractRegistration setDrawing(final Integer drawing) {
      this.drawing = drawing;
      return this;
   }

   @JsonProperty("boolBidProposals")
   public ContractRegistration setBoolBidProposals(final Boolean boolBidProposals) {
      this.boolBidProposals = boolBidProposals;
      return this;
   }

   @JsonProperty("boolBidDocument")
   public ContractRegistration setBoolBidDocument(final Boolean boolBidDocument) {
      this.boolBidDocument = boolBidDocument;
      return this;
   }

   @JsonProperty("contractualNature")
   public ContractRegistration setContractualNature(final Long contractualNature) {
      this.contractualNature = contractualNature;
      return this;
   }

   @JsonProperty("biddingMethod")
   public ContractRegistration setBiddingMethod(final Long biddingMethod) {
      this.biddingMethod = biddingMethod;
      return this;
   }

   @JsonProperty("partyType")
   public ContractRegistration setPartyType(final Long partyType) {
      this.partyType = partyType;
      return this;
   }

   @JsonProperty("boolFabricatedStructure")
   public ContractRegistration setBoolFabricatedStructure(final Boolean boolFabricatedStructure) {
      this.boolFabricatedStructure = boolFabricatedStructure;
      return this;
   }

   @JsonProperty("boolModelContract")
   public ContractRegistration setBoolModelContract(final Boolean boolModelContract) {
      this.boolModelContract = boolModelContract;
      return this;
   }

   @JsonProperty("locationId")
   public ContractRegistration setLocationId(final Long locationId) {
      this.locationId = locationId;
      return this;
   }

   @JsonProperty("countryId")
   public ContractRegistration setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("provinceId")
   public ContractRegistration setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("cityId")
   public ContractRegistration setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("regionId")
   public ContractRegistration setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("address")
   public ContractRegistration setAddress(final String address) {
      this.address = address;
      return this;
   }

   @JsonProperty("structureType")
   public ContractRegistration setStructureType(final Long structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("structureArea")
   public ContractRegistration setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
      return this;
   }

   @JsonProperty("mainStructureSteelMete")
   public ContractRegistration setMainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
      this.mainStructureSteelMete = mainStructureSteelMete;
      return this;
   }

   @JsonProperty("subfabricSteelMete")
   public ContractRegistration setSubfabricSteelMete(final BigDecimal subfabricSteelMete) {
      this.subfabricSteelMete = subfabricSteelMete;
      return this;
   }

   @JsonProperty("maximumSpan")
   public ContractRegistration setMaximumSpan(final BigDecimal maximumSpan) {
      this.maximumSpan = maximumSpan;
      return this;
   }

   @JsonProperty("contractStartDate")
   public ContractRegistration setContractStartDate(final LocalDateTime contractStartDate) {
      this.contractStartDate = contractStartDate;
      return this;
   }

   @JsonProperty("contractEndDate")
   public ContractRegistration setContractEndDate(final LocalDateTime contractEndDate) {
      this.contractEndDate = contractEndDate;
      return this;
   }

   @JsonProperty("allDays")
   public ContractRegistration setAllDays(final Integer allDays) {
      this.allDays = allDays;
      return this;
   }

   @JsonProperty("prepaymentRatio")
   public ContractRegistration setPrepaymentRatio(final String prepaymentRatio) {
      this.prepaymentRatio = prepaymentRatio;
      return this;
   }

   @JsonProperty("warrantyRatio")
   public ContractRegistration setWarrantyRatio(final String warrantyRatio) {
      this.warrantyRatio = warrantyRatio;
      return this;
   }

   @JsonProperty("boolPeasantWorkerWageAccount")
   public ContractRegistration setBoolPeasantWorkerWageAccount(final Boolean boolPeasantWorkerWageAccount) {
      this.boolPeasantWorkerWageAccount = boolPeasantWorkerWageAccount;
      return this;
   }

   @JsonProperty("peasantWorkerWageRatio")
   public ContractRegistration setPeasantWorkerWageRatio(final String peasantWorkerWageRatio) {
      this.peasantWorkerWageRatio = peasantWorkerWageRatio;
      return this;
   }

   @JsonProperty("progressPayment")
   public ContractRegistration setProgressPayment(final String progressPayment) {
      this.progressPayment = progressPayment;
      return this;
   }

   @JsonProperty("materialInspection")
   public ContractRegistration setMaterialInspection(final String materialInspection) {
      this.materialInspection = materialInspection;
      return this;
   }

   @JsonProperty("attachments")
   public ContractRegistration setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @JsonProperty("reviewStatus")
   public ContractRegistration setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("approveRecordId")
   public ContractRegistration setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("reviewPassTime")
   public ContractRegistration setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
      return this;
   }

   @JsonProperty("initDataId")
   public ContractRegistration setInitDataId(final Long initDataId) {
      this.initDataId = initDataId;
      return this;
   }

   @JsonProperty("boolSupplement")
   public ContractRegistration setBoolSupplement(final Boolean boolSupplement) {
      this.boolSupplement = boolSupplement;
      return this;
   }

   @JsonProperty("remark")
   public ContractRegistration setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractRegistration(id="
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
         + ", applicantDeptId="
         + this.getApplicantDeptId()
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
         + ", address="
         + this.getAddress()
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
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", initDataId="
         + this.getInitDataId()
         + ", boolSupplement="
         + this.getBoolSupplement()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractRegistration)) {
         return false;
      }

      ContractRegistration other = (ContractRegistration)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                                                                                                Object this$approveRecordId = this.getApproveRecordId();
                                                                                                Object other$approveRecordId = other.getApproveRecordId();
                                                                                                if (this$approveRecordId == null
                                                                                                   ? other$approveRecordId == null
                                                                                                   : this$approveRecordId.equals(other$approveRecordId)) {
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
                                                                                                               : this$contractNumber.equals(
                                                                                                                  other$contractNumber
                                                                                                               )) {
                                                                                                               Object this$title = this.getTitle();
                                                                                                               Object other$title = other.getTitle();
                                                                                                               if (this$title == null
                                                                                                                  ? other$title == null
                                                                                                                  : this$title.equals(other$title)) {
                                                                                                                  Object this$applicantName = this.getApplicantName();
                                                                                                                  Object other$applicantName = other.getApplicantName();
                                                                                                                  if (this$applicantName == null
                                                                                                                     ? other$applicantName == null
                                                                                                                     : this$applicantName.equals(
                                                                                                                        other$applicantName
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
                                                                                                                                                      Object this$address = this.getAddress();
                                                                                                                                                      Object other$address = other.getAddress();
                                                                                                                                                      if (this$address
                                                                                                                                                            == null
                                                                                                                                                         ? other$address
                                                                                                                                                            == null
                                                                                                                                                         : this$address.equals(
                                                                                                                                                            other$address
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
      return other instanceof ContractRegistration;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
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
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
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
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractRegistrationBuilder {
      private Long id;
      private String registrationNo;
      private String contractNumber;
      private Integer registrationType;
      private String title;
      private Long preRegistrationId;
      private Long contractCatalogueId;
      private Long applicantId;
      private String applicantName;
      private Long applicantDeptId;
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
      private Long locationId;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private String address;
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
      private Integer reviewStatus;
      private Long approveRecordId;
      private LocalDateTime reviewPassTime;
      private Long initDataId;
      private Boolean boolSupplement;
      private String remark;

      ContractRegistrationBuilder() {
      }

      @JsonProperty("id")
      public ContractRegistration.ContractRegistrationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("registrationNo")
      public ContractRegistration.ContractRegistrationBuilder registrationNo(final String registrationNo) {
         this.registrationNo = registrationNo;
         return this;
      }

      @JsonProperty("contractNumber")
      public ContractRegistration.ContractRegistrationBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      @JsonProperty("registrationType")
      public ContractRegistration.ContractRegistrationBuilder registrationType(final Integer registrationType) {
         this.registrationType = registrationType;
         return this;
      }

      @JsonProperty("title")
      public ContractRegistration.ContractRegistrationBuilder title(final String title) {
         this.title = title;
         return this;
      }

      @JsonProperty("preRegistrationId")
      public ContractRegistration.ContractRegistrationBuilder preRegistrationId(final Long preRegistrationId) {
         this.preRegistrationId = preRegistrationId;
         return this;
      }

      @JsonProperty("contractCatalogueId")
      public ContractRegistration.ContractRegistrationBuilder contractCatalogueId(final Long contractCatalogueId) {
         this.contractCatalogueId = contractCatalogueId;
         return this;
      }

      @JsonProperty("applicantId")
      public ContractRegistration.ContractRegistrationBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public ContractRegistration.ContractRegistrationBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("applicantDeptId")
      public ContractRegistration.ContractRegistrationBuilder applicantDeptId(final Long applicantDeptId) {
         this.applicantDeptId = applicantDeptId;
         return this;
      }

      @JsonProperty("applicationNumber")
      public ContractRegistration.ContractRegistrationBuilder applicationNumber(final String applicationNumber) {
         this.applicationNumber = applicationNumber;
         return this;
      }

      @JsonProperty("applicationDate")
      public ContractRegistration.ContractRegistrationBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      @JsonProperty("projectName")
      public ContractRegistration.ContractRegistrationBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("signerId")
      public ContractRegistration.ContractRegistrationBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      @JsonProperty("signerName")
      public ContractRegistration.ContractRegistrationBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      @JsonProperty("firstLevelDept")
      public ContractRegistration.ContractRegistrationBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      @JsonProperty("secondLevelDept")
      public ContractRegistration.ContractRegistrationBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      @JsonProperty("contractAmount")
      public ContractRegistration.ContractRegistrationBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("taxRate")
      public ContractRegistration.ContractRegistrationBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("contractType")
      public ContractRegistration.ContractRegistrationBuilder contractType(final Long contractType) {
         this.contractType = contractType;
         return this;
      }

      @JsonProperty("infoSource")
      public ContractRegistration.ContractRegistrationBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      @JsonProperty("projectManager")
      public ContractRegistration.ContractRegistrationBuilder projectManager(final String projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      @JsonProperty("boolCoordinate")
      public ContractRegistration.ContractRegistrationBuilder boolCoordinate(final Boolean boolCoordinate) {
         this.boolCoordinate = boolCoordinate;
         return this;
      }

      @JsonProperty("partyA")
      public ContractRegistration.ContractRegistrationBuilder partyA(final String partyA) {
         this.partyA = partyA;
         return this;
      }

      @JsonProperty("partyB")
      public ContractRegistration.ContractRegistrationBuilder partyB(final String partyB) {
         this.partyB = partyB;
         return this;
      }

      @JsonProperty("partyC")
      public ContractRegistration.ContractRegistrationBuilder partyC(final String partyC) {
         this.partyC = partyC;
         return this;
      }

      @JsonProperty("partyD")
      public ContractRegistration.ContractRegistrationBuilder partyD(final String partyD) {
         this.partyD = partyD;
         return this;
      }

      @JsonProperty("boolBidWinningNotice")
      public ContractRegistration.ContractRegistrationBuilder boolBidWinningNotice(final Boolean boolBidWinningNotice) {
         this.boolBidWinningNotice = boolBidWinningNotice;
         return this;
      }

      @JsonProperty("drawing")
      public ContractRegistration.ContractRegistrationBuilder drawing(final Integer drawing) {
         this.drawing = drawing;
         return this;
      }

      @JsonProperty("boolBidProposals")
      public ContractRegistration.ContractRegistrationBuilder boolBidProposals(final Boolean boolBidProposals) {
         this.boolBidProposals = boolBidProposals;
         return this;
      }

      @JsonProperty("boolBidDocument")
      public ContractRegistration.ContractRegistrationBuilder boolBidDocument(final Boolean boolBidDocument) {
         this.boolBidDocument = boolBidDocument;
         return this;
      }

      @JsonProperty("contractualNature")
      public ContractRegistration.ContractRegistrationBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      @JsonProperty("biddingMethod")
      public ContractRegistration.ContractRegistrationBuilder biddingMethod(final Long biddingMethod) {
         this.biddingMethod = biddingMethod;
         return this;
      }

      @JsonProperty("partyType")
      public ContractRegistration.ContractRegistrationBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      @JsonProperty("boolFabricatedStructure")
      public ContractRegistration.ContractRegistrationBuilder boolFabricatedStructure(final Boolean boolFabricatedStructure) {
         this.boolFabricatedStructure = boolFabricatedStructure;
         return this;
      }

      @JsonProperty("boolModelContract")
      public ContractRegistration.ContractRegistrationBuilder boolModelContract(final Boolean boolModelContract) {
         this.boolModelContract = boolModelContract;
         return this;
      }

      @JsonProperty("locationId")
      public ContractRegistration.ContractRegistrationBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      @JsonProperty("countryId")
      public ContractRegistration.ContractRegistrationBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("provinceId")
      public ContractRegistration.ContractRegistrationBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("cityId")
      public ContractRegistration.ContractRegistrationBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("regionId")
      public ContractRegistration.ContractRegistrationBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("address")
      public ContractRegistration.ContractRegistrationBuilder address(final String address) {
         this.address = address;
         return this;
      }

      @JsonProperty("structureType")
      public ContractRegistration.ContractRegistrationBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("structureArea")
      public ContractRegistration.ContractRegistrationBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      @JsonProperty("mainStructureSteelMete")
      public ContractRegistration.ContractRegistrationBuilder mainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
         this.mainStructureSteelMete = mainStructureSteelMete;
         return this;
      }

      @JsonProperty("subfabricSteelMete")
      public ContractRegistration.ContractRegistrationBuilder subfabricSteelMete(final BigDecimal subfabricSteelMete) {
         this.subfabricSteelMete = subfabricSteelMete;
         return this;
      }

      @JsonProperty("maximumSpan")
      public ContractRegistration.ContractRegistrationBuilder maximumSpan(final BigDecimal maximumSpan) {
         this.maximumSpan = maximumSpan;
         return this;
      }

      @JsonProperty("contractStartDate")
      public ContractRegistration.ContractRegistrationBuilder contractStartDate(final LocalDateTime contractStartDate) {
         this.contractStartDate = contractStartDate;
         return this;
      }

      @JsonProperty("contractEndDate")
      public ContractRegistration.ContractRegistrationBuilder contractEndDate(final LocalDateTime contractEndDate) {
         this.contractEndDate = contractEndDate;
         return this;
      }

      @JsonProperty("allDays")
      public ContractRegistration.ContractRegistrationBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      @JsonProperty("prepaymentRatio")
      public ContractRegistration.ContractRegistrationBuilder prepaymentRatio(final String prepaymentRatio) {
         this.prepaymentRatio = prepaymentRatio;
         return this;
      }

      @JsonProperty("warrantyRatio")
      public ContractRegistration.ContractRegistrationBuilder warrantyRatio(final String warrantyRatio) {
         this.warrantyRatio = warrantyRatio;
         return this;
      }

      @JsonProperty("boolPeasantWorkerWageAccount")
      public ContractRegistration.ContractRegistrationBuilder boolPeasantWorkerWageAccount(final Boolean boolPeasantWorkerWageAccount) {
         this.boolPeasantWorkerWageAccount = boolPeasantWorkerWageAccount;
         return this;
      }

      @JsonProperty("peasantWorkerWageRatio")
      public ContractRegistration.ContractRegistrationBuilder peasantWorkerWageRatio(final String peasantWorkerWageRatio) {
         this.peasantWorkerWageRatio = peasantWorkerWageRatio;
         return this;
      }

      @JsonProperty("progressPayment")
      public ContractRegistration.ContractRegistrationBuilder progressPayment(final String progressPayment) {
         this.progressPayment = progressPayment;
         return this;
      }

      @JsonProperty("materialInspection")
      public ContractRegistration.ContractRegistrationBuilder materialInspection(final String materialInspection) {
         this.materialInspection = materialInspection;
         return this;
      }

      @JsonProperty("attachments")
      public ContractRegistration.ContractRegistrationBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      @JsonProperty("reviewStatus")
      public ContractRegistration.ContractRegistrationBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("approveRecordId")
      public ContractRegistration.ContractRegistrationBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("reviewPassTime")
      public ContractRegistration.ContractRegistrationBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      @JsonProperty("initDataId")
      public ContractRegistration.ContractRegistrationBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      @JsonProperty("boolSupplement")
      public ContractRegistration.ContractRegistrationBuilder boolSupplement(final Boolean boolSupplement) {
         this.boolSupplement = boolSupplement;
         return this;
      }

      @JsonProperty("remark")
      public ContractRegistration.ContractRegistrationBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractRegistration build() {
         return new ContractRegistration(
            this.id,
            this.registrationNo,
            this.contractNumber,
            this.registrationType,
            this.title,
            this.preRegistrationId,
            this.contractCatalogueId,
            this.applicantId,
            this.applicantName,
            this.applicantDeptId,
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
            this.address,
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
            this.reviewStatus,
            this.approveRecordId,
            this.reviewPassTime,
            this.initDataId,
            this.boolSupplement,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractRegistration.ContractRegistrationBuilder(id="
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
            + ", applicantDeptId="
            + this.applicantDeptId
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
            + ", address="
            + this.address
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
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", initDataId="
            + this.initDataId
            + ", boolSupplement="
            + this.boolSupplement
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
